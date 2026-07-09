package Section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S6_arrayLst {

	public static void main(String[] args) {
		
//		in Array there is a static size that is define initially, 
//		whereas in ArrayList Size of the array can be dynamically grow
		
//		Array list is a class in java
		ArrayList al = new ArrayList();
//		to access any class in java -- we need to create its object
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Ayesha");
		a.add("Ali");
		a.add("Alisha");
		a.add("Hadia");
		a.add("Raha");
		a.add("Maya");
		System.out.println(a);
		a.remove(0);
		System.out.println(a);
		
		System.out.println(a.get(3));
		
		System.out.println("**********************************************");
		
//		for arrayList we use 'size()' & 'get()'.
//		for simple Array we use 'length()' & 'index[]'
		
		for (int i=0; i<a.size(); i++) {
			System.out.println("Element on Index"+i+"is: "+a.get(i));
		}
		
		System.out.println("**********************************************");
		
		for (String name: a) {
			System.out.println(name);
		}
		
		System.out.println("**********************************************");
		
//		Search if element exist in a ArrayList
		System.out.println(a.contains("Raha"));
		
		System.out.println("**********************************************");
		
//		Converting array into ArrayList
		String[] names = {"Ali", "Raza", "Ahsan", "Hayat", "Ahmed"};

//		to use 'contain()' we need to convert array into ArrayList/List
		List<String> namesArrayList = Arrays.asList(names);
		System.out.println(namesArrayList.contains("Hayat"));
		
	}

}
