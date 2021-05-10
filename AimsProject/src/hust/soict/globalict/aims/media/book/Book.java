package hust.soict.globalict.aims.media.book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hust.soict.globalict.aims.media.Media;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

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
	
	// Getter & Setter
	public String getAuthorsString() {
		String result = new String();
		for (String author : authors) {
			result += author + ", ";
		}
		return result;
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	// Overriding methods 
	@Override
	public String toString() {
		String head = "\tBook - ";
		String tail = " by " + getAuthorsString();
		return head + super.toString() + tail;
	}
	
	// Others
	public void copyContentOf(Book book) {
		/*
		super.setTitle(book.getTitle());
		super.setCategory(book.getCategory());
		for(String author : book.authors) {
			String copyAuthor = author;
			authors.add(copyAuthor);
		}
		super.setCost(book.getCost());
		super.setId(book.getId());
		super.setDateAdded(book.getDateAdded());
		*/
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
	
	public void addContents(String newContent) {
		content = newContent;
		processContent();
	}
	
	private void processContent() {
		String[] tokens = content.split(" ");
		for(String token : tokens) {
			if (wordFrequency.containsKey(token)) {
				int count = wordFrequency.get(token);
				wordFrequency.put(token, count + 1);
			} else {
				wordFrequency.put(token, 1);
			}
		}
		for(Map.Entry<String, Integer> token : wordFrequency.entrySet()) {
			contentTokens.add(token.getKey());
		}
	}
	
	// Display
	public String getFullDetail() {
		String detail = toString();
		detail += "\n\tContent: " + content;
		detail += "\n\tNumber of words: " + contentTokens.size();
		for (Map.Entry<String, Integer> token : wordFrequency.entrySet()) {
			detail += "\n\t- " + token.getKey() + " - " + token.getValue();
		}
		return detail;
	}
}
