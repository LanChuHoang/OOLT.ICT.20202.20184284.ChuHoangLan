package hust.soict.globalict.test.Book;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.cd.CompactDisc;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;

public class BookTest {

	public static void initDataTest(ArrayList<Book> books) {
		Book book1 = new Book("Harry Potter1", "Fantasy2", 11.5f, "Author 5", "Author 6");
		book1.addContents("a a a la la ha ha ha he he hu");
		books.add(book1);

	}
	
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		initDataTest(books);
		for (Book book : books) {
			System.out.println(book.getFullDetail());
		}
		
	}

}
