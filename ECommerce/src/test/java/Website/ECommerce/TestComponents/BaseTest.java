package Website.ECommerce.TestComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Website.ECommerce.PageObjects.LoginApplication;
import Website.ECommerce.PageObjects.OrdersPage;
import Website.ECommerce.PageObjects.ProductCatalogue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class BaseTest {
	
//	In java there is a class called 'Properties' that read the global properties
//	create a properties class, that decides on runtime which browser to used for executing test cases
	
	public static  WebDriver driver;
	public static LoginApplication loginApp;
	public static OrdersPage orders;
	public static ProductCatalogue prodcutCatelogue;
	
	public WebDriver initializeDriver() throws IOException {
		
//		properties class in java
		Properties prop = new Properties();
		
//		convert file into stream
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"//src//main//java//Website//ECommerce//Resources//GlobalData.properties");
		
//		load methods - parse the file and extract all the keywords from the file
		prop.load(fis); //file is expected to send in stream

//		get property
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firfox")) {
//			firefox
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
//			edge
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
	}
//	System.getProperty("user.dir")+"src\\test\\java\\Website\\ECommerce\\data\\PurchaseOrder.json"
	
	public List<HashMap<String, Object>> GetJsonToMap(String filepath) throws IOException {
//		read JSON to String
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
//		String to HashMap Jackson Databind\
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, Object>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, Object>>>() {
		});
		return data; //{map, map}
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
	
	@BeforeMethod (alwaysRun=true)
	public LoginApplication LaunchApplication() throws IOException {
		driver = initializeDriver();
		loginApp = new LoginApplication(driver);
		loginApp.goTo();
		return loginApp;
	}
	
	@AfterMethod (alwaysRun=true)
	public void TearDown() {
		driver.close();
	}
}
