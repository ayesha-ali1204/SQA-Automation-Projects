package Website.ECommerce.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Website.ECommerce.Resources.ExtendReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.GetReportObject();
//	helps to avoid the concurrency of test that are run.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	// Invoked before each test method is run
    @Override
    public void onTestStart(ITestResult result) {
       test = extent.createTest(result.getMethod().getMethodName());
       extentTest.set(test); //assign unique id to every test i.e. run. 
    }

    // Invoked each time a test succeeds
    @Override
    public void onTestSuccess(ITestResult result) {
    	extentTest.get().log(Status.PASS, "Test Passed!");
    }

    // Invoked each time a test fails
    @Override
    public void onTestFailure(ITestResult result) {
//      test.fail(result.getThrowable());
////    	replacing test with the extentTest.get()
    	extentTest.get().fail(result.getThrowable());
        try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
//        Screenshot
        String filePath = null;
        try {
//        	taking screenshot
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
//        attaching screenshot to the report
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    // Invoked each time a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }

    // Invoked each time a test fails but is within the success percentage
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("FAILED BUT WITHIN SUCCESS PERCENTAGE: " + result.getName());
    }

    // Invoked when a test fails due to timeout
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("TIMEOUT: " + result.getName());
    }
    
 // Invoked after the test class is instantiated and before any test method is invoked
    @Override
    public void onStart(ITestContext context) {
//        System.out.println("Test Suite Started: " + context.getName());

    }

    // Invoked after all the test methods have run
    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
        System.out.println("Test Suite Finished: " + context.getName());
    }

}
