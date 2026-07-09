package Section10_realTimeExercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class excercise_2_handleCalenders {

	public static void main(String[] args) {
		
		String date = "21";
		String month = "12";
		String year = "2024";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		
		driver.findElement(By.className("react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.className("react-calendar__navigation__label__labelText--from")).click();

////		select year
		driver.findElement(By.xpath("//*[text()='"+year+"']")).click();

////		select month
//		direct by xpath
		driver.findElement(By.xpath("//*[contains(@class, 'react-calendar__tile react-calendar')]["+Integer.parseInt(month)+"]")).click();
//		by findElements and get method
//		driver.findElements(By.xpath("//*[contains(@class, 'react-calendar__tile react-calendar')]")).get(Integer.parseInt(month)-1).click();

////		select date
		driver.findElement(By.xpath("//*[text()='21']")).click();
		
		
//		Comparing if the input is correctly entered or not
		List<WebElement> expectedList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		String[] actualList = {month, date, year};
		
		for (int i=0; i<expectedList.size(); i++) {
			String values = expectedList.get(i).getAttribute("value");
			System.out.println(values);
			Assert.assertEquals(values, actualList[i]);
		}
	}
	
	
	

}
