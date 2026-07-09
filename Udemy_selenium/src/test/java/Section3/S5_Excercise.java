package Section3;

public class S5_Excercise {

	public static void main(String[] args) {
		
//		Create a new array called numbers to store 5 numerical values
		int[] numbers = {1, 2, 3, 4, 5};
		
//		The first element of the numbers array.
		System.out.println("First Element of array: "+numbers[0]);
		
//		The last element of the numbers array.
        System.out.println("Last Element of array: "+numbers[4]);
		
//		Reverse Order:
//		Using a loop, print the elements of the numbers array in reverse order.
        for(int i = numbers.length -1; 0<i; i--){
            System.out.println("Element on "+ i +" index is "+numbers[i]);
        }
	
//		Calculate the total number of elements within the numbers array.
		System.out.println("Total number of elements in array are: "+ numbers.length);

//		Sum elements in the array;		        
		int sum = 0;
		for (int i = 0; i<numbers.length; i++){
			sum = sum + numbers[i];
		}
		System.out.println(sum);

	}

}
