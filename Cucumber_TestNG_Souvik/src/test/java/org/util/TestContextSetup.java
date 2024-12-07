package org.util;

import org.openqa.selenium.WebDriver;
import org.pajeObjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public  TestBase testBase;
    public CommonUtils commonUtils;

    public TestContextSetup(){
        testBase=new TestBase();
        pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
        commonUtils=new CommonUtils(testBase.WebDriverManager());
    }
}
