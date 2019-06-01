package com.crm.qa.util;

import com.qa.testbase.TestBase;

public class TestUtil extends TestBase{
	
	public static long page_load_timeout = 20;
	public static long implict_wait= 10;
	
	public void switchtoframe(){
		driver.switchTo().frame("mainpanel");
		
	}

}
