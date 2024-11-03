package com.swaglabs.pages;

import com.swaglabs.locators.LoginPageLocators;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = new AppiumBy.ByAccessibilityId(LoginPageLocators.USERNAME_FIELD);
    private final By passwordField = new AppiumBy.ByAccessibilityId(LoginPageLocators.PASSWORD_FIELD);
    private final By loginButton = new AppiumBy.ByAccessibilityId(LoginPageLocators.LOGIN_BUTTON);
    private final By errorMessageText = new By.ByXPath(LoginPageLocators.ERROR_MESSAGE_TEXT);

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterUsername(String text) {
        enterText(usernameField, text);
    }

    public void enterPassword(String text) {
        enterText(passwordField, text);
    }

    public void clickLoginButton() {
        tap(loginButton);
    }

    public String getErrorMessageText() {
        return getTextFromElement(errorMessageText);
    }
}
