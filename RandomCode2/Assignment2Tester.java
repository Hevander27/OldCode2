import java.util.*;

public class Assignment2Tester {

	public static void main(String args []) {
		
		Scanner scan = new Scanner(System.in);
		
		Assignment2_19_1 obj1 = new Assignment2_19_1();
		
		Assignment2_19_2 obj2 = new Assignment2_19_2();
		
		
		long startTime;
		
		long endTime;
		
		System.out.println("Enter array size: ");
		
		int size  = scan.nextInt();
		
		scan.close();
		
		startTime = System.nanoTime();
		
		//System.out.println(obj1.ArrayInfo(size));
		System.out.println(obj2.ArrayInfo(size));
		
		endTime = System.nanoTime();
		
		System.out.printf("Runtime : " + String.format( "%12.5f",
				((endTime-startTime)/Math.pow(10,9))) + " seconds");
	}
}
