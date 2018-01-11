package com.domain.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

public class JSONDataTest {

  
  String jsonPriceTxt = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"How much is X\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"Price\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";
  
  String jsonAvailabilityTxt = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Do you have product X\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"ProductAvailability\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";
  
  String jsonTraceTxt = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Do you have product X\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"delivery.order.check_status\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";
  
  String jsonTimeTxt = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Do you have product X\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"delivery.order.check_time\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";
  
  String jsonNoResTxt = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Do you have product X\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"no responsing\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";

  String jsonNoResTxtId = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Do you have product\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"no responsing\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";

	@Test
    public void testCreatePriceResponse() {
      JsonCreatorFactory creatorFactory = new JsonCreatorFactory();
      try {
        
        String content = creatorFactory.createResponse(jsonPriceTxt);
        System.out.println(content);
        assertNotNull(content);
        org.codehaus.jettison.json.JSONObject object =
            new org.codehaus.jettison.json.JSONObject(content);
        org.codehaus.jettison.json.JSONObject result =
            (org.codehaus.jettison.json.JSONObject) object.get("result");
        JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        System.out.println(fulfillment.getString("speech"));
        assertEquals(fulfillment.get("speech"), "It will cost 200€");
        
        
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
	@Test
    public void testCreateAvailabiltiesResponse() {
      JsonCreatorFactory creatorFactory = new JsonCreatorFactory();
      try {
        
        String content = creatorFactory.createResponse(jsonAvailabilityTxt);
        assertNotNull(content);
        org.codehaus.jettison.json.JSONObject object =
            new org.codehaus.jettison.json.JSONObject(content);
        org.codehaus.jettison.json.JSONObject result =
            (org.codehaus.jettison.json.JSONObject) object.get("result");
        JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        assertEquals(fulfillment.get("speech"), "Si, Tenemose");
        
        
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
	@Test
    public void testCreateTimeResponse() {
      JsonCreatorFactory creatorFactory = new JsonCreatorFactory();
      try {
        
        String content = creatorFactory.createResponse(jsonTimeTxt);
        assertNotNull(content);
        org.codehaus.jettison.json.JSONObject object =
            new org.codehaus.jettison.json.JSONObject(content);
        org.codehaus.jettison.json.JSONObject result =
            (org.codehaus.jettison.json.JSONObject) object.get("result");
        JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        assertEquals(fulfillment.get("speech"), "It would be at your address tomorrow morning");
        
        
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
	@Test
    public void testCreateTraceResponse() {
      JsonCreatorFactory creatorFactory = new JsonCreatorFactory();
      try {
        
        String content = creatorFactory.createResponse(jsonTraceTxt);
        assertNotNull(content);
        org.codehaus.jettison.json.JSONObject object =
            new org.codehaus.jettison.json.JSONObject(content);
        org.codehaus.jettison.json.JSONObject result =
            (org.codehaus.jettison.json.JSONObject) object.get("result");
        JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        assertEquals(fulfillment.get("speech"), "It has been sent to postOffice");
        
        
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
	@Test
    public void testCreatejsonNoResponse() {
      JsonCreatorFactory creatorFactory = new JsonCreatorFactory();
      try {
        
        String content = creatorFactory.createResponse(jsonNoResTxt);
        assertNotNull(content);
        org.codehaus.jettison.json.JSONObject object =
            new org.codehaus.jettison.json.JSONObject(content);
        org.codehaus.jettison.json.JSONObject result =
            (org.codehaus.jettison.json.JSONObject) object.get("result");
        JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        assertEquals(fulfillment.getString("speech"), "Sorry not Available");
        
        
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
	@Test
    public void testCreatejsonNoResponseID() {
      JsonCreatorFactory creatorFactory = new JsonCreatorFactory();
      try {
        
        String content = creatorFactory.createResponse(jsonNoResTxtId);
        assertNotNull(content);
        org.codehaus.jettison.json.JSONObject object =
            new org.codehaus.jettison.json.JSONObject(content);
        org.codehaus.jettison.json.JSONObject result =
            (org.codehaus.jettison.json.JSONObject) object.get("result");
        JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        assertEquals(fulfillment.getString("speech"), "Sorry not Available");
        
        
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
}
