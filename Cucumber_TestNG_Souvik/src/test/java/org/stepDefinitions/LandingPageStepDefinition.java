package org.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.pajeObjects.LandingPage;
import org.util.TestContextSetup;


public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;

        landingPage=testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() throws InterruptedException,NullPointerException {
        System.out.println("Start Testing");
    }

    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String productSortName) throws InterruptedException {
        landingPage.searchItem(productSortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("Extracted Product Name" + testContextSetup.landingPageProductName);
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();;
    }




}
