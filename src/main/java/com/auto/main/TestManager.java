package com.auto.main;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;

import com.auto.basetest.BaseTest;
import com.auto.common.CommonConstant;
import com.auto.loader.TestSuitesLoader;
import com.auto.model.AppiumCap;
import com.auto.model.Configuration;
import com.auto.model.Status;
import com.auto.model.TestCase;
import com.auto.model.TestFlow;
import com.auto.model.TestStep;
import com.auto.model.TestSuite;
import com.auto.model.TestSuites;
import com.auto.service.LoaderService;
import com.auto.utils.TestUtils;

public class TestManager {
	private static final Logger LOGGER = Logger.getLogger(TestManager.class);
	
	private String kewordPkg;
	private Configuration config;
	private TestSuites testSuites;
	private TestSuite testSuite;
	private TestCase testCase;
	private TestFlow testFlow;
	private TestStep testStep;
	
	private LoaderService loaderService;
	
	private AppiumCap appiumCap;

	public void execute(String device, String env ) {
		loaderService = new LoaderService();
		loaderService.init();
		
		this.config =  TestUtils.getConfiguration(device, env);

		
		init();

		BaseTest baseTest = new BaseTest();
		baseTest.initDriver();

		baseTest.demoTest();

	}

	
	private void init() {
		
		initAppiumCap();
		initTestSuites();
		
	}
	
	private void initTestSuites() {
		List<String> testSuitesFile = this.config.getEnvironment().getTestSuites();
		
		this.testSuites = new TestSuites();
		this.testSuites.getTestSuite().add(loaderService.getTestSuitesLoader().getTestSuitesMap())
		
	}


	private void initAppiumCap(){
		this.appiumCap = config.getAppiumCap();
		this.appiumCap.setAppiumServerURL(CommonConstant.APPIUM_SERVER_URL_DEFAULT.replace("4723", appiumCap.getPort()));
	}
	
	private void executeTestSuite(){
		List<TestCase> testCases = this.testSuite.getTestCase();
		for (TestCase tc : testCases) {
			this.testCase = tc;
			executeTestCase();
			
		}

	}

	public void executeTestCase(){
		LOGGER.info("================================================");
		LOGGER.info("Running test case " + testCase.getDescription());
		StringBuffer message = new StringBuffer();
		// clear all information from previous running
		testCase.setUpdateStatus(false);
		testCase.setStatus(Status.RUN);
		testCase.setPassed(false);
		testCase.setMessage("");
		
		List<TestFlow> testFlows = testCase.getTestFlow();
		for (TestFlow tf : testFlows) {
			this.testFlow = tf;
			
			try {
				executeTestFlow();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		testCase.setMessage(message.toString());
		
	}
	
	

	private void executeTestFlow(){
		LOGGER.info("Running test flow: " + testFlow.getKeyword();
		try {
			/**
			 * invoke to the page
			 */
			Method getPage = CSImpl.class.getDeclaredMethod(testFlow.getTestPage());
			getPage.setAccessible(true);
			Object page = getPage.invoke(cs);
	
			/**
			 * invoke to method of the page
			 */
			Method method;
			int dataSize = 0;
	
			if (testFlow.getTestData() != null) {
				dataSize = testFlow.getTestData().size();
			}
	
			switch (dataSize) {
			case 1:
				method = page.getClass().getDeclaredMethod(testFlow.getMethod(),
						String.class);
				method.setAccessible(true);
				method.invoke(page, testFlow.getTestData().get(0).getValue());
				break;
				
			case 2:
				method = page.getClass().getDeclaredMethod(testFlow.getMethod(),
						String.class, String.class);
				method.setAccessible(true);
				method.invoke(page, testFlow.getTestData().get(0).getValue(), testFlow
						.getTestData().get(1).getValue());
	
				break;
				
			case 3:
				method = page.getClass().getDeclaredMethod(testFlow.getMethod(),
						String.class, String.class, String.class);
				method.setAccessible(true);
				method.invoke(page, testFlow.getTestData().get(0).getValue(), testFlow
						.getTestData().get(1).getValue(), testFlow.getTestData().get(2)
						.getValue());
	
				break;
				
			case 4:
				method = page.getClass().getDeclaredMethod(testFlow.getMethod(),
						String.class, String.class, String.class, String.class);
				method.setAccessible(true);
				method.invoke(page, testFlow.getTestData().get(0).getValue(), testFlow
						.getTestData().get(1).getValue(), testFlow.getTestData().get(2)
						.getValue(), testFlow.getTestData().get(3).getValue());
	
				break;
	
			default:
				method = page.getClass().getDeclaredMethod(testFlow.getMethod());
				method.setAccessible(true);
				method.invoke(page);
			}

			testFlow.setStatus(Status.PASSED);
			if (!tc.isUpdateStatus()){
				tc.setStatus(Status.PASSED);
				tc.setPassed(true);
				tc.setUpdateStatus(true);
			}
			
		} catch (Exception e) {
			testFlow.setMessage(e.getCause().toString());
			testFlow.setStatus(Status.FAILED);
			testFlow.setScreenShort(ScreenShotUtil.takeScreenShot(cs.getDriver(), configuration.PROFILE_NAME, tc.getId()));
			if (!Status.FAILED.equals(tc.getStatus())){
				tc.setStatus(Status.FAILED);
				tc.setPassed(false);
				tc.setUpdateStatus(true);
			}
			message.append("\n").append(testFlow.getTestPage()).append(testFlow.getMethod()).append(":").append(testFlow.getMessage());
			e.printStackTrace();
		}

	}
	
}
