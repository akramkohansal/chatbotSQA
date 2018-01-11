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
          createPriceResponse(result);
          break ;
        case JsonCreatorFactory.AVAILABILITY_INTENT:
          createAvailabilityResponse(result);
          break ;
        case JsonCreatorFactory.DELIVERY_STATUS_INTENT:
          createTraceResponse(result);
          break ;
        case JsonCreatorFactory.DELIVERY_TIME_INTENT:
          createDeliveryTimeResponse(result);
          break ;
        default:
            createNotExistResponse(result);
            break ;
      }
    }else {
      createNotExistResponse(result);
    }
    return object.toString();
  }


  private void createPriceResponse(JSONObject result) throws JSONException {
    JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
    fulfillment.put("speech", "It will cost 200€");
    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
    org.codehaus.jettison.json.JSONObject msg =
        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
    msg.put("speech", "It will cost 200€");
  }

  private void createTraceResponse(JSONObject result) throws JSONException {
    org.codehaus.jettison.json.JSONObject fulfillment =
        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
    fulfillment.put("speech", "It has been sent to postOffice");
    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
    org.codehaus.jettison.json.JSONObject msg =
        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
    msg.put("speech", "It has been sent to postOffice");
  }

  private void createDeliveryTimeResponse(JSONObject result) throws JSONException {
    org.codehaus.jettison.json.JSONObject fulfillment =
        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
    fulfillment.put("speech", "It would be at your address tomorrow morning");
    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
    org.codehaus.jettison.json.JSONObject msg =
        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
    msg.put("speech", "It would be at your address tomorrow morning");
  }

  private void createAvailabilityResponse(JSONObject result) throws JSONException {
    org.codehaus.jettison.json.JSONObject fulfillment =
        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
    fulfillment.put("speech", "Si, Tenemose");
    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
    org.codehaus.jettison.json.JSONObject msg =
        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
    msg.put("speech", "Si, Tenemose");
  }

  private void createNotExistResponse(JSONObject result) throws JSONException {
    org.codehaus.jettison.json.JSONObject fulfillment =
        (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
    fulfillment.put("speech", "Sorry not Available");
    org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
    org.codehaus.jettison.json.JSONObject msg =
        (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
    msg.put("speech", "Sorry not Available Answer");
  }

}
