package testCases;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ContactPage;
import pageObject.HomePage;
import testBase.Baseclass;

public class TC010_ContactFormTest extends Baseclass
{
  @Test
  public void contactform() throws InterruptedException, TimeoutException 
  {
	  HomePage hPage = new HomePage(driver);
	  hPage.clickcontactlink();
	  
	  ContactPage cPage = new ContactPage(driver);
	  
	  // enter new contact info. 
	  cPage.enterfirstname("ketan");
	  cPage.enterlastname("patel");
	  cPage.enteremail("n@gmail.com");
	  cPage.entercomment("i am learning");
	  cPage.tickcaptchacheckbox();
	  Thread.sleep(15000); // wait 20 seconds to solve captcha manually 
	  cPage.clicksubmit();  
	  	  		  
	  if (cPage.isFormSubmitted()) 
	  {
		 
		  Assert.assertTrue( true);

      } 
	  else 
	  {
		  Assert.fail();      
	  }
	  
  }
}
