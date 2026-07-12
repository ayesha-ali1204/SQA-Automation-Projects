package RegressionSuite.ECommerce_TestNG.Tests;

import org.testng.annotations.Test;

import RegressionSuite.ECommerce_TestNG.TestComponents.BaseTest;

public class LoginTests extends BaseTest{
	
	@Test
	public void LoginWithValidCredentials() {
		prodcutCatelogue = loginApp.Login("rbtestayesha@gmail.com", "Abcd@1234");	
	}
	
}
