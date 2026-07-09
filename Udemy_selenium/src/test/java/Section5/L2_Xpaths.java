package Section5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L2_Xpaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
//		XPATH with single attribute
		driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys("apple");
		

//		XPATH with multiple attribute
		driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("apple");
		
//		XPATH with AND OR Operators
		driver.findElement(By.xpath("//input[@name='search' and placeholder='Search']")).sendKeys("apple");
		driver.findElement(By.xpath("//*[@name='search' or placeholder='xyz']")).sendKeys("apple");

//		Xpath with Inner Text
		driver.findElement(By.xpath("//a[text()='Macbooks']")).click();
		
		boolean displaystatus = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.print(displaystatus);
		
		String value = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.print(value);
		
//		Path using Contains method
		//input[contains(@attribute='value')]
		driver.findElement(By.xpath("input[contains(@placeholder, 'Sea')]")).click();
	
//		Xpath using Starts-with method
		//input[starts-with(@attribute='value')]
		driver.findElement(By.xpath("input[starts-with(@placeholder, 'Sea')]")).click();
		
//		Chained XPATH
		//div[@id='logo']/a/img

	}

}
