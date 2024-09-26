package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    WebElement cartHeading;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT']")
    WebElement checkOutBtn;

    public boolean isCartPageDisplayed(){
        return cartHeading.isDisplayed();
    }

    public void clickCheckOutBtn(){
        checkOutBtn.click();
    }
}
