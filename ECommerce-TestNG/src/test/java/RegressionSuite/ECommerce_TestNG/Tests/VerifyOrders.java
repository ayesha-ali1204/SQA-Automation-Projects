package RegressionSuite.ECommerce_TestNG.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import RegressionSuite.ECommerce_TestNG.TestComponents.BaseTest;


public class VerifyOrders extends BaseTest{

	
	@Test (dependsOnMethods="RegressionSuite.ECommerce_TestNG.Tests.AddProductToCart.AddProducts", alwaysRun = true)
	public void GoToOrders() {
		orders = prodcutCatelogue.goToOrdersPage();
	}
	
	@Test (dependsOnMethods="GoToOrders", alwaysRun = true)
	public void VerifyOrder() {
//		VerifyOrderNames
		boolean status = orders.VerifyOrderNames();
		Assert.assertTrue(status);
	}
}
