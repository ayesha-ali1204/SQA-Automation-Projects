//Alerts

package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment_06 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		checkbox
		driver.findElement(By.cssSelector("#checkBoxOption2")).click();
		String text = driver.findElement(By.cssSelector("[for='benz']")).getText().trim();
		
//		dropdown
		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
		
//		Alert
		driver.findElement(By.cssSelector("#name")).sendKeys(text);
//		click alert btn
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
//		switch to alerts
		Alert alert = driver.switchTo().alert();
		boolean alertText = alert.getText().contains(text);
		
//		System.out.println(alertText);
		Assert.assertTrue(alertText);
		
		alert.accept();
		
		
//		System.out.println(text);
		
	}

}
