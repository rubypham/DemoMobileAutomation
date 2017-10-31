package com.auto.model;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumCap {
	private String fileName;
	private String port;
	private String platformName;
	private String device;
	private String appiumServerURL;
	private DesiredCapabilities desiredCapabilities;

	public AppiumCap() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getAppiumServerURL() {
		return appiumServerURL;
	}

	public void setAppiumServerURL(String appiumServerURL) {
		this.appiumServerURL = appiumServerURL;
	}

	public DesiredCapabilities getDesiredCapabilities() {
		return desiredCapabilities;
	}

	public void setDesiredCapabilities(DesiredCapabilities desiredCapabilities) {
		this.desiredCapabilities = desiredCapabilities;
	}

}
