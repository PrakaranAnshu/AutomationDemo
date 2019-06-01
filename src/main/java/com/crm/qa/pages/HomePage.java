package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestUtil;
import com.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	TestUtil testutil;
	
	@FindBy(xpath = "//td[@class= 'headertext' and @align= 'left']")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLinks;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLinks;
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String  verifyhomepageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickonContactsLink(){
		testutil.switchtoframe();
		contactsLinks.click();
		return new ContactsPage();
	}
	
	public boolean verifyusername(){
		 
		return usernameLabel.isDisplayed();
	}
	

}
