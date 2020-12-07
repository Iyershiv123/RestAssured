package ResponseAssertionDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseAssertionForSymbol 
{
	Response resp;
	
	@Given("API for foreign exchange with symbols")
	public void api_for_foreign_exchange_with_symbols()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	
	@When("posted with correct symbols")
	public void posted_with_correct_symbols()
	{
		resp = RestAssured.get("/api/latest?symbols=GBP,USD");
	}
	
	@Then("validate positive response code for given symbols")
	public void validate_positive_response_code_for_given_symbols() 
	{
		int statusCode = resp.getStatusCode();
		System.out.println("Status Code returned is "+statusCode);
		Assert.assertEquals(200, statusCode);
		
		Assert.assertTrue(statusCode==200);
		Assert.assertFalse(statusCode!=200);
		
		String stLine = resp.getStatusLine();
		Assert.assertEquals("HTTP/1.1 200 OK", stLine);
		System.out.println("Status Line returned is "+stLine);
	}
}
