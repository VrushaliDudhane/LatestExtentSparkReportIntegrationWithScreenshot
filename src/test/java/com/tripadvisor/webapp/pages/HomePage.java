/**
 * 
 */
package com.tripadvisor.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tripadvisor.webapp.base.BasePage;

/**
 * This is the Page class for Home page of the application this class has two
 * parts first part contains all the By locators of the Home page WebElements
 * and second part contains all the action methods on page
 * 
 * @author Vrushali
 *
 */
public class HomePage extends BasePage {

	// private By logo=By.cssSelector("img[class='TRRBg _R']");
	@FindBy(css = "img[class='TRRBg _R']")
	WebElement logo;

	// private By signInLink=By.cssSelector("a[class='rmyCe _G B- z _S c Wc wSSLS w
	// jWkoZ sOtnj']");
	@FindBy(css = "a[class='rmyCe _G B- z _S c Wc wSSLS w jWkoZ sOtnj']")
	WebElement signInLink;

	// private By signInFrame=By.cssSelector("iframe[class='bFOrV _R B- o']");
	@FindBy(css = "iframe[class='bFOrV _R B- o']")
	WebElement signInFrame;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * these are the getters of WebElements these methods wait for perticular
	 * webelement to be get displayed and return that webElement to the caller
	 * @return title of the page
	 */

	public String getTheHomePageTitle() {
		waitForPageTitle(
				"Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more");
		return getPageTitle();
	}

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public boolean isSignInDisplayed() {
		return signInLink.isDisplayed();
	}

	/**
	 * this method click on sign in link which opens the iframe
	 * 
	 * @return SignIn Page object
	 */
	public SignInPage clickOnSignIn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 //waitForElementToBeClickable(signInLink);
		signInLink.click();
		//waitForFrame(signInFrame);
		driver.switchTo().frame(signInFrame);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("changing frame");
		return new SignInPage(driver);
	}

}
