package rahulshettyacademy.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class StandAloneTest2 {

	public static void main(String[] args) {
		
		String productName= "I PHONE2";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		landingpage landingPage=new landingpage(driver);
		landingPage.goTo();
		landingPage.loginApplication("manojdinanthsingh@gmail.com","MRUNMAYI.singh@1");
		
//		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("manojdinanthsingh@gmail.com");
//		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("MRUNMAYI.singh@1");
//		driver.findElement(By.cssSelector("input#login")).click();
		
//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
//		List<WebElement> products= driver.findElements(By.cssSelector("div.mb-3"));
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement>products= productCatalogue.getProductList();
		
		
		
//	WebElement prod=products.stream().filter(p->
//		p.findElement(By.cssSelector("b")).getText().equals("I PHONE")).findFirst().orElse(null);		
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		productCatalogue.addProductToCart(productName);
		
		
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		ng-animating
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		productCatalogue.goToCartPage();
		
//		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
		cart cartPage=new cart(driver);
		
		
//		boolean match=cartProducts.stream().anyMatch(c-> c.getText().equalsIgnoreCase(productName));
		Boolean match= cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage=cartPage.goToCheckout();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutpage.SubmitOrder();
		
		
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		
//		Actions a=new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='ta-results']")));
//		driver.findElement(By.xpath("//span[text()=' India']")).click();
		
//		driver.findElement(By.cssSelector("a.btnn.action__submit.ng-star-inserted")).click();
		
		
		String cnfmsg= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(cnfmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	}

}
