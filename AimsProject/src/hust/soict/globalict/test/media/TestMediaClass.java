package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.cd.CompactDisc;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;

public class TestMediaClass {
	
	public static void initDataTest(ArrayList<Media> arr) {
		Book book1 = new Book("Harry Potter1", "Fantasy2", 11.5f, "Author 5", "Author 6");
		Book book2 = new Book("Harry Potter1", "Fantasy1", 11.6f, "Author 3", "Author 4");
		Book book3 = new Book("Harry Potter3", "Fantasy", 11.7f, "Author 1", "Author 2");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		CompactDisc cd1 = new CompactDisc("Album1", "Ballad", 10.5f, "Chullee", "artist1");
		CompactDisc cd2 = new CompactDisc("Album2", "Ballad", 10.6f, "Chullee", "artist2");
		CompactDisc cd3 = new CompactDisc("Album3", "Ballad", 10.7f, "Chullee", "artist3");
		arr.add(book1);
		arr.add(book2);
		arr.add(book3);
		arr.add(dvd1);
		arr.add(dvd2);
		arr.add(dvd3);
		arr.add(cd1);
		arr.add(cd2);
		arr.add(cd3);
	}
	
	public static void printArr(ArrayList<Media> arr) {
		if (arr.isEmpty()) {
			System.out.println("Empty");
			return;
		}
		for(Media media : arr) {
			System.out.println(media.toString());
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Media> arr = new ArrayList<Media>();
		initDataTest(arr);
		Collections.sort(arr);
		printArr(arr);
		
	}

}
