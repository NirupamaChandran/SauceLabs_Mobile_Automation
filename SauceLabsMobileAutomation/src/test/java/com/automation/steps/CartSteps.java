package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();


    @Then("verify cart page is displayed")
    public void verifyCartPageIsDisplayed() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @When("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        cartPage.clickCheckOutBtn();
    }
}
