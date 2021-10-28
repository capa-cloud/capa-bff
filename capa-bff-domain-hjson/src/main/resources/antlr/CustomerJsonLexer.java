// Generated from CustomerJson.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CustomerJsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, STRING=15, NUMBER=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "STRING", "NUMBER", "INT", 
			"ESC", "UNICODE", "HEX", "SAFECODEPOINT", "EXP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", "':'", "'['", "']'", "'('", "'request'", "'metaData'", 
			"'response'", "')'", "'true'", "'false'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "STRING", "NUMBER", "WS"
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


	public CustomerJsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CustomerJson.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\7\20o\n\20\f\20"+
		"\16\20r\13\20\3\20\3\20\3\21\5\21w\n\21\3\21\3\21\3\21\6\21|\n\21\r\21"+
		"\16\21}\5\21\u0080\n\21\3\21\5\21\u0083\n\21\3\22\3\22\3\22\7\22\u0088"+
		"\n\22\f\22\16\22\u008b\13\22\5\22\u008d\n\22\3\23\3\23\3\23\5\23\u0092"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\5\27"+
		"\u00a0\n\27\3\27\3\27\3\30\6\30\u00a5\n\30\r\30\16\30\u00a6\3\30\3\30"+
		"\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\2%\2\'\2)\2+\2-\2/\23\3\2\n\3\2\62;\3\2\63;\n\2$$\61"+
		"\61^^ddhhppttvv\5\2\62;CHch\5\2\2!$$^^\4\2GGgg\4\2--//\5\2\13\f\17\17"+
		"\"\"\2\u00ae\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\13"+
		"9\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23G\3\2\2\2\25P\3\2\2\2\27"+
		"Y\3\2\2\2\31[\3\2\2\2\33`\3\2\2\2\35f\3\2\2\2\37k\3\2\2\2!v\3\2\2\2#\u008c"+
		"\3\2\2\2%\u008e\3\2\2\2\'\u0093\3\2\2\2)\u0099\3\2\2\2+\u009b\3\2\2\2"+
		"-\u009d\3\2\2\2/\u00a4\3\2\2\2\61\62\7}\2\2\62\4\3\2\2\2\63\64\7.\2\2"+
		"\64\6\3\2\2\2\65\66\7\177\2\2\66\b\3\2\2\2\678\7<\2\28\n\3\2\2\29:\7]"+
		"\2\2:\f\3\2\2\2;<\7_\2\2<\16\3\2\2\2=>\7*\2\2>\20\3\2\2\2?@\7t\2\2@A\7"+
		"g\2\2AB\7s\2\2BC\7w\2\2CD\7g\2\2DE\7u\2\2EF\7v\2\2F\22\3\2\2\2GH\7o\2"+
		"\2HI\7g\2\2IJ\7v\2\2JK\7c\2\2KL\7F\2\2LM\7c\2\2MN\7v\2\2NO\7c\2\2O\24"+
		"\3\2\2\2PQ\7t\2\2QR\7g\2\2RS\7u\2\2ST\7r\2\2TU\7q\2\2UV\7p\2\2VW\7u\2"+
		"\2WX\7g\2\2X\26\3\2\2\2YZ\7+\2\2Z\30\3\2\2\2[\\\7v\2\2\\]\7t\2\2]^\7w"+
		"\2\2^_\7g\2\2_\32\3\2\2\2`a\7h\2\2ab\7c\2\2bc\7n\2\2cd\7u\2\2de\7g\2\2"+
		"e\34\3\2\2\2fg\7p\2\2gh\7w\2\2hi\7n\2\2ij\7n\2\2j\36\3\2\2\2kp\7$\2\2"+
		"lo\5%\23\2mo\5+\26\2nl\3\2\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2"+
		"qs\3\2\2\2rp\3\2\2\2st\7$\2\2t \3\2\2\2uw\7/\2\2vu\3\2\2\2vw\3\2\2\2w"+
		"x\3\2\2\2x\177\5#\22\2y{\7\60\2\2z|\t\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2"+
		"\2\2}~\3\2\2\2~\u0080\3\2\2\2\177y\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082"+
		"\3\2\2\2\u0081\u0083\5-\27\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\"\3\2\2\2\u0084\u008d\7\62\2\2\u0085\u0089\t\3\2\2\u0086\u0088\t\2\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0084\3\2\2\2\u008c"+
		"\u0085\3\2\2\2\u008d$\3\2\2\2\u008e\u0091\7^\2\2\u008f\u0092\t\4\2\2\u0090"+
		"\u0092\5\'\24\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092&\3\2\2\2"+
		"\u0093\u0094\7w\2\2\u0094\u0095\5)\25\2\u0095\u0096\5)\25\2\u0096\u0097"+
		"\5)\25\2\u0097\u0098\5)\25\2\u0098(\3\2\2\2\u0099\u009a\t\5\2\2\u009a"+
		"*\3\2\2\2\u009b\u009c\n\6\2\2\u009c,\3\2\2\2\u009d\u009f\t\7\2\2\u009e"+
		"\u00a0\t\b\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a2\5#\22\2\u00a2.\3\2\2\2\u00a3\u00a5\t\t\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\b\30\2\2\u00a9\60\3\2\2\2\16\2npv}\177\u0082"+
		"\u0089\u008c\u0091\u009f\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}