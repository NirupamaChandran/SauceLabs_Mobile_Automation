package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewPage extends BasePage{


    @FindBy(xpath = "//android.webkit.WebView")
    WebElement webPage;

    @FindBy(className = "android.widget.EditText")
    WebElement searchBox;

    public boolean isWebsiteDisplayed(){
        return webPage.isDisplayed();
    }

    public void searchElement(){
        searchBox.sendKeys("Laptop");
        searchBox.click();
    }
}
