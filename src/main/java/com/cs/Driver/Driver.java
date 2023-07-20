package com.cs.Driver;

import static com.cs.ReadProperties.ReadPropertiesFile.prop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.cs.DriverFactory.DriverFactory;
import com.cs.DriverManager.DriverManager;

public final class Driver {

	private Driver() {};
	
	private static WebDriver driver;

	public static WebDriver initDriver() {
		String browser = prop.getProperty("browser");
		if (DriverManager.getDriver()==null)
		{
			driver = DriverFactory.getBrowser(browser);
			DriverManager.setDriver(driver);
		}
		DriverManager.getDriver().get(prop.getProperty("url"));
		if (Boolean.parseBoolean(prop.getProperty("maxwindow")))
			DriverManager.getDriver().manage().window().maximize();

		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));

		return driver;
	}
	
	public static void quitBrowser()
	{
		if (DriverManager.getDriver()!=null)
		{
			DriverManager.getDriver().quit();
			DriverManager.setDriver(null);
		}
	}
}
