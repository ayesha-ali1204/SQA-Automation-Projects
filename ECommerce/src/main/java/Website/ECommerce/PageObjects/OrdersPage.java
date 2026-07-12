package Website.ECommerce.PageObjects;

import java.util.List;

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
	
	
	public boolean VerifyOrderNames() {
		boolean verifyOrderName = getOrdersList().stream().anyMatch(o -> o.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		return verifyOrderName;
	}
}
