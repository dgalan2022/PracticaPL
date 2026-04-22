import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraductorListener extends Grupo11BaseListener {

    private final TraductorC t;
    private String  funActual   = null;
    private boolean enMain      = false;
    private int     nivelSwitch = 0;
    private final List<String> paramsRef = new ArrayList<>();
    private final Map<String, List<Integer>> posRefsSubprogs = new HashMap<>();

    public TraductorListener(TraductorC tr) { this.t = tr; }

    @Override public void enterProg(Grupo11Parser.ProgContext ctx) { enMain = true; }
    @Override public void exitProg (Grupo11Parser.ProgContext ctx) { t.endMain(); }

    // ── Declaraciones ────────────────────────────────────────────
    @Override
    public void enterDcl(Grupo11Parser.DclContext ctx) {
        boolean esParam = false;
        for (int i = 0; i < ctx.getChildCount(); i++)
            if ("PARAMETER".equals(ctx.getChild(i).getText())) { esParam = true; break; }

        if (esParam) {
            t.addDefine(ctx.IDENT().getText(), t.simpvalueTexto(ctx.simpvalue()));
            Grupo11Parser.CtelistContext lista = ctx.ctelist();
            while (lista != null && lista.IDENT() != null) {
                t.addDefine(lista.IDENT().getText(), t.simpvalueTexto(lista.simpvalue()));
                lista = lista.ctelist();
            }
        } else {
            String tipo = t.mapTipo(ctx.tipo());
            String len  = t.charLen(ctx.tipo());
            StringBuilder sb = new StringBuilder(tipo).append(" ");
            Grupo11Parser.VarlistContext vl = ctx.varlist();
            sb.append(varConInit(vl.IDENT().getText(), tipo, len, vl.init()));
            Grupo11Parser.VarlistRestContext rest = vl.varlistRest();
            while (rest != null && rest.IDENT() != null) {
                sb.append(", ").append(varConInit(rest.IDENT().getText(), tipo, len, rest.init()));
                rest = rest.varlistRest();
            }
            sb.append(";");
            if (enMain && funActual == null && !t.mainStarted()) t.startMain();
            t.line(sb.toString());
        }
    }

    private String varConInit(String nombre, String tipo, String len, Grupo11Parser.InitContext init) {
        String dim  = (!len.isEmpty() && tipo.equals("char")) ? "[" + len + "]" : "";
        String base = nombre + dim;
        if (init != null && init.simpvalue() != null)
            return base + " = " + t.simpvalueTexto(init.simpvalue());
        return base;
    }

    // ── INTERFACE — prototipos ───────────────────────────────────
    @Override
    public void enterDecproc(Grupo11Parser.DecprocContext ctx) {
        String nombre        = ctx.IDENT(0).getText();
        List<String> tipos   = t.tiposProc(ctx.dec_s_paramlist());
        List<String> tparam  = t.tipoparamsProc(ctx.dec_s_paramlist());
        List<String> nombres = ctx.formal_paramlist().nomparamlist() != null
                ? t.extraerNomparams(ctx.formal_paramlist().nomparamlist()) : new ArrayList<>();
        t.addPrototype("void " + nombre + "(" + t.buildParamsConRef(nombres, tipos, tparam) + ");");
        registrarPosRefs(nombre, tparam);
    }

    @Override
    public void enterDecfun(Grupo11Parser.DecfunContext ctx) {
        String nombre       = ctx.IDENT(0).getText();
        String tipo         = t.mapTipo(ctx.tipo());
        List<String> tipos  = t.tiposFun(ctx.dec_f_paramlist());
        List<String> params = t.extraerNomparams(ctx.nomparamlist());
        t.addPrototype(tipo + " " + nombre + "(" + t.buildParams(params, tipos) + ");");
    }

    // ── Procedimientos ───────────────────────────────────────────
    @Override
    public void enterCodproc(Grupo11Parser.CodprocContext ctx) {
        enMain = false; funActual = null; paramsRef.clear();
        String nombre        = ctx.IDENT(0).getText();
        List<String> tipos   = t.tiposProc(ctx.dec_s_paramlist());
        List<String> tparam  = t.tipoparamsProc(ctx.dec_s_paramlist());
        List<String> nombres = ctx.formal_paramlist().nomparamlist() != null
                ? t.extraerNomparams(ctx.formal_paramlist().nomparamlist()) : new ArrayList<>();
        List<String> idents  = t.extraerIdentsProc(ctx.dec_s_paramlist());
        for (int i = 0; i < tparam.size(); i++)
            if ("OUT".equals(tparam.get(i)) || "INOUT".equals(tparam.get(i)))
                paramsRef.add(idents.get(i));
        registrarPosRefs(nombre, tparam);
        t.startSubprog("void " + nombre + "(" + t.buildParamsConRef(nombres, tipos, tparam) + ")");
    }

    @Override
    public void exitCodproc(Grupo11Parser.CodprocContext ctx) { t.endSubprog(); paramsRef.clear(); }

    // ── Funciones ────────────────────────────────────────────────
    @Override
    public void enterCodfun(Grupo11Parser.CodfunContext ctx) {
        enMain = false; funActual = ctx.IDENT(0).getText(); paramsRef.clear();
        String tipo         = t.mapTipo(ctx.tipo());
        List<String> tipos  = t.tiposFun(ctx.dec_f_paramlist());
        List<String> params = t.extraerNomparams(ctx.nomparamlist());
        t.startSubprog(tipo + " " + funActual + "(" + t.buildParams(params, tipos) + ")");
    }

    @Override
    public void exitCodfun(Grupo11Parser.CodfunContext ctx) {
        t.line("return " + t.expTexto(ctx.exp()) + ";");
        t.endSubprog(); funActual = null; paramsRef.clear();
    }

    // ── sentlist ─────────────────────────────────────────────────
    @Override
    public void enterSentlist(Grupo11Parser.SentlistContext ctx) {
        if (nivelSwitch > 0) return;
        if (enMain && funActual == null && !t.mainStarted()) t.startMain();
        if (ctx.getParent() instanceof Grupo11Parser.SentContext sent) {
            boolean tieneElse = false;
            for (int i = 0; i < sent.getChildCount(); i++)
                if ("ELSE".equals(sent.getChild(i).getText())) { tieneElse = true; break; }
            if (tieneElse && sent.sentlist().size() == 2 && sent.sentlist(1) == ctx) {
                t.dedent(); t.line("} else {"); t.indent();
            }
        }
    }

    @Override
    public void exitSentlist(Grupo11Parser.SentlistContext ctx) {
        if (nivelSwitch > 0) return;
        if (ctx.getParent() instanceof Grupo11Parser.SentContext sent) {
            boolean tieneElse = false;
            for (int i = 0; i < sent.getChildCount(); i++)
                if ("ELSE".equals(sent.getChild(i).getText())) { tieneElse = true; break; }
            if (tieneElse && sent.sentlist().size() == 2 && sent.sentlist(1) == ctx) {
                t.dedent(); t.line("}");
            }
        }
    }

    // ── Sentencias (walker) ──────────────────────────────────────
    @Override
    public void enterSent(Grupo11Parser.SentContext ctx) {
        if (nivelSwitch > 0) return;
        String first = ctx.getChild(0) == null ? "" : ctx.getChild(0).getText();

        // Asignacion
        if (ctx.IDENT() != null && ctx.exp() != null
                && ctx.getChild(1) != null && "=".equals(ctx.getChild(1).getText())) {
            String lhs = ctx.IDENT().getText();
            String rhs = t.expTextoDeref(ctx.exp(), paramsRef);
            if (funActual != null && lhs.equals(funActual)) return;
            t.line((paramsRef.contains(lhs) ? "*" : "") + lhs + " = " + rhs + ";");
            return;
        }

        // CALL
        if (ctx.proc_call() != null) { emitirCall(ctx.proc_call()); return; }

        // IF sin THEN
        if ("IF".equals(first) && ctx.sent() != null) {
            t.line("if (" + t.expcondTexto(ctx.expcond()) + ") {");
            t.indent(); return;
        }

        // IF THEN [ELSE] ENDIF
        if ("IF".equals(first) && !ctx.sentlist().isEmpty()) {
            t.line("if (" + t.expcondTexto(ctx.expcond()) + ") {");
            t.indent(); return;
        }

        // DO WHILE
        if ("DO".equals(first) && ctx.getChildCount() > 1
                && "WHILE".equals(ctx.getChild(1).getText())) {
            t.line("while (" + t.expcondTexto(ctx.expcond()) + ") {");
            t.indent(); return;
        }

        // DO for
        if ("DO".equals(first) && ctx.IDENT() != null && ctx.doval().size() == 3) {
            String vble = ctx.IDENT().getText();
            t.line("for (" + vble + " = " + ctx.doval(0).getText()
                    + "; " + vble + " <= " + ctx.doval(1).getText()
                    + "; " + vble + " += " + ctx.doval(2).getText() + ") {");
            t.indent(); return;
        }

        // SELECT CASE — procesado manualmente, nivelSwitch bloquea hijos
        if ("SELECT".equals(first)) {
            t.line("switch (" + t.expTexto(ctx.exp()) + ") {");
            t.indent();
            nivelSwitch++;
            procesarCasos(ctx.casos());
            t.dedent();
            t.line("}");
        }
    }

    @Override
    public void exitSent(Grupo11Parser.SentContext ctx) {
        String first = ctx.getChild(0) == null ? "" : ctx.getChild(0).getText();

        // Decrementar nivelSwitch al salir del SELECT, luego ignorar
        if ("SELECT".equals(first)) {
            if (nivelSwitch > 0) nivelSwitch--;
            return;
        }

        if (nivelSwitch > 0) return;

        if ("IF".equals(first) && ctx.sent() != null) { t.dedent(); t.line("}"); return; }

        if ("IF".equals(first) && !ctx.sentlist().isEmpty()) {
            boolean tieneElse = false;
            for (int i = 0; i < ctx.getChildCount(); i++)
                if ("ELSE".equals(ctx.getChild(i).getText())) { tieneElse = true; break; }
            if (!tieneElse) { t.dedent(); t.line("}"); }
            return;
        }

        if ("DO".equals(first)) { t.dedent(); t.line("}"); }
    }

    // casos bloqueados — procesados manualmente
    @Override public void enterCasos(Grupo11Parser.CasosContext ctx) {}
    @Override public void exitCasos (Grupo11Parser.CasosContext ctx) {}

    // ── Procesado manual de casos ────────────────────────────────
    private void procesarCasos(Grupo11Parser.CasosContext ctx) {
        if (ctx == null || ctx.getChildCount() == 0) return;
        if (!"CASE".equals(ctx.getChild(0).getText())) return;

        if (ctx.etiquetas() != null) {
            t.line("case " + t.etiquetaTexto(ctx.etiquetas()) + ":");
        } else {
            t.line("default:");
        }
        t.indent();
        if (ctx.sentlist() != null)
            for (Grupo11Parser.SentContext s : ctx.sentlist().sent())
                emitirSentencia(s);
        t.line("break;");
        t.dedent();
        procesarCasos(ctx.casos());
    }

    private void emitirSentencia(Grupo11Parser.SentContext ctx) {
        String first = ctx.getChild(0) == null ? "" : ctx.getChild(0).getText();

        if (ctx.IDENT() != null && ctx.exp() != null
                && ctx.getChild(1) != null && "=".equals(ctx.getChild(1).getText())) {
            String lhs = ctx.IDENT().getText();
            String rhs = t.expTextoDeref(ctx.exp(), paramsRef);
            if (funActual == null || !lhs.equals(funActual))
                t.line((paramsRef.contains(lhs) ? "*" : "") + lhs + " = " + rhs + ";");
            return;
        }

        if (ctx.proc_call() != null) { emitirCall(ctx.proc_call()); return; }

        if ("IF".equals(first) && ctx.sent() != null) {
            t.line("if (" + t.expcondTexto(ctx.expcond()) + ") {");
            t.indent();
            emitirSentencia(ctx.sent());
            t.dedent(); t.line("}");
            return;
        }

        if ("IF".equals(first) && !ctx.sentlist().isEmpty()) {
            t.line("if (" + t.expcondTexto(ctx.expcond()) + ") {");
            t.indent();
            for (Grupo11Parser.SentContext s : ctx.sentlist(0).sent()) emitirSentencia(s);
            boolean tieneElse = ctx.sentlist().size() == 2;
            if (tieneElse) {
                t.dedent(); t.line("} else {"); t.indent();
                for (Grupo11Parser.SentContext s : ctx.sentlist(1).sent()) emitirSentencia(s);
            }
            t.dedent(); t.line("}");
            return;
        }

        if ("DO".equals(first) && ctx.getChildCount() > 1
                && "WHILE".equals(ctx.getChild(1).getText())) {
            t.line("while (" + t.expcondTexto(ctx.expcond()) + ") {");
            t.indent();
            for (Grupo11Parser.SentContext s : ctx.sentlist(0).sent()) emitirSentencia(s);
            t.dedent(); t.line("}");
            return;
        }

        if ("DO".equals(first) && ctx.IDENT() != null && ctx.doval().size() == 3) {
            String vble = ctx.IDENT().getText();
            t.line("for (" + vble + " = " + ctx.doval(0).getText()
                    + "; " + vble + " <= " + ctx.doval(1).getText()
                    + "; " + vble + " += " + ctx.doval(2).getText() + ") {");
            t.indent();
            for (Grupo11Parser.SentContext s : ctx.sentlist(0).sent()) emitirSentencia(s);
            t.dedent(); t.line("}");
            return;
        }

        if ("SELECT".equals(first)) {
            t.line("switch (" + t.expTexto(ctx.exp()) + ") {");
            t.indent();
            procesarCasos(ctx.casos());
            t.dedent(); t.line("}");
        }
    }

    // ── CALL con & en posiciones OUT/INOUT ───────────────────────
    private void emitirCall(Grupo11Parser.Proc_callContext pc) {
        String nombre = pc.IDENT().getText();
        Grupo11Parser.SubpparamlistContext sp = pc.subpparamlist();
        List<Integer> refs = posRefsSubprogs.getOrDefault(nombre, new ArrayList<>());

        if (sp.exp() != null) {
            List<Grupo11Parser.ExpContext> exps = new ArrayList<>();
            exps.add(sp.exp());
            Grupo11Parser.ExplistContext el = sp.explist();
            while (el != null && el.exp() != null) {
                exps.add(el.exp());
                el = el.explist();
            }
            List<String> args = new ArrayList<>();
            for (int i = 0; i < exps.size(); i++) {
                if (refs.contains(i)) {
                    args.add("&" + exps.get(i).getText());
                } else {
                    args.add(t.expTexto(exps.get(i)));
                }
            }
            t.line(nombre + "(" + String.join(", ", args) + ");");
        } else {
            t.line(nombre + "();");
        }
    }

    // ── Utilidades ───────────────────────────────────────────────
    private void registrarPosRefs(String nombre, List<String> tparam) {
        List<Integer> posRefs = new ArrayList<>();
        for (int i = 0; i < tparam.size(); i++)
            if ("OUT".equals(tparam.get(i)) || "INOUT".equals(tparam.get(i)))
                posRefs.add(i);
        posRefsSubprogs.put(nombre, posRefs);
    }
}