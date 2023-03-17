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
                	String line = outro.readLine(); 
    			while(line != null && scnr.next().equals("/n")) {
    				System.out.print(line);
				line = outro.readLine();
    			}
                //reads out room enter text
          		outro.close();
    			System.out.println("Do retrieve the Mysterious Amulet?");
		      String word1 = scnr.next();
          if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")){
            //if the player chooses not to take the amulet, the game ends.
    				try {
				String line2 = badBuffer.readLine();
    	    			BufferedReader badBuffer = new BufferedReader(new FileReader("badOutro.txt"));
    			        while(line2 != null && scnr.next().equals("/n")) {
    				        System.out.print(line2);
					line2 = badBuffer.readLine();
    			        }
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
			String line3 = goodBuffer.readLine());
    			while(line != null && scnr.next().equals("/n")) {
    			System.out.print(line);
			line3 = goodBuffer.readLine();
    		}

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
