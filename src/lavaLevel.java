import java.io.BufferedReader;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.Random;
 import java.util.Scanner;

 public class lavaLevel extends Room {
 	Scanner scnr = new Scanner(System.in);
     private int[] lavaPosition = new int[3]; 
   
     /**
      * Generates the position of the lava pit in the room.
      * prevents a monster from being spawned in this room.
      */
     private void generateLava() {
         Random rand = new Random();
        
         lavaPosition = super.getSize();

         if(lavaPosition[0] < 2) lavaPosition[0] = 2; //Checks if an index out of bounds error will occur or not.
         if(lavaPosition[1] < 2) lavaPosition[1] = 2; //Checks if an index out of bounds error will occur or not.

         lavaPosition[0] = rand.nextInt(lavaPosition[0] - 1); //Subtract one so that it so it cannot generate a pit on the exit.
         lavaPosition[1] = rand.nextInt(lavaPosition[1] - 1); 
         lavaPosition[2] = rand.nextInt(lavaPosition[2] - 1); 
    
     }
   
     /**
      * Creates a new instance of lavaLevel with a randomly generated lava pit position.
      */
     public lavaLevel() {
         super();
         generateLava();
         //creates a room with lava generated in it.
        
     }
    
     /**
      * Returns the position of the lava pit in the room.
      * @return An integer array representing the position of the lava pit in the room.
      */
     public int[] getLavaPosition() {
         return lavaPosition;
         //returns where the lava is positioned.
     }
 	/**
          * Overrides the method in Room to implement custom room functionality for lavaLevel.
          */

	@Override
	public void roomEngine(Map map) throws IOException {
		audioEngine.playSong("Katy Perry - Firework (Medieval Cover Bardcore).mp3");
 		try {
 			BufferedReader trap = new BufferedReader(new FileReader("lavaroom.txt"));
             	String line = trap.readLine(); 
             	while(line != null && scnr.hasNext()) {
             		System.out.print(line);
             		line = trap.readLine(); 
             		scnr.next();
             	}
             	System.out.print("Tread lightly, dear hero.");
                //reads out room enter text
             	trap.close();
             	if (getLavaPosition() == getPlayerPosition()) {
                 //if you fall into the lava, 
			audioEngine.playSong("Pompeii - Medieval Cover Bardcore.mp3");
 				try {
                    		BufferedReader pitBuffer = new BufferedReader(new FileReader("cookedChicken.txt"));
				    String line2 = pitBuffer.readLine();
 			        while(line2 != null && scnr.hasNext()) {
 			        	System.out.print(line);
					    line2 = pitBuffer.readLine();
                        scnr.next();
 			        }
                     pitBuffer.close();
                     IOException end = new IOException();
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
