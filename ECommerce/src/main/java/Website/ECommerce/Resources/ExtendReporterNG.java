package Website.ECommerce.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	
	public static ExtentReports GetReportObject() {
//		ExtendReports, ExtendSparkReporter
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ayesha Ali");
		return extent;
	}
}
