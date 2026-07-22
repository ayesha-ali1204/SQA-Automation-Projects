package Website.ECommerce.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Website.ECommerce.PageObjects.LoginApplication;
import Website.ECommerce.TestComponents.BaseTest;

public class LoginTests extends BaseTest{

	@Test
	public void TC001_loginWithInCorrectEmail() {
		loginApp.Login("ayeshaali@gmail.com", "Qwerty@12");
		String status001 = loginApp.LoginFailErrorMessage();
		Assert.assertEquals(status001, "Incorrect email or password.");	
	}
	
	@Test
	public void TC002_loginWithInCorrectPassword() {
		loginApp.Login("ayeshaalishaikh1010@gmail.com", "abc");
		String status002 = loginApp.LoginFailErrorMessage();
		Assert.assertEquals(status002, "Incorrect email or password.");
	}
	
	@Test
	public void TC003_invalidCredentialsTest() {
		loginApp.Login("xyz@gmail.com", "abc");
		String status003 = loginApp.LoginFailErrorMessage();
		Assert.assertEquals(status003, "Incorrect email or password.");
	}
	
	@Test
	public void TC004_emptyEmailTest() {
		loginApp.Login("", "abc");
		String status004 = loginApp.getEmailRequiredValidationMessage();
//		System.out.println(status004);
		Assert.assertEquals(status004, "*Email is required");
	}
	
	@Test
	public void TC005_emptyPasswordTest() {
		loginApp.Login("ayeshaalishaikh1010@gmail.com", "");
		String status005 = loginApp.getPasswordRequiredValidationMessage();
		System.out.println(status005);
		Assert.assertEquals(status005, "*Password is required");
	}
	
	@Test
	public void TC006_emptyFieldsTest() {
		loginApp.Login("", "");
		String emailfield = loginApp.getEmailRequiredValidationMessage();
		String passfield = loginApp.getPasswordRequiredValidationMessage();
		System.out.println(emailfield);
		System.out.println(passfield);
		Assert.assertEquals(emailfield, "*Email is required");
		Assert.assertEquals(passfield, "*Password is required");
	}
	
	@Test
	public void TC007_invalidEmailFormatTest() {
		loginApp.Login("ayeshaalishaikh1010", "abc");
		String invalidFormat = loginApp.getInvlaidEmailValidationMessage();
		System.out.println(invalidFormat);
		Assert.assertEquals(invalidFormat, "*Enter Valid Email");
	}
}
