package projectSane;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The outroLevel class represents the final room in the game.
 * It prompts the player to retrieve the Mysterious Amulet and
 * displays different endings based on the player's choice.
 * prevents a monster from being spawned in this room.
 */
public class outroLevel extends Room {
	Scanner scnr = new Scanner(System.in);

	/**
	 * Creates a new outroLevel object.
	 */
	public outroLevel() {
		super();
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
         * Generates the text for the outroLevel room by reading from a file called "outro.txt"
         * @throws IOException if there is an error reading the file
         */
	private void generateOutroText(GUI gui) {
		readTextFile("Text/outro.txt", gui);			
	}

        /**
         * Generates the bad ending text by reading from a file called "badOutro.txt"
         * and then throws an IOException to end the game.
         * @throws IOException if there is an error reading the file or to end the game
         */
	private void generateBadEnding(GUI gui) {
		readTextFile("Text/badOutro.txt", gui);
	}

	/**
         * Generates the good ending text by reading from a file called "goodOutro.txt"
         * and then throws an IOException to display the credits.
         * @throws IOException if there is an error reading the file or to display the credits
         */
	private void generateGoodEnding(GUI gui) {
		readTextFile("Text/goodOutro.txt", gui);
			
	}

	 /**
          * Generates the credits text by reading from a file called "credits.txt"
          * and then throws an IOException to end the game.
          * @throws IOException if there is an error reading the file or to end the game
          */
	private void generateCredits(GUI gui) {
		readTextFile("Text/credits.txt", gui);
	}
	/**
         * Runs the logic for the outroLevel room.
         * Prompts the player to retrieve the Mysterious Amulet and
         * displays different endings based on the player's choice.
	 * @throws IOException
         */
	@Override
    public void roomEngine(Map map, GUI gui) throws IOException{

	    audioEngine.playSong("Katy Perry - Firework (Medieval Cover   Bardcore).mp3");
		generateOutroText(gui);
		// reads out room enter text

		char answer = promptUser("Do you retrieve the Mysterious Amulet?", gui);

		if (answer == 'n') {
			//if the player chooses not to take the amulet, the game ends.
			audioEngine.playSong("Don't Fear The Reaper (Medieval Style) Blue Oyster Cult Bardcore Cover.mp3");
			generateBadEnding(gui);
	    			
		}else if(answer == 'y') {
			audioEngine.playSong("THE REAL SLIM SHADY Medieval Bardcore Version Eminem vs Beedle the Bardcore.mp3");
			generateGoodEnding(gui);	
		}
		// reads out ending text.

		generateCredits(gui);
		
		//It should generate an exception within the generation of credits
		throw new IOException();
	}


	public void setScanner(Scanner scnr) {
		this.scnr = scnr; 
	}
}
