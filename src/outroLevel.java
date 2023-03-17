import java.util.Random;
import java.util.Scanner;

public class outroLevel extends Room {
	//outroLevel.enemySpawnChance = 0;
	//prevents a monster from being spawned in this room.
	
	public outroLevel() {
        	super();
    	}
	
	@Override
    	public void roomEngine() {
        Scanner scnr = new Scanner(System.in);
    		try {
    			BufferedReader outro = new BufferedReader(new FileReader("outro.txt"));
                	String line; 
    			while((line = outro.readLine()) != null && scnr.next().equals("/n")) {
    				System.out.print(line);
    			}
                //reads out room enter text
    			reader.close();
          		goodOutro.close();
    			System.out.println("Do retrieve the Mysterious Amulet?");
		      String word1 = scnr.next();
          if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")){
            //if the player chooses not to take the amulet, the game ends.
    				try {
    	    			BufferedReader badBuffer = new BufferedReader(new FileReader("badOutro.txt"));
    			        while((line = badBuffer.readLine()) != null && scnr.next().equals("/n")) {
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
        else if (word1.equalsIgnoreCase("YES") || word1.equalsIgnoreCase("Y")){{
         	try {
    			BufferedReader goodBuffer = new BufferedReader(new FileReader("goodOutro.txt"));
    			while((line = goodBuffer.readLine()) != null && scnr.next().equals("/n")) {
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
