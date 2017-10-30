package com.auto.basetest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.auto.common.Global;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class BaseTest {
	private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

	protected WebDriver driver;
	protected WebElement webElement;

	By settingIcon = new By.ById("Settings icon");
	By doneBtn = new By.ByXPath("//XCUIElementTypeButton[@label='Done']");

	public void demoTest() {
		System.out.println("################## Start testing");

		tap(settingIcon);
		tap(doneBtn);

		System.out.println("################## Done testing");

	}

	public void initDriver() {

		try {
			driver = new IOSDriver<MobileElement>(new URL(Global.appiumServerURL),
					Global.appiumCap.getDesiredCapabilities());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		}

		setImplicitWait(20, TimeUnit.SECONDS);

	}

	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void tap(By by) {
		if (getElement(by)) {
			this.webElement.click();
		}
	}

	boolean getElement(By by) {
		try {
			this.webElement = (MobileElement) driver.findElement(by);
			LOGGER.debug("Element found: " + by.toString());
			return true;
		} catch (Exception e) {
			LOGGER.debug("Element not found: " + by.toString());
			return false;
		}

	}

	void setImplicitWait(long time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	public void fluentWait(final By by, long time, TimeUnit unit) {

	}

	// protected void swipe(int startx, int starty, int endx, int endy) {
	// swipe(startx, starty, endx, endy, 10000);
	// }
	//
	// protected void swipe(int startx, int starty, int endx, int endy, int
	// duration) {
	// new TouchAction((AppiumDriver<WebElement>) appiumDriver).press(startx,
	// starty)
	// .waitAction(Duration.ofMillis(duration)).moveTo(endx,
	// endy).release().perform();
	//
	// }
	//
	// private void checkMoviesBtn() {
	// try {
	// mobileElement = (MobileElement) appiumDriver
	// .findElement(By.xpath("//android.widget.TextView[@text='Movies']"));
	// System.out.println("Movies Btn Exists: PASS");
	//
	// } catch (Exception e) {
	// System.out.println("FAILED");
	// }
	//
	// }
	//
	// private void goToMoviesScreen() {
	// this.mobileElement.click();
	// System.out.println("Go to Movies Screen: PASS");
	//
	// }

}
