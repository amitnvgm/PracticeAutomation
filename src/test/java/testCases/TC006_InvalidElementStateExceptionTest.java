package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.PracticePage;
import pageObject.TestExceptionPage;
import testBase.Baseclass;

public class TC006_InvalidElementStateExceptionTest extends Baseclass
{
  @Test
  public void disabledinput() throws InterruptedException 
  {
	  
	  	logger.info("***** disabledinput Started ***** ");
	  
	  	HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clikexception();
		
		TestExceptionPage tpage = new TestExceptionPage (driver);
		
		//input1 is disabled by default so if you directly try to clear value it will throw InvalidElementStateException
		// so first we need to enable input1 by click on edit button, then we will able to clear and enter value to it
		tpage.editbtnaction();
		tpage.input1action();  
		tpage.savebtn1click();
		
		Thread.sleep(2000); //add wait to avoid test case failed delay in displaying in message
		
		//System.out.println(tpage.confirmsave());
		
		if(tpage.confirmsave().equalsIgnoreCase("Row 1 was saved"))
		{
				Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
		
		logger.info("***** disabledinput ended ***** ");
  }
}
