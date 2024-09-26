package com.automation.pages;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class HomePage extends BasePage{

    Set<String> titleSet = new HashSet<>();
    List<Double> allPriceList = new ArrayList<>();
    List<Double> afterSort;
    List<Double> afterSortCopy;

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    WebElement productsHeading;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-PRODUCTS']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    List<WebElement> titleList;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Terms of Service')]")
    WebElement footer;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    WebElement removeBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']//android.widget.ImageView")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (high to low)']")
    WebElement priceHighToLow;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']/android.view.ViewGroup/android.widget.TextView[contains(@text,'$')]")
    List<WebElement> priceList;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    WebElement burgerMenu;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-WEBVIEW']")
    WebElement webView;

    @FindBy(xpath = "//android.widget.EditText[contains(@text,'url')]")
    WebElement urlInput;

    @FindBy(xpath = "//android.widget.TextView[@text=\"GO TO SITE\"]")
    WebElement goToSiteBtn;


    public boolean isHomePageDisplayed(){
        return productsHeading.isDisplayed();
    }

    public void printTitle(){

        for(WebElement title:titleList){
            titleSet.add(title.getText());
        }

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while(!isPresentNew(footer)){
            scrollOrSwipe(width/2, height/2, width/2, 0);
        }

        for(WebElement title:titleList){
            titleSet.add(title.getText());
        }

        System.out.println(titleSet);
    }

    public void clickFirstItem(){
        titleList.get(0).click();
    }


    public boolean isRemoveBtnDisplayed(){
        return removeBtn.isDisplayed();
    }


    public boolean isSorted(){

        WebElement container = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc='test-PRODUCTS']/android.view.ViewGroup/android.view.ViewGroup[1]"));
        int x = container.getLocation().getX();
        int y = container.getLocation().getY();

        int containerWidth = container.getSize().getWidth();
        int containerHeight = container.getSize().getHeight();

//        Dimension dimension = driver.manage().window().getSize();
//        int width = dimension.getWidth();
//        int height = dimension.getHeight();


        while (!isPresentNew(footer)){

            for (WebElement price:priceList){
                StringBuilder sb;
                sb= new StringBuilder(price.getText().substring(1));
                allPriceList.add(Double.parseDouble(String.valueOf(sb)));
            }

            scrollOrSwipe((x + containerWidth)/2, y + containerHeight, (x + containerWidth)/2, y);
        }

        for (WebElement price:priceList){
            StringBuilder sb;
            sb= new StringBuilder(price.getText().substring(1));
            allPriceList.add(Double.parseDouble(String.valueOf(sb)));
        }


        afterSort = new ArrayList<>(allPriceList);
        Collections.sort(afterSort);
        Collections.reverse(afterSort);

        System.out.println("automation sort " + allPriceList);
        System.out.println("manual sort " + afterSort);

        return allPriceList.equals(afterSort);

    }

    public void clickFilterBtn(){
        filterBtn.click();
    }

    public void selectPriceHighToLow(){
        priceHighToLow.click();
    }

    public void clickBurgerMenu(){
        burgerMenu.click();
    }

    public void clickWebView(){
        webView.click();
    }

    public void enterUrl(String url){
        urlInput.sendKeys(url);
    }

    public void clickGoToSite() throws InterruptedException {
        goToSiteBtn.click();
        Thread.sleep(1000);
    }

    public void printContexts(){
        SupportsContextSwitching contextSwitching = (SupportsContextSwitching) driver;
        System.out.println(Arrays.toString(contextSwitching.getContextHandles().toArray()));
    }



}
