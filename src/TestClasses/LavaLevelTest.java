package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;



public class LavaLevelTest {
    @Test
    public void generateDefaultRoom() {
        lavaLevel level = new lavaLevel();
        assertEquals(true, level.getSize()[0] > 0);
        assertEquals(true, level.getSize()[1] > 0);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        lavaLevel level = new lavaLevel();

        level.roomEngine(map);
    }
}
