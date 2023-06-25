package swagLabs.commonActions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import swagLabs.pages.Login;
import swagLabs.utilities.CustomListener;
import swagLabs.utilities.ExcelReader;

public class CommonActions extends DriverSetUp{
	
	
	Properties prop;
	private ExcelReader excelReader;
	
	public CommonActions() {
		
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\Resources\\config\\config.properties");
			prop = new Properties();
			prop.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Login openUrl() {
		
		constant.setRemote(prop.getProperty("remote"));
		constant.setBrowser(prop.getProperty("browser"));
		
		if(constant.isRemote()) {
			
			constant.setHubUrl(prop.getProperty("hubUrl"));	
			
		}
		
		else {
			
			constant.setChromeDriverPath(prop.getProperty("chromedriverPath"));
			constant.setEdgeDriverPath(prop.getProperty("edgeDriverPath"));
			
		}
		
		browserSetUp();
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("applicationUrl"));
		
		
		return new Login(getDriver());
		
	}
	
	public void quit() {
		
		getDriver().quit();
		
	}
	
	public void setExcelReader(String path) {
		
		excelReader = new ExcelReader(path);
		
	}
	
	public ExcelReader gerExcelReader() {
		
		return excelReader;
	}
	
	public void extentLogInfo(String message) {
		
		CustomListener.testReport.get().log(LogStatus.INFO, message);
		
	}
	
	public void click(WebElement element) {
		
		element.click();
		extentLogInfo("clicked the element "+element);
		
	}
	
	public void type(WebElement element, String value) {
		
		element.sendKeys(value);
		extentLogInfo("Entered the "+value+" into element "+element);
		
	}
	
	public String getPageTitle() {
		
		String title = getDriver().getTitle();
		extentLogInfo("Page title is "+title);
		return title;
		
	}

}
