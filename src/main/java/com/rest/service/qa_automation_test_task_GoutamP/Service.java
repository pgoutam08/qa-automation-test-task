package com.rest.service.qa_automation_test_task_GoutamP;

import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Service {

	
	public Response getComments()
	{
		JSONObject jsonObj = new JSONObject();
		
		
		//Using REST Assured GIVEN function
		RequestSpecification reqSpecification = RestAssured.given();
		reqSpecification.contentType("application/json");
		reqSpecification.accept("application/json");
		
		reqSpecification.body(jsonObj.toString());
		
		//1. Make GET request to https://jsonplaceholder.typicode.com/comments
		Response response = reqSpecification.get(ServiceURL.getCommentsURL);
		
		return response;
		
	}
}
