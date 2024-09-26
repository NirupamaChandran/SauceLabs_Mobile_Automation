package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user opens application")
    public void user_opens_application() {
        loginPage.openApplication();
    }

    @Given("print username and password")
    public void print_username_and_password() {
        loginPage.performScroll();
        loginPage.printData();
    }

    @And("login using valid {string} and {string}")
    public void loginUsingValidAnd(String username, String password) {
        loginPage.doLogin(ConfigReader.getConfigValue(username),ConfigReader.getConfigValue(password));
    }

}
