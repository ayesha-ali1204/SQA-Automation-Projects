package Section5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class S16_invoking_multiple_wnidows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
//		open new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
//		get window handle
		Set<String> windows = driver.getWindowHandles();
		
//		iterate and store values
		Iterator<String> it =  windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
//		switch
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());

	}

}
