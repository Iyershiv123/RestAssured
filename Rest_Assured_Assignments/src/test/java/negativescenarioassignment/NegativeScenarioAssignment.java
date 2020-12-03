package negativescenarioassignment;



import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeScenarioAssignment 
{
	Response getRe;
	
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange()
	{
		RestAssured.baseURI = "https://api.ratesapi.io";
	}
	
	@When("posted with incorrect information")
	public void posted_with_incorrect_information()
	{
		getRe = RestAssured.get("/api");
		
	}
	
	@Then("validate response code received")
	public void validate_response_code_received()
	{
		int statusCode = getRe.getStatusCode();
		System.out.println("Status Code is returned is "+statusCode);
		Assert.assertEquals(400, statusCode);
		
		
	}
	
	
}
