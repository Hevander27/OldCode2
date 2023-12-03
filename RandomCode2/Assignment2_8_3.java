import java.util.*;

public class Assignment2_8_3 {

	public static void main(String args []) {
		
		Assignment2_8_3 obj = new Assignment2_8_3();
		
		long startTime;
		
		long endTime ;
		
		long sum = 0;
		
		int b = 0;
		int a[] = obj.arry1();
		
		
		while( b < 10) {
				
			startTime = System.nanoTime();
			
			for(int i = 0; i < a.length; i++) {
				
			obj.swapReferences(i,randInt(0,i),a);
			
			}
			
			endTime = System.nanoTime();
			
			System.out.printf("\nRuntime : " + String.format( "%12.10f",
					((endTime-startTime)/Math.pow(10,9))) + " seconds"); 
			
			sum = sum + ((endTime-startTime));
			
			b++;
	}
		System.out.println();
				
		System.out.printf("\nAvg_Runtime : " + String.format( "%12.10f",
				((sum/b)/Math.pow(10,9))) + " seconds"); 
		

		System.out.println("\n");
		
		for(int i = 0; i < a.length; i++) {
			
			System.out.println(a[i]);
		}
		
	}
	int size;
	public int[]arry1() {
		
		System.out.println("Enter array size: ");
		
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		
		int a[] = new int[size];
		
		for(int i = 0; i < size; i++) { a[i] = i + 1;}
		
		sc.close();
		
		return a;
	}
	public static int randInt(int min, int max) {
		
		Random rand = new Random();
		
		int randomNum = rand.nextInt((max-min)+1) + min;
		
		return randomNum;
	}
	public void swapReferences(int i, int j, int a[]) {
		
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
