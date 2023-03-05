import java.util.Random;
import java.util.Scanner;

public class introRoom extends Room {
    	public static void roomEngine(String[] args) {
        Scanner scnr = new Scanner(System.in);
    		try {
    			FileReader reader = new FileReader("intro.txt");
    			BufferedReader intro = new BufferedReader reader;
                String line; 
    			while((line = intro.readLine()) != null) {
    				System.out.print(line);
    			}
                //reads out room enter text
    			reader.close();
          intro.close();
    			System.out.println("Do you enter the cave?");
		      String word1 = scnr.next();
          if (word1 == "No" || word1 == "n" || word1 == "NO" || word1 == "no" || word1 == "N"){
            //if the player chooses not to enter the cave, the game ends.
    				try {
    	    			FileReader chickenReader = new FileReader("chicken.txt");
                BufferedReader chickenBuffer = new BufferedReader chickenReader;
    			        while((line = chickenBuffer.readLine()) != null) {
    				        System.out.print(line);
    			        }
                   chickenReader.close();
                   chickenBuffer.close();
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
        else if (word1 == "Yes" || word1 == "Y" || word1 == "YES" || word1 == "yes" || word1 == "y"){
          Room();
          //if player enters the cave from the intro room, then a new room is generated.
        }

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();

    		} catch (IOException e) {
    			e.printStackTrace();

    		}


}
