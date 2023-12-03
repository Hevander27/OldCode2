package main.java;

import java.util.*;

/**
 * Name: Hevander Da Costa
 * Class Name:
 * Project: 1
 * Due Date: 3/3/17
 * Title: Playing Instruments
 * Description: Sorts instruments and displays information
 */

public class Driver {

	public static void main(String... args) {
		Instrument[] instruments = {new Guitar(345, 3, 4), new Violin(234, 5, 3),
		                            new Guitar(1000, 10, 4), new Violin(980, 10, 4)};
		Arrays.sort(instruments);
		for (Instrument i : instruments) {
			System.out.printf("%s\n\n", i);
			i.play();
			System.out.println();
		}
	}
}
