package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;



public class BasicLevelTest {
    @Test
    public void generateDefaultRoom() {
        basicLevel level = new basicLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        basicLevel level = new basicLevel();

        level.roomEngine(map);
    }
}
