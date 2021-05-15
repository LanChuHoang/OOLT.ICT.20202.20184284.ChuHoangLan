package hust.soict.globalict.aims.screen.cart;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;


import hust.soict.globalict.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		this.cart = cart;
		
		// Create a fxpanel to hold the scene
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setSize(new Dimension(1028, 746));
		this.setVisible(true);
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/cart/Cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
