package swagLabs.commonActions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetUp {
	
	
	private WebDriver driver;
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	public Constants constant = new Constants();
	
	
	public void setDriver(WebDriver driver) {
		
		threadLocal.set(driver);
		
	}
	
	public static WebDriver getDriver() {
		
		return threadLocal.get();
		
	}

	
	public void browserSetUp() {
		
		if(constant.isRemote()) {
			
			if(constant.getBrowser().equalsIgnoreCase("chrome")) {
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
				
				ChromeOptions options = new ChromeOptions();
				options.merge(cap);
				
				try {
					driver = new RemoteWebDriver(new URL(constant.getHubUrl()),options);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				
			}
			
			else if(constant.getBrowser().equalsIgnoreCase("edge")) {
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("MicrosoftEdge");
				cap.setPlatform(Platform.WINDOWS);
				
				try {
					driver = new RemoteWebDriver(new URL(constant.getHubUrl()),cap);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				
			}
			
			setDriver(driver);
			
		}
		
		else {
			
			if(constant.getBrowser().equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", constant.getChromeDriverPath());
				driver = new ChromeDriver();
				
			}
			else if(constant.getBrowser().equalsIgnoreCase("edge")) {
				
				System.setProperty("webdriver.edge.driver", constant.getEdgeDriverPath());
				driver = new EdgeDriver();
				
			}
			
			setDriver(driver);
			
		}
		
	}
	
	
	
}
