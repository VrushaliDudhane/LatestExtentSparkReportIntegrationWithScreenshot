/**
 * 
 */
package com.tripadvisor.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tripadvisor.webapp.base.BasePage;

/**
 * This is the Page class for Sign in frame of the application this class has
 * two parts first part contains all the By locators of the sign in frame
 * WebElements and second part contains all the action methods on page
 * 
 * @author Vrushali
 *
 */
public class SignInPage extends BasePage {

	@FindBy(xpath = "//*[@id='overlayHeader']/div")
	WebElement header;

	@FindBy(css = "button[id='googleBtn']")
	WebElement continueWithGoogle;

	@FindBy(css = "button[id='facebookBtn']")
	WebElement continueWithFacebook;

	@FindBy(css = "button[class='ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin']>span[class='textContainer']")
	WebElement continueWithEmail;

	@FindBy(xpath = "//div[@id='regSignIn']/div[2]/div")
	WebElement EmailHeader;

	@FindBy(xpath = "//*[@id=\"ssoButtons\"]/button")
	WebElement continueWithEmailButton;

	@FindBy(css = "input[id='regSignIn.email']")
	WebElement emailAddress;

	@FindBy(css = "input[id='regSignIn.password']")
	WebElement password;

	@FindBy(css = "button[class='ui_button primary coreRegPrimaryButton  regSubmitBtnEvent']")
	WebElement signInButton;

	@FindBy(xpath = "//*[@id='regErrors']/ul/li")
	WebElement errorMessageOnInvalideCredentials;

	@FindBy(css = "div[class='body_text']")
	WebElement errorMessageOnBlankEmailAddress;

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getSignInPageHeader()  {
		waitForElementToBePresent(header);
		return getPageHeader(header);
	}

	public String textOnContinueWithFacebook() {
		waitForElementToBePresent(continueWithFacebook);
		return continueWithFacebook.getText();
	}

	public String textOnContinueWithGoogle() {
		waitForElementToBePresent(continueWithGoogle);
		return continueWithGoogle.getText();
	}

	public String textOnContinueWithEmail() {
		waitForElementToBePresent(continueWithEmail);
		return continueWithEmail.getText();
	}

	public void clickOnContinueWithEmail() {
		// waitForElementToBePresent(continueWithEmailButton);
		waitForElementToBeClickable(continueWithEmailButton);
		continueWithEmailButton.click();

	}

	public String getEmailHeader() {
		return getPageHeader(EmailHeader);
	}

	public UserHomePage signInWithCredentials(String email, String pass) {
		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		signInButton.click();
		return new UserHomePage(driver);
	}

	public String getTheErrorMessageOnInvalidCredetials() {
		waitForElementToBePresent(errorMessageOnInvalideCredentials);
		return errorMessageOnInvalideCredentials.getText();
	}

	public void signInWithCredentials(String crdentials, char ch) {
		if (ch == 'P') {

			password.sendKeys(crdentials);

		} else if (ch == 'E') {
			emailAddress.sendKeys(crdentials);

		}
		signInButton.click();

	}

	public String getTheErrorMessageOnBlankEmailAddress() {
		waitForElementToBePresent(errorMessageOnBlankEmailAddress);
		return errorMessageOnBlankEmailAddress.getText();
	}

	public String getTheErrorMessageOnBlankPassword() {
		waitForElementToBePresent(errorMessageOnBlankEmailAddress);
		return errorMessageOnBlankEmailAddress.getText();
	}
}
