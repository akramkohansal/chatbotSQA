package com.domain.resources;

import static org.junit.Assert.assertEquals;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class MyResourceTest extends JerseyTest {

  String jsonPriceTxt =
      "{\"id\":\"b19b7bb5-f5f6-4ea0-92d9-4df2ef377a08\",\"timestamp\":\"2017-12-30T17:33:17.49Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"How much is X\","
          + "\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{},\"contexts\":[],\"metadata\":{\"intentId\":\"bbcae676-2fa0-4ecf-a39c-7df0ad9745e6\",\"webhookUsed\":\"false\","
          + "\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"Price\"},\"fulfillment\":{\"speech\":\"It will cost djffdjg\",\"messages\":[{\"type\":0,\"speech\":\"It will cost djffdjg\"}]},\"score\":1},"
          + "\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"1252c0c5-68b1-4a71-af00-05c809f6f1a5\"}\n";

  @Override
  protected Application configure() {
    return new ResourceConfig(ApiResource.class);
  }

  /**
   * Test to see that the message "Got it!" is sent in the response.
   */
  @Test
  public void testGetIt() {

    final String responseMsg = target().path("apiserver").queryParam("question", "one")

        .request().get(String.class);

    assertEquals("{}", responseMsg);
  }

  @Test
  public void testPostIt() {

    final Response response = target().path("apiserver")


        .request().post(Entity.entity(jsonPriceTxt, MediaType.APPLICATION_JSON));
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
  }
}
