package Section6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L9_alerts {

	public static void main(String[] args) {
		
		String name = "Ayesha Ali";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(name);
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(alert.getText());
		alert.dismiss();
		
		
		
		

	}

}
