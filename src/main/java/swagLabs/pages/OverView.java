package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.commonActions.CommonActions;

public class OverView extends CommonActions{
	
	WebDriver driver;
	
	public OverView(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="finish")
	private WebElement finish;
	
	@FindBy(id="cancel")
	private WebElement cancel;
	
	@FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
	private WebElement successMsg;
	
	@FindBy(id="back-to-products")
	private WebElement backHome;
	
	public String getTotalPrice() {
		
		extentLogInfo("Total price of products: "+totalPrice.getText());
		return totalPrice.getText();
		
	}
	
	public Products clickCancel() {
		
		click(cancel);
		return new Products(driver);
		
	}
	
	public void clickFinish() {
		
		finish.click();
		
	}
	
	public String isSucessMsgDisplayed() {
		
		extentLogInfo("Success message: "+successMsg.getText());
		return successMsg.getText();
		
	}
	
	public Products clickBackHome() {
		
		click(backHome);
		return new Products(driver);
		
	}

}
