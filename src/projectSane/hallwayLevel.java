package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The hallwayLevel class represents a room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class hallwayLevel extends Room {
	Scanner scnr = new Scanner(System.in);
	//TODO: Add a default constructor.
	/**
	 * Takes in a string, which it will continue to prompt the user with until the user answers with a 
	 * yes or no
	 * @param prompt
	 * @return
	 */
	private char promptUser(String prompt, GUI gui) {
		String input;

		do {
			gui.addText(prompt);
			input = gui.getInput();
		} while(!(
			input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N") 
			|| input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")));
		
		
		if (input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("N"))
			return 'n';

		return 'y'; 

	}
	
	/**
     * Reads and prints the text from the 'enterHallway file'
     */
	private void generateIntroText(GUI gui) {
		try {
			BufferedReader intro = new BufferedReader(new FileReader("Text/enterHallway.txt"));
			String line = intro.readLine();

			while (line != null && scnr.hasNext()) {
				gui.addText(line);
				line = intro.readLine();
				scnr.next();
			}
			// reads out room enter text
			intro.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	} 
	/**
     * Reads and prints the text from the 'hallwayExit file' before the player exits the room.
     */
	private void generateHallwayExit(GUI gui) {
		try {
			BufferedReader exitText = new BufferedReader(new FileReader("Text/hallwayExit.txt"));
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
	/**
     * Reads and prints the text from the 'infiniteDoors file'. Prompts the backrooms ending.
     */
	private void generateInfiniteEnding(GUI gui) {
		try {
			BufferedReader exitText = new BufferedReader(new FileReader("Text/infiniteDoors.txt"));
			String line = exitText.readLine();
			gui.addText(line);
			while (line != null && scnr.hasNext()) {
				gui.addText(line);
				line = exitText.readLine();
				scnr.next();
			}
			exitText.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		String prompt = "Which direction do you want to exit the board room?";
		String input = null;
			
		while(input == null || !(
				input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))){
			gui.addText(prompt);
			input = gui.getInput();

			if(!move(map, input, gui)) {
				input = null;
			}
		};
	}

	/**
	 * this method reads the exit text from a file, and provides it when the player chooses to exit the cave.
	 * if the player exits, they get a new room.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	
	public void roomEngine(Map map, GUI gui) throws IOException {
		audioEngine.playSong("muzak.wav");
		generateIntroText(gui);
		// player is prompted with the level's flavor text

		char answer = promptUser("Do you open a door?", gui);

		if (answer == 'y') {
			audioEngine.track.stop();
			audioEngine.playSong("bo.wav");
			try {
				generateInfiniteEnding(gui);
				IOException end = new IOException(); 
				throw end;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		// if the player tries to open a door, they get sucked into a "backroom" and the game ends.
		//TODO: Implement some solution for below.

		if (answer == 'n') {
			
			exit(map, gui);
			audioEngine.track.stop();
			audioEngine.playSong("thelessIknowthebetter.wav");
			gui.addText("You walk to the end of the hallway and exit, ignoring the hallway doors.");
			generateHallwayExit(gui);
			
		}
		// if the player does not try to open the door and instead exits at the end of the hallway, they get to proceed
		// to the next level. 
	}
}
