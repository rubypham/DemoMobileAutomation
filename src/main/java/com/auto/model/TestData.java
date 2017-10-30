package com.auto.model;

import javax.xml.bind.annotation.XmlAttribute;

public class TestData {

	@XmlAttribute(name = "name")
	protected String name;

	@XmlAttribute(name = "value")
	protected String value;

	public TestData() {
		super();
	}

	public TestData(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
