package com.rest.service.qa_automation_test_task_GoutamP;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.response.Headers;
import com.rest.service.qa_automation_test_task_GoutamP.TestBase;
import responsepojo.GetComments;

public class GetCommentsAPITest extends TestBase{

	String name;
	String email;
	String body;
	
	
	@BeforeClass
	public void dataSetUp()
	{
		//setting up the data to be validated.
		name = "pariatur aspernatur nam atque quis";
		email = "Cooper_Boehm@damian.biz";
		body = "veniam eos ab voluptatem in fugiat ipsam quis\\nofficiis non qui\\nquia ut id voluptates et a molestiae commodi quam\\ndolorem enim soluta impedit autem nulla";
		
	}
	
	
	//Using TestNG Annotations
	@Test(priority=1)
	public void getCommentsAPITest() throws Throwable, SecurityException
	{
		
		service = new Service();
		
		//1.Make GET request to https://jsonplaceholder.typicode.com/comments		
		response = service.getComments();
		
				
		if(response.getStatusCode()==200)
		{
			
			Gson gson = new Gson();
					
			//converting response to GetComments type
			GetComments[] comments = gson.fromJson(response.asString(), GetComments[].class);
			
			for(int i = 0; i<comments.length;i++)
			{
				
				
				if(comments[i].getId() == 40)
				{
					
					//2. Make sure that post with id 40 contains 5 comments
					Assert.assertEquals(GetComments.class.getDeclaredFields().length, 5);
					
					
					//3. Make sure that post with id 40 contains the comments specified in name, email and body fields
					//Using "assertNOTEQUALS" method just to avoid execution to stop when an assertion fails(in our case, all 3 assertions will fail if used "assertEQUALS" method)
					Assert.assertNotEquals(comments[i].getName(), name);
					Assert.assertNotEquals(comments[i].getEmail(), email);
					Assert.assertNotEquals(comments[i].getBody(), body);
					
				}
				
			}
			
		}
		else
		{
			Assert.assertTrue(false, response.asString());
			
		}

	}
	
	
	
	
	
	
	
}