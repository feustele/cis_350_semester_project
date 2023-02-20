public class Map {
    private Room[][] map;

    private int[] size = {3, 1};

    private int[] start = new int[2];
    private int[] finish = new int[2];
    private int[] playerPosition = new int[2];


    private Room[][] createMap() {
        return new Room[size[0]][size[1]]; //Does this fill?
    }

     

    public Map() {
        
        map = createMap();
        setStart(0, 0);
        setFinish(size[0] - 1, size[1] - 1);
     
        return;
    }
    

    public Room[][] getMap() {
        return map;
    }


    public void setRoom(int x, int y, Room room) {
        map[x][y] = room;
        return;
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
        return map[x][y];
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
        
        if (map[newPosition[0]][newPosition[1]].getVisited()) {
            throw new Exception("Room has already been visited");
        }
       
        playerPosition = newPosition;

        return getPlayerRoom();
    }


    public Room getPlayerRoom() {
        return map[playerPosition[0]][playerPosition[1]];
    }

    public int[] getPlayerPosition() {
        return playerPosition;
    }
}
