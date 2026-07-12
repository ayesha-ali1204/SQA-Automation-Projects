package Website.ECommerce.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Website.ECommerce.AbstractComponents.abstractComponent;

public class ProductCatalogue extends abstractComponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css=".col-lg-4")
	List<WebElement> products;
	
	
	By productNames= By.tagName("b");
	By productsBy= By.cssSelector(".col-lg-4");
	By toast = By.cssSelector("#toast-container");
	By loader = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
//		System.out.println("Items fetched");
		return products;
	}
	
	public List<WebElement> getProductNames(List<String> elementsToBuy) {
		List<WebElement> productsList = getProductList().stream()
				.filter(p -> elementsToBuy.contains(p.findElement(productNames).getText().toLowerCase().trim()))
				.collect(Collectors.toList());
//		System.out.println(productsList);
		return productsList;
	}
	
	
	public void addProductToCart(List<String> elementsToBuy) {
	
		getProductNames(elementsToBuy).forEach(prod -> {
		prod.findElement(By.cssSelector("[class*='w-10']")).click();
		System.out.println(prod.findElement(By.tagName("b")).getText());
		waitForElementToAppear(toast);
		waitForElementToDisappear(toast);
		waitForElementToDisappear(loader);
	//	goToCartPage();
		});
	}
}
