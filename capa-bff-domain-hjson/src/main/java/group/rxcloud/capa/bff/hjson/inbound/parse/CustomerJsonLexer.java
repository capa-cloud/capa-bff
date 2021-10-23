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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, STRING=15, NUMBER=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "STRING", "ESC", "SAFECODEPOINT", 
			"NUMBER", "HEX", "UNICODE", "INT", "EXP"
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
			null, null, null, "STRING", "NUMBER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\7\20r"+
		"\n\20\f\20\16\20u\13\20\3\20\3\20\3\21\3\21\3\21\5\21|\n\21\3\22\3\22"+
		"\3\23\5\23\u0081\n\23\3\23\3\23\3\23\6\23\u0086\n\23\r\23\16\23\u0087"+
		"\5\23\u008a\n\23\3\23\5\23\u008d\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\7\26\u009a\n\26\f\26\16\26\u009d\13\26\5\26\u009f"+
		"\n\26\3\27\3\27\5\27\u00a3\n\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\2%\22\'\2)"+
		"\2+\2-\2\3\2\t\n\2$$\61\61^^ddhhppttvv\5\2\2!$$^^\3\2\62;\5\2\62;CHch"+
		"\3\2\63;\4\2GGgg\4\2--//\2\u00a9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2%\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2"+
		"\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23E\3\2\2\2\25S"+
		"\3\2\2\2\27\\\3\2\2\2\31^\3\2\2\2\33c\3\2\2\2\35i\3\2\2\2\37n\3\2\2\2"+
		"!x\3\2\2\2#}\3\2\2\2%\u0080\3\2\2\2\'\u008e\3\2\2\2)\u0090\3\2\2\2+\u009e"+
		"\3\2\2\2-\u00a0\3\2\2\2/\60\7}\2\2\60\4\3\2\2\2\61\62\7.\2\2\62\6\3\2"+
		"\2\2\63\64\7\177\2\2\64\b\3\2\2\2\65\66\7<\2\2\66\n\3\2\2\2\678\7]\2\2"+
		"8\f\3\2\2\29:\7_\2\2:\16\3\2\2\2;<\7*\2\2<\20\3\2\2\2=>\7t\2\2>?\7g\2"+
		"\2?@\7s\2\2@A\7w\2\2AB\7g\2\2BC\7u\2\2CD\7v\2\2D\22\3\2\2\2EF\7t\2\2F"+
		"G\7g\2\2GH\7s\2\2HI\7w\2\2IJ\7g\2\2JK\7u\2\2KL\7v\2\2LM\7J\2\2MN\7g\2"+
		"\2NO\7c\2\2OP\7f\2\2PQ\7g\2\2QR\7t\2\2R\24\3\2\2\2ST\7t\2\2TU\7g\2\2U"+
		"V\7u\2\2VW\7r\2\2WX\7q\2\2XY\7p\2\2YZ\7u\2\2Z[\7g\2\2[\26\3\2\2\2\\]\7"+
		"+\2\2]\30\3\2\2\2^_\7v\2\2_`\7t\2\2`a\7w\2\2ab\7g\2\2b\32\3\2\2\2cd\7"+
		"h\2\2de\7c\2\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h\34\3\2\2\2ij\7p\2\2jk\7w\2"+
		"\2kl\7n\2\2lm\7n\2\2m\36\3\2\2\2ns\7$\2\2or\5!\21\2pr\5#\22\2qo\3\2\2"+
		"\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7$\2"+
		"\2w \3\2\2\2x{\7^\2\2y|\t\2\2\2z|\5)\25\2{y\3\2\2\2{z\3\2\2\2|\"\3\2\2"+
		"\2}~\n\3\2\2~$\3\2\2\2\177\u0081\7/\2\2\u0080\177\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0089\5+\26\2\u0083\u0085\7\60\2\2"+
		"\u0084\u0086\t\4\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0083\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u008d\5-\27\2\u008c\u008b\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d&\3\2\2\2\u008e\u008f\t\5\2\2\u008f(\3\2"+
		"\2\2\u0090\u0091\7w\2\2\u0091\u0092\5\'\24\2\u0092\u0093\5\'\24\2\u0093"+
		"\u0094\5\'\24\2\u0094\u0095\5\'\24\2\u0095*\3\2\2\2\u0096\u009f\7\62\2"+
		"\2\u0097\u009b\t\6\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2\2\u009a\u009d"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u0097\3\2\2\2\u009f,\3\2\2\2"+
		"\u00a0\u00a2\t\7\2\2\u00a1\u00a3\t\b\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\5+\26\2\u00a5.\3\2\2\2\r\2qs"+
		"{\u0080\u0087\u0089\u008c\u009b\u009e\u00a2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}