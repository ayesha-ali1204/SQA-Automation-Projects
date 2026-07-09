package Section8_synchronization;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S1_assignment1_EndToEnd {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
		
		driver.findElement(By.xpath("//input[@type='radio'][@value='user']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#okayBtn"))).click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("[data-style=\"btn-info\"]"));
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Consultant");
		
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		String hometitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ProtoCommerce Home']"))).getText();
		System.out.println(hometitle);
		
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='card-title']/a"));
		List<WebElement> addbtn = driver.findElements(By.xpath("//*[@class='btn btn-info']"));
		
		for(int i=0; i<products.size(); i++) {
			String prodNames = products.get(i).getText();
			System.out.println(prodNames);
			addbtn.get(i).click();
			System.out.println(prodNames+" is clicked.");
			
		}
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		
		
		
		

	}

}
