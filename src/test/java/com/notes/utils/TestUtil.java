package com.notes.utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class TestUtil {
	public static String oAuth_Token() {
		RestRequestUtil.setBaseURI();
		RestRequestUtil.setBasePath("");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "pallavijoshi2002@gmail.com");
		requestParams.put("password", "12345678");

		
		Response response = RestRequestUtil.responseWithTokenAndBody("post", null, requestParams, "/notes/api");
		RestResponseUtil.checkStatusIs200(response);
		
		
		String outh_token = RestResponseUtil.getValue(response, "access_token");
		System.out.println("oAuth Token is =>  " + outh_token);
		return outh_token;
		
	}

	//get userID given accessToken
	
	public static String getUserId(String accessToken) {
		RestRequestUtil.setBaseURI();
		RestRequestUtil.setBasePath("/notes/api");

//		RequestSpecification req = RestAssuredUtil.auth2(accessToken);
//		Response response = RestAssuredUtil.get(req, "/account");
		Response response = RestRequestUtil.responseWithTokenAndBody("get", accessToken, null, "/notes");
		RestResponseUtil.checkStatusIs200(response);
		return RestResponseUtil.getValue(response, "data.id");
	}
	
	public static JSONObject generateJSONAddress(String title, String desc, String category) {
		JSONObject body = new JSONObject();
		body.put("title", title);
		body.put("description", desc);
		body.put("category", category);

		return body;
	}
//	public static JSONObject generateJSONAddress(String fName, String lName, String address1,
//			String city, String zipcode, String phone, String state, String country, String label) {
//		JSONObject newAddress = new JSONObject();
//		newAddress.put("firstname", fName);
//		newAddress.put("lastname", lName);
//		newAddress.put("address1", address1);
//		newAddress.put("city", city);
//		newAddress.put("zipcode", zipcode);
//		newAddress.put("phone", phone);
//		newAddress.put("state_name", state);
//		newAddress.put("country_iso", country);
//		newAddress.put("label", label);
//		JSONObject body = new JSONObject();
//		body.put("address", newAddress);
//		return body;
//	}
	
	public static JSONObject readFile(String filename) throws IOException, ParseException, org.json.simple.parser.ParseException
	{
		
		//Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\JSON_File\\"+filename);
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		return prodjsonobj;
	}
	

}
