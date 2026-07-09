package Section7_cartEcommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L1_addCart {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
//		iterate through all element and print them
		for (int i=0; i<products.size(); i++) {
			
//			here get() works as a get-index
			System.out.println(products.get(i).getText());
			
			
		}
		

	}

}
