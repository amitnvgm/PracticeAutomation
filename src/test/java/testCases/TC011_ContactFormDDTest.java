package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ContactPage;
import pageObject.HomePage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC011_ContactFormDDTest extends Baseclass
{
  
	 @Test(dataProvider = "Contactdata",dataProviderClass = DataProviders.class)
	  public void contactform(String fname,String lname,String email,String msg,String exptresult) throws InterruptedException 
	  {
		  HomePage hPage = new HomePage(driver);
		  hPage.clickcontactlink();
		  
		  ContactPage cPage = new ContactPage(driver);
		  
		  // enter new contact info. 
		  cPage.enterfirstname(fname);
		  cPage.enterlastname(lname);
		  cPage.enteremail(email);
		  cPage.entercomment(msg);
		  cPage.tickcaptchacheckbox();
		  Thread.sleep(20000); // wait 20 seconds to solve captcha manually 
		  cPage.clicksubmit();  
		  
		  if(exptresult.equalsIgnoreCase("Valid"))
		  {
			  
			  if (cPage.isFormSubmitted()) 
			  {
				Assert.assertTrue( true);
		      } 
			  else 
			  {
				Assert.fail();      
			  }
			  
		  }
			 
		  if(exptresult.equalsIgnoreCase("Invalid"))
		  {
			  
			  if (cPage.isFormSubmitted()) 
			  {
				
				Assert.fail(); 
		      } 
			  else 
			  {
				
				Assert.assertTrue( true);
			  }
			  
		  }
		  
		  
	  }
	
  
}
