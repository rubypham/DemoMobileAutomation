package com.auto.loader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auto.common.CommonConstant;
import com.auto.common.Split;
import com.auto.model.Keyword;

public class KeywordLoader extends BaseLoader {

	private Map<String, Map<String, Keyword>> packageToKeywordsMap;
	private String pkgName;

	@Override
	public void init() {
		packageToKeywordsMap = new HashMap<>();
		String kewordPkg = CommonConstant.KEYWORD_PACKAGE_BASE_DIR.replace(Split.DOT.toString(),
				Split.SLASH.toString());

		String realPath = ClassLoader.getSystemClassLoader().getResource(kewordPkg).toString();
		File dir = new File(realPath);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File foler : files) {
				this.pkgName = CommonConstant.KEYWORD_PACKAGE_BASE_DIR + Split.DOT.toString() + foler.getName();
				loadKeywordForPackage(realPath + Split.SLASH.toString() + foler.getName());

			}
		}

	}

	private void loadKeywordForPackage(String path) {
		try {
			URL resource = new URL(path);
			File directory = new File(resource.toURI());
			if (directory != null && directory.exists()) {
				String[] files = directory.list();
				for (String file: files) {
					if (!file.endsWith(".class")){
						continue;}
					String className = pkgName + '.' + file.substring(0, file.length() - 6);
					
					classTestSet.add(Class.forName(className));
				}
			}
		} catch (MalformedURLException e) {

		} catch (URISyntaxException e) {
		} catch (ClassNotFoundException e) {

		}

	}

}
