import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class introLevel extends Room {
	//super.enemySpawnChance = 0;
	
	public introLevel() {
        super();
           
    	}
	
	//makes sure you don't get beaned with a monster in the first room
	@Override
    	public void roomEngine() {
        Scanner scnr = new Scanner(System.in);
    		try {
    			BufferedReader intro = new BufferedReader(new FileReader("intro.txt"));
                	String line = intro.readLine(); ; 
    			while(line != null && scnr.next().equals("\n")) {	
    				System.out.print(line);
				line = intro.readLine(); 
    			}
                	//reads out room enter text
          		intro.close();
    			System.out.println("Do you enter the cave?");
		      	String word1 = scnr.next();
          if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")){
            //if the player chooses not to enter the cave, the game ends.
    			try {
    	    			BufferedReader chickenBuffer = new BufferedReader(new FileReader("chicken.txt"));
				String line2 = chickenBuffer.readLine(); 
    			        while(line2 != null && scnr.next().equals("\n")) {
    				        System.out.print(line2);
					line2 = chickenBuffer.readLine(); 
    			        }
                   		chickenBuffer.close();
				IOException end = new IOException();
				throw end;
            		 }
//add ioextension end method to interact with game engine (register an ending)
                    // reads out fall text
             catch (FileNotFoundException e) {
        			  e.printStackTrace();
        		 }
             catch (IOException e) {
        			  e.printStackTrace();
    			   }
    		}
        else if (word1.equalsIgnoreCase("YES") || word1.equalsIgnoreCase("Y")){
          //if player enters the cave from the intro room, then a new room is generated.
        }

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();

    		} catch (IOException e) {
    			e.printStackTrace();

    		}


    	}
}
