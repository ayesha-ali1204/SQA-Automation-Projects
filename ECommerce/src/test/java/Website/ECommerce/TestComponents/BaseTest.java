package Website.ECommerce.TestComponents;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Website.ECommerce.PageObjects.LoginApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
	
//	In java there is a class called 'Properties' that read the global properties
//	create a properties class, that decides on runtime which browser to used for executing test cases
	
	public WebDriver driver;
	
	public LoginApplication loginApp;
	
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
	
	@BeforeMethod
	public LoginApplication LaunchApplication() throws IOException {
		driver = initializeDriver();
		loginApp = new LoginApplication(driver);
		loginApp.goTo();
		return loginApp;
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
