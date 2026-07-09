package Section12_miscellaneous_topics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class L5_find_broken_links {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		SoftAssertion
		SoftAssert sassert = new SoftAssert();
		
		List<WebElement> links =  driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		for(WebElement link : links) {
			String url = link.getAttribute("href");
//			System.out.println(link.getText());
			
			HttpURLConnection conn = (HttpURLConnection)new URI(url).toURL().openConnection();
			
			conn.setRequestMethod("HEAD");
			
			conn.connect();
			
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			
			sassert.assertTrue(respCode<400, "this is the broken link "+link.getText());
		}
		
		sassert.assertAll();

	}

}
