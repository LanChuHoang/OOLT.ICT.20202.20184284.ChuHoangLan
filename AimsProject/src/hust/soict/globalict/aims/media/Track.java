package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.interfaces.Playable;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void play() {
		System.out.println("Playing Track: " + getTitle());
		System.out.println("Track length: " + getLength());
		
	}
	
	

}
