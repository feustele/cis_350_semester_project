import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class PitLevel extends Room {
    private int[] pitPosition = new int[2];
    Scanner scnr = new Scanner(System.in);

    // PitLevel.enemySpawnChance = 0;
    // prevents a monster from being spawned in this room.

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

    public PitLevel() {
        super();
        int[] size = {3, 3};
        generateRoom(size);
        generatePit();

    }

    public int[] getPitPosition() {
        return pitPosition;
    }

    private void generateIntroText() {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry! You can't do that here.");
        }
    }

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
    private void fullFillAction(String action) {
        if (action.length() > 5) {
            if(action.substring(0, 4).toLowerCase()
                    .equals("move")) { //If the first word within the action string is equal to move, then move
                char direction = action.toLowerCase().charAt(5);
                
                move(direction); 
            }
        }
    }

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
    
     //TODO: Fill this method out still
    private char directionToMoveRoomsIn() {


        return 's';
    }

    public char roomEngine() {
        	
        generateIntroText();

        //The below code needs to loop through until a index out of bounds exception occurs from moving rooms
        while(isPositionValid(playerPosition)) {
            System.out.println("What would you like to do?");
            String action = scnr.nextLine();
            try {
                fullFillAction(action);
            } catch(IndexOutOfBoundsException e) {
                return directionToMoveRoomsIn();
            }
        } 
            
	   
	    // if (getPlayerPosition() != null){
		//     System.out.println("Sorry! You can't do that here.");
	    // }
		
        return 's';

    }

}
