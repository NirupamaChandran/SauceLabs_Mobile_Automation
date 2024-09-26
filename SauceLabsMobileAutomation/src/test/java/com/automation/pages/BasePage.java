package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    BasePage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public boolean isPresentNew(WebElement element) {
        try {
            resetImplicitWait(0);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }finally {
            resetImplicitWait(60);
        }
    }


    public void resetImplicitWait(long sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }



    public void scrollOrSwipe(int startX,int startY,int endX,int endY){

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1, 1)   // Sequence is a requestSpecification
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }

    public void doubleTap(WebElement element){

        int startX = element.getSize().getWidth() / 2 + element.getLocation().getX();
        int startY = element.getSize().getHeight() / 2 + element.getLocation().getY();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence = new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofSeconds(2)))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }


}
