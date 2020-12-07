package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Response_Script_Symbol 
{
	Response re1;
	
	@Given("API for foreign exchange with symbols")
	public void api_for_foreign_exchange_with_symbols()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	
	@When("posted with correct symbols")
	public void posted_with_correct_symbols()
	{
		re1 = RestAssured.get("/api/latest?symbols=GBP,USD");
	}
	
	@Then("validate positive response code for given symbols")
	public void validate_positive_response_code_for_given_symbols() 
	{
		int statusCode = re1.getStatusCode();
//		System.out.println("Status code is "+statusCode);
	
		System.out.println("Status Code is: " +statusCode);
		Assert.assertEquals(200, statusCode);
	}
}
