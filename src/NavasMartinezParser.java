// Generated from C:/Users/Personal/Desktop/UNI/Curso 4/Segundo Cuatri/PL/Practicas/Complementaria/NavasMartinez/src/NavasMartinez.g4 by ANTLR 4.13.2

import java.util.*;
import java.util.regex.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NavasMartinezParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CODEBLOCK=1, LISTITEM=2, H6=3, H5=4, H4=5, H3=6, H2=7, H1=8, QUOTE=9, 
		HRULE=10, LINK=11, BOLD=12, ITALIC=13, WS=14, NEWLINE=15, WORD=16;
	public static final int
		RULE_prog = 0, RULE_document = 1, RULE_element = 2, RULE_heading = 3, 
		RULE_quote = 4, RULE_hrule = 5, RULE_codeblock = 6, RULE_list = 7, RULE_listitem = 8, 
		RULE_textline = 9, RULE_textpart = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "document", "element", "heading", "quote", "hrule", "codeblock", 
			"list", "listitem", "textline", "textpart"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CODEBLOCK", "LISTITEM", "H6", "H5", "H4", "H3", "H2", "H1", "QUOTE", 
			"HRULE", "LINK", "BOLD", "ITALIC", "WS", "NEWLINE", "WORD"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NavasMartinez.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NavasMartinezParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DocumentContext document() {
			return getRuleContext(DocumentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(NavasMartinezParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{

			    System.out.println("<!DOCTYPE html>");
			    System.out.println("<html>");
			    System.out.println("<head>");
			    System.out.println("<title>MarkDown3HTML</title>");
			    System.out.println("<style>");
			    System.out.println(".bold {font-weight: bold;}");
			    System.out.println(".ital {font-style: italic;}");
			    System.out.println("</style>");
			    System.out.println("</head>");
			    System.out.println("<body>");

			setState(23);
			document();
			setState(24);
			match(EOF);

			    // Cierra el HTML
			    System.out.println("</body>");
			    System.out.println("</html>");

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 131070L) != 0)) {
				{
				{
				setState(27);
				element();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public HeadingContext heading() {
			return getRuleContext(HeadingContext.class,0);
		}
		public QuoteContext quote() {
			return getRuleContext(QuoteContext.class,0);
		}
		public HruleContext hrule() {
			return getRuleContext(HruleContext.class,0);
		}
		public CodeblockContext codeblock() {
			return getRuleContext(CodeblockContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TextlineContext textline() {
			return getRuleContext(TextlineContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(NavasMartinezParser.NEWLINE, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_element);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case H6:
			case H5:
			case H4:
			case H3:
			case H2:
			case H1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				heading();
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				quote();
				}
				break;
			case HRULE:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				hrule();
				}
				break;
			case CODEBLOCK:
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				codeblock();
				}
				break;
			case LISTITEM:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				list();
				}
				break;
			case LINK:
			case BOLD:
			case ITALIC:
			case WS:
			case WORD:
				enterOuterAlt(_localctx, 6);
				{
				setState(38);
				textline();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 7);
				{
				setState(39);
				match(NEWLINE);
				 System.out.println(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeadingContext extends ParserRuleContext {
		public Token H1;
		public Token H2;
		public Token H3;
		public Token H4;
		public Token H5;
		public Token H6;
		public TerminalNode H1() { return getToken(NavasMartinezParser.H1, 0); }
		public TerminalNode H2() { return getToken(NavasMartinezParser.H2, 0); }
		public TerminalNode H3() { return getToken(NavasMartinezParser.H3, 0); }
		public TerminalNode H4() { return getToken(NavasMartinezParser.H4, 0); }
		public TerminalNode H5() { return getToken(NavasMartinezParser.H5, 0); }
		public TerminalNode H6() { return getToken(NavasMartinezParser.H6, 0); }
		public HeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadingContext heading() throws RecognitionException {
		HeadingContext _localctx = new HeadingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_heading);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case H1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				((HeadingContext)_localctx).H1 = match(H1);
				 System.out.println("<H1>" + (((HeadingContext)_localctx).H1!=null?((HeadingContext)_localctx).H1.getText():null).substring(2).trim() + "</H1>"); 
				}
				break;
			case H2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((HeadingContext)_localctx).H2 = match(H2);
				 System.out.println("<H2>" + (((HeadingContext)_localctx).H2!=null?((HeadingContext)_localctx).H2.getText():null).substring(3).trim() + "</H2>"); 
				}
				break;
			case H3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				((HeadingContext)_localctx).H3 = match(H3);
				 System.out.println("<H3>" + (((HeadingContext)_localctx).H3!=null?((HeadingContext)_localctx).H3.getText():null).substring(4).trim() + "</H3>"); 
				}
				break;
			case H4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				((HeadingContext)_localctx).H4 = match(H4);
				 System.out.println("<H4>" + (((HeadingContext)_localctx).H4!=null?((HeadingContext)_localctx).H4.getText():null).substring(5).trim() + "</H4>"); 
				}
				break;
			case H5:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				((HeadingContext)_localctx).H5 = match(H5);
				 System.out.println("<H5>" + (((HeadingContext)_localctx).H5!=null?((HeadingContext)_localctx).H5.getText():null).substring(6).trim() + "</H5>"); 
				}
				break;
			case H6:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				((HeadingContext)_localctx).H6 = match(H6);
				 System.out.println("<H6>" + (((HeadingContext)_localctx).H6!=null?((HeadingContext)_localctx).H6.getText():null).substring(7).trim() + "</H6>"); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuoteContext extends ParserRuleContext {
		public Token QUOTE;
		public TerminalNode QUOTE() { return getToken(NavasMartinezParser.QUOTE, 0); }
		public QuoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterQuote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitQuote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitQuote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuoteContext quote() throws RecognitionException {
		QuoteContext _localctx = new QuoteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((QuoteContext)_localctx).QUOTE = match(QUOTE);

			    System.out.println("<blockquote>");
			    System.out.println((((QuoteContext)_localctx).QUOTE!=null?((QuoteContext)_localctx).QUOTE.getText():null).substring(2).trim());
			    System.out.println("</blockquote>");

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HruleContext extends ParserRuleContext {
		public TerminalNode HRULE() { return getToken(NavasMartinezParser.HRULE, 0); }
		public HruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterHrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitHrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitHrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HruleContext hrule() throws RecognitionException {
		HruleContext _localctx = new HruleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_hrule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(HRULE);
			 System.out.println("<HR/>"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeblockContext extends ParserRuleContext {
		public Token CODEBLOCK;
		public TerminalNode CODEBLOCK() { return getToken(NavasMartinezParser.CODEBLOCK, 0); }
		public CodeblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterCodeblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitCodeblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitCodeblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeblockContext codeblock() throws RecognitionException {
		CodeblockContext _localctx = new CodeblockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			((CodeblockContext)_localctx).CODEBLOCK = match(CODEBLOCK);

			    String content = (((CodeblockContext)_localctx).CODEBLOCK!=null?((CodeblockContext)_localctx).CODEBLOCK.getText():null);
			    content = content.substring(4, content.length()-4).trim();
			    System.out.println("<code> <pre>");
			    System.out.print(content);
			    System.out.println("</pre> </code>");

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public List<ListitemContext> listitem() {
			return getRuleContexts(ListitemContext.class);
		}
		public ListitemContext listitem(int i) {
			return getRuleContext(ListitemContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 System.out.println("<UL>"); 
			setState(68); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(67);
					listitem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(70); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			 System.out.println("</UL>"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListitemContext extends ParserRuleContext {
		public Token LISTITEM;
		public TerminalNode LISTITEM() { return getToken(NavasMartinezParser.LISTITEM, 0); }
		public ListitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterListitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitListitem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitListitem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListitemContext listitem() throws RecognitionException {
		ListitemContext _localctx = new ListitemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listitem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((ListitemContext)_localctx).LISTITEM = match(LISTITEM);

			    String item = (((ListitemContext)_localctx).LISTITEM!=null?((ListitemContext)_localctx).LISTITEM.getText():null).substring(2).trim();
			    System.out.println("<LI>" + item + "</LI>");

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextlineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(NavasMartinezParser.NEWLINE, 0); }
		public List<TextpartContext> textpart() {
			return getRuleContexts(TextpartContext.class);
		}
		public TextpartContext textpart(int i) {
			return getRuleContext(TextpartContext.class,i);
		}
		public TextlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterTextline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitTextline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitTextline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextlineContext textline() throws RecognitionException {
		TextlineContext _localctx = new TextlineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_textline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				textpart();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 96256L) != 0) );
			setState(82);
			match(NEWLINE);
			 System.out.println(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextpartContext extends ParserRuleContext {
		public Token LINK;
		public Token BOLD;
		public Token ITALIC;
		public Token WS;
		public Token WORD;
		public TerminalNode LINK() { return getToken(NavasMartinezParser.LINK, 0); }
		public TerminalNode BOLD() { return getToken(NavasMartinezParser.BOLD, 0); }
		public TerminalNode ITALIC() { return getToken(NavasMartinezParser.ITALIC, 0); }
		public TerminalNode WS() { return getToken(NavasMartinezParser.WS, 0); }
		public TerminalNode WORD() { return getToken(NavasMartinezParser.WORD, 0); }
		public TextpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).enterTextpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NavasMartinezListener ) ((NavasMartinezListener)listener).exitTextpart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NavasMartinezVisitor ) return ((NavasMartinezVisitor<? extends T>)visitor).visitTextpart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextpartContext textpart() throws RecognitionException {
		TextpartContext _localctx = new TextpartContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_textpart);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LINK:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((TextpartContext)_localctx).LINK = match(LINK);

				        // Extraer texto y URL del enlace
				        String full = (((TextpartContext)_localctx).LINK!=null?((TextpartContext)_localctx).LINK.getText():null);
				        int urlStart = full.indexOf("](") + 2;
				        int urlEnd = full.lastIndexOf(")");
				        String linkText = full.substring(1, full.indexOf("]("));
				        String url = full.substring(urlStart, urlEnd);

				        // Validar formato de URL
				        boolean isValid = url.matches("^(http://|https://)[a-zA-Z0-9]+\\.[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*.*$");

				        System.out.print("<A HREF=\"" + url + "\">" + linkText);
				        if (!isValid) {
				            System.out.print("(URL aparentemente incorrecta)");
				        }
				        System.out.print("</A>");
				    
				}
				break;
			case BOLD:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				((TextpartContext)_localctx).BOLD = match(BOLD);

				        // Procesar texto en negrita
				        String s = (((TextpartContext)_localctx).BOLD!=null?((TextpartContext)_localctx).BOLD.getText():null);
				        String txt = s.startsWith("**") ? s.substring(2, s.length()-2) : s.substring(2, s.length()-2);
				        System.out.print("<SPAN class=\"bold\">" + txt + "</SPAN>");
				    
				}
				break;
			case ITALIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((TextpartContext)_localctx).ITALIC = match(ITALIC);

				        // Procesar texto en cursiva
				        String s = (((TextpartContext)_localctx).ITALIC!=null?((TextpartContext)_localctx).ITALIC.getText():null);
				        String txt = s.substring(1, s.length()-1);
				        System.out.print("<SPAN class=\"ital\">" + txt + "</SPAN>");
				    
				}
				break;
			case WS:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				((TextpartContext)_localctx).WS = match(WS);
				 System.out.print((((TextpartContext)_localctx).WS!=null?((TextpartContext)_localctx).WS.getText():null)); 
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				((TextpartContext)_localctx).WORD = match(WORD);
				 System.out.print((((TextpartContext)_localctx).WORD!=null?((TextpartContext)_localctx).WORD.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001\u001d\b\u0001\n"+
		"\u0001\f\u0001 \t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002*\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00038\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0004\u0007E\b\u0007\u000b\u0007\f\u0007F\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0004\tO\b\t\u000b\t\f\tP\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n`\b\n\u0001\n\u0000\u0000\u000b\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000h\u0000\u0016"+
		"\u0001\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000\u0000\u0004)\u0001"+
		"\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b9\u0001\u0000\u0000"+
		"\u0000\n<\u0001\u0000\u0000\u0000\f?\u0001\u0000\u0000\u0000\u000eB\u0001"+
		"\u0000\u0000\u0000\u0010J\u0001\u0000\u0000\u0000\u0012N\u0001\u0000\u0000"+
		"\u0000\u0014_\u0001\u0000\u0000\u0000\u0016\u0017\u0006\u0000\uffff\uffff"+
		"\u0000\u0017\u0018\u0003\u0002\u0001\u0000\u0018\u0019\u0005\u0000\u0000"+
		"\u0001\u0019\u001a\u0006\u0000\uffff\uffff\u0000\u001a\u0001\u0001\u0000"+
		"\u0000\u0000\u001b\u001d\u0003\u0004\u0002\u0000\u001c\u001b\u0001\u0000"+
		"\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u0003\u0001\u0000\u0000"+
		"\u0000 \u001e\u0001\u0000\u0000\u0000!*\u0003\u0006\u0003\u0000\"*\u0003"+
		"\b\u0004\u0000#*\u0003\n\u0005\u0000$*\u0003\f\u0006\u0000%*\u0003\u000e"+
		"\u0007\u0000&*\u0003\u0012\t\u0000\'(\u0005\u000f\u0000\u0000(*\u0006"+
		"\u0002\uffff\uffff\u0000)!\u0001\u0000\u0000\u0000)\"\u0001\u0000\u0000"+
		"\u0000)#\u0001\u0000\u0000\u0000)$\u0001\u0000\u0000\u0000)%\u0001\u0000"+
		"\u0000\u0000)&\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*\u0005"+
		"\u0001\u0000\u0000\u0000+,\u0005\b\u0000\u0000,8\u0006\u0003\uffff\uffff"+
		"\u0000-.\u0005\u0007\u0000\u0000.8\u0006\u0003\uffff\uffff\u0000/0\u0005"+
		"\u0006\u0000\u000008\u0006\u0003\uffff\uffff\u000012\u0005\u0005\u0000"+
		"\u000028\u0006\u0003\uffff\uffff\u000034\u0005\u0004\u0000\u000048\u0006"+
		"\u0003\uffff\uffff\u000056\u0005\u0003\u0000\u000068\u0006\u0003\uffff"+
		"\uffff\u00007+\u0001\u0000\u0000\u00007-\u0001\u0000\u0000\u00007/\u0001"+
		"\u0000\u0000\u000071\u0001\u0000\u0000\u000073\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u00008\u0007\u0001\u0000\u0000\u00009:\u0005\t\u0000"+
		"\u0000:;\u0006\u0004\uffff\uffff\u0000;\t\u0001\u0000\u0000\u0000<=\u0005"+
		"\n\u0000\u0000=>\u0006\u0005\uffff\uffff\u0000>\u000b\u0001\u0000\u0000"+
		"\u0000?@\u0005\u0001\u0000\u0000@A\u0006\u0006\uffff\uffff\u0000A\r\u0001"+
		"\u0000\u0000\u0000BD\u0006\u0007\uffff\uffff\u0000CE\u0003\u0010\b\u0000"+
		"DC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0006\u0007"+
		"\uffff\uffff\u0000I\u000f\u0001\u0000\u0000\u0000JK\u0005\u0002\u0000"+
		"\u0000KL\u0006\b\uffff\uffff\u0000L\u0011\u0001\u0000\u0000\u0000MO\u0003"+
		"\u0014\n\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0005\u000f\u0000\u0000ST\u0006\t\uffff\uffff\u0000T\u0013\u0001\u0000"+
		"\u0000\u0000UV\u0005\u000b\u0000\u0000V`\u0006\n\uffff\uffff\u0000WX\u0005"+
		"\f\u0000\u0000X`\u0006\n\uffff\uffff\u0000YZ\u0005\r\u0000\u0000Z`\u0006"+
		"\n\uffff\uffff\u0000[\\\u0005\u000e\u0000\u0000\\`\u0006\n\uffff\uffff"+
		"\u0000]^\u0005\u0010\u0000\u0000^`\u0006\n\uffff\uffff\u0000_U\u0001\u0000"+
		"\u0000\u0000_W\u0001\u0000\u0000\u0000_Y\u0001\u0000\u0000\u0000_[\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`\u0015\u0001\u0000\u0000"+
		"\u0000\u0006\u001e)7FP_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}