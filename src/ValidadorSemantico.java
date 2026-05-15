import java.util.ArrayList;
import java.util.List;

public class ValidadorSemantico {

    private final List<String> errores = new ArrayList<>();

    public void validar(Grupo11Parser.ProgContext ctx) {
        String nombreInicial = ctx.IDENT(0).getText();
        String nombreFinal   = ctx.IDENT(1).getText();
        if (!nombreInicial.equalsIgnoreCase(nombreFinal))
            err("PROGRAM: nombre inicial '" + nombreInicial + "' != final '" + nombreFinal + "'");

        if (ctx.cabecera() != null && ctx.cabecera().cablist() != null)
            revisarCablist(ctx.cabecera().cablist());
        revisarSubproglist(ctx.subproglist());
    }

    private void revisarCablist(Grupo11Parser.CablistContext cab) {
        if (cab == null) return;
        revisarDecsubprog(cab.decsubprog());
        revisarCablistRest(cab.cablistRest());
    }

    private void revisarCablistRest(Grupo11Parser.CablistRestContext rest) {
        if (rest == null || rest.decsubprog() == null) return;
        revisarDecsubprog(rest.decsubprog());
        revisarCablistRest(rest.cablistRest());
    }

    private void revisarDecsubprog(Grupo11Parser.DecsubprogContext d) {
        if (d == null) return;
        if (d.decproc() != null) chkDecproc(d.decproc());
        if (d.decfun()  != null) chkDecfun(d.decfun());
    }

    private void revisarSubproglist(Grupo11Parser.SubproglistContext lista) {
        if (lista == null || lista.subprog() == null) return;
        Grupo11Parser.SubprogContext sp = lista.subprog();
        if (sp.codproc() != null) chkCodproc(sp.codproc());
        if (sp.codfun()  != null) chkCodfun(sp.codfun());
        revisarSubproglist(lista.subproglist());
    }

    private void chkDecproc(Grupo11Parser.DecprocContext ctx) {
        String ini = ctx.IDENT(0).getText();
        String fin = ctx.IDENT(1).getText();
        if (!ini.equalsIgnoreCase(fin))
            err("SUBROUTINE: nombre inicial '" + ini + "' != final '" + fin + "'");
        chkOrdenProc(ctx.formal_paramlist(), ctx.dec_s_paramlist(), "SUBROUTINE " + ini);
    }

    private void chkDecfun(Grupo11Parser.DecfunContext ctx) {
        String ini    = ctx.IDENT(0).getText();
        String tipoid = ctx.IDENT(1).getText();
        String fin    = ctx.IDENT(2).getText();
        if (!ini.equalsIgnoreCase(fin))
            err("FUNCTION: nombre inicial '" + ini + "' != final '" + fin + "'");
        if (!ini.equalsIgnoreCase(tipoid))
            err("FUNCTION '" + ini + "': tipo devuelto debe llamarse '" + ini + "', se encontro '" + tipoid + "'");
        chkOrdenFun(ctx.nomparamlist(), ctx.dec_f_paramlist(), "FUNCTION " + ini);
    }

    private void chkCodproc(Grupo11Parser.CodprocContext ctx) {
        String ini = ctx.IDENT(0).getText();
        String fin = ctx.IDENT(1).getText();
        if (!ini.equalsIgnoreCase(fin))
            err("SUBROUTINE(impl): nombre inicial '" + ini + "' != final '" + fin + "'");
        chkOrdenProc(ctx.formal_paramlist(), ctx.dec_s_paramlist(), "SUBROUTINE(impl) " + ini);
    }

    private void chkCodfun(Grupo11Parser.CodfunContext ctx) {
        String ini    = ctx.IDENT(0).getText();
        String tipoid = ctx.IDENT(1).getText();
        String retid  = ctx.IDENT(2).getText();
        String fin    = ctx.IDENT(3).getText();
        if (!ini.equalsIgnoreCase(fin))
            err("FUNCTION(impl): nombre inicial '" + ini + "' != final '" + fin + "'");
        if (!ini.equalsIgnoreCase(tipoid))
            err("FUNCTION(impl) '" + ini + "': tipo devuelto debe llamarse '" + ini + "', se encontro '" + tipoid + "'");
        if (!ini.equalsIgnoreCase(retid))
            err("FUNCTION(impl) '" + ini + "': asignacion retorno debe usar '" + ini + "', se encontro '" + retid + "'");
        chkOrdenFun(ctx.nomparamlist(), ctx.dec_f_paramlist(), "FUNCTION(impl) " + ini);
    }

    private void chkOrdenProc(Grupo11Parser.Formal_paramlistContext cab,
                              Grupo11Parser.Dec_s_paramlistContext tipos,
                              String donde) {
        List<String> pCab  = extraerFormal(cab);
        List<String> pTipo = extraerProc(tipos);
        if (!igualesIgnoreCase(pCab, pTipo))
            err(donde + ": params cabecera " + pCab + " != declarados " + pTipo);
    }

    private void chkOrdenFun(Grupo11Parser.NomparamlistContext cab,
                             Grupo11Parser.Dec_f_paramlistContext tipos,
                             String donde) {
        List<String> pCab  = extraerNom(cab);
        List<String> pTipo = extraerFun(tipos);
        if (!igualesIgnoreCase(pCab, pTipo))
            err(donde + ": params cabecera " + pCab + " != declarados " + pTipo);
    }

    private List<String> extraerFormal(Grupo11Parser.Formal_paramlistContext ctx) {
        if (ctx == null || ctx.nomparamlist() == null) return new ArrayList<>();
        return extraerNom(ctx.nomparamlist());
    }

    private List<String> extraerNom(Grupo11Parser.NomparamlistContext ctx) {
        List<String> ids = new ArrayList<>();
        if (ctx == null) return ids;
        ids.add(ctx.IDENT().getText());
        Grupo11Parser.NomparamlistRestContext r = ctx.nomparamlistRest();
        while (r != null && r.IDENT() != null) {
            ids.add(r.IDENT().getText());
            r = r.nomparamlistRest();
        }
        return ids;
    }

    private List<String> extraerProc(Grupo11Parser.Dec_s_paramlistContext ctx) {
        List<String> ids = new ArrayList<>();
        for (Grupo11Parser.Dec_s_paramlistContext a = ctx; a != null; a = a.dec_s_paramlist())
            if (a.dec_d_paramlist() != null)
                ids.add(a.dec_d_paramlist().IDENT().getText());
        return ids;
    }

    private List<String> extraerFun(Grupo11Parser.Dec_f_paramlistContext ctx) {
        List<String> ids = new ArrayList<>();
        for (Grupo11Parser.Dec_f_paramlistContext a = ctx; a != null; a = a.dec_f_paramlist())
            if (a.dec_d_paramlist() != null)
                ids.add(a.dec_d_paramlist().IDENT().getText());
        return ids;
    }

    private boolean igualesIgnoreCase(List<String> a, List<String> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++)
            if (!a.get(i).equalsIgnoreCase(b.get(i))) return false;
        return true;
    }

    private void err(String msg) { errores.add("Error semantico: " + msg); }

    public boolean hayErrores()      { return !errores.isEmpty(); }
    public List<String> getErrores() { return errores; }
    public void imprimirErrores()    { errores.forEach(System.err::println); }
}
