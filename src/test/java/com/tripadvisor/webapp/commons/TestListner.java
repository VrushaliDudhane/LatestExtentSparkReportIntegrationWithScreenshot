/**
 * 
 */
package com.tripadvisor.webapp.commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.tripadvisor.webapp.base.BaseTest;
import com.tripadvisor.webapp.utilities.TakingScreenShots;


/**
 * This class implements ITestListner Interface
 * This class demonstrate how to catch screenshot of failed test cases and save to folder ScreenShots//FailedTestCases
 * @author Vrushali
 * 
 *
 */
public class TestListner implements ITestListener {
	
	Logger logger=Logger.getLogger(TestListner.class.getName());
	
	public void onTestFailure(ITestResult result) {
		ITestContext testContext=result.getTestContext();
		logger.error(result.getMethod().getMethodName() + " Test case is failed");
		Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
    
		TakingScreenShots objTakingScreenShots=new TakingScreenShots();
		String capturedScreenshotPath=objTakingScreenShots.takingScreenshot(driver);
		testContext.setAttribute(result.getMethod().getMethodName(), capturedScreenshotPath);
		Reporter.log("<a href="+capturedScreenshotPath+">TESTRESULT</a>");
	  }
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()  + " Test case is successful");
	  }
	
	public void onTestSkipped(ITestResult result) {
		logger.debug(result.getMethod().getMethodName() + " Test case is skipped");
	  }

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName()  + " Test case is started");
		
	  }
}
