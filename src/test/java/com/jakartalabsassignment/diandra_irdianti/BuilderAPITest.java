package com.jakartalabsassignment.diandra_irdianti;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BuilderAPITest {
	String authtoken = "token not found";
	//String email = "email not found";

	@Test(priority = 1)
	public void signUpAPI() {

		String SignUpPayload = "{\"user\":{\"first_name\":\"rere\",\"last_name\":\"\",\"email\":\"buayademo22321@gmail.com\",\"password\":\"builder123\",\"phone_number\":\"+62-87788991313\",\"user_type\":\"User\",\"organisation\":\"noise\",\"signup_stage\":\"\"}}";

		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response signUpResponse = RestAssured.given().log().all().contentType("application/json").body(SignUpPayload).when()
				.post("/users");

		System.out.println("status code :" + signUpResponse.getStatusCode());
		assertEquals(signUpResponse.getStatusCode(), 200);
		
		JsonPath jsonPath = signUpResponse.jsonPath();

		authtoken = jsonPath.get("user.authtoken");
		System.out.println("authtoken = " + authtoken);

		String Email = jsonPath.get("user.email");
		System.out.println("email = " + Email);
		assertEquals(Email, "buayademo22321@gmail.com");		

	}

	@Test(priority = 2)
	public void setCurrencyAPI() {

		//String currencyPayload = "user[currency_id]=3";
		
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response setCurrencyResponse = RestAssured.given().log().all().contentType("multipart/form-data").multiPart("user[currency_id]", "3")
				.header("authtoken", authtoken).when().put("/users");

		System.out.println("status code :" + setCurrencyResponse.getStatusCode());
		assertEquals(setCurrencyResponse.getStatusCode(), 200);
		
		JsonPath jsonPath = setCurrencyResponse.jsonPath();
		
		//authtoken = jsonPath.get("user.authtoken");
		//System.out.println("authtoken =" + authtoken);
		
		String currencyId = jsonPath.get("user.currency.data.id");
		System.out.println("currencyId =" + currencyId);
		assertEquals(currencyId, "3");

	}
	
	@Test(priority = 3)
	public void profileAPI() {

		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response profileResponse = RestAssured.given().log().all().contentType("application/json")
				.header("authtoken", authtoken).when().get("/user");

		System.out.println("status code :" + profileResponse.getStatusCode());
		assertEquals(profileResponse.getStatusCode(), 200);
		
		JsonPath jsonPath = profileResponse.jsonPath();
		
		String email = jsonPath.get("email");
		System.out.println("email on profile =" + email);
		assertEquals(email, "buayademo22321@gmail.com");
	}
	
	@Test(priority = 4)
	public void signOutAPI() {

		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response signOutResponse = RestAssured.given().log().all().contentType("application/json")
				.queryParam("authtoken", authtoken).when().delete("/users/sign_out");

		System.out.println("status code :" + signOutResponse.getStatusCode());
		assertEquals(signOutResponse.getStatusCode(), 200);
		
		//JsonPath jsonPath = signOutResponse.jsonPath();
		//String authtoken = jsonPath.get("user.authtoken");
		//str
	}
}
