# LatestExtentSparkReportIntegrationWithScreenshot
Parallel Cross Browser Testing With Spark Extent Report by implementing TestNG IReportListener

To run the code
git clone https://github.com/VrushaliDudhane/LatestExtentSparkReportIntegrationWithScreenshot.git
mvn clean test

This repository demonstrates the integration of Spark extent report version 5 in Selenium with TestNG.
I have created a test Suite where 2 different tests are running in parallel on different browsers.
With this code, we can create a very clean spark report which has a much better look than the TestNG report.
This code also demonstrates to attach the screenshot of failed test cases with the report

Under the commons package, I have created the class ExtentReporterTestNG which implements the IReporter Interface of TestNG.
Using IReporter has a special reason.
This interface can be implemented by clients to generate a report. Its method generateReport() will be invoked after all the suites have run and the parameters give all the test results that happened during that run. So while running tests in parallel under a given suite we do not face a synchronization issue.
The second parameter this method passes list of all suits. After iterating over this list we can get the result of the suite run (With ISuiteResult).
From this result, we can get the test context(with ITestContext) which contains all the information for a given test run. From this, we can get the list of all passed, failed, and skipped methods.
Now we can segregate the passed, failed, and skipped methods.
We can traverse the methods from these groups we can get the result of each method. 

Under the commons package, I have created the TestListner class which extends ITestListener. Which is a listener for test running. So when any method gets fail I am getting the screenshot of the current driver window and save it as an attribute under ITestContext. The key I am using to the attribute is the name of the method so this won't let the attribute override. Here as I run the tests in parallel ITestContext will be separate for each test.

Along with this, I am attaching failed Test case Screenshot to TestNG Report with Reporter.log() method which makes the TestNG report even more understandable. 
