
package com.tripadvisor.webapp.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the Abstract class has declaration of common methods used by Page classes which would be inherited by BasePage class
 * @author Vrushali
 * this Class also sets WebDriverWait 
 */
public abstract class Page {
	
	protected WebDriver driver;
	WebDriverWait wait;

	/**
	 * 
	 * @param driver which is passes by inherited classes
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(WebElement element);
	
	public abstract void waitForElementToBePresent(WebElement element) ;
	
	public abstract void waitForPageTitle(String title);
	
	public abstract void waitForFrame(WebElement element);
		

}
