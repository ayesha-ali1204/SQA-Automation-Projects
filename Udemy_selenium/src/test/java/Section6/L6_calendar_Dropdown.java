package Section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L6_calendar_Dropdown {

	public static void main(String[] args) {
		
//		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).click();
		
		
		
	}

}
