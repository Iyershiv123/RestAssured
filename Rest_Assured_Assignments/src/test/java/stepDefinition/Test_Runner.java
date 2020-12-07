package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features\\AcceptanceCriteria 1.feature", glue = {"stepDefinition"})

public class Test_Runner 
{
	
}
