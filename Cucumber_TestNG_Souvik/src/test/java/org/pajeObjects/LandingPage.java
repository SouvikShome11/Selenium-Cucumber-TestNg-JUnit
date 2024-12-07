package org.pajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("h4.product-name");
    By topDeals= By.xpath("//a[contains(text(), 'Top Deals')]");
    By quantityInputField=By.cssSelector("input.quantity");

    By incrementButton=   By.cssSelector("a.increment");
    By addToCartButton=By.xpath("//button[text()='ADD TO CART']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String item){
        driver.findElement(search).sendKeys(item);
    }

    public String getProductName(){
         return driver.findElement(productName).getText();
    }

    public void goToTopDealsPage(){
        driver.findElement(topDeals).click();
    }


    public void incrementQuantity(int quantity)
    {
        int i = quantity-1;
        while(i>0)
        {
            driver.findElement(incrementButton).click();
            i--;
        }

    }

    public  void addToCart(){
        driver.findElement(addToCartButton).click();
    }
}
