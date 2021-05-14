package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
    private RadioButton penModeButton;

    @FXML
    private ToggleGroup modeGroup;

    @FXML
    private RadioButton eraseModeButton;
	@FXML
	private Pane drawingAreaPane;
	
	private Color brushColor = Color.BLACK;

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	// Create a black circle at the current position
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, brushColor);
		drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
	void modeButtonSelected(ActionEvent event) {
		brushColor = (Color) modeGroup.getSelectedToggle().getUserData();
	}
    
	public void initialize() {
		penModeButton.setUserData(Color.BLACK);
		eraseModeButton.setUserData(Color.WHITE);
	}
}
