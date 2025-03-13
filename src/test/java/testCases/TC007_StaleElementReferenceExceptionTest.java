package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.PracticePage;
import pageObject.TestExceptionPage;
import testBase.Baseclass;

public class TC007_StaleElementReferenceExceptionTest extends Baseclass
{
  @Test
  public void verifyinstuctiondisremoved() 
  {
	  	logger.info("***** verifyinstuctiondisremoved Started ***** ");
	  	
	  	HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clikexception();
		
		TestExceptionPage tpage = new TestExceptionPage (driver);
		tpage.addbtnaction();
		
		/* The instructions element is removed from the page when the second row is added (when click on add button). 
			That’s why we can no longer interact with it. so when we call tpage.instructionstatus(), 
			it will throw a exception , which confirms that instruction element is removed, 
			so in catch we have called Assert.assertTrue(true); */
		try
		{
			if(tpage.instructionstatus())
			{
				Assert.fail();
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		catch (Exception e) 
		{
			Assert.assertTrue(true);
		}
		
		logger.info("***** verifyinstuctiondisremoved ended ***** ");
  }
}
