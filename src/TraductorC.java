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
    private int indent = 0;
    private boolean mainStarted = false;

    public TraductorC(String rutaEntrada) {
        Path p = Paths.get(rutaEntrada);
        String nombre = p.getFileName().toString();
        int dot = nombre.lastIndexOf('.');
        String base = dot >= 0 ? nombre.substring(0, dot) : nombre;
        Path parent = p.getParent();
        this.rutaSalida = (parent == null
                ? Paths.get(base + ".c")
                : parent.resolve(base + ".c")).toString();
        this.actual = mainBody;
    }

    public String getRutaSalida() { return rutaSalida; }
    public boolean mainStarted()  { return mainStarted; }

    public void addDefine(String ident, String valor) {
        defines.append("#define ").append(ident).append(" ").append(valor).append("\n");
    }

    public void addPrototype(String linea) {
        prototypes.append(linea).append("\n");
    }

    public void startMain() {
        if (mainStarted) return;
        mainStarted = true;
        actual = mainBody;
        mainBody.append("void main(void)\n{\n");
        indent = 1;
    }

    public void endMain() {
        indent = 0;
        mainBody.append("}\n");
    }

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
        actual.append("    ".repeat(indent)).append(texto).append("\n");
    }

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

    public String normalizarLiteral(String s) {
        if (s == null || s.isEmpty()) return "\"\"";
        s = s.trim();
        if (s.startsWith("'")) {
            String c = s.substring(1, s.length() - 1).replace("''", "'");
            c = c.replace("\"", "\\\"");
            return "\"" + c + "\"";
        }
        if (s.startsWith("\"")) {
            String c = s.substring(1, s.length() - 1).replace("\"\"", "\"");
            c = c.replace("\"", "\\\"");
            return "\"" + c + "\"";
        }
        return s;
    }

    public String simpvalueTexto(Grupo11Parser.SimpvalueContext ctx) {
        if (ctx.STRING_CONST() != null) return normalizarLiteral(ctx.getText());
        return ctx.getText();
    }

    public String expTexto(Grupo11Parser.ExpContext ctx) {
        return buildExp(ctx);
    }

    private String buildExp(Grupo11Parser.ExpContext ctx) {
        return buildFactor(ctx.factor()) + buildExpRest(ctx.expRest());
    }

    private String buildExpRest(Grupo11Parser.ExpRestContext ctx) {
        if (ctx == null || ctx.op() == null) return "";
        return " " + ctx.op().getText() + " "
                + buildFactor(ctx.factor())
                + buildExpRest(ctx.expRest());
    }

    private String buildFactor(Grupo11Parser.FactorContext ctx) {
        if (ctx.simpvalue() != null) return simpvalueTexto(ctx.simpvalue());
        if (ctx.IDENT() != null && ctx.exp() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ctx.IDENT().getText()).append("(");
            sb.append(buildExp(ctx.exp()));
            Grupo11Parser.ExplistContext el = ctx.explist();
            while (el != null && el.exp() != null) {
                sb.append(", ").append(buildExp(el.exp()));
                el = el.explist();
            }
            sb.append(")");
            return sb.toString();
        }
        if (ctx.IDENT() != null) return ctx.IDENT().getText();
        if (ctx.exp()   != null) return "(" + buildExp(ctx.exp()) + ")";
        return ctx.getText();
    }

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
        List<String> tipos = new ArrayList<>();
        Grupo11Parser.Dec_s_paramlistContext a = ctx;
        while (a != null && a.tipo() != null) {
            tipos.add(mapTipo(a.tipo()));
            a = a.dec_s_paramlist();
        }
        return tipos;
    }

    public List<String> tiposFun(Grupo11Parser.Dec_f_paramlistContext ctx) {
        List<String> tipos = new ArrayList<>();
        Grupo11Parser.Dec_f_paramlistContext a = ctx;
        while (a != null && a.tipo() != null) {
            tipos.add(mapTipo(a.tipo()));
            a = a.dec_f_paramlist();
        }
        return tipos;
    }

    public String buildParams(List<String> nombres, List<String> tipos) {
        if (nombres.isEmpty()) return "void";
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nombres.size() && i < tipos.size(); i++) {
            res.add(tipos.get(i) + " " + nombres.get(i));
        }
        return String.join(", ", res);
    }

    public String getCodigo() {
        StringBuilder sb = new StringBuilder();
        if (defines.length()    > 0) sb.append(defines).append("\n");
        if (prototypes.length() > 0) sb.append(prototypes).append("\n");
        if (functions.length()  > 0) sb.append(functions);
        sb.append(mainBody);
        return sb.toString();
    }
}