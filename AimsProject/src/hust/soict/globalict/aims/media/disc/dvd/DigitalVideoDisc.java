package hust.soict.globalict.aims.media.disc.dvd;

import hust.soict.globalict.aims.media.disc.Disc;

public class DigitalVideoDisc extends Disc {
	
	// Display content
	public void printInfo() {
		if(getTitle() != null) {
			System.out.print(getTitle() + " - ");
		}
		if(getCategory() != null) {
			System.out.print(getCategory() + " - ");
		}
		if(getDirector() != null) {
			System.out.print(getDirector() + " - ");
		}
		System.out.print(getLength() + " - ");
		System.out.print(getCost() + " - ");
		System.out.print(getDateAdded() + " - ");
		System.out.print(getId() + " - ");
		System.out.print(getNumMediaCreated());
		System.out.println();
	}
	
	// Others
	public void copyContentOf(DigitalVideoDisc dvd) {
		/*
		super.setTitle(dvd.getTitle());
		super.setCategory(dvd.getCategory());
		this.director = dvd.getDirector();
		this.length = dvd.getLength();
		super.setCost(dvd.getCost())
		super.setId(dvd.getId());
		super.setDateAdded(dvd.getDateAdded());
		*/
	}
	
	// init
	public DigitalVideoDisc(String title) {
		super(title, null, 0.0f, null, 0);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost, null, 0);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost, director, 0);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, director, length);
	} 

	// Getter

	public String getDetail() {
		String result = "\tDVD - ";
		result += "ID: " + getId() + " - ";
		result += getTitle() + " - ";
		result += "by " + getDirector() + " - ";
		result += getCost() + "$";
		return result;
	}
	
	public String getShortDetail() {
		String shortDetail = new String();
		shortDetail += getId() + " - ";
		shortDetail += getTitle() + " by ";
		shortDetail += getDirector();
		return shortDetail;
	}

	
}
