import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
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
        Random rand = new Random();
        // Likely can be removed.
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        // exception
        // }
        pitPosition = super.getSize();

        if (pitPosition[0] < 2)
            pitPosition[0] = 2; // Checks if an index out of bounds error will occur or not.
        if (pitPosition[1] < 2)
            pitPosition[1] = 2; // Checks if an index out of bounds error will occur or not.

        pitPosition[0] = rand.nextInt(pitPosition[0] - 1); // Subtract one so that it so it cannot generate a pit on the
                                                           // exit.
        pitPosition[1] = rand.nextInt(pitPosition[1] - 1);

    }

    public PitLevel() {
        super();
        generatePit();

    }

    public int[] getPitPosition() {
        return pitPosition;
    }

    public char roomEngine() {
        try {
            File file = new File(
					"C:\\Users\\Bees\\Documents\\School\\GVSU\\2022WinterSemester\\CIS 350\\Project\\Project Sane\\trap.txt");
            BufferedReader trap = new BufferedReader(new FileReader(file));
            String line = trap.readLine(); 
			while (line != null && !line.equals("\n")) {
                System.out.print(line);
                System.out.println();
                line = trap.readLine(); 
            }
            //reads out room enter text
            trap.close();
            System.out.print("Where do you go?");   
            
            String word1 = scnr.next();
		while (getPlayerPosition != null && (word1.equalsIgnoreCase('w') || word1.equalsIgnoreCase('a') || word1.equalsIgnoreCase('s') || word1.equalsIgnoreCase('d'))){
			super.movePlayer(word1);
			if (getPitPosition() == getPlayerPosition()) {
                		//if you fall into the pit, 
               			try {
                    			BufferedReader pit = new BufferedReader(new FileReader("pit.txt"));
                   			 String line2 = pit.readLine(); 
                    			while(line2 != null && scnr.next().equals("\n")) {         
                        			System.out.print(line2);
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
                    			System.out.print("Sorry! You can't do that here.");
                		}
           		 }
        	}
			System.out.print("Where next?"); 
			word1 = scnr.next();
	}
	    if (getPlayerPosition != null){
		    System.out.print("Sorry! You can't do that here.");
	    }
		    
            //TODO: Create a loop which will constantly move the player
            //The loop can use the super.movePlayer(direction) method. Once the player moves off 
            //of the room, I will then create a new Room via the map object. 
            //TODO: Move below into a function please
            

        catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Sorry! You can't do that here.");

        }
        return 's';

    }

}
