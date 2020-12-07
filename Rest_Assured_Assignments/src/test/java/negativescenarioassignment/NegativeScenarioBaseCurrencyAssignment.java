package negativescenarioassignment;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeScenarioBaseCurrencyAssignment
{
	
		Response rp;
		
		@Given("API for foreign exchange with base currency")
		public void api_for_foreign_exchange_with_base_currency()
		{
			RestAssured.baseURI="https://api.ratesapi.io";
			
		}
		
		@When("posted with incorrect base currency")
		public void posted_with_inccorrect_base_currency()
		{
			rp = RestAssured.get("/api/latest?base=GB,US");
		}
		
		@Then("validate response code for given base currency")
		public void validate_response_code_for_given_base_currency() 
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


