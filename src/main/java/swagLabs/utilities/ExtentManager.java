package swagLabs.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import swagLabs.commonActions.DriverSetUp;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		
		if(extent == null) {
			
			extent = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\SwagLabsReport.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\Resources\\extentConfig\\extentConfigFile.xml"));
			
		}
		
		return extent;
	}
	
	public static void takeSnapShot(String path) {
		
		TakesScreenshot screenshot = ((TakesScreenshot) DriverSetUp.getDriver());
		File Srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		File Destfile = new File(path);
		try {
			FileUtils.copyFile(Srcfile,Destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
