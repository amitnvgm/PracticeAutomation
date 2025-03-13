package pageObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends BasePage
{
	public CoursePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(tagName = "a")
	List<WebElement> linkElements;
	
	public void numberOfLink()
	{
		
		System.out.println(linkElements.size());
	}
	 public int findBrokenLinks()
	 {
		 int brokenlinkcount = 0;
		 for(WebElement link:linkElements)
		 {
			 String linkhref=link.getAttribute("href");
			 
			 if(linkhref==null || linkhref.isEmpty())
			 {
				 System.out.println(linkhref);
				 continue;
			 }
			 
			 try 
			 {
				 URL url = new URL(linkhref);
				 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				 connection.connect();
				 int responsecode = connection.getResponseCode();
				 if(responsecode>=400)
				 {
					 brokenlinkcount++;
					 System.out.println("boken link url : " + linkhref + "-Response code : " + responsecode);
					 
				 }
				
			 }
			
			 catch (Exception e) 
			 {
				e.printStackTrace();
			 } 
		 }
		   return brokenlinkcount;
	 }
  
}
