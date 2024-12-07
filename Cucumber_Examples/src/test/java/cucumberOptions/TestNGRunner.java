package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", //dryRun=true
glue="stepDefinitions",monochrome=true,tags="@SmokeTest or @RegressionTest", //tags= "not @Regresstion"
plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"} )
public class TestNGRunner extends AbstractTestNGCucumberTests {

	
	
}
