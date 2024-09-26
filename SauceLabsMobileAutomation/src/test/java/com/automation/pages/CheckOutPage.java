package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    WebElement postCodeInput;

    @FindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
    WebElement continueBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Terms of Service')]")
    WebElement footer;

    @FindBy(xpath = "//android.widget.TextView[@text='FINISH']")
    WebElement finishBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    WebElement successMsg;

    public void fillInformation(String firstname, String lastname, String post){
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        postCodeInput.sendKeys(post);
        continueBtn.click();
    }

    public void clickFinishBtn(){

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while(!isPresentNew(footer)){
            scrollOrSwipe(width/2, height/2, width/2, 0);
        }

        finishBtn.click();
    }

    public String isSuccessMsgDisplayed(){
        return successMsg.getText();
    }
}
