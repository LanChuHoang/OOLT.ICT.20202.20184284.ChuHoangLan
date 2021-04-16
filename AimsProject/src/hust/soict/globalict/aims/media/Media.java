package hust.soict.globalict.aims.media;

import java.time.LocalDate;

abstract public class Media {
	public static int numMediaCreated = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media downcastedObj = (Media) obj;
			return this.id == downcastedObj.getId();
		}
		return false;
	}
	
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
	public static int getNumMediaCreated() {
		return numMediaCreated;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	abstract public String getDetail();

}
