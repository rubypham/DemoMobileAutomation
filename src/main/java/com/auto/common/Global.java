package com.auto.common;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.auto.model.AppiumCap;

public class Global {
	public static final String BASE_DIR = System.getProperty("base.dir");

	public static String testCaseId;
	public static String testSuiteId;

	public static String platformName;
	public static String device;
	public static String appiumServerURL;

	public static AppiumCap appiumCap;
	public static Map<String, AppiumCap> appiumCapMap = new HashMap<>();

}
