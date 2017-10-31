package com.auto.service;

import com.auto.loader.AppiumCapLoader;
import com.auto.loader.EnvironmentLoader;
import com.auto.loader.KeywordLoader;
import com.auto.loader.ObjectRepoLoader;
import com.auto.loader.TestSuitesLoader;

public class LoaderService {
	private AppiumCapLoader appiumCapLoader;
	private KeywordLoader keywordLoader;
	private ObjectRepoLoader objectRepoLoader;
	private TestSuitesLoader testSuitesLoader;
	private EnvironmentLoader environmentLoader;

	public LoaderService() {
		appiumCapLoader = new AppiumCapLoader();
		keywordLoader = new KeywordLoader();
		objectRepoLoader = new ObjectRepoLoader();
		testSuitesLoader = new TestSuitesLoader();
		environmentLoader = new EnvironmentLoader();
	}

	public void init() {
		appiumCapLoader.init();
		keywordLoader.init();
		objectRepoLoader.init();
		testSuitesLoader.init();
		environmentLoader.init();
	}

	public AppiumCapLoader getAppiumCapLoader() {
		return appiumCapLoader;
	}

	public void setAppiumCapLoader(AppiumCapLoader appiumCapLoader) {
		this.appiumCapLoader = appiumCapLoader;
	}

	public KeywordLoader getKeywordLoader() {
		return keywordLoader;
	}

	public void setKeywordLoader(KeywordLoader keywordLoader) {
		this.keywordLoader = keywordLoader;
	}

	public ObjectRepoLoader getObjectRepoLoader() {
		return objectRepoLoader;
	}

	public void setObjectRepoLoader(ObjectRepoLoader objectRepoLoader) {
		this.objectRepoLoader = objectRepoLoader;
	}

	public TestSuitesLoader getTestSuitesLoader() {
		return testSuitesLoader;
	}

	public void setTestSuitesLoader(TestSuitesLoader testSuitesLoader) {
		this.testSuitesLoader = testSuitesLoader;
	}

	public EnvironmentLoader getEnvironmentLoader() {
		return environmentLoader;
	}

	public void setEnvironmentLoader(EnvironmentLoader environmentLoader) {
		this.environmentLoader = environmentLoader;
	}

}
