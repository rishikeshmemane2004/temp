package tests;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.Driver.Driver;
import com.cs.ReadProperties.ReadPropertiesFile;

public class BaseTest {

	public static Properties prop;
	
	@BeforeSuite
	public void beforeSuite()
	{
		prop = ReadPropertiesFile.readPropertyFile();
	}
	
	@BeforeMethod
	public void tearUp()
	{
		 Driver.initDriver();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quitBrowser();
	}
}
