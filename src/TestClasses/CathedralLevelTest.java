package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;

public class CathedralLevelTest {
    
    @Test
    public void generateDefaultRoom() {
        cathedralLevel level = new cathedralLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        cathedralLevel level = new cathedralLevel();

        level.roomEngine(map);
    }
}
