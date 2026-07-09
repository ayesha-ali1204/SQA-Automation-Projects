package Section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S1_assignment1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		 WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
		 checkbox1.click();
		 System.out.println(checkbox1.isSelected());
		 
		 checkbox1.click();
		 System.out.println(checkbox1.isSelected());
		 
		 
		 
		 System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());
		 
		 
		
		
		
	}

}
