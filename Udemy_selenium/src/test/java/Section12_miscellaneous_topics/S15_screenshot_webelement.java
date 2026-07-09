package Section12_miscellaneous_topics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S15_screenshot_webelement {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys("Ayesha Ali");
		
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
//		Get height and Widthssa of the WebElement for UX validation
		int h = name.getRect().getDimension().getHeight();
		int w = name.getRect().getDimension().getWidth();
		System.out.println(h);
		System.out.println(w);
	}

}
