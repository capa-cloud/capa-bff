// Generated from CustomerJson.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CustomerJsonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, STRING=12, NUMBER=13;
	public static final int
		RULE_customerJson = 0, RULE_service = 1, RULE_serviceBody = 2, RULE_requestObj = 3, 
		RULE_requestValue = 4, RULE_requestBody = 5, RULE_singleRequestField = 6, 
		RULE_responseBody = 7, RULE_singleResponseField = 8, RULE_value = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"customerJson", "service", "serviceBody", "requestObj", "requestValue", 
			"requestBody", "singleRequestField", "responseBody", "singleResponseField", 
			"value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", "':'", "'['", "']'", "'('", "')'", "'true'", 
			"'false'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"STRING", "NUMBER"
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
	public String getGrammarFileName() { return "CustomerJson.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CustomerJsonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CustomerJsonContext extends ParserRuleContext {
		public List<ServiceContext> service() {
			return getRuleContexts(ServiceContext.class);
		}
		public ServiceContext service(int i) {
			return getRuleContext(ServiceContext.class,i);
		}
		public CustomerJsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customerJson; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterCustomerJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitCustomerJson(this);
		}
	}

	public final CustomerJsonContext customerJson() throws RecognitionException {
		CustomerJsonContext _localctx = new CustomerJsonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_customerJson);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__0);
			setState(21);
			service();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(22);
				match(T__1);
				setState(23);
				service();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(T__2);
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

	public static class ServiceContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public ServiceBodyContext serviceBody() {
			return getRuleContext(ServiceBodyContext.class,0);
		}
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitService(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_service);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(STRING);
			setState(32);
			match(T__3);
			setState(33);
			serviceBody();
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

	public static class ServiceBodyContext extends ParserRuleContext {
		public List<RequestObjContext> requestObj() {
			return getRuleContexts(RequestObjContext.class);
		}
		public RequestObjContext requestObj(int i) {
			return getRuleContext(RequestObjContext.class,i);
		}
		public ServiceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterServiceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitServiceBody(this);
		}
	}

	public final ServiceBodyContext serviceBody() throws RecognitionException {
		ServiceBodyContext _localctx = new ServiceBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_serviceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__4);
			setState(36);
			requestObj();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(37);
				match(T__1);
				setState(38);
				requestObj();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(T__5);
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

	public static class RequestObjContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public RequestValueContext requestValue() {
			return getRuleContext(RequestValueContext.class,0);
		}
		public RequestObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requestObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterRequestObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitRequestObj(this);
		}
	}

	public final RequestObjContext requestObj() throws RecognitionException {
		RequestObjContext _localctx = new RequestObjContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_requestObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(STRING);
			setState(47);
			match(T__3);
			setState(48);
			requestValue();
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

	public static class RequestValueContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(CustomerJsonParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(CustomerJsonParser.STRING, i);
		}
		public RequestBodyContext requestBody() {
			return getRuleContext(RequestBodyContext.class,0);
		}
		public ResponseBodyContext responseBody() {
			return getRuleContext(ResponseBodyContext.class,0);
		}
		public RequestValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requestValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterRequestValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitRequestValue(this);
		}
	}

	public final RequestValueContext requestValue() throws RecognitionException {
		RequestValueContext _localctx = new RequestValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_requestValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__6);
			setState(51);
			match(STRING);
			setState(52);
			match(T__3);
			setState(53);
			requestBody();
			setState(54);
			match(T__1);
			setState(55);
			match(STRING);
			setState(56);
			match(T__3);
			setState(57);
			responseBody();
			setState(58);
			match(T__7);
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

	public static class RequestBodyContext extends ParserRuleContext {
		public List<SingleRequestFieldContext> singleRequestField() {
			return getRuleContexts(SingleRequestFieldContext.class);
		}
		public SingleRequestFieldContext singleRequestField(int i) {
			return getRuleContext(SingleRequestFieldContext.class,i);
		}
		public RequestBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requestBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterRequestBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitRequestBody(this);
		}
	}

	public final RequestBodyContext requestBody() throws RecognitionException {
		RequestBodyContext _localctx = new RequestBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_requestBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			singleRequestField();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(62);
				match(T__1);
				setState(63);
				singleRequestField();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(T__2);
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

	public static class SingleRequestFieldContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SingleRequestFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleRequestField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterSingleRequestField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitSingleRequestField(this);
		}
	}

	public final SingleRequestFieldContext singleRequestField() throws RecognitionException {
		SingleRequestFieldContext _localctx = new SingleRequestFieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleRequestField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(STRING);
			setState(72);
			match(T__3);
			setState(73);
			value();
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

	public static class ResponseBodyContext extends ParserRuleContext {
		public List<SingleResponseFieldContext> singleResponseField() {
			return getRuleContexts(SingleResponseFieldContext.class);
		}
		public SingleResponseFieldContext singleResponseField(int i) {
			return getRuleContext(SingleResponseFieldContext.class,i);
		}
		public ResponseBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_responseBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterResponseBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitResponseBody(this);
		}
	}

	public final ResponseBodyContext responseBody() throws RecognitionException {
		ResponseBodyContext _localctx = new ResponseBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_responseBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			singleResponseField();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(77);
				match(T__1);
				setState(78);
				singleResponseField();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__2);
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

	public static class SingleResponseFieldContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SingleResponseFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleResponseField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterSingleResponseField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitSingleResponseField(this);
		}
	}

	public final SingleResponseFieldContext singleResponseField() throws RecognitionException {
		SingleResponseFieldContext _localctx = new SingleResponseFieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_singleResponseField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(STRING);
			setState(87);
			match(T__3);
			setState(88);
			value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(CustomerJsonParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17_\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7C\n\7\f\7\16\7F\13\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\tR\n\t\f\t\16\tU\13\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\3"+
		"\2\13\17\2X\2\26\3\2\2\2\4!\3\2\2\2\6%\3\2\2\2\b\60\3\2\2\2\n\64\3\2\2"+
		"\2\f>\3\2\2\2\16I\3\2\2\2\20M\3\2\2\2\22X\3\2\2\2\24\\\3\2\2\2\26\27\7"+
		"\3\2\2\27\34\5\4\3\2\30\31\7\4\2\2\31\33\5\4\3\2\32\30\3\2\2\2\33\36\3"+
		"\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \7\5"+
		"\2\2 \3\3\2\2\2!\"\7\16\2\2\"#\7\6\2\2#$\5\6\4\2$\5\3\2\2\2%&\7\7\2\2"+
		"&+\5\b\5\2\'(\7\4\2\2(*\5\b\5\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2"+
		"\2,.\3\2\2\2-+\3\2\2\2./\7\b\2\2/\7\3\2\2\2\60\61\7\16\2\2\61\62\7\6\2"+
		"\2\62\63\5\n\6\2\63\t\3\2\2\2\64\65\7\t\2\2\65\66\7\16\2\2\66\67\7\6\2"+
		"\2\678\5\f\7\289\7\4\2\29:\7\16\2\2:;\7\6\2\2;<\5\20\t\2<=\7\n\2\2=\13"+
		"\3\2\2\2>?\7\3\2\2?D\5\16\b\2@A\7\4\2\2AC\5\16\b\2B@\3\2\2\2CF\3\2\2\2"+
		"DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\5\2\2H\r\3\2\2\2IJ\7\16\2"+
		"\2JK\7\6\2\2KL\5\24\13\2L\17\3\2\2\2MN\7\3\2\2NS\5\22\n\2OP\7\4\2\2PR"+
		"\5\22\n\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2"+
		"VW\7\5\2\2W\21\3\2\2\2XY\7\16\2\2YZ\7\6\2\2Z[\5\24\13\2[\23\3\2\2\2\\"+
		"]\t\2\2\2]\25\3\2\2\2\6\34+DS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}