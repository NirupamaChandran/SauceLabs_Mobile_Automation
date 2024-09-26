package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @And("print all product titles")
    public void printAllProductTitles() {
        homePage.printTitle();
    }

    @When("user click first item")
    public void userClickFirstItem() {
        homePage.clickFirstItem();
    }


    @Then("verify remove button is displayed")
    public void verifyRemoveButtonIsDisplayed() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isRemoveBtnDisplayed());
    }

    @When("user click filter button")
    public void userClickFilterButton() {
        homePage.clickFilterBtn();
    }

    @And("select price high to low")
    public void selectPriceHighToLow() {
        homePage.selectPriceHighToLow();
    }

    @Then("verify home page is sorted")
    public void verifyHomePageIsSorted() {
        Assert.assertTrue(homePage.isSorted());
    }

    @When("user clicks on burger menu")
    public void userClicksOnBurgerMenu() {
        homePage.clickBurgerMenu();
    }

    @And("clicks webView")
    public void clicksWebView() {
        homePage.clickWebView();
    }

    @And("enter url {string}")
    public void enterUrl(String url) {
        homePage.enterUrl(url);
    }

    @And("click go to site button")
    public void clickGoToSiteButton() throws InterruptedException {
        homePage.clickGoToSite();
    }

    @And("print contexts")
    public void printContexts() {
        homePage.printContexts();
    }


}
