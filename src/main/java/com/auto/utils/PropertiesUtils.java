package com.auto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	public static Properties loadProperties(File file) {
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
}
