package com.automation.steps;

import com.automation.pages.WebViewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebViewSteps {

    WebViewPage webViewPage = new WebViewPage();


    @Then("verify website is displayed")
    public void verifyWebsiteIsDisplayed() {
        Assert.assertTrue(webViewPage.isWebsiteDisplayed());
    }

    @When("user search an item")
    public void userSearchAnItem() {
        webViewPage.searchElement();
    }

    @Then("verify search item page is displayed")
    public void verifySearchItemPageIsDisplayed() {
    }
}
