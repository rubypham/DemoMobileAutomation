package com.auto.main;

import org.apache.log4j.Logger;

import com.auto.basetest.BaseTest;
import com.auto.common.CommonConstant;
import com.auto.common.Global;

public class AppRunner {
	private static final Logger LOGGER = Logger.getLogger(AppRunner.class);
	/**
	 * Execute cl ex: java -jar target/mobile-automation-0.0.1-SNAPSHOT.jar Simulator_iPhone7.properties
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			LOGGER.warn("Missing device >> Using default device!");
		}else{
			Global.device = args[0];
		}
		
		Global.appiumCap = Global.appiumCapMap.get(Global.device);
		Global.appiumServerURL = CommonConstant.APPIUM_SERVER_URL_DEFAULT.replace("4723", Global.appiumCap.getPort());


		BaseTest baseTest = new BaseTest();
		baseTest.initDriver();

		baseTest.demoTest();
	}
}
