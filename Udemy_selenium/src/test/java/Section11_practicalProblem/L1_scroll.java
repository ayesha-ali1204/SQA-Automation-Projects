package Section11_practicalProblem;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class L1_scroll {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		Scroll web Page
		js.executeScript("window.scrollBy(0, 600)");
		
		Thread.sleep(5000);

		
//		Scroll into table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		
		List<WebElement> values = driver.findElements(By.xpath("//*[@class='tableFixHead']/table/tbody/tr/child::td[4]"));
		int sum = 0;
		for (int i=0; i<values.size(); i++) {
			
//			String val = values.get(i).getText();
//			Integer.parseInt(val);
			
//			Convert values to int then SUM them
			sum = sum + Integer.parseInt(values.get(i).getText());	
		}
		
		System.out.println(sum);
		
//		Comparing it with the value
		String act_value = driver.findElement(By.cssSelector(".totalAmount")).getText();
		int actual_value = Integer.parseInt(act_value.split(":")[1].trim());
		
		
		Assert.assertEquals(sum, actual_value);
		System.out.println("Test Passed");
	}

}
