import java.util.Random;

public class lavaLevel extends Room {
    private int[] lavaPosition = new int[3]; 
    
    lavaLevel.enemySpawnChance = 0;
    // prevents a monster from being spawned in this room.

    private void generateLava() {
        Random rand = new Random();
        //Likely can be removed. 
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        //     exception
        // }
        lavaPosition = super.getSize();

        lavaPosition[0] = rand.nextInt(pitPosition[0] - 1); //Subtract one so that it so it cannot generate a pit on the exit.
        lavaPosition[1] = rand.nextInt(pitPosition[1] - 1); 
        lavaPosition[2] = rand.nextInt(pitPosition[2] - 1); 
    
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
    public class Main {
    	public static void roomEngine(String[] args) {
    		try {
    			FileReader reader = new FileReader("lavaroom.txt");
    			BufferedReader trap = new BufferedReader reader;
                String line; 
    			while((line = trap.readLine()) != null && scnr.next != null) {
    				System.out.print(line);
    			}
                //reads out room enter text
    			reader.close();
          trap.close();
    			if (getLavaPosition() == getPlayerPosition()) {
                    //if you fall into the lava, 
    				try {
    	    			FileReader pitReader = new FileReader("cookedChicken.txt");
                        BufferedReader pitBuffer = new BufferedReader pitReader;
    			        while((line = pitBuffer.readLine()) != null && scnr.next != null) {
    				        System.out.print(line);
    			        }
                        pitReader.close();
                        pitBuffer.close();
                        new IOException end;
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
