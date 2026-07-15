package Website.ECommerce.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Website.ECommerce.PageObjects.CheckoutPage;
import Website.ECommerce.PageObjects.OrdersPage;

public class abstractComponent {
	

	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy (css="[routerlink*='cart']")
	WebElement gotoCart;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement gotoOrders;
	
	public abstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToBeVisible(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void ElementToBeClickable(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public CheckoutPage goToCartPage() {
		gotoCart.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	
	public OrdersPage goToOrdersPage() {
		gotoOrders.click();
		OrdersPage orders = new OrdersPage(driver);
		return orders;
	}

}
