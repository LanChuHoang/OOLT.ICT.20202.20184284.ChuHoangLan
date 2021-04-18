package hust.soict.globalict.aims.media.disc.cd;

import java.util.ArrayList;

import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.disc.Disc;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	// init
	public CompactDisc(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, director, 0);
		this.artist = artist;
	}
	
	// Getter & Setter
	public String getArtist() {
		return artist;
	}
	
	// Overriding methods
	@Override
	public String toString() {
		String head = "\tCD - ";
		String tail = " - artist: " + artist;
		return head + super.toString() + tail;
	}
	
	// Update
	public void addTrack(Track...newTracks) {
		for (Track newTrack : newTracks) {
			if (newTrack != null) {
				if (tracks.contains(newTrack)) {
					System.err.println("The track " + newTrack.getTitle() + " is already in the CD. Add a new one");
				} else {
					tracks.add(newTrack);
					super.setLength(super.getLength() + newTrack.getLength());
					System.err.println("Added track " + newTrack.getTitle() +" to the CD");
				}
			} else {
				System.err.println("The new track is null");
			}
		}		
	}
	
	public void removeTrack(String title, int length) {
		int i = 0;
		for (Track track : tracks) {
			if (track.getTitle().equals(title) && track.getLength() == length) {
				tracks.remove(i);
				System.err.println("Removed track " + title + " from the CD");
				return;
			}
			i++;
		}
		System.out.println("Cannot found");
		
//		for (Track delTrack : delTracks) {
//			int index = tracks.indexOf(delTrack);
//			if (index == -1) {
//				System.out.println("Cannout found " + delTrack.getTitle());
//			} else {
//				super.setLength(super.getLength() - delTrack.getLength());
//				tracks.remove(index);
//				System.err.println("Removed track " + delTrack.getTitle() + " from the CD");
//			}
//		}
	}
	
	// Checking
	
	// Implement Playable
	@Override
	public void play() {
		System.out.println("Playing CD: " + getTitle());
		System.out.println("CD length: " + getLength());
		for(Track track : tracks) {
			track.play();
		}
	}
	
	
}
