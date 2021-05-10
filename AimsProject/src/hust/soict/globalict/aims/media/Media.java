package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

abstract public class Media implements Comparable<Media> {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost);
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator.comparing(Media::getCost).thenComparing(Media::getTitle);
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
	
	public String[] getDataArray() {
		String[] data = new String[5];
		data[0] = id + "";
		data[1] = title;
		data[2] = category;
		data[3] = cost + "";
		data[4] = dateAdded + "";
		return data;
	}
	
	// Override methods
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media downcastedObj = (Media) obj;
			return this.id == downcastedObj.getId();
		}
		return false;
	}
	
	@Override
	public String toString() {
		String detail = "";
		detail += "ID: " + getId() + " - ";
		detail += getTitle() + " - ";
		detail += getCost() + " - ";
		detail += getCost() + "$";
		return detail;
	}
	
	// Others
	
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
	
	// Implement Comparable
	@Override
	public int compareTo(Media o) {
		int compareTitleResult = title.compareTo(o.getTitle());
		if (compareTitleResult == 0) {
			return category.compareTo(o.getCategory());
		}
		return compareTitleResult;
	}
}
