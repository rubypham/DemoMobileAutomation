package com.auto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "originalObjectPath", propOrder = { "name", "iosPath", "androidPath" })
public class OriginalObjectPath {
	@XmlElement
	private String name;

	private ObjectPath iosPath;

	private ObjectPath androidPath;

	public OriginalObjectPath() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ObjectPath getIosPath() {
		return iosPath;
	}

	public void setIosPath(ObjectPath iosPath) {
		this.iosPath = iosPath;
	}

	public ObjectPath getAndroidPath() {
		return androidPath;
	}

	public void setAndroidPath(ObjectPath androidPath) {
		this.androidPath = androidPath;
	}

}
