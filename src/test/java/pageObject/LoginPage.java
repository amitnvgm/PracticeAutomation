package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
  
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// locate elements 
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement inputUsername;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement inputpassword;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement clikloginbtn;
	
	@FindBy(xpath = "//div[@class='show']")
	WebElement errormsg;
	
	
	public void enterusername(String username)
	{
		inputUsername.sendKeys(username);
	}
	public void enterpassword(String password)
	{
		inputpassword.sendKeys(password);
	}
	public void clickloginbutton()
	{
		clikloginbtn.click();
	}
	
	public boolean errormsgdisplay()
	{
		return errormsg.isDisplayed();
	}
	public String errortext()
	{
		return errormsg.getText();
	}
	
	
	
}
