//		Window Handles

package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment_04 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//*[text()='Multiple Windows']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href*='windows/new']"))).click();
		
//		Window Handles
		Set<String> windows = driver.getWindowHandles();
		
//		convert Set into List
		List<String> windowsList = new ArrayList<> (windows);
		
		driver.switchTo().window(windowsList.get(1));
		String window1 = driver.findElement(By.tagName("H3")).getText();
		System.out.println(window1);
		
		driver.switchTo().window(windowsList.get(0));
		String window2 = driver.findElement(By.tagName("H3")).getText();
		System.out.println(window2);

	}

}
