package hust.soict.globalict.aims.screen.cart;


import java.util.function.Predicate;



import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;



public class CartScreenController {
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
    
    // Bottom bar 
    
    @FXML 
    private Button playButton;
    
    @FXML	
    private Button removeButton;
    
    private Cart cart;
	
	// Init
	public CartScreenController(Cart cart) {
		this.cart = cart;
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
		
		// Create filter list to wrap the data list(intitialize display all the data)
		FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), m -> true);
		
		// FILTER BAR
		filterTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// This method is triggered when the text in the text field is changed
				// Old value: old text before changing
				// New value: current text after changing
				oldValue = oldValue == null ? "null" : oldValue;
				newValue = newValue == null ? "null" : newValue;
				System.out.println("- Old: " + oldValue);
				System.out.println("  New: " + newValue);
				
				showFilteredMedia(newValue, filteredList);
				
			}
			
		});
		
		cartTableView.setItems(filteredList);
		
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
		// Covert text loval variable to a final variable to pass to the inner class
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
	
	// Event handling
	
	@FXML
    void removeButtonPressed(ActionEvent event) {
		Media selectedItem = cartTableView.getSelectionModel().getSelectedItem();
		cart.removeMedia(selectedItem);
    }
}




