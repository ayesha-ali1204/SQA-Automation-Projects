package Section2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class S1_getTitle {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/geckodriver.exe");
//		WebDriver driver = new EdgeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty/Documents/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
//		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		
//		get the title of the webpage
		System.out.println(driver.getTitle());
		
//		get the current url of the webpage
		System.out.println(driver.getCurrentUrl());
		
//		close the current window
		driver.close();
		
//		close all the associate window that have been opened while running the script.
//		driver.quit();
	}

}
