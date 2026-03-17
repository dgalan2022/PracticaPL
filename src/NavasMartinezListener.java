// Generated from C:/Users/Personal/Desktop/UNI/Curso 4/Segundo Cuatri/PL/Practicas/Complementaria/NavasMartinez/src/NavasMartinez.g4 by ANTLR 4.13.2

import java.util.*;
import java.util.regex.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NavasMartinezParser}.
 */
public interface NavasMartinezListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(NavasMartinezParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(NavasMartinezParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(NavasMartinezParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(NavasMartinezParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(NavasMartinezParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(NavasMartinezParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#heading}.
	 * @param ctx the parse tree
	 */
	void enterHeading(NavasMartinezParser.HeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#heading}.
	 * @param ctx the parse tree
	 */
	void exitHeading(NavasMartinezParser.HeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#quote}.
	 * @param ctx the parse tree
	 */
	void enterQuote(NavasMartinezParser.QuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#quote}.
	 * @param ctx the parse tree
	 */
	void exitQuote(NavasMartinezParser.QuoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#hrule}.
	 * @param ctx the parse tree
	 */
	void enterHrule(NavasMartinezParser.HruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#hrule}.
	 * @param ctx the parse tree
	 */
	void exitHrule(NavasMartinezParser.HruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void enterCodeblock(NavasMartinezParser.CodeblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void exitCodeblock(NavasMartinezParser.CodeblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(NavasMartinezParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(NavasMartinezParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#listitem}.
	 * @param ctx the parse tree
	 */
	void enterListitem(NavasMartinezParser.ListitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#listitem}.
	 * @param ctx the parse tree
	 */
	void exitListitem(NavasMartinezParser.ListitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#textline}.
	 * @param ctx the parse tree
	 */
	void enterTextline(NavasMartinezParser.TextlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#textline}.
	 * @param ctx the parse tree
	 */
	void exitTextline(NavasMartinezParser.TextlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link NavasMartinezParser#textpart}.
	 * @param ctx the parse tree
	 */
	void enterTextpart(NavasMartinezParser.TextpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link NavasMartinezParser#textpart}.
	 * @param ctx the parse tree
	 */
	void exitTextpart(NavasMartinezParser.TextpartContext ctx);
}