package hust.soict.globalict.aims.screen;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.disc.cd.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
	
	private JLabel directorLabel;
	private JTextField diretorTextField;
	private JLabel artistLabel;
	private JTextField artistTextField;
	
	@Override
	public void createFields() {
		// TODO Auto-generated method stub
		super.createFields();
		getDesctiptionLabel().setText("CD Detail");
		
		directorLabel = new JLabel("Director");
 		diretorTextField = new JTextField(15);
		getFields().add(new JComponent[]{directorLabel, diretorTextField});
		
		artistLabel = new JLabel("Artist");
 		artistTextField = new JTextField(15);
		getFields().add(new JComponent[]{artistLabel, artistTextField});
		
	}
	
	@Override
	public void addNewItemToStore() {
		// TODO Auto-generated method stub
		super.addNewItemToStore();
		String title = getTitleTextField().getText();
		String category = getCategoryTextField().getText();
		Float cost = Float.parseFloat(getCostTextField().getText());
		String director = diretorTextField.getText();
		String artist = artistTextField.getText();
		CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
		getStore().addMedia(cd);
		
		DefaultTableModel model = (DefaultTableModel)getTable().getModel();
		model.addRow(cd.getDataArray());
	}
	
	public AddCDToStoreScreen(Store store, Cart cart, JFrame mainFrame) {
		super(store, cart, mainFrame);
		// TODO Auto-generated constructor stub
	}

}
