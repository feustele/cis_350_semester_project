package TestClasses;
import org.junit.Test;
import static org.junit.Assert.*;
import projectSane.*;

public class MapTest {
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
    @Test(expected = Exception.class)
    public void mapMoveToPrevVisitedRectangleComplex() throws Exception {
        Map map = new Map();
        map.move('s');
        map.move('s');
        map.move('s');
        map.move('e');
        map.move('n');
        map.move('n');
        map.move('n');
        map.move('w');
    }
    //TODO: Figure out if I need a test case for when we move on the outroRoom or not.
}
