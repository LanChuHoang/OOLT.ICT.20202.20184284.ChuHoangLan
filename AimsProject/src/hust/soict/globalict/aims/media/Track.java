package hust.soict.globalict.aims.media;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JDialog;

import hust.soict.globalict.aims.exception.PlayerException;
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
	public void play() throws PlayerException{
//		JDialog trackPlay = new JDialog();
		if (this.getLength() > 0) {
			JDialog dialog = new JDialog();
			dialog.setTitle("Play Track");
			dialog.setLayout(new GridBagLayout());
			GridBagConstraints contraints = new GridBagConstraints();
			contraints.insets = new Insets(0, 30, 0, 0);
			contraints.anchor = GridBagConstraints.LINE_START;
			
			contraints.gridx = 0;contraints.gridy = 0;dialog.add(new Label("Playing"), contraints);
			contraints.gridx = 1;contraints.gridy = 0;dialog.add(new Label("\""+getTitle()+"\""), contraints);
			contraints.gridx = 0;contraints.gridy = 1;dialog.add(new Label("Length "), contraints);
			contraints.gridx = 1;contraints.gridy = 1;dialog.add(new Label(getLength()+""), contraints);
			dialog.setBounds(500, 300, 300, 150);
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		} else {
			throw new PlayerException("ERROR: Track "+ getTitle() +" has a non-positive length!");
		}
		
	}

}
