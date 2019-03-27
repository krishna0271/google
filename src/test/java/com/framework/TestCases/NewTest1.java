package com.framework.TestCases;

import java.awt.AWTException;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.framework.Pages.GoogleHomePage;

public class NewTest1 extends BaseClass{

GoogleHomePage homepage;

@Test(priority=1,groups = { "regressionTest", "functionalTest" })
public void test_Home_Page(){
	
	homepage=new GoogleHomePage(driver);
	String loginPageTitle = homepage.getLoginTitle();
	System.out.println(loginPageTitle);
	homepage.Search_Something("selenium");
	System.out.println(driver.getTitle());
//	homepage.feelingLucky();
	
}

@Test(priority=2,groups = { "regressionTest", "functionalTest" })
public void test_Home_Page1() throws AWTException, InterruptedException{
	
	homepage=new GoogleHomePage(driver);
	Actions act =  new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("(//a[@class='gb_d'])[1]")));
	act.click().build().perform();
	
//	Robot rb = new Robot();
//	rb.keyPress(KeyEvent.VK_CONTROL);
//	rb.keyPress(KeyEvent.VK_A);
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
}

@Test(priority=3,groups = { "regressionTest", "smokeTest" })
public void test_gmail_link() {
	
	homepage=new GoogleHomePage(driver);
	homepage.ClickOnGmail();
	System.out.println(driver.getTitle());
	
}

}
