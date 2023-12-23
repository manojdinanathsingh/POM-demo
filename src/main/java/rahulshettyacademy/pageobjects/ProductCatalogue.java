package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver  driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	By productsBy=By.cssSelector("div.mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
//	List<WebElement> products= driver.findElements(By.cssSelector("div.mb-3"));
	@FindBy(css="div.mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
    WebElement spinner;
	
	public List<WebElement> getProductList()
	{
		waitForElementsToAppear(productsBy);
		return products;
	}
	public WebElement GetProductsByName(String productName)
	{
		WebElement prod=products.stream().filter(p->
		p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName)
	{
		WebElement prod=GetProductsByName(productName);
		prod.findElement(addToCart).click();
		waitForElementsToAppear(toastMessage);
		waitForElementsToDissapear(spinner);
		
	}
	

}
