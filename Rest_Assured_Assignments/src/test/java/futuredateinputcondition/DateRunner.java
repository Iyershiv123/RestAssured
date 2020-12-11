package futuredateinputcondition;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "\\src\\test\\resources\\features\\futuredate.feature", glue = {"futuredateinputcondition"})
public class DateRunner extends GivenFutureDateRespondCurrentDate{

}
