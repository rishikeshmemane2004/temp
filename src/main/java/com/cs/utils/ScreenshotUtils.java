package com.cs.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cs.DriverManager.DriverManager;

public final class ScreenshotUtils {

	private ScreenshotUtils() {}
	
	public static String getScreenShot()
	{
		return ( (TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}






