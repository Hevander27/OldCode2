package main.java;

import main.java.Music;
import main.java.DoublyLinkedList;

/**
 * Name: Hevander Da Costa
 * Class Name:
 * Project Number: 2
 * Project Due Date: 4/28/17
 * Program Title: Driver.java
 * Program Description:
 *     - Driver class - Music and DoublyLinkedList operations
 */

public class Driver {

	public static void main(String[] args) {
		DoublyLinkedList<Music> list = new DoublyLinkedList<Music>();
		list.addFirst(new Music("Trapt", "Lost Realist", "04/05/05"));
		list.addFirst(new Music("Chevelle", "Jars", "06/10/06"));
		list.addFirst(new Music("Chevelle", "Letter From a Thief", "06/10/06"));
		list.addFirst(new Music("Fireflight", "You Decide", "02/20/07"));
		list.addFirst(new Music("Crossfade", "Colors", "08/15/04"));
		list.addFirst(new Music("Crossfade", "So Far Away", "08/15/04"));
		
		System.out.println(list);

		Music deleted = list.delete(3);
		Music last = list.removeLast();
		list.addLast(list.removeFirst());
		list.addFirst(last);
		
	    System.out.println(list.contains(deleted));
		System.out.println(list);
		
		list.insert(3, new Music("32 Leaves", "Sudden Change", "09/03/05"));
		
		System.out.println(list);

		list.delete(deleted);
	}
}
