/**
 * 
 */
package com.tripadvisor.webapp.base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.tripadvisor.webapp.utilities.PropertyFileReader;
import com.tripadvisor.webapp.utilities.TimeOutsProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Vrushali
 *
 */
public abstract class BaseTest {
 
	protected WebDriver driver;
	Logger logger=Logger.getLogger(BaseTest.class.getName());
	
	
	public WebDriver getDriver() {
        return this.driver;
     }
	
	/**
	 * This Before method opens the home page before every test 
	 * @param browser this browser parameter is given by testng.xml
	 */
	@Parameters("Browser")
	@BeforeMethod
	public void init(String browser)
	{
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(opt);
			
		}

		else if (browser.equalsIgnoreCase("microsoftEdge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(opt);
		}
		logger.trace("opened browser: "+browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.PAGETIMEOUT));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(PropertyFileReader.readConfigFile().getProperty("url"));
		logger.trace("opened the URL :"+driver.getCurrentUrl());
	}
	/**
	 * this method annotated with AfterMethod 
	 * which gets executed after every test
	 */
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	
	}
	
}
