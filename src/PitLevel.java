import java.util.Random;

public class PitLevel extends Room {
    private int[] pitPosition = new int[2]; 
    
    PitLevel.enemySpawnChance = 0;
    // prevents a monster from being spawned in this room.

    private void generatePit() {
        Random rand = new Random();
        //Likely can be removed. 
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        //     exception
        // }
        pitPosition = super.getSize();

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
    public class Main {
    	public static void roomEngine(String[] args) {
    		try {
    			FileReader reader = new FileReader("trap.txt");
    			BufferedReader trap = new BufferedReader reader;
                String line; 
    			while((line = trap.readLine()) != null) {
    				System.out.print(line);
    			}
                //reads out room enter text
    			reader.close();
                trap.close();
    			if (getPitPosition() == getPlayerPosition()) {
                    //if you fall into the pit, 
    				try {
    	    			FileReader pitReader = new FileReader("pit.txt");
                        BufferedReader pitBuffer = new BufferedReader pitReader;
    			        while((line = pitBuffer.readLine()) != null) {
    				        System.out.print(line);
    			        }
                        pitReader.close();
                        pitBuffer.close();
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
