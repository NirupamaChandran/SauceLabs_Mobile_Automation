package com.automation.steps;

import com.automation.pages.CheckOutPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;

public class CheckOutSteps {

    CheckOutPage checkOutPage = new CheckOutPage();

    @And("user enters {string} {string} and {string}")
    public void userEntersAnd(String fname, String lname, String post) {
        checkOutPage.fillInformation(
                ConfigReader.getConfigValue(fname),
                ConfigReader.getConfigValue(lname),
                ConfigReader.getConfigValue(post)
        );
    }

    @And("user clicks on finish button")
    public void userClicksOnFinishButton() {
        checkOutPage.clickFinishBtn();
    }

    @Then("verify {string} note is displayed")
    public void verifyNoteIsDisplayed(String str) {
        Assert.assertEquals(str,checkOutPage.isSuccessMsgDisplayed());
    }
}
