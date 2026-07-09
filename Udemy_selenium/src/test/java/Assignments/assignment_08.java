package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment_08 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("uni");
		
		WebElement value =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui-menu-item'][4]/div")));
		
		value.click();
		
		driver.findElement(By.cssSelector("#autocomplete")).clear();
		
		String down = Keys.chord(Keys.DOWN);
		String enter = Keys.chord(Keys.ENTER);
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(down);
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(enter);
		
		
	}

}
