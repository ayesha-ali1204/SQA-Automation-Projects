package Singleton.ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendReportDemo {

	ExtentReports extent;
	
	@BeforeTest
	public void config() {
//		ExtendReports, ExtendSparkReporter
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ayesha Ali");
	}
	
	@Test
	public void getTitle() {
		extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "xyz");
		extent.flush();
	}
}
