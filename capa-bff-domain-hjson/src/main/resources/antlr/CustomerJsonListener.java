// Generated from CustomerJson.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CustomerJsonParser}.
 */
public interface CustomerJsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#customerJson}.
	 * @param ctx the parse tree
	 */
	void enterCustomerJson(CustomerJsonParser.CustomerJsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#customerJson}.
	 * @param ctx the parse tree
	 */
	void exitCustomerJson(CustomerJsonParser.CustomerJsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(CustomerJsonParser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(CustomerJsonParser.ServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#serviceId}.
	 * @param ctx the parse tree
	 */
	void enterServiceId(CustomerJsonParser.ServiceIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#serviceId}.
	 * @param ctx the parse tree
	 */
	void exitServiceId(CustomerJsonParser.ServiceIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#serviceBody}.
	 * @param ctx the parse tree
	 */
	void enterServiceBody(CustomerJsonParser.ServiceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#serviceBody}.
	 * @param ctx the parse tree
	 */
	void exitServiceBody(CustomerJsonParser.ServiceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestObj}.
	 * @param ctx the parse tree
	 */
	void enterRequestObj(CustomerJsonParser.RequestObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestObj}.
	 * @param ctx the parse tree
	 */
	void exitRequestObj(CustomerJsonParser.RequestObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestId}.
	 * @param ctx the parse tree
	 */
	void enterRequestId(CustomerJsonParser.RequestIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestId}.
	 * @param ctx the parse tree
	 */
	void exitRequestId(CustomerJsonParser.RequestIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestValue}.
	 * @param ctx the parse tree
	 */
	void enterRequestValue(CustomerJsonParser.RequestValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestValue}.
	 * @param ctx the parse tree
	 */
	void exitRequestValue(CustomerJsonParser.RequestValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestHeaderObj}.
	 * @param ctx the parse tree
	 */
	void enterRequestHeaderObj(CustomerJsonParser.RequestHeaderObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestHeaderObj}.
	 * @param ctx the parse tree
	 */
	void exitRequestHeaderObj(CustomerJsonParser.RequestHeaderObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#singleRequestHeaderField}.
	 * @param ctx the parse tree
	 */
	void enterSingleRequestHeaderField(CustomerJsonParser.SingleRequestHeaderFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#singleRequestHeaderField}.
	 * @param ctx the parse tree
	 */
	void exitSingleRequestHeaderField(CustomerJsonParser.SingleRequestHeaderFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestBody}.
	 * @param ctx the parse tree
	 */
	void enterRequestBody(CustomerJsonParser.RequestBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestBody}.
	 * @param ctx the parse tree
	 */
	void exitRequestBody(CustomerJsonParser.RequestBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterRequestBodyItem(CustomerJsonParser.RequestBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitRequestBodyItem(CustomerJsonParser.RequestBodyItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#singleRequestField}.
	 * @param ctx the parse tree
	 */
	void enterSingleRequestField(CustomerJsonParser.SingleRequestFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#singleRequestField}.
	 * @param ctx the parse tree
	 */
	void exitSingleRequestField(CustomerJsonParser.SingleRequestFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestJson}.
	 * @param ctx the parse tree
	 */
	void enterRequestJson(CustomerJsonParser.RequestJsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestJson}.
	 * @param ctx the parse tree
	 */
	void exitRequestJson(CustomerJsonParser.RequestJsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(CustomerJsonParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(CustomerJsonParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(CustomerJsonParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(CustomerJsonParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(CustomerJsonParser.ArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(CustomerJsonParser.ArrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#responseBody}.
	 * @param ctx the parse tree
	 */
	void enterResponseBody(CustomerJsonParser.ResponseBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#responseBody}.
	 * @param ctx the parse tree
	 */
	void exitResponseBody(CustomerJsonParser.ResponseBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#singleResponseField}.
	 * @param ctx the parse tree
	 */
	void enterSingleResponseField(CustomerJsonParser.SingleResponseFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#singleResponseField}.
	 * @param ctx the parse tree
	 */
	void exitSingleResponseField(CustomerJsonParser.SingleResponseFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#singleRequestFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterSingleRequestFieldValue(CustomerJsonParser.SingleRequestFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#singleRequestFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitSingleRequestFieldValue(CustomerJsonParser.SingleRequestFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#singleResponseFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterSingleResponseFieldValue(CustomerJsonParser.SingleResponseFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#singleResponseFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitSingleResponseFieldValue(CustomerJsonParser.SingleResponseFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#singlerequestHeaderFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterSinglerequestHeaderFieldValue(CustomerJsonParser.SinglerequestHeaderFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#singlerequestHeaderFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitSinglerequestHeaderFieldValue(CustomerJsonParser.SinglerequestHeaderFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CustomerJsonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CustomerJsonParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestHeaderObjValue}.
	 * @param ctx the parse tree
	 */
	void enterRequestHeaderObjValue(CustomerJsonParser.RequestHeaderObjValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestHeaderObjValue}.
	 * @param ctx the parse tree
	 */
	void exitRequestHeaderObjValue(CustomerJsonParser.RequestHeaderObjValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestHeaderPair}.
	 * @param ctx the parse tree
	 */
	void enterRequestHeaderPair(CustomerJsonParser.RequestHeaderPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestHeaderPair}.
	 * @param ctx the parse tree
	 */
	void exitRequestHeaderPair(CustomerJsonParser.RequestHeaderPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerJsonParser#requestHeaderArr}.
	 * @param ctx the parse tree
	 */
	void enterRequestHeaderArr(CustomerJsonParser.RequestHeaderArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#requestHeaderArr}.
	 * @param ctx the parse tree
	 */
	void exitRequestHeaderArr(CustomerJsonParser.RequestHeaderArrContext ctx);
}