package ResponseAssertionDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseAssertion 
{
	
	Response response;
	
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange()
	{
		RestAssured.baseURI ="https://api.ratesapi.io";
		
	}
	@When("posted with correct information")
	public void posted_correct_info()
	{
		response = RestAssured.get("/api/latest");
	}
	@Then("validate positive response code received")
	public void  validate_positive_response()
	{

		int statusCode = response.getStatusCode();
		System.out.println("Status Code returned is "+statusCode);
		Assert.assertEquals(200, statusCode);
		
		
		String stLine = response.getStatusLine();
		Assert.assertEquals("HTTP/1.1 200 OK", stLine);
		System.out.println("Status Line returned is "+stLine);
	
		
	}

}
