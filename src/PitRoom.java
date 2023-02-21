import java.util.Random;

public class PitRoom extends Room {
    private int[] pitPosition = new int[2]; 

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

    public PitRoom() {
        super();
        generatePit();
        
    }

    public int[] getPitPosition() {
        return pitPosition;
    }
    public class Main {
    	public static void main(String[] args) {
    		try {
    			FileReader reader = new FileReader("trap.txt");
    			//pukes entire file
    			//working on line by line
    			int data = reader.read();
    			while(data != -1) {
    				System.out.print((char)data);
    				data = reader.read();
    			}
    			reader.close();
    			if (player.position == pitPosition) {
    				//unsure how player position will be tracked
    				//so subject to change
    				try {
    	    			FileReader reader = new FileReader("pit.txt");
    	    			//working on line by line
    	    			int data = reader.read();
    	    			while(data != -1) {
    	    				System.out.print((char)data);
    	    				data = reader.read();
    	    			}
    			} catch (FileNotFoundException e) {
        			e.printStackTrace();

        		} catch (IOException e) {
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
}
