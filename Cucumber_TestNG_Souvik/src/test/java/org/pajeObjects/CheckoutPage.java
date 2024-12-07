package org.pajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    private By cartImage=By.cssSelector("a.cart-icon");
    private  By proceedToCheckoutButton= By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    private By promoBtn = By.cssSelector(".promoBtn");
    private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void goToCheckoutPage(){
        driver.findElement(cartImage).click();
        driver.findElement(proceedToCheckoutButton).click();
    }

    public Boolean VerifyPromoBtn()
    {
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean VerifyPlaceOrder()
    {
        return driver.findElement(placeOrder).isDisplayed();
    }


}
