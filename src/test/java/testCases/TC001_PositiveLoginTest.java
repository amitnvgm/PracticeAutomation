package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.LoginSuccessPage;
import pageObject.PracticePage;
import testBase.Baseclass;

public class TC001_PositiveLoginTest extends Baseclass
{
	
	@BeforeClass
	public void logintoapp()
	{
		logger.info("***** login started ***** ");
		
		HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clicklogin();
		
		LoginPage lPage = new LoginPage(driver);
		lPage.enterusername("student"); 
		lPage.enterpassword("Password123");
		lPage.clickloginbutton();
		logger.info("***** login end ***** ");
	}
	
	@Test
	public void verifyurl()
	{
		logger.info("***** verify Url Test Started Started ***** ");
		
		LoginSuccessPage loginsuccess = new LoginSuccessPage(driver);
		String successurl=loginsuccess.checkurl();
		
		//System.out.println(successurl);
		
		if(successurl.equalsIgnoreCase("https://practicetestautomation.com/logged-in-successfully/"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
		
		logger.info("***** verify Url Test Started Ended ***** ");

	}
	@Test
	public void verifycongratulationmsg()
	{
		
		logger.info("***** verify congratulations msg test started ***** ");
		
		LoginSuccessPage loginsuccess = new LoginSuccessPage(driver);
		String expectedtxt=loginsuccess.checkecpectedtext();
		if(expectedtxt.equalsIgnoreCase("Logged In Successfully"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
		logger.info("***** verify congratulations msg test end ***** ");
		
	}
	
	
	@Test
	public void logoutbtncheck()
	{
		logger.info("***** verify logout button test started ***** ");
		LoginSuccessPage loginsuccess = new LoginSuccessPage(driver);
		boolean status =loginsuccess.logoutbtnstatus();
		if(status)
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
			
		logger.info("***** verify logout button test ended ***** ");
	}
	
}
