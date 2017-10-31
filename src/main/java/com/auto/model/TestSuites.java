package com.auto.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestSuites {

	protected List<TestSuite> testSuite;

	public TestSuites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestSuites(List<TestSuite> testSuite) {
		super();
		this.testSuite = testSuite;
	}

	@XmlElement
	public List<TestSuite> getTestSuite() {
		if (testSuite == null) {
			testSuite = new ArrayList<TestSuite>();
		}
		return this.testSuite;
	}

	public void setTestSuite(List<TestSuite> testSuite) {
		this.testSuite = testSuite;
	}

}
