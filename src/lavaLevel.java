import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.io.IOException;
import java.util.Scanner;

public class lavaLevel extends Room {
    private int[] lavaPosition = new int[3];

    // prevents a monster from being spawned in this room.

    private void generateLava(lavaLevel lava) {
        Random rand = new Random();
        //Likely can be removed.
        // if (super.getSize()[0] == 0 or super.getSize()[1] == 0) {
        //     exception
        // }
        lavaPosition = super.getSize();

        lavaPosition[0] = rand.nextInt(lava.lavaPosition[0] - 1); //Subtract one so that it so it cannot generate a pit on the exit.
        lavaPosition[1] = rand.nextInt(lava.lavaPosition[1] - 1);
        lavaPosition[2] = rand.nextInt(lava.lavaPosition[2] - 1);

    }

    public lavaLevel() {
        super();
        generateLava(this);
        //creates a room with lava generated in it.

    }

    public int[] getLavaPosition() {
        return lavaPosition;
        //returns where the lava is positioned.
    }
        @Override
        public void roomEngine() {
            lavaLevel lava = new lavaLevel();
            lava.enemySpawnChance = 0;
            Scanner scnr = new Scanner(System.in);
            try {
                FileReader reader = new FileReader("lavaroom.txt");
                BufferedReader trap = new BufferedReader(reader);
                String line;
                while ((line = trap.readLine()) != null && scnr.nextLine().equals("/n")){
                    System.out.print(line);
                }
                //reads out room enter text
                reader.close();
                trap.close();
                if (lava.getLavaPosition() == lava.getPlayerPosition()) {
                    //if you fall into the lava,
                    try {
                        FileReader pitReader = new FileReader("cookedChicken.txt");
                        BufferedReader pitBuffer = new BufferedReader(pitReader);
                        while ((line = pitBuffer.readLine()) != null && scnr.nextLine().equals("/n")){
                            System.out.print(line);
                        }
                        pitReader.close();
                        pitBuffer.close();
                        IOException end = new IOException();
                        throw end;
                    }
                    // reads out fall text
                    catch (IOException e) {
                        e.printStackTrace();

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();

            }


        }
}