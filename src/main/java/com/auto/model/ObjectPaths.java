package com.auto.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder="originalObjectPath")
@XmlRootElement(name = "objectPaths")
public class ObjectPaths {
	private List<OriginalObjectPath> originalObjectPath;

	public ObjectPaths() {
	}

	public List<OriginalObjectPath> getOriginalObjectPath() {
		if(originalObjectPath==null){
			originalObjectPath = new ArrayList<>();
		}
		
		return originalObjectPath;
	}

	public void setOriginalObjectPath(List<OriginalObjectPath> originalObjectPath) {
		this.originalObjectPath = originalObjectPath;
	}


}
