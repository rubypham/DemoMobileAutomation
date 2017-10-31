package com.auto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TestCase implements Serializable, Cloneable{

	protected String description;
	protected List<TestFlow> testFlow;
	protected String message;
	protected String id;
	protected String tester;
	protected String status;
	private String testResultFolder;
	boolean isUpdateStatus;
	boolean passed;

	public TestCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestCase(String description, List<TestFlow> testFlow,
			String message, String id, String tester, String status) {
		super();
		this.description = description;
		this.testFlow = testFlow;
		this.message = message;
		this.id = id;
		this.tester = tester;
		this.status = status;
		this.isUpdateStatus = false;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TestFlow> getTestFlow() {
		return testFlow;
	}

	@XmlElement
	public void setTestFlow(List<TestFlow> testFlow) {
		this.testFlow = testFlow;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getTester() {
		return tester;
	}

	@XmlAttribute
	public void setTester(String tester) {
		this.tester = tester;
	}

	public String getStatus() {
		return status;
	}

	@XmlAttribute
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestResultFolder() {
		return testResultFolder;
	}

	public void setTestResultFolder(String testResultFolder) {
		this.testResultFolder = testResultFolder;
	}

	public boolean isUpdateStatus() {
		return isUpdateStatus;
	}

	public void setUpdateStatus(boolean isUpdateStatus) {
		this.isUpdateStatus = isUpdateStatus;
	}
	
	
	
	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public Object clone() throws CloneNotSupportedException {
		TestCase clonedOject = (TestCase) super.clone();
		
			List<TestFlow> tfs = new ArrayList<>();
			
			for(TestFlow tf:this.testFlow){
				tfs.add((TestFlow) tf.clone());
			}
			
			clonedOject.setTestFlow(tfs);
		
		return clonedOject;
	}

}
