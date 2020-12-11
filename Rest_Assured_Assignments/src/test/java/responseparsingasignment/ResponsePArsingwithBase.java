package responseparsingasignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponsePArsingwithBase 
{
	Response response;
	@Test
	@Given("API for foreign exchange with base")
	public void api_foreign_exchange_with_base()
	{
		RestAssured.baseURI = "https://api.ratesapi.io";
	}
	@Test
	@When("posted with correct information on base")
	public void posted_with_correct_info()
	{
		//RestAssured.basePath= "/api/latest?base=INR";
		response = RestAssured.get("/api/latest?base=INR");   //-->Another way of giving the basepath
	}
	
	@Test
	@Then("validate positive response received for given base")
	public void validate_positive_response()
	{
		//String rDate = RestAssured.given().contentType(ContentType.JSON).log().all().get().then().extract().path("date");
		String rDate = response.jsonPath().get("date");
		System.out.println("Date is "+rDate);
		
		
		/*Assertion of date is not working because in the ratesapi.io website date is not updated with the current date that is 11-12-2020
		/LocalDate currentDate = LocalDate.now();
		Assert.assertEquals(currentDate, rDate);*/
		
		JsonPath jp = response.jsonPath();
		String resValue = jp.get("base");
		
		System.out.println(resValue);
		Assert.assertEquals("INR",resValue);
	}
}
