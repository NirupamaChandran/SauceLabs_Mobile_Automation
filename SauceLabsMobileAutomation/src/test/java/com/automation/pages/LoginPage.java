package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoginPage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(xpath = "//android.widget.TextView[@text='And the password for all users is:']/following-sibling::android.widget.TextView")
    WebElement password;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'The currently accepted usernames')]/following-sibling::android.view.ViewGroup/android.widget.TextView")
    List<WebElement> usernameList;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    WebElement usernameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    WebElement passwordInput;

    @FindBy(xpath = "//android.widget.TextView[@text='LOGIN']")
    WebElement loginBtn;


    public void openApplication(){
    }

    public void performScroll(){
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresentNew(password)){
            scrollOrSwipe(width/2, height/2, width/2, 0);
        }
    }

    public void printData(){
        System.out.println("usernames: ");
        for( WebElement username: usernameList){
            System.out.println(username.getText());
        }
        System.out.println("password: ");
        System.out.println(password.getText());
    }

    public void doLogin(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
