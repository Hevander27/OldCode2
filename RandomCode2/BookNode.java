package main.java;

public class BookNode {
	
	private BookData value;
	private BookNode next;
	private int position;
	
	public BookNode(BookData value) {
		super();
		this.value = value;
		next = null;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition( int position) {
		this.position = position;
	}
	
	public BookData getValue() {
		return value;
	}
	
	public void setValue(BookData value) {
		this.value = value;
	}
	
	public BookNode getNext() {
		return next;
	}
	
	public void setNext(BookNode node) {
		next = node;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookNode other = (BookNode) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
