package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath ="//input[@value='New Contact']")
	WebElement newContactbtn;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel(){
		
		return contactsLabel.isDisplayed();
	}
	
	public void clickonNewContacts(){
		newContactbtn.click();
	}
	
	

}
