import java.util.Random;
import java.util.ArrayList;

/**
 * Acts as a map, storing all the rooms within a linked list, and the player's position on the map.
 */
public class Map {
    //A 2D arrayList of Room classes, which acts as a map of the game.
    /**NOTE: The size of the row will likely differ, as you travel down the column.*/
    /**NOTE: The size of the columns will likely differ, as you travel down the row.*/ 
    private ArrayList<ArrayList<Room>> map; 

    //TODO: Archive size to better fit the 'procedural generation'
    //The size of the map
    private int[] size = {3, 1};

    //The location where the player starts at
    private int[] start = new int[2];
    //TODO: Archive this variable to better suit the procedural generation
    //The location where the player finishes at
    private int[] finish = new int[2];
    //The current position of the player in regards to the map.
    private int[] playerPosition = new int[2];


    private ArrayList<ArrayList<Room>> createMap() {
        return new ArrayList<ArrayList<Room>>(); 
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

    private void setRoom(Room room, int[] pos) {
        if(isValidPosition(pos)) {
            map.get(pos[0]).set(pos[1], room);
            return;
        }

        if(pos[0] >= map.size()) {
            ArrayList<Room> secondLayer = new ArrayList<Room>();

            while(pos[0] + 2 >= secondLayer.size())                
                secondLayer.add(null); 

            secondLayer.add(room);

            map.add(secondLayer);
        }

        if(pos[1] >= map.get(pos[0]).size()) {
            while(pos[1] + 2 >= map.get(pos[0]).size()) {
                map.get(pos[0]).add(null);
            }

            map.get(pos[0]).add(room);
        }
        
        return;
    }

    private boolean isValidPosition(int[] pos) {
        if (pos[0] < 0) 
            return false;
        if (pos[0] <= map.size()) 
            return false;
        if (pos[1] < 0) 
            return false;
        if (pos[1] <= map.size()) 
            return false;

        return true;
    }

    /**
     * Default constructor Creates a new map.
     */
    public Map() {
        
        map = createMap();
        setStart(0, 0);
        setFinish(size[0] - 1, size[1] - 1);
     
        return;
    }
    
    /**
     * Returns the map object.
     * @return ArrayList<ArrayList<Room>>
     */
    public ArrayList<ArrayList<Room>> getMap() {
        return map;
    }

    /**
     * Sets the start of the map.
     * @param x
     * @param y
     */
    public void setStart(int x, int y) {
        start[0] = x; start[1] = y;
        playerPosition = start;
        return;
    }

    /**
     * Sets the end of the map **Archived**. Do not use.
     * @param x
     * @param y
     */
    public void setFinish(int x, int y) {
        finish[0] = x; finish[1] = y;
        return;
    }

    /**
     * Gets the room at the position.
     * @param x
     * @param y
     * @return Room
     */
    public Room getRoom(int x, int y) {
        return map.get(x).get(y);
    }

    /**
     * Moves the player to the next room. Will generate the next room if the room does not already exist
     * @param currentRoom
     * @param direction
     * @return Room
     * @throws Exception
     */
    public Room moveRooms(char direction) throws Exception {
        int[] newPosition = new int[2];
        newPosition[0] = playerPosition[0];
        newPosition[1] = playerPosition[1]; 
        switch (direction) {
         case 'w':
            newPosition[1] -= 1;
            break;
         case 'd':
            newPosition[1] += 1;
            break;
         case 's':
            newPosition[0] -= 1;
            break;
         case 'a':
            newPosition[0] += 1;
            break;
        default:
            throw new Exception("Invalid parameters passed");
        }
        
        if(isValidPosition(newPosition)) {
            if (map.get(newPosition[0]).get(newPosition[1]).getVisited()) {
                throw new Exception("Room has already been visited");
            }
        }
        else {
            Room room = generateNewRoom();
            room.setPlayerPosition(direction);
            setRoom(room, newPosition);
        }
        
        playerPosition = newPosition;

        return getPlayerRoom();
    }

    /**
     * Returns the current player's room.
     * @return Room
     */
    public Room getPlayerRoom() {
        return map.get(playerPosition[0]).get(playerPosition[1]);
    }

    /**
     * Returns the current player's position
     * @return int[]
     */
    public int[] getPlayerPosition() {
        return playerPosition;
    }
    //public String monsterInteraction(){
       // if (getPlayerPosition == this.room[monster.ranX][monster.ranY]){
           // System.out.println(monster.name);
       // }
  //  }
    //if the player enters a space with a monster in it, the monster's flavor text is generated.
    //will change with combat.
}
