import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.print.attribute.PrintServiceAttributeSet;

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

    private void generatePitText() {
        try {

            BufferedReader pit = new BufferedReader(new FileReader("pit.txt"));
            String line2 = pit.readLine(); 
            while(line2 != null && scnr.next().equals("\n")) {         
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

    public char roomEngine() {
        try {
            
            File file = new File(
					"C:\\Users\\Bees\\Documents\\School\\GVSU\\2022WinterSemester\\CIS 350\\Project\\Project Sane\\trap.txt");
            BufferedReader trap = new BufferedReader(new FileReader(file));
            String line = trap.readLine(); 
			while (line != null && !line.equals("\n")) {
                System.out.println(line);
                line = trap.readLine(); 
            }
            //reads out room enter text
            trap.close();

            //TODO: We need to loop through until a index out of bounds exception occurs from moving rooms
            while(true) { //I want to adjust this so it's not a while true loop... It'll function the same, I just want a fail safe.
                System.out.println("What would you like to do?");
                String action = scnr.next();
                //Manipulate string here...
                if() { //If the first word within the action string is equal to move, then move
                    char direction = ;
                    try {
                        move(direction); //Perform string manipulation to pass the lower case character for direction to move

                    } catch(IndexOutOfBoundsException e) {
                        break;
                    }
                }
                
            }
            //TODO: The code below all is a special condition when the user wants to move.
            
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