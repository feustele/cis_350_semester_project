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
    			System.out.println(line);
			while (line != null && scnr.next().equals(" ")) {
                		line = outro.readLine();
				System.out.println(line);
            		}
          		outro.close();
    			System.out.println("Do retrieve the Mysterious Amulet?");
		      String word1 = scnr.next();
          if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")){
            //if the player chooses not to take the amulet, the game ends.
    				try {
				String line2 = badBuffer.readLine();
    	    			BufferedReader badBuffer = new BufferedReader(new FileReader("badOutro.txt"));
    			        System.out.println(line2);
				while (line2 != null && scnr.next().equals(" ")) {
                			line2 = badBuffer.readLine();
					System.out.println(line2);
            			}
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
    			System.out.println(line3);
			while (line3 != null && scnr.nextLine.equals(" ")) {
                		line3 = goodBuffer.readLine();
				System.out.println(line3);
            		}
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
	try {
    			BufferedReader creditBuffer = new BufferedReader(new FileReader("credits.txt"));
			String line4 = creditBuffer.readLine());
    			System.out.println(line4);
			while (line4 != null && scnr.nextLine.equals(" ")) {
                		line4 = credit.readLine();
				System.out.println(line4);
            		}

                   creditBuffer.close();
		 new IOException end;
		throw end;
             }

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();

    		} catch (IOException e) {
    			e.printStackTrace();

    		}


}
