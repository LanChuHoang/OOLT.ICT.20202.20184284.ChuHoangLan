package hust.soict.globalict.aims.screen;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JPanel {
	private Store store;
	private Cart cart;
	
	// Display Media in store with grid style
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		if (store.isEmpty()) {
			JLabel storeEmptyLabel = new JLabel("The store is empty");
			storeEmptyLabel.setFont(new Font(storeEmptyLabel.getFont().getName(), Font.PLAIN, 20));
			setLayout(new GridBagLayout());
			add(storeEmptyLabel);
			
		} else {
			ArrayList<Media> mediaInStore = store.getItemsInStore();
			int numRow = mediaInStore.size() / 2;
			int numColumn = numRow + 1;
			
			setLayout(new GridLayout(numRow, numColumn, 2, 2));
			for(Media media : mediaInStore) {
				MediaItemPanel itemPanel = new MediaItemPanel(media);
				add(itemPanel);
			}
			
			
		}
		
	}
	
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
