package main.java;

import java.util.*;

public class Assignment2_27 {

	public static int[][] matrix;
	private static int[][] markedMatrix;

	private static boolean matrixExists() {
		if (matrix == null) {
			System.out.println("N by N matrix must be created to class");
			return false;
		}
		return true;
	}

	public static void createNByNMatrix(int N) {
		matrix = new int[N][N];
		markedMatrix = new int[N][N];
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int min = N * i, max = N * (i + 1);
				int r = max - min;
				matrix[i][j] = rand.nextInt(r) + min;
				markedMatrix[i][j] = 0;
			}
		}
		sort();
	}

	private static void sort() {
		if (!matrixExists()) return;
		for (int i = 0; i < matrix.length; i++) {
			Arrays.sort(matrix[i]);
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][0] < matrix[j][0]) {
					int[] temp = matrix[i];
					matrix[i] = matrix[j];
					matrix[j] = temp;
				}
			}
			Arrays.sort(matrix[i]);
		}
	}

	public static void checkContains(int c) {
		if (contains(c)) System.out.println("" + c + " is contained within the matrix.");
		else             System.out.println("" + c + " is not contained within the matrix.");
	}

	public static boolean contains(int c) {
		int loi = 0, hii = matrix.length - 1, midi = 0;
		while (loi <= hii) {
			midi = loi + (hii - loi) / 2;
			int loj = 0, hij = matrix.length - 1, midj = 0;
			while (loj <= hij) {
				midj = loj + (hij - loj) / 2;
				if      (c < matrix[midi][midj]) hij = midj - 1;
				else if (c > matrix[midi][midj]) loj = midj + 1;
				else return true;
		    }
			if      (c < matrix[midi][midj]) hii = midi - 1;
			else if (c > matrix[midi][midj]) loi = midi + 1;
		}
		return false;
	}

	private static boolean containsExclusive(int c, int x, int y) {
		int loi = 0, hii = matrix.length - 1, midi = 0;
		while (loi <= hii) {
			midi = loi + (hii - loi) / 2;
			int loj = 0, hij = matrix.length - 1, midj = 0;
			while (loj <= hij) {
				midj = loj + (hij - loj) / 2;
				if      (c < matrix[midi][midj]) hij = midj - 1;
				else if (c > matrix[midi][midj]) loj = midj + 1;
				else if (midi == x && midj == y) {
					if (y > 0 && matrix[midi][y - 1] == c)                 return true;
					if (y < matrix.length - 1 && matrix[midi][y + 1] == c) return true;
				}
				else return true;
		    }
			if      (c < matrix[midi][midj]) hii = midi - 1;
			else if (c > matrix[midi][midj]) loi = midi + 1;
		}
		return false;
	}

	private static void mark(int i, int j) { markedMatrix[i][j] = 1; }
	private static boolean hasMarked(int i, int j) { return markedMatrix[i][j] != 0; }
	
	public static void checkUnique() {
		if (!matrixExists()) return;
		boolean isUnique = true;
		boolean isOddSet = true;
		int N, n = N = matrix.length;
		int count = 0;
		while (count < 2) {
			count++;
			if (n % 2 == 0) {
				isOddSet = false;
				n = n / 2;
			}
			else n = (n + 1) / 2;
		}
		int x = isOddSet ? 1 : 0;
		for (int li = 0, ri = N - 1; li < n; li++, ri--) {
			for (int lj = 0, rj = N - 1; lj < n; lj++, rj--) {
				int a, b;
				int c = n - x, d = n + x;
				if (!hasMarked(li, lj)) {
					mark(li, lj);
				    if (!(isUnique = !containsExclusive(matrix[li][lj], ri, rj))) break;
				}
				if (!hasMarked(ri, rj)) {
					mark(ri, rj);
					if (!(isUnique = !containsExclusive(matrix[ri][rj], ri, rj))) break;
				}
				if (!hasMarked((a = li + c), (b = lj + c))) {
					mark(a, b);
					if (!(isUnique = !containsExclusive(matrix[a][b], a, b))) break;
				}
				if (!hasMarked((a = ri - d), (b = rj - d))) {
					mark(a, b);
					if (!(isUnique = !containsExclusive(matrix[a][b], a, b))) break;
				}
			}
		}

		if (isUnique) System.out.println("This matrix is unique.");
		else          System.out.println("This matrix is not unique.");
	}

	public static void displayMatrix() {
		String displayMessage = "";
		if (!matrixExists()) return;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				displayMessage += matrix[i][j] + " ";
			}
			displayMessage.trim();
			displayMessage += "\n";
		}
		
		System.out.println(displayMessage);
	}
}
