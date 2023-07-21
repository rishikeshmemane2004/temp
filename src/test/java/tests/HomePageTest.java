package tests;

 

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotations;
import com.cs.pages.CustomerPage;
import com.cs.pages.HomePage;
import com.cs.pages.LoginPage;
import com.github.javafaker.Faker;

public class HomePageTest extends BaseTest{

	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {
				{ "Admin","admin123"}
							  };
	}
	
	@FrameworkAnnotations(author = "Siddhesh",category = {"smoke","regression","Customer Mgmt"})
	@Test(dataProvider="getData",description="Verifying home page test")
	public void verifyHomePageTest(String un, String pw)
	{
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginToappl(un,pw);
		Assert.assertTrue(homePage.isSearchPresent(),"Search text did not display !!!"); 
	}
	
	@FrameworkAnnotations(author = "Ravi",category = "smoke")
	@Test(description="Verifying add customer functionality")
	public void verifyAddCustomer()
	{
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginToappl("Admin","admin123");
		Assert.assertTrue(homePage.isSearchPresent(),"Search text did not display !!!");
		homePage.clickonPIM();
		CustomerPage customerPage = homePage.clickonAddCustomer();
		
		
//		customerPage.addCustomer("hitesh_"+System.currentTimeMillis(), "Sanjay_"+System.currentTimeMillis(), "Patil_"+System.currentTimeMillis());
		
		Faker faker = new Faker();
		String fName = faker.name().firstName();
		String mName = faker.name().firstName();
		String lName = faker.name().lastName();
		customerPage.addCustomer(fName, mName, lName);
			try {
				Thread.sleep(5000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false,"Search text did not display !!!");
	}
}
