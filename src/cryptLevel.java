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

	private void generateIntroText() {
		try {
			BufferedReader intro = new BufferedReader(new FileReader("introCrypt.txt"));
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
        * Reads and prints the text from the 'cryptExit file'
        */
	//TODO: Please update all of the other classes' functions/descriptions/Javadocs to better match 
	//what they do. I already did this one for you. It helps the rest of the group understand 
	//your intentions with your coding. For example, I'm not entirely sure what your intentions 
	//were for the roomEngine class, so I had to take a swing in the dark and make comments based
	//off of that swing in the dark.
	private void generateCryptExit() {
		try {
			BufferedReader exitText = new BufferedReader(new FileReader("cryptExit.txt"));
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
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	//TODO: Update javadocs above to better match the description of the room.
	//TODO: Currently, this class is written so that the player either approaches the chest 
	//or they exit the crypt.
	@Override
	public void roomEngine(Map map) throws IOException {
		
		generateIntroText();

		
		char answer = promptUser("Do you approach the chest?");

		if (answer == 'n') {
			// if the player chooses not to approach the chest, the player leaves the crypt room?????
			//TODO: Fix the below code. Currently causes an IOException to make the game 'end'?
			generateCryptExit();
			IOException end = new IOException(); 
			throw end;
		} 


		answer = promptUser("Do you exit the crypt?");
		
		if (answer == 'n') {
			//TODO: So if the player exits the crypt, the game ends?
			IOException end = new IOException(); 
			throw end;
		}
		try {
			//TODO: If the player has already visited the south room, the below code will not work. 
			map.move('s');
		} catch (IndexOutOfBoundsException e ) {
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
