package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The cathedralLevel class represents the first room in the game.
 * It prompts the player to explore a new location
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class cathedralLevel extends Room {
	Scanner scnr = new Scanner(System.in);

        /**
	      * Creates a new cathedral object
	 */
	public cathedralLevel() {
		super();
		int[] size = {1, 1};
		generateRoom(size);

	}

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
         * Reads and prints the introduction text from the "intro.txt" file
         */
	private void generateIntroText() {
		readTextFile("Text/introCathedral.txt");
			
	} 
       
	/**
        * Reads and prints the text about the chicken from the "chicken.txt" file
        */
	private void generateChestText() {
		readTextFile("Text/chest.txt");
		
	}

	private boolean move(Map map, String input) {
		if (input.length() > 1) {
			System.out.println("Please input the initial character of the cardinal direction that you wish to move");
			return false;
		}
		if(!(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))) {
			System.out.println("Please input the initial character of the cardinal direction that you wish to move");
		}
		
		try {
			map.move(input.charAt(0));
			return true;
		} catch (Exception e) {
			return false;
			
		}
	}

	private void exit(Map map) {
		String prompt = "Which direction do you want to head?";
		String input = null;
			
		while(input == null || !(
				input.equalsIgnoreCase("n") || input.equalsIgnoreCase("w") 
				|| input.equalsIgnoreCase("s") || input.equalsIgnoreCase("e"))){
			System.out.println(prompt);
			input = scnr.next();

			if(!move(map, input)) {
				input = null;
			}
		};
	}

	/**
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
		generateIntroText();

		char answer = promptUser("Do you approach the chest?");
		if (answer == 'y') {
			// if the player approaches the chest, they get flavor text.
			generateChestText();
			audioEngine.playSong("Pompeii - Medieval Cover Bardcore.mp3");

		} 

		exit(map);

	}
}
