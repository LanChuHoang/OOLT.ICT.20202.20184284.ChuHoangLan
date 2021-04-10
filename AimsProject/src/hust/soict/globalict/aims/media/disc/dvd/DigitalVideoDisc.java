package hust.soict.globalict.aims.media.disc.dvd;

import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.disc.Disc;

public class DigitalVideoDisc extends Disc implements Playable{
	
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
		String detail = super.getDetail();
		String header = "\tDVD - ";
		return header + detail;
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + getTitle());
		System.out.println("DVD length: " + getLength());
	}

	
}
