package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CoursePage;
import pageObject.HomePage;
import testBase.Baseclass;

public class TC012_BrokenLinksTest extends Baseclass
{
	
  @Test
  public void isBrokenLinkExist() 
  {
	  HomePage hPage = new HomePage(driver);
	  hPage.clickCoursesLink();
	  CoursePage cPage = new CoursePage(driver);
	  cPage.numberOfLink();
	  int totalbrokenlinks =cPage.findBrokenLinks();
	  System.out.println("count : " + totalbrokenlinks);
	  // links are coming broken here are working fine but getting response code>=400, b'coz 
	  // server might detecting automated request.
	  if(totalbrokenlinks>0)
		{
		  	Assert.fail();
		}
	  else 
	  	{
		  Assert.assertTrue(true);
	  	}
  }
}
