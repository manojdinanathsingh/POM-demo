package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class landingpage extends AbstractComponent {
	WebDriver driver;
	public landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement userEmail=driver.findElement(By.cssSelector("input#userEmail"));
	
//	Page Factory
	@FindBy(css="input#userEmail")
	WebElement userEmail;
	
	@FindBy(css="input#userPassword")
	WebElement passwordEle;
	
	@FindBy(css="input#login")
	WebElement submit;
	
	public void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
