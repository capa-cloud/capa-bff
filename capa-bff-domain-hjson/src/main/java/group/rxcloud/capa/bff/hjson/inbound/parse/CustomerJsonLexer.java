package group.rxcloud.capa.bff.hjson.inbound.parse;// Generated from CustomerJson.g4 by ANTLR 4.9.2
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
			null, "'{'", "','", "'}'", "':'", "'['", "']'", "'('", "'request'", "'requestHeader'", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\7\20t\n\20\f\20\16\20w\13\20\3\20\3\20\3\21\5\21|\n\21\3\21\3\21"+
		"\3\21\6\21\u0081\n\21\r\21\16\21\u0082\5\21\u0085\n\21\3\21\5\21\u0088"+
		"\n\21\3\22\3\22\3\22\7\22\u008d\n\22\f\22\16\22\u0090\13\22\5\22\u0092"+
		"\n\22\3\23\3\23\3\23\5\23\u0097\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\5\27\u00a5\n\27\3\27\3\27\3\30\6\30\u00aa\n"+
		"\30\r\30\16\30\u00ab\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2\'\2)\2+\2-\2/\23"+
		"\3\2\n\3\2\62;\3\2\63;\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\2!$$^^"+
		"\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\2\u00b3\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2"+
		"\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21?"+
		"\3\2\2\2\23G\3\2\2\2\25U\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33e\3\2\2\2\35"+
		"k\3\2\2\2\37p\3\2\2\2!{\3\2\2\2#\u0091\3\2\2\2%\u0093\3\2\2\2\'\u0098"+
		"\3\2\2\2)\u009e\3\2\2\2+\u00a0\3\2\2\2-\u00a2\3\2\2\2/\u00a9\3\2\2\2\61"+
		"\62\7}\2\2\62\4\3\2\2\2\63\64\7.\2\2\64\6\3\2\2\2\65\66\7\177\2\2\66\b"+
		"\3\2\2\2\678\7<\2\28\n\3\2\2\29:\7]\2\2:\f\3\2\2\2;<\7_\2\2<\16\3\2\2"+
		"\2=>\7*\2\2>\20\3\2\2\2?@\7t\2\2@A\7g\2\2AB\7s\2\2BC\7w\2\2CD\7g\2\2D"+
		"E\7u\2\2EF\7v\2\2F\22\3\2\2\2GH\7t\2\2HI\7g\2\2IJ\7s\2\2JK\7w\2\2KL\7"+
		"g\2\2LM\7u\2\2MN\7v\2\2NO\7J\2\2OP\7g\2\2PQ\7c\2\2QR\7f\2\2RS\7g\2\2S"+
		"T\7t\2\2T\24\3\2\2\2UV\7t\2\2VW\7g\2\2WX\7u\2\2XY\7r\2\2YZ\7q\2\2Z[\7"+
		"p\2\2[\\\7u\2\2\\]\7g\2\2]\26\3\2\2\2^_\7+\2\2_\30\3\2\2\2`a\7v\2\2ab"+
		"\7t\2\2bc\7w\2\2cd\7g\2\2d\32\3\2\2\2ef\7h\2\2fg\7c\2\2gh\7n\2\2hi\7u"+
		"\2\2ij\7g\2\2j\34\3\2\2\2kl\7p\2\2lm\7w\2\2mn\7n\2\2no\7n\2\2o\36\3\2"+
		"\2\2pu\7$\2\2qt\5%\23\2rt\5+\26\2sq\3\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2"+
		"\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7$\2\2y \3\2\2\2z|\7/\2\2{z\3\2\2"+
		"\2{|\3\2\2\2|}\3\2\2\2}\u0084\5#\22\2~\u0080\7\60\2\2\177\u0081\t\2\2"+
		"\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084~\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0088\5-\27\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\"\3\2\2\2\u0089\u0092\7\62\2\2\u008a\u008e\t\3\2\2\u008b\u008d"+
		"\t\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0089\3\2"+
		"\2\2\u0091\u008a\3\2\2\2\u0092$\3\2\2\2\u0093\u0096\7^\2\2\u0094\u0097"+
		"\t\4\2\2\u0095\u0097\5\'\24\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2"+
		"\u0097&\3\2\2\2\u0098\u0099\7w\2\2\u0099\u009a\5)\25\2\u009a\u009b\5)"+
		"\25\2\u009b\u009c\5)\25\2\u009c\u009d\5)\25\2\u009d(\3\2\2\2\u009e\u009f"+
		"\t\5\2\2\u009f*\3\2\2\2\u00a0\u00a1\n\6\2\2\u00a1,\3\2\2\2\u00a2\u00a4"+
		"\t\7\2\2\u00a3\u00a5\t\b\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\5#\22\2\u00a7.\3\2\2\2\u00a8\u00aa\t\t\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\30\2\2\u00ae\60\3\2\2\2\16"+
		"\2su{\u0082\u0084\u0087\u008e\u0091\u0096\u00a4\u00ab\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}