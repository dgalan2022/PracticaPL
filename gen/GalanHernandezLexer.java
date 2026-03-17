// Generated from C:/Users/diego/OneDrive/Documentos/Universidad URJC/4 ano/2 Cuatri/PL/PracticaCumplimentaria/src/GalanHernandez.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GalanHernandezLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		H6=1, H5=2, H4=3, H3=4, H2=5, H1=6, BLOCKQUOTE=7, LIST_START=8, DOUBLE_HR=9, 
		HR=10, CODE_BLOCK=11, NEWLINE=12, ANY=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"H6", "H5", "H4", "H3", "H2", "H1", "BLOCKQUOTE", "LIST_START", "DOUBLE_HR", 
			"HR", "CODE_BLOCK", "NEWLINE", "ANY"
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


	public GalanHernandezLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GalanHernandez.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\rj\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\tP\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\nW\b\n\u0001\n\u0001\n\u0005\n[\b\n\n\n\f\n^\t\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0003\u000be\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\\\u0000\r\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0000n\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0001\u001b\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005"+
		"*\u0001\u0000\u0000\u0000\u00070\u0001\u0000\u0000\u0000\t5\u0001\u0000"+
		"\u0000\u0000\u000b9\u0001\u0000\u0000\u0000\r<\u0001\u0000\u0000\u0000"+
		"\u000f?\u0001\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000\u0013O"+
		"\u0001\u0000\u0000\u0000\u0015Q\u0001\u0000\u0000\u0000\u0017d\u0001\u0000"+
		"\u0000\u0000\u0019h\u0001\u0000\u0000\u0000\u001b\u001c\u0005#\u0000\u0000"+
		"\u001c\u001d\u0005#\u0000\u0000\u001d\u001e\u0005#\u0000\u0000\u001e\u001f"+
		"\u0005#\u0000\u0000\u001f \u0005#\u0000\u0000 !\u0005#\u0000\u0000!\""+
		"\u0005 \u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005#\u0000\u0000"+
		"$%\u0005#\u0000\u0000%&\u0005#\u0000\u0000&\'\u0005#\u0000\u0000\'(\u0005"+
		"#\u0000\u0000()\u0005 \u0000\u0000)\u0004\u0001\u0000\u0000\u0000*+\u0005"+
		"#\u0000\u0000+,\u0005#\u0000\u0000,-\u0005#\u0000\u0000-.\u0005#\u0000"+
		"\u0000./\u0005 \u0000\u0000/\u0006\u0001\u0000\u0000\u000001\u0005#\u0000"+
		"\u000012\u0005#\u0000\u000023\u0005#\u0000\u000034\u0005 \u0000\u0000"+
		"4\b\u0001\u0000\u0000\u000056\u0005#\u0000\u000067\u0005#\u0000\u0000"+
		"78\u0005 \u0000\u00008\n\u0001\u0000\u0000\u00009:\u0005#\u0000\u0000"+
		":;\u0005 \u0000\u0000;\f\u0001\u0000\u0000\u0000<=\u0005>\u0000\u0000"+
		"=>\u0005 \u0000\u0000>\u000e\u0001\u0000\u0000\u0000?@\u0005-\u0000\u0000"+
		"@A\u0005 \u0000\u0000A\u0010\u0001\u0000\u0000\u0000BC\u0005=\u0000\u0000"+
		"CD\u0005=\u0000\u0000DE\u0005=\u0000\u0000E\u0012\u0001\u0000\u0000\u0000"+
		"FG\u0005*\u0000\u0000GH\u0005*\u0000\u0000HP\u0005*\u0000\u0000IJ\u0005"+
		"-\u0000\u0000JK\u0005-\u0000\u0000KP\u0005-\u0000\u0000LM\u0005_\u0000"+
		"\u0000MN\u0005_\u0000\u0000NP\u0005_\u0000\u0000OF\u0001\u0000\u0000\u0000"+
		"OI\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000P\u0014\u0001\u0000"+
		"\u0000\u0000QR\u0005~\u0000\u0000RS\u0005~\u0000\u0000ST\u0005~\u0000"+
		"\u0000TV\u0001\u0000\u0000\u0000UW\u0005\r\u0000\u0000VU\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\\\u0005\n"+
		"\u0000\u0000Y[\t\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]_\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_`\u0005~\u0000\u0000`a\u0005"+
		"~\u0000\u0000ab\u0005~\u0000\u0000b\u0016\u0001\u0000\u0000\u0000ce\u0005"+
		"\r\u0000\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fg\u0005\n\u0000\u0000g\u0018\u0001\u0000\u0000\u0000"+
		"hi\t\u0000\u0000\u0000i\u001a\u0001\u0000\u0000\u0000\u0005\u0000OV\\"+
		"d\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}