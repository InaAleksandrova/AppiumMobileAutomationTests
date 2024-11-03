package com.swaglabs;

import com.swaglabs.BaseTests;
import com.swaglabs.util.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTests {

    private PropertiesHelper propertiesHelper;

    @BeforeMethod
    public void login() {
        propertiesHelper = new PropertiesHelper();
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("standard_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        Assert.assertTrue(productsPage().isProductsPageVisible());
    }

    @Test
    public void addProductAndRemoveItFromCartPage() {
        productsPage().addProductToCartByIndex(1);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().removeProductFromCartByIndex(1);
        Assert.assertTrue(cartPage().isCartEmpty(), "The cart is not empty");
    }

    @Test
    public void addProductAndContinueShopping() {
        productsPage().addProductToCartByIndex(1);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapContinueShopping();
        Assert.assertTrue(productsPage().isProductsPageVisible(), "The user is not redirected back to products page");
    }

    @Test
    public void addToCartAndCheckout() {
        productsPage().addProductToCartByIndex(1);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to checkout page");
    }

    @AfterMethod
    public void logout() {
        productsPage().tapProductsMenu();
        menuPage().tapLogout();
        Assert.assertTrue(menuPage().isLoginPageDisplayed(), "The user is not logged out");
    }
}
