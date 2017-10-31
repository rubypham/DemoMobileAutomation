package com.auto.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.openqa.selenium.By;

import com.auto.common.CommonConstant;
import com.auto.common.Global;
import com.auto.model.ObjectPath;
import com.auto.model.ObjectPaths;
import com.auto.model.OriginalObjectPath;

public class ObjectRepoLoader  extends BaseLoader{
	private static ObjectPaths objectPaths;

	public void init() {
		objectPaths = new ObjectPaths();
		File folder = new File(Global.BASE_DIR + CommonConstant.OBJ_REPO_DIR);
		if (!folder.isDirectory()) {
			return;
		}

		File[] files = folder.listFiles();

		for (File f : files) {
			try {
				InputStream is = new FileInputStream(f);
				JAXBContext context = JAXBContext.newInstance(ObjectPaths.class);

				ObjectPaths objectPathsTemp = (ObjectPaths) context.createUnmarshaller().unmarshal(is);
				if (objectPathsTemp == null) {
					continue;
				}
				objectPaths.getOriginalObjectPath().addAll(objectPathsTemp.getOriginalObjectPath());
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Load object path " + f.getAbsolutePath() + " failed: " + ex.getMessage());
			}
		}

	}

	public Map<String, By> buildObjectPath() {
		Map<String, By> objectPathMap = new HashMap<>();
		By by = null;
		List<OriginalObjectPath> originalObjectPathList = objectPaths.getOriginalObjectPath();
		for (OriginalObjectPath oriObjPath : originalObjectPathList) {
			if (Global.isIOS) {
				by = getBy(oriObjPath.getIosPath());
			} else if (Global.isAndroid) {
				by = getBy(oriObjPath.getAndroidPath());

			}

			objectPathMap.put(oriObjPath.getName(), by);
		}
		return objectPathMap;

	}

	public By getBy(ObjectPath objPath) {
		return getBy(objPath.getType(), objPath.getValue());
	}

	public By getBy(String type, String value) {
		By by = null;
		switch (type) {
		case "XPath":
			by = new By.ByXPath(value);
			break;

		case "Id":
		default:
			by = new By.ById(value);
			break;
		}

		return by;
	}

}
