package Section3;

public class S3_loops {

	public static void main(String[] args) {
		
//		int[] integers = {1, 2, 3, 4, 5, 6};
		int[] array1 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		
		for(int i=0; i<array1.length; i++) {
			System.out.println(array1[i]);
		}
		
		String[] names = {"Ayesha", "Hadia", "Alisha", "Yumna"};
		
		for(int i=names.length-1; i>=0; i--) {
			System.out.println("Name on "+i+" index is: "+names[i]);
		}
		
		for(String n: names) {
			System.out.println(n);
		}
	}

}
