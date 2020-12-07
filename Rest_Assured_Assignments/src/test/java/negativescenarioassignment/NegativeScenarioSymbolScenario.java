package negativescenarioassignment;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeScenarioSymbolScenario 
{
	Response rp;
	@Given("API for foreign exchange with symbols")
	public void api_for_foreign_exchange_with_symbols()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}
	
	@When("posted with incorrect symbols")
	public void posted_with_inccorrect_symbols()
	{
		rp = RestAssured.get("/api/latest?symbols=GB,US");
	}
	
	@Then("validate response code for symbols")
	public void validate_response_code_for_given_symbols() 
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
