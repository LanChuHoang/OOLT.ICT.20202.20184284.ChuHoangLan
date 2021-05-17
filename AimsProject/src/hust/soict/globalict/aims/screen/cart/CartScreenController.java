package hust.soict.globalict.aims.screen.cart;


import java.util.function.Predicate;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.MainFrame;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class CartScreenController {
	private Store store;
	private Cart cart;
	private MainFrame storeWindow;
	private CartScreen cartWindow;
	// Filter bar
	@FXML
    private TextField filterTextField;

    @FXML
    private RadioButton idFilterButton;

    @FXML
    private RadioButton titleFilterButton;
	
	@FXML
    private ToggleGroup filterModes;
	
	// Table view
    @FXML
    private TableView<Media> cartTableView;

    @FXML
    private TableColumn<Media, Integer> idColumn;
    
    @FXML
    private TableColumn<Media, String> titleColumn;

    @FXML
    private TableColumn<Media, String> categoryColumn;

    @FXML
    private TableColumn<Media, Float> costColumn;
    
    // Left panel
    @FXML 
    private Label totalCostLabel;
    
    // Bottom bar 
  
    @FXML 
    private Button playButton;
    
    @FXML	
    private Button removeButton;
    
   
	
    // Init
	public CartScreenController(Store store, Cart cart, CartScreen cartWindow) {
		this.store = store;
		this.cart = cart;
		this.cartWindow = cartWindow;
	}
	
	// Perform post processing in content after it is loaded
	@FXML
	private void initialize() {
		// TABLE VIEW
		// Set the table the way to get data
		idColumn.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		
		// Create filter list to wrap the data list(initialize display all the data)
		FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), m -> true);
		
		// FILTER BAR
		filterTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// This method is triggered when the text in the text field is changed
				// Old value: old text before changing
				// New value: current text after changing
				showFilteredMedia(newValue, filteredList);
			}
			
		});
		
		cartTableView.setItems(filteredList);
		totalCostLabel.setText(cart.totalCost() + " $");
		
		// BOTTOM BAR
		// Config 2 buttons: playButton and removeButton
		playButton.setVisible(false);
		removeButton.setVisible(false);
		
		// Add the change listener to handle the event occurs when a row is selected
		cartTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observale, Media oldValue, Media newValue) {
				// This method is triggered when a row is selected
				// oldValue - old row that has been selected before
				// newValue - the current row that is selected by the user
				updateButtonBar(newValue);
			}
		});
		
	}
	
	public void updateButtonBar(Media media) {
		if (media == null) {
			removeButton.setVisible(false);
			playButton.setVisible(false);
		} else {
			removeButton.setVisible(true);
			Boolean isPlayable = (media instanceof Playable) ? true : false;
			playButton.setVisible(isPlayable); 
		}
	}
	
	public void showFilteredMedia(String text, FilteredList<Media> filteredList) {
		// Covert text local variable to a final variable to pass to the inner class
		final String key = new String(text);
		// Change the filteredList's predicate to trigger the filter
		filteredList.setPredicate(new Predicate<Media>() {
			// This method is triggered when compare each row to the key
			@Override
			public boolean test(Media currentItem) {
				if (key == null || key.isEmpty()) {
					return true;
				}
				if (idFilterButton.isSelected()) {
					return currentItem.idContains(key);
				}
				return currentItem.titleContains(key);
			}
			
		});
	}
	
	// Getter & Setter
	public void setStoreWindow(MainFrame storeWindow) {
		this.storeWindow = storeWindow;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	// Event handling
	// Menu Bar
	@FXML
    void addBookToStorePressed(ActionEvent event) {
		cartWindow.setVisible(false);
		storeWindow.setVisible(true);
		storeWindow.changeScreen("Add Book");
    }

    @FXML
    void addCDToStorePressed(ActionEvent event) {
    	cartWindow.setVisible(false);
		storeWindow.setVisible(true);
		storeWindow.changeScreen("Add CD");
    }

    @FXML
    void addDVDToStorePressed(ActionEvent event) {
    	cartWindow.setVisible(false);
		storeWindow.setVisible(true);
		storeWindow.changeScreen("Add DVD");
    }
	
	@FXML
    void viewStoreMenuPressed(ActionEvent event) {
		cartWindow.setVisible(false);
		storeWindow.setVisible(true);
		storeWindow.changeScreen("View store");
		
    }
	
	// Bottom Bar
	@FXML
	void playButtonPressed(ActionEvent event) {
		Media selectedItem = cartTableView.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			((Playable)selectedItem).play();
		}
	}
	
	@FXML
    void removeButtonPressed(ActionEvent event) {
		Media selectedItem = cartTableView.getSelectionModel().getSelectedItem();
		cart.removeMedia(selectedItem);
		totalCostLabel.setText(cart.totalCost() + " $");
    }
	
	// Right panel
	@FXML
    void getLuckyItemButtonPressed(ActionEvent event) {
		final Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Lucky Item");
		window.setMinWidth(600);
		window.setMinHeight(150);
		
		Label messageLabel = new Label();
		Media luckyItem = cart.getLuckyItem();
		if (cart.getItemsOrdered().isEmpty()) {
			messageLabel.setText("Your cart is empty !");
		} else {
			messageLabel.setText("Congratulation, your lucky item is " + luckyItem.getTitle() + " - " + luckyItem.getCost() + " $ !");
			totalCostLabel.setText(cart.totalCost() + " $");
		}
		messageLabel.setFont(new Font(24));
		
		VBox layout = new VBox(10);
		layout.getChildren().add(messageLabel);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
    }
	
	@FXML
    void sortTitleCostButtonPressed(ActionEvent event) {
    	cart.sortByTitleAndCost();
    }
	
	@FXML
    void sortTitleCategoryButtonPressed(ActionEvent event) {
    	cart.sortByTitleAndCategory();
    }
	
	@FXML
    void sortCostTitleButtonPressed(ActionEvent event) {
		cart.sortByCostAndTitle();
    }	
	@FXML
    void placeOrderButtonPressed(ActionEvent event) {
		final Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Place Order");
		window.setMinWidth(300);
		window.setMinHeight(150);
		
		Label messageLabel = new Label();
		messageLabel.setText("Your order is created !");
		messageLabel.setFont(new Font(24));
		
		VBox layout = new VBox(10);
		layout.getChildren().add(messageLabel);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		cart.emptyCart();
    }

}




