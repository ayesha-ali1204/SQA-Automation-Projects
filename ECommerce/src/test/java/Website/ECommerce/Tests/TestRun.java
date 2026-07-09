package Website.ECommerce.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Website.ECommerce.PageObjects.CheckoutPage;
import Website.ECommerce.PageObjects.ConfirmationPage;
import Website.ECommerce.PageObjects.LoginApplication;
import Website.ECommerce.PageObjects.ProductCatalogue;
import Website.ECommerce.TestComponents.BaseTest;

//import POM_Framework.LoginApplication;

public class TestRun extends BaseTest{

	@Test
	public void SubmitOrder() throws IOException {

		List<String> productsToBuy = Arrays.asList("adidas original", "iphone 13 pro");
		String email = "rbtestayesha@gmail.com";
		String password = "Abcd@1234";
		String country = "Pakistan";
		
//		Return Type of LaunchApplication method is "LoginApplication" class
//		LaunchApplication method is @BeforeMethod/ it will run everytime before running any test


//		return type of Login method is Checkout class - Object
		ProductCatalogue catalogue = loginApp.Login(email, password);

//		ADD PRODUCTS TO CART
		catalogue.addProductToCart(productsToBuy); //add product from the dashboard
//		return type of goToCartPage method is Checkout class - Object
		CheckoutPage checkout = catalogue.goToCartPage(); //go to cart page from header

//		PROCEED TO CHECKOUT
		boolean status = checkout.VerifyCartProducts(productsToBuy); //Verify products in cart
		Assert.assertTrue(status);

		ConfirmationPage confirmPage = checkout.ClickCheckout(); //click checkout button = move to confirmation page
		
//		choose country
		confirmPage.ChooseCountry(country);
		confirmPage.ClickPlacrOrder();

	}

}
