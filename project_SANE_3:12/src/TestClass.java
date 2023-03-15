import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;


public class TestClass {

    @Test
    public void testItemsClass() {
        for(int i = 0; i < 100; i++) {
            Object object1;
            try {
                object1 = Items.getItem(0);
            } catch(Exception e) {
                object1 = null;
            }

            Object object2;
            try { object2 = Items.getItem("ExperienceRing"); }
            catch(Exception e) {
                object2 = null;
            }

            assertNotNull(object1);
            assertNotNull(object2);
        }
    }

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
            try { object2 = Rooms.getRoom("PitLevel"); }
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
            try { object2 = Monsters.getMonster("Frog"); }
            catch(Exception e) {
                object2 = null;
            }

            assertNotNull(object1);
            assertNotNull(object2);
        }
    }
   
    /**Testing the initial creation of ChessModel.*/
    @Test
    public void mapSetupTest() {
        Map map = new Map();
        introLevel tempVar = new introLevel();
        assertEquals(1, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
    }

    @Test
    public void mapMoveARoomSouth() throws Exception  {
        Map map = new Map();
        introLevel tempVar = new introLevel();
        int[] setPosition = {0, 1};

        map.moveRooms('s');

        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
    
    }
    @Test
    public void mapMoveARoomNorth() throws Exception {
        Map map = new Map();
        introLevel tempVar = new introLevel();
        int[] setPosition = {0, -1};

        map.moveRooms('w');

        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
    
    }
    @Test
    public void mapMoveARoomEast() throws Exception {
        Map map = new Map();
        introLevel tempVar = new introLevel();
        int[] setPosition = {1, 0};

        map.moveRooms('d');

        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
    
    }
    @Test
    public void mapMoveARoomWest() throws Exception {
        Map map = new Map();
        introLevel tempVar = new introLevel();
        int[] setPosition = {-1, 0};

        map.moveRooms('a');

        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
    }

    @Test(expected = Exception.class)
    public void mapMoveToPrevVisitedSquareSimple() throws Exception {
        Map map = new Map();

        map.moveRooms('a');

        map.moveRooms('d');
    }

    @Test(expected = Exception.class)
    public void mapMoveToPrevVisitedSquareComplex() throws Exception {
        Map map = new Map();

        map.moveRooms('a');

        map.moveRooms('s');
        map.moveRooms('d');
        map.moveRooms('w');
    }

    @Test
    public void roomMovePlayerNorth() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('w');
        assertEquals(0, room.getPlayerPosition()[0]);
        
    }  
    @Test
    public void roomMovePlayerSouth() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('s');
        assertEquals(room.getSize()[0] - 1, room.getPlayerPosition()[0]);
        
    }  
    @Test
    public void roomMovePlayerEast() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('d');
        assertEquals(room.getSize()[1] - 1, room.getPlayerPosition()[1]);
        
    }  
    @Test
    public void roomMovePlayerWest() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('a');
        assertEquals(0, room.getPlayerPosition()[1]);
        
    }  

    @Test
    public void roomSetRoomPosition() {
        int[] pos = {5, 3};
        PitLevel room = new PitLevel();
        try {
            room.setRoomPosition(pos);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(pos[0], room.getRoomPosition()[0]);
        assertEquals(pos[1], room.getRoomPosition()[1]);
    }

    @Test(expected = Exception.class)
    public void roomSetRoomPositionInvalidLarger() throws Exception {
        int[] pos = {5, 3, 4};
        PitLevel room = new PitLevel();
        room.setRoomPosition(pos);
        
    }
    @Test(expected = Exception.class)
    public void roomSetRoomPositionInvalidSmaller() throws Exception {
        int[] pos = {5};
        PitLevel room = new PitLevel();
        room.setRoomPosition(pos);
        assertEquals(pos[0], room.getRoomPosition()[0]);
        assertEquals(pos[1], room.getRoomPosition()[0]);
    }

    


    public static void main(String args[]) {
        //Map map = new Map();

        Object object1;
        try {
            object1 = Rooms.getRoom(0);
        } catch(Exception e) {
            object1 = null;
        }
    }
}