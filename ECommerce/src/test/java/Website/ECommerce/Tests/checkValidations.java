package Website.ECommerce.Tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Website.ECommerce.PageObjects.CheckoutPage;
import Website.ECommerce.PageObjects.ConfirmationPage;
import Website.ECommerce.PageObjects.OrdersPage;
import Website.ECommerce.PageObjects.ProductCatalogue;
import Website.ECommerce.TestComponents.BaseTest;

public class checkValidations extends BaseTest{
	
	ProductCatalogue prodCatalogue;
	List<String> productsToBuy = Arrays.asList("adidas original", "iphone 13 pro");
	String email = "rbtestayesha@gmail.com";
	String password = "Abcd@1234";
	String country = "Pakistan";
	
	
	@Test (groups= {"ErrorHandling"}, dataProvider="getDataLoginValidate")
	public void LoginWithWrongPassword(String email, String password) {
		loginApp.Login(email, password);
		String T001_status = loginApp.LoginFailErrorMessage();
		Assert.assertEquals(T001_status, "Incorrect email password.");
		
	}
//	@Test
	public void LoginWithValidCredentials() {
		loginApp.Login("rbtestayesha@gmail.com", "Abcd@1234");
	}
	
	@Test
	public void SubmitOrder() throws IOException {

		ProductCatalogue catalogue = loginApp.Login(email, password);
		catalogue.addProductToCart(productsToBuy); 
		CheckoutPage checkout = catalogue.goToCartPage();
		boolean status = checkout.VerifyCartProducts(productsToBuy);
		Assert.assertTrue(status);
		ConfirmationPage confirmPage = checkout.ClickCheckout(); 
		confirmPage.ChooseCountry(country);
		confirmPage.ClickPlacrOrder();
	}
	
	@Test (dependsOnMethods="SubmitOrder")
	public void VerifyOrder() {
		ProductCatalogue catalogue = loginApp.Login("rbtestayesha@gmail.com", "Abcd@1234");
		OrdersPage orders = catalogue.goToOrdersPage();
		boolean status = orders.VerifyOrdersProducts(productsToBuy);
		Assert.assertTrue(status);
	}
	
	@DataProvider
	public Object[][] getDataLoginValidate() {
		return new Object[] []
				{
			{"rbtestayesha@gmail.com", "Abcd@12"},
//			{"rbtestayesha@gmail.com", "Abcd3"},	
//			{"rbtest@gmail.com", "Abcd"}
				};	
	}
//	
}
