package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The cryptLevel class represents a room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class cryptLevel extends Room {

	

	Scanner scnr = new Scanner(System.in);	
	
	public cryptLevel() {		
		//super();
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
        * Reads and prints the text from the 'introCrypt file', meant to give the player some flair as they enter the room.
        */

	private void generateIntroText(GUI gui) {
		readTextFile("Text/introCrypt.txt", gui);
	} 
       
	/**
        * Reads and prints the text from the 'cryptExit file', meant to give the player some flair as they leave the room.
        */
	
	private void generateCryptExit(GUI gui) {
		readTextFile("Text/cryptExit.txt", gui);
		
	}
	private void generateChestText(GUI gui) {
		readTextFile("Text/chest.txt", gui);

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
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts to either investigate the chest or not, generating text accordingly.
	 * Reguardless of the user's choice, they are prompted to either exit the cave or remain.
	 * If the player choses to leave, a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map, GUI gui) throws IOException {
		audioEngine.playSong("The Cranberries - Zombie [Medieval Bardcore Instrumental Cover].mp3");
		generateIntroText(gui);
		
		char answer = promptUser("Do you investigate the chest?", gui);
		
		if (answer == 'y') {
			//read out the chest text.
			audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
			generateChestText(gui);
		}



		exit(map, gui);
	}

	public void setScanner(Scanner scnr) {
		this.scnr = scnr; 
	}
}
		
