package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;



public class outroLevelTest {
    @Test
    public void generateDefaultRoom() {
        outroLevel level = new outroLevel();
        assertEquals(1, level.getSize()[0]);
        assertEquals(1, level.getSize()[1]);
        assertTrue(Rooms.isObjectARoom(level));
    }

    

    @Test (expected = IOException.class)
    public void doesGameFinish() throws IOException {
        Map map = new Map();
        outroLevel level = new outroLevel();
        String input = "y";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        level.setScanner(scanner);
        
        level.roomEngine(map);

        scanner.close();

    }
}
