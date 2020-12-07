package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Response_Script_Assignment 
{
	Response re;
	
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange()
	{
		RestAssured.baseURI="https://api.ratesapi.io/";
		
	}
	@When("posted with correct information")
	public void posted_with_correct_information() {
		re = RestAssured.get("/api/latest");
		
	}

	@Then("validate positive response code received")
	public void validate_positive_response_code_received() 
	{
		int statusCode = re.getStatusCode();
//		System.out.println("Status code is "+statusCode);
	
		System.out.println("Status Code is: " + re.getStatusCode());
		Assert.assertEquals(200, statusCode);
		
	}
	
	
}
