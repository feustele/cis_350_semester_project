package projectSane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextPane;
/**
* Acts as the view for the player to go through the adventure. Text given by the narrator is written on this GUI.
*/
public class GUI {
	// This is the JFrame containing our textbox
	JFrame window;
	
	// This is the text panel that shows the game's text
	JTextPane text;
	
	/**
	* This is the default constructor for the GUI class
	*/
	public GUI() {
		window = new JFrame();
		text = new JTextPane();
		window.setBounds(0, 0, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text.setEditable(false);
		text.setBackground(Color.black);
		text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		text.setForeground(Color.white);
		
		window.add(text);
		window.setVisible(true);
	}
	
	/**
	* This is the method for printing text to the GUI
	* @param s This parameter is the text you want to print to the GUI
	*/
	public void addText(String s) {
		this.text.setText(this.text.getText() + "\n" + s);
	}
	
	/**
	* This method clears all text currently contained in the GUI
	*/
	public void clear() {
		this.text.setText("");
	}
}
