package org.util;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class CommonUtils {
    private WebDriver driver;


    public CommonUtils(WebDriver driver){
        this.driver= driver;
    }

    public void switchToChildTab(){
        Set<String> tabs= driver.getWindowHandles() ;
        Iterator<String> itr= tabs.iterator();

        String parentTab=itr.next();
        String childTab=itr.next();

        driver.switchTo().window(childTab);
    }
}
