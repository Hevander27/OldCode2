package main.java;

public class BookLinkedList {
	
	private BookNode start;
	private int size;
	
	public BookLinkedList() {
		super();
		start = null;
		size = 0;
	}
	
	public void insert(BookData b, int position) {
		BookNode newNode = new BookNode(b);
		BookNode current = start;
		if (position >= size) add(b);
		else {
			if (position == 0) {
				for (; current != null; current = current.getNext()) {
					current.setPosition(current.getPosition() + 1);
				}
				newNode.setNext(start);
				newNode.setPosition(0);
				this.start = newNode;
				size++;
			}
			else {
				while(current != null) {
					if (position - 1 == current.getPosition()) {
						BookNode nextNode = current.getNext();
						for (BookNode node = nextNode; node != null; node = node.getNext()) {
							node.setPosition(node.getPosition() + 1);
						}
						newNode.setNext(nextNode);
						newNode.setPosition(position);
						current.setNext(newNode);
						size++;
						break;
					}
					current = current.getNext();
				}
			}
		}
	}
	
	/*public BookData delete(int position) {
		
	}*/
	
	public void delete(BookData b) {
		BookNode node = new BookNode(b);
		BookNode current = start;
		if (size == 0) start = null;
		else {
			if (start.equals(node)) {
				current = current.getNext();
				for (; current != null; current = current.getNext()) {
					current.setPosition(current.getPosition() - 1);
				}
				start = start.getNext();
				size--;
			}
			else {
				BookNode previous = current;
				current = start.getNext();
				while (current != null) {
					if (current.equals(node)) {
						BookNode nextNode = current.getNext();
						previous.setNext(nextNode);
						for (current = nextNode; current != null; current = current.getNext()) {
							current.setPosition(current.getPosition() - 1);
						}
						size--;
						break;
					}
					previous = current;
					current = current.getNext();
				}
			}
		}
	}
	
	public void add(BookData b) {
		BookNode node = new BookNode(b);
		BookNode current;
		if (start == null) start = node;
		else {
			current = start;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
		size++;
		node.setPosition(size - 1);
	}
	
	public int size() { return size; }
	
	public String toString() {
		String result = "Size: " + size() + "\n";;
		BookNode current = start;
		while (current != null) {
			result += current.getPosition() + " - " + current + "\n";
			current = current.getNext();
		}
		return result;
    }
}
