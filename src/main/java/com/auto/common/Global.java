package com.auto.common;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.auto.model.AppiumCap;
import com.auto.model.ObjectPaths;

public class Global {
	public static final String BASE_DIR = System.getProperty("user.dir");

	public static String testCaseId;
	public static String testSuiteId;

	public static String platformName;
	public static String device;
	public static String appiumServerURL;

	public static AppiumCap appiumCap;
	public static Map<String, AppiumCap> appiumCapMap;

	public static Map<String, By> ObjectPathMap;

	public static ObjectPaths objectPaths;

	public static boolean isIOS = false;
	public static boolean isAndroid = false;


}
