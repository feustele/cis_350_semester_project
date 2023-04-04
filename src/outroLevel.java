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
         * Generates the text for the outroLevel room by reading from a file called "outro.txt"
         * @throws IOException if there is an error reading the file
         */
	private void generateOutroText() {
		try {

			BufferedReader outro = new BufferedReader(new FileReader("outro.txt"));
			String line = outro.readLine(); 
			System.out.println(line);
			
			while (line != null && scnr.hasNext()) {
				line = outro.readLine();
				System.out.println(line);
				scnr.next();
			}
			outro.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry! You can't do that here.");
        }
	}

        /**
         * Generates the bad ending text by reading from a file called "badOutro.txt"
         * and then throws an IOException to end the game.
         * @throws IOException if there is an error reading the file or to end the game
         */
	private void generateBadEnding() {
		try {
			BufferedReader badBuffer = new BufferedReader(new FileReader("badOutro.txt"));
			String line2 = badBuffer.readLine();

			System.out.println(line2);
			while (line2 != null && scnr.hasNext()) {
				line2 = badBuffer.readLine();
				System.out.println(line2);
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
	private void generateGoodEnding() {
		try {
			BufferedReader goodBuffer = new BufferedReader(new FileReader("goodOutro.txt"));
			String line3 = goodBuffer.readLine();
			System.out.println(line3);
			while (line3 != null && scnr.hasNext()) {
				line3 = goodBuffer.readLine();
				System.out.println(line3);
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
	private void generateCredits() {
		try {
			BufferedReader creditBuffer = new BufferedReader(new FileReader("credits.txt"));
			String line4 = creditBuffer.readLine();
			System.out.println(line4);
			while (line4 != null && scnr.hasNext()) {
				line4 = creditBuffer.readLine();
				System.out.println(line4);
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
    public void roomEngine(Map map) throws IOException{
	    	audioEngine.playSong("Katy Perry - Firework (Medieval Cover Bardcore");
		generateOutroText();
		// reads out room enter text
		String word1;

		do {
			System.out.println("Do you retrieve the Mysterious Amulet?");
			word1 = scnr.next();
		} while(!(
			word1.equalsIgnoreCase("No") || word1.equalsIgnoreCase("N") 
			|| word1.equalsIgnoreCase("Yes") || word1.equalsIgnoreCase("Y"))){
  
    		}if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")){
			//if the player chooses not to take the amulet, the game ends.
				audioEngine.playSong("Don't Fear The Reaper (Medieval Style) Blue Oyster Cult Bardcore Cover.mp3");
				generateBadEnding();
	    			
    		}else if (word1.equalsIgnoreCase("YES") || word1.equalsIgnoreCase("Y")) {
				audioEngine.playSong("THE REAL SLIM SHADY Medieval Bardcore Version Eminem vs Beedle the Bardcore.mp3");
				generateGoodEnding();	
		}
		// reads out ending text.

		generateCredits();
		
		//It should generate an exception within the generation of credits
		throw new IOException();
	}

}
