package Section3;

public class S8_Methods {

	public static void main(String[] args) {
		
//		Creating object for the class
		S8_Methods d = new S8_Methods ();
		
//		using object to accessing other methods
		d.getData();
		
//		creating str to accessing StringMethod
		String str = d.getStrData();
		System.out.println(str);
		System.out.println("**********************************************");
		
//		Static keyword == Get Data in the own class without creating an object 
//		When we use "Static keyword" class level access is provided to the methods
		getData2();
		System.out.println("**********************************************");
		
//		Accessing methods from another class
		S8_1_AccessingMethods otherclass = new S8_1_AccessingMethods();
		String str2 = otherclass.getUserData();
		System.out.println(str2);
		
	}
	
	public void getData() {
		System.out.println("Hello World");
	}
	
	public String getStrData() {
		return "Ayesha Ali";
	}
	
	public static void getData2() {
		System.out.println("Get Data in the own class without creating an object -- if using a static keyword");
	}

}
