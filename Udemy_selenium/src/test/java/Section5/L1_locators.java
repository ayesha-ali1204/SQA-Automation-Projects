package Section5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L1_locators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//		ID
		driver.findElement(By.id("inputUsername")).sendKeys("Ayesha");
		
//		Name
		driver.findElement(By.name("inputPassword")).sendKeys("abc");
		
//		ClassName
		driver.findElement(By.className("signInBtn")).click();
		
//		CssSelector
		
//		by ID ==> Tagname#id ==> input#inputUsername ==> #inputUsername 
//		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Ayesha");
		
//		byClass ==> Tagname.Class ==> button.signInBtn ==> .signInBtn
//		driver.findElement(By.cssSelector("button.signInBtn")).click();
		
//		by attribute ==> Tagname[Attribute="Value"] ==> Input[placeholder="Username"] ==> [placeholder="Username"]
//		driver.findElement(By.cssSelector("Input[placeholder='Username']")).sendKeys("Ayesha");
		
//		Multiple Classes
//		driver.findElement(By.cssSelector(".submit.signInBtn"));
		
		String errortext = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errortext);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Ayesha");
		
		driver.findElement(By.xpath("//*[@type='text'][2]")).sendKeys("ayesha.ali@dibpak.com");
		driver.findElement(By.xpath("//*[@type='text'][2]")).clear();
		driver.findElement(By.xpath("//*[@type='text'][2]")).sendKeys("ayesha.ali@dibpak.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("033254232434");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
//		ElementClickInterceptedException -- encounter when another element is getting clicked but not the actual one
		
		
		
	}

}
