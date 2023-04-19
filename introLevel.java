package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The introLevel class represents the first room in the game.
 * It prompts the player to enter the cave
 * displays different endings based on the player's choice.
 * Prevents a monster from being spawned in this room.
 */
public class introLevel extends Room {
	Scanner scnr = new Scanner(System.in);

        /**
	 * Creates a new introLevel object
	 */
	public introLevel() {
		super(new int[] {1, 1});

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
         * Reads and prints the introduction text from the "intro.txt" file
         */
	private void generateIntroText(GUI gui) {
		readTextFile("Text/intro.txt", gui);
			
	} 

	
       
	/**
        * Reads and prints the text about the chicken from the "chicken.txt" file
        */
	private void generateChickenText(GUI gui) {
		try {
			BufferedReader chickenBuffer = new BufferedReader(new FileReader("Text/chicken.txt"));
			String line2 = chickenBuffer.readLine();
			gui.addText(line2);
			while (line2 != null && scnr.hasNext()) {
				gui.addText(line2);
				line2 = chickenBuffer.readLine();
				scnr.next();
			}
			chickenBuffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		String prompt = "Which direction do you want to exit the board room?";
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
	 * This method contains the specific behavior of the intro room.
	 * It reads the intro text from a file, and prompts the user to enter the cave.
	 * If the user decides not to enter, the game ends. If the user enters the cave,
	 * a new room is generated.
	 * 
	 * @return 's' character, indicating the direction of the player's movement.
	 */
	@Override
	public void roomEngine(Map map, GUI gui) throws IOException {
		
		generateIntroText(gui);
		audioEngine.playSong("Dancing In The Moonlight (Medieval Version) - Bardcore.mp3");

		String word1;
		do {
			gui.addText("Do you enter the cave?");
			word1 = scnr.next();
		} while(!(
			word1.equalsIgnoreCase("No") || word1.equalsIgnoreCase("N") 
			|| word1.equalsIgnoreCase("Yes") || word1.equalsIgnoreCase("Y")));


		if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")) {
			audioEngine.playSong("rickroll.wav");
			// if the player chooses not to enter the cave, the game ends.
			generateChickenText(gui);
			IOException end = new IOException(); 
			throw end;
			// add ioextension end method to interact with game engine (register an ending)
			// reads out fall text
			
		} 
		
		try{ 
			map.move('s');
		} catch (Exception e) {
			System.out.println("Unable to move south of the intro room");
		}
		
		
	}

	public void setScanner(Scanner scnr) {
		this.scnr = scnr; 
	}
}
