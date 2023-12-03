package main.java;

public class BookLinkedListTester {
	
	public static void main(String[] args) {
		BookLinkedList sl = new BookLinkedList();

		// Add
		sl.add(new BookData("Harry Potter"));
		sl.add(new BookData("Captain Underpants"));
		sl.add(new BookData("Pendragon"));
		sl.add(new BookData("Lord Of the Flies"));
		sl.add(new BookData("Native Son"));
		System.out.println(sl);

		// Insert
	    sl.insert(new BookData("As I Lay Dying"), 2);
		sl.insert(new BookData("100 Years of Solitude"), sl.size() - 2);
		System.out.println(sl); 

		// Delete
		sl.delete(new BookData("Pendragon"));
		sl.delete(new BookData("Harry Potter"));
		sl.delete(new BookData("Captain Underpants"));
		System.out.println(sl); 
	}
}
