package responselogging;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "\\src\\test\\resources\\features\\responselogging.feature", glue = {"responselogging"})
public class ResponseLoggingNegativeScenarioRunner extends ResponseLoggingNegativeScenarioAssignment 
{

}
