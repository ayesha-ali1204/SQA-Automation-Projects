package Website.ECommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Website.ECommerce.AbstractComponents.abstractComponent;

public class LoginApplication extends abstractComponent{
	
WebDriver driver;
	
	public LoginApplication(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id="userEmail")
	WebElement userEmail;
	
	@FindBy (id="userPassword")
	WebElement password;
	
	@FindBy (id="login")
	WebElement submit;
	
	@FindBy (css="div[aria-label='Incorrect email or password.']")
	WebElement errorMsg;

//	Get URL Method	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();
	}
	
	public String LoginFailErrorMessage(){
		waitForElementToBeVisible(errorMsg);
		return errorMsg.getText();
		
	}

//	Login to Application
	public ProductCatalogue Login(String email, String pass) {
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue catalogue = new ProductCatalogue(driver);
		return catalogue;
	}
}
