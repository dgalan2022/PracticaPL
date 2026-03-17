// Generated from C:/Users/Personal/Desktop/UNI/Curso 4/Segundo Cuatri/PL/Practicas/Complementaria/NavasMartinez/src/NavasMartinez.g4 by ANTLR 4.13.2

import java.util.*;
import java.util.regex.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NavasMartinezParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NavasMartinezVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(NavasMartinezParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(NavasMartinezParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(NavasMartinezParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#heading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeading(NavasMartinezParser.HeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#quote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(NavasMartinezParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#hrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHrule(NavasMartinezParser.HruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#codeblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeblock(NavasMartinezParser.CodeblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(NavasMartinezParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#listitem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListitem(NavasMartinezParser.ListitemContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#textline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextline(NavasMartinezParser.TextlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link NavasMartinezParser#textpart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextpart(NavasMartinezParser.TextpartContext ctx);
}