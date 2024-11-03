package com.swaglabs;

import com.swaglabs.BaseTests;
import com.swaglabs.util.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests {

    private PropertiesHelper propertiesHelper;

    @BeforeMethod
    public void setUpProperties() {
        propertiesHelper = new PropertiesHelper();
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("standard_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        Assert.assertTrue(productsPage().isProductsPageVisible());
    }

    @Test
    public void verifySuccessfulCheckout() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName(propertiesHelper.getProperty("first_name"));
        checkoutPage().enterLastName(propertiesHelper.getProperty("last_name"));
        checkoutPage().enterZipCode(propertiesHelper.getProperty("postal_code"));
        checkoutPage().tapContinue();
        Assert.assertTrue(checkoutPage().isCheckoutOverviewPagePresent(), "The user is not redirected to the checkout overview page");
        checkoutPage().tapFinishButton();
        Assert.assertTrue(checkoutPage().isCheckoutCompletePagePresent(), "The user is not redirected to the checkout complete page");
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithEmptyFirstName() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName("");
        checkoutPage().enterLastName(propertiesHelper.getProperty("last_name"));
        checkoutPage().enterZipCode(propertiesHelper.getProperty("postal_code"));
        checkoutPage().tapContinue();
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("first_name_required_message"));
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithEmptyLastName() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName(propertiesHelper.getProperty("first_name"));
        checkoutPage().enterLastName("");
        checkoutPage().enterZipCode(propertiesHelper.getProperty("postal_code"));
        checkoutPage().tapContinue();
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("last_name_required_message"));
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithEmptyPostalCode() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName(propertiesHelper.getProperty("first_name"));
        checkoutPage().enterLastName(propertiesHelper.getProperty("last_name"));
        checkoutPage().enterZipCode("");
        checkoutPage().tapContinue();
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("postal_code_required_message"));
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithNumberFirstName() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName(propertiesHelper.getProperty("first_name_numbers"));
        checkoutPage().enterLastName(propertiesHelper.getProperty("last_name"));
        checkoutPage().enterZipCode(propertiesHelper.getProperty("postal_code"));
        checkoutPage().tapContinue();
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("first_name_requires_letters_message"));
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithNumberLastName() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName(propertiesHelper.getProperty("first_name"));
        checkoutPage().enterLastName(propertiesHelper.getProperty("last_name_numbers"));
        checkoutPage().enterZipCode(propertiesHelper.getProperty("postal_code"));
        checkoutPage().tapContinue();
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("last_name_requires_letters_message"));
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithLettersPostalCode() {
        productsPage().addProductToCartByIndex(1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(checkoutPage().isCheckoutPagePresent(), "The user is not redirected to the checkout page");
        propertiesHelper.loadProperties("properties/checkout.properties");
        checkoutPage().enterFirstName(propertiesHelper.getProperty("first_name"));
        checkoutPage().enterLastName(propertiesHelper.getProperty("last_name"));
        checkoutPage().enterZipCode(propertiesHelper.getProperty("postal_code_letters"));
        checkoutPage().tapContinue();
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("postal_code_requires_numbers_message"));
    }

    @Test
    public void verifyUnsuccessfulCheckoutWithEmptyCart() {
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
        cartPage().tapCheckout();
        Assert.assertTrue(cartPage().isCartEmpty(), "The cart is not empty!");
        Assert.assertFalse(checkoutPage().isErrorMessageDisplayed(), "Error message is not displayed!");
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(checkoutPage().getCheckoutErrorMessageText(), propertiesHelper.getProperty("empty_cart_message"));
    }

    @AfterMethod
    public void logout() {
        productsPage().tapProductsMenu();
        menuPage().tapLogout();
        Assert.assertTrue(menuPage().isLoginPageDisplayed(), "The user is not logged out");
    }
}
