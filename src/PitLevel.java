import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * A class that represents a room in game that contains a pit. The player must navigate
 * around the pit to avoid falling in.
 */
public class PitLevel extends Room {
    private int[] pitPosition = new int[2];
    Scanner scnr = new Scanner(System.in);

    /**
     * Generates the position of the pit within the room.
     * prevents a monster from being spawned in this room.
     */
      private void generatePit() {
        
        
        pitPosition = getSize();
         // Ensure that the pit is not generated on the edge of the room, which would cause an index out of bounds error.
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
     * Constructs a new PitLevel object with a randomly generated room and pit position.
     */
    public PitLevel() {
        super();
        int[] size = {3, 3};
        generateRoom(size);
        generatePit();

    }

    /**
     * Returns the position of the pit within the room.
     *
     * @return an array containing the x and y coordinates of the pit within the room
     */
    public int[] getPitPosition() {
        return pitPosition;
    }

    /**
     * Reads the text file containing the text for falling into the pit trap and prints it to the console.
     */
    private void generatePitText() {
        try {

            BufferedReader pit = new BufferedReader(new FileReader("pit.txt"));
            String line2 = pit.readLine(); 
	    System.out.println(line2);
            while(line2 != null && scnr.next().equals(" ")) {         
                System.out.println(line2);
                line2 = pit.readLine(); 
            }
            pit.close();
        
        }
        // reads out fall text
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry! You can't do that here.");
        }
    }
	
   /**
    * Moves the player in the specified direction and checks if they have fallen into the pit trap.
    * 
    * @param dir a char representing the direction the player wants to move.
    */
    private void move(char dir) {            
        while (getPlayerPosition() != null && 
                (  dir == 'w'
                || dir == 'a' 
                || dir == 's'
                || dir == 'd')) {
            
            
            movePlayer(dir);
           
            
            if (getPitPosition() == getPlayerPosition()) {
                //if you fall into the pit, 
               generatePitText();
            }
        }
        
    }

   /**
    * Executes the game logic for the PitLevel room.
    * 
    * @return a char representing the outcome of the game (s for success, f for failure).
    */
    public char roomEngine() {
        try {
        	BufferedReader trap = new BufferedReader(new FileReader("trap.txt"));
        	String line = trap.readLine(); 
	    	System.out.println(line);
			while (line != null && scnr.next().equals(" ")) {
                line = trap.readLine();
				System.out.println(line);
            }
            //reads out room enter text
            trap.close();

            //The below code needs to loop through until a index out of bounds exception occurs from moving rooms
            while(isPositionValid(playerPosition)) { //I want to adjust this so it's not a while true loop... It'll function the same, I just want a fail safe.
                System.out.println("What would you like to do?");
                String action = scnr.nextLine();
                
                //Manipulate string here...

                if (action.length() > 5) {
                
                    if(action.substring(0, 4).toLowerCase().equals("move")) { //If the first word within the action string is equal to move, then move
                        char direction = action.toLowerCase().charAt(5);
                        System.out.println(direction);
                        try {
                            move(direction); 

                        } catch(IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                }
            } 
            
	    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry! You can't do that here.");
        }

	    if (getPlayerPosition() != null){
		    System.out.println("Sorry! You can't do that here.");
	    }
		
        return 's';

    }

}
