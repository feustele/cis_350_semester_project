import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
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

	}
       
	/**
         * Reads and prints the introduction text from the "intro.txt" file
         */
	private void generateIntroText() {
		try {
			BufferedReader intro = new BufferedReader(new FileReader("intro.txt"));
			String line = intro.readLine();

			while (line != null && !line.equals("\n")) {
				System.out.print(line);
				System.out.println();
				line = intro.readLine();
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
        * Reads and prints the text about the chicken from the "chicken.txt" file
        */
	private void generateChickenText() {
		try {
			BufferedReader chickenBuffer = new BufferedReader(new FileReader("chicken.txt"));
			String line2 = chickenBuffer.readLine();
			System.out.print(line2);
			while (line2 != null && !line2.equals("\n")) {
				System.out.print(line2);
				System.out.println();
				line2 = chickenBuffer.readLine();
			}
			chickenBuffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	@Override
	public char roomEngine() throws IOException {
		
		generateIntroText();

		String word1;
		do {
			System.out.println("Do you enter the cave?");
			word1 = scnr.next();
		} while(!(
			word1.equalsIgnoreCase("No") || word1.equalsIgnoreCase("N") 
			|| word1.equalsIgnoreCase("Yes") || word1.equalsIgnoreCase("Y")));


		if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")) {
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
		
		return 's';

	}
}
