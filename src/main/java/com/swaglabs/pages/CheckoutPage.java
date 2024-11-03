package com.swaglabs.pages;

import com.swaglabs.util.ItemsListHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.swaglabs.locators.CheckoutPageLocators.*;

public class CheckoutPage extends BasePage {

    private ItemsListHelper itemsListHelper;

    private final By firstName = new AppiumBy.ByAccessibilityId(FIRST_NAME);
    private final By lastName = new AppiumBy.ByAccessibilityId(LAST_NAME);
    private final By zipCode = new AppiumBy.ByAccessibilityId(ZIP_CODE);
    private final By cancelButton = new AppiumBy.ByAccessibilityId(CANCEL_BUTTON);
    private final By continueButton = new AppiumBy.ByAccessibilityId(CONTINUE_BUTTON);
    private final By checkoutErrorMessage = new AppiumBy.ByAccessibilityId(ERROR_MESSAGE);
    private final By checkoutErrorMessageText = new By.ByXPath(CHECKOUT_ERROR_MESSAGE_TEXT);
    private final By checkoutItem = new AppiumBy.ByAccessibilityId(CHECKOUT_ITEM);
    private final By itemsAmount = new AppiumBy.ByAccessibilityId(ITEMS_AMOUNT);
    private final By checkoutOverview = new AppiumBy.ByAccessibilityId(CHECKOUT_OVERVIEW);
    private final By finalCancelButton = new AppiumBy.ByAccessibilityId(FINAL_CANCEL_BUTTON);
    private final By finishButton = new AppiumBy.ByAccessibilityId(FINISH_BUTTON);
    private final By checkoutComplete = new AppiumBy.ByAccessibilityId(CHECKOUT_COMPLETE);
    private final By backHomeButton = new AppiumBy.ByAccessibilityId(BACK_HOME_BUTTON);


    public CheckoutPage(AppiumDriver driver) {
        super(driver);
        this.itemsListHelper = new ItemsListHelper(driver);
    }

    public void enterFirstName(String text) {
        enterText(firstName, text);
    }

    public void enterLastName(String text) {
        enterText(lastName, text);
    }

    public void enterZipCode(String text) {
        enterText(zipCode, text);
    }

    public void tapCancel() {
        if (!isElementVisible(cancelButton)) {
            scrollToAndroidElement("CANCEL");
        }
        tap(cancelButton);
    }

    public void tapContinue() {
        if (!isElementVisible(continueButton)) {
            scrollToAndroidElement("CONTINUE");
        }
        tap(continueButton);
    }

    public String getCheckoutErrorMessageText() {
        return getTextFromElement(checkoutErrorMessageText);
    }

    public void tapFinalCancel() {
        if (!isElementVisible(finalCancelButton)) {
            scrollToAndroidElement("CANCEL");
        }
        tap(finalCancelButton);
    }

    public void tapFinishButton() {
        if (!isElementVisible(finishButton)) {
            scrollToAndroidElement("FINISH");
        }
        tap(finishButton);
    }

    public void tapBackHomeButton() {
        tap(backHomeButton);
    }

    public int getCheckoutItemsNumber() {
        return itemsListHelper.getAllItems(checkoutItem);
    }

    public boolean isCheckoutItemsCountEmpty() {
        return isElementNotPresent(checkoutItem);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementNotPresent(checkoutErrorMessage);
    }

    public boolean isCheckoutPagePresent() {
        return isElementVisible(firstName);
    }

    public boolean isCheckoutOverviewPagePresent() {
        return isElementVisible(checkoutOverview);
    }

    public boolean isCheckoutCompletePagePresent() {
        return isElementVisible(checkoutComplete);
    }
}
