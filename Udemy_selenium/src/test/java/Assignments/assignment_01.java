package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
