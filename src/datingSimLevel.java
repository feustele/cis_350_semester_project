import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The datingSimLevel class represents a room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class datingSimLevel extends Room {
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
        * Reads and prints the text from a file, meant to give the player some flair.
        */

	private void generateIntroText() {
		readTextFile("datingSimIntro.txt");
	} 
	/**
        * Reads and prints the text from the 'datingSimIntro file', meant to give the player some flair as they enter the room.
        */
	
	private void generateExitText() {
		readTextFile("datingSimExit.txt");
		
	}
	/**
     * Reads and prints the text from the 'datingSimExit file', meant to give the player some flair as they exit the room.
     */
	
	private void generateSeduceText() {
		readTextFile("seduce.txt");

	}
	/**
     * Reads and prints the text from the 'seduce file', meant to advise the player on the next course of action - be a good date or else!
     */

	/**
	 * This method contains the specific behavior of the dragon's room.
	 * It reads the intro text from a file, and prompts to either engage with the dragon or not, generating text accordingly.
	 * If the player chooses to run at any point, or fail the date as marked by three "chances", the dragon eats them.
	 * If they flirt with the dragon, they stand a chance at survival, with text generated based on every descicion they make with the dragon.
	 * If they successfully romance the dragon, they are allowed to leave.
	 * If the player choses to leave, a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("Pompeii - Medieval Cover Bardcore.mp3");
		generateIntroText();

		char answer = promptUser("Do you run?");
		
		if (answer == 'n') {
			audioEngine.playSong("Haddaway - What Is Love (Medieval Style Bardcore).mp3");
			generateSeduceText();
			
			int chances = 3;
			int hearts = 0;
			while (chances >= 1 || hearts <= 2){
				System.out.println("What do you do?");
				if (scnr.next().contains("flirt")|| scnr.next().equalsIgnoreCase("Ask her about her day") || scnr.next().equalsIgnoreCase("Compliment her.") || scnr.next().equalsIgnoreCase("Ask what such a beautiful dragon is doing in a place like this?") || scnr.next().equalsIgnoreCase("Tell her you've never met a dragon before."))  {
					if (hearts == 0){
						System.out.println("The dragon blushes, surprised.");
					}
					if (hearts == 1){
						System.out.println("The dragon curls back. She doesn't seem to want to attack you.");
					}
					if (hearts == 2){
						System.out.println("The dragon bats her eyelashes at you.");
					}
					hearts = hearts + 1;
				}
				else if (scnr.next().equalsIgnoreCase("run") || scnr.next().equalsIgnoreCase("escape") || scnr.next().equalsIgnoreCase("flee")){
					chances = 0;
				}
				else{
					if (chances == 3){
						System.out.println("The dragon blows smoke at you. You'd better be careful with what you say next.");
					}
					else if (chances == 2){
						System.out.println("The dragon snarls. Buddy, are you blind?");
					} 
					else{
						System.out.println("The dragon creeps closer, ready to pounce. You'd better hope you have a will in place.");
					} 
					chances = chances - 1;
				}
			}
			if (chances == 0){
				System.out.println("The dragon gobbles you up! Your charisma stat really was lacking.  END");
				IOException end = new IOException(); 
				throw end;
			}
			else{
				System.out.println("You and the dragon decide to order takeout. She reccomends a lovely Indian place in the next cavern over.");
				answer = promptUser("Do you go to the next room after the date?");
				
				while (answer == 'n') {
					System.out.println("You're hesitant to leave Tiamat... she seems so lonely.");
					answer = promptUser("Do you want to leave now?");
				}
		
				if (answer == 'y') {
					// If the player chooses to exit, they leave the date.
					audioEngine.playSong("Dancing In The Moonlight (Medieval Version) - Bardcore.mp3");
					generateExitText();
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
	}
}
