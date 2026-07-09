package Section7_cartEcommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L4_addVeggiesInCart {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] veggies = {"Cucumber", "Brocolli", "Beetroot"};
		AddItemsToCart(driver, veggies);
		

	}
	
	public static void AddItemsToCart(WebDriver driver, String[] veggies) {
		int j=0; 
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//*[@class='product-action']/child::button"));
		
		
		for (int i=0; i<products.size(); i++) {
			
			String name = products.get(i).getText();
			String[] prodname = name.split("-");
			String VeggieName = prodname[0].trim();
			System.out.println(VeggieName);
			
//			convert array to array list first --> 
//			initially we define array because it take less memory space than ArrayList
			List<String> alVeggies = Arrays.asList(veggies);
			
//			check whether name we define are present, in elements we extract or not
			if (alVeggies.contains(VeggieName)) {
				j++;
				addToCartButtons.get(i).click();
				
				if(j==veggies.length) {
					break;
				}
			}
		}		

	}

}
