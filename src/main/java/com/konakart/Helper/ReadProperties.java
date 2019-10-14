package com.konakart.Helper;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 * This will load property file and return data.
 * 
 * @author indira.saravanan
 *
 */

public class ReadProperties {
	public static String properties(String elements, String path) throws IOException {
		Properties property = new Properties();
		FileInputStream stream;
		stream = new FileInputStream(path);
		property.load(stream);
		String data = property.getProperty(elements);
		return data;
	}

}
