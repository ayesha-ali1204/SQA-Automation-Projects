package Section13_Java_Streams;
//
//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S1_column_sorting {

	@Test
	public void sortingColumn() {

		// Click on the column header
		// Capture all web elements into a list
		// Capture the text of all web elements into a new (original) list
		// Sort the original list to create a sorted list
		// Compare the original list with the sorted list
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//// Click on the column header
		driver.findElement(By.cssSelector("[aria-label*='Veg']")).click();
		
		//// Capture all web elements into a list
		List<WebElement> veggies= driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		//// Capture the text of all web elements into a new (original) list
//		List<String> original = new ArrayList<String>();
//		for (WebElement veg : veggies) {
//			String v = veg.getText();
//			original.add(v);
//		}
		List<String> originalList = veggies.stream().map(v -> v.getText()).collect(Collectors.toList());
		

		//// Sort the original list to create a sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		

		//// Compare the original list with the sorted list
		Assert.assertTrue(originalList.equals(sortedList)); 
		
		
		
//		Problem 2
		// scan the name column with getText -> Beans -> print the price of the Rice
		List<String> price = veggies.stream()
		        .filter(s -> s.getText().contains("Beans"))
		        .map(s -> getPriceVeggie(s))
		        .collect(Collectors.toList());

		price.forEach(a -> System.out.println(a));
		
	}

	private String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	    return pricevalue;
	}

}
