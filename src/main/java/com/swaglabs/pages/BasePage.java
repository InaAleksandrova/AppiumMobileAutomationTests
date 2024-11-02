package com.swaglabs.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public void waitUntilElementIsVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void enterText(By field, String text) {
        waitUntilElementIsVisible(field);
        driver.findElement(field).sendKeys(text);
    }

    public void tap(By by) {
        waitUntilElementIsVisible(by);
        driver.findElement(by).click();
    }

    public boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


    public WebElement scrollToAndroidElement(String elementText) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"));
    }
}
