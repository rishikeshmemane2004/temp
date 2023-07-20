package com.cs.ReadProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static Properties prop = null;
	
	public static Properties readPropertyFile()
	{
		String fileName = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(fileName + " config file is not able to read");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(fileName + " config file is not able to load");
		}
		return prop;
		
	}
}
