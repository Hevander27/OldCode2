package main.java;

import java.util.*;
import main.java.Assignment2_27;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter matrix number N: ");
		int N = scan.nextInt();
		Assignment2_27.createNByNMatrix(N);
		Assignment2_27.displayMatrix();
		System.out.println("Please enter an integer to search: ");
		int x = scan.nextInt();
		Assignment2_27.checkContains(x);
		Assignment2_27.checkUnique();
		scan.close();
	}
}
