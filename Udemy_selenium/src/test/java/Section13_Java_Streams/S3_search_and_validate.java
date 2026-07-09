package Section13_Java_Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class S3_search_and_validate {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
//		Search for the element
		String search = "apple";
		driver.findElement(By.cssSelector("#search-field")).sendKeys(search);
		
//		get the filtered Original List 
		List<WebElement> orginalRes = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		
//		Check if the Original list, actually filters the result
		List<WebElement> filteredList=  orginalRes.stream()
			.filter(s -> s.getText().toLowerCase().contains(search.toLowerCase()))
			.collect(Collectors.toList());
		
		Assert.assertEquals(orginalRes.size(), filteredList.size());
	}

}
