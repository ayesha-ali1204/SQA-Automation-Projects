package Section3;

public class S7_Strings {

	public static void main(String[] args) {
//		String is an object in java
//		String -- represent the sequence of characters
		
//		two mwethods for defining Strings
//		String literals
		String s1 = "Ayesha Ali";
		String s2 = "Ayesha Ali";
		
//		Note: Here I have created two String that has same String stored in two different variables 
//		it will create a new object for S1
//		since s2 has same string but, it will refer the same Object create for S1(as it has same String as s1)
		
//		String Object
		String s3 = new String("Welcome");
		String s4 = new String("Welcome");
		
//		Here for both String two different object will get create.(in memory Space)
		
		
//		STRING METHODS
		String s = "Rahul Shetty Academy";
		
		String[] splittedString= s.split(" ");
		
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);

		System.out.println("**********************************************");

		String[] splittedString2= s.split("Shetty");
		System.out.println(splittedString2[0]);
		
//		Trim() -- used for removing additional spacing from the "Start of the String"
		System.out.println(splittedString2[1].trim());
		
		
//		To print each character Separately
		for (int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
//		Reverse of String
		for (int i=s.length()-1; i>=0; i--) {
			System.out.print(s.charAt(i));
		}
		
		
		
		
	}

}
