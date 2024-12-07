package org.pajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
    WebDriver driver;
    By search = By.id("search-field");
    By productName = By.cssSelector("tbody tr td:nth-child(1)");


    public OfferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String item){
       driver.findElement(search).sendKeys(item);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
