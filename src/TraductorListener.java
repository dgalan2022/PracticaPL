import java.util.ArrayList;
import java.util.List;

public class TraductorListener extends Grupo11BaseListener {

    private final TraductorC t;
    private String funActual = null;
    private boolean enMain   = false;

    public TraductorListener(TraductorC traductor) {
        this.t = traductor;
    }

    @Override
    public void enterProg(Grupo11Parser.ProgContext ctx) {
        enMain = true;
    }

    @Override
    public void exitProg(Grupo11Parser.ProgContext ctx) {
        t.endMain();
    }

    @Override
    public void enterDcl(Grupo11Parser.DclContext ctx) {
        boolean esParam = false;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if ("PARAMETER".equals(ctx.getChild(i).getText())) {
                esParam = true;
                break;
            }
        }

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

    private String varConInit(String nombre, String tipo, String len,
                              Grupo11Parser.InitContext init) {
        String dim  = (!len.isEmpty() && tipo.equals("char")) ? "[" + len + "]" : "";
        String base = nombre + dim;
        if (init != null && init.simpvalue() != null)
            return base + " = " + t.simpvalueTexto(init.simpvalue());
        return base;
    }

    @Override
    public void enterDecproc(Grupo11Parser.DecprocContext ctx) {
        String nombre = ctx.IDENT(0).getText();
        List<String> tipos  = t.tiposProc(ctx.dec_s_paramlist());
        List<String> params = ctx.formal_paramlist().nomparamlist() != null
                ? t.extraerNomparams(ctx.formal_paramlist().nomparamlist())
                : new ArrayList<>();
        t.addPrototype("void " + nombre + "(" + t.buildParams(params, tipos) + ");");
    }

    @Override
    public void enterDecfun(Grupo11Parser.DecfunContext ctx) {
        String nombre = ctx.IDENT(0).getText();
        String tipo   = t.mapTipo(ctx.tipo());
        List<String> tipos  = t.tiposFun(ctx.dec_f_paramlist());
        List<String> params = t.extraerNomparams(ctx.nomparamlist());
        t.addPrototype(tipo + " " + nombre + "(" + t.buildParams(params, tipos) + ");");
    }

    @Override
    public void enterCodproc(Grupo11Parser.CodprocContext ctx) {
        enMain    = false;
        funActual = null;
        String nombre = ctx.IDENT(0).getText();
        List<String> tipos  = t.tiposProc(ctx.dec_s_paramlist());
        List<String> params = ctx.formal_paramlist().nomparamlist() != null
                ? t.extraerNomparams(ctx.formal_paramlist().nomparamlist())
                : new ArrayList<>();
        t.startSubprog("void " + nombre + "(" + t.buildParams(params, tipos) + ")");
    }

    @Override
    public void exitCodproc(Grupo11Parser.CodprocContext ctx) {
        t.endSubprog();
    }

    @Override
    public void enterCodfun(Grupo11Parser.CodfunContext ctx) {
        enMain    = false;
        funActual = ctx.IDENT(0).getText();
        String tipo   = t.mapTipo(ctx.tipo());
        List<String> tipos  = t.tiposFun(ctx.dec_f_paramlist());
        List<String> params = t.extraerNomparams(ctx.nomparamlist());
        t.startSubprog(tipo + " " + funActual + "(" + t.buildParams(params, tipos) + ")");
    }

    @Override
    public void exitCodfun(Grupo11Parser.CodfunContext ctx) {
        t.line("return " + t.expTexto(ctx.exp()) + ";");
        t.endSubprog();
        funActual = null;
    }

    @Override
    public void enterSentlist(Grupo11Parser.SentlistContext ctx) {
        if (enMain && funActual == null && !t.mainStarted()) t.startMain();
    }

    @Override
    public void enterSent(Grupo11Parser.SentContext ctx) {
        if (ctx.proc_call() != null) {
            String nombre = ctx.proc_call().IDENT().getText();
            Grupo11Parser.SubpparamlistContext sp = ctx.proc_call().subpparamlist();
            if (sp.exp() != null) {
                List<String> exps = new ArrayList<>();
                exps.add(t.expTexto(sp.exp()));
                Grupo11Parser.ExplistContext el = sp.explist();
                while (el != null && el.exp() != null) {
                    exps.add(t.expTexto(el.exp()));
                    el = el.explist();
                }
                t.line(nombre + "(" + String.join(", ", exps) + ");");
            } else {
                t.line(nombre + "();");
            }
        } else if (ctx.IDENT() != null && ctx.exp() != null) {
            String lhs = ctx.IDENT().getText();
            String rhs = t.expTexto(ctx.exp());
            if (funActual != null && lhs.equals(funActual)) return;
            t.line(lhs + " = " + rhs + ";");
        }
    }
}