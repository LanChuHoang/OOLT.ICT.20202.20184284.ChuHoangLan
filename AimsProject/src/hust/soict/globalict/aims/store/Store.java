package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	// Update
	public void addMedia(Media...newMediaList) throws NullPointerException, IllegalArgumentException {
		for (Media newMedia : newMediaList) {
			if (newMedia == null) {
				throw new NullPointerException("The input media is null");
			} else if (itemsInStore.contains(newMedia)) {
				throw new IllegalArgumentException("The media " + newMedia.getTitle() + " is already in the Store");
			} else {
				itemsInStore.add(newMedia);
				System.out.println("Added " + newMedia.getTitle() + " to the Store");
			}
		}
	
	}
	
	public void removeMedia(int id) throws IllegalArgumentException{
		for (Media item : itemsInStore) {
			if(item.getId() == id) {
				itemsInStore.remove(item);
				System.out.println("Removed " + id + " from the Store");
				return;
			}
		}
		throw new IllegalArgumentException("The media " + id + " is not in the Store");
	}
	
	public void removeMedia(Media media) throws NullPointerException, IllegalArgumentException {
		if (media == null) {
			throw new NullPointerException("The input media is null");
		} else if (!itemsInStore.contains(media)){
			throw new IllegalArgumentException("The media " + media.getTitle() + " is not in the Store");
		} else {
			itemsInStore.remove(media);
			System.out.println("Removed " + media.getTitle() + " from the Store");
		}
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
	
	
	// Getter & Setter 
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
}
