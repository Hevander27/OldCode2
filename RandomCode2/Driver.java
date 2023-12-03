package main.java;

import java.util.*;

public class Driver {

	private static String[] bookTitles = {"The Golden Ratio", "The Artic Continent",
                                          "The Pillars of Hercules", "The Great Dialectic"};
	private static String[] bookAuthors = {"Thomas Payne", "Edgar Scott", "Ronald McDonald"};
	private static String[] bookPublishers = {"O'Reilly", "Bookworm", "Mason Lodge"};
	
	private static String[] magazineTitles = {"Top 10 Latest Hits!", "Ready, set, go!",
											  "Winter Zone, Sports!"};
	private static String[] magazineAuthors = {"Henry Miller", "Allen Poe", "Jacob Frank"};
	private static String[] magazinePublishers = {"The Sigil", "Atlanta Times", "Big East"};
	
	public static void main(String[] args) {
		Book book = createBook();
		Magazine magazine = createMagazine();
		System.out.printf("%s\nSynapses:\n%s\n\n", book, book.getSynapses());
		System.out.printf("%s\nAdvertisements:\n%s\n\n", magazine, magazine.getAdvertisements());
		System.out.println(book.compareTo(magazine));
	}

	private static Book createBook() {
		String title = getRandomStringFromList(bookTitles);
		String[] authors = {getRandomStringFromList(bookAuthors)};		
		String publisher = getRandomStringFromList(bookPublishers);
		return new Book(title, authors, publisher);
	}

	private static Magazine createMagazine() {
		String title = getRandomStringFromList(magazineTitles);
		String[] authors = {getRandomStringFromList(magazineAuthors)};
		String publisher = getRandomStringFromList(magazinePublishers);
		return new Magazine(title, authors, publisher);
	}

	private static String getRandomStringFromList(String[] array) {
		int rn = (int) (Math.random() * array.length);
		return array[rn];
	}
}
