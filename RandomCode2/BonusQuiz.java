package project;

import java.util.Scanner;

public class BonusQuiz {
	public static class SafeCrackingExample {
		public static String[][] grid;
		public static void main(String[]args){
			
			Scanner s = new Scanner(System.in);
			int size =s.nextInt();
			grid = new String[size][size];
			int y = 0, x = 0;
			
					for(int i =0; i <size; i++)
					{
						for(int j = 0; j<size; j++)
						{
							grid[i][j]= s.next().toUpperCase();
							if(grid[i][j].equals("OPEN"))
							{
								x =j;
								y= i;
							}
							
						}
						
					}
					System.out.println(traverse(x,y));
		}
		public static boolean traverse(int x, int y)
		{
			boolean done = false;

		      if (valid(row, column))
		      {
		         grid[row][column] = TRIED;  // this cell has been tried

		         if (row == grid.length-1 && column == grid[0].length-1)
		            done = true;  // the maze is solved
		         else
		         {
		            done = traverse(row+1, column);     // down
		            if (!done)
		                done = traverse(row, column-1);  // left
		            if (!done)
		               done = traverse(row, column+1);  // right
		            if (!done)
		               done = traverse(row-1, column);  // up
		         }

		         if (done)  // this location is part of the final path
		            grid[row][column] = PATH;
		      }


		}
	}

}
