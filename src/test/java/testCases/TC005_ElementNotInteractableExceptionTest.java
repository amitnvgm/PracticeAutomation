package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.PracticePage;
import pageObject.TestExceptionPage;
import testBase.Baseclass;

public class TC005_ElementNotInteractableExceptionTest extends Baseclass
{
	@Test
	public void ElementNotInteractableExceptionTest()
	{
		
		logger.info("***** ElementNotInteractableExceptionTest Started ***** ");
		
		HomePage hPage = new HomePage(driver);
		hPage.clickpracticelink();
		
		PracticePage practPage = new PracticePage(driver);
		practPage.clikexception();
		
		TestExceptionPage tpage = new TestExceptionPage (driver);
		tpage.addbtnaction();
		tpage.input2sendkeys();
		tpage.savebtn2click();  // there are two save buttons. one is invisible..and appear after input2 appear..
								//if find element by name('save') then it will generate ElementNotInteractableException. 
							
		if(tpage.confirmsave().equalsIgnoreCase("Row 2 was saved"))
		{
			Assert.assertTrue(true); 
		}
		else 
		{
			Assert.fail();
		}
		
		logger.info("***** ElementNotInteractableExceptionTest ended ***** ");
		
	}
}
