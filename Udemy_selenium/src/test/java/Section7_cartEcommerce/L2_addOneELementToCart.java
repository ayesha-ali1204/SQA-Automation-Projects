package Section7_cartEcommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L2_addOneELementToCart {

	public static void main(String[] args) {
		
		String veggie = "Cucumber";
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//*[text()='ADD TO CART']"));
		
		int Sum=0;
		for (int i=0; i<products.size(); i++) {
			
			String name = products.get(i).getText();
			Sum++;
			System.out.println(Sum);
			
			if (name.contains(veggie)) {
				addToCartButtons.get(i).click();
				break;
			}
		}		

	}

}
