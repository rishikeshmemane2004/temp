package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.DriverManager.DriverManager;
import com.cs.enums.WaitTypes;
import com.cs.utils.SeleniumUtils;

public class HomePage {

	private static final By OPTION_PIM = By.xpath("//span[text()='PIM']");
	private static final By TXT_SEARCH = By.xpath("//input[@placeholder='Search']");

	private static final By BTN_ADDCUSTOMER = By.xpath("(//button[@type='button'])[4]");
	
	public CustomerPage clickonAddCustomer()
	{
		SeleniumUtils.click(BTN_ADDCUSTOMER, WaitTypes.CLICKABLE,"ADD CUSTOMER");
		return new CustomerPage();
	}
	
	
	public void clickonPIM()
	{
		SeleniumUtils.click(OPTION_PIM, WaitTypes.CLICKABLE,"PIM OPTION");
	}
	
	public boolean isSearchPresent()
	{
		return DriverManager.getDriver().findElement(TXT_SEARCH).isDisplayed();
	}
	
	
	
}
