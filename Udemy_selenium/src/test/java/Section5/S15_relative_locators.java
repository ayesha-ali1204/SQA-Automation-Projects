package Section5;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S15_relative_locators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
//		Above() Relative Locator
		WebElement nameLabel = driver.findElement(By.cssSelector("[name='name']"));
		String label = driver.findElement(with(By.tagName("label")).above(nameLabel)).getText();
		System.out.println(label);
		
//		Below Relative Locator
//		Since the element below the webElement is flex element, therefore got the next element below the Date field
		WebElement date = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		WebElement below = driver.findElement(with(By.tagName("input")).below(date));
		System.out.println(below.getAttribute("type"));
		below.click();
		
//		toLeftOf()
		WebElement checkboxText = driver.findElement(By.cssSelector("[for=\"exampleCheck1\"]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxText)).click();
		
//		
		WebElement radioText = driver.findElement(By.cssSelector("[id='inlineRadio1']"));
		WebElement rightEl = driver.findElement(with(By.tagName("label")).toRightOf(radioText));
		System.out.println(rightEl.getText());
	}

}
