package OOP;

import org.testng.annotations.Test;

//// using methods of parent (inheritance) class in child class 
//public class child extends inheritence{	
//	@Test
//	public void childMethod() {
////		inheritance (directly method called in child class, used extend keyword with class)
////		parentMethod();
//	}
//}


public class child{
	@Test
	public void childMethod() {
		
		//using parent class method, by creating Object
		anotherParent ap = new anotherParent(3);
		
		System.out.println("Increment: "+ap.increment());
		System.out.println("Decrement: "+ap.decrement());
		
	}
	
}


