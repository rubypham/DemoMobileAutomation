package com.auto.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "testFlow", propOrder = { "testData", "keyword" })
public class TestFlow {

	protected String description;
	protected List<TestData> testData;
	@XmlElement
	protected String keyword;
	protected String status;
	protected List<TestStep> testStep;

	public TestFlow() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TestData> getTestData() {
		return testData;
	}

	public void setTestData(List<TestData> testData) {
		this.testData = testData;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TestStep> getTestStep() {
		return testStep;
	}

	public void setTestStep(List<TestStep> testStep) {
		this.testStep = testStep;
	}

	public Object clone() throws CloneNotSupportedException {
		TestFlow clonedOject = (TestFlow) super.clone();

		if (this.testData != null && this.testData.size() > 0) {
			List<TestData> datas = new ArrayList<TestData>();
			for (TestData data : this.testData) {
				datas.add((TestData) data.clone());
			}

			clonedOject.setTestData(datas);
		}

		return clonedOject;
	}

}
