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
	 * Enter a parse tree produced by {@link CustomerJsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CustomerJsonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerJsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CustomerJsonParser.ValueContext ctx);
}