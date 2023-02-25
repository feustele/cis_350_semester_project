import java.util.Random;
import java.util.ArrayList;

public class Map {
    //private Room[][] map;
    private ArrayList<ArrayList<Room>> map; 

    private int[] size = {3, 1};

    private int[] start = new int[2];
    private int[] finish = new int[2];
    private int[] playerPosition = new int[2];


    private ArrayList<ArrayList<Room>> createMap() {
        return new ArrayList<ArrayList<Room>>(); 
    }

    private Room generateNewRoom() throws Exception {
        Random ran = new Random();
        int roomToGenerate = ran.nextInt(Rooms.length());
        try {
            Room room = (Room) Rooms.getItem(roomToGenerate);
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
     

    public Map() {
        
        map = createMap();
        setStart(0, 0);
        setFinish(size[0] - 1, size[1] - 1);
     
        return;
    }
    

    public ArrayList<ArrayList<Room>> getMap() {
        return map;
    }

    public void setStart(int x, int y) {
        start[0] = x; start[1] = y;
        playerPosition = start;
        return;
    }

    public void setFinish(int x, int y) {
        finish[0] = x; finish[1] = y;
        return;
    }

    public Room getRoom(int x, int y) {
        return map.get(x).get(y);
    }

    public Room moveRooms(Room currentRoom, char direction) throws Exception {
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
            room.setPlayerSpawn(direction);
            setRoom(room, newPosition);
        }
        
        playerPosition = newPosition;

        return getPlayerRoom();
    }

    public Room getPlayerRoom() {
        return map.get(playerPosition[0]).get(playerPosition[1]);
    }

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
