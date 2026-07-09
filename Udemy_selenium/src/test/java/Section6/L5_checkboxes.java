package Section6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class L5_checkboxes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//		Get Student Check-box Web Element
		WebElement std = driver.findElement(By.cssSelector("input[id*=StudentDiscount]"));
		System.out.println(std.isSelected());
//		Assert check false
		Assert.assertFalse(std.isSelected());
		
//		Click check Box
		std.click();
		System.out.println(std.isSelected());
//		Assert check true
		Assert.assertTrue(std.isSelected());
		
//		getSize
		System.out.println(driver.findElements(By.xpath("//input[contains(@name, 'ctl00$mainContent$chk')]")).size());
		
//		printing the CheckBox Label
		List<WebElement> ckbCount = driver.findElements(By.xpath("//input[contains(@name, 'ctl00$mainContent$chk')]/following-sibling::label"));
		for (WebElement count: ckbCount) {
			System.out.println(count.getText());
		}
		
		
	}

}
