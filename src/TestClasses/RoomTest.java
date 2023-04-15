package TestClasses;
import org.junit.Test;
import static org.junit.Assert.*;
import projectSane.*;
import projectSane.Room;

public class RoomTest {
    @Test
    public void SetPlayerNorth() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('n');
        System.out.println(room.getSize()[0] -1);
        assertEquals(room.getSize()[0] - 1, room.getPlayerPosition()[1]);
    }  
    @Test
    public void SetPlayerSouth() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('s');
        assertEquals(0, room.getPlayerPosition()[1]);

    }  
    @Test
    public void SetPlayerEast() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('e');
        assertEquals(0, room.getPlayerPosition()[0]);

    }  
    @Test
    public void SetPlayerWest() {
        PitLevel room = new PitLevel();
        room.setPlayerPosition('w');
        assertEquals(room.getSize()[1] - 1, room.getPlayerPosition()[0]);

    }  

    @Test
    public void SetRoomPosition() {
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
    public void SetRoomPositionInvalidLarger() throws Exception {
        int[] pos = {5, 3, 4};
        PitLevel room = new PitLevel();
        room.setRoomPosition(pos);
        
    }
    @Test(expected = Exception.class)
    public void SetRoomPositionInvalidSmaller() throws Exception {
        int[] pos = {5};
        PitLevel room = new PitLevel();
        room.setRoomPosition(pos);
        assertEquals(pos[0], room.getRoomPosition()[0]);
        assertEquals(pos[1], room.getRoomPosition()[0]);
    }

    @Test
    public void MovePlayerNorth() {
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
    public void MovePlayerSouth() {
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
    public void MovePlayerEast() {
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
    public void MovePlayerWest() {
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
    public void SetPlayerNorthInvalid1() {
        int[] pos = {0,0};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SetPlayerNorthInvalid2() {
        int[] pos = {1,0};
        Room room = new PitLevel();
        room.setPlayerPosition(pos);
        room.movePlayer('n');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SetPlayerSouthInvalid1() {
        Room room = new PitLevel();
        int[] pos = {0, room.getSize()[1]};

        room.setPlayerPosition(pos);
        room.movePlayer('s');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SetPlayerSouthInvalid2() {
        Room room = new PitLevel();
        int[] pos = {1, room.getSize()[1]};
        room.setPlayerPosition(pos);
        room.movePlayer('s');
    }
    @Test
    public void NoEnemySpawns() {
        for(int i = 0; i < 10; i++) {
            Room room = new PitLevel();
            room.setMonsterSpawnChance(0);
    
            assertEquals(0, room.getEnemyPosition().size());
        }
        
    }
    @Test
    public void AllEnemySpawns() {
        for(int i = 0; i < 10; i++) {
            Room room = new PitLevel();
            room.setMonsterSpawnChance(1);

            assertEquals(room.getSize()[0] * room.getSize()[1], room.getEnemyPosition().size());
        }
    }

    public static void main(String args[]) {
        Room room = new PitLevel();
        room.setMonsterSpawnChance(1);
        room.getEnemyPosition();
    }
    
}
