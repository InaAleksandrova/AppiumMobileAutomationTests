package com.swaglabs;

import com.swaglabs.BaseTests;
import com.swaglabs.util.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    private PropertiesHelper propertiesHelper;

    @BeforeMethod
    public void setUpProperties() {
        propertiesHelper = new PropertiesHelper();
    }

    @Test
    public void validLoginTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("standard_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        Assert.assertTrue(productsPage().isProductsPageVisible());
    }

    @Test
    public void invalidLoginWithLockedOutUserTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("locked_out_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(loginPage().getErrorMessageText(), propertiesHelper.getProperty("locked_out_user_error_message"));
        Assert.assertFalse(productsPage().isProductsPageVisible());
    }

    @Test
    public void invalidLoginWithInvalidUserTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("invalid_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(loginPage().getErrorMessageText(), propertiesHelper.getProperty("invalid_username_password_error_message"));
        Assert.assertFalse(productsPage().isProductsPageVisible());
    }

    @Test
    public void invalidLoginWithInvalidPasswordTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("standard_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("invalid_password"));
        loginPage().clickLoginButton();
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(loginPage().getErrorMessageText(), propertiesHelper.getProperty("invalid_username_password_error_message"));
        Assert.assertFalse(productsPage().isProductsPageVisible());
    }

    @Test
    public void invalidLoginWithEmptyUserTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername("");
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(loginPage().getErrorMessageText(), propertiesHelper.getProperty("empty_username_error_message"));
        Assert.assertFalse(productsPage().isProductsPageVisible());
    }

    @Test
    public void invalidLoginWithEmptyPasswordTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("standard_user"));
        loginPage().enterPassword("");
        loginPage().clickLoginButton();
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(loginPage().getErrorMessageText(), propertiesHelper.getProperty("empty_password_error_message"));
        Assert.assertFalse(productsPage().isProductsPageVisible());
    }

    @Test
    public void invalidLoginWithEmptyDataTest() {
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername("");
        loginPage().enterPassword("");
        loginPage().clickLoginButton();
        propertiesHelper.loadProperties("properties/errorMessages.properties");
        Assert.assertEquals(loginPage().getErrorMessageText(), propertiesHelper.getProperty("empty_username_error_message"));
        Assert.assertFalse(productsPage().isProductsPageVisible());
    }

//    @AfterMethod
//    public void logout() {
//        productsPage().tapProductsMenu();
//        menuPage().tapLogout();
//        Assert.assertTrue(menuPage().isLoginPageDisplayed(), "The user is not logged out");
//    }
}
