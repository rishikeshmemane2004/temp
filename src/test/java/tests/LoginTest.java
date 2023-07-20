package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotations;
import com.cs.pages.HomePage;
import com.cs.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@FrameworkAnnotations(author = "Kattapa",category = "regression")
	@Test(description="Verifying login test")
	public void verifyLoginTest()
	{
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginToappl("Admin","admin123");
		Assert.assertTrue(homePage.isSearchPresent(),"Search text did not display !!!");
	}
}
