package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.commonActions.CommonActions;

public class Cart extends CommonActions{
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="continue-shopping")
	private WebElement shopping;
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	
	public Products goToProducts() {
		click(shopping);
		return new Products(driver);
	}

	public void removeProductFromCart(String product) {
		
		driver.findElement(By.id("remove-"+product.toLowerCase().replace(" ", "-"))).click();
		
	}
	
	public YourInformation clickCheckout() {
		
		click(checkout);
		return new YourInformation(driver);
		
	}
	
}
