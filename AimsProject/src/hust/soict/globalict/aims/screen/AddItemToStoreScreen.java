package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;


public class AddItemToStoreScreen extends JPanel{
	private JFrame rootPane;
	private Store store;
	private Cart cart;
	
	private JButton addButton;
	private JButton cancelButton;
	private JLabel largeTitle;
	
	private JLabel titleLabel;
	private JTextField titleTextField;
	private JLabel categoryLabel;
	private JTextField categoryTextField;
	private JLabel costLabel;
	private JTextField costTextField;
	private JLabel desctiptionLabel;
	
	private JScrollPane scrollPane;
	private JTable table;
	
	ArrayList<JComponent[]> fields = new ArrayList<>();
	
	// GUI
	
	// FIELD PANEL - INPUT DATA FORM
	public void addFieldToPanel(JPanel panel) {
		GridBagConstraints contrains = new GridBagConstraints();
		// Alignment left to right
		contrains.anchor = GridBagConstraints.LINE_START;
	    contrains.fill = GridBagConstraints.HORIZONTAL;
	    
	    // Add empty space sides left + right
	    contrains.gridx = 0;
	    contrains.gridy = 0;
	    contrains.weightx = 0.2; 
	    contrains.weighty = 0;
	    panel.add(new JLabel(), contrains);
	    contrains.gridx = 3;
	    panel.add(new JLabel(), contrains);
	    for(int row = 0; row < fields.size(); ++row) {
		    for(int col = 1; col <= 2; ++col) {
		    	contrains.gridx = col;
		    	contrains.gridy = row;
		    	// Percent to receive extra space Horizontal
		    	contrains.weightx = 1.0; 
		    	// Percent to receive extra space Vertical
			    contrains.weighty = 0;
				panel.add(fields.get(row)[col-1], contrains);
		    }
	    }
	    // Add empty space sides bottom
	    contrains.gridx = 0;
	    contrains.gridy = fields.size();
	    contrains.weightx = 0; 
	    contrains.weighty = 1;
	    panel.add(new JLabel(), contrains);
	}
	
	public void createFields() {
		largeTitle = new JLabel("Add Item");
		largeTitle.setFont(new Font(largeTitle.getFont().getName(), Font.BOLD, 20));
		fields.add(new JComponent[]{largeTitle, new JLabel()});

		titleLabel = new JLabel("Title");
		titleTextField = new JTextField(15);
		fields.add(new JComponent[]{titleLabel, titleTextField});
		
		categoryLabel = new JLabel("Category");
		categoryTextField = new JTextField(15);
		fields.add(new JComponent[]{categoryLabel, categoryTextField});
	
		costLabel = new JLabel("Cost");
		costTextField = new JTextField(15);
		fields.add(new JComponent[]{costLabel, costTextField});
		
//		// Separator
//		JLabel separator = new JLabel("");
//		separator.setSize(new Dimension(20,20));
//		fields.add(new JComponent[]{separator, new JLabel()});
		
		// Description
		desctiptionLabel = new JLabel();
		desctiptionLabel.setFont(new Font(desctiptionLabel.getFont().getName(), Font.ITALIC, 15));
		desctiptionLabel.setForeground(Color.GRAY);
		fields.add(new JComponent[]{desctiptionLabel, new JLabel()});
		
		
	}
	
		// Field Panel - Add Item
	public JPanel createFieldPanel() {
		JPanel fieldPanel = new JPanel(new GridBagLayout());
//		fieldPanel.setBackground(Color.green);
		
		createFields();
		addFieldToPanel(fieldPanel);
		return fieldPanel;
	}
			
	// LEFT PANEL - FIELD PANEL + 2 BUTTON BELOW
	public JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel(new BorderLayout());
		
		// Field Panel to Enter input item
		JPanel fieldPanel = createFieldPanel();
		
		// Button Panel to hold buttons
		ButtonListener listener = new ButtonListener();
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(Color.gray);
		addButton = new JButton("Add");
		addButton.setPreferredSize(new Dimension(100, 40));
		addButton.addActionListener(listener);
		cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(100, 40));
		cancelButton.addActionListener(listener);
		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

		leftPanel.add(fieldPanel, BorderLayout.CENTER);
		leftPanel.add(buttonPanel, BorderLayout.SOUTH);
		return leftPanel;
	}
	
	// RIGHT PANEL - DISPLAY DATA USING JTABLE
	public JPanel createRightPanel() {
		JPanel rightPanel = new JPanel();
		if (store.isEmpty()) {
			rightPanel.setLayout(new GridBagLayout());
			JLabel emptyNoti = new JLabel("The store is empty");
			emptyNoti.setFont(new Font(emptyNoti.getFont().getName(), Font.BOLD, 15));
			rightPanel.add(emptyNoti);
		} else {
			ArrayList<Media> items = store.getItemsInStore();
			String[] columns = new String[] {"ID", "Title", "Category", "Cost", "Date Added"};
			String[][] data = new String[items.size()][columns.length];
			
			for(int i = 0; i < items.size(); ++i) {
				Media item = items.get(i);
				data[i] = item.getDataArray();
			}
			
			table = new JTable(new DefaultTableModel(data, columns));
			table.setPreferredScrollableViewportSize(new Dimension(500, 200));
			table.setFillsViewportHeight(true);
			
			rightPanel.add(table);
			
			scrollPane = new JScrollPane(table);
			rightPanel.add(scrollPane);
		}
		return rightPanel;
	}
	
	// CENTER PANEL - MAIN PANEL
	public JPanel createCenterPanel() {
		JPanel mainPanel = new JPanel(new GridLayout(1,1,2,4));
		mainPanel.add(createLeftPanel());
		mainPanel.add(createRightPanel());
		return mainPanel;
	}

	// ACTION
	
	// Add new item to store
	public void addNewItemToStore() {
		
	}
	
	// Action listener - Handle add button pressed
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String sourceName = e.getActionCommand();
			if (sourceName.equals(addButton.getText())) {
				// Check empty
				for (JComponent[] field : fields) {
					if (field[1] instanceof JTextField) {
						String inputText = ((JTextField) field[1]).getText();
						if(inputText == null || inputText.equals("")) {
							JOptionPane.showMessageDialog(rootPane, "Please enter all data !");;
							return;
						}
					}
				}
				
				// Add new item to store
				addNewItemToStore();
				
				// Show the message 
				JOptionPane.showMessageDialog(rootPane, "Added new item to store!");
			} else if(sourceName.equals(cancelButton.getText())) {
				for (JComponent[] field : fields) {
					if (field[1] instanceof JTextField) {
						JTextField textField = (JTextField) field[1];
						textField.setText("");
					}
				}
			}
		}
	}
	
	// Init
	public AddItemToStoreScreen(Store store, Cart cart, JFrame mainFrame) {
		this.store = store;
		this.cart = cart;
		this.rootPane = mainFrame;
		
		setLayout(new GridLayout(1,1,2,4));
		add(createLeftPanel());
		add(createRightPanel());
	}
	
	//
	//
	// Getter & Setter
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JLabel getLargeTitle() {
		return largeTitle;
	}

	public void setLargeTitle(JLabel largeTitle) {
		this.largeTitle = largeTitle;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JTextField getTitleTextField() {
		return titleTextField;
	}

	public void setTitleTextField(JTextField titleTextField) {
		this.titleTextField = titleTextField;
	}

	public JLabel getCategoryLabel() {
		return categoryLabel;
	}

	public void setCategoryLabel(JLabel categoryLabel) {
		this.categoryLabel = categoryLabel;
	}

	public JTextField getCategoryTextField() {
		return categoryTextField;
	}

	public void setCategoryTextField(JTextField categoryTextField) {
		this.categoryTextField = categoryTextField;
	}

	public JLabel getCostLabel() {
		return costLabel;
	}

	public void setCostLabel(JLabel costLabel) {
		this.costLabel = costLabel;
	}

	public JTextField getCostTextField() {
		return costTextField;
	}

	public void setCostTextField(JTextField costTextField) {
		this.costTextField = costTextField;
	}

	public ArrayList<JComponent[]> getFields() {
		return fields;
	}

	public void setFields(ArrayList<JComponent[]> fields) {
		this.fields = fields;
	}
	
	public JFrame getJFrameRootPane() {
		return rootPane;
	}

	public void setRootPane(JFrame rootPane) {
		this.rootPane = rootPane;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public JLabel getDesctiptionLabel() {
		return desctiptionLabel;
	}

	public void setDesctiptionLabel(JLabel desctiption) {
		this.desctiptionLabel = desctiption;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	
}
