package Section5;

import java.time.Duration;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L4_parsing {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		String password = getPassword(driver);
		String name = "Ayesha";
		
		driver.findElement(By.xpath("//*[@id='inputUsername']")).sendKeys(name);
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
		Thread.sleep(2000);
		String loginSuccessfully = driver.findElement(By.tagName("p")).getText();
		System.out.println(loginSuccessfully);
		Assert.assertEquals(loginSuccessfully, "You are successfully logged in.");
		String welcome = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		System.out.println(welcome);
		Assert.assertEquals(welcome, "Hello "+name+",");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.quit();
	
		
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		
//		Click on Forget Password
		driver.findElement(By.xpath("//a[contains(text(),'password')]")).click();
		
//		Waiting for animation to happen and for elements to visible
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[class*='reset-pwd']")).click();
		
		String getPwdText = driver.findElement(By.cssSelector("[class*='infoMsg']")).getText();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] arrayPwd= getPwdText.split("'");
		String password = arrayPwd[1];
		System.out.println("Extracted Password is: "+password);
		
//		Print Array
		for (int i=0; i<arrayPwd.length;i++) {
			System.out.println(arrayPwd[i]);
		}
		
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(5000);
		
		return password;
		

	}

	
}


