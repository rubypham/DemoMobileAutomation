package com.auto.loader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;

import org.apache.log4j.Logger;

import com.auto.common.CommonConstant;
import com.auto.common.Global;
import com.auto.model.TestSuites;

public class TestSuitesLoader extends BaseLoader {
	private static final Logger LOGGER = Logger.getLogger(TestSuitesLoader.class);

	private  TestSuites testSuites;
	private  Map<String, TestSuites> testSuitesMap;

	public TestSuitesLoader() {

	}

	public void init() {

		testSuites = new TestSuites();
		testSuitesMap = new HashMap<>();

		File folder = new File(Global.BASE_DIR + CommonConstant.OBJ_REPO_DIR);
		if (!folder.isDirectory()) {
			return;
		}

		File[] files = folder.listFiles();

		for (File f : files) {
			String fileName = f.getName();
			if ((fileName.length() > 3)
					&& (fileName.substring(fileName.length() - 3).equalsIgnoreCase(CommonConstant.XML))) {
				try {
					LOGGER.info("Loading testsuite file " + fileName);
					JAXBContext context = JAXBContext.newInstance(TestSuites.class);
					TestSuites testSuitesTemp = (TestSuites) context.createUnmarshaller().unmarshal(f);
					if (testSuitesTemp == null) {
						continue;
					}
					testSuites.getTestSuite().addAll(testSuitesTemp.getTestSuite());
					testSuitesMap.put(fileName, testSuitesTemp);
				} catch (Exception e) {
					LOGGER.info("Error while Loading testsuite  ");
				}
			}

		}

	}

	public  TestSuites getTestSuites() {
		return testSuites;
	}

	public  Map<String, TestSuites> getTestSuitesMap() {
		return testSuitesMap;
	}

}
