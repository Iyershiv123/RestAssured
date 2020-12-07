package ResponseAssertionDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseAssertionForBaseCurrencyAndSymbol 
{
	Response rep;
	
	@Given("API for foreign exchange with base and symbols")
	public void api_for_foreign_exchange_with_base_and_symbols()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	
	
	@When("posted with correct base and symbols")
	public void posted_with_correct_base_and_sumbols()
	{
		rep = RestAssured.get("/api/latest?base=USD&symbols=GBP");
	}
	@Then("validate positive response code for base currency and symbols")
	public void validate_positive_response_code_received_for_base_currency_and_symbols() 
	{
		int statusCode = rep.getStatusCode();
		System.out.println("Status Code returned is "+statusCode);
		Assert.assertEquals(200, statusCode);
		
		Assert.assertTrue(statusCode==200);
		Assert.assertFalse(statusCode!=200);
		
		
		String stLine = rep.getStatusLine();
		Assert.assertEquals("HTTP/1.1 200 OK", stLine);
		
		System.out.println("Status Line returned is "+stLine);
	}

}
	

