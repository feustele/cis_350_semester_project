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

}