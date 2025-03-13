package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestExceptionPage extends BasePage
{
  
	public TestExceptionPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//p[@id='instructions']")
	WebElement instruction;
	
	@FindBy(xpath = "//div[@id='row1']//input[@class='input-field']")
	WebElement input1;
	
	@FindBy(xpath = "//div[@id='row2']//input[@class='input-field']")
	WebElement input2;
	
	@FindBy(xpath = "//div[@id='row1']//button[@id='edit_btn']")
	WebElement editbtn;
	
	@FindBy(xpath = "//button[@id='add_btn']")
	WebElement addbtn;
	
	@FindBy(xpath = "//div[@id = 'row1']//button[@id='save_btn']")
	WebElement savebtn1;
	
	@FindBy(xpath = "//div[@id = 'row2']//button[@id='save_btn']")
	WebElement savebtn2;
	
	@FindBy(xpath = "//div[@id = 'confirmation']")
	WebElement saveconfirmmsg;
	
	
	public void input1action()
	{
		input1.clear();
		input1.sendKeys("hello");
	}
	public boolean input2IsDisplayed()
	{
		return input2.isDisplayed();
	}
	public void input2sendkeys()
	{
		input2.sendKeys("testing");
	}
	
	public void editbtnaction()
	{
		editbtn.click();
	}
	public void addbtnaction()
	{
		addbtn.click();
	}
	public void savebtn1click()
	{
		savebtn1.click();
	}
	
	public void savebtn2click()
	{
		savebtn2.click();
	}
	public String confirmsave()
	{
		return saveconfirmmsg.getText();
	}
	public boolean instructionstatus()
	{
	   return instruction.isDisplayed();
	}
}
