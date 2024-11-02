package com.swaglabs.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.swaglabs.locators.CartPageLocators.*;

public class CartPage extends BasePage {

    private final By continueShoppingButton = new AppiumBy.ByAccessibilityId(CONTINUE_SHOPPING_BUTTON);
    private final By checkoutButton = new AppiumBy.ByAccessibilityId(CHECKOUT_BUTTON);
    private final By cartProductsList = new AppiumBy.ByAccessibilityId(CART_PRODUCTS_LIST);
    //private final By continueShoppingButton = new AppiumBy.ByAccessibilityId(CONTINUE_SHOPPING_BUTTON);


    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public void tapContinueShopping() {
        if (!isElementVisible(continueShoppingButton)) {
            scrollToAndroidElement("CONTINUE SHOPPING");
        }
        tap(continueShoppingButton);
    }

    public void tapCheckout() {
        if (!isElementVisible(continueShoppingButton)) {
            scrollToAndroidElement("CONTINUE SHOPPING");
        }
        tap(checkoutButton);
    }
}
