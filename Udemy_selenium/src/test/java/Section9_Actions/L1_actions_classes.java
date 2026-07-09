package Section9_Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L1_actions_classes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.com/");
		
		Actions action = new Actions(driver);
		
		WebElement target =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-csa-c-content-id='nav_ya_signin']")));
		
		Actions element = action.moveToElement(target);
		
		element.perform();

	}

}
