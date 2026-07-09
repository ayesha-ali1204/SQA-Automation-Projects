package Section3;

public class S4_loopConditions {

	public static void main(String[] args) {
		int[] array1 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		
//		finding multiple of 2.
		for(int i=0;i<array1.length;i++) {
			
			if(array1[i]%2 == 0) {
				System.out.println(array1[i]+ " is a multiple of 2.");
			}
			
			else {
				System.out.println(array1[i]+ " is not a multiple of 2.");
			}
			
		}
		
//		finding first multiple of 2 in a list
		for(int i=0;i<array1.length;i++) {
			
			if(array1[i]%2 == 0) {
				System.out.println(array1[i]+ " is a multiple of 2.");
				break;
			}
		}

		String[] name = {"Ayesha", "Alisha", "Ayat"};
		
//		finding first multiple of 2 in a list
		for(int i=0;i<name.length;i++) {
			
			if(name[i] == "Alisha") {
				System.out.println(name[i] + " Exist in a list 'name'.");
				break;
			}
			
			
			
		}

	}

}
