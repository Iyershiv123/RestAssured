package negativescenarioassignment;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeScenarioBaseSymbolAndCurrencyAssignment 
{
	Response rp;
	
	@Given("API for foreign exchange with base and symbols")
	public void api_for_foreign_exchange_with_symbols()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	
	@When("posted with incorrect base and symbols")
	public void posted_with_inccorrect_base_and_symbols()
	{
		rp = RestAssured.get("/api/latest?base=GB&symbols=IN");
	}
	
	@Then("validate response code for base currency and symbols")
	public void validate_response_code_for_base_currency_and_symbols() 
	{
		int statusCode = rp.getStatusCode();
		System.out.println("Status Code returned is "+statusCode);
		Assert.assertEquals(400, statusCode);
		
		Assert.assertTrue(statusCode==400);
		//Assert.assertFalse(statusCode!=200);
		
		String stLine = rp.getStatusLine();
		Assert.assertEquals("HTTP/1.1 400 Bad Request", stLine);
		System.out.println("Status Line returned is "+stLine);
	}
	
}
