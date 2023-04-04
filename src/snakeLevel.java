import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The snakeLevel class represents a room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
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
		readTextFile("snakeIntro.txt");
	} 
       
	/**
        * Reads and prints the text from the 'snakeIntro file', meant to give the player some flair as they enter the room.
        */
	
	private void generateExitText() {
		readTextFile("snakeExit.txt");
		
	}
	private void generateCharmText() {
		readTextFile("charm.txt");

	}

	/**
	 * This method contains the specific behavior of the basic room.
	 * It reads the intro text from a file, and prompts to either investigate the computer or not, generating text accordingly.
   * If the player chooses to investigate the computer, the game ends as they are trapped in the 9 to 5.
	 * If they avoid the trap, they are prompted to either exit the room or remain.
	 * If the player choses to leave, a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		
		generateIntroText();

		char answer = promptUser("Do you face the snakes?");
		
		if (answer == 'y') {
			//TODO: Factor the below code so that we only have to call a function which will
			//read out the computer text.
			generateComputerText();
      int chances = 3;
      while (chances >= 1 || chances != 4){
      System.out.println("What do you do?");
      if (scnr.nextLine.equals.ignoreCase("sing") || scnr.nextLine.equals.ignoreCase("sing to the snakes"){
        System.out.println("You break into a rousing rendition of Rhianna's Umbrella. The snakes love it!");
        chances = 4;
      }
      else{
        if (chances = 3){
          System.out.println("The snakes look saddened. You haven't impressed them.");
        }
        else if (chances = 2){
          System.out.println("The snakes look peeved. You haven't impressed them. What do snakes like, again?");
        } 
        else{
          System.out.println("The snakes look angry. One hisses "Get off the ssssstage!!"");
        } 
        chances = chances - 1;
      }
		}
    if (chances == 0){
      System.out.println("The snakes attack! You die of poisoning.");
      IOException end = new IOException(); 
			throw end;
    }
    else{
    System.out.println("The snakes do a little boogie. They seem to be amenable to you passing them.");
		answer = promptUser("Do you exit the board room?");
		
		if (answer == 'y') {
			// If the player chooses to exit, they leave the crypt.
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
