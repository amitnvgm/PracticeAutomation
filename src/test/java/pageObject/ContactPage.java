package pageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage
{
  
	public ContactPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='wpforms-161-field_0']")
	WebElement inputFirstName;
	
	@FindBy(xpath = "//input[@id='wpforms-161-field_0-last']")
	WebElement inputLastName;
	
	@FindBy(xpath = "//input[@id='wpforms-161-field_1']")
	WebElement inputemail;
	
	@FindBy(xpath = "//textarea[@id='wpforms-161-field_2']")
	WebElement textcomment;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnsubmit;
	
	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	WebElement captchaCheckbox;
	
	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	WebElement iframElement;
	
	@FindBy(xpath = "//p[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]")
	WebElement confirmtxt;
	
	
	
	public void enterfirstname(String fname)
	{
		inputFirstName.sendKeys(fname);
	}
	public void enterlastname(String lname)
	{
		inputLastName.sendKeys(lname);
	}
	public void enteremail(String email)
	{
		inputemail.sendKeys(email);
	}
	public void entercomment(String comment)
	{
		textcomment.sendKeys(comment);
	}
	public void tickcaptchacheckbox()
	{
		driver.switchTo().frame(iframElement);
		captchaCheckbox.click();
	}
	
	public void clicksubmit()
	{
		driver.switchTo().defaultContent();
		btnsubmit.click();
	}
	
	public boolean issubmitdisplayed()
	{
		return btnsubmit.isDisplayed();
	}
	
	public boolean isFormSubmitted() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try 
	    {
	      WebElement confirmtxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]")));
	      return confirmtxt != null && confirmtxt.isDisplayed();
	    } 
	    catch (Exception e) 
	    {
	      return false;
	    }
	}
	
	/*
	public boolean isconfirmdisplayed()
	{	
		return confirmtxt.isDisplayed();
	}
	public boolean checkconfirmtxt()
	{
			
	return confirmtxt.getText().equalsIgnoreCase("Thanks for contacting us! We will be in touch with you shortly.");
		
	}
	*/
	
}

