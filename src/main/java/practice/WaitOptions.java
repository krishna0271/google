package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitOptions {
	public static WebDriver driver;
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.manage().timeouts().
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_script_create");
}
}
