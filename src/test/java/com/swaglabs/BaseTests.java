package com.swaglabs;

import com.swaglabs.driverFactory.AndroidDriverService;
import com.swaglabs.driverFactory.AppiumDriverService;
import com.swaglabs.pages.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTests {

    private AppiumDriverService appiumDriverService;
    private AndroidDriverService androidDriverService;
    private AppiumDriverLocalService appiumService;

    protected AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the services
        appiumDriverService = new AppiumDriverService();
        androidDriverService = new AndroidDriverService();

        // Start the Appium server
        appiumService = appiumDriverService.startAppiumService();

        // Initialize the Android driver with the running Appium service
        androidDriverService.initializeDriver(appiumService);

        // Get the driver instance to use in the tests
        driver = androidDriverService.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public ProductsPage productsPage() {
        return new ProductsPage(driver);
    }

    public CartPage cartPage() {
        return new CartPage(driver);
    }

    public CheckoutPage checkoutPage() {
        return new CheckoutPage(driver);
    }

    public MenuPage menuPage() {
        return new MenuPage(driver);
    }

    @AfterClass
    public void tearDown() {
        // Close the Android driver
        if (androidDriverService != null) {
            androidDriverService.closeDriver();
        }

        // Stop the Appium server
        if (appiumDriverService != null && appiumService != null) {
            appiumDriverService.stopAppiumService(appiumService);
        }
    }
}
