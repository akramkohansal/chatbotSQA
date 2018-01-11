package com.domain.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.json.JSONObject;
import com.domain.json.ResponseDataJson;

@Path("apiserver")
public class ApiResource {

  
  public static final String PRICE_INTENT = "price";
  public static final String DELIVERY_STATUS_INTENT = "delivery.order.check_status";
  public static final String DELIVERY_TIME_INTENT = "delivery.order.check_time";
  public static final String AVAILABILITY_INTENT = "ProductAvailability7";
  
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getIt(@QueryParam("id") String id, @QueryParam("question") String question) {
    switch (question) {
      case "where is my order":
        JSONObject obj = ResponseDataJson
        .createResponseDataJson(ResponseDataJson.AVAILABILITY_INTENT_ID, question);
        return Response.status(200).entity(obj).build();

      case "when will I receive my order":
        return Response.status(200).entity(
            ResponseDataJson.createResponseDataJson(ResponseDataJson.DELIVERY_INTENT_ID, question))
            .build();

      case "what is the price of product":
        return Response.status(200)
            .entity(
                ResponseDataJson.createResponseDataJson(ResponseDataJson.PRICE_INTENT_ID, question))
            .build();

      default:
        return Response.status(200).entity("{no answer available}").build();

    }

  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response postIt(String content) {

    org.codehaus.jettison.json.JSONObject object = null;
    try {
      object = new org.codehaus.jettison.json.JSONObject(content);
      
      org.codehaus.jettison.json.JSONObject result = (org.codehaus.jettison.json.JSONObject) object.get("result");
      String query = result.getString("resolvedQuery");
      org.codehaus.jettison.json.JSONObject metadata = (org.codehaus.jettison.json.JSONObject) result.get("metadata");
      String intentName = metadata.getString("intentName");
      if(ApiResource.PRICE_INTENT.equalsIgnoreCase(intentName)) {
        if (query.contains("X")) {
          org.codehaus.jettison.json.JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
          fulfillment.put("speech", "It will cost 200€");
          org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
          org.codehaus.jettison.json.JSONObject msg = (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
          msg.put("speech", "It will cost 200€");
        }
      }
      else if(ApiResource.DELIVERY_STATUS_INTENT.equalsIgnoreCase(intentName)) {
        if (query.contains("X")){ 
        org.codehaus.jettison.json.JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        fulfillment.put("speech", "It has been sent to postOffice");
        org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
        org.codehaus.jettison.json.JSONObject msg = (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
        msg.put("speech", "It has been sent to postOffice");
      }
        
      }
      else if(ApiResource.DELIVERY_TIME_INTENT.equalsIgnoreCase(intentName)) {
        if (query.contains("X")) {
          org.codehaus.jettison.json.JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
          fulfillment.put("speech", "It would be at your address tomorrow morning");
          org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
          org.codehaus.jettison.json.JSONObject msg = (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
          msg.put("speech", "It would be at your address tomorrow morning");
        }
      }
      else if(ApiResource.AVAILABILITY_INTENT.equalsIgnoreCase(intentName)) {
        if (query.contains("X")) {
          org.codehaus.jettison.json.JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
          fulfillment.put("speech", "Si, Tenemose");
          org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
          org.codehaus.jettison.json.JSONObject msg = (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
          msg.put("speech", "Si, Tenemose");
        }
      }
      else {
        org.codehaus.jettison.json.JSONObject fulfillment = (org.codehaus.jettison.json.JSONObject) result.get("fulfillment");
        fulfillment.put("speech", "Sorry not Available");
        org.codehaus.jettison.json.JSONArray msgArray = fulfillment.getJSONArray("messages");
        org.codehaus.jettison.json.JSONObject msg = (org.codehaus.jettison.json.JSONObject) msgArray.get(0);
        msg.put("speech", "Sorry not Available");
      }
      
    } catch (JSONException e) {
      e.printStackTrace();
    }
    
    String str = object.toString();
    //System.out.println(str);
    return Response.status(200).entity(str).build();
  }

  /**
   * where is my order when will I receive my orders what is the price of product
   */
}
