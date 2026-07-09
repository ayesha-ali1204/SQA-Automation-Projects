package Section10_realTimeExercise;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class exercise_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
////	Count of Links present on the WebPage
		List<WebElement> linksCount = driver.findElements(By.tagName("a"));
		System.out.println(linksCount.size());
		
////	count of links present on the footer of web page
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
//		use WebElement 'footer'	as a Subset of driver
		List<WebElement> footerLinksCount= footer.findElements(By.tagName("a"));
		System.out.println(footerLinksCount.size());
		
////	Counts of links present in the first column of footer
		WebElement footercolumndriver = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));
		List<WebElement> links =  footercolumndriver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
////	open all links in the footer
		for (int i=1; i<links.size(); i++) {
			String keyboardAction = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footercolumndriver.findElements(By.tagName("a")).get(i).sendKeys(keyboardAction);
		}
		
////		Get title of each window tab
		Set<String> windows = driver.getWindowHandles();
		
//		METHOD 1
//		convert set to ArrayList
		List<String> windowsList = new ArrayList<>(windows);
		for (int i=0; i<windowsList.size();i++) {
			String win = windowsList.get(i);
			driver.switchTo().window(win);
			String title =driver.getTitle();
			System.out.println(title);
		}
		
//		METHOD 2
//		Using Iterator and While Loop
		Iterator<String> at = windows.iterator();
		
		while(at.hasNext()) {
			driver.switchTo().window(at.next());
			System.out.println(driver.getTitle());
		}
	}

}
