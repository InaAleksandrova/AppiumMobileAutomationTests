package com.swaglabs.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.swaglabs.locators.LoginPageLocators.USERNAME_FIELD;
import static com.swaglabs.locators.MenuPageLocators.LOGOUT_BUTTON;

public class MenuPage extends BasePage {

    private final By logoutButton = new AppiumBy.ByAccessibilityId(LOGOUT_BUTTON);

    public MenuPage(AppiumDriver driver) {
        super(driver);
    }

    public void tapLogout() {
        tap(logoutButton);
    }

    public boolean isLoginPageDisplayed() {
        return isElementVisible(new AppiumBy.ByAccessibilityId(USERNAME_FIELD));
    }

}
