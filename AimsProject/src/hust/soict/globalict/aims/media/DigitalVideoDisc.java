package hust.soict.globalict.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private LocalDate dateAdded;
	private String title;
	private static int numDVDCreated = 0; // nbDigitalVideoDiscs
	
	// Getter
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public String getDetail() {
		String result = "DVD\t";
		result += getTitle() + " - ";
		result += getCategory() + " - ";
		result += director + " - ";
		result += length + ": " + " - ";
		result += getCost() + "$";
		result += " / ";
		result += dateAdded + " - ";
		result += "ID: " + getId() + " - ";
		result += numDVDCreated;
		return result;
	}
	public String getShortDetail() {
		String shortDetail = new String();
		shortDetail += getId() + " - ";
		shortDetail += getTitle() + " by ";
		shortDetail += director;
		return shortDetail;
	}
	
	// Display content
	public void printInfo() {
		if(getTitle() != null) {
			System.out.print(getTitle() + " - ");
		}
		if(getCategory() != null) {
			System.out.print(getCategory() + " - ");
		}
		if(director != null) {
			System.out.print(director + " - ");
		}
		System.out.print(length + " - ");
		System.out.print(getCost() + " - ");
		System.out.print(dateAdded + " - ");
		System.out.print(getId() + " - ");
		System.out.print(numDVDCreated);
		System.out.println();
	}
	
	// init
	public DigitalVideoDisc(String title) {
		super();
		super.setTitle(title);
		this.dateAdded = LocalDate.now();
		numDVDCreated++;
		super.setId(numDVDCreated);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title);
		super.setCategory(category);
		super.setCost(cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title, category, cost);
		this.director = director;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this(title, category, director, cost);
		this.length = length;
	} 
	
	// Others
	public void copyContentOf(DigitalVideoDisc dvd) {
		super.setTitle(dvd.getTitle());
		super.setCategory(dvd.getCategory());
		this.director = dvd.getDirector();
		this.length = dvd.getLength();
		super.setCost(dvd.getCost());
	}
	
	// Checking
	public boolean titleContains(String words) {
		if (words == null || this.title == null) {
			return false;
		}
		// Convert 2 strings to lower case
		words = words.toLowerCase();
		String dvdTitle = this.title.toLowerCase();
	
		// Split the input tokens to an array of tokens
		String[] tokens = words.split(" ");
		
		// Check the tokens one by one
		for (String token : tokens) {
			if (dvdTitle.contains(token)) {
				return true;
			}
		}
		return false;	
	}
	
	
	
}
