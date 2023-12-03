package main.java;

import java.util.*;

public class Book extends ReadingMaterial {

	private static String[] characters = {"Tom Thompson", "Gary Allison", "Richard Michael",
										  "John James", "Cole Coley", "Evan Kingston"};
	private static String[] listOfSynapses = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices felis vitae erat fermentum lobortis. Morbi dapibus tempor turpis vel dignissim.",
											  "Nullam at finibus dolor. Ut ultrices lacus at tortor fringilla pharetra. Integer lectus enim, interdum eu facilisis vel, tristique nec orci.",
											  "Nulla placerat ullamcorper nisi eu varius. Nam interdum, libero vel vestibulum varius, nibh urna tincidunt dui, non vestibulum diam velit sed lectus.",
											  "Fusce blandit pellentesque mauris, bibendum convallis lacus consectetur eget. Nunc faucibus lorem vitae augue iaculis facilisis. Sed nec molestie sapien."};
	
	private String synapses;
	private String primaryCharacter;

	public Book(String title, String[] authors, String publisher) {
		super(title, authors, publisher);
		rollSecondaryAttributes();
		int rnS = (int) (Math.random() * listOfSynapses.length);
		int rnC = (int) (Math.random() * characters.length);
		synapses = listOfSynapses[rnS];
		primaryCharacter = characters[rnC];
	}

	////////////
	// GETTERS

	public String getSynapses() { return synapses; }
	public String getPrimaryCharacter() { return primaryCharacter; }
}
