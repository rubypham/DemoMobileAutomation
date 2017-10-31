/**
 * 
 * FACE_RECOGNITION PROPRIETARY
 * Copyright� 2014 FACE_RECOGNITION, INC.
 * UNPUBLISHED WORK
 * ALL RIGHTS RESERVED
 * 
 * This software is the confidential and proprietary information of
 * FACE_RECOGNITION, Inc. ("Proprietary Information").  Any use, reproduction, 
 * distribution or disclosure of the software or Proprietary Information, 
 * in whole or in part, must comply with the terms of the license 
 * agreement, nondisclosure agreement or contract entered into with 
 * FACE_RECOGNITION providing access to this software.
 */
package com.auto.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.auto.common.Global;
import com.auto.common.Split;
import com.auto.loader.AppiumCapLoader;
import com.auto.loader.EnvironmentLoader;
import com.auto.model.Configuration;
import com.auto.model.ObjectPath;

public class TestUtils {

	private static final Logger LOGGER = Logger.getLogger(TestUtils.class);

	public By getByFromObjectPath(String objectPath) {
		return Global.ObjectPathMap.get(objectPath);
	}

	@SuppressWarnings("unchecked")
	public static <T> T xmlToResponse(String xml, Class<T> clazz) throws JAXBException {
		Reader reader = new StringReader(xml);
		// setup object mapper using the ServiceConfig class
		JAXBContext context = JAXBContext.newInstance(clazz);

		return (T) context.createUnmarshaller().unmarshal(reader);
	}

	public static Document xmlToDocument(String xmlString) {
		Document doc = null;
		try {
			LOGGER.debug("Trying to Parse String: " + xmlString);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));
		} catch (Exception e) {
			LOGGER.debug(e.toString());
		}

		return doc;
	}

	public static NodeList getObjectUsingXPath(Document document, String objectPath) {
		NodeList nodeList = null;
		XPath xPath = XPathFactory.newInstance().newXPath();

		try {
			XPathExpression xp = xPath.compile(objectPath);
			nodeList = (NodeList) xp.evaluate(document, XPathConstants.NODESET);
		} catch (Exception e) {
		}
		return nodeList;

	}

	public static String executeCommand(String command) {
		StringBuffer response = new StringBuffer();
		StringBuffer error = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				response.append(line + "\n");
			}

			//
			BufferedReader readerError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = readerError.readLine()) != null) {
				error.append(line + "\n");
			}

			LOGGER.debug("Response\n" + response.toString());
			if (error.length() > 0) {
				LOGGER.debug("Error\n" + error.toString());
			}

			p.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.toString();

	}

	public static String getCmdResponse(final InputStream is) {
		StringBuffer output = new StringBuffer();
		final InputStreamReader streamReader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(streamReader);
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				output.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return output.toString();
	}

	public static List<String> stringToList(String string, Split split) {
		if (string != null && split != null) {
			return Arrays.asList(string.split(split.toString()));
		} else {
			return new ArrayList<>();
		}

	}

	public static Configuration getConfiguration(String device, String env) {
		Configuration configuration = new Configuration();
		configuration.setAppiumCap(AppiumCapLoader.getAppiumCapMap().get(device));
		configuration.setEnvironment(EnvironmentLoader.getEnvironmentMap().get(env));
		return configuration;
	}
}
