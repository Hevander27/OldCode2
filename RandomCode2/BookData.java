package main.java;

public class BookData {
	
	private String title;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BookData other = (BookData) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookData [title=" + title + "]";
	}

	public BookData(String title) {
		super();
		this.title = title;
	}

	public String getName() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}
}
