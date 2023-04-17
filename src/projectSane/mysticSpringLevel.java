package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The mysticSpringLevel class represents a room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class mysticSpringLevel extends Room {
	Scanner scnr = new Scanner(System.in);
	//TODO: Default constructor


	/** Takes in a string, which it will continue to prompt the user with until the user answers with a 
	* yes or no
	* @param prompt
	* @return
	*/
	private char promptUser(String prompt, GUI gui) {
		String input;

		do {
			gui.addText(prompt);
			input = scnr.next();
		} while(!(
			input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N") 
			|| input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")));
		
		
		if (input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("N"))
			return 'n';

		return 'y'; 

	}
	
	// method of reading flavor texts from files
	private void readTextFile(String file, GUI gui) {
		try {

			BufferedReader exitText = new BufferedReader(new FileReader(file));
			String line2 = exitText.readLine();
			gui.addText(line2);

			while (line2 != null && scnr.hasNext()) {
				gui.addText(line2);
				line2 = exitText.readLine();
				scnr.next();
			}

			exitText.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void generateIntroText(GUI gui) {
		readTextFile("Text/introSpring.txt", gui);
			
	} 
       
	/**
        * Reads and prints the text from the "introSpring.txt" file to give user room information.
        */
	
	private void generateExitText(GUI gui) {
		readTextFile("Text/springExit.txt", gui);
		
	}
	
	/**
     * Reads and prints the text from the "SpringExit.txt" file to give user room information as they leave.
     */
	
	private void generateSpringText(GUI gui) {
		readTextFile("Text/spring.txt", gui);
		
	}
	
	private boolean move(Map map, String input, GUI gui) {
		if (input.length() > 1) {
			gui.addText("Please input the initial character of the cardinal direction that you wish to move");
			return false;
		}
		if(!(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))) {
			gui.addText("Please input the initial character of the cardinal direction that you wish to move");
		}
		
		try {
			map.move(input.charAt(0));
			return true;
		} catch (Exception e) {
			return false;
			
		}
	}

	private void exit(Map map, GUI gui) {
		String prompt = "Which direction do you want to head?";
		String input = null;
			
		while(input == null || !(
				input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))){
			gui.addText(prompt);
			input = scnr.next();

			if(!move(map, input, gui)) {
				input = null;
			}
		};
	}
	
	/**
     * Reads and prints the text from the "spring.txt" file to give user flavor text about the spring.
     */

	/**
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map, GUI gui) throws IOException {
		audioEngine.playSong("Daft Punk - Around The World (Bardcore, Medieval style).mp3");
		generateIntroText(gui);

		char answer = promptUser("Do you approach the spring?", gui);
			

		if ('y' == answer) {
			audioEngine.playSong("Self Healing Water Sound for Effortless Deep Sleeping for Crying Babies.mp3");
			generateSpringText(gui);
		} 
		
		exit(map, gui);

		audioEngine.playSong("Daft Punk - Around The World (Bardcore, Medieval style).mp3");
		
		generateExitText(gui);
			

		
	}
}
