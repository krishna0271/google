package com.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {
		

		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\framework\\src\\main\\java\\resources\\data.properties");
		prop.load(fs);
		String browsername = prop.getProperty("broswer");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			//firefox driver
			driver = new FirefoxDriver();	
		} else if (browsername.equals("ie")) {
			//IE driver
			driver = new EdgeDriver();
		}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
	}

}
