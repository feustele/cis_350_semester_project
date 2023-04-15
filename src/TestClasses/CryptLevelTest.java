package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;

public class CryptLevelTest {
    
    @Test
    public void generateDefaultRoom() {
        cryptLevel level = new cryptLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        cryptLevel level = new cryptLevel();

        level.roomEngine(map);
    }
}
