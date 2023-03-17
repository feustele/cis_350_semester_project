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
    private introLevel start;
    
    //The current position of the player in regards to the map.
    private Room playerRoom;

    private introLevel createintroLevel() {
        int[] position = {0, 0};
        introLevel intro = new introLevel();
        intro.setRoomPosition(position);
        return intro;
    }

    private ArrayList<Room> createMap() {
        ArrayList<Room> tempMap = new ArrayList<Room>(); 
        tempMap.add(createintroLevel());
        return tempMap; 
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

    private Room createOutroRoom() {
        return new outroLevel();
    }

    private Room tryCreatingOutro(Player player) {
        ArrayList<Item> inv = player.openInventory();

        /**
         * Determines if the player contains a 'quest item'. 
         * Currently, the only quest item is the MysteriousAmulet
         */
        for (int i = 0; i < inv.size(); i++) {
            Item item = inv.get(i);
            if(QuestItem.class.isAssignableFrom(item.getClass())) {
                return createOutroRoom();
            }
        }
        
        return null;
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
        start = (introLevel) map.get(0);
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
     * Moves the player to the exit.
     * @return Room
     */
    public Room moveRooms() {
        boolean debounce = false;

        if (debounce) {
            return null;
        }

        Room outro = createOutroRoom();
        map.add(outro);
        playerRoom = outro;
        return outro;
    }

    /**
     * Moves the player to the next room. Will generate the next room if the room does not already exist
     * @param currentRoom
     * @param direction
     * @return Room
     * @throws Exception
     */
    public Room moveRooms(char direction, Player player) throws Exception {
        
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
            throw new Exception("Invalid parameters passed");
        }
        
        if(hasVisitedPosition(position)) {
            throw new Exception("Room has already been visited");
            
        }

        Room room = tryCreatingOutro(player);
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
