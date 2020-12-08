package responselogging;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseLoggingNegativeScenarioAssignment 
{
	Response reps;
	@Test
	@Given("API for foreign exchange with incorrect URI")
	public void api_for_foreign_exchange_with_incorrect_uri()
	{
		RestAssured.baseURI="https://api.ratesapi.io";
	}
	
	@Test
	@When("posted with incorrect information")
	public void posted_with_correct_information()
	{
		reps = RestAssured.get("/ap");
	}
	
	@Test
	@Then("validate response code for request using log method")
	public void validate_response_code_for_request_using_log_method()
	{
		reps = RestAssured.given().log().all().header("Content-Type", "application/json").body("").when().get("/ap").then()
				.log().all().statusCode(400).extract().response();
	}
}
