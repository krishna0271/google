package practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExe_Examples {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));
		
		js.executeScript("arguments[0].click();", element);
		//js.executeScript("document.getElementById('').click();");
		String title = (String) js.executeScript("return document.title");
		System.out.println(title);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,1500)");
		
		Thread.sleep(5000);
		driver.close();

	}

}
