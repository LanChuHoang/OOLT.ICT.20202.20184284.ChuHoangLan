package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class LookAndFeelDemo extends JFrame {
	
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
	}
	
	void addDemoComponents() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Label"));
		contentPane.add(new JTextField("Text Field"));
		contentPane.add(new JRadioButton("Radio Button"));
		contentPane.add(new JButton("Button"));
	}
	
	// Extended combo box with 2 choices: Java & System
	void addLookAndFeelComboBox() {
		Container contentPane = getContentPane();
		contentPane.add(new JLabel("Change Look & Feel here"));
		
		// Create an array of L&F names 
		LookAndFeelInfo[] installedLAF = UIManager.getInstalledLookAndFeels();
		LookAndFeelInfo[] lafInfo = Arrays.copyOf(installedLAF, installedLAF.length + 2);
		LookAndFeelInfo javaLAF = new LookAndFeelInfo("Java", UIManager.getCrossPlatformLookAndFeelClassName());
		LookAndFeelInfo systemLAF = new LookAndFeelInfo("System", UIManager.getSystemLookAndFeelClassName());
		lafInfo[lafInfo.length-2] = javaLAF;
		lafInfo[lafInfo.length-1] = systemLAF;
		
		String[] lafNames = new String[lafInfo.length];
		for(int i = 0; i < lafNames.length; ++i) {
			lafNames[i] = lafInfo[i].getName();
		}
		
		// Create a combo box containing L&F names
		JComboBox lafComboBox = new JComboBox(lafNames);
		
		// Add the combo box to the content pane
		contentPane.add(lafComboBox);
		
		// Handle the action occurs when the using select a name in the combo box
		JFrame frame = this;
			//  Using anonymous class
		lafComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = lafComboBox.getSelectedIndex();
				LookAndFeelInfo selectedLAF = lafInfo[selectedIndex];
				try {
					UIManager.setLookAndFeel(selectedLAF.getClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(selectedLAF.getName() + " Look And Feel");
			}
		});
		
		
		
	}
	
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
	
}
