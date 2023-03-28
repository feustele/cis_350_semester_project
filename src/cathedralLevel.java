import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The cathedralLevel class represents the first room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class cathedralLevel extends Room {
	Scanner scnr = new Scanner(System.in);

        /**
	      * Creates a new cathedral object
	 */
	public introLevel() {
		super();
		int[] size = {1, 1};
		generateRoom(size);

	}
       
	/**
         * Reads and prints the introduction text from the "intro.txt" file
         */
	private void generateIntroText() {
		try {
			BufferedReader intro = new BufferedReader(new FileReader("introCathedral.txt"));
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
        * Reads and prints the text about the chicken from the "chicken.txt" file
        */
	private void generateChickenText() {
		try {
			BufferedReader chickenBuffer = new BufferedReader(new FileReader("chest.txt"));
			String line2 = chickenBuffer.readLine();
			System.out.print(line2);
			while (line2 != null && scnr.hasNext()) {
				System.out.print(line2);
				line2 = chickenBuffer.readLine();
				scnr.next();
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
	public void roomEngine(Map map) throws IOException {
		
		generateIntroText();

		String word1;
		do {
			System.out.println("Do you approach the chest?");
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
    String word2;
		do {
			System.out.println("Do you exit the cave?");
			word2 = scnr.next();
		} while(!(
			word2.equalsIgnoreCase("No") || word2.equalsIgnoreCase("N") 
			|| word2.equalsIgnoreCase("Yes") || word2.equalsIgnoreCase("Y")));


		if (word2.equalsIgnoreCase("YES") || word2.equalsIgnoreCase("Y")) {
			// if the player chooses not to enter the cave, the game ends.
			IOException end = new IOException(); 
			throw end;
{
			map.move('s');
		} catch (IndexOutOfBoundsException e ) {
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
