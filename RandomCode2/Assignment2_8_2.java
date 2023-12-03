
import java.util.*;

public class Assignment2_8_2 {
	
	public static void main(String args []) {
		
		Assignment2_8_2 obj = new Assignment2_8_2();
		
		System.out.println("Enter array size: ");
		
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		
		int array[] = new int[size];
		
		
		boolean used[] = new boolean [size];
		
		for(int i =0; i < size; i++) { used[i] = false; }
		
		int low = 1;
		int high = size + 1;
		int ran;
		long startTime;
		long endTime;
		int j = 1;
		int a = 0;
		long sum = 0;
		
		Random r = new Random();

		for(int i = 0; i < size; i++) {
		
			do {
				
				ran = r.nextInt(high-low)+low;
				
				array[0] = ran;
				
				if(used[ran-1] == false) {
					
					array[i] = ran;
					break;
				}
				
			}while(used[ran-1] == true);
		}
		
		
		for(int i = 0; i< size; i++) { System.out.println(array[i]);}
		
	 }
	

}
	
