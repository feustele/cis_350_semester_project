import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The snakeLevel class represents a room in the game.
 * It prompts the player to explore a new location and solve problems
 * displays different endings based on the player's choice.
 */
public class snakeLevel extends Room {
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
	
	/**
     * Reads and prints the text from a file, meant to give the player some flair.
     */
	
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
     * Reads and prints the text from the 'snakeIntro file', meant to give the player some flair as they enter the room.
     */
	private void generateIntroText() {
		readTextFile("snakeIntro.txt");
	} 
	
	/**
     * Reads and prints the text from the 'snakeExit file', meant to be read out as the player exits the room.
     */  
	private void generateExitText() {
		readTextFile("snakeExit.txt");
		
	}
	
	/**
     * Reads out what happens if the player chooses to charm the snakes.
     */
	private void generateCharmText() {
		readTextFile("charm.txt");

	}
	

	/**
	 * This method contains the specific behavior of the basic room.
	 * It reads the intro text from a file, and prompts the player to either face the snakes or not, generating text accordingly.
	 * If the player chooses to face the snakes, the player must find a way to please the snakes in order to pass.
	 * If they fail, they are killed and the game ends.
	 * If they succeed, the player is prompted to either leave the room or remain.
	 * If the player choses to leave, a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("Toxic - Britney Spears (Bardcore Medieval Style).mp3");
		generateIntroText();
		
	    int chances = 3;
	    //basically a counter to limit the length of the interaction. If player fails to please the snakes before the counter runs out,
	    //the encounter ends.

		char answer = promptUser("Do you face the snakes?");
		
		if (answer == 'y') {
			
			generateCharmText();
			
			while (chances >= 1 || chances != 4){
				System.out.println("What do you do?");
					if (scnr.next().contains("sing") || scnr.next().equalsIgnoreCase("sing to the snakes")){
						audioEngine.playSong("Rihanna - Umbrella [Bardcore Medieval Style Cover].mp3");
						System.out.println("You break into a rousing rendition of Rhianna's Umbrella. The snakes love it!");
						chances = 4;
					}
					else{
						if (chances == 3){
							System.out.println("The snakes look saddened. You haven't impressed them.");
						}
						else if (chances == 2){
							System.out.println("The snakes look peeved. You haven't impressed them. What do snakes like, again?");
						} 
						else{
							System.out.println("The snakes look angry. One hisses 'Get off the ssssstage!!'");
						} 
						chances = chances - 1;
					}
			}
			if (chances == 0){
				audioEngine.playSong("Toxic - Britney Spears (Bardcore Medieval Style).mp3");
				System.out.println("The snakes attack! You die of poisoning.");
				IOException end = new IOException(); 
				throw end;
			}
			else{
				audioEngine.playSong("Rihanna - Umbrella [Bardcore Medieval Style Cover].mp3");
				System.out.println("The snakes do a little boogie. They seem to be amenable to you passing them.");
				answer = promptUser("Do you exit the impromptu snake dance party?");
				
				while (answer == 'n') {
					System.out.println("You dance a little while longer.");
					answer = promptUser("Do you want to leave now?");
				}
		
				if (answer == 'y') {
					// If the player chooses to exit, they leave the snake room.
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
