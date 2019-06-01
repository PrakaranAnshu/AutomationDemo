package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.testbase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void SetUp(){
		inilization();
		 loginpage= new LoginPage();
		 		
	}
	
	@Test(priority=1)
	public void loginpageTitleTest(){
		String title= loginpage.validateTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");		
	}
	
	@Test(priority=2)
	public void crmlogoTesr(){
		boolean flag = loginpage.validateCRMimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws AWTException{
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void TearDown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
	}
	

}
