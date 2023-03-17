import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class lavaLevel extends Room {
	Scanner scnr = new Scanner(System.in);
    private int[] lavaPosition = new int[3]; 
    
   // lavaLevel.enemySpawnChance = 0;
    // prevents a monster from being spawned in this room.

    private void generateLava() {
        Random rand = new Random();
        //Likely can be removed. 
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        //     exception
        // }
        /**Note by Steven:
         * super is a reference to Room, meaning getSize() returns an array of two ints, not three
         * Returns the array [room.length, room[0].length]
         */
        lavaPosition = super.getSize();

        if(lavaPosition[0] < 2) lavaPosition[0] = 2; //Checks if an index out of bounds error will occur or not.
        if(lavaPosition[1] < 2) lavaPosition[1] = 2; //Checks if an index out of bounds error will occur or not.

        lavaPosition[0] = rand.nextInt(lavaPosition[0] - 1); //Subtract one so that it so it cannot generate a pit on the exit.
        lavaPosition[1] = rand.nextInt(lavaPosition[1] - 1); 
        lavaPosition[2] = rand.nextInt(lavaPosition[2] - 1); 
    
    }

    public lavaLevel() {
        super();
        generateLava();
        //creates a room with lava generated in it.
        
    }

    public int[] getLavaPosition() {
        return lavaPosition;
        //returns where the lava is positioned.
    }
	@Override
    	public void roomEngine(){
    		try {
    			BufferedReader trap = new BufferedReader(new FileReader("lavaroom.txt"));
                	String line = trap.readLine(); 
    			while(line != null && scnr.next().equals("/n")) {
    				System.out.print(line);
				line = trap.readLine(); 
    			}
			System.out.print("Tread lightly, dear hero.");
                //reads out room enter text
         		trap.close();
    			if (getLavaPosition() == getPlayerPosition()) {
                    //if you fall into the lava, 
    				try {
                       		BufferedReader pitBuffer = new BufferedReader(new FileReader("cookedChicken.txt"));
				String line2 = pitBuffer.readLine();
    			        while(line2 != null && scnr.next().equals("/n")) {
    				        System.out.print(line);
					line2 = pitBuffer.readLine();
    			        }
                        pitBuffer.close();
                        Exception end = null;
		                throw end;
                    }
                    // reads out fall text
                catch (FileNotFoundException e) {
        			e.printStackTrace();

        		}
                catch (IOException e) {
        			e.printStackTrace();
    			}
    		}
   

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();

    		} catch (IOException e) {
    			e.printStackTrace();

    		}
    	}
}
