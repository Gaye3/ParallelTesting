package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import swagLabs.commonActions.CommonActions;

public class Products extends CommonActions{
	
	WebDriver driver;
	
	public Products(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
	private WebElement filter;
	
	@FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
	private WebElement price;
	
	@FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")
	private WebElement productDetails;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cart;
	
	public void addProdToCart(String product) {
		
		driver.findElement(By.id("add-to-cart-"+product.toLowerCase().replace(" ", "-"))).click();
		extentLogInfo("added "+product+" to cart");
		
	}
	
	public boolean isProductsDisplayed() {
		
		for(int i=0;i<6;i++) {
			
			 if(driver.findElement(By.id("item_"+i+"_title_link")).isDisplayed()) {
				 extentLogInfo("Products are displayed");
				 return true;
			 }
		}
		return false;
	}
	
	public void filterProducts(String option) {
		
		Select select = new Select(filter);
		select.selectByVisibleText(option);
		
	}
	
	public String getProductPrice(String product) {
		
		String value = null;
			
		for(int i=0;i<6;i++) {
				
			WebElement prod = driver.findElement(By.id("item_"+i+"_title_link"));
				
			if(prod.getText().equalsIgnoreCase(product)){
				prod.click();
				value = price.getText();
				break;
			}	
		}
		
		return value;
		
	}
	
	public String getProductDetails(String product) {
		
		String value = null;
		
		for(int i=0;i<6;i++) {
				
			WebElement prod = driver.findElement(By.id("item_"+i+"_title_link"));
				
			if(prod.getText().equalsIgnoreCase(product)){
				prod.click();
				value = productDetails.getText();
				break;
			}	
		}
		
		return value;
		
	}

	public Cart goToCart() {
		
		click(cart);
		return new Cart(driver);
	}
	
}
