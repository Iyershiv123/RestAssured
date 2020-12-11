package responseparsingasignment;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "\\src\\test\\resources\\features\\responseparsing.feature", glue = {"responseparsingassignment"})
public class ResponseParsingAssignmentRunner extends ResponseParsingAssignment{

}
