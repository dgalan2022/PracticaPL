// Generated from C:/Users/Personal/Desktop/UNI/Curso 4/Segundo Cuatri/PL/Practicas/Obligatoria/PracticaGrupo11PL/src/Grupo11.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Grupo11Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Grupo11Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(Grupo11Parser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#dcllist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcllist(Grupo11Parser.DcllistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(Grupo11Parser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#ctelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtelist(Grupo11Parser.CtelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#simpvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpvalue(Grupo11Parser.SimpvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#varlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlist(Grupo11Parser.VarlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#varlistRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlistRest(Grupo11Parser.VarlistRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(Grupo11Parser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(Grupo11Parser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#charlength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharlength(Grupo11Parser.CharlengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera(Grupo11Parser.CabeceraContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#cablist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCablist(Grupo11Parser.CablistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#cablistRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCablistRest(Grupo11Parser.CablistRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#decsubprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecsubprog(Grupo11Parser.DecsubprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#decproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecproc(Grupo11Parser.DecprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#formal_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_paramlist(Grupo11Parser.Formal_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#nomparamlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomparamlist(Grupo11Parser.NomparamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#nomparamlistRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomparamlistRest(Grupo11Parser.NomparamlistRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_d_paramlist(Grupo11Parser.Dec_d_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_s_paramlist(Grupo11Parser.Dec_s_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#tipoparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoparam(Grupo11Parser.TipoparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#decfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecfun(Grupo11Parser.DecfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_f_paramlist(Grupo11Parser.Dec_f_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#sentlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentlist(Grupo11Parser.SentlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#sentlistRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentlistRest(Grupo11Parser.SentlistRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#sent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSent(Grupo11Parser.SentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#doval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoval(Grupo11Parser.DovalContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#expcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpcond(Grupo11Parser.ExpcondContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#expcondRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpcondRest(Grupo11Parser.ExpcondRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#oplog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOplog(Grupo11Parser.OplogContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#factorcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorcond(Grupo11Parser.FactorcondContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#opcomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcomp(Grupo11Parser.OpcompContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#casos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasos(Grupo11Parser.CasosContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#etiquetas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEtiquetas(Grupo11Parser.EtiquetasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#listaetiquetas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaetiquetas(Grupo11Parser.ListaetiquetasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(Grupo11Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#expRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpRest(Grupo11Parser.ExpRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(Grupo11Parser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(Grupo11Parser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(Grupo11Parser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#proc_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_call(Grupo11Parser.Proc_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#subpparamlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpparamlist(Grupo11Parser.SubpparamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#subproglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubproglist(Grupo11Parser.SubproglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#subprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprog(Grupo11Parser.SubprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#codproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodproc(Grupo11Parser.CodprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link Grupo11Parser#codfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodfun(Grupo11Parser.CodfunContext ctx);
}