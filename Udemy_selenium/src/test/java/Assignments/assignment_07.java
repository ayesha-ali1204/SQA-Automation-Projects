// Table
//Subset of Driver
package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_07 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 800)");
		
//		rows
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name='courses']/tbody/tr"));
		System.out.println("There are "+rows.size()+" rows in the table.");
		
//		columns
		List<WebElement> columns = driver.findElements(By.xpath("//*[@name='courses']/tbody/tr[1]/th"));
		System.out.println("There are "+columns.size()+" columns in the table.");
//		OR
		int cols = rows.get(0).findElements(By.tagName("th")).size();
		System.out.println("Number of columns in table: "+cols);
		
//		Get second row Data
		List<WebElement> tableData = rows.get(2).findElements(By.tagName("td"));
		
		for (WebElement data: tableData) {
			String secondRowData = data.getText();
			
			System.out.println(secondRowData);
		}
		
	}

}
