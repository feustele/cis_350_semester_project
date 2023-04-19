package projectSane;
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
	public datingSimLevel() {
		super(new int[] {1,1});
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
        * Reads and prints the text from a file, meant to give the player some flair.
        */

	private void generateIntroText(GUI gui) {
		readTextFile("Text/datingSimIntro.txt", gui);
	} 
	/**
        * Reads and prints the text from the 'datingSimIntro file', meant to give the player some flair as they enter the room.
        */
	
	private void generateExitText(GUI gui) {
		readTextFile("Text/datingSimExit.txt", gui);
		
	}
	/**
     * Reads and prints the text from the 'datingSimExit file', meant to give the player some flair as they exit the room.
     */
	
	private void generateSeduceText(GUI gui) {
		readTextFile("Text/seduce.txt", gui);

	}

	private boolean move(Map map, String input, GUI gui) {
		if (input.length() > 1) {
			gui.addText("Please input the initial character of the cardinal direction that you wish to move");
			return false;
		}
		if(!(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))) {
			gui.addText("Please input the initial character of the cardinal direction that you wish to move");
		}
		
		try {
			map.move(input.charAt(0));
			return true;
		} catch (Exception e) {
			return false;
			
		}
	}

	private void exit(Map map, GUI gui) {
		String prompt = "Which direction do you want to head?";
		String input = null;
			
		while(input == null || !(
				input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))){
			gui.addText(prompt);
			input = scnr.next();

			if(!move(map, input, gui)) {
				input = null;
			}
		};
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
	public void roomEngine(Map map, GUI gui) throws IOException {
		audioEngine.playSong("Pompeii - Medieval Cover Bardcore.mp3");
		generateIntroText(gui);

		char answer = promptUser("Do you run?", gui);
		
		if (answer == 'n') {
			audioEngine.playSong("Haddaway - What Is Love (Medieval Style Bardcore).mp3");
			generateSeduceText(gui);
			
			int chances = 3;
			int hearts = 0;
			while (chances >= 1 || hearts <= 2){
				gui.addText("What do you do?");
				if (scnr.next().contains("flirt")|| scnr.next().equalsIgnoreCase("Ask her about her day") || scnr.next().equalsIgnoreCase("Compliment her.") || scnr.next().equalsIgnoreCase("Ask what such a beautiful dragon is doing in a place like this?") || scnr.next().equalsIgnoreCase("Tell her you've never met a dragon before."))  {
					if (hearts == 0){
						gui.addText("The dragon blushes, surprised.");
					}
					if (hearts == 1){
						gui.addText("The dragon curls back. She doesn't seem to want to attack you.");
					}
					if (hearts == 2){
						gui.addText("The dragon bats her eyelashes at you.");
					}
					hearts = hearts + 1;
				}
				else if (scnr.next().equalsIgnoreCase("run") || scnr.next().equalsIgnoreCase("escape") || scnr.next().equalsIgnoreCase("flee")){
					chances = 0;
				}
				else{
					if (chances == 3){
						gui.addText("The dragon blows smoke at you. You'd better be careful with what you say next.");
					}
					else if (chances == 2){
						gui.addText("The dragon snarls. Buddy, are you blind?");
					} 
					else{
						gui.addText("The dragon creeps closer, ready to pounce. You'd better hope you have a will in place.");
					} 
					chances = chances - 1;
				}
			}
			if (chances == 0){
				gui.addText("The dragon gobbles you up! Your charisma stat really was lacking.  END");
				IOException end = new IOException(); 
				throw end;
			}
			else{
				gui.addText("You and the dragon decide to order takeout. She recommends a lovely Indian place in the next cavern over.");
				answer = promptUser("Do you go to the next room after the date?", gui);
				
				while (answer == 'n') {
					gui.addText("You're hesitant to leave Tiamat... she seems so lonely.");
					answer = promptUser("Do you want to leave now?", gui);
				}
		
				if (answer == 'y') {
					exit(map, gui);
					// If the player chooses to exit, they leave the date.
					audioEngine.playSong("Dancing In The Moonlight (Medieval Version) - Bardcore.mp3");
					generateExitText(gui);
					
				} 	
			}
		}
	}
}
