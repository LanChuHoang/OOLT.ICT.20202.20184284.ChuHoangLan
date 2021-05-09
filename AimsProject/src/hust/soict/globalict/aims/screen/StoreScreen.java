package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	
	JMenuBar createStoreMenuBar() {
		JMenu optionMenu = new JMenu("Options");
		
		// Options of the "Options" menu
		JMenu updateMenu = new JMenu("Update Store");
		updateMenu.add(new JMenuItem("Add Book"));
		updateMenu.add(new JMenuItem("Add CD"));
		updateMenu.add(new JMenuItem("Add DVD"));
		
		optionMenu.add(updateMenu);	
		optionMenu.add(new JMenuItem("View store"));
		optionMenu.add(new JMenuItem("View cart"));
		
		JMenuBar storeMenuBar = new JMenuBar();
		storeMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		storeMenuBar.add(optionMenu);
		return storeMenuBar;
	}
	
	JPanel createHeaderPanel() {
		// Title label
		JLabel titleLabel = new JLabel("AIMS");
		titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
		titleLabel.setForeground(new Color(240, 165, 0));
		
		// Left Button
		JButton viewCartButton = new JButton("View Cart");
		viewCartButton.setPreferredSize(new Dimension(100, 50));
		viewCartButton.setMaximumSize(new Dimension(100, 50));
		
		// Horizontal stack
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
		
		// Alignment left 10px, right 10px
		headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		headerPanel.add(titleLabel);
		headerPanel.add(Box.createHorizontalGlue());
		headerPanel.add(viewCartButton);
		headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return headerPanel;
	}
	
	// Display Options menu bar + Header panel
	JPanel createNorthPanel() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createStoreMenuBar());
		north.add(createHeaderPanel());
		return north;
	}
	
	// Display Media in store with grid style
	JPanel createCenterPanel() {
		JPanel mediaPanel = new JPanel();
		if (store.isEmpty()) {
			JLabel storeEmptyLabel = new JLabel("The store is empty");
			storeEmptyLabel.setFont(new Font(storeEmptyLabel.getFont().getName(), Font.PLAIN, 20));
			mediaPanel.setLayout(new GridBagLayout());
			mediaPanel.add(storeEmptyLabel);
			
		} else {
			ArrayList<Media> mediaInStore = store.getItemsInStore();
			int numRow = mediaInStore.size() / 2;
			int numColumn = numRow + 1;
			
			mediaPanel.setLayout(new GridLayout(numRow, numColumn, 2, 2));
			for(Media media : mediaInStore) {
				MediaItemPanel itemPanel = new MediaItemPanel(media);
				mediaPanel.add(itemPanel);
			}
			
			
		}
		return mediaPanel;
	}
	
	public StoreScreen(Store store) {
		this.store = store;
		JPanel northPanel = createNorthPanel();
		JPanel centerPanel = createCenterPanel();
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setVisible(true);
	}
	
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
