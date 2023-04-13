package TestClasses;
import org.junit.Test;
import static org.junit.Assert.*;

import projectSane.*;


public class TestClass {

    @Test
    public void testRoomsClass() {
        for(int i = 0; i < 100; i++) {

            Object object1;
            try {
                object1 = Rooms.getRoom(0);
            } catch(Exception e) {
                object1 = null;
            }

            Object object2;
            try { object2 = Rooms.getRoom(PitLevel.class); }
            catch(Exception e) {
                object2 = null;
            }

            assertNotNull(object1);
            assertNotNull(object2);
        }
    }

    @Test
    public void testMonstersClass() {
        for(int i = 0; i < 100; i++) {
            Object object1;
            try {
                object1 = Monsters.getMonster(0);
            } catch(Exception e) {
                object1 = null;
            }

            Object object2;
            try { object2 = Monsters.getMonster(Frog.class); }
            catch(Exception e) {
                object2 = null;
            }

            assertNotNull(object1);
            assertNotNull(object2);
        }
    }

}