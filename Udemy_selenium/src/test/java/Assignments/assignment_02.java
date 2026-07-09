//Check-boxes
package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_02 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1200)");
		
//		enter name
		driver.findElement(By.xpath("//*[@name='name'][@minlength='2']")).sendKeys("Ayesha Ali");
//		enter email
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ayeshaali4876@gmail.com");
//		enter password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Password123");
//		check-box 
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		
//		find dropdown element
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='exampleFormControlSelect1']"));
		
//		Select checkbox
		Select select = new Select(dropdown);
		select.selectByVisibleText("Female");
		
//		select checkbox
		driver.findElement(By.xpath("//*[@id='inlineRadio2']")).click();
		
//		select date
		driver.findElement(By.xpath("//*[@name='bday']")).sendKeys("04122001");
		
//		Click 'Submit' button
		driver.findElement(By.cssSelector("[value='Submit']")).click();
		
//		Success Message
		String message = driver.findElement(By.xpath("//*[contains(@class, 'alert-success')]")).getText();
		String trimmedMsg = message.split("×")[1].trim();
		System.out.println(trimmedMsg);
		
		

	}

}
