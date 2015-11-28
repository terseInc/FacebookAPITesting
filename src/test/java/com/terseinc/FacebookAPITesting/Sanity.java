package com.terseinc.FacebookAPITesting;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Sanity {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	  
    @Test
    public void TestThatTheNameAndIdOfAUserCanBeRetrieved(){
   	 Client client = Client.create();
     WebResource service = client.resource(Facebook.getBaseUrl())
    		 .path("me")
    		 .queryParam("fields", "id,name")
    		 .queryParam("access_token", AuthenticationManager.get_about_me_Token());
     ClientResponse response = service.accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON)
             .get(ClientResponse.class);
     System.out.println(response);
     Assert.assertEquals(200, response.getStatus());
     String body = response.getEntity(String.class);
     System.out.println(body);
     
     JSONObject obj = new JSONObject(body);
     System.out.println(obj);
     
     Assert.assertEquals("Dan Annankra", obj.getString("name"));
     Assert.assertEquals("10153861320718825", obj.getString("id"));
    }

}
