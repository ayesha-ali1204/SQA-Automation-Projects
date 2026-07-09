package Website.ECommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import Website.ECommerce.AbstractComponents.abstractComponent;

public class CheckoutPage extends abstractComponent {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".cartWrap h3")
	List<WebElement> cartItems;
	
	@FindBy (css=".totalRow button")
	WebElement checkoutBtn;
	
	By checkout = By.cssSelector(".totalRow button");
	
	public boolean VerifyCartProducts(List<String> elementsToBuy) {
		boolean status = cartItems.stream()
				.map(c -> c.getText().toLowerCase())
				.allMatch(elementsToBuy::contains);
		return status;
	}

	public ConfirmationPage ClickCheckout() {
		waitForElementToAppear(checkout);
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].scrollIntoView({block:'center', behavior:'instant'});", checkoutBtn);
//			wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)); // re-check after scroll
			ElementToBeClickable(checkout);
			checkoutBtn.click();
			ConfirmationPage confirmPage = new ConfirmationPage(driver);
			return confirmPage;
		
	}
}
