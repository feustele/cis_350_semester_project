package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;

public class SnakeLevelTest {
    
    @Test
    public void generateDefaultRoom() {
        snakeLevel level = new snakeLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        snakeLevel level = new snakeLevel();

        level.roomEngine(map);
    }
}
