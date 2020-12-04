package dataprovderdefinition;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\resources\\features\\", glue = {"dataproviderdefinition"}, 
plugin = {"pretty","target/test-output/testng1.html"},
monochrome = true)
public class DataProviderAssignmentRunner extends DataProviderAssignment{

}
