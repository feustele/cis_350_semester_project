package projectSane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;
/**
* Acts as the view for the player to go through the adventure. Text given by the narrator is written on this GUI.
*/
public class GUI {
	// This is the JFrame containing our textbox
	JFrame window;
	
	// This is the text panel that shows the game's text
	JTextPane text;
	
	// This is the Scroll panel
	JScrollPane scroll;
	
	/**
	* This is the default constructor for the GUI class
	*/
	public GUI() {
		window = new JFrame();
		text = new JTextPane();
		scroll = new JScrollPane(text);
		window.setBounds(0, 0, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text.setEditable(false);
		text.setBackground(Color.black);
		text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		text.setForeground(Color.white);
		
		window.add(scroll);
		window.setVisible(true);
	}
	
	/**
	* This is the method for printing text to the GUI
	* @param s This parameter is the text you want to print to the GUI
	*/
	public void addText(String s) {
		this.text.setText(this.text.getText() + "\n" + s);
		DefaultCaret caret = (DefaultCaret)text.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}
	
	/**
	* This method clears all text currently contained in the GUI
	*/
	public void clear() {
		this.text.setText("");
	}
}
