package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;

public class MediaItemPanel extends JPanel{
	private static Cart cart;
	private Media media;
	
	public MediaItemPanel(Media inputMedia, Cart cart) {
		this.media = inputMedia;
		this.cart = cart;
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
		addToCartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				dialog.setLayout(new GridBagLayout());
				JLabel label = new JLabel();
				if (cart.isFull()) {
					label.setText("Your cart is full");
				} else if (cart.getItemsOrdered().contains(media)) {
					label.setText("The item is already in your cart");
				} else {
					label.setText("The media " + media.getTitle() + " has been added to your cart !");
					cart.addMedia(media);
				}
				dialog.add(label);
				dialog.setSize(new Dimension(300, 200));
				dialog.setVisible(true);
			}
		});
		
		// Add the button to the panel with FlowLayout
		JPanel choicePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		choicePanel.add(addToCartButton);
		if (media instanceof Playable) {
			// Play button
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					((Playable) media).play();
				}
			});
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
