package com.domain.json;

import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseDataJson {

  public static final String PRICE_INTENT_ID = "bbcae676-2fa0-4ecf-a39c-7df0ad9745e6";

  public static final String DELIVERY_INTENT_ID = "31df1536-e668-4419-addc-0da85994b391";

  public static final String AVAILABILITY_INTENT_ID = "81ca96ff-d3f5-4cbe-8804-85505537ea17";


  public static JSONObject createResponseDataJson(String intentId, String intentName) {
    JSONObject response = new JSONObject();

    response.put("id", UUID.randomUUID().toString());
    response.put("timestamp", (new Date()).toString());
    response.put("lang", "en");
    response.put("sessionId", UUID.randomUUID().toString());
    response.put("result", creatResult(intentId, intentName));

    return response;

  }

  /*
   * { "id": "b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08", "timestamp": "2017-12-30T17:33:17.49Z", "lang":
   * "en", "result": { "source": "agent", "resolvedQuery": "How much is x", "action": "",
   * "actionIncomplete": false, "parameters": {}, "contexts": [], "metadata": { "intentId":
   * "bbcae676-2fa0-4ecf-a39c-7df0ad9745e6", "webhookUsed": "false", "webhookForSlotFillingUsed":
   * "false", "intentName": "Price" }, "fulfillment": { "speech": "It will cost $$$$$$$$$",
   * "messages": [ { "type": 0, "speech": "It will cost $$$$$$$$$" } ] }, "score": 1 }, "status": {
   * "code": 200, "errorType": "success", "webhookTimedOut": false }, "sessionId":
   * "1252c0c5-68b1-4a71-af00-05c809f6f1a5" }
   */

  public static JSONObject Status() {

    JSONObject status = new JSONObject();
    status.put("code", 200);
    status.put("errorType", "success");
    status.put("webhookTimedOut", false);
    return status;

  }

  public static JSONObject creatResult(String intentId, String intentName) {

    JSONObject result = new JSONObject();
    result.put("source", "agent");
    result.put("resolvedQuery", intentName);
    result.put("action", "");
    result.put("actionIncomplete", false);
    result.put("parameters", new JSONObject());
    result.put("contexts", new JSONArray());
    result.put("score", 1);
    result.put("metadata", createMetadata(intentId, intentName));
    result.put("fulfillment", createFulfillment(intentName));

    return result;

  }

  public static JSONObject createMetadata(String intentId, String intentName) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("intentId", intentId);
    jsonObject.put("intentName", intentName);
    jsonObject.put("webhookUsed", "false");
    jsonObject.put("webhookForSlotFillingUsed", "false");
    return jsonObject;
  }

  public static JSONObject createFulfillment(String speech) {
    JSONObject jsonObject = new JSONObject();

    jsonObject.put("speech", speech);
    JSONArray array = new JSONArray();
    JSONObject innerObject = new JSONObject();
    innerObject.put("type", 0);
    innerObject.put("speech", speech);
    array.put(innerObject);

    jsonObject.put("messages", array);

    return jsonObject;
  }
}
