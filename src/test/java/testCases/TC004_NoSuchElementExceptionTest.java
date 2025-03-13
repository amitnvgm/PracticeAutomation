package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.PracticePage;
import pageObject.TestExceptionPage;
import testBase.Baseclass;

public class TC004_NoSuchElementExceptionTest extends Baseclass
{
	@Test
	public void verifyrow2input() throws InterruptedException
	{
		logger.info(" ****verifyrow2input Started ****");
		
		HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clikexception();
		
		TestExceptionPage tpage = new TestExceptionPage (driver);
		tpage.addbtnaction();
		//Thread.sleep(2000); // if we don't add implicit wait in base class then this test will fail,
		//bcoz input2 takes time to load and it will raise NoSuchElementException
		
		if(tpage.input2IsDisplayed())
		{
			Assert.assertTrue(true);
		}
		else 
		{
				Assert.fail();
		}
		
		logger.info(" ****verifyrow2input ended ****");
		
	}
	
	
  
}

