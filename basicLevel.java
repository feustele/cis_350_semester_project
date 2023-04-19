package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The basicLevel class represents a room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class basicLevel extends Room {
	Scanner scnr = new Scanner(System.in);

	public basicLevel() {
		super(new int[] {1, 1});
	}

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
        * Reads and prints the text from a file, meant to give the player some flair.
        */

	private void generateIntroText(GUI gui) {
		readTextFile("Text/introBasic.txt", gui);
	} 
       
	/**
        * Reads and prints the text from the 'introBasic file', meant to give the player some flair as they enter the room.
        */
	
	private void generateExitText(GUI gui) {
		readTextFile("Text/exitBasic.txt", gui);
		
	}
	/**
     * Reads and prints the text from the 'exitBasic file', meant to give the player some flair as they exit the room.
     */
	
	private void generateComputerText(GUI gui) {
		readTextFile("Text/computer.txt", gui);

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
     * Reads and prints the text from the 'computer file', meant to give the player some flair as they interact with the computer.
     */

	/**
	 * This method contains the specific behavior of the basic room.
	 * It reads the intro text from a file, and prompts to either investigate the computer or not, generating text accordingly.
   * If the player chooses to investigate the computer, the game ends as they are trapped in the 9 to 5.
	 * If they avoid the trap, they are prompted to either exit the room or remain.
	 * If the player choses to leave, a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map, GUI gui) throws IOException {
		audioEngine.playSong("Muzak Track 10A (May be original).mp3");
		generateIntroText(gui);

		char answer = promptUser("Do you investigate the computer?", gui);
		
		if (answer == 'y') {
			audioEngine.playSong("Welcome to the Internet - medieval style from Bo Burnhams Inside.mp3");
			generateComputerText(gui);
			IOException end = new IOException(); 
			throw end;
		}

		

		exit(map, gui);


		audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
		// If the player chooses to exit, they leave the crypt.
		generateExitText(gui);
			
	
	}
}
		
