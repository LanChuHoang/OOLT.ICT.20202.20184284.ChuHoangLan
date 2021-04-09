package hust.soict.globalict.aims.media.disc;

import hust.soict.globalict.aims.media.Media;

public class Disc extends Media {
	private String director;
	private int length;
	
	
	
	// init
	public Disc(String title, String category, float cost, String director, int length) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	// Getter
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
	
	

}
