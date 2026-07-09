package Section5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L3_happy_flow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.xpath("//*[@id='inputUsername']")).sendKeys("Ayesha");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
//		NoSuchElementException:
		WebElement errorMsg = driver.findElement(By.cssSelector("p.error"));
		System.out.println(errorMsg.getText());
		
//		Click on Forget Password
		driver.findElement(By.xpath("//a[contains(text(),'password')]")).click();
		
//		Waiting for animation to happen and for elements to visible
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[class*='reset-pwd']")).click();
		
		WebElement getPwdText = driver.findElement(By.cssSelector("[class*='infoMsg']"));
		System.out.println(getPwdText.getText());
		
		driver.findElement(By.className("go-to-login-btn")).click();
		
		Thread.sleep(3000);
		
//		Enter CorrectCredentials
		driver.findElement(By.xpath("//*[@id='inputUsername']")).sendKeys("Ayesha");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		String SucLoginText= driver.findElement(By.xpath("//p[contains(text(), 'successfully logged in')]")).getText();
		System.out.println(SucLoginText);
		
		if (SucLoginText.equalsIgnoreCase("You are successfully logged in.") ) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
}
