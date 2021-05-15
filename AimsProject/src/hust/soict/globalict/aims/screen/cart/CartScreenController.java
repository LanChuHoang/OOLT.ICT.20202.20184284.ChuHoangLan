package hust.soict.globalict.aims.screen.cart;



import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
    
    private Cart cart;
	
	// Init
	public CartScreenController(Cart cart) {
		this.cart = cart;
	}
	
	// Perform post processing in content after it is loaded
	@FXML
	private void initialize() {
		titleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		cartTableView.setItems(this.cart.getItemsOrdered());
		
	}
}




