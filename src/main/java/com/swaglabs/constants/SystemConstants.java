package com.swaglabs.constants;

public class SystemConstants {


    private static final String DEFAULT_ENV = "dev";
    private static final String DEFAULT_PLATFORM = "android";

    public static final String EXECUTION_ENV_NAME = getEnvironmentName();
    public static final String MOBILE_PLATFORM_NAME = getPlatformName();

    private static String getEnvironmentName() {
        String environmentName = System.getProperty("environment");
        if (environmentName != null) {
            return environmentName.toLowerCase();
        } else {
            System.err.println("The Maven Profile is missing the environment configuration. Using default: " + DEFAULT_ENV);
            return DEFAULT_ENV;
        }
    }

    private static String getPlatformName() {
        String platformName = System.getProperty("platform");
        if (platformName != null) {
            return platformName.toLowerCase();
        } else {
            System.err.println("The Maven Profile is missing the platform configuration. Using default: " + DEFAULT_PLATFORM);
            return DEFAULT_PLATFORM;
        }
    }


}
