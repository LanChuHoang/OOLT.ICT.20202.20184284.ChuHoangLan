package hust.soict.globalict.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
	private TextField inputTextField;
	private TextField outputTextField;
	private int sum = 0;
	
	public AWTAccumulator() {
		 setLayout(new GridLayout(2, 2));
		 
		 Label inputLabel = new Label("Enter an Integer");
		 Label outputLabel = new Label("The accumulated sum is");
		 inputTextField = new TextField(10);
		 inputTextField.addActionListener(new TextFieldInputListener());
		 outputTextField = new TextField(10);
		 outputTextField.setEditable(false);
		 
		 add(inputLabel);
		 add(inputTextField);
		 add(outputLabel);
		 add(outputTextField);
		 
		 setTitle("AWT Accumulator");
		 setSize(350, 120);
		 setVisible(true);
		 
	}	
	
	public static void main(String[] args) {
		new AWTAccumulator();

	}
	
	private class TextFieldInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int numberIn = Integer.parseInt(inputTextField.getText());
			sum += numberIn;
			inputTextField.setText("");
			outputTextField.setText(sum + "");
		}
		
	}
}
