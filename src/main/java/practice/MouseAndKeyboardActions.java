package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardActions {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		System.out.println(driver.getTitle());
		WebElement shopby = driver.findElement(By.xpath("//span[contains(text(),'Category')]"));
		WebElement mensFashion = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]/div[4]/div[2]/span[8]/span[1]"));
	    WebElement jeans = driver.findElement(By.xpath("//span[contains(text(),'Jeans')]"));
		
		Actions act = new Actions(driver);
		
		Action clickonjeans = act.moveToElement(shopby).moveToElement(mensFashion).moveToElement(jeans).click().build();
		
		clickonjeans.perform();
		
		
		
		
		Thread.sleep(5000);
		driver.close();
	}
}
