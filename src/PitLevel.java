import java.util.Random;
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
        Random rand = new Random();
        //Likely can be removed. 
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        //     exception
        // }
        pitPosition = super.getSize();

        if(pitPosition[0] < 2) pitPosition[0] = 2; //Checks if an index out of bounds error will occur or not.
        if(pitPosition[1] < 2) pitPosition[1] = 2; //Checks if an index out of bounds error will occur or not.
    
        pitPosition[0] = rand.nextInt(pitPosition[0] - 1); //Subtract one so that it so it cannot generate a pit on the exit.
        pitPosition[1] = rand.nextInt(pitPosition[1] - 1); 
    
    }

    public PitLevel() {
        super();
        generatePit();
        
    }

    public int[] getPitPosition() {
        return pitPosition;
    }
    
    	public void roomEngine() {
    		try {
    			BufferedReader trap = new BufferedReader(new FileReader("trap.txt"));
                String line = trap.readLine(); 
    			while(line != null && scnr.next().equals("\n")) {
    				System.out.print(line);
                    line = trap.readLine(); 
    			}
                //reads out room enter text
                trap.close();
                System.out.print("Where do you go?");   
                      
    			if (getPitPosition() == getPlayerPosition()) {
                    //if you fall into the pit, 
    				try {
    			        BufferedReader pit = new BufferedReader(new FileReader("pit.txt"));
                        String line1 = pit.readLine(); 
    			        while(line1 != null && scnr.next().equals("\n")) {         
    				        System.out.print(line1);
                            line1 = pit.readLine(); 
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

    		catch (FileNotFoundException e) {
    			e.printStackTrace();

    		} catch (IOException e) {
    			e.printStackTrace();
    			System.out.print("Sorry! You can't do that here.");

    		}
    	}
    }
    
}
