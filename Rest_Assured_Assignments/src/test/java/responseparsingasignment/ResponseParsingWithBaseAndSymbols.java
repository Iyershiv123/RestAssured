package responseparsingasignment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseParsingWithBaseAndSymbols {
	Response rep;
	
	@Test
	@Given("API for foreign exchange with symbols and base")
	public void api_for_exchange_with_symbols_and_base()
	{
		RestAssured.baseURI = "https://api.ratesapi.io";
	}
	@Test
	@When("posted with correct information on symbols and base")
	public void posted_with_info_on_base_and_symbols()
	{
		rep = RestAssured.get("/api/latest?base=GBP&symbols=INR");
	}
	@Test
	@Then("validate positive response received for given symbols an base")
	public void validate_positive_response_for_base_and_symbols()
	{
		JsonPath jpa = rep.jsonPath();
		String bValue = jpa.get("base");
		
		System.out.println("Base value given is "+bValue);
		Assert.assertEquals("GBP", bValue);
		

		JsonPath jPath1 = rep.jsonPath();
		HashMap<String, Double> sMap = jPath1.get("rates");
		Set<Entry<String, Double>> sValue1 = sMap.entrySet();
		for(Map.Entry<String, Double> ratesVal : sValue1)
		{
			System.out.println(ratesVal.getKey()+  " : "+ ratesVal.getValue());
			Assert.assertEquals("INR", ratesVal.getKey());
		}
		 
		String date=rep.jsonPath().get("date");
		System.out.println("Date in uri :"+date);
		LocalDate currentDate = LocalDate.now();
		System.out.println("Official date is "+currentDate);
		
	}

}
