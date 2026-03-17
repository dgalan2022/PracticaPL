// Generated from C:/Users/diego/OneDrive/Documentos/Universidad URJC/4 ano/2 Cuatri/PL/PracticaCumplimentaria/src/GalanHernandez.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GalanHernandezParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		H6=1, H5=2, H4=3, H3=4, H2=5, H1=6, BLOCKQUOTE=7, LIST_START=8, DOUBLE_HR=9, 
		HR=10, CODE_BLOCK=11, NEWLINE=12, ANY=13;
	public static final int
		RULE_documento = 0, RULE_linea = 1, RULE_encabezado = 2, RULE_lineaHorizontal = 3, 
		RULE_cita = 4, RULE_bloquecodigo = 5, RULE_lista = 6, RULE_itemLista = 7, 
		RULE_parrafo = 8, RULE_restoLinea = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"documento", "linea", "encabezado", "lineaHorizontal", "cita", "bloquecodigo", 
			"lista", "itemLista", "parrafo", "restoLinea"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'###### '", "'##### '", "'#### '", "'### '", "'## '", "'# '", 
			"'> '", "'- '", "'==='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "H6", "H5", "H4", "H3", "H2", "H1", "BLOCKQUOTE", "LIST_START", 
			"DOUBLE_HR", "HR", "CODE_BLOCK", "NEWLINE", "ANY"
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
	public String getGrammarFileName() { return "GalanHernandez.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private String convertirTexto(String texto) {
	        if (texto == null) return "";
	        texto = texto.trim();

	        texto = procesarEnlaces(texto);

	        texto = procesarNegrita(texto);
	        texto = procesarCursiva(texto);

	        return texto;
	    }

	    private String procesarEnlaces(String texto) {
	        java.util.regex.Pattern patron = java.util.regex.Pattern.compile("\\[([^\\]]+)\\]\\(([^)]+)\\)");
	        java.util.regex.Matcher buscador = patron.matcher(texto);
	        StringBuffer resultado = new StringBuffer();

	        while (buscador.find()) {
	            String textoEnlace = buscador.group(1);
	            String direccionURL = buscador.group(2);
	            String htmlFinal;

	            if (esURLValida(direccionURL)) {
	                htmlFinal = "<a href=\"" + direccionURL + "\">" + textoEnlace + "</a>";
	            } else {
	                htmlFinal = "<a href=\"" + direccionURL + "\">" + textoEnlace + "</a>(URL enlace aparentemente incorrecta)";
	            }
	            buscador.appendReplacement(resultado, java.util.regex.Matcher.quoteReplacement(htmlFinal));
	        }
	        buscador.appendTail(resultado);
	        return resultado.toString();
	    }

	    private boolean esURLValida(String url) {
	        return url.matches("https?://[a-zA-Z0-9]+\\.[a-zA-Z0-9]+.*");
	    }

	    private String procesarNegrita(String texto) {
	        texto = texto.replaceAll("\\*\\*([^*]+)\\*\\*", "<b>$1</b>");
	        texto = texto.replaceAll("__([^_]+)__", "<b>$1</b>");
	        return texto;
	    }

	    private String procesarCursiva(String texto) {
	        texto = texto.replaceAll("\\*([^*]+)\\*", "<i>$1</i>");
	        texto = texto.replaceAll("_([^_]+)_", "<i>$1</i>");
	        return texto;
	    }

	public GalanHernandezParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentoContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GalanHernandezParser.EOF, 0); }
		public List<LineaContext> linea() {
			return getRuleContexts(LineaContext.class);
		}
		public LineaContext linea(int i) {
			return getRuleContext(LineaContext.class,i);
		}
		public DocumentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documento; }
	}

	public final DocumentoContext documento() throws RecognitionException {
		DocumentoContext _localctx = new DocumentoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_documento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 System.out.println("<!DOCTYPE html>\n<html>\n<head>\n<title>MarkDown3HTML</title>\n</head>\n<body>"); 
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16382L) != 0)) {
				{
				{
				setState(21);
				linea();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 System.out.println("</body>\n</html>"); 
			setState(28);
			match(EOF);
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
	public static class LineaContext extends ParserRuleContext {
		public EncabezadoContext encabezado() {
			return getRuleContext(EncabezadoContext.class,0);
		}
		public LineaHorizontalContext lineaHorizontal() {
			return getRuleContext(LineaHorizontalContext.class,0);
		}
		public CitaContext cita() {
			return getRuleContext(CitaContext.class,0);
		}
		public BloquecodigoContext bloquecodigo() {
			return getRuleContext(BloquecodigoContext.class,0);
		}
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public ParrafoContext parrafo() {
			return getRuleContext(ParrafoContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GalanHernandezParser.NEWLINE, 0); }
		public LineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linea; }
	}

	public final LineaContext linea() throws RecognitionException {
		LineaContext _localctx = new LineaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_linea);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				encabezado();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				lineaHorizontal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				cita();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				bloquecodigo();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				lista();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(35);
				parrafo();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(36);
				match(NEWLINE);
				}
				break;
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
	public static class EncabezadoContext extends ParserRuleContext {
		public RestoLineaContext contenido;
		public TerminalNode H1() { return getToken(GalanHernandezParser.H1, 0); }
		public RestoLineaContext restoLinea() {
			return getRuleContext(RestoLineaContext.class,0);
		}
		public TerminalNode H2() { return getToken(GalanHernandezParser.H2, 0); }
		public TerminalNode H3() { return getToken(GalanHernandezParser.H3, 0); }
		public TerminalNode H4() { return getToken(GalanHernandezParser.H4, 0); }
		public TerminalNode H5() { return getToken(GalanHernandezParser.H5, 0); }
		public TerminalNode H6() { return getToken(GalanHernandezParser.H6, 0); }
		public EncabezadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encabezado; }
	}

	public final EncabezadoContext encabezado() throws RecognitionException {
		EncabezadoContext _localctx = new EncabezadoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_encabezado);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case H1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(H1);
				setState(40);
				((EncabezadoContext)_localctx).contenido = restoLinea();
				 System.out.println("<h1>" + convertirTexto((((EncabezadoContext)_localctx).contenido!=null?_input.getText(((EncabezadoContext)_localctx).contenido.start,((EncabezadoContext)_localctx).contenido.stop):null)) + "</h1>"); 
				}
				break;
			case H2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(H2);
				setState(44);
				((EncabezadoContext)_localctx).contenido = restoLinea();
				 System.out.println("<h2>" + convertirTexto((((EncabezadoContext)_localctx).contenido!=null?_input.getText(((EncabezadoContext)_localctx).contenido.start,((EncabezadoContext)_localctx).contenido.stop):null)) + "</h2>"); 
				}
				break;
			case H3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(H3);
				setState(48);
				((EncabezadoContext)_localctx).contenido = restoLinea();
				 System.out.println("<h3>" + convertirTexto((((EncabezadoContext)_localctx).contenido!=null?_input.getText(((EncabezadoContext)_localctx).contenido.start,((EncabezadoContext)_localctx).contenido.stop):null)) + "</h3>"); 
				}
				break;
			case H4:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				match(H4);
				setState(52);
				((EncabezadoContext)_localctx).contenido = restoLinea();
				 System.out.println("<h4>" + convertirTexto((((EncabezadoContext)_localctx).contenido!=null?_input.getText(((EncabezadoContext)_localctx).contenido.start,((EncabezadoContext)_localctx).contenido.stop):null)) + "</h4>"); 
				}
				break;
			case H5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				match(H5);
				setState(56);
				((EncabezadoContext)_localctx).contenido = restoLinea();
				 System.out.println("<h5>" + convertirTexto((((EncabezadoContext)_localctx).contenido!=null?_input.getText(((EncabezadoContext)_localctx).contenido.start,((EncabezadoContext)_localctx).contenido.stop):null)) + "</h5>"); 
				}
				break;
			case H6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				match(H6);
				setState(60);
				((EncabezadoContext)_localctx).contenido = restoLinea();
				 System.out.println("<h6>" + convertirTexto((((EncabezadoContext)_localctx).contenido!=null?_input.getText(((EncabezadoContext)_localctx).contenido.start,((EncabezadoContext)_localctx).contenido.stop):null)) + "</h6>"); 
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
	public static class LineaHorizontalContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(GalanHernandezParser.NEWLINE, 0); }
		public TerminalNode HR() { return getToken(GalanHernandezParser.HR, 0); }
		public TerminalNode DOUBLE_HR() { return getToken(GalanHernandezParser.DOUBLE_HR, 0); }
		public LineaHorizontalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineaHorizontal; }
	}

	public final LineaHorizontalContext lineaHorizontal() throws RecognitionException {
		LineaHorizontalContext _localctx = new LineaHorizontalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lineaHorizontal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==DOUBLE_HR || _la==HR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(66);
			match(NEWLINE);
			 System.out.println("<hr/>"); 
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
	public static class CitaContext extends ParserRuleContext {
		public RestoLineaContext contenido;
		public TerminalNode BLOCKQUOTE() { return getToken(GalanHernandezParser.BLOCKQUOTE, 0); }
		public RestoLineaContext restoLinea() {
			return getRuleContext(RestoLineaContext.class,0);
		}
		public CitaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cita; }
	}

	public final CitaContext cita() throws RecognitionException {
		CitaContext _localctx = new CitaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(BLOCKQUOTE);
			setState(70);
			((CitaContext)_localctx).contenido = restoLinea();
			 System.out.println("<blockquote>" + convertirTexto((((CitaContext)_localctx).contenido!=null?_input.getText(((CitaContext)_localctx).contenido.start,((CitaContext)_localctx).contenido.stop):null)) + "</blockquote>"); 
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
	public static class BloquecodigoContext extends ParserRuleContext {
		public Token CODE_BLOCK;
		public TerminalNode CODE_BLOCK() { return getToken(GalanHernandezParser.CODE_BLOCK, 0); }
		public BloquecodigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloquecodigo; }
	}

	public final BloquecodigoContext bloquecodigo() throws RecognitionException {
		BloquecodigoContext _localctx = new BloquecodigoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloquecodigo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((BloquecodigoContext)_localctx).CODE_BLOCK = match(CODE_BLOCK);

			        String textoCompleto = (((BloquecodigoContext)_localctx).CODE_BLOCK!=null?((BloquecodigoContext)_localctx).CODE_BLOCK.getText():null);
			        String codigoLimpio = textoCompleto.substring(4, textoCompleto.length()-4).trim();
			        System.out.println("<pre><code>");
			        System.out.print(codigoLimpio);
			        System.out.println("</code></pre>");
			    
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
	public static class ListaContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(GalanHernandezParser.NEWLINE, 0); }
		public List<ItemListaContext> itemLista() {
			return getRuleContexts(ItemListaContext.class);
		}
		public ItemListaContext itemLista(int i) {
			return getRuleContext(ItemListaContext.class,i);
		}
		public ListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista; }
	}

	public final ListaContext lista() throws RecognitionException {
		ListaContext _localctx = new ListaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 System.out.println("<ul>"); 
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				itemLista();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LIST_START );
			setState(82);
			match(NEWLINE);
			 System.out.println("</ul>"); 
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
	public static class ItemListaContext extends ParserRuleContext {
		public RestoLineaContext contenido;
		public TerminalNode LIST_START() { return getToken(GalanHernandezParser.LIST_START, 0); }
		public RestoLineaContext restoLinea() {
			return getRuleContext(RestoLineaContext.class,0);
		}
		public ItemListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemLista; }
	}

	public final ItemListaContext itemLista() throws RecognitionException {
		ItemListaContext _localctx = new ItemListaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_itemLista);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(LIST_START);
			setState(86);
			((ItemListaContext)_localctx).contenido = restoLinea();

			        System.out.println("<li>" + convertirTexto((((ItemListaContext)_localctx).contenido!=null?_input.getText(((ItemListaContext)_localctx).contenido.start,((ItemListaContext)_localctx).contenido.stop):null)) + "</li>");
			    
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
	public static class ParrafoContext extends ParserRuleContext {
		public RestoLineaContext contenido;
		public RestoLineaContext restoLinea() {
			return getRuleContext(RestoLineaContext.class,0);
		}
		public ParrafoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parrafo; }
	}

	public final ParrafoContext parrafo() throws RecognitionException {
		ParrafoContext _localctx = new ParrafoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parrafo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			((ParrafoContext)_localctx).contenido = restoLinea();

			        String textoHTML = convertirTexto((((ParrafoContext)_localctx).contenido!=null?_input.getText(((ParrafoContext)_localctx).contenido.start,((ParrafoContext)_localctx).contenido.stop):null));
			        if (textoHTML != null && !textoHTML.trim().isEmpty()) {
			            System.out.println("<p>" + textoHTML + "</p>");
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
	public static class RestoLineaContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(GalanHernandezParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GalanHernandezParser.NEWLINE, i);
		}
		public RestoLineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restoLinea; }
	}

	public final RestoLineaContext restoLinea() throws RecognitionException {
		RestoLineaContext _localctx = new RestoLineaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_restoLinea);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12286L) != 0)) {
				{
				{
				setState(92);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(NEWLINE);
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
		"\u0004\u0001\re\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005\u0000\u0017\b"+
		"\u0000\n\u0000\f\u0000\u001a\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002@\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0004\u0006O\b\u0006\u000b\u0006\f\u0006P\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0005\t^\b\t\n\t\f\ta\t\t\u0001\t\u0001\t\u0001\t\u0000"+
		"\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0002\u0001"+
		"\u0000\t\n\u0001\u0000\f\fh\u0000\u0014\u0001\u0000\u0000\u0000\u0002"+
		"%\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000\u0006A\u0001"+
		"\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nI\u0001\u0000\u0000\u0000"+
		"\fL\u0001\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010Y\u0001"+
		"\u0000\u0000\u0000\u0012_\u0001\u0000\u0000\u0000\u0014\u0018\u0006\u0000"+
		"\uffff\uffff\u0000\u0015\u0017\u0003\u0002\u0001\u0000\u0016\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u0016\u0001"+
		"\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001b\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u001c\u0006"+
		"\u0000\uffff\uffff\u0000\u001c\u001d\u0005\u0000\u0000\u0001\u001d\u0001"+
		"\u0001\u0000\u0000\u0000\u001e&\u0003\u0004\u0002\u0000\u001f&\u0003\u0006"+
		"\u0003\u0000 &\u0003\b\u0004\u0000!&\u0003\n\u0005\u0000\"&\u0003\f\u0006"+
		"\u0000#&\u0003\u0010\b\u0000$&\u0005\f\u0000\u0000%\u001e\u0001\u0000"+
		"\u0000\u0000%\u001f\u0001\u0000\u0000\u0000% \u0001\u0000\u0000\u0000"+
		"%!\u0001\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000"+
		"\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000\u0000\'(\u0005"+
		"\u0006\u0000\u0000()\u0003\u0012\t\u0000)*\u0006\u0002\uffff\uffff\u0000"+
		"*@\u0001\u0000\u0000\u0000+,\u0005\u0005\u0000\u0000,-\u0003\u0012\t\u0000"+
		"-.\u0006\u0002\uffff\uffff\u0000.@\u0001\u0000\u0000\u0000/0\u0005\u0004"+
		"\u0000\u000001\u0003\u0012\t\u000012\u0006\u0002\uffff\uffff\u00002@\u0001"+
		"\u0000\u0000\u000034\u0005\u0003\u0000\u000045\u0003\u0012\t\u000056\u0006"+
		"\u0002\uffff\uffff\u00006@\u0001\u0000\u0000\u000078\u0005\u0002\u0000"+
		"\u000089\u0003\u0012\t\u00009:\u0006\u0002\uffff\uffff\u0000:@\u0001\u0000"+
		"\u0000\u0000;<\u0005\u0001\u0000\u0000<=\u0003\u0012\t\u0000=>\u0006\u0002"+
		"\uffff\uffff\u0000>@\u0001\u0000\u0000\u0000?\'\u0001\u0000\u0000\u0000"+
		"?+\u0001\u0000\u0000\u0000?/\u0001\u0000\u0000\u0000?3\u0001\u0000\u0000"+
		"\u0000?7\u0001\u0000\u0000\u0000?;\u0001\u0000\u0000\u0000@\u0005\u0001"+
		"\u0000\u0000\u0000AB\u0007\u0000\u0000\u0000BC\u0005\f\u0000\u0000CD\u0006"+
		"\u0003\uffff\uffff\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0005\u0007"+
		"\u0000\u0000FG\u0003\u0012\t\u0000GH\u0006\u0004\uffff\uffff\u0000H\t"+
		"\u0001\u0000\u0000\u0000IJ\u0005\u000b\u0000\u0000JK\u0006\u0005\uffff"+
		"\uffff\u0000K\u000b\u0001\u0000\u0000\u0000LN\u0006\u0006\uffff\uffff"+
		"\u0000MO\u0003\u000e\u0007\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RS\u0005\f\u0000\u0000ST\u0006\u0006\uffff\uffff\u0000"+
		"T\r\u0001\u0000\u0000\u0000UV\u0005\b\u0000\u0000VW\u0003\u0012\t\u0000"+
		"WX\u0006\u0007\uffff\uffff\u0000X\u000f\u0001\u0000\u0000\u0000YZ\u0003"+
		"\u0012\t\u0000Z[\u0006\b\uffff\uffff\u0000[\u0011\u0001\u0000\u0000\u0000"+
		"\\^\b\u0001\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\f\u0000\u0000c\u0013\u0001"+
		"\u0000\u0000\u0000\u0005\u0018%?P_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}