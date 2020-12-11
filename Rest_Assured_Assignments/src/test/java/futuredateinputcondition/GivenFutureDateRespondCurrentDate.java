package futuredateinputcondition;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GivenFutureDateRespondCurrentDate 
{
	
	Response rep;
	
	@Test
	@Given("API with future date for foreign exchange rates")
	public void api_future_date_for_foreign_rates()
	{
		RestAssured.baseURI = "https://api.ratesapi.io";
	}
	@Test
	@When("posted with future date")
	public void posted_future_date() throws Exception
	{
		//rep =RestAssured.get("/api/2035-01-12");
		RestAssured.basePath = "/api/2035-01-12";
		
	}
	
	@Test
	@Then("Assert the response with current date")
	public void assert_current_date() throws Exception
	{
		
		//This will give the current date 
		LocalDate currentDate = LocalDate.now();
		System.out.println("current date is "+currentDate);
		
		String date = RestAssured.given().contentType(ContentType.JSON).log().all().get().then().extract().path("date");
		
//		JsonPath jp1 = rep.jsonPath();
//		String resDate = jp1.get("date");
		
		
		System.out.println("Date in Future date is "+date);
		Assert.assertEquals(date,currentDate);
			
	}
	
}
