package hust.soict.globalict.aims.media.disc.cd;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.disc.Disc;

public class CompactDisc extends Disc{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	// Update
	
	public void addTrack(Track newTrack) {
		for (Track track : tracks) {
			if (track.getTitle().equals(newTrack.getTitle())) {
				System.err.println("The track is already in the CD. Add a new one");
				return;
			}
		}
		tracks.add(newTrack);
		System.err.println("Added new track to CD");
	}
	
	public void removeTrack(Track delTrack) {
		int i = 0;
		for (Track track : tracks) {
			if (track.getTitle().equals(delTrack.getTitle())) {
				tracks.remove(i);
				System.err.println("Removed track from CD");
				return;
			}
			i++;
		}
		System.out.println("Cannot found");
	}
	
	// Calculate
	public int totalLengthOfTracks() {
		int total = 0;
		for (Track track : tracks) {
			total += track.getLength();
		}
		return total;
	}
	
	// init

	public CompactDisc(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, director, 0);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	

	public int getLength() {
		return totalLengthOfTracks();
	}
	
	
}
