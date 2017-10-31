package com.auto.main;

import org.apache.log4j.Logger;

import com.auto.common.CommonConstant;
import com.auto.model.Configuration;
import com.auto.service.LoaderService;
import com.auto.utils.TestUtils;

public class AppRunner {
	private static final Logger LOGGER = Logger.getLogger(AppRunner.class);

	/**
	 * Execute cl ex: java -jar target/mobile-automation-0.0.1-SNAPSHOT.jar
	 * Simulator_iPhone7.properties environment.properties
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		init();

		String device;
		String env;

		switch (args.length) {
		case 2:
			device = args[0];
			env = args[1];
			break;
		case 1:
			device = args[0];
			env = CommonConstant.ENVIRONMENT_DEFAULT;
			LOGGER.warn("Missing environment config >> Using default environment " + env);
			break;

		default:
			device = CommonConstant.DEVICE_DEFAULT;
			env = CommonConstant.ENVIRONMENT_DEFAULT;
			LOGGER.warn("Missing device config >> Using default device " + device);
			LOGGER.warn("Missing environment config >> Using default environment " + env);
			break;
		}

		
		new TestManager().execute(device, env);

	}


}
