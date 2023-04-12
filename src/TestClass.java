import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


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
            try { object2 = Items.getItem(ExperienceRing.class); }
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
        int[] roomSize = map.getPlayerRoom().getSize();
        int[] setPosition = {0, 1};

        for (int i = 0; i < roomSize[0]; i++) {
            map.move('s');
        }


        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);
        
        assertNotEquals(tempVar, map.getPlayerRoom());
        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
        assertNotEquals(outroLevel.class, map.getMap().get(1).getClass());
        assertNotEquals(introLevel.class, map.getMap().get(1).getClass());
    }


    @Test
    public void mapMoveARoomNorth() throws Exception {
        Map map = new Map();
        Player player = new Player("Test");

        introLevel tempVar = new introLevel();
        int[] setPosition = {0, -1};
        int[] roomSize = map.getPlayerRoom().getSize();


        for (int i = roomSize[0]; i > 0;  i--) {
            map.move('n');
        }
        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar, map.getPlayerRoom());
        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
        assertNotEquals(outroLevel.class, map.getMap().get(1).getClass());
        assertNotEquals(introLevel.class, map.getMap().get(1).getClass());
    }
    @Test
    public void mapMoveARoomEast() throws Exception {
        Map map = new Map();
        Player player = new Player("Test");

        introLevel tempVar = new introLevel();
        int[] setPosition = {1, 0};

        int[] roomSize = map.getPlayerRoom().getSize();


        for (int i = 0; i < roomSize[1];  i++) {
            map.move('e');
        }
        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar, map.getPlayerRoom());
        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
        assertNotEquals(outroLevel.class, map.getMap().get(1).getClass());
        assertNotEquals(introLevel.class, map.getMap().get(1).getClass());
    }
    @Test
    public void mapMoveARoomWest() throws Exception {
        Map map = new Map();
        Player player = new Player("Test");
        introLevel tempVar = new introLevel();
        int[] setPosition = {-1, 0};
        int[] roomSize = map.getPlayerRoom().getSize();


        for (int i = roomSize[1]; i > 0;  i--) {
            map.move('w');
        }

        assertEquals(2, map.getMapSize());
        assertEquals(tempVar.getClass(), map.getMap().get(0).getClass());
        assertEquals(2, map.getMap().get(1).getRoomPosition().length);
        assertEquals(setPosition[0], map.getMap().get(1).getRoomPosition()[0]);
        assertEquals(setPosition[1], map.getMap().get(1).getRoomPosition()[1]);

        assertNotEquals(tempVar, map.getPlayerRoom());
        assertNotEquals(tempVar.getClass(), map.getMap().get(1).getClass());
        assertNotEquals(outroLevel.class, map.getMap().get(1).getClass());
        assertNotEquals(introLevel.class, map.getMap().get(1).getClass());
    }

    

    @Test(expected = Exception.class)
    public void mapMoveToPrevVisitedSquareSimple() throws Exception {
        Map map = new Map();
        Player player = new Player("Test");


        map.move('w');

        map.move('e');
    }

    @Test(expected = Exception.class)
    public void mapMoveToPrevVisitedSquareComplex() throws Exception {
        Map map = new Map();
        Player player = new Player("Test");

        map.move('w');

        map.move('s');
        map.move('e');
        map.move('n');
    }

    

    @Test
    public void roomSetPlayerNorth() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('n');
        System.out.println(room.getSize()[0] -1);
        assertEquals(room.getSize()[0] - 1, room.getPlayerPosition()[1]);
    }  
    @Test
    public void roomSetPlayerSouth() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('s');
        assertEquals(0, room.getPlayerPosition()[1]);

    }  
    @Test
    public void roomSetPlayerEast() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('e');
        assertEquals(0, room.getPlayerPosition()[0]);

    }  
    @Test
    public void roomSetPlayerWest() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('w');
        assertEquals(room.getSize()[1] - 1, room.getPlayerPosition()[0]);

    }  

    @Test
    public void roomSetRoomPosition() {
        int[] pos = {5, 3};
        PitLevel room = new PitLevel();
        try {
            room.setRoomPosition(pos);
        } catch (Exception e) {
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

    @Test
    public void roomMovePlayerNorth() {
        int[] pos = {1,1};
        int[] finalPos = {1, 0};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
        

        pos[0] = 0;
        pos[1] = room.getSize()[1] - 1;

        finalPos[0] = 0;
        finalPos[1] = room.getSize()[1] - 2;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);


        pos[0] = room.getSize()[0] - 1;
        pos[1] = room.getSize()[1] - 1;

        finalPos[0] = room.getSize()[0] - 1;
        finalPos[1] = room.getSize()[1] - 2;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
    }

    @Test
    public void roomMovePlayerSouth() {
        int[] pos = {1,1};
        int[] finalPos = {1, 2};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('s');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
        

        pos[0] = 0;
        pos[1] = 0;

        finalPos[0] = 0;
        finalPos[1] = 1;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('s');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);


        pos[0] = room.getSize()[0] - 1;
        pos[1] = room.getSize()[1] - 2;

        finalPos[0] = room.getSize()[0] - 1;
        finalPos[1] = room.getSize()[1] - 1;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('s');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
    }
    
    @Test
    public void roomMovePlayerEast() {
        int[] pos = {1,1};
        int[] finalPos = {2, 1};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('e');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
        

        pos[0] = 0;
        pos[1] = 0;

        finalPos[0] = 1;
        finalPos[1] = 0;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('e');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);


        pos[0] = room.getSize()[0] - 2;
        pos[1] = room.getSize()[1] - 1;

        finalPos[0] = room.getSize()[0] - 1;
        finalPos[1] = room.getSize()[1] - 1;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('e');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
    }

    @Test
    public void roomMovePlayerWest() {
        int[] pos = {1,1};
        int[] finalPos = {0, 1};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('w');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
        

        pos[0] = 1;
        pos[1] = 0;

        finalPos[0] = 0;
        finalPos[1] = 0;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('w');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);


        pos[0] = room.getSize()[0] - 1;
        pos[1] = room.getSize()[1] - 1;

        finalPos[0] = room.getSize()[0] - 2;
        finalPos[1] = room.getSize()[1] - 1;
        room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('w');
        
        assertEquals(finalPos[0], room.getPlayerPosition()[0]);
        assertEquals(finalPos[1], room.getPlayerPosition()[1]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void roomSetPlayerNorthInvalid1() {
        int[] pos = {0,0};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void roomSetPlayerNorthInvalid2() {
        int[] pos = {1,0};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void roomSetPlayerSouthInvalid1() {
        Room room = new PitLevel();
        int[] pos = {0, room.getSize()[1]};

        room.setPlayerPosition(pos);
        room.movePlayer('s');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void roomSetPlayerSouthInvalid2() {
        Room room = new PitLevel();
        int[] pos = {1, room.getSize()[1]};
        room.setPlayerPosition(pos);
        room.movePlayer('s');
    }
    

    public static void main(String args[]) throws Exception {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('a');
        assertEquals(room.getSize()[1] - 1, room.getPlayerPosition()[0]);
    }
}