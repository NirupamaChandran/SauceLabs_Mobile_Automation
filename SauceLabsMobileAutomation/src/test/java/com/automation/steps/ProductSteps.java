package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @Then("verify product page is displayed")
    public void verifyProductPageIsDisplayed() {
        Assert.assertTrue(productPage.verifyTitle());
    }

    @And("click add to cart button")
    public void clickAddToCartButton() {
        productPage.addToCart();
        productPage.clickBackButton();
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        productPage.addToCart();
    }

    @When("user click cart icon from product page")
    public void userClickCartIconFromProductPage() {
        productPage.clickCartIcon();
    }

    @And("double click add to cart button")
    public void doubleClickAddToCartButton() {
        productPage.doubleTapAddToCart();
    }
}
