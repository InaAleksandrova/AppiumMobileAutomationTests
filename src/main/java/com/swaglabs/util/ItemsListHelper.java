package com.swaglabs.util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemsListHelper {

    private AppiumDriver driver;

    public ItemsListHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemByIndex(String locator, int index) throws Exception {
        try {
            return driver.findElement(By.xpath(String.format("%s[%d]", locator, index)));
        } catch (Exception e) {
            throw new Exception("No item found at index " + index);
        }
    }

    public int getAllItems(By by) {
        return driver.findElements(by).size();
    }

    public WebElement getButtonByItemIndex(String parentLocator, String childLocator, int index) throws Exception {
        try {
            String buttonXpath = String.format("%s[%d]%s", parentLocator, index, childLocator);
            return driver.findElement(By.xpath(buttonXpath));
        } catch (Exception e) {
            throw new Exception("No such button found in item at index " + index);
        }
    }

}
