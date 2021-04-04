package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	
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
		System.out.print(getDateAdded() + " - ");
		System.out.print(getId() + " - ");
		System.out.print(getNumMediaCreated());
		System.out.println();
	}
	
	// Others
	public void copyContentOf(DigitalVideoDisc dvd) {
		super.setTitle(dvd.getTitle());
		super.setCategory(dvd.getCategory());
		this.director = dvd.getDirector();
		this.length = dvd.getLength();
		super.setCost(dvd.getCost());
		super.setId(dvd.getId());
		super.setDateAdded(dvd.getDateAdded());
	}
	
	// init
	public DigitalVideoDisc(String title) {
		super();
		super.setTitle(title);
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

	// Getter
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}

	public String getDetail() {
		String result = "\tDVD - ";
		result += "ID: " + getId() + " - ";
		result += getTitle() + " - ";
		result += "by " + director + " - ";
		result += getCost() + "$";
		return result;
	}
	
	public String getShortDetail() {
		String shortDetail = new String();
		shortDetail += getId() + " - ";
		shortDetail += getTitle() + " by ";
		shortDetail += director;
		return shortDetail;
	}

	
}
