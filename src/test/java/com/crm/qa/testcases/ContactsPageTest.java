package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.qa.testbase.TestBase;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	TestUtil testutil;
	HomePage homepage;
	ContactsPage contactspage;
	
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws AWTException{
		inilization();
		loginpage= new LoginPage();
		testutil = new TestUtil();
		contactspage= new ContactsPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickonContactsLink();	
		
	}
	
	@Test
	public void verifyContactsPageTest(){
		boolean flag = contactspage.verifyContactLabel();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
	}

}
