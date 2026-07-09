package Section13_Java_Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S2_getPrice_pagination {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
//		column sorting
		driver.findElement(By.cssSelector("[aria-label*='Veg']")).click();
		
		List<String> vegPrice;
		
		do {
//			get element on rows
			List<WebElement> rows =  driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			
//			search for veggie
			vegPrice = rows.stream()
				.filter(s -> s.getText().contains("Pineapple"))
				.map(s -> getPrice(s))
				.collect(Collectors.toList());

//			if not found on the current page, then click on next button
//			vegPrice 'List' size is less than 1 (No element stored yet).

			if(vegPrice.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();			}
			
		}
//		loop will run until the vegPrice List size = 0.
		while(vegPrice.size()==0);
		
		
		vegPrice.forEach(s -> System.out.println(s));
	}
	
	private static String getPrice(WebElement s) {
//		Subset of driver is used to get the price of veggie
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
	}


}
