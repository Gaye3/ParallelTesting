package swagLabs.utilities;


import java.sql.Timestamp;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener implements ITestListener{
	
	public static ExtentReports extentReport = ExtentManager.getInstance();
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		//ITestListener.super.onTestStart(result);
		ExtentTest test = extentReport.startTest(result.getName().toUpperCase());
		testReport.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//logger.info(result.getName()+" Test Passed");
		testReport.get().log(LogStatus.PASS, result.getName()+" Test Passed");
		extentReport.endTest(testReport.get());
		extentReport.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//logger.info(result.getName()+" Test Failed");
		testReport.get().log(LogStatus.FAIL, result.getName()+" Test Failed with: "+result.getThrowable());
		
		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());
		
		String temp = timestamp2.toString().replace(" ", "_").replace(":","_").replace("-", "_").replace(".", "_");
		
		ExtentManager.takeSnapShot(System.getProperty("user.dir")+"\\Screenshots\\"+temp+".png");
		testReport.get().log(LogStatus.FAIL, testReport.get().addScreenCapture(System.getProperty("user.dir")+"\\Screenshots\\"+temp+".png"));
		
		extentReport.endTest(testReport.get());
		extentReport.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//logger.info(result.getName()+" Test Skipped");
		testReport.get().log(LogStatus.SKIP, result.getName()+" Test Skipped with: "+result.getThrowable());
		extentReport.endTest(testReport.get());
		extentReport.flush();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		//extentReport.flush();
	}
	
	
}
