/**
 * 
 * DIRECTV PROPRIETARY
 * Copyright© 2017 DIRECTV, INC.
 * UNPUBLISHED WORK
 * ALL RIGHTS RESERVED
 * 
 * This software is the confidential and proprietary information of
 * DIRECTV, Inc. ("Proprietary Information").  Any use, reproduction, 
 * distribution or disclosure of the software or Proprietary Information, 
 * in whole or in part, must comply with the terms of the license 
 * agreement, nondisclosure agreement or contract entered into with 
 * DIRECTV providing access to this software.
 */
package com.auto.Connector;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTestMobile {

	protected WebDriver webDriver;
	protected WebElement webElement;

	public static void main(String[] args) {
		BaseTestMobile baseTest = new BaseTestMobile();
		baseTest.initDriver();

		baseTest.wait(5);

		for (int i = 0; i < 10; i++) {
			System.out.println("Run " + i + 1);
			baseTest.checkMoviesBtn();
		}

		baseTest.goToMoviesScreen();

	}

	private void initDriver() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(
				"Simulator_NOX.properties").getFile());
		DesiredCapabilities cap = loadDesiredCapabilities(file);

		try {
			webDriver = new AndroidDriver(new URL(
					"http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		}
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void swipe(int startx, int starty, int endx, int endy) {
		swipe(startx, starty, endx, endy, 10000);
	}

	protected void swipe(int startx, int starty, int endx, int endy,
			int duration) {
		new TouchAction((AppiumDriver<WebElement>) webDriver)
				.press(startx, starty).waitAction(Duration.ofMillis(duration))
				.moveTo(endx, endy).release().perform();

	}

	private Properties loadProperties(File file) {
		Properties prop = new Properties();

		InputStream input;
		try {
			input = new FileInputStream(file);
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}

	private DesiredCapabilities loadDesiredCapabilities(File file) {
		DesiredCapabilities cap = new DesiredCapabilities();

		Properties capabilities = loadProperties(file);
		Properties props = loadProperties(file);
		Enumeration e = props.propertyNames();

		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			cap.setCapability(key, props.getProperty(key));
		}

		return cap;

	}

	private void checkMoviesBtn() {
		try {
			webElement = webDriver.findElement(By
					.xpath("//android.widget.TextView[@text='Movies']"));
			System.out.println("Movies Btn Exists: PASS");

		} catch (Exception e) {
			System.out.println("FAILED");
		}

	}

	private void goToMoviesScreen() {
		this.webElement.click();
		System.out.println("Go to Movies Screen: PASS");

	}

}
