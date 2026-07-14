package Website.ECommerce.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Website.ECommerce.AbstractComponents.abstractComponent;

public class OrdersPage extends abstractComponent{
	WebDriver driver;
	@FindBy (xpath="//tbody/tr/td[2]")
	List<WebElement> ordersList;
	
	By ordersBy= By.xpath("//tbody/tr[1]/td[2]");
	
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getOrdersList() {
		waitForElementToAppear(ordersBy);
		return ordersList;
	}

	public List<String> GetOrderNames() {

		List<String> actualOrderedProducts = getOrdersList().stream()
		.map(WebElement::getText)
        .map(String::toLowerCase)
        .collect(Collectors.toList());
		return actualOrderedProducts;
	}
	
	
	public boolean VerifyOrdersProducts(List<String> prodOrdered) {
		boolean status = GetOrderNames().stream().allMatch(s -> prodOrdered.contains(s));
//		boolean status = cartItems.stream()
//				.map(c -> c.getText().toLowerCase())
//				.allMatch(elementsToBuy::contains);
		return status;
	}
}
