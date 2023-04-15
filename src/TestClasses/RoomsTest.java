package TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import projectSane.*;

public class RoomsTest {
    @Test
    public void isPitLevelARoom() {
        Room testLevel = new PitLevel();

        PitLevel testLevel2 = new PitLevel();

        assertEquals(true, Rooms.isObjectARoom(testLevel));
        assertEquals(true, Rooms.isObjectARoom(testLevel2));
    }

    @Test
    public void isLevelARoomAbstract() {
        for(int i = 0; i < Rooms.length(); i++) {
            Object room;
            try {
                room = Rooms.getRoom(i);
                assertEquals(true, Rooms.isObjectARoom(room));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
