package Section3;

public class S2_ArrayInJava {

	public static void main(String[] args) {
		
//		Array -- Storing multiple values into a single variable
		
//		Declaring array
//		new --> new keyword is used for assigning memory
		int[] arr = new int[5];
		
//		assigning values in declared array
		arr[0] = 5;
		arr[1] = 6;
		arr[2] = 7;
		arr[3] = 8;
		arr[4] = 9;
		
//		directing assigning values into array
		int[] arr2 = {1, 2, 3, 4, 5, 6};
		
		System.out.println("Value stored in arr2 at index 0: "+arr2[0]);
		System.out.println("Value stored in arr1 at index 4: "+arr[4]);

	}

}
