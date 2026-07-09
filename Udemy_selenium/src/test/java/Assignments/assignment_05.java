//Frames

//Switch the to frame inside the frame


package Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment_05 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("[href*='nested_frames']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("frame")));
		
//		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		String content = driver.findElement(By.cssSelector("#content")).getText();
		
		System.out.println(content);
		
		driver.switchTo().defaultContent();
		

	}

}
