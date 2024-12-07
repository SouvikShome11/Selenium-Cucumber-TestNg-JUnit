package org.stepDefinitions;

import io.cucumber.java.en.Then;
import org.pajeObjects.LandingPage;
import org.pajeObjects.OfferPage;
import org.testng.Assert;
import org.util.CommonUtils;
import org.util.TestContextSetup;

public class OfferPageStepDefinition {

    String offersPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String productSortName) throws InterruptedException {
        OfferPage offerPage=testContextSetup.pageObjectManager.getOfferPage();

        switchToOffersPage();
        offerPage.searchItem(productSortName);
        Thread.sleep(2000);
        offersPageProductName= offerPage.getProductName();
    }

    public void switchToOffersPage(){
        LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
        landingPage.goToTopDealsPage();
        testContextSetup.commonUtils.switchToChildTab();
    }


    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
    }
}
