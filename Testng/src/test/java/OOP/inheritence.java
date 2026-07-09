package OOP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class inheritence {
	
	
	@Test
	public void parentMethod() {
		System.out.println("I am a parent");
	}
	
	@BeforeMethod
	public void pBeforeMethod() {
		System.out.println("I am a Before Method of TestNG, define in a parent class.");
	}
	
	@AfterMethod
	public void aBeforeMethod() {
		System.out.println("I am a After Method of TestNG, define in a parent class.");
	}

}
