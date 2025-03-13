package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PracticePage;
import testBase.Baseclass;

public class TC003_NegativePasswordTest extends Baseclass
{
  
	@Test
	public void negativepassword()
	{
		logger.info("***** Negative password test started ***** ");
		
		HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clicklogin();
		
		LoginPage lPage = new LoginPage(driver);
		lPage.enterusername("student");
		lPage.enterpassword("Password1");
		lPage.clickloginbutton();
		
		
		if(lPage.errormsgdisplay())
		{
			if(lPage.errortext().equalsIgnoreCase("Your password is invalid!"))
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
		logger.info("***** Negative password test ended ***** ");
	}
	
	
	
	
}
