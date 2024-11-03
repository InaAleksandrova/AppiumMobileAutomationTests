package com.swaglabs.pages;

import com.swaglabs.util.ItemsListHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.swaglabs.locators.CartPageLocators.*;

public class CartPage extends BasePage {

    private ItemsListHelper itemsListHelper;

    private final By continueShoppingButton = new AppiumBy.ByAccessibilityId(CONTINUE_SHOPPING_BUTTON);
    private final By checkoutButton = new AppiumBy.ByAccessibilityId(CHECKOUT_BUTTON);
    private final By cartProductsList = new AppiumBy.ByAccessibilityId(CART_PRODUCTS_LIST);
    private final By cartContent = new AppiumBy.ByAccessibilityId(CART_CONTENT);



    public CartPage(AppiumDriver driver) {
        super(driver);
        this.itemsListHelper = new ItemsListHelper(driver);
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

    public boolean isCartPageVisible() {
        return isElementVisible(cartContent);
    }

    public boolean isCartEmpty() {
        waitUntilElementIsNotVisible(cartProductsList);
        return isElementNotPresent(cartProductsList);
    }

    public int getItemsNumberInCart() {
        return itemsListHelper.getAllItems(cartProductsList);
    }

    public void removeProductFromCartByIndex(int index) {
        try {
            WebElement removeFromCartButton = itemsListHelper.getButtonByItemIndex(CART_PRODUCTS_LIST_XPATH, CART_PRODUCTS_REMOVE_BUTTONS_XPATH, index);
            removeFromCartButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Remove from Cart button for product at index " + index, e);
        }
    }
}
