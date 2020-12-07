package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Response_Script_Base_Symbol 
{
	Response re1;
	@Given("API for foreign exchange with base and symbols")
	public void api_for_foreign_exchange_with_base_and_symbols()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	
	
	@When("posted with correct base and symbols")
	public void posted_with_correct_base_and_sumbols()
	{
		re1 = RestAssured.get("/api/latest?base=USD&symbols=GBP");
	}
	@Then("validate positive response code for base currency and symbols")
	public void validate_positive_response_code_received_for_base_currency_and_symbols() 
	{
		int statusCode = re1.getStatusCode();
//		System.out.println("Status code is "+statusCode);
	
		System.out.println("Status Code is: " +statusCode);
		Assert.assertEquals(200, statusCode);
	}
	

}
