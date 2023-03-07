import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Acts as a map, storing all the rooms within a linked list, and the player's position on the map.
 */
public class Map {
    /**An arrayList of Room classes, which stores the order of rooms that are visited, with the tail 
    being the current position.
    */
    /**NOTE: The size of the row will likely differ, as you travel down the column.*/
    /**NOTE: The size of the columns will likely differ, as you travel down the row.*/ 
    private ArrayList<Room> map; 

    //The location where the player starts at
    private introRoom start;
    
    //The current position of the player in regards to the map.
    private Room playerRoom;


    private ArrayList<Room> createMap() {
        return new ArrayList<Room>(); 
    }

    private Room getRoom(int position) {
        if (position < 0) {
            return null;
        }
        if(position >= getMapSize()) {
            return null;
        }
        
        return map.get(position);

    }

    private Room generateNewRoom() throws Exception {
        Random ran = new Random();
        int roomToGenerate = ran.nextInt(Rooms.length());
        try {
            Room room = (Room) Rooms.getRoom(roomToGenerate);
            return room;
        } catch (Exception e) {
            throw new Exception("Unable to generate a new room");
        }
    }


    private boolean hasVisitedPosition(int[] position) {
        for (int i = 0; i < getMapSize(); i++) {
            if(Arrays.equals(getRoom(i).getRoomPosition(), position)) {
                return true;
            }
        }

        return false;
    }


    /**
     * Default constructor Creates a new map.
     */
    public Map() {
        
        map = createMap();
        start = new introRoom();
        playerRoom = start;

        return;
    }
    
    /**
     * Returns the map object.
     * @return ArrayList<ArrayList<Room>>
     */
    public ArrayList<Room> getMap() {
        return map;
    }

    /**
     * Moves the player to the next room. Will generate the next room if the room does not already exist
     * @param currentRoom
     * @param direction
     * @return Room
     * @throws Exception
     */
    public Room moveRooms(char direction) throws Exception {
        int[] oldPosition = playerRoom.getRoomPosition();
        /**Creates a hard copy of oldPosition */
        int[] position = {oldPosition[0], oldPosition[1]};

        switch (direction) {
         case 'w':
            position[1] -= 1;
            break;
         case 'd':
            position[1] += 1;
            break;
         case 's':
            position[0] -= 1;
            break;
         case 'a':
            position[0] += 1;
            break;
        default:
            throw new Exception("Invalid parameters passed");
        }
        
        if(hasVisitedPosition(position)) {
            throw new Exception("Room has already been visited");
            
        }
        
        Room room = generateNewRoom();
        room.setPlayerPosition(direction);
        room.setRoomPosition(position);
        playerRoom = room;
        
        
        return getPlayerRoom();
    }

    /**
     * Returns the current player's room.
     * @return Room
     */
    public Room getPlayerRoom() {
        return playerRoom;
    }

    public int getMapSize() {
        return map.size();
    }

    //public String monsterInteraction(){
       // if (getPlayerPosition == this.room[monster.ranX][monster.ranY]){
           // System.out.println(monster.name);
       // }
  //  }
    //if the player enters a space with a monster in it, the monster's flavor text is generated.
    //will change with combat.
}
