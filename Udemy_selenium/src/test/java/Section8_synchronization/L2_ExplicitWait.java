package Section8_synchronization;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L2_ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
//		Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] veggies = {"Cucumber", "Brocolli", "Beetroot"};
		AddItemsToCart(driver, veggies);
		
		driver.findElement(By.xpath("//*[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		
		WebElement promocode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		promocode.sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		String promotext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo"))).getText();
		
		System.out.println(promotext);

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
			
			List<String> alVeggies = Arrays.asList(veggies);
			
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
