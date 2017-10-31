package com.auto.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TestSuite {

	protected String summary;
	protected List<TestCase> testCase;
	protected String id;
	protected String status;

	public TestSuite() {
		super();
		testCase = new ArrayList<TestCase>();
	}

	public TestSuite(String summary, List<TestCase> testCase, String id,
			String status) {
		super();
		this.summary = summary;
		this.testCase = testCase;
		this.id = id;
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@XmlElement
	public List<TestCase> getTestCase() {
		return testCase;
	}

	public void setTestCase(List<TestCase> testCase) {
		this.testCase = testCase;
	}

	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	@XmlAttribute
	public void setStatus(String status) {
		this.status = status;
	}

}
