package com.swaglabs.constants;

import com.swaglabs.util.PropertiesHelper;

public class AndroidDriverConstants {

    private static PropertiesHelper propertiesHelper = new PropertiesHelper("properties/android.properties");

    public static final String ANDROID = "android";
    public static final String ANDROID_DEVICE_NAME = propertiesHelper.getProperty("android_device_name");
    public static final String ANDROID_APP_FILE_PATH = propertiesHelper.getProperty("android_app_file_path");
    public static final String ANDROID_APP_PACKAGE = propertiesHelper.getProperty("android_app_package");
    public static final String ANDROID_APP_ACTIVITY = propertiesHelper.getProperty("android_app_activity");
    public static final String ANDROID_NO_RESET = propertiesHelper.getProperty("android_no_reset");
    public static final String ANDROID_FULL_RESET = propertiesHelper.getProperty("android_full_reset");
}
