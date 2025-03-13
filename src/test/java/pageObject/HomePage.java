package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(xpath = "//a[normalize-space()='Practice']")
	WebElement linkPractice;
	
	/*
	@FindBy (linkText = "CONTACT")
	WebElement contactlink;*/
	
	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement contactlink;
	
	@FindBy(xpath = "//a[normalize-space()='Courses']")
	WebElement coursesLink;
	
	public void clickpracticelink()
	{
		linkPractice.click();
	}
	public void clickcontactlink()
	{
		contactlink.click();
	}
	public void clickCoursesLink()
	{
		coursesLink.click();
	}

}