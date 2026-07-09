package OOP;

public class anotherParent extends multiply{
	
	int a;

	//	creating class constructor
	public anotherParent(int a) {
		super(a);
		this.a = a;
	}
	
	public int increment() {
		a = a+1;
		return a;
	}
	
	public int decrement() {
		a = a-1;
		return a;
	}
}
