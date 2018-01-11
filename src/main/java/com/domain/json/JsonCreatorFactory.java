package com.domain.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonCreatorFactory {

  public static final String PRICE_INTENT = "Price";
  public static final String DELIVERY_STATUS_INTENT = "delivery.order.check_status";
  public static final String DELIVERY_TIME_INTENT = "delivery.order.check_time";
  public static final String AVAILABILITY_INTENT = "ProductAvailability";
  public static final String HELLO_INTENT = "Hey there";

  public String createResponse(String content) throws JSONException {

    org.codehaus.jettison.json.JSONObject object =
        new org.codehaus.jettison.json.JSONObject(content);

    org.codehaus.jettison.json.JSONObject result =
        (org.codehaus.jettison.json.JSONObject) object.get("result");
    
    String query = result.getString("resolvedQuery");
    
    org.codehaus.jettison.json.JSONObject metadata =
        (org.codehaus.jettison.json.JSONObject) result.get("metadata");
    
    String intentName = metadata.getString("intentName");
    
    if (query.contains("X")) {
      switch (intentName) {
        case JsonCreatorFactory.PRICE_INTENT:
          return createPriceResponse();
        case JsonCreatorFactory.AVAILABILITY_INTENT:
          return createAvailabilityResponse();
        case JsonCreatorFactory.DELIVERY_STATUS_INTENT:
          return createTraceResponse();
        case JsonCreatorFactory.DELIVERY_TIME_INTENT:
          return createDeliveryTimeResponse();
        default:
            return createNotExistResponse();
      }
    }else if(intentName.equalsIgnoreCase(HELLO_INTENT)) {
        return createHelloResponse();
    }
    else {
      return createNotExistResponse();
    }
  }
  
 private String createHelloResponse() throws JSONException {
    JSONObject result = new JSONObject();
    result.put("speech", "Hola");
    result.put("displayText", "Hola");
    return result.toString();
  }

  private String createPriceResponse() throws JSONException {
    JSONObject result = new JSONObject();
    result.put("speech", "The item will cost 200€");
    result.put("displayText", "The item will cost 200€");
    return result.toString();
  }

  private String createTraceResponse() throws JSONException {
    
    JSONObject result = new JSONObject();
    result.put("speech", "The item has been shipped via the Post Office");
    result.put("displayText", "The item has been shipped via the Post Office");
    return result.toString();
    
  }

  private String createDeliveryTimeResponse() throws JSONException {
    JSONObject result = new JSONObject();
    result.put("speech", "The item will arrive to your shipping address tomorrow morning");
    result.put("displayText", "The item will arrive to your shipping address tomorrow morning");
    return result.toString();
    
  }

  private String createAvailabilityResponse() throws JSONException {
    JSONObject result = new JSONObject();
    result.put("speech", "We are sorry but that product is not currently available");
    result.put("displayText", "We are sorry but that product is not currently available");
    return result.toString();
    
  }

  private String createNotExistResponse() throws JSONException {
    
    JSONObject result = new JSONObject();
    result.put("speech", "We are sorry but that product is not currently available");
    result.put("displayText", "We are sorry but that product is not currently available");
    return result.toString();
    
  }

}
