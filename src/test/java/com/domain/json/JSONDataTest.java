package com.domain.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

public class JSONDataTest {

  JsonCreatorFactory creatorFactory = new JsonCreatorFactory();

  
  String jsonHelloTxt = "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Hey there\","
      + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
      + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"Hey there\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
      + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";
  
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

  
  @Test(expected = JSONException.class)
  public void testCreateHelloResponse() throws JSONException {
    
    String content = creatorFactory.createResponse(jsonHelloTxt);
    assertNotNull(content);
    org.codehaus.jettison.json.JSONObject object =
        new org.codehaus.jettison.json.JSONObject(content);
    assertEquals(object.get("speech"), "Hola");
      
  }
  
	@Test(expected = JSONException.class)
    public void testCreatePriceResponse() throws JSONException {
        
      String content = creatorFactory.createResponse(jsonPriceTxt);
      assertNotNull(content);
      org.codehaus.jettison.json.JSONObject object =
          new org.codehaus.jettison.json.JSONObject(content);
      assertEquals(object.get("speech"), "The item will cost 200€");
        
    }
	
	@Test(expected = JSONException.class)
    public void testCreateAvailabiltiesResponse() throws JSONException {
        
      String content = creatorFactory.createResponse(jsonAvailabilityTxt);
      assertNotNull(content);
      org.codehaus.jettison.json.JSONObject object =
          new org.codehaus.jettison.json.JSONObject(content);
      assertEquals(object.get("speech"), "We are sorry but that product is not currently available");
    }
	
	@Test(expected = JSONException.class)
    public void testCreateDeliveryTimeResponse() throws JSONException {
        
      String content = creatorFactory.createResponse(jsonTimeTxt);
      assertNotNull(content);
      org.codehaus.jettison.json.JSONObject object =
          new org.codehaus.jettison.json.JSONObject(content);
      assertEquals(object.get("speech"), "The item will arrive to your shipping address tomorrow morning");
    }
	
	@Test(expected = JSONException.class)
    public void testCreateTraceResponse() throws JSONException {

	  String content = creatorFactory.createResponse(jsonTraceTxt);
      assertNotNull(content);
      org.codehaus.jettison.json.JSONObject object =
          new org.codehaus.jettison.json.JSONObject(content);
      assertEquals(object.get("speech"), "The item has been shipped via the Post Office");
    }
	
	@Test(expected = JSONException.class)
    public void testCreatejsonNoResponse() throws JSONException {
        
      String content = creatorFactory.createResponse(jsonNoResTxt);
      assertNotNull(content);
      org.codehaus.jettison.json.JSONObject object =
          new org.codehaus.jettison.json.JSONObject(content);
      assertEquals(object.getString("speech"), "We are sorry but that product is not currently available");
        
    }
	
	@Test(expected = JSONException.class)
    public void testCreatejsonNoResponseID() throws JSONException {
        
      String content = creatorFactory.createResponse(jsonNoResTxtId);
      assertNotNull(content);
      org.codehaus.jettison.json.JSONObject object =
          new org.codehaus.jettison.json.JSONObject(content);
      assertEquals(object.getString("speech"), "We are sorry but that product is not currently available");
        
    }
}
