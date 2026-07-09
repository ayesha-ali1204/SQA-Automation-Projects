package Section9_Actions;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L2_windowActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		
		String parentwindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		
		for(String win : windows) {
				
			if (!win.equals(parentwindow) ){
				driver.switchTo().window(win);
			}
			
		}
		
		String email = driver.findElement(By.xpath("//*[@class='im-para red']")).getText();
		System.out.println(email);
		
		String string = email.split("at")[1].trim().split(" ")[0].trim();
		System.out.println(string);
		
		driver.switchTo().window(parentwindow);
		
		driver.findElement(By.cssSelector("#username")).sendKeys(string);
		
		
		

	}

}
