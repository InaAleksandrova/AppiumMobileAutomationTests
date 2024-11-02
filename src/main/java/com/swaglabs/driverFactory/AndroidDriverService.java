package com.swaglabs.driverFactory;

import com.swaglabs.constants.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.File;

import static com.swaglabs.constants.AndroidDriverConstants.ANDROID_APP_PACKAGE;

public class AndroidDriverService {

    private AndroidDriver androidDriver;

    public void initializeDriver(AppiumDriverLocalService appiumService) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(AndroidDriverConstants.ANDROID_DEVICE_NAME)
                .setApp(new File(AndroidDriverConstants.ANDROID_APP_FILE_PATH).getAbsolutePath())
                .setAppActivity(AndroidDriverConstants.ANDROID_APP_ACTIVITY)
                .setNoReset(Boolean.parseBoolean(AndroidDriverConstants.ANDROID_NO_RESET))
                .setFullReset(Boolean.parseBoolean(AndroidDriverConstants.ANDROID_FULL_RESET))
                .autoGrantPermissions();

        androidDriver = new AndroidDriver(appiumService.getUrl(), options);
        androidDriver.manage().timeouts().implicitlyWait(AppiumDriverConstants.APPIUM_DRIVER_TIMEOUT);
    }

    public void closeDriver() {
        androidDriver.terminateApp(ANDROID_APP_PACKAGE);
    }

    public AppiumDriver getDriver() {
        return androidDriver;
    }
}
