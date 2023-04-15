package projectSane;
import java.util.Random;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Acts as a map, storing all the rooms within a linked list, and the player's position on the map.
 */
public class Map {
    /**
     *An arrayList of Room classes, which stores the order of rooms that are visited, with the tail 
     *being the current position.
     */
    private ArrayList<Room> map; 

    //The location where the player starts at
    private introLevel start;
    
    //The current position of the player in regards to the map.
    private Room playerRoom;

    /**
     * Creates the intro level of the map.
     * @return introLevel
     */
    private introLevel createintroLevel() {
        int[] position = {0, 0};
        introLevel intro = new introLevel();
        intro.setRoomPosition(position);
        return intro;
    }

    /**
     * Creates a new ArrayList object that contains the introLevel object.
     * @return ArrayList<Room>
     */
    private ArrayList<Room> createMap() {
        ArrayList<Room> tempMap = new ArrayList<Room>(); 
        tempMap.add(createintroLevel());
        return tempMap; 
    }

    /**
     * Returns the Room object at a given position on the map.
     * @param position The position of the Room object to return.
     * @return Room
     */
    private Room getRoom(int position) {
        
        if (position < 0) {
            return null;
        }
        if(position >= getMapSize()) {
            return null;
        }
        
        return map.get(position);

    }
    
    /**
     * Creates the outro level of the map.
     * @return Room
     */
    private Room createOutroRoom() {
        return new outroLevel();
    }

    /**
     * Attempts to create the outro level of the map, if enough rooms have passed
     * @return Room
     */
    private Room tryCreatingOutro() {
        
        if(getMapSize() > 5) {
            Room outroRoom = createOutroRoom(); 
            playerRoom = outroRoom;
            return outroRoom;
        }
        
        return null;
    }

    
    /**
     * Generates a new Room object at random.
     * @return Room
     * @throws Exception
     */
    private Room generateNewRoom() throws Exception {
        Random ran = new Random();
        int roomToGenerate = ran.nextInt(Rooms.length());
        try {
            Room room = (Room) Rooms.getRoom(roomToGenerate);
            playerRoom = room;
            return room;
        } catch (Exception e) {
            throw new Exception("Unable to generate a new room");
        }
    }

    /**
     * Moves the player to the next room. Will generate the next room if the room does not already exist
     * @param currentRoom
     * @param direction
     * @return Room
     * @throws Exception
     */
    private Room moveRooms(char direction) throws Exception {
        int[] oldPosition = playerRoom.getRoomPosition();
        /**Creates a hard copy of oldPosition */
        int[] position = {oldPosition[0], oldPosition[1]};

        switch (direction) {
         case 'n':
            position[1] -= 1;
            break;
         case 'e':
            position[0] += 1;
            break;
         case 's':
            position[1] += 1;
            break;
         case 'w':
            position[0] -= 1;
            break;
         default:
            throw new InvalidParameterException();
        }
        
        if(hasVisitedPosition(position)) {
            System.out.println("This room has already been visited");
            throw new Exception("Room has already been visited");
        }

        Room room = tryCreatingOutro();
        if (room == null) {
            room = generateNewRoom();
        }

        
        room.setPlayerPosition(direction);
        room.setRoomPosition(position);
        map.add(room);
        playerRoom = room;
        
        return getPlayerRoom();
    }


    /**
     * Checks if a given position on the map has already been visited.
     * @param position The position to check.
     * @return boolean
     */
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
        start = (introLevel) map.get(0);
        playerRoom = start;

        return;
    }
    
    /**
     * Returns the ArrayList object containing all the Room objects.
     * @return ArrayList<ArrayList<Room>>
     */
    public ArrayList<Room> getMap() {
        return map;
    }

    
    /**
     * Moves the player in the direction. 
     * If the player is no longer able to explore the room in that direction, 
     * it will generate the next room for the player to explore. 
     * @param d
     * @throws Exception
     */
    public void move(char d) throws Exception {
        if(!(
                d == 'n' ||
                d == 'e' || 
                d == 's' || 
                d == 'w')) 
            return;
        
        try {
            playerRoom.movePlayer(d);
        } catch (IndexOutOfBoundsException e) {
           
            moveRooms(d);
        }
    }
    

    /**
     * Returns the current player's room.
     * @return Room
     */
    public Room getPlayerRoom() {
        return playerRoom;
    }

    /**
     * Returns the number of elements visited
     * @return int
     */
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
