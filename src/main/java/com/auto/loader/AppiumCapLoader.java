package com.auto.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.auto.common.CommonConstant;
import com.auto.common.Global;
import com.auto.model.AppiumCap;
import com.auto.utils.PropertiesUtils;

public class AppiumCapLoader {

	private Map<String, AppiumCap> appiumCapMap = new HashMap<>();

	public void loadAppiumCap() {
		
		File folder = new File(Global.BASE_DIR + "/devices");
		if (folder.isDirectory()) {
			File[] devices = folder.listFiles();
			for (File device : devices) {
				appiumCapMap.put(device.getName(), loadAppiumCap(device));
			}
		}
		
		Global.appiumCapMap.putAll(appiumCapMap);

	}

	public AppiumCap loadAppiumCap(File file) {
		AppiumCap appiumCap = new AppiumCap();
		appiumCap.setFileName(file.getName());

		DesiredCapabilities cap = new DesiredCapabilities();

		Properties props = PropertiesUtils.loadProperties(file);
		Enumeration<?> e = props.propertyNames();

		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			if (CommonConstant.PLATFORM_NAME.equals(key)) {
				appiumCap.setPlatformName(props.getProperty(key));
			} else {
				cap.setCapability(key, props.getProperty(key));
			}
		}
		appiumCap.setDesiredCapabilities(cap);

		return appiumCap;

	}

}
