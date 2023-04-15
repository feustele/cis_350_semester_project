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
	private char promptUser(String prompt) {
		String input;

		do {
			System.out.println(prompt);
			input = scnr.next();
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
	private void generateIntroText() {
		try {
			BufferedReader intro = new BufferedReader(new FileReader("Text/enterHallway.txt"));
			String line = intro.readLine();

			while (line != null && scnr.hasNext()) {
				System.out.print(line);
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
	private void generateHallwayExit() {
		try {
			BufferedReader exitText = new BufferedReader(new FileReader("Text/hallwayExit.txt"));
			String line2 = exitText.readLine();
			System.out.print(line2);
			while (line2 != null && scnr.hasNext()) {
				System.out.print(line2);
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
	private void generateInfiniteEnding() {
		try {
			BufferedReader exitText = new BufferedReader(new FileReader("Text/infiniteDoors.txt"));
			String line = exitText.readLine();
			System.out.print(line);
			while (line != null && scnr.hasNext()) {
				System.out.print(line);
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

	private boolean move(Map map, String input) {
		if (input.length() > 1) {
			System.out.println("Please input the initial character of the cardinal direction that you wish to move");
			return false;
		}
		if(!(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))) {
			System.out.println("Please input the initial character of the cardinal direction that you wish to move");
		}
		
		try {
			map.move(input.charAt(0));
			return true;
		} catch (Exception e) {
			return false;
			
		}
	}

	private void exit(Map map) {
		String prompt = "Which direction do you want to exit the board room?";
		String input = null;
			
		while(input == null || !(
				input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))){
			System.out.println(prompt);
			input = scnr.next();

			if(!move(map, input)) {
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
	
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("Muzak Track 10A (May be original).mp3");
		generateIntroText();
		// player is prompted with the level's flavor text

		char answer = promptUser("Do you open a door?");

		if (answer == 'y') {
			audioEngine.playSong("Welcome to the Internet - medieval style from Bo Burnhams Inside.mp3");
			try {
				generateInfiniteEnding();
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
			
			exit(map);

			audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
			System.out.print("You walk to the end of the hallway and exit, ignoring the hallway doors.");
			generateHallwayExit();
			
		}
		// if the player does not try to open the door and instead exits at the end of the hallway, they get to proceed
		// to the next level. 
	}
}
