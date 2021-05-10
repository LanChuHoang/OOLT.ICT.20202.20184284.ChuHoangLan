package hust.soict.globalict.aims.screen;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	
	private JLabel authorLabel;
	private JTextField authorTextField;
	
	@Override
	public void createFields() {
		// TODO Auto-generated method stub
		super.createFields();
		getDesctiptionLabel().setText("Book Detail");
		
		authorLabel = new JLabel("Author");
 		authorTextField = new JTextField(15);
		getFields().add(new JComponent[]{authorLabel, authorTextField});
		
	}
	
	@Override
	public void addNewItemToStore() {
		// TODO Auto-generated method stub
		super.addNewItemToStore();
		String title = getTitleTextField().getText();
		String category = getCategoryTextField().getText();
		Float cost = Float.parseFloat(getCostTextField().getText());
		String author = authorTextField.getText();
		Book book = new Book(title, category, cost, author);
		getStore().addMedia(book);
		
		DefaultTableModel model = (DefaultTableModel)getTable().getModel();
		model.addRow(book.getDataArray());
	}
	
 	public AddBookToStoreScreen(Store store, Cart cart, JFrame mainFrame) {
		super(store, cart, mainFrame);
		// TODO Auto-generated constructor stub
	}
	
}
