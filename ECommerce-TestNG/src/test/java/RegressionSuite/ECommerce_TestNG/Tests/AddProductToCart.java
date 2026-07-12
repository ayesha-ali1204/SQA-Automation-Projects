package RegressionSuite.ECommerce_TestNG.Tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import RegressionSuite.ECommerce_TestNG.TestComponents.BaseTest;


public class AddProductToCart extends BaseTest{
	

	List<String> productsToBuy = Arrays.asList("adidas original");
	@FindBy (css=".card")
	WebElement ProductsCards;
	
	@Test (dependsOnMethods="RegressionSuite.ECommerce_TestNG.Tests.LoginTests.LoginWithValidCredentials", alwaysRun = true)
	public void AddProducts() {
		prodcutCatelogue.addProductToCart(productsToBuy);
	}
}
