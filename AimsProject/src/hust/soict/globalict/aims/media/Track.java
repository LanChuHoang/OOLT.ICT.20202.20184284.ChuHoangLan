package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.interfaces.Playable;

public class Track implements Playable{
	private String title;
	private int length;

	// Init
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	// Getter & Setter
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
	
	// Override Methods
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track downcastedObj = (Track) obj;
			return (this.title.equals(downcastedObj.getTitle())) && (this.length == downcastedObj.getLength());
		}
		return false;
	}
	
	// Others
	@Override
	public void play() {
//		JDialog trackPlay = new JDialog();
		
		System.out.println("Playing Track: " + getTitle());
		System.out.println("Track length: " + getLength());
		
	}

}
