package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {
	private JTextField inputTextField;
	private JTextField outputTextField;
	private int sum = 0;
	
	public SwingAccumulator() {
		 Container contentPane = getContentPane();
		 contentPane.setLayout(new GridLayout(2, 2));
		 
		 JLabel inputLabel = new JLabel("Enter an Integer");
		 JLabel outputLabel = new JLabel("The accumulated sum is");
		 inputTextField = new JTextField(10);
		 inputTextField.addActionListener(new TextFieldInputListener());
		 outputTextField = new JTextField(10);
		 outputTextField.setEditable(false);
		 
		 add(inputLabel);
		 add(inputTextField);
		 add(outputLabel);
		 add(outputTextField);
		 
		 setTitle("Swing Accumulator");
		 setSize(350, 120);
		 setVisible(true);
		 
	}	
	
	public static void main(String[] args) {
		new SwingAccumulator();

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
