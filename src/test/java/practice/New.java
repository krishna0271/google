package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class New {
public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
	WebDriver driver  =  new ChromeDriver();
	driver.get("https://www.google.com/");
	WebDriverWait wait = new WebDriverWait(driver,10);
	WebElement gmail = driver.findElement(By.xpath("(//a[@class='gb_d'])[1])"));
	wait.until(ExpectedConditions.elementToBeClickable(gmail));
	gmail.click();
	Thread.sleep(5000);
	driver.close();
}
}
