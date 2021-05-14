package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGridFrame extends JFrame{
	private JButton[] digitButtons = new JButton[10];
	private JButton deleteButton, resetButton;
	private JTextField textField;
	
	
	public NumberGridFrame() {
		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel digitButtonPanel = new JPanel(new GridLayout(4,3));
		addDigitButtonsTo(digitButtonPanel);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(textField, BorderLayout.NORTH);
		contentPane.add(digitButtonPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}	
	
	public void addDigitButtonsTo(JPanel panel) {
		NumGridButtonListener listener = new NumGridButtonListener();
		for(int i = 1; i < 10; i++) {
			digitButtons[i] = new JButton(i + "");
			digitButtons[i].addActionListener(listener);
			panel.add(digitButtons[i]);
			
		}
		deleteButton = new JButton("DEL");
		deleteButton.addActionListener(listener);
		digitButtons[0] = new JButton("0");
		digitButtons[0].addActionListener(listener);
		resetButton = new JButton("C");
		resetButton.addActionListener(listener);
		
		panel.add(deleteButton);
		panel.add(digitButtons[0]);
		panel.add(resetButton);
		
	}
	
	public class NumGridButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonTitle = e.getActionCommand();
			if (buttonTitle.charAt(0) >= '0' && buttonTitle.charAt(0) <= '9') {
				textField.setText(textField.getText() + buttonTitle);
			} else if (buttonTitle.equals("C")) {
				textField.setText("");
			} else {
				String oldText = textField.getText();
				if (oldText != null && oldText.length() > 0) {
					String newText = oldText.substring(0, oldText.length()-1);
					textField.setText(newText);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new NumberGridFrame();

	}

}
