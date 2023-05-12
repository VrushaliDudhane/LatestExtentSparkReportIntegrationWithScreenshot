package com.tripadvisor.webapp.commons;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tripadvisor.webapp.base.BaseTest;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	ExtentSparkReporter spark;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports();
		spark=new ExtentSparkReporter("ExtentReport/spark.html");
		extent.attachReporter(spark);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();			
				buildTestNodes(context.getPassedTests(), Status.PASS);
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
			}
		}

		extent.flush();
	}

	private void buildTestNodes(IResultMap tests,Status status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());
				result.getMethod().getParameterTypes();
				Object currentClass = result.getInstance();
		        WebDriver driver = ((BaseTest) currentClass).getDriver();
		        String browserType=driver.getClass().toString().split(" ")[1];
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					ITestContext context = result.getTestContext();
					
					String screenshotPath=(String)context.getAttribute(result.getMethod().getMethodName());
					test.log(status,"FAILED on "+browserType, result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} else {
					
					test.log(status, "Test " + status.toLower()
							+ "ed on "+browserType);
				}
			}
		}
	}

}
