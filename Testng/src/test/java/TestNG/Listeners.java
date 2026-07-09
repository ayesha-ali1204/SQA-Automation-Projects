package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("Test Passed");	
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed 'Method Name': "+result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
	    // TODO Auto-generated method stub
	}
}
