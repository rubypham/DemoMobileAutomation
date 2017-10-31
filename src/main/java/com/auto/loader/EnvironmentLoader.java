package com.auto.loader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.auto.common.CommonConstant;
import com.auto.common.Global;
import com.auto.common.Split;
import com.auto.model.Environment;
import com.auto.utils.PropertiesUtils;
import com.auto.utils.TestUtils;

public class EnvironmentLoader  extends BaseLoader{
	private static Map<String, Environment> environmentMap;

	public void init() {
		environmentMap = new HashMap<>();
		File folder = new File(Global.BASE_DIR + CommonConstant.DEVICES_DIR);
		if (folder.isDirectory()) {
			File[] devices = folder.listFiles();
			for (File device : devices) {
				environmentMap.put(device.getName(), loadEnvironment(device));
			}
		}


	}

	public Environment loadEnvironment(File file) {
		Environment environment = new Environment();
		environment.setFileName(file.getName());


		Properties props = PropertiesUtils.loadProperties(file);
		environment.setKewordPackage(props.getProperty("kewordPackage"));
		environment.setTestSuites(TestUtils.stringToList(props.getProperty("testSuites"), Split.COMMAS));

		return environment;

	}

	public static Map<String, Environment> getEnvironmentMap() {
		return environmentMap;
	}

}
