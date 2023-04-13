package projectSane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
public class GUI {
	
	public GUI() {
		JFrame window = new JFrame();
		JTextPane text = new JTextPane();
		window.setBounds(0, 0, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Menu Bar
//		JMenuBar menu = new JMenuBar();
//		JMenu file = new JMenu("File");
//		menu.add(file);
//		JMenuItem save = new JMenuItem("Save");
//		JMenuItem load = new JMenuItem("Load");
//		JMenuItem quit = new JMenuItem("Quit");
//		file.add(save);
//		file.add(load);
//		file.add(quit);
//		window.add(menu);
		
		text.setEditable(false);
		text.setText("Hello");
		text.setText(text.getText() + "\n" + "No");
		
		window.add(text);
		window.setVisible(true);
	}
	
	
	
	public static void main(String args[]) {
		GUI gui = new GUI();
	}
}