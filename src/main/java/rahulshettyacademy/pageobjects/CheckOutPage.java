package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage  extends AbstractComponent
	{
		WebDriver driver;
		public CheckOutPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		@FindBy(css="[placeholder='Select Country']")
		WebElement country;
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='ta-results']")));
		@FindBy(css="[class*='ta-results']")
		WebElement dropDownCountry;
		
//		driver.findElement(By.xpath("//span[text()=' India']")).click();
		@FindBy(xpath="//span[text()=' India']")
		WebElement SelectCountry;
		
		By results=By.cssSelector("[class*='ta-results']");
		
		public void selectCountry(String countryName)
		{
			Actions a=new Actions(driver);
			a.sendKeys(country, countryName).build().perform();
			waitForElementsToAppear(By.cssSelector("[class*='ta-results']"));
			SelectCountry.click();
		}
//		driver.findElement(By.cssSelector("a.btnn.action__submit.ng-star-inserted")).click();
		@FindBy(css="a.btnn.action__submit.ng-star-inserted")
		WebElement SubmitButton;
				
		public ConfirmationPage SubmitOrder()
		{
			SubmitButton.click();
			return new ConfirmationPage(driver);
		}
		

		



}
