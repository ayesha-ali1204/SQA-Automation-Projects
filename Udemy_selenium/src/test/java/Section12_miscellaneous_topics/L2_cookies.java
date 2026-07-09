package Section12_miscellaneous_topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L2_cookies {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
//		Deletes all website cookies
		driver.manage().deleteAllCookies();
		
//		Scenario
//		You are working on some website.
//		you have to delete check if the application got log out when you delete the session cookie
//		Here we will delete specific cookie, click on any link, and user should be at login page (Verify).
		driver.manage().deleteCookieNamed("sessionKey");
//		driver.findElement(By.id("")).click();
//		Verify user should be on verify page
		
		
		

	}

}
