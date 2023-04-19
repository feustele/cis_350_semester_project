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
			input = scnr.next();
		} while(!(
			input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N") 
			|| input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")));
		
		
		if (input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("N"))
			return 'n';

		return 'y'; 

	}
	
	private void readTextFile(String file, GUI gui) {
		try {

			BufferedReader exitText = new BufferedReader(new FileReader(file));
			String line2 = exitText.readLine();

			while (line2 != null) {
				gui.addText(line2);

				scnr.nextLine();  // wait for user input

				line2 = exitText.readLine();
			}
			
			gui.addText("");

			exitText.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * Reads and prints the text from the 'enterHallway file'
     */
	private void generateIntroText(GUI gui) {
		readTextFile("Text/enterHallway.txt", gui);
	} 
	/**
     * Reads and prints the text from the 'hallwayExit file' before the player exits the room.
     */
	private void generateHallwayExit(GUI gui) {
		readTextFile("Text/hallwayExit.txt", gui);
	}
	/**
     * Reads and prints the text from the 'infiniteDoors file'. Prompts the backrooms ending.
     */
	private void generateInfiniteEnding(GUI gui) {
		readTextFile("Text/infiniteDoors.txt", gui);		
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
			input = scnr.next();

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
		audioEngine.playSong("Muzak Track 10A (May be original).mp3");
		generateIntroText(gui);
		// player is prompted with the level's flavor text

		char answer = promptUser("Do you open a door?", gui);

		if (answer == 'y') {
			audioEngine.playSong("Welcome to the Internet - medieval style from Bo Burnhams Inside.mp3");
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

			audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
			gui.addText("You walk to the end of the hallway and exit, ignoring the hallway doors.");
			generateHallwayExit(gui);
			
		}
		// if the player does not try to open the door and instead exits at the end of the hallway, they get to proceed
		// to the next level. 
	}
}
