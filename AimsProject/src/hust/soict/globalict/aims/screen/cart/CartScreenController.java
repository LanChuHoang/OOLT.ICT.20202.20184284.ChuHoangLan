package hust.soict.globalict.aims.screen.cart;


import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;



public class CartScreenController {
	@FXML
    private ToggleGroup filterModes;

    @FXML
    private TableView<Media> cartTableView;

    @FXML
    private TableColumn<Media, String> titleColumn;

    @FXML
    private TableColumn<Media, String> categoryColumn;

    @FXML
    private TableColumn<Media, Float> costColumn;
    
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
		// Set the table the way to get data
		titleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		cartTableView.setItems(this.cart.getItemsOrdered());
		
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
	
	// Event handling
	
	@FXML
    void removeButtonPressed(ActionEvent event) {
		Media selectedItem = cartTableView.getSelectionModel().getSelectedItem();
		cart.removeMedia(selectedItem);
    }
}




