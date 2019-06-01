package com.crm.qa.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	//page factory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text() = 'Sign Up']")
	WebElement signupBtn;
	
	@FindBy(xpath = "//img[contains(@src,'https://classic.crmpro.com/img/logo.png')]")
	WebElement crmlogo;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle(){
		return driver.getTitle();
	}
	
	public boolean  validateCRMimage(){
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws AWTException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);		
		//loginBtn.click();
		return new HomePage();
		
		
		
	}
}
