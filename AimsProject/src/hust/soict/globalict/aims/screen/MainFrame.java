package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;


public class MainFrame extends JFrame{
	private Store store;
	private Cart cart;
	
	private StoreScreen storeScreen;
	private AddBookToStoreScreen addBookToStoreScreen;
	private AddCDToStoreScreen addCDToStoreScreen;
	private AddDVDToStoreScreen addDVDToStoreScreen;
	
	private JPanel navigationPanel;
	private JPanel contentPanel;
	
	public MainFrame(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		storeScreen = new StoreScreen(store, cart);
		
		navigationPanel = createNavigationPanel();
		contentPanel = storeScreen;
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(navigationPanel, BorderLayout.NORTH);
		contentPane.add(contentPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setVisible(true);
		
	}
	
	// Change screen
	public void changeScreen(JPanel screen) {
		getContentPane().remove(contentPanel);
		contentPanel = screen;
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setVisible(false);
		setVisible(true);
	}
	
	// Menu bar on top with Options menu
	public JMenuBar createAddItemMenuBar() {
		JMenu optionMenu = new JMenu("Options");
		
		// Options of the "Options" menu
		MenuItemListener listener = new MenuItemListener();
		
		JMenu updateMenu = new JMenu("Update Store");
		JMenuItem addBookItem = new JMenuItem("Add Book");
		JMenuItem addCDItem = new JMenuItem("Add CD");
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
		addBookItem.addActionListener(listener);
		addCDItem.addActionListener(listener);
		addDVDItem.addActionListener(listener);
		updateMenu.add(addBookItem);
		updateMenu.add(addCDItem);
		updateMenu.add(addDVDItem);
		
		optionMenu.add(updateMenu);
		JMenuItem viewStoreItem = new JMenuItem("View store");
		JMenuItem viewCartItem = new JMenuItem("View cart");
		viewStoreItem.addActionListener(listener);
		viewCartItem.addActionListener(listener);
		optionMenu.add(viewStoreItem);
		optionMenu.add(viewCartItem);
		
		JMenuBar storeMenuBar = new JMenuBar();
		storeMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		storeMenuBar.add(optionMenu);
		return storeMenuBar;
	}
	
	// ACTION: Menu Item Listener
	public class MenuItemListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String option = e.getActionCommand();
			switch (option) {
				case "Add Book": {
					addBookToStoreScreen = new AddBookToStoreScreen(store, cart, MainFrame.this);
					changeScreen(addBookToStoreScreen);
					break;
				}
				case "Add CD": {
					addCDToStoreScreen = new AddCDToStoreScreen(store, cart, MainFrame.this);
					changeScreen(addCDToStoreScreen);
					break;			
				}
				case "Add DVD": {
					addDVDToStoreScreen= new AddDVDToStoreScreen(store, cart, MainFrame.this);
					changeScreen(addDVDToStoreScreen);
					break;
				}
				case "View store": {
					storeScreen = new StoreScreen(store, cart);
					changeScreen(storeScreen);
					break;
				}
				case "View cart": {
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
		}
	}
	
	// Header panel with AIMS Title and View Cart Button
	public JPanel createHeaderPanel() {
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
	
	// Navigation Panel
	public JPanel createNavigationPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(createAddItemMenuBar());
		panel.add(createHeaderPanel());
		return panel;
	}
}
