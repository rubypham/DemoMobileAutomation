package com.auto.model;

public class Configuration {
	private AppiumCap appiumCap;
	private Environment environment;


	public Configuration init(String device, String kewordPkg){
		this.appiumCap = null;
		this.environment = null;
		return this;
	}

	public AppiumCap getAppiumCap() {
		return appiumCap;
	}

	public void setAppiumCap(AppiumCap appiumCap) {
		this.appiumCap = appiumCap;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

}
