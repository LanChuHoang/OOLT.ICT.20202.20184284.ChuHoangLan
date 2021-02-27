import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		// Answer1: The user choose "Cancel" = choose "No" option
		
		
		// Answer2: Customize the options
		String[] options = new String[] {"I do", "I don't"};
	    int response = JOptionPane.showOptionDialog(null, "Message", "Title",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    JOptionPane.showMessageDialog(null, "You have chosen: " + (response == JOptionPane.YES_OPTION? "I do" : "I dont't"));
	    System.exit(0);
		
	}
}
