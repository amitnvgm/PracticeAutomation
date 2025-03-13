package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends BasePage
{
	public PracticePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Test Login Page']")
	WebElement linkloginpag;
	
	@FindBy(xpath = "//a[normalize-space()='Test Exceptions']")
	WebElement linkexceptionpage;
	
	
	public void clicklogin()
	{
		linkloginpag.click();
	}
	public void clikexception()
	{
		linkexceptionpage.click();
	}
  
}
