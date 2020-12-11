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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseParsingWithSymbols
{
	Response rp;
	@Test
	@Given("API for foreign exchange with symbols")
	public void api_for_foreign_exchange()
	{
		RestAssured.baseURI = "https://api.ratesapi.io/";
	}
	@Test
	@When("posted with correct information on symbols")
	public void posted_with_correct_symbols()
	{
		rp = RestAssured.get("/api/latest?symbols=INR");
	}
	@Test
	@Then("validate positive response received for given symbols")
	public void validate_positive_response_for_symbols()
	{
		JsonPath jPath = rp.jsonPath();
		String val = jPath.get("base");
		System.out.println("Base value displayed is "+val);
		
		Assert.assertEquals("EUR", val);
		
		JsonPath jPath1 = rp.jsonPath();
		HashMap<String, Double> sMap = jPath1.get("rates");
		Set<Entry<String, Double>> sValue = sMap.entrySet();
		for(Map.Entry<String, Double> ratesVal : sValue)
		{
			System.out.println(ratesVal.getKey()+  " : "+ ratesVal.getValue());
			Assert.assertEquals("INR", ratesVal.getKey());
			
		}
		
		
		
		
	}
}
