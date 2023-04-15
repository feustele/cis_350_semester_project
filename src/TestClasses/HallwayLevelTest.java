package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;



public class HallwayLevelTest {
    @Test
    public void generateDefaultRoom() {
        hallwayLevel level = new hallwayLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        hallwayLevel level = new hallwayLevel();

        level.roomEngine(map);
    }
}
