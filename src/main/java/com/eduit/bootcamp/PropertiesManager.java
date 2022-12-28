package com.eduit.bootcamp;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManager {
	
	public static Properties buildProperties(final String path) throws Exception {
		Properties output = new Properties();
		FileInputStream fis = new FileInputStream(path);
		output.load(fis);
		return output;
	}

}
