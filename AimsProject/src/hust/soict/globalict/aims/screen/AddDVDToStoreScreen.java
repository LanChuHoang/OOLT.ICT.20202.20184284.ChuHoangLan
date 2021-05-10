package hust.soict.globalict.aims.screen;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
	private JLabel directorLabel;
	private JTextField diretorTextField;
	private JLabel lengthLabel;
	private JTextField lengthTextField;

	public void createFields() {
		// TODO Auto-generated method stub
		super.createFields();
		getDesctiptionLabel().setText("CD Detail");
		
		directorLabel = new JLabel("Director");
 		diretorTextField = new JTextField(15);
		getFields().add(new JComponent[]{directorLabel, diretorTextField});
		
		lengthLabel = new JLabel("Length");
 		lengthTextField = new JTextField(15);
		getFields().add(new JComponent[]{lengthLabel, lengthTextField});
		
	}
	
	@Override
	public void addNewItemToStore() {
		// TODO Auto-generated method stub
		super.addNewItemToStore();
		String title = getTitleTextField().getText();
		String category = getCategoryTextField().getText();
		Float cost = Float.parseFloat(getCostTextField().getText());
		String director = diretorTextField.getText();
		int length = Integer.parseInt(lengthTextField.getText());
		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
		getStore().addMedia(dvd);
		
		DefaultTableModel model = (DefaultTableModel)getTable().getModel();
		model.addRow(dvd.getDataArray());
	}
	
	public AddDVDToStoreScreen(Store store, Cart cart, JFrame mainFrame) {
		super(store, cart, mainFrame);
		// TODO Auto-generated constructor stub
	}

}
