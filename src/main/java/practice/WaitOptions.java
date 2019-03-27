package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitOptions {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		WebElement ele = driver.findElement(By.name("q"));
		WebElement ele1 = driver.findElement(By.name("btnK"));
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOf(ele));
		explicitWait.until(ExpectedConditions.elementToBeClickable(ele1));
		//assert.assertTrue(ele.isDisplayed(), "Content is not displayed");
		ele.sendKeys("krishna reddy");
		
		Thread.sleep(2000);
		driver.close();
		
	}
}
