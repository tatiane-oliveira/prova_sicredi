package br.com.dbcompany.ProvaSicredi.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	public String getChromeDriverPath() {
		InputStream inputStream = null;
		String result = "";
		try {
			Properties prop = new Properties(); 
			inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file 'config.properties' not found in the classpath");
			}
			result = prop.getProperty("chromedriver.path");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}	
}
