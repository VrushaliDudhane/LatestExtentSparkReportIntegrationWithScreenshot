
package com.tripadvisor.webapp.base;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



/**
 * This BaePage class extends the Page class and implements all the methods present
 * @author Vrushali
 *
 */
public class BasePage extends Page {

	public Logger logger=Logger.getLogger( BasePage.class.getName());
	
	public BasePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method gets the Title of the page
	 */
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * this method Gets the header of the page 
	 * @param locator of the Header
	 * @return String header
	 */
	@Override
	public String getPageHeader(WebElement element)
	{
		return element.getText();
	}



	/**
	 * This method waits for element to be present on DOM
	 * this method Handels the probable exception using try catch block and sets error message on logger with locator value
	 * @param locator of the WebElement
	 */
	@Override
	public void waitForElementToBePresent(WebElement element) {
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e)
		{
			logger.error(element+" element could Not Be found on DOM Within given wait time  "+e.getMessage());
			throw e;
		}
	}

	/**
	 * This method waits for page title to be get loaded
	 * @param String title of the page
	 */
	@Override
	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	/**
	 * This method waits for Frame to be get loaded
	 * @param WebElement locator 
	 */
	@Override
	public void waitForFrame(WebElement element) {
		try
		{
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		}catch (Exception e)
		{
			logger.error(element+" Frame is not available  "+ e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This method waits for element to be clickable
	 * this method Handels the probable exception using try catch block and sets error message on logger with locator value
	 * @param  WebElement
	 */
	public void waitForElementToBeClickable(WebElement element) {
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e)
		{
			logger.error(element+" Element Is not clickable  "+e.getMessage());
			throw e;
		}
	}
	
	
	public void waitForElementsToBePresent(List<WebElement> elements) {
		try
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}catch (Exception e)
		{
			logger.error(" element could Not Be found on DOM Within given wait time  "+e.getMessage());
			throw e;
		}
	}
	
	public void waitForElementsToBePresentByLocator(By locator,int number)
	{
		try
		{
			wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
		}catch (Exception e)
		{
			logger.error(locator+" element could Not Be found on DOM Within given wait time  "+e.getMessage());
			throw e;
		}
	}

//	public WebElement getElementByJavaScript(By locator)
//	{
// //needs to change 
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement element=(WebElement)js.executeScript("return document.querySelector(\"button[class='ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin']>span[class='textContainer']\")");
//		return element;
//	}
	

}
