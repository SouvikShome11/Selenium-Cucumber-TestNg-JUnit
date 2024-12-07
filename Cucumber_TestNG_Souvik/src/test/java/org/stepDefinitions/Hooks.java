package org.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.util.TestContextSetup;


import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }


    @After
    public void closeBrowser() {
        testContextSetup.testBase.WebDriverManager().quit();
    }

    @AfterStep
    public void takeFailedScreenshot(Scenario scenario) throws IOException {
        WebDriver driver= testContextSetup.testBase.WebDriverManager();

        if(scenario.isFailed()){
            File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] byteScreenshot= FileUtils.readFileToByteArray(screenshot);
            scenario.attach(byteScreenshot, "image/png", "image");
        }
    }
}
