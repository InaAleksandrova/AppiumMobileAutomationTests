package com.swaglabs.constants;

import com.swaglabs.util.PropertiesHelper;

import java.time.Duration;

public class AppiumDriverConstants {

    private static PropertiesHelper propertiesHelper = new PropertiesHelper("properties/appium.properties");

    public static final String APPIUM_SERVER_IP = propertiesHelper.getProperty("appium_server_ip");
    public static final int APPIUM_SERVER_PORT = Integer.parseInt(propertiesHelper.getProperty("appium_server_port"));
    public static final Duration APPIUM_DRIVER_TIMEOUT = Duration.ofSeconds(
            Long.parseLong(propertiesHelper.getProperty("appium_driver_timeout_in_seconds"))
    );
}
