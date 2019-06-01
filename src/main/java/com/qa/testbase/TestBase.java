package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()  {
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("\\Users\\PRAKARAN\\workspace"
					+ "\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);						
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
			
	}
	
	public static  void inilization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C://Users//PRAKARAN//Downloads//chromedriver_win32//chromedriver.exe");
			driver= new ChromeDriver();		
		}else if (browserName.equals("firefox")){
			//System.setProperty("webdriver.chrome.driver", "C://Users//PRAKARAN//Downloads//chromedriver_win32//chromedriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implict_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		 
	}
	
	
}
