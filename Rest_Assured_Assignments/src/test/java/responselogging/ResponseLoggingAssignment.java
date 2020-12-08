package responselogging;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseLoggingAssignment 
{

		Response reps;
		@Test
		@Given("API for foreign exchange")
		public void api_for_foreign_exchange()
		{
			RestAssured.baseURI="https://api.ratesapi.io";
		}
		@Test
		@When("posted with correct information")
		public void posted_with_correct_information()
		{
			reps = RestAssured.get("/api/latest");
		}
		@Test
		@Then("validate response code for request using log method")
		public void validate_response_code_for_request_using_log_method()
		{
			reps = RestAssured.given().log().all().header("Content-Type", "application/json").body("").when().get("/api/latest").then()
					.log().all().statusCode(200).extract().response();
		}
	}


