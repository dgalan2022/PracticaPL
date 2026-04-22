import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TraductorC {

    private final String rutaSalida;
    private final StringBuilder defines    = new StringBuilder();
    private final StringBuilder prototypes = new StringBuilder();
    private final StringBuilder functions  = new StringBuilder();
    private final StringBuilder mainBody   = new StringBuilder();
    private StringBuilder actual;
    private int     indent      = 0;
    private boolean mainStarted = false;

    public TraductorC(String rutaEntrada) {
        Path p        = Paths.get(rutaEntrada);
        String nombre = p.getFileName().toString();
        int dot       = nombre.lastIndexOf('.');
        String base   = dot >= 0 ? nombre.substring(0, dot) : nombre;
        Path parent   = p.getParent();
        this.rutaSalida = (parent == null
                ? Paths.get(base + ".c")
                : parent.resolve(base + ".c")).toString();
        this.actual = mainBody;
    }

    public String  getRutaSalida() { return rutaSalida; }
    public boolean mainStarted()   { return mainStarted; }
    public void indent()  { indent++; }
    public void dedent()  { if (indent > 0) indent--; }

    public void addDefine(String ident, String valor) {
        defines.append("#define ").append(ident).append(" ").append(valor).append("\n");
    }

    public void addPrototype(String linea) { prototypes.append(linea).append("\n"); }

    public void startMain() {
        if (mainStarted) return;
        mainStarted = true;
        actual = mainBody;
        mainBody.append("void main(void)\n{\n");
        indent = 1;
    }

    public void endMain()  { indent = 0; mainBody.append("}\n"); }

    public void startSubprog(String cabecera) {
        actual = functions;
        functions.append(cabecera).append("\n{\n");
        indent = 1;
    }

    public void endSubprog() {
        indent = 0;
        functions.append("}\n\n");
        actual = mainBody;
    }

    public void line(String texto) {
        actual.append("    ".repeat(Math.max(0, indent))).append(texto).append("\n");
    }

    // ── Tipos ─────────────────────────────────────────────────────
    public String mapTipo(Grupo11Parser.TipoContext ctx) {
        String t = ctx.getStart().getText();
        if (t.equals("INTEGER"))   return "int";
        if (t.equals("REAL"))      return "float";
        if (t.equals("CHARACTER")) return "char";
        return "void";
    }

    public String charLen(Grupo11Parser.TipoContext ctx) {
        Grupo11Parser.CharlengthContext cl = ctx.charlength();
        if (cl == null || cl.NUM_INT_CONST() == null) return "";
        return cl.NUM_INT_CONST().getText();
    }

    // ── Literales ─────────────────────────────────────────────────
    public String normalizarLiteral(String s) {
        if (s == null || s.isEmpty()) return "\"\"";
        s = s.trim();
        if (s.startsWith("'")) {
            String c = s.substring(1, s.length()-1).replace("''","'").replace("\"","\\\"");
            return "\"" + c + "\"";
        }
        if (s.startsWith("\"")) {
            String c = s.substring(1, s.length()-1).replace("\"\"","\"").replace("\"","\\\"");
            return "\"" + c + "\"";
        }
        return s;
    }

    public String simpvalueTexto(Grupo11Parser.SimpvalueContext ctx) {
        if (ctx == null) return "";
        String raw = ctx.getText();
        if (ctx.NUM_INT_CONST_B() != null) return "0b" + raw.substring(2, raw.length()-1);
        if (ctx.NUM_INT_CONST_O() != null) return "0"  + raw.substring(2, raw.length()-1);
        if (ctx.NUM_INT_CONST_H() != null) return "0x" + raw.substring(2, raw.length()-1);
        if (raw.equals(".TRUE."))  return "1";
        if (raw.equals(".FALSE.")) return "0";
        if (ctx.STRING_CONST() != null) return normalizarLiteral(raw);
        return raw;
    }

    // ── Expresiones aritméticas ───────────────────────────────────
    public String expTexto(Grupo11Parser.ExpContext ctx) {
        if (ctx == null) return "";
        return buildExp(ctx, null);
    }

    public String expTextoDeref(Grupo11Parser.ExpContext ctx, List<String> paramsRef) {
        if (ctx == null) return "";
        return buildExp(ctx, paramsRef);
    }

    public String expTextoConRef(Grupo11Parser.ExpContext ctx, List<String> paramsRef) {
        if (ctx == null) return "";
        Grupo11Parser.FactorContext fc = ctx.factor();
        if (fc != null && fc.IDENT() != null && fc.exp() == null
                && (ctx.expRest() == null || ctx.expRest().op() == null)) {
            String id = fc.IDENT().getText();
            if (paramsRef != null && paramsRef.contains(id)) return "&" + id;
        }
        return buildExp(ctx, null);
    }

    private String buildExp(Grupo11Parser.ExpContext ctx, List<String> refs) {
        return buildFactor(ctx.factor(), refs) + buildExpRest(ctx.expRest(), refs);
    }

    private String buildExpRest(Grupo11Parser.ExpRestContext ctx, List<String> refs) {
        if (ctx == null || ctx.op() == null) return "";
        return " " + ctx.op().getText() + " "
                + buildFactor(ctx.factor(), refs)
                + buildExpRest(ctx.expRest(), refs);
    }

    private String buildFactor(Grupo11Parser.FactorContext ctx, List<String> refs) {
        if (ctx.simpvalue() != null) return simpvalueTexto(ctx.simpvalue());
        if (ctx.IDENT() != null && ctx.exp() != null && ctx.explist() != null) {
            StringBuilder sb = new StringBuilder(ctx.IDENT().getText()).append("(");
            sb.append(buildExp(ctx.exp(), refs));
            Grupo11Parser.ExplistContext el = ctx.explist();
            while (el != null && el.exp() != null) {
                sb.append(", ").append(buildExp(el.exp(), refs));
                el = el.explist();
            }
            return sb.append(")").toString();
        }
        if (ctx.IDENT() != null) {
            String id = ctx.IDENT().getText();
            if (refs != null && refs.contains(id)) return "(*" + id + ")";
            return id;
        }
        if (ctx.exp() != null) return "(" + buildExp(ctx.exp(), refs) + ")";
        return ctx.getText();
    }

    // ── Expresiones condicionales ─────────────────────────────────
    public String expcondTexto(Grupo11Parser.ExpcondContext ctx) {
        if (ctx == null) return "";
        return buildFactorcond(ctx.factorcond()) + buildExpcondRest(ctx.expcondRest());
    }

    private String buildExpcondRest(Grupo11Parser.ExpcondRestContext ctx) {
        if (ctx == null || ctx.oplog() == null) return "";
        return " " + mapOplog(ctx.oplog().getText()) + " "
                + buildFactorcond(ctx.factorcond())
                + buildExpcondRest(ctx.expcondRest());
    }

    private String buildFactorcond(Grupo11Parser.FactorcondContext ctx) {
        if (ctx == null) return "";
        String raw = ctx.getText();
        if (raw.startsWith(".NOT.")) return "!(" + buildFactorcond(ctx.factorcond()) + ")";
        if (raw.equals(".TRUE."))    return "1";
        if (raw.equals(".FALSE."))   return "0";
        if (ctx.expcond() != null)   return "(" + expcondTexto(ctx.expcond()) + ")";
        if (ctx.opcomp()  != null)
            return expTexto(ctx.exp(0)) + " " + mapOpcomp(ctx.opcomp().getText()) + " " + expTexto(ctx.exp(1));
        return raw;
    }

    private String mapOplog(String op) {
        switch (op) {
            case ".AND.":  return "&&";
            case ".OR.":   return "||";
            case ".EQV.":  return "==";
            case ".NEQV.": return "!=";
            default:       return op;
        }
    }

    private String mapOpcomp(String op) { return "/=".equals(op) ? "!=" : op; }

    // ── SELECT CASE etiquetas ─────────────────────────────────────
    public String etiquetaTexto(Grupo11Parser.EtiquetasContext ctx) {
        if (ctx == null) return "";
        if (ctx.simpvalue() != null && !ctx.simpvalue().isEmpty())
            return simpvalueTexto(ctx.simpvalue(0));
        return ctx.getText();
    }

    // ── Parámetros ────────────────────────────────────────────────
    public List<String> extraerNomparams(Grupo11Parser.NomparamlistContext ctx) {
        List<String> ids = new ArrayList<>();
        if (ctx == null) return ids;
        ids.add(ctx.IDENT().getText());
        Grupo11Parser.NomparamlistRestContext rest = ctx.nomparamlistRest();
        while (rest != null && rest.IDENT() != null) {
            ids.add(rest.IDENT().getText());
            rest = rest.nomparamlistRest();
        }
        return ids;
    }

    public List<String> tiposProc(Grupo11Parser.Dec_s_paramlistContext ctx) {
        List<String> list = new ArrayList<>();
        for (Grupo11Parser.Dec_s_paramlistContext a = ctx; a != null && a.tipo() != null; a = a.dec_s_paramlist())
            list.add(mapTipo(a.tipo()));
        return list;
    }

    public List<String> tipoparamsProc(Grupo11Parser.Dec_s_paramlistContext ctx) {
        List<String> list = new ArrayList<>();
        for (Grupo11Parser.Dec_s_paramlistContext a = ctx; a != null && a.tipoparam() != null; a = a.dec_s_paramlist())
            list.add(a.tipoparam().getText());
        return list;
    }

    public List<String> extraerIdentsProc(Grupo11Parser.Dec_s_paramlistContext ctx) {
        List<String> list = new ArrayList<>();
        for (Grupo11Parser.Dec_s_paramlistContext a = ctx; a != null && a.IDENT() != null; a = a.dec_s_paramlist())
            list.add(a.IDENT().getText());
        return list;
    }

    public List<String> tiposFun(Grupo11Parser.Dec_f_paramlistContext ctx) {
        List<String> list = new ArrayList<>();
        for (Grupo11Parser.Dec_f_paramlistContext a = ctx; a != null && a.tipo() != null; a = a.dec_f_paramlist())
            list.add(mapTipo(a.tipo()));
        return list;
    }

    public String buildParams(List<String> nombres, List<String> tipos) {
        if (nombres.isEmpty()) return "void";
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nombres.size() && i < tipos.size(); i++)
            res.add(tipos.get(i) + " " + nombres.get(i));
        return String.join(", ", res);
    }

    public String buildParamsConRef(List<String> nombres, List<String> tipos, List<String> tparam) {
        if (nombres.isEmpty()) return "void";
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nombres.size() && i < tipos.size(); i++) {
            boolean esRef = i < tparam.size()
                    && ("OUT".equals(tparam.get(i)) || "INOUT".equals(tparam.get(i)));
            res.add(tipos.get(i) + (esRef ? " *" : " ") + nombres.get(i));
        }
        return String.join(", ", res);
    }

    // ── Código final ──────────────────────────────────────────────
    public String getCodigo() {
        StringBuilder sb = new StringBuilder();
        if (defines.length()    > 0) sb.append(defines).append("\n");
        if (prototypes.length() > 0) sb.append(prototypes).append("\n");
        if (functions.length()  > 0) sb.append(functions);
        sb.append(mainBody);
        return sb.toString();
    }
}