package com.cs.DriverFactory;

import static com.cs.ReadProperties.ReadPropertiesFile.prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {
	
	private DriverFactory() {};
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browser)
	{
	if (browser.equalsIgnoreCase("chrome"))
		driver = new ChromeDriver();
	else if (browser.equalsIgnoreCase("edge"))
		driver = new EdgeDriver();
	else if (browser.equalsIgnoreCase("firefox"))
		driver = new FirefoxDriver();
	else
		throw new RuntimeException("Invalid browser set into config.properties file");
	
	 return driver;
	}
}
