package Section9_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class L3_frames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());

////		Call method
//		handleIFrames(driver);
		
		//	Select IFrame by WebElement
		driver.switchTo().frame(0);
		
		
		WebElement source = driver.findElement(By.cssSelector("[id='draggable']"));
		WebElement target = driver.findElement(By.cssSelector("[id='droppable']"));	
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
		
		
		
		
		;
	}
	
	public static void handleIFrames(WebDriver driver) {
		
		WebElement iframe= driver.findElement(By.className("demo-frame"));
		
//		Select IFrame by WebElement
		driver.switchTo().frame(iframe);
		
		WebElement source = driver.findElement(By.cssSelector("[id='draggable']"));
		WebElement target = driver.findElement(By.cssSelector("[id='droppable']"));
		
		Actions action = new Actions(driver);
		action.clickAndHold(source);
		action.moveToElement(target);
		action.release();
		action.build().perform();
	}

}
