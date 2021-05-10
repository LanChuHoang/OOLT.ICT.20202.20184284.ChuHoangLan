package hust.soict.globalict.aims.media.disc.dvd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JDialog;

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

	// Overriding methods
	@Override
	public String toString() {
		String head = "\tDVD - ";
		return head + super.toString();
	}
	
	// Implement Playable
	@Override
	public void play() {
		JDialog playDVD = new JDialog();
		playDVD.setTitle("Play DVD");
		playDVD.setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		contraints.insets = new Insets(0, 30, 0, 0);
		contraints.anchor = GridBagConstraints.LINE_START;
		
		contraints.gridx = 0;contraints.gridy = 0;playDVD.add(new Label("Playing"), contraints);
		contraints.gridx = 1;contraints.gridy = 0;playDVD.add(new Label("\""+getTitle()+"\""), contraints);
		contraints.gridx = 0;contraints.gridy = 1;playDVD.add(new Label("Length "), contraints);
		contraints.gridx = 1;contraints.gridy = 1;playDVD.add(new Label(getLength()+""), contraints);
		playDVD.setBounds(500, 300, 300, 150);
		playDVD.setAlwaysOnTop(true);
		playDVD.setVisible(true);
	}

	
}
