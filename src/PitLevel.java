import java.util.Random;

public class PitLevel extends Room {
    private int[] pitPosition = new int[2]; 

    private void generatePit() {
        Random rand = new Random();
        //Likely can be removed. 
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        //     exception
        // }
        pitPosition = super.getSize();
        if(pitPosition[0] < 2) pitPosition[0] = 2;
        if(pitPosition[1] < 2) pitPosition[1] = 2; 
        pitPosition[0] = rand.nextInt(pitPosition[0] - 1); //Subtract one so that it so it cannot generate a pit on the exit.
        pitPosition[1] = rand.nextInt(pitPosition[1] - 1); 
    
    }

    public PitLevel() {
        super();
        generatePit();
        
    }

    
    /** 
     * @return int[]
     */
    public int[] getPitPosition() {
        return pitPosition;
    }

}