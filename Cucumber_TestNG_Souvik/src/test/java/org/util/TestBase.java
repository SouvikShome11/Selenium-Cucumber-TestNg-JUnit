package org.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;


    public  WebDriver WebDriverManager()  {
        FileInputStream fis;
        Properties prop;
        try {
            fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
            prop=new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String browser_properties = prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        // result = testCondition ? value1 : value2
        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if(driver==null) {
            if(browser.equalsIgnoreCase("CHROME"))
            driver = new ChromeDriver();
            else if (browser.equalsIgnoreCase("FireFox")) {
                //Apply Firefox logic
                System.out.println("FIREFOX---------------->");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(prop.getProperty("QA_URL"));
        }
        return driver;
    }


}
