package hust.soict.globalict.aims.media.disc.cd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JDialog;

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
		JDialog playCD = new JDialog();
		playCD.setTitle("Play CD");
		playCD.setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		contraints.insets = new Insets(0, 30, 0, 0);
		contraints.anchor = GridBagConstraints.LINE_START;
		
		contraints.gridx = 0;contraints.gridy = 0;playCD.add(new Label("Playing"), contraints);
		contraints.gridx = 1;contraints.gridy = 0;playCD.add(new Label("\""+getTitle()+"\""), contraints);
		contraints.gridx = 0;contraints.gridy = 1;playCD.add(new Label("Total length "), contraints);
		contraints.gridx = 1;contraints.gridy = 1;playCD.add(new Label(getLength()+""), contraints);
		
		if(!tracks.isEmpty()) {
			contraints.gridx = 0;contraints.gridy = 2;playCD.add(new Label("Tracks:"), contraints);
			int row = 3;
			for(Track track : tracks) {
				contraints.gridx = 0;contraints.gridy = row;playCD.add(new Label(" - \""+track.getTitle()+"\""), contraints);
				contraints.gridx = 1;contraints.gridy = row;playCD.add(new Label(track.getLength() + ""), contraints);
				row++;
			}
		}
		
		playCD.setBounds(500, 300, 300, 150);
		playCD.setAlwaysOnTop(true);
		playCD.setVisible(true);
	}
	
	
}
