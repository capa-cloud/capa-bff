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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, STRING=15, NUMBER=16;
	public static final int
		RULE_customerJson = 0, RULE_service = 1, RULE_serviceBody = 2, RULE_requestObj = 3, 
		RULE_requestValue = 4, RULE_requestHeaderObj = 5, RULE_singleRequestHeaderField = 6, 
		RULE_requestBody = 7, RULE_singleRequestField = 8, RULE_responseBody = 9, 
		RULE_singleResponseField = 10, RULE_singleRequestFieldValue = 11, RULE_singleResponseFieldValue = 12, 
		RULE_singlerequestHeaderFieldValue = 13, RULE_value = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"customerJson", "service", "serviceBody", "requestObj", "requestValue", 
			"requestHeaderObj", "singleRequestHeaderField", "requestBody", "singleRequestField", 
			"responseBody", "singleResponseField", "singleRequestFieldValue", "singleResponseFieldValue", 
			"singlerequestHeaderFieldValue", "value"
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
			setState(30);
			match(T__0);
			setState(31);
			service();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(32);
				match(T__1);
				setState(33);
				service();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
			setState(41);
			match(STRING);
			setState(42);
			match(T__3);
			setState(43);
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
			setState(45);
			match(T__4);
			setState(46);
			requestObj();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(47);
				match(T__1);
				setState(48);
				requestObj();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
			setState(56);
			match(STRING);
			setState(57);
			match(T__3);
			setState(58);
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
		public RequestBodyContext requestBody() {
			return getRuleContext(RequestBodyContext.class,0);
		}
		public ResponseBodyContext responseBody() {
			return getRuleContext(ResponseBodyContext.class,0);
		}
		public RequestHeaderObjContext requestHeaderObj() {
			return getRuleContext(RequestHeaderObjContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__6);
			setState(61);
			match(T__7);
			setState(62);
			match(T__3);
			setState(63);
			requestBody();
			setState(64);
			match(T__1);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(65);
				match(T__8);
				setState(66);
				match(T__3);
				setState(67);
				requestHeaderObj();
				setState(68);
				match(T__1);
				}
			}

			setState(72);
			match(T__9);
			setState(73);
			match(T__3);
			setState(74);
			responseBody();
			setState(75);
			match(T__10);
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

	public static class RequestHeaderObjContext extends ParserRuleContext {
		public List<SingleRequestHeaderFieldContext> singleRequestHeaderField() {
			return getRuleContexts(SingleRequestHeaderFieldContext.class);
		}
		public SingleRequestHeaderFieldContext singleRequestHeaderField(int i) {
			return getRuleContext(SingleRequestHeaderFieldContext.class,i);
		}
		public RequestHeaderObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requestHeaderObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterRequestHeaderObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitRequestHeaderObj(this);
		}
	}

	public final RequestHeaderObjContext requestHeaderObj() throws RecognitionException {
		RequestHeaderObjContext _localctx = new RequestHeaderObjContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_requestHeaderObj);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(T__0);
				setState(78);
				singleRequestHeaderField();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(79);
					match(T__1);
					setState(80);
					singleRequestHeaderField();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__0);
				setState(89);
				match(T__2);
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

	public static class SingleRequestHeaderFieldContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public SinglerequestHeaderFieldValueContext singlerequestHeaderFieldValue() {
			return getRuleContext(SinglerequestHeaderFieldValueContext.class,0);
		}
		public SingleRequestHeaderFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleRequestHeaderField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterSingleRequestHeaderField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitSingleRequestHeaderField(this);
		}
	}

	public final SingleRequestHeaderFieldContext singleRequestHeaderField() throws RecognitionException {
		SingleRequestHeaderFieldContext _localctx = new SingleRequestHeaderFieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleRequestHeaderField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(STRING);
			setState(93);
			match(T__3);
			setState(94);
			singlerequestHeaderFieldValue();
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
		enterRule(_localctx, 14, RULE_requestBody);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(T__0);
				setState(97);
				singleRequestField();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(98);
					match(T__1);
					setState(99);
					singleRequestField();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__0);
				setState(108);
				match(T__2);
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

	public static class SingleRequestFieldContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public SingleRequestFieldValueContext singleRequestFieldValue() {
			return getRuleContext(SingleRequestFieldValueContext.class,0);
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
		enterRule(_localctx, 16, RULE_singleRequestField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(STRING);
			setState(112);
			match(T__3);
			setState(113);
			singleRequestFieldValue();
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
		enterRule(_localctx, 18, RULE_responseBody);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(T__0);
				setState(116);
				singleResponseField();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(117);
					match(T__1);
					setState(118);
					singleResponseField();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__0);
				setState(127);
				match(T__2);
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

	public static class SingleResponseFieldContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public SingleResponseFieldValueContext singleResponseFieldValue() {
			return getRuleContext(SingleResponseFieldValueContext.class,0);
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
		enterRule(_localctx, 20, RULE_singleResponseField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(STRING);
			setState(131);
			match(T__3);
			setState(132);
			singleResponseFieldValue();
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

	public static class SingleRequestFieldValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(CustomerJsonParser.NUMBER, 0); }
		public SingleRequestFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleRequestFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterSingleRequestFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitSingleRequestFieldValue(this);
		}
	}

	public final SingleRequestFieldValueContext singleRequestFieldValue() throws RecognitionException {
		SingleRequestFieldValueContext _localctx = new SingleRequestFieldValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_singleRequestFieldValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
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

	public static class SingleResponseFieldValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(CustomerJsonParser.NUMBER, 0); }
		public SingleResponseFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleResponseFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterSingleResponseFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitSingleResponseFieldValue(this);
		}
	}

	public final SingleResponseFieldValueContext singleResponseFieldValue() throws RecognitionException {
		SingleResponseFieldValueContext _localctx = new SingleResponseFieldValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_singleResponseFieldValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
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

	public static class SinglerequestHeaderFieldValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CustomerJsonParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(CustomerJsonParser.NUMBER, 0); }
		public SinglerequestHeaderFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlerequestHeaderFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).enterSinglerequestHeaderFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomerJsonListener ) ((CustomerJsonListener)listener).exitSinglerequestHeaderFieldValue(this);
		}
	}

	public final SinglerequestHeaderFieldValueContext singlerequestHeaderFieldValue() throws RecognitionException {
		SinglerequestHeaderFieldValueContext _localctx = new SinglerequestHeaderFieldValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_singlerequestHeaderFieldValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\7"+
		"\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\64"+
		"\n\4\f\4\16\4\67\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6I\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7T\n\7"+
		"\f\7\16\7W\13\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\7\tg\n\t\f\t\16\tj\13\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\7\13z\n\13\f\13\16\13}\13\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0083\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\16\22\2\u008a"+
		"\2 \3\2\2\2\4+\3\2\2\2\6/\3\2\2\2\b:\3\2\2\2\n>\3\2\2\2\f\\\3\2\2\2\16"+
		"^\3\2\2\2\20o\3\2\2\2\22q\3\2\2\2\24\u0082\3\2\2\2\26\u0084\3\2\2\2\30"+
		"\u0088\3\2\2\2\32\u008a\3\2\2\2\34\u008c\3\2\2\2\36\u008e\3\2\2\2 !\7"+
		"\3\2\2!&\5\4\3\2\"#\7\4\2\2#%\5\4\3\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&"+
		"\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\5\2\2*\3\3\2\2\2+,\7\21\2\2,-\7\6"+
		"\2\2-.\5\6\4\2.\5\3\2\2\2/\60\7\7\2\2\60\65\5\b\5\2\61\62\7\4\2\2\62\64"+
		"\5\b\5\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3"+
		"\2\2\2\67\65\3\2\2\289\7\b\2\29\7\3\2\2\2:;\7\21\2\2;<\7\6\2\2<=\5\n\6"+
		"\2=\t\3\2\2\2>?\7\t\2\2?@\7\n\2\2@A\7\6\2\2AB\5\20\t\2BH\7\4\2\2CD\7\13"+
		"\2\2DE\7\6\2\2EF\5\f\7\2FG\7\4\2\2GI\3\2\2\2HC\3\2\2\2HI\3\2\2\2IJ\3\2"+
		"\2\2JK\7\f\2\2KL\7\6\2\2LM\5\24\13\2MN\7\r\2\2N\13\3\2\2\2OP\7\3\2\2P"+
		"U\5\16\b\2QR\7\4\2\2RT\5\16\b\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2VX\3\2\2\2WU\3\2\2\2XY\7\5\2\2Y]\3\2\2\2Z[\7\3\2\2[]\7\5\2\2\\O\3\2"+
		"\2\2\\Z\3\2\2\2]\r\3\2\2\2^_\7\21\2\2_`\7\6\2\2`a\5\34\17\2a\17\3\2\2"+
		"\2bc\7\3\2\2ch\5\22\n\2de\7\4\2\2eg\5\22\n\2fd\3\2\2\2gj\3\2\2\2hf\3\2"+
		"\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\5\2\2lp\3\2\2\2mn\7\3\2\2np\7\5"+
		"\2\2ob\3\2\2\2om\3\2\2\2p\21\3\2\2\2qr\7\21\2\2rs\7\6\2\2st\5\30\r\2t"+
		"\23\3\2\2\2uv\7\3\2\2v{\5\26\f\2wx\7\4\2\2xz\5\26\f\2yw\3\2\2\2z}\3\2"+
		"\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\5\2\2\177\u0083\3"+
		"\2\2\2\u0080\u0081\7\3\2\2\u0081\u0083\7\5\2\2\u0082u\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\25\3\2\2\2\u0084\u0085\7\21\2\2\u0085\u0086\7\6\2\2\u0086"+
		"\u0087\5\32\16\2\u0087\27\3\2\2\2\u0088\u0089\t\2\2\2\u0089\31\3\2\2\2"+
		"\u008a\u008b\t\2\2\2\u008b\33\3\2\2\2\u008c\u008d\t\2\2\2\u008d\35\3\2"+
		"\2\2\u008e\u008f\t\2\2\2\u008f\37\3\2\2\2\13&\65HU\\ho{\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}