package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSuccessPage extends BasePage
{
  public LoginSuccessPage(WebDriver driver)
  {
	  super(driver);
  }
  
  @FindBy(xpath = "//div//h1[@class='post-title']")
	WebElement expectedtext;
	
  @FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement logoutbtn;

  public String checkurl()
	{
		return driver.getCurrentUrl();
	}
	public String checkecpectedtext()
	{
		return expectedtext.getText();
	}
	public boolean logoutbtnstatus()
	{
		return logoutbtn.isDisplayed();
	}
	public void clicklogout()
	{
		logoutbtn.click();
	}
}
