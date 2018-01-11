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
import com.domain.json.JsonCreatorFactory;

@Path("apiserver")
public class ApiResource {

  
  
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getIt(@QueryParam("id") String id, @QueryParam("question") String question) {
//    switch (question) {
//      case "where is my order":
//        JSONObject obj = ResponseDataJson
//        .createResponseDataJson(ResponseDataJson.AVAILABILITY_INTENT_ID, question);
//        return Response.status(200).entity(obj).build();
//
//      case "when will I receive my order":
//        return Response.status(200).entity(
//            ResponseDataJson.createResponseDataJson(ResponseDataJson.DELIVERY_INTENT_ID, question))
//            .build();
//
//      case "what is the price of product":
//        return Response.status(200)
//            .entity(
//                ResponseDataJson.createResponseDataJson(ResponseDataJson.PRICE_INTENT_ID, question))
//            .build();
//
//      default:
//        return Response.status(200).entity("{no answer available}").build();
//
//    }
    return Response.status(200).entity("{}").build();

  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response postIt(String content) throws JSONException {

    
      JsonCreatorFactory creator = new JsonCreatorFactory();
      String response = creator.createResponse(content);
    
    return Response.status(200).entity(response).build();
  }

  
}
