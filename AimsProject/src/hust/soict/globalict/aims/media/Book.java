package hust.soict.globalict.aims.media;
import java.util.ArrayList;  
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public void copyContentOf(Book book) {
		super.setTitle(book.getTitle());
		super.setCategory(book.getCategory());
		for(String author : book.authors) {
			String copyAuthor = author;
			authors.add(copyAuthor);
		}
		super.setCost(book.getCost());
		super.setId(book.getId());
		super.setDateAdded(book.getDateAdded());
	}
	
	// Update
	public void addAuthor(String name) {
		if (name == null) {
			System.out.println("The string input is null");
			return;
		}
		
		if (authors.contains(name)) {
			System.out.println("The author has been added before");
		} else {
			authors.add(name);
			System.out.println("Author " + name + " has been added");
		}
	}
	
	public void removeAuthor(String name) {
		if (name == null) {
			System.out.println("The string input is null");
			return;
		}
		
		if (authors.contains(name)) {
			authors.remove(name);
			System.out.println("Author " + name + " has been removed");
		} else {
			System.out.println("Cannot find " + name + " in the author list");
		}
	}
	
	
	// Init
	public Book() {
		super();
	}
	
	public Book(String title, String category, float cost, String...inputAuthors) {
		super(title, category, cost);
		for (String author : inputAuthors) {
			if (author != null) {
				authors.add(author);
			}
		}
	}
	
	// Getter
	public String getAuthorsString() {
		String result = new String();
		for (String author : authors) {
			result += author + ", ";
		}
		return result;
	}
	
	public String getDetail() {
		String result = "\tBook - ";
		result += "ID: " + getId() + " - ";
		result += getTitle() + " - ";
		result += "by " + getAuthorsString() + " - ";
		result += getCost() + "$";
		return result;
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	

}
