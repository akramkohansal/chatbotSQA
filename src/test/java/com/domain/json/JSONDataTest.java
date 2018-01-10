package com.domain.json;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JSONDataTest {

	@Test
	public void createMetadataTest() {
		ResponseDataJson dataJson = new ResponseDataJson();
		assertNotNull(dataJson.createMetadata(ResponseDataJson.PRICE_INTENT_ID, "price"));
		
	}
	
	@Test
	public void createFulfillmentTest() {
		ResponseDataJson dataJson = new ResponseDataJson();
		assertNotNull(dataJson.createFulfillment("price is 6666"));
		
	}
}
