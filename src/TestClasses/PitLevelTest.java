package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;



public class PitLevelTest {
    @Test
    public void generateDefaultRoom() {
        PitLevel level = new PitLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        PitLevel level = new PitLevel();

        level.roomEngine(map);
    }
}
