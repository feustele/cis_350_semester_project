package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;

public class DatingSimLevelTest {
    
    @Test
    public void generateDefaultRoom() {
        datingSimLevel level = new datingSimLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        datingSimLevel level = new datingSimLevel();

        level.roomEngine(map);
    }
}
