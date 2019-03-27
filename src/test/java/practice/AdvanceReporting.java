package practice;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.Pages.GoogleHomePage;

public class AdvanceReporting {

	// Extent reports are the advanced Selenium Reporting Tool
	public WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	GoogleHomePage homepage;

	@BeforeTest
	public void startreport() {

		// Create an object of Extent Reports
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "krishna Reddy Gajjala");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
		// Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here ");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.DARK);

	}

// This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/ScreenShots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\krish\\OneDrive\\Apps\\Desktop\\Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test(priority=4,groups = { "regressionTest", "functionalTest" })
	public void verifyTitle() {
		logger = extent.createTest("To verify Google Title");
		Assert.assertEquals(driver.getTitle(), "Google");
		logger.log(Status.PASS, "Title is verfied");
	}
	@Test(priority=1,groups = { "smokeTest", "sanityTest" })
	public void test_Home_Page(){
		
		homepage=new GoogleHomePage(driver);
		String loginPageTitle = homepage.getLoginTitle();
		System.out.println(loginPageTitle);
		homepage.Search_Something("selenium");
		System.out.println(driver.getTitle());
//		homepage.feelingLucky();
		
	}

	@Test(priority=2,groups = { "smokeTest", "regressionTest" })
	public void test_Home_Page1() throws AWTException, InterruptedException{
		
		homepage=new GoogleHomePage(driver);
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//a[@class='gb_d'])[1]")));
		act.click().build().perform();
		
//		Robot rb = new Robot();
//		rb.keyPress(KeyEvent.VK_CONTROL);
//		rb.keyPress(KeyEvent.VK_A);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}

	@Test(priority=3,groups = { "smokeTest", "regressionTest" })
	public void test_gmail_link() {
		
		homepage=new GoogleHomePage(driver);
		homepage.ClickOnGmail();
		System.out.println(driver.getTitle());
		
	}
	 @Test(enabled= false, priority=5,groups = { "smokeTest", "functionalTest" })
	 public void verifyLogo() {
		 logger = extent.createTest("To verify Google Logo");
		 boolean img = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		 logger.createNode("Image is Present");
		 Assert.assertTrue(img);
		 logger.createNode("Image is not Present");
		 Assert.assertFalse(img);
	 }

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(driver, result.getName());
			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

}
