package responseparsingasignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseParsingAssignment 
{
	Response rep; 
	@Test
	@Given("Given API for foreign exchange")
	public void given_api_for_foreign_exchange()
	{
		RestAssured.baseURI = "https://api.ratesapi.io";
	}
	
	@Test
	@When("posted with correct information")
	public void posted_with_correct_information()
	{
		RestAssured.basePath= "/api/latest";
	}
	
	@Test
	@Then("validate positive response received")
	public void validate_positive_response_received()
	{
		rep = RestAssured.given().contentType(ContentType.JSON).log().all().get();
		String rBase = RestAssured.given().contentType(ContentType.JSON).log().all().get().then().extract().path("base");
		rep.prettyPrint();
		System.out.println("Value is "+rBase);
		Map<String, Double> cRates = new HashMap<>();
		cRates =RestAssured.given().contentType(ContentType.JSON).log().all().get().then().extract().path("rates");
		Set<Entry<String, Double>> rate1  = cRates.entrySet();
		for(Map.Entry<String, Double> value : rate1)
		{
			System.out.println(value.getKey()+ " :"+value.getValue());
		}
		String date = RestAssured.given().contentType(ContentType.JSON).log().all().get().then().extract().path("date");
		System.out.println("Date is "+ date);
		Assert.assertEquals("EUR", rBase);
		
	}
}
