package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.commonActions.CommonActions;

public class Login extends CommonActions{
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement login;
	
	
	public Products userLogin(String username,String pass) {
		
		type(userName,username);
		type(password,pass);
		click(login);
		
		return new Products(driver);
		
	}

}
