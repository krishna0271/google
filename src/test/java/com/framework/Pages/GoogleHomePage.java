package com.framework.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.TestCases.BaseClass;

public class GoogleHomePage extends BaseClass {

	WebDriver driver;
	@FindBy(name = "q")
	WebElement Search;

	@FindBy(name = "btnK")
	WebElement Google_Search;

	@FindBy(name = "btnI")
	WebElement Im_Feeling_Lucky;
 
	@FindBy(id = "hplogo")
	WebElement Logo;
	
	@FindBy(xpath = "(//a[@class='gb_d'])[1]")
	WebElement gmail;

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void type(String type) {
		Search.sendKeys(type);
	}

	public void search() {
		Google_Search.click();
	}
	
	public void feelingLucky() {
		Im_Feeling_Lucky.click();
	}
	public String getLoginTitle(){
		 return	Logo.getText();
		}

	public void Search_Something(String type) {
		this.type(type);
//		this.getLoginTitle();
//		this.search();
		this.feelingLucky();
		
	}
	public void ClickOnGmail() {
		Actions act =  new Actions(driver);
		act.moveToElement(gmail).click().build().perform();
	}
	
	
}

