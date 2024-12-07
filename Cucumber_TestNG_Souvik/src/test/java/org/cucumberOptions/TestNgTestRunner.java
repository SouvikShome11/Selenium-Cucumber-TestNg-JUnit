package org.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/org/features",
        glue = "org.stepDefinitions",
        monochrome = true,
        tags = "@PlaceOrder or @OffersPage",
        plugin = {"html:src/test/reports/cucumber.html",
                  "json:src/test/reports/cucumber.json",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
