package com.auto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.openqa.selenium.By;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( name="objectPath", propOrder = { "name", "type", "value" })
public class ObjectPath {
	@XmlElement
	private String name;

	@XmlElement
	private String value;

	@XmlElement
	private String type;
	
	private By by;

	public ObjectPath() {
		super();
	}

	public ObjectPath(String name, String value, String type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public By getBy() {
		return by;
	}

	public void setBy(By by) {
		this.by = by;
	}
	
	

}
