package org.stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.pajeObjects.CheckoutPage;
import org.util.TestContextSetup;

public class CartPageStepDefinition {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CartPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String product) {
       checkoutPage.goToCheckoutPage();
        //Assertion to extract name from screen and compare with name
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        checkoutPage.VerifyPromoBtn();
        checkoutPage.VerifyPlaceOrder();
    }
}
