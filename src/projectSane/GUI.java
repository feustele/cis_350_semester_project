package projectSane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextPane;
public class GUI {
	JFrame window;
	JTextPane text;
	
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
	
	
	public void addText(String s) {
		this.text.setText(this.text.getText() + "\n" + s);
	}
	
	public void clear() {
		this.text.setText("");
	}
}
