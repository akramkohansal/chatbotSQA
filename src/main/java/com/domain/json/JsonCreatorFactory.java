package com.domain.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonCreatorFactory {

  public static final String PRICE_INTENT = "Price";
  public static final String DELIVERY_STATUS_INTENT = "delivery.order.check_status";
  public static final String DELIVERY_TIME_INTENT = "delivery.order.check_time";
  public static final String AVAILABILITY_INTENT = "ProductAvailability";
  

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
    }else {
      return createNotExistResponse();
    }
  }


  private String createPriceResponse() throws JSONException {
    
    JSONObject result = new JSONObject();
    result.put("speech", "It will cost 200€");
    result.put("displayText", "It will cost 200€");
    return result.toString();
//    JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
//    fulfillment.put("speech", "It will cost 200€");
//    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
//    org.codehaus.jettison.json.JSONObject msg =
//        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
//    msg.put("speech", "It will cost 200€");
  }

  private String createTraceResponse() throws JSONException {
    
    JSONObject result = new JSONObject();
    result.put("speech", "It has been sent to postOffice");
    result.put("displayText", "It has been sent to postOffice€");
    return result.toString();
    
//    org.codehaus.jettison.json.JSONObject fulfillment =
//        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
//    fulfillment.put("speech", "It has been sent to postOffice");
//    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
//    org.codehaus.jettison.json.JSONObject msg =
//        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
//    msg.put("speech", "It has been sent to postOffice");
  }

  private String createDeliveryTimeResponse() throws JSONException {
    JSONObject result = new JSONObject();
    result.put("speech", "It has been sent to postOffice");
    result.put("displayText", "It has been sent to postOffice");
    return result.toString();
    
//    org.codehaus.jettison.json.JSONObject fulfillment =
//        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
//    fulfillment.put("speech", "It would be at your address tomorrow morning");
//    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
//    org.codehaus.jettison.json.JSONObject msg =
//        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
//    msg.put("speech", "It would be at your address tomorrow morning");
  }

  private String createAvailabilityResponse() throws JSONException {
    JSONObject result = new JSONObject();
    result.put("speech", "Si, Tenemosee");
    result.put("displayText", "Si, Tenemose");
    return result.toString();
    
//    org.codehaus.jettison.json.JSONObject fulfillment =
//        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
//    fulfillment.put("speech", "Si, Tenemose");
//    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
//    org.codehaus.jettison.json.JSONObject msg =
//        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
//    msg.put("speech", "Si, Tenemose");
  }

  private String createNotExistResponse() throws JSONException {
    
    JSONObject result = new JSONObject();
    result.put("speech", "Si, Tenemosee");
    result.put("displayText", "Si, Tenemose");
    return result.toString();
    
//    org.codehaus.jettison.json.JSONObject fulfillment =
//        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
//    fulfillment.put("speech", "Sorry not Available");
//    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
//    org.codehaus.jettison.json.JSONObject msg =
//        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
//    msg.put("speech", "Sorry not Available Answer");
  }

}
