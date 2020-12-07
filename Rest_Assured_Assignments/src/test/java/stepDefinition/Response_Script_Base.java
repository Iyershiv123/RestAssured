package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Response_Script_Base 
{
	Response re1;
	@Given("API for foreign exchange with base currency")
	public void api_for_foreign_exchange_with_base_currency()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	@When("posted with correct base currency")
	public void posted_with_correct_base_currency()
	{
		re1 = RestAssured.get("/api/latest?base=USD");
	}
	
	
	
	
	@Then("validate positive response code for given base currency")
	public void validate_positive_response_code_for_given_base_currency() 
	{
		int statusCode = re1.getStatusCode();
//		System.out.println("Status code is "+statusCode);
	
		System.out.println("Status Code is: " +statusCode);
		Assert.assertEquals(200, statusCode);
	}
	
}
