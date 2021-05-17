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
import hust.soict.globalict.aims.screen.cart.CartScreen;
import hust.soict.globalict.aims.store.Store;


public class MainFrame extends JFrame{
	private Store store;
	private Cart cart;
	private CartScreen cartWindow;
	private MainFrame storeWindow = this; 
	
	private StoreScreen storeScreen;
	private AddBookToStoreScreen addBookToStoreScreen;
	private AddCDToStoreScreen addCDToStoreScreen;
	private AddDVDToStoreScreen addDVDToStoreScreen;
	
	private JPanel navigationPanel;
	private JPanel contentPanel;
	
	// Init
	public MainFrame(Store store, Cart cart, Boolean visible) {
		this.store = store;
		this.cart = cart;
		
		navigationPanel = createNavigationPanel();
		storeScreen = new StoreScreen(store, cart);
		contentPanel = storeScreen;
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(navigationPanel, BorderLayout.NORTH);
		contentPane.add(contentPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setVisible(visible);
		
	}
	
	// Change screen
	public void changeScreen(String option) {
		JPanel screen = new JPanel();
		switch (option) {
		case "Add Book": {
			addBookToStoreScreen = new AddBookToStoreScreen(store, cart, MainFrame.this);
			screen = addBookToStoreScreen;
			break;
		}
		case "Add CD": {
			addCDToStoreScreen = new AddCDToStoreScreen(store, cart, MainFrame.this);
			screen = addCDToStoreScreen;
			break;			
		}
		case "Add DVD": {
			addDVDToStoreScreen = new AddDVDToStoreScreen(store, cart, MainFrame.this);
			screen = addDVDToStoreScreen;
			break;
		}
		case "View store": {
			storeScreen = new StoreScreen(store, cart);
			screen = storeScreen;
			break;
		}
		case "View cart": {
			storeWindow.setVisible(false);
			cartWindow.setVisible(true);
			return;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
		getContentPane().remove(contentPanel);
		contentPanel = screen;
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setVisible(false);
		setVisible(true);
	}
	
	// Navigation Bar
	
	// 1. Navigation Panel
		public JPanel createNavigationPanel() {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(createAddItemMenuBar());
			panel.add(createHeaderPanel());
			return panel;
		}
	
	// 1.1 Menu bar on top with Options menu
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
	
	// 1.1 ACTION: Menu Item Listener
	public class MenuItemListener implements ActionListener {	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String option = e.getActionCommand();
			changeScreen(option);
		}
	}
	
	// 1.2 Header panel with AIMS Title and View Cart Button
	public JPanel createHeaderPanel() {
		// Title label
		JLabel titleLabel = new JLabel("AIMS");
		titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
		titleLabel.setForeground(new Color(240, 165, 0));
		
		// Left Button
		JButton viewCartButton = new JButton("View Cart");
		viewCartButton.setPreferredSize(new Dimension(100, 50));
		viewCartButton.setMaximumSize(new Dimension(100, 50));
		viewCartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeScreen("View cart");
			}
		});
		
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
	
	
	
	
	// Getter & Setter
	public AddBookToStoreScreen getAddBookToStoreScreen() {
		return addBookToStoreScreen;
	}
	
	public void setCartWindow(CartScreen cartWindow) {
		this.cartWindow = cartWindow;
	}
}
