package projectSane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * A room in the game with a pit trap that can cause the player to fall in and lose the game.
 */
public class PitLevel extends Room {
    private int[] pitPosition = new int[2];
    Scanner scnr = new Scanner(System.in);

    // PitLevel.enemySpawnChance = 0;
    // prevents a monster from being spawned in this room.

    /**
     * Generates the location of the pit in the room based on the room's size.
     */
    private void generatePit() {
        // Likely can be removed.
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        // exception
        // }
        
        pitPosition = getSize();

        if (pitPosition[0] < 2)
            pitPosition[0] = 2; // Checks if an index out of bounds error will occur or not.
        if (pitPosition[1] < 2)
            pitPosition[1] = 2; // Checks if an index out of bounds error will occur or not.


        pitPosition[0] /= 2;
        pitPosition[1] /= 2;
        //pitPosition[0] = rand.nextInt(pitPosition[0] - 1); // Subtract one so that it so it cannot generate a pit on the
                                                           // exit.
        //pitPosition[1] = rand.nextInt(pitPosition[1] - 1);

    }

    /**
     * Creates a new PitLevel room with a random size and a generated pit trap location.
     */
    public PitLevel() {
        super();
        int[] size = {3, 3};
        generateRoom(size);
        generatePit();

    }

    /**
     * Gets the location of the pit in the room.
     * @return an array containing the x and y coordinates of the pit
     */
    public int[] getPitPosition() {
        return pitPosition;
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
     * Generates the introduction text for the room and reads it from a file.
     */
    private void generateIntroText(GUI gui) {
        readTextFile("Text/trap.txt", gui);
    }

    /**
     * Generates the text for falling into the pit and reads it from a file.
     */
    private void generatePitText(GUI gui) {
        
	    audioEngine.playSong("Don't Fear The Reaper (Medieval Style) Blue Oyster Cult Bardcore Cover.mp3");
        readTextFile("Text/pit.txt", gui);
    }
	
    /**
     * Parses and executes the action string entered by the player.
     * @param action the action string to execute
     */
    private void fullFillAction(Map m, String action, GUI gui) {
        if (action.length() > 5) {
            if(action.substring(0, 4).toLowerCase()
                    .equals("move")) { //If the first word within the action string is equal to move, then move
                char direction = action.toLowerCase().charAt(5);
                
                move(m, direction, gui); 
            }
        }
    }

    private void mapMove(Map m, char dir) {
        try {
            m.move(dir);
        } catch(IndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) {
            //The general exception will be thrown if the room has already been visited

            e.printStackTrace();
        }
    }

    /**
     * Moves the player in the specified direction and checks if they fall into the pit trap.
     * @param dir the direction to move in
     * @throws Exception
     */
    private void move(Map m, char dir, GUI gui) { 
        if (getPlayerPosition() != null && 
                (  dir == 'w'
                || dir == 'a' 
                || dir == 's'
                || dir == 'd')) {
            
            mapMove(m, dir);
            
            if (getPitPosition() == getPlayerPosition()) {
                //if you fall into the pit, 
               generatePitText(gui);
            }
        }
    }

    /**
     *Runs the game engine loop until the player's position is no longer valid within the game's map.
     *@return A character representing the direction to move in after the game is finished.
     */
    public void roomEngine(Map map, GUI gui) throws IOException{
       	audioEngine.playSong("Dancing In The Moonlight (Medieval Version) - Bardcore.mp3");
        generateIntroText(gui);

        //The below code needs to loop through until a index out of bounds exception occurs from moving rooms
        while(!getVisited()) {
            gui.addText("What would you like to do?");
            String action = scnr.nextLine();
            
            fullFillAction(map, action, gui);
           
        } 
        

    }

}