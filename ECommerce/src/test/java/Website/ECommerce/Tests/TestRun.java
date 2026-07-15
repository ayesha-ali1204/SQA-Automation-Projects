package Website.ECommerce.Tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Website.ECommerce.PageObjects.CheckoutPage;
import Website.ECommerce.PageObjects.ConfirmationPage;
import Website.ECommerce.PageObjects.ProductCatalogue;
import Website.ECommerce.TestComponents.BaseTest;

public class TestRun extends BaseTest{
//	@Test (groups= {"SubmitOrderTest"}, dataProvider="getDataSubmitOrder")
	public void SubmitOrder(String email, String password, List<String> productsToBuy) throws IOException {

//		List<String> productsToBuy = Arrays.asList("adidas original", "iphone 13 pro");
//		String email = "rbtestayesha@gmail.com";
//		String password = "Abcd@1234";
		String country = "Pakistan";
		
//		Return Type of LaunchApplication method is "LoginApplication" class
//		LaunchApplication method is @BeforeMethod/ it will run everytime before running any test
//		
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
	
//	Sending Data using simple Object Creation
	@DataProvider
	public Object[][] getDataSubmitOrder() {
		return new Object[] []
				{
			{"rbtestayesha@gmail.com", "Abcd@1234", List.of("adidas original", "iphone 13 pro")},
			{"ayeshaalishaikh1010@gmail.com", "Qwerty@12", List.of("zara coat 3")}
				};
	}
	
	
//	@Test (groups= {"SubmitOrderTest"}, dataProvider="getDataHashmap")
	public void Purchase(HashMap<String, Object> input) throws IOException {

		String email = (String) input.get("email");
	    String password = (String) input.get("password");
	    List<String> products = (List<String>) input.get("products");
		
		ProductCatalogue catalogue = loginApp.Login(email, password);
		catalogue.addProductToCart(products);
		CheckoutPage checkout = catalogue.goToCartPage(); 
		boolean status = checkout.VerifyCartProducts(products); //Verify products in cart
		Assert.assertTrue(status);
		ConfirmationPage confirmPage = checkout.ClickCheckout(); //click checkout button = move to confirmation page
		confirmPage.ChooseCountry("Pakistan");
		confirmPage.ClickPlacrOrder();

	}
	
//	Sending Data using Hashmap 
	@DataProvider
	public Object[][] getDataHashmap() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", "rbtestayesha@gmail.com");
		map.put("password", "Abcd@1234");
		map.put("products", List.of("adidas original", "iphone 13 pro"));
		
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("email", "ayeshaalishaikh1010@gmail.com");
		map1.put("password", "Qwerty@12");
		map1.put("products", List.of("zara coat 3"));
		
		return new Object[] []
				{{map}, {map1}};
	}
	
//	Using Json file
	@Test (groups= {"PurchaseOrderTest"}, dataProvider="getDataJson")
	public void PurchaseOrder(HashMap<String, Object> input) throws IOException {
//		List<String> productsToBuy = Arrays.asList("adidas original", "iphone 13 pro");
//		String email = "rbtestayesha@gmail.com";
//		String password = "Abcd@1234";
//		String country = "Pakistan";
		
		String email = (String) input.get("email");
	    String password = (String) input.get("password");
	    List<String> products = (List<String>) input.get("products");
		
		ProductCatalogue catalogue = loginApp.Login(email, password);
		catalogue.addProductToCart(products);
		CheckoutPage checkout = catalogue.goToCartPage(); 
		boolean status = checkout.VerifyCartProducts(products);
		Assert.assertTrue(status);
		ConfirmationPage confirmPage = checkout.ClickCheckout();
		confirmPage.ChooseCountry("Pakistan");
		confirmPage.ClickPlacrOrder();
	}
	
	@DataProvider
	public Object[][] getDataJson() throws IOException {
		List<HashMap<String, Object>> data= GetJsonToMap(System.getProperty("user.dir")+"//src//test//java//Website//ECommerce//data//PurchaseOrder.json");
		return new Object[] [] {{data.get(0)}, {data.get(1)}};
	}
	

}
