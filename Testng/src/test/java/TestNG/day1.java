package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {

	@Test(groups= {"smoke"})
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Parameters ({"URL1", "APIKeyUser"})
	@Test 
	public void test2(String urlname, String api) {
		System.out.println("Test case 2");
		System.out.println(urlname);
		System.out.println(api);
	}
	
	@Test
	public void test3() {
		System.out.println("Test case 3");
	}

}
