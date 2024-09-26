package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Collections;

public class ProductPage extends BasePage{


    @FindBy(xpath = "//android.widget.TextView[@text='BACK TO PRODUCTS']")
    WebElement heading;

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[@text='ADD TO CART']")
    WebElement addToCart;

    @FindBy(xpath = "//android.widget.TextView[@text='BACK TO PRODUCTS']/preceding-sibling::android.widget.ImageView")
    WebElement backBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    WebElement cartIcon;

    public boolean verifyTitle(){
        return heading.isDisplayed();
    }

    public void addToCart(){

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresentNew(addToCart)){
            scrollOrSwipe(width/2, height/2, width/2, 0);
        }

        addToCart.click();
    }

    public void clickBackButton(){
        backBtn.click();
    }

    public void clickCartIcon(){
        cartIcon.click();
    }

    public void doubleTapAddToCart(){

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresentNew(addToCart)){
            scrollOrSwipe(width/2, height/2, width/2, 0);
        }

        doubleTap(addToCart);

//        Actions actions = new Actions(driver);
//        actions.pause(1000).doubleClick(addToCart).pause(1000).build().perform();
    }
}
