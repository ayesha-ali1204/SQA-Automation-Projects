package Website.ECommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Website.ECommerce.AbstractComponents.abstractComponent;

public class ConfirmationPage extends abstractComponent{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By countryDropdown = By.cssSelector("[placeholder='Select Country']");
	By countryFilter = By.cssSelector(".ta-results");
	
	@FindBy (xpath="//button[contains(@class,'ta-item')]")
	List<WebElement> options;
	
	@FindBy (css=".action__submit")
	WebElement placeOrderBtn;
	
	public void ChooseCountry(String country) {
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(countryDropdown), "Pa").build().perform();
		waitForElementToAppear(countryFilter);

		// Store all matching elements in a list
		for (WebElement option : options) {
		    if (option.getText().trim().equalsIgnoreCase(country)) {
		        ((JavascriptExecutor) driver).executeScript(
		                "arguments[0].scrollIntoView({block:'center', behavior:'instant'});", option);

		        option.click();
		        break;
		    }
		}

	}
	
	public void ClickPlacrOrder() {
		placeOrderBtn.click();
	}
}
