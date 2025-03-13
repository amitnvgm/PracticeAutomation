package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.PracticePage;
import pageObject.TestExceptionPage;
import testBase.Baseclass;

public class TC008_TimeoutExceptionTest extends Baseclass
{
  @Test
  public void verifysecondinputDisplayed() 
  {
	  	logger.info("***** verifysecondinputDisplayed Started ***** ");
	  
	  	HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clikexception();
		
		TestExceptionPage tpage = new TestExceptionPage (driver);
		tpage.addbtnaction();
		/*
		 	The second row shows up after about 5 seconds, so a 3-second timeout is not enough. 
		 	That’s why we will get TimeoutException while executing steps in the above test case.
		 	if we change implicit wait in base class <=3 then it will throw exception
		 */
		if(tpage.input2IsDisplayed())
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
		
		logger.info("***** verifysecondinputDisplayed ended ***** ");
  }
}
