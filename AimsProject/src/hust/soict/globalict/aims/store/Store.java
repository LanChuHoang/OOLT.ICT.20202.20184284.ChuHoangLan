package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	// Update
	public void addMedia(Media...newMediaList) {
		for (Media newMedia : newMediaList) {
			if (newMedia == null) {
				System.out.println("The new media is null");
			} else {
				itemsInStore.add(newMedia);
				System.out.println("Added " + newMedia.getTitle() + " to the Store");
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
				if (item instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc)item;
					System.out.println("\t" + (i+1) + ". " + dvd.getDetail());
				} else if (item instanceof Book) {
					Book book = (Book)item;
					System.out.println("\t"+ (i+1) + ". " + book.getDetail());
				} else {
					System.out.println("\tDowncasting error");
				}
				i++;
			}
		}
	}	
		
	// Checking
	public boolean isEmpty() {
		return itemsInStore.size() == 0;
	}
	
	public boolean contains(Media media) {
		String inputTitle = media.getTitle();
		if (media instanceof DigitalVideoDisc) {
			for (Media item : itemsInStore) {
				if (item instanceof DigitalVideoDisc && item.getTitle().equals(inputTitle)) {
					return true;
				}
			}
		} else if (media instanceof Book) {
			for (Media item : itemsInStore) {
				if (item instanceof Book && item.getTitle().equals(inputTitle)) {
					return true;
				}
			}
		} else {
			System.out.println("Downcasting error");
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
