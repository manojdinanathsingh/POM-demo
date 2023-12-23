package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class cart extends AbstractComponent 
{
	WebDriver driver;
	
	public cart(WebDriver driver)
	{  super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
//	List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));

	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
//	driver.findElement(By.cssSelector(".totalRow button")).click();

	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
//	boolean match=cartProducts.stream().anyMatch(c-> c.getText().equalsIgnoreCase(productName));
	public Boolean VerifyProductDisplay(String productName)
	{
		boolean match=cartProducts.stream().anyMatch(c-> c.getText().equalsIgnoreCase(productName));
		return match;
	}
	 
	public CheckOutPage goToCheckout()
	{
		checkoutEle.click();
		return new CheckOutPage(driver);
	}
	
	

}
