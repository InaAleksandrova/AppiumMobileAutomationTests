package com.swaglabs;

import com.swaglabs.BaseTests;
import com.swaglabs.util.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {

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
    public void addOneProductToCart() {
        productsPage().addProductToCartByIndex(1);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 1);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 1);
    }

    @Test
    public void addProductsToCart() {
        productsPage().addProductToCartByIndex(1);
        productsPage().addProductToCartByIndex(2);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 2);
        productsPage().tapProductsCart();
        Assert.assertTrue(cartPage().isCartPageVisible(), "Cart page is not displayed");
        Assert.assertEquals(cartPage().getItemsNumberInCart(), 2);
    }

    @Test
    public void addProductsToCartAndRemoveProduct() {
        productsPage().addProductToCartByIndex(1);
        productsPage().addProductToCartByIndex(2);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 2);
        productsPage().removeProductFromProductsByIndex(1);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 1);
    }

    @AfterMethod
    public void logout() {
        productsPage().tapProductsMenu();
        menuPage().tapLogout();
        Assert.assertTrue(menuPage().isLoginPageDisplayed(), "The user is not logged out");
    }
}
