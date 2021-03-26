package hust.soict.globalict.aims.disc;
import java.time.LocalDate;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private static int numDVDCreated = 0; // nbDigitalVideoDiscs
	private int id;
	
	// Getter
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDetail() {
		String result = "DVD\t";
		result += title + " - ";
		result += category + " - ";
		result += director + " - ";
		result += length + ": " + " - ";
		result += cost + "$";
		result += " / ";
		result += dateAdded + " - ";
		result += "ID: " + id + " - ";
		result += numDVDCreated;
		return result;
	}
	
	// Setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void copyContentOf(DigitalVideoDisc dvd) {
		this.title = dvd.getTitle();
		this.category = dvd.getCategory();
		this.director = dvd.getDirector();
		this.length = dvd.getLength();
		this.cost = dvd.getCost();
	}
	
	// Display content
	public void printInfo() {
		if(title != null) {
			System.out.print(title + " - ");
		}
		if(category != null) {
			System.out.print(category + " - ");
		}
		if(director != null) {
			System.out.print(director + " - ");
		}
		System.out.print(length + " - ");
		System.out.print(cost + " - ");
		System.out.print(dateAdded + " - ");
		System.out.print(id + " - ");
		System.out.print(numDVDCreated);
		System.out.println();
	}
	
	// init
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		numDVDCreated++;
		this.id = numDVDCreated;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		numDVDCreated++;
		this.id = numDVDCreated;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		numDVDCreated++;
		this.id = numDVDCreated;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		numDVDCreated++;
		this.id = numDVDCreated;
	} 
	
	
}
