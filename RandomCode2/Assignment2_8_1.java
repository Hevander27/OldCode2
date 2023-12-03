import java.util.*;

public class Assignment2_8_1 {

	public static void main(String[] args) {
		
		System.out.println("Enter array size: ");
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int size = scan.nextInt();
		
		int array[] = new int[size];
		
		int low = 1;
		int j = 1;
		int high = size + 1;
		int ran;
		long startTime;
		long endTime;
		int a = 0;
		long sum = 0;
		ran = rand.nextInt(high-low)+low;
		array[0] = ran;
		
		
		while(a < 10) {
			
			 startTime = System.nanoTime();
			 
			 while(j < size) {
				 
				//startTime = System.nanoTime();
				 
				 ran = rand.nextInt(high-low)+low;
			
				 for(int i = 0; i < size; i++ ) {
				
					 if(ran == array[i])
						 break;
					
					 else if ( i == j-1) {
					
						 array[j] = ran;
	
					  j++;
					 
				}
			}
		}
		a++;	
		
			endTime = System.nanoTime();
		
			 System.out.printf("\nRuntime : " + String.format( "%12.10f",
							((endTime-startTime)/Math.pow(10,9))) + " seconds");
			
			 sum = sum + ((endTime-startTime));	     
		
	}

		System.out.println();
		
		System.out.printf("\nAvg_Runtime : " + String.format( "%12.10f",
				((sum/a)/Math.pow(10,9))) + " seconds");
		
		System.out.println("\n");
		
		for(int i = 0; i < size; i++) {
			
			System.out.println(array[i]);
		}
	
	}

}
