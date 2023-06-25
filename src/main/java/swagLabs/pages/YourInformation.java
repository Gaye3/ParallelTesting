package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.commonActions.CommonActions;

public class YourInformation extends CommonActions{
	
	WebDriver driver;
	
	public YourInformation(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postCode;
	
	@FindBy(id="cancel")
	private WebElement cancel;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	public void setFirstName(String fName) {
		
		type(firstName,fName);
		
	}
	
	public void setLastName(String lName) {
		
		type(lastName,lName);
		
	}
	
	public void setPostCode(String pCode) {
		
		type(postCode,pCode);
		
	}
	
	public Cart clickCancel() {
		
		click(cancel);
		return new Cart(driver);
		
	}
	
	public OverView clickContinue() {
		
		click(continueBtn);
		return new OverView(driver);
		
	}
	
	
	

}
