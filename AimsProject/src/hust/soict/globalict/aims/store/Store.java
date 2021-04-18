package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	// Update
	public void addMedia(Media...newMediaList) {
		for (Media newMedia : newMediaList) {
			if (newMedia != null) {
				if (contains(newMedia)) {
					System.out.println("The media " + newMedia.getTitle() + " is already in the store. Add a new one");
				} else {
					itemsInStore.add(newMedia);
					System.out.println("Added " + newMedia.getTitle() + " to the Store");
				}
			} else {
				System.out.println("The new media is null");
			}
		}
	
	}
	
	public void removeMedia(int id) {
		for (Media item : itemsInStore) {
			if(item.getId() == id) {
				itemsInStore.remove(item);
				System.out.println("Removed " + id + " from the Store");
				return;
			}
		}
		System.out.println("\tCannot Found");
	}

	// Display
	public void printStore() {
		if (itemsInStore.isEmpty()) {
			System.out.println("\tThe Store is empty");
		} else {
			int i = 0;
			for(Media item : itemsInStore) {
				System.out.println("\t" + (i+1) + ". " + item.toString());
				i++;
			}
		}
	}	
		
	// Checking
	public boolean isEmpty() {
		return itemsInStore.size() == 0;
	}
	
	public boolean contains(Media input) {
		for (Media item : itemsInStore) {
			if (item.getClass() == input.getClass() && item.getTitle().equals(input.getTitle())) {
				return true;
			}
		}
		return false;
	}
	
	// Searching 
	public Media searchByID(int id) {
		for(Media item : itemsInStore) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	
	//
	//
	
	
	
	
}
