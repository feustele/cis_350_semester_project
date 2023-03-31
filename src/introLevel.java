import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The introLevel class represents the first room in the game.
 * It prompts the player to enter the cave
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class introLevel extends Room {
	Scanner scnr = new Scanner(System.in);

        /**
	 * Creates a new introLevel object
	 */
	public introLevel() {
		super();
		int[] size = {1, 1};
		generateRoom(size);

	}
       
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
         * Reads and prints the introduction text from the "intro.txt" file
         */
	private void generateIntroText() {
		readTextFile("intro.txt");
			
	} 
       
	/**
        * Reads and prints the text about the chicken from the "chicken.txt" file
        */
	private void generateChickenText() {
		readTextFile("chicken.txt");
		
	}

	/**
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		
		generateIntroText();

		char answer = promptUser("Do you enter the cave?");
		


		if (answer == 'n'){
			// if the player chooses not to enter the cave, the game ends.
			generateChickenText();
			IOException end = new IOException(); 
			throw end;
			// add ioextension end method to interact with game engine (register an ending)
			// reads out fall text
			
		} 
		/**
		 * Because the game is thrown into two states - enter the cave or not, 
		 *we know the game is currently in the enter the cave state.
		 */
		
		//Move south by default
		
		try {
			map.move('s');
		} catch (IndexOutOfBoundsException e ) {
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
