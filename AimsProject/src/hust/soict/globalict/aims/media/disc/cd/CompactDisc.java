package hust.soict.globalict.aims.media.disc.cd;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.disc.Disc;

public class CompactDisc extends Disc{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	// Update
	public void addTrack(Track...newTracks) {
		for (Track newTrack : newTracks) {
			if (newTrack != null) {
				if (contains(newTrack)) {
					System.err.println("The track " + newTrack.getTitle() + " is already in the CD. Add a new one");
				} else {
					tracks.add(newTrack);
					super.setLength(super.getLength() + newTrack.getLength());
					System.err.println("Added track" + newTrack.getTitle() +" to the CD");
				}
			} else {
				System.err.println("The new track is null");
			}
		}		
	}
	
	public void removeTrack(String title) {
		int i = 0;
		for (Track track : tracks) {
			if (track.getTitle().equals(title)) {
				super.setLength(super.getLength() - track.getLength());
				tracks.remove(i);
				System.err.println("Removed the track " + title + " from the CD");
				return;
			}
			i++;
		}
		System.out.println("Cannot found");
	}
	
	// Checking
	public boolean contains(Track input) {
		for (Track track : tracks) {
			if (track.getTitle().equals(input.getTitle())) {
				return true;
			}
		}
		return false;
	}
	
	// init

	public CompactDisc(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, director, 0);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public String getDetail() {
		String detail = super.getDetail();
		String header = "\tCD - ";
		String tail = " - artist: " + artist;
		return header + detail + tail;
	}
	
	
}
