import java.util.Random;
import java.util.Scanner;

public class outroLevel extends Room {
	outroLevel.enemySpawnChance = 0;
	//prevents a monster from being spawned in this room.
	
    public class Main {
    	public static void roomEngine(String[] args) {
        Scanner scnr = new Scanner(System.in);
    		try {
    			FileReader reader = new FileReader("outro.txt");
    			BufferedReader outro = new BufferedReader reader;
                String line; 
    			while((line = outro.readLine()) != null && scnr.next != null) {
    				System.out.print(line);
    			}
                //reads out room enter text
    			reader.close();
          goodOutro.close();
    			System.out.println("Do retrieve the Mysterious Amulet?");
		      String word1 = scnr.next();
          if (word1 == "No" || word1 == "n" || word1 == "NO" || word1 == "no" || word1 == "N"){
            //if the player chooses not to take the amulet, the game ends.
    				try {
    	    			FileReader badReader = new FileReader("badOutro.txt");
                BufferedReader badBuffer = new BufferedReader badReader;
    			        while((line = badBuffer.readLine()) != null && scnr.next != null) {
    				        System.out.print(line);
    			        }
                   badReader.close();
                   badBuffer.close();
		new IOException end;
		throw end;
            }
             catch (FileNotFoundException e) {
        			  e.printStackTrace();
        		 }
             catch (IOException e) {
        			  e.printStackTrace();
    			   }
    		}
        else if (word1 == "Yes" || word1 == "Y" || word1 == "YES" || word1 == "yes" || word1 == "y"){
         try {
    	    			FileReader goodReader = new FileReader("goodOutro.txt");
                BufferedReader goodBuffer = new BufferedReader goodReader;
    			        while((line = goodBuffer.readLine()) != null) {
    				        System.out.print(line);
    			        }
                   goodReader.close();
                   goodBuffer.close();
		 new IOException end;
		throw end;
             }
                    // reads out ending text.
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
