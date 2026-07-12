package Website.ECommerce.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Website.ECommerce.TestComponents.BaseTest;

public class checkValidations extends BaseTest{
	
	@Test
	public void LoginWithWrongPasswordk() {
		loginApp.Login("rbtestayesha@gmail.com", "12345");
		String T001_status = loginApp.LoginFailErrorMessage();
		Assert.assertEquals(T001_status, "Incorrect email or password.");
		
	}
}
