package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.DriverManager.DriverManager;
import com.cs.enums.WaitTypes;
import com.cs.utils.SeleniumUtils;

public class LoginPage {

	private static final By TXT_USERNAME = By.name("username");
	private static final By TXT_PASSWORD = By.name("password");
	private static final By BTN_LOGIN    = By.xpath("//button[@type='submit']");
	
	private LoginPage setUserName(String username)
	{
		SeleniumUtils.sendKeys(TXT_USERNAME,username,WaitTypes.PRESENCE,"USERNAME");
		return this;
	}
	
	private LoginPage setPassword(String password)
	{
		SeleniumUtils.sendKeys(TXT_PASSWORD,password,WaitTypes.VISIBLE,"PASSWORD");
		return this;
	}
	
	private HomePage clickLoginBtn()
	{
		SeleniumUtils.click(BTN_LOGIN,WaitTypes.CLICKABLE,"LOGIN BUTTON");
		return new HomePage();
	}
	
	public HomePage loginToappl(String username, String password)
	{
		return setUserName(username)
			.setPassword(password)
			.clickLoginBtn();
	}
	
	
	
	
	
}
