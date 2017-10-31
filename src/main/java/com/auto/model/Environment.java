package com.auto.model;

import java.util.ArrayList;
import java.util.List;

public class Environment {
	private String fileName;
	private String kewordPackage;
	private List<String> testSuites;

	public Environment() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getKewordPackage() {
		return kewordPackage;
	}

	public void setKewordPackage(String kewordPackage) {
		this.kewordPackage = kewordPackage;
	}

	public List<String> getTestSuites() {
		if(testSuites==null){
			this.testSuites = new ArrayList<>();
		}
		return testSuites;
	}

	public void setTestSuites(List<String> testSuites) {
		this.testSuites = testSuites;
	}

}
