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
	
	private void readTextFile(String file) {
		try {

			BufferedReader exitText = new BufferedReader(new FileReader(file));
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
        * Reads and prints the text from the 'introCrypt file', meant to give the player some flair as they enter the room.
        */

	private void generateIntroText() {
		readTextFile("introCrypt.txt");
	} 
       
	/**
        * Reads and prints the text from the 'cryptExit file', meant to give the player some flair as they leave the room.
        */
	
	private void generateCryptExit() {
		readTextFile("cryptExit.txt");
		
	}
	private void generateChestText() {
		readTextFile("chest.txt");

	}

	/**
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts to either investigate the chest or not, generating text accordingly.
	 * Reguardless of the user's choice, they are prompted to either exit the cave or remain.
	 * If the player choses to leave, a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("The Cranberries - Zombie [Medieval Bardcore Instrumental Cover].mp3");
		generateIntroText();
		
		char answer = promptUser("Do you investigate the chest?");
		
		if (answer == 'y') {
			//TODO: Factor the below code so that we only have to call a function which will
			//read out the chest text.
			audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
			generateChestText();
		}

		answer = promptUser("Do you exit the crypt?");
		
		if (answer == 'y') {
			// If the player chooses to exit, they leave the crypt.
			try {
				//TODO: If the player has already visited the south room, the below code will not work. 
				map.move('s');
			} catch (IndexOutOfBoundsException e ) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 	
	}
}
		
