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

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws AWTException{
		inilization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage= new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
						
	}
	
	@Test(priority= 1)
	public void verifyhomepagetitleTest(){
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homepageTitle= homepage.verifyhomepageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "HomePage Titele not matched");
				
	}
	@Test(priority= 2)
	public void verifyusernametest() throws AWTException{
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		boolean flag= homepage.verifyusername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void verifycontactlinks(){
		testutil.switchtoframe();
		contactspage= homepage.clickonContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
		
	}

}
