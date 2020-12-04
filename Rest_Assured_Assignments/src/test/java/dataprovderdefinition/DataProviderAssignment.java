package dataprovderdefinition;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DataProviderAssignment 
{
	Response re;
	
	@DataProvider(name = "DateInfo")
	public Object[][] dProvider()
	{
		Object[][] data = new Object[3][3];
		data[0][0] = "2020";
		data[0][1] = "05";
		data[0][2] = "01";
		
	
		data[1][0] = "1992";
		data[1][1] = "04";
		data[1][2] = "01";
		
		
		data[2][0] = "2026";
		data[2][1] = "12";
		data[2][2] = "01";
		
		return data;
		
	}
	@Test
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange()
	{
		RestAssured.baseURI = "https://api.ratesapi.io";
	}
	@Test(dataProvider = "DateInfo")
	@When("posted with correct information")
	public void posted_with_correct_information(String year, String mon, String day)
	{
		re = RestAssured.get("/api/"+year+"-"+mon+"-"+day);
		
	}
	
	@Test
	@Then("validate response code received")
	public void validate_response_code_received()
	{
		int statusCode = re.getStatusCode();
		System.out.println("Status Code is returned is "+statusCode);
		Assert.assertEquals(200, statusCode);
		
		Assert.assertTrue(statusCode==200);
		Assert.assertFalse(statusCode!=200);
		
	
	}
}
