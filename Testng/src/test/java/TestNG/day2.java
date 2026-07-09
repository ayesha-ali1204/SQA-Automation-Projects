//Clear cut understanding on annotations - group - methodtorunbefore - parameters
//
//Global environment variables can be incorporated though selenium - xml file [@Parameters({"URL2"})]
//
//Parameterizing with multiple data sets by running tests with multiple combination - @dataProvider


package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {

//	used if we have to run some test cases from the suite and not all
	@Test (groups= {"smoke"})
	public void test4() {
		System.out.println("Test case 4");
	}
	
//	achieve parameterization? in two ways. 
//	achieve parameterization - drive the data from TestNG XML file 
		
	@Parameters({"URL2"})
	@Test
	public void test5(String urlval) {
		System.out.println("Test case 5");
		System.out.println(urlval);
	}
	

//	achieve parameterization - you can parameterize it using data provider annotation.

	@Test (groups= {"smoke"}, dataProvider="getData")
	public void test6(String username, String password) {
		System.out.println("Test case 6");
		System.out.println(username);
		System.out.println(password);
	}
	

//	defining data-provider annotation.

	@DataProvider
	public Object[][] getData()
	{
	    // 1st combination - username password - good credit history - row
	    // 2nd - username password - no credit history
	    // 3rd - fraudulent credit history

	    Object[][] data = new Object[3][2];

	    // 1st set
	    data[0][0] = "firstsetusername";
	    data[0][1] = "password";

	    // columns in the row are nothing but values for that particular combination (row)

	    // 2nd set
	    data[1][0] = "secondsetusername";
	    data[1][1] = "secondpassword";
	    
	 // 3rd set
	    data[2][0] = "thirdsetusername";
	    data[2][1] = "thirdpassword";
	    
	    return data;
	}
}
