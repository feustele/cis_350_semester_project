package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;



public class IntroLevelTest {
    @Test
    public void generateDefaultRoom() {
        introLevel level = new introLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test
    public void testRoomEngine() throws IOException {
        Map map = new Map();
        introLevel level = new introLevel();

        level.roomEngine(map);
    }

    @Test (expected = IOException.class)
    public void chickenEnding() throws IOException {
        Map map = new Map();
        introLevel level = new introLevel();
        String input = "n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        level.setScanner(scanner);
        
        level.roomEngine(map);

        scanner.close();
    }
}
