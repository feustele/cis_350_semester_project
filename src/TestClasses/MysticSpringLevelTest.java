package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;



public class MysticSpringLevelTest {
    @Test
    public void generateDefaultRoom() {
        mysticSpringLevel level = new mysticSpringLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        mysticSpringLevel level = new mysticSpringLevel();

        level.roomEngine(map);
    }
}
