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

	private void generateIntroText() {
		try {
			BufferedReader intro = new BufferedReader(new FileReader("introSpring.txt"));
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
        * Reads and prints the text about the chicken from the "introSpring.txt" file
        */
	private void generateChickenText() {
		try {
			BufferedReader chickenBuffer = new BufferedReader(new FileReader("springExit.txt"));
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

		char answer = promptUser("Do you approach the spring?");
			

		if ('n' == answer) {
			// if the player chooses not to enter the cave, the game ends.
			generateChickenText();
			IOException end = new IOException(); 
			throw end;
			// add ioextension end method to interact with game engine (register an ending)
			// reads out fall text
			
		} 
		answer = promptUser("Do you exit the spring?");
		if('y' == answer) {
			// if the player chooses not to enter the cave, the game ends.
			IOException end = new IOException(); 
			throw end;
		}
		try {
			map.move('s');
		} catch (IndexOutOfBoundsException e ) {
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
