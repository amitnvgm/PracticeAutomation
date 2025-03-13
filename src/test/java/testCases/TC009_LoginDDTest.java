package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.LoginSuccessPage;
import pageObject.PracticePage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC009_LoginDDTest extends Baseclass
{
  
  @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
  public void dtdlogin(String username, String Password,String expectedresult) 
  {
	  
	  logger.info("***** login from excel data started ***** ");
		
		HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clicklogin();
		
		LoginPage lPage = new LoginPage(driver);
		lPage.enterusername(username); 
		lPage.enterpassword(Password);
		lPage.clickloginbutton();
		
		LoginSuccessPage loginsuccess = new LoginSuccessPage(driver);
		String successurl=loginsuccess.checkurl();
		
		boolean actualresult =successurl.equalsIgnoreCase("https://practicetestautomation.com/logged-in-successfully/");
		
		if(expectedresult.equalsIgnoreCase("valid"))
		{
			if(actualresult==true)
			{
				Assert.assertTrue(true);
				loginsuccess.clicklogout();	
			}
			else 
			{
				Assert.fail();
			}
		}
		if(expectedresult.equalsIgnoreCase("Invalid")) 
		{
			if(actualresult==true)
			{
				Assert.fail();
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		
		
		//System.out.println(successurl);
		/*
		if(successurl.equalsIgnoreCase("https://practicetestautomation.com/logged-in-successfully/"))
		{
			if(expectedresult.equalsIgnoreCase("pass"))
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}*/
		
		
		
		logger.info("***** login from excel data end ***** ");
	  
  }
}
