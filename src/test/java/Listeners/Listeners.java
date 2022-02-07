package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.Base;
import resources.Reports;

public class Listeners extends Base implements ITestListener{
	ExtentReports extent= Reports.reportsNG();
	ExtentTest Test;
	
	public void onTestStart(ITestResult result) {
		
		Test=extent.createTest(result.getMethod().getMethodName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		Test.log(Status.PASS, "Test Passed");

		
	}

	public void onTestFailure(ITestResult result) {
		Test.log(Status.FAIL, "Test failed");
		Test.fail(result.getThrowable());	
		WebDriver driver=null;
		String TestMethodname=result.getMethod().getMethodName();
	
	
		try {
			
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
			catch (Exception e1) {
				System.out.print("Exception is "+e1);
			}
			
			//String ScreenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+TestMethodname+".png";
			//System.out.println("In Listerens "+ScreenshotPath);
			
			try {
				Test.addScreenCaptureFromPath(CaptureScreenShot(TestMethodname,driver));
			} catch (Exception e) {
			
			} 
			
			
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();		
	}


}
