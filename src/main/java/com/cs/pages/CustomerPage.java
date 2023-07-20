package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.enums.WaitTypes;
import com.cs.utils.SeleniumUtils;

public class CustomerPage {

	private static final By TXT_FIRST_NAME = By.name("firstName");
	private static final By TXT_MIDDLE_NAME = By.name("middleName");
	private static final By TXT_LAST_NAME = By.name("lastName");
	private static final By BTN_SAVE = By.xpath("//button[@type='submit']");

	private CustomerPage setFirstName(String firstName)
	{
		SeleniumUtils.sendKeys(TXT_FIRST_NAME, firstName, WaitTypes.PRESENCE,"FIRST NAME");
		return this;
	}
	private CustomerPage setMiddleName(String middleName)
	{
		SeleniumUtils.sendKeys(TXT_MIDDLE_NAME, middleName, WaitTypes.PRESENCE,"MIDDLE NAME");
		return this;
	}
	private CustomerPage setLastName(String lastName)
	{
		SeleniumUtils.sendKeys(TXT_LAST_NAME, lastName, WaitTypes.PRESENCE,"LAST NAME");
		return this;
	}
	
	private CustomerPage clickOnSave()
	{
		SeleniumUtils.click(BTN_SAVE, WaitTypes.CLICKABLE,"SAVE BUTTON");
		return this;
	}
	
	public CustomerPage addCustomer(String firstName, String middleName, String lastName)
	{
		return setFirstName(firstName)
			.setMiddleName(middleName)
			.setLastName(lastName)
			.clickOnSave();
	}
}
