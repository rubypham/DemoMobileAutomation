package com.auto.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

public class TestData implements Serializable, Cloneable{

	protected String name;
	protected String value;

	public TestData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestData(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(String value) {
		this.value = value;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
