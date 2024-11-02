package com.swaglabs.pages;

import com.swaglabs.util.ItemsListHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.swaglabs.locators.ProductsPageLocators.*;

public class ProductsPage extends BasePage {

    private ItemsListHelper itemsListHelper;

    private final By productsMenu = new AppiumBy.ByAccessibilityId(PRODUCTS_MENU);
    private final By productsCart = new AppiumBy.ByAccessibilityId(PRODUCTS_CART);
    private final By productsFilter = new AppiumBy.ByAccessibilityId(PRODUCTS_FILTER);
    private final By productsToggleButton = new AppiumBy.ByAccessibilityId(PRODUCTS_TOGGLE_BUTTON);
    private final By allProducts = new AppiumBy.ByAccessibilityId(PRODUCTS_ALL);
    private final By productList = new By.ByXPath(PRODUCTS_LIST);
    private final By productsAddToCartButton = new By.ByXPath(PRODUCTS_ADD_TO_CART_BUTTONS);
    private final By productsRemoveFromCartButton = new By.ByXPath(PRODUCTS_REMOVE_FROM_CART_BUTTONS);
    private final By productsCartItemsValue = new By.ByXPath(PRODUCTS_CART_ITEMS_VALUE);

    public ProductsPage(AppiumDriver driver) {
        super(driver);
        this.itemsListHelper = new ItemsListHelper(driver);
    }

    public void tapProductsMenu() {
        tap(productsMenu);
    }

    public void tapProductsCart() {
        tap(productsCart);
    }

    public void tapProductsFilter() {
        tap(productsFilter);
    }

    public void tapProductsToggleButton() {
        tap(productsToggleButton);
    }

    public boolean isProductsPageVisible() {
        return isElementVisible(allProducts);
    }

    public String getItemsInCartNumber() {
        return getTextFromElement(productsCartItemsValue);
    }

    public int getTotalProductsCount() {
        return itemsListHelper.getAllItems(productList);
    }

    public WebElement getProductByIndex(int index) {
        try {
            return itemsListHelper.getItemByIndex(PRODUCTS_LIST, index);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get product at index " + index, e);
        }
    }

    public void addProductToCartByIndex(int index) {
        try {
            WebElement addToCartButton = itemsListHelper.getButtonByItemIndex(PRODUCTS_LIST, PRODUCTS_ADD_TO_CART_BUTTONS, index);
            addToCartButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Add to Cart button for product at index " + index, e);
        }
    }

    public void removeProductFromCartByIndex(int index) {
        try {
            WebElement removeFromCartButton = itemsListHelper.getButtonByItemIndex(PRODUCTS_LIST, PRODUCTS_REMOVE_FROM_CART_BUTTONS, index);
            removeFromCartButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Remove from Cart button for product at index " + index, e);
        }
    }

}
