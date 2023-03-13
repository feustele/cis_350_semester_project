import java.util.ArrayList;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * The parent class to all rooms implemented. Holds the framework that will be used by all rooms.
 */
public abstract class Room {
    //Limits the max size of the rooms to spawn
    private int roomLimit = 5; 
    //Holds the player's position
    private int[] playerPosition = new int[2];
    //Holds the room's position
    private int[] roomPosition = new int[2];
    
    //If this is true, then square rooms will be generated. Otherwise, rectangle rooms will generate. 
    private boolean isRoomSquare = true; 
    //Determines if the player has already visited this room. Will be used to prevent 
    private boolean hasVisited = false; 

    //Represents a percentage that an item will spawn
    private double itemSpawnChance = .5; 
    //Represents a percentage that an enemy will spawn.
    private double enemySpawnChance = .5; 

        // private boolean hasMonster - could work the same as item spawns once we have monsters. 

    //A grid containing both items and enemies.
    private Object[][] room; 

  
    
    /** 
     * Generates the room by setting up the roomSize
     * @param roomSize
     */
    private void generateRoom(int[] roomSize) {
        
        if(roomSize[0] > roomLimit) {
            roomSize[0] = roomLimit;
        }

        if(roomSize[1] > roomLimit) {
            roomSize[1] = roomLimit;
        }
        if(roomSize[0] < 1) {
            roomSize[0] = 1;
        }
        if(roomSize[1] < 1) {
            roomSize[1] = 1;
        }

        room = new Object[roomSize[0]][roomSize[1]];
        return;

    }

    /**
     * Sets up the room by randomly generating the size of the room.
     * 
     */
    private void generateRoom() {
        Random ran = new Random();

        int ranInt = ran.nextInt(roomLimit) + 1;
        int[] roomSize = new int[2];
        roomSize[0] = ranInt;

        if(!isRoomSquare) {
            ranInt = ran.nextInt(roomLimit) + 1;
        }

        roomSize[1] = ranInt;

        room = new Object[roomSize[0]][roomSize[1]];
    }

    /**
     * Generates the items that should be contained within the room. 
     */
    private void generateItems() {
        Random ran = new Random();

        for(int x = 0; x < room.length; x++) {
            for (int y = 0; y < room[x].length; y++) {

                double ranDoub = ran.nextDouble();
                boolean spawn = ranDoub >= itemSpawnChance;

                if(spawn) {
                    spawnItemRandomly(new int[] {x, y});
                }
            }  
        }
    }


    /**
     * Generates the enemies that should be contained within the room.
     */
    private void generateEnemies() {
        Random ran = new Random();

        for(int x = 0; x < room.length; x++) {
            for (int y = 0; y < room[x].length; y++) {
                double ranDoub = ran.nextDouble();
                boolean spawn = ranDoub >= enemySpawnChance;

                if(spawn) {

                    spawnMonsterRandomly(new int[] {x, y});

                }
            }
        }
    }


    
    /**
     * Creates a new Room object
     * @param roomSize
     * @param roomLimit
     * @param isRoomSquare
     * @param itemSpawnChance
     * @param enemySpawnChance
     */
    public Room(int[] roomSize, int roomLimit, boolean isRoomSquare, double itemSpawnChance, double enemySpawnChance) {
        
        this.isRoomSquare = isRoomSquare;

        if(roomLimit > 0) 
            this.roomLimit = roomLimit;
        if(itemSpawnChance >= 0 ) 
            this.itemSpawnChance = itemSpawnChance;
        if(enemySpawnChance >= 0)
            this.enemySpawnChance = enemySpawnChance;

        //Generates the number of sections within the room. 
        generateRoom(roomSize);

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        
    }

    /**
     * Creates a new room class
     * @param roomSize
     */
    public Room(int[] roomSize) {

        //Generates the number of sections within the room. 
        generateRoom(roomSize);

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        
    }

    /**
     * Default constructor creates a new room class
     */
    public Room() {

        //Generates the number of sections within the room. 
        generateRoom();

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        
    }

    /**
     * Sets the player's position. Should only be used when they enter the room. 
     * @param pos
     */
    public void setPlayerPosition(int[] pos) {

        playerPosition[0] = pos[0];
        playerPosition[1] = pos[1];
        return;
    }

    /**
     * Sets the player's position, but only adapting one axis of the position. 
     * Should only be used when the player enter a room from a certain direction
     * @param direction
     */
    public void setPlayerPosition(char direction) {
        Random ran = new Random();

        /**Do not be surprised if I have mixed up my columns of room.*/
        switch(direction) {
        case 'n':
            playerPosition[0] = 0;
            playerPosition[1] = ran.nextInt(room[playerPosition[0]].length);
            break;
        case 'e':
            playerPosition[0] = ran.nextInt(room.length);
            playerPosition[1] = room[0].length - 1;
            break;
        case 's':
            playerPosition[0] = room[0].length - 1;
            playerPosition[1] = ran.nextInt(room[playerPosition[0]].length);

            break;
        case 'w':
            playerPosition[0] = ran.nextInt(room.length);
            playerPosition[1] = 0;
            break;
        }

        return;
    }

    /**
     * Sets the Room's global position along the map to the position passed.
     * @param position
     * @throws Exception
     */
    public void setRoomPosition(int[] position) throws Exception {
        if (position.length != 2) {
            throw new Exception("Room position must be of length 2");
        }

        roomPosition[0] = position[0];
        roomPosition[1] = position[1];
    }

    /**
     * 
     * @return int[]
     */
    public int[] getRoomPosition() {
        return roomPosition;
    }
    /**
     * Returns whether the player has visited this room or not.
     * @return
     */
    public boolean getVisited() {
        return hasVisited;
    }


    /**
     * Sets the variable storing whether the player has visited this room or not. 
     * @param bool
     */
    public void setVisited(boolean bool) {
        hasVisited = bool;
        return;
    }

    /**
     * Returns the positons of all of the enemies stored within an ArrayList.
     * @return ArrayList<int[]>
     */
    public ArrayList<int[]> getEnemyPosition() {

        ArrayList<int[]> EnemyPositions = new ArrayList<int[]>();
        
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                int[] pos = {i, j};

                if(isMonster(pos)) {
                    EnemyPositions.add(pos);
                }
               
            }
        }
        return EnemyPositions;
    }
    /**
     * Returns the player's current position
     * @return
     */
    protected int[] getPlayerPosition() {
        return playerPosition;
    }

    /**
     * Returns the size of the room
     * @return
     */
    protected int[] getSize() {
        if (room.length <= 0 ) {
            return new int[] {0, 0};
        }

        return new int[] {room.length, room[0].length};
    }


    private boolean isMonster(int[] pos) {

        if (room[pos[0]][pos[1]] == null) {
            return false;
        }

        if(!Monsters.isObjectAEnemy(room[pos[0]][pos[1]])) {
            return false;
        }
        return true;
    }

    /**
     * Adds the provided item to the Room at the given position.
     * @param item
     * @param pos
     */
    private void spawnItem(Item item, int[] pos) {

        room[pos[0]][pos[1]] = item;

    }
    
    private void spawnItemRandomly() {
        //Randomly generate a position
        int[] pos = new int[2];
        Random ran = new Random();
        pos[0] = ran.nextInt(room.length);
        pos[1] = ran.nextInt(room[0].length);
        spawnItemRandomly(pos);
    }

    private void spawnItemRandomly(int[] pos) {
        Random ran = new Random();
        int ranInt = ran.nextInt(Items.length());

        try {

            Object itemObj = Items.getItem(ranInt);
            Item item = (Item) itemObj;

            spawnItem(item, pos);
       
        }catch (Exception e) {
            System.out.println("Unable to create item... An item in 'Items' list of items likely does not correspond to an item\n");
        }    
    }

    private void spawnItemRandomly(Item item) {
        int[] pos = new int[2];
        Random ran = new Random();
        pos[0] = ran.nextInt(room.length);
        pos[1] = ran.nextInt(room[0].length);

        spawnItem(item, pos);
    }


    private void spawnMonster(Monster enemy, int[] pos) {

        room[pos[0]][pos[1]] = enemy;
    }

    private void spawnMonsterRandomly() {
        //Randomly generate a position
        int[] pos = new int[2];
        Random ran = new Random();
        pos[0] = ran.nextInt(room.length);
        pos[1] = ran.nextInt(room[0].length);
        spawnMonsterRandomly(pos);
    }

    private void spawnMonsterRandomly(int[] pos) {
        Random ran = new Random();
        int ranInt = ran.nextInt(Items.length());

        try {

            Object itemObj = Monsters.getMonster(ranInt);
            Monster item = (Monster) itemObj;

            spawnMonster(item, pos);
       
        }catch (Exception e) {
            System.out.println("Unable to create item... An item in 'Items' list of items likely does not correspond to an item\n");
        }
       
        
    }
    private void spawnMonsterRandomly(Monster mon) {
        int[] pos = new int[2];
        Random ran = new Random();
        pos[0] = ran.nextInt(room.length);
        pos[1] = ran.nextInt(room[0].length);

        spawnMonster(mon, pos);
    }


     

}
