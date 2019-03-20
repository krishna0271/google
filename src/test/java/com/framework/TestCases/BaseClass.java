package com.framework.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	WebDriver driver;

  @BeforeMethod
  public void setup(){
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

  @AfterMethod
  public void teardown() {
		driver.close();
	}

}
