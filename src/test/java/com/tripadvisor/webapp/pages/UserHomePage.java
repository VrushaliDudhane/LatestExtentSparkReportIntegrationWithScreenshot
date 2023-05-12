/**
 * 
 */
package com.tripadvisor.webapp.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tripadvisor.webapp.base.BasePage;

/**
 * This is the Page class for User Home Page of the application this class has
 * two parts first part contains all the By locators of the User Home Page
 * WebElements and second part contains all the action methods on page
 * 
 * @author Vrushali
 *
 */
public class UserHomePage extends BasePage {

	@FindBy(css="div[class='RvMjF ccudK Rb I o']>div>picture>img")
	WebElement userProfilePic;
	
	@FindBy(css="a[id='menu-item-0']>div>span")
	WebElement viewProfileTab;
	
	@FindBy(css="div[class='IvGkt hnsQj pTcNu BhqVp GRfiG jdaPs']:nth-of-type(3)>a>span>span")
	WebElement thingsToDoTab;
	
	@FindBy(css="div[class='slvrn Z0 Wh EcFTp']>form>input[type='search']")
	WebElement searchBarOnHome;
	
	@FindBy(css="div[class='slvrn Z0 Wh rsqqi EcFTp']>form>input:nth-of-type(1)")
	WebElement searchBar;
	
	@FindBy(css="div[class='slvrn Z0 Wh rsqqi EcFTp GADiy']>form>input:nth-of-type(1)")
	WebElement searchBarOnOptions;
	
	@FindBy(css="div[id='typeahead_results']")
	WebElement searchResultWindow;
	
	@FindBy(css="div[id='typeahead_results']>a>div:nth-of-type(2)>div:nth-of-type(1)")
	List<WebElement> searchResults;
	
	By searchResult1=By.cssSelector("div[id='typeahead_results']>a>div:nth-of-type(2)>div:nth-of-type(1)");
	By searchResult2=By.cssSelector("div[id='typeahead_results']>a>div:nth-of-type(2)>div:nth-of-type(2)");
	
	
	public UserHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getTheUserHomePageTitle() {
		waitForPageTitle(
				"Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more");
		return getPageTitle();
	}
	
	
	
	
	

}
