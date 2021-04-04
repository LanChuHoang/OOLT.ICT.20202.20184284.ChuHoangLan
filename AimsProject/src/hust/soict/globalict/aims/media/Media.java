package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {
	public static int numMediaCreated = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	// Init
	public Media() {
		dateAdded = LocalDate.now();
		id = numMediaCreated;
		numMediaCreated++;
	}
	
	public Media(String title, String category, float cost) {
		this();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	// Checking
	public boolean titleContains(String words) {
		if (words == null || title == null) {
			return false;
		}
		// Convert 2 strings to lower case
		words = words.toLowerCase();
		String lowercaseTitle = title.toLowerCase();
	
		// Split the input tokens to an array of tokens
		String[] tokens = words.split(" ");
		
		// Check the tokens one by one
		for (String token : tokens) {
			if (lowercaseTitle.contains(token)) {
				return true;
			}
		}
		return false;	
	}
	
	
	
	// Getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public static int getNumMediaCreated() {
		return numMediaCreated;
	}
	
	

}
