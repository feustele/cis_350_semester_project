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
			input = gui.getInput();
		} while(!(
			input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N") 
			|| input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")));
		
		
		if (input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("N"))
			return 'n';

		return 'y'; 

	}
	
	/**
         * Generates the text for the outroLevel room by reading from a file called "outro.txt"
         * @throws IOException if there is an error reading the file
         */
	private void generateOutroText(GUI gui) {
		try {

			BufferedReader outro = new BufferedReader(new FileReader("Text/outro.txt"));
			String line = outro.readLine(); 
			gui.addText(line);
			
			while (line != null && scnr.hasNext()) {
				line = outro.readLine();
				gui.addText(line);
				scnr.next();
			}
			outro.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
            gui.addText("Sorry! You can't do that here.");
        }
	}

        /**
         * Generates the bad ending text by reading from a file called "badOutro.txt"
         * and then throws an IOException to end the game.
         * @throws IOException if there is an error reading the file or to end the game
         */
	private void generateBadEnding(GUI gui) {
		try {
			BufferedReader badBuffer = new BufferedReader(new FileReader("Text/badOutro.txt"));
			String line2 = badBuffer.readLine();

			gui.addText(line2);
			while (line2 != null && scnr.hasNext()) {
				line2 = badBuffer.readLine();
				gui.addText(line2);
				scnr.next();
			}
		
			badBuffer.close();
	// end the game here
			throw new IOException(); //This will be caught by the try catch below...???
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
         * Generates the good ending text by reading from a file called "goodOutro.txt"
         * and then throws an IOException to display the credits.
         * @throws IOException if there is an error reading the file or to display the credits
         */
	private void generateGoodEnding(GUI gui) {
		try {
			BufferedReader goodBuffer = new BufferedReader(new FileReader("Text/goodOutro.txt"));
			String line3 = goodBuffer.readLine();
			gui.addText(line3);
			while (line3 != null && scnr.hasNext()) {
				line3 = goodBuffer.readLine();
				gui.addText(line3);
				scnr.next();
			}
			goodBuffer.close();
			// display credits here
			throw new IOException(); //This will be caught by the try/catch below...?
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}

	 /**
          * Generates the credits text by reading from a file called "credits.txt"
          * and then throws an IOException to end the game.
          * @throws IOException if there is an error reading the file or to end the game
          */
	private void generateCredits(GUI gui) {
		try {
			BufferedReader creditBuffer = new BufferedReader(new FileReader("Text/credits.txt"));
			String line4 = creditBuffer.readLine();
			gui.addText(line4);
			while (line4 != null && scnr.hasNext()) {
				line4 = creditBuffer.readLine();
				gui.addText(line4);
				scnr.next();
			}

			creditBuffer.close();
			// end the game here
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/**
         * Runs the logic for the outroLevel room.
         * Prompts the player to retrieve the Mysterious Amulet and
         * displays different endings based on the player's choice.
	 * @throws IOException
         */
	@Override
    public void roomEngine(Map map, GUI gui) throws IOException{

	    audioEngine.playSong("firework.wav");
		generateOutroText(gui);
		// reads out room enter text

		char answer = promptUser("Do you retrieve the Mysterious Amulet?", gui);

		if (answer == 'n') {
			audioEngine.track.stop();
			//if the player chooses not to take the amulet, the game ends.
			audioEngine.playSong("thereaper.wav");
			generateBadEnding(gui);
	    			
		}else if(answer == 'y') {
			audioEngine.track.stop();
			audioEngine.playSong("pleasestandup.wav");
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
