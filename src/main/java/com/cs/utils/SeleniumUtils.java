package com.cs.utils;

import static com.cs.ReadProperties.ReadPropertiesFile.prop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.DriverManager.DriverManager;
import com.cs.enums.WaitTypes;

import reports.ExtentLogger;

public class SeleniumUtils {
	
	private static WebDriverWait waitUntilElementPresent()
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
		return wait;
	}
	
	private static WebElement getElement(By by, WaitTypes waitType, WebDriverWait wait) {
		
		WebElement element = null;
		
		if (waitType == WaitTypes.PRESENCE)
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		else if (waitType == WaitTypes.VISIBLE)
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
		else if (waitType == WaitTypes.CLICKABLE)
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
		
		return element;
	}
	
	
	public static void sendKeys(By by, String value, WaitTypes waitType, String elementName)
	{
		WebDriverWait wait =  waitUntilElementPresent();
		getElement(by, waitType, wait).sendKeys(value);
		ExtentLogger.pass(value + " entered successfully in " + elementName);
	}

	public static void click(By by, WaitTypes waitType, String elementName)
	{
		WebDriverWait wait = waitUntilElementPresent();
		getElement(by, waitType, wait).click();
		ExtentLogger.pass(elementName + " clicked successfully");
	}
}





