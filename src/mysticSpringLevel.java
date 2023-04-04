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
	
	// method of reading flavor texts from files
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


	private void generateIntroText() {
		readTextFile("introSpring.txt");
			
	} 
       
	/**
        * Reads and prints the text from the "introSpring.txt" file to give user room information.
        */
	
	private void generateExitText() {
		readTextFile("springExit.txt");
		
	}
	
	/**
     * Reads and prints the text from the "SpringExit.txt" file to give user room information as they leave.
     */
	
	private void generateSpringText() {
		readTextFile("spring.txt");
		
	}
	
	/**
     * Reads and prints the text from the "spring.txt" file to give user flavor text about the spring.
     */

	/**
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("Daft Punk - Around The World (Bardcore, Medieval style).mp3");
		generateIntroText();

		char answer = promptUser("Do you approach the spring?");
			

		if ('y' == answer) {
			audioEngine.playSong("Self Healing Water Sound for Effortless Deep Sleeping for Crying Babies.mp3");
			generateSpringText();
		} 
		
		answer = promptUser("Do you exit the cave?");
		audioEngine.playSong("Daft Punk - Around The World (Bardcore, Medieval style).mp3");
		if('y' == answer) {
			generateExitText();
			try {
				map.move('s');
			} catch (IndexOutOfBoundsException e ) {
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
