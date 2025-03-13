package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PracticePage;
import testBase.Baseclass;

public class TC002_NegativeUserNameTest extends Baseclass
{
  
	@Test
	public void negativeusername() throws InterruptedException
	{
		logger.info("***** Negative username test started ***** ");
		
		HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clicklogin();
		
		LoginPage lPage = new LoginPage(driver);
		lPage.enterusername("stude");
		lPage.enterpassword("Password123");
		lPage.clickloginbutton();
		
		Thread.sleep(2000); //add wait to avoid test case failed delay in displaying in message
		if(lPage.errormsgdisplay())
		{
			
			if(lPage.errortext().equalsIgnoreCase("Your username is invalid!"))
			{
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.fail();
			}
		}
		else 
		{
			Assert.fail();
		}
		
		logger.info("***** Negative username test ended ***** ");
	}
	
	
	
	
}
