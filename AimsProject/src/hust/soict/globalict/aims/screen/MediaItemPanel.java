package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;

public class MediaItemPanel extends JPanel{
	private Media media;
	
	public MediaItemPanel(Media media) {
		this.media = media;
		// Set this panel's layout to BoxLayout -> make it become a vertical stack
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Title label
		JLabel titleLabel = new JLabel(media.getTitle());
		titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		titleLabel.setAlignmentY(CENTER_ALIGNMENT);
		
		// Cost label
		JLabel costLabel = new JLabel(media.getCost()+"");
		costLabel.setAlignmentX(CENTER_ALIGNMENT);
		costLabel.setAlignmentY(CENTER_ALIGNMENT);
		
		// Add to cart button
		JButton addToCartButton = new JButton("Add to cart");
		
		// Add the button to the panel with FlowLayout
		JPanel choicePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		choicePanel.add(addToCartButton);
		if (media instanceof Playable) {
			// Play button
			JButton playButton = new JButton("Play");
			choicePanel.add(playButton);
		}
		
		// Add these components to the MediaItemPanel
		
		this.add(Box.createVerticalGlue());
		this.add(titleLabel);
		this.add(costLabel);
		this.add(Box.createVerticalGlue());
		this.add(choicePanel);
		
		this.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
	}
}
