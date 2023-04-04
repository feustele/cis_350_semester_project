import java.util.ArrayList;
import java.util.Random;
import java.security.InvalidParameterException;

/**
 * The parent class to all rooms implemented. Holds the framework that will be used by all rooms.
 */
public abstract class Room implements RoomInterface {
    //Limits the max size of the rooms to spawn
    protected int roomLimit = 5; 
    //Holds the player's position
    protected int[] playerPosition = new int[2];
    //Holds the room's position
    protected int[] roomPosition = new int[2];
    
    //If this is true, then square rooms will be generated. Otherwise, rectangle rooms will generate. 
    protected boolean isRoomSquare = true; 
    //Determines if the player has already visited this room. Will be used to prevent 
    protected boolean hasVisited = false; 

    //Represents a percentage that an item will spawn
    //protected double itemSpawnChance = .5; 
    //Represents a percentage that an monster will spawn in a square of the room.
    protected double monsterSpawnChance = .1; 

    //A grid containing enemies.
    protected Object[][] room; 
    

    /** 
     * Generates the room by setting up the roomSize
     * @param roomSize
     */
    protected void generateRoom(int[] roomSize) {
        if(roomSize.length != 2) {
            throw new InvalidParameterException();
        }

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
        
        //Generate enemies
        generateEnemies();
        return;

    }

    /**
     * Sets up the room by randomly generating the size of the room.
     * 
     */
    protected void generateRoom() {
        Random ran = new Random();

        int ranInt = ran.nextInt(roomLimit) + 1;
        int[] roomSize = new int[2];
        roomSize[0] = ranInt;

        if(!isRoomSquare) {
            ranInt = ran.nextInt(roomLimit) + 1;
        }

        roomSize[1] = ranInt;

        room = new Object[roomSize[0]][roomSize[1]];

        //Generate items in the room
        //generateItems();
        
        //Generate enemies
        generateEnemies();
    }

    /**
     * Generates the items that should be contained within the room. 
     */
    // protected void generateItems() {
    //     Random ran = new Random();

    //     for(int x = 0; x < room.length; x++) {
    //         for (int y = 0; y < room[x].length; y++) {

    //             double ranDoub = ran.nextDouble();
    //             boolean spawn = ranDoub >= itemSpawnChance;

    //             if(spawn) {
    //                 spawnItemRandomly(new int[] {x, y});
    //             }
    //         }  
    //     }
    // }


    /**
     * Generates the enemies that should be contained within the room.
     */
    protected void generateEnemies() {
        Random ran = new Random();

        for(int x = 0; x < room.length; x++) {
            for (int y = 0; y < room[x].length; y++) {
                room[x][y] = null;

                double ranDoub = ran.nextDouble();
                boolean spawn = ranDoub >= monsterSpawnChance;

                if(spawn) {

                    spawnMonsterRandomly(new int[] {x, y});

                }
            }
        }
    }

    /**
     * Checks if the given position is valid.
     *
     * @param position an array of two integers representing the position to be checked
     * @return true if the position is valid, false otherwise
     * @throws InvalidParameterException if the position array does not contain exactly two elements
     */
    protected boolean isPositionValid(int[] position) {
        if (position.length != 2) {
            throw new InvalidParameterException();
        }  

        if (position[0] < 0 || position[1] < 0) {
            return false;
        }

        if(position[0] >= getSize()[0] || position[1] >= getSize()[1]) {
            return false;
        }


        return true;
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
        // if(itemSpawnChance >= 0 ) 
        //     this.itemSpawnChance = itemSpawnChance;
        // if(enemySpawnChance >= 0)
        //     this.enemySpawnChance = enemySpawnChance;

        //Generates the number of sections, enemies, and items within the room.
        generateRoom(roomSize);

       
        
    }

    /**
     * Creates a new room class
     * @param roomSize
     */
    public Room(int[] roomSize) {

        //Generates the number of sections within the room. 
        generateRoom(roomSize);

        //Generate items in the room
        //generateItems();
        
        //Generate enemies
        
    }

    /**
     * Default constructor creates a new room class
     */
    public Room() {

        //Generates the number of sections within the room. 
        generateRoom();

        //Generate items in the room
        //generateItems();
        
        //Generate enemies
        
    }

    /**
     * Moves the player in a given direction.
     * @param d The direction to move the player in ('n' for north, 'e' for east, 's' for south, 'w' for west).
     * @throws IndexOutOfBoundsException If the player attempts to move outside the game board boundaries.
     * @throws InvalidParameterException If the direction parameter is not a valid character ('n', 'e', 's', or 'w').
     */
    public void movePlayer(char d) {
        switch(d) {
        case 'n':
            if(playerPosition[0] < 0) 
                return;    
                //throw new IndexOutOfBoundsException();
            if(playerPosition[1] <= 0)
                throw new IndexOutOfBoundsException();
            if(playerPosition[0] > getSize()[0] - 1 || playerPosition[1] > getSize()[1] - 1)
                return;
            
            playerPosition[1] -= 1;
            break;
        case 'e':
            if(playerPosition[0] >= getSize()[0] - 1) 
                throw new IndexOutOfBoundsException();
            if(playerPosition[0] < 0 )
                return;
            if(playerPosition[1] < 0 || playerPosition[1] > getSize()[1] - 1)
                return;

            playerPosition[0] += 1;
            break;
        case 's':
            if(playerPosition[0] < 0 || playerPosition[0] > getSize()[0] - 1) 
                return;
            if(playerPosition[1] < 0)
                return;
            if(playerPosition[1] >= getSize()[1] - 1)
                throw new IndexOutOfBoundsException();

            playerPosition[1] += 1;
            break;
        case 'w':
            if(playerPosition[0] <= 0) 
                throw new IndexOutOfBoundsException();
            if(playerPosition[0] > getSize()[0] - 1) 
                return;
            if(playerPosition[1] < 0 || playerPosition[1] > getSize()[1] - 1)
                return;

            playerPosition[0] -= 1;
            break;

        default:
            throw new InvalidParameterException();
        }
        
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
     */
    public void setRoomPosition(int[] position) {
        if (position.length != 2) {
            return;
        }

        roomPosition[0] = position[0];
        roomPosition[1] = position[1];
    }

    public void setMonsterSpawnChance(double monsterSpawnChance) {
        this.monsterSpawnChance = monsterSpawnChance;
        generateEnemies();
        return;
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
     * 
     * @return
     */

    // public Monster[] getMonsters() {

    // Monster[] monsters = new Monster[getEnemyPosition().size()]
    // } 


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
        return new int[] {room.length, room[0].length};
    }

    /**
     * Determines whether the object at the given position is a monster or not.
     *
     * @param pos the position to check, represented as an array of two integers
     * @return true if the object at the given position is a monster, false otherwise
     */
    private boolean isMonster(int[] pos) {
       
        // If the room at the given position is null, there can be no monster
        if (room[pos[0]][pos[1]] == null) {
            return false;
        }
        // If the object at the given position is not an enemy, it is not a monster
        if(!Monsters.isObjectAEnemy(room[pos[0]][pos[1]])) {
            return false;
        }
        
        // Otherwise, the object is a monster
        return true;
    }

    /**
     * Adds the provided item to the Room at the given position.
     * @param item
     * @param pos
     */
    // private void spawnItem(Item item, int[] pos) {

    //     room[pos[0]][pos[1]] = item;

    // }
    
    // /**
    //  *Spawn a random item at a random position in the room
    //  */
    // private void spawnItemRandomly() {
    //     //Randomly generate a position
    //     int[] pos = new int[2];
    //     Random ran = new Random();
    //     pos[0] = ran.nextInt(room.length);
    //     pos[1] = ran.nextInt(room[0].length);
    //     spawnItemRandomly(pos);
    // }

    // /**
    //  *Spawn an item at the specified position
    //  *@param pos the position where the item should be spawned
    //  */
    // private void spawnItemRandomly(int[] pos) {
    //     Random ran = new Random();
    //     int ranInt = ran.nextInt(Items.length());

    //     Object itemObj;
    //     try {
    //         itemObj = Items.getItem(ranInt);
    //         Item item = (Item) itemObj;

    //         spawnItem(item, pos);
    //     } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
    //             | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
       
    //         //System.out.println("Unable to create item... An item in 'Items' list of items likely does not correspond to an item\n");
        
    // }
    
    // /**
    //  *Spawn the specified item at a random position in the room
    //  *@param item the item to be spawned
    //  */
    // private void spawnItemRandomly(Item item) {
    //     int[] pos = new int[2];
    //     Random ran = new Random();
    //     pos[0] = ran.nextInt(room.length);
    //     pos[1] = ran.nextInt(room[0].length);

    //     spawnItem(item, pos);
    // }

    // /**
    //  *Spawn the specified monster at the specified position in the room
    //  *@param enemy the monster to be spawned
    //  *@param pos the position where the monster should be spawned
    //  */
    private void spawnMonster(Monster enemy, int[] pos) {

        room[pos[0]][pos[1]] = enemy;
    }

    /**
     *Spawn a random monster at a random position in the room
     */
    // private void spawnMonsterRandomly() {
    //     //Randomly generate a position
    //     int[] pos = new int[2];
    //     Random ran = new Random();
    //     pos[0] = ran.nextInt(room.length);
    //     pos[1] = ran.nextInt(room[0].length);
    //     spawnMonsterRandomly(pos);
    // }
    
    /**
     *Spawn a monster at the specified position in the room
     *@param pos the position where the monster should be spawned
     */
    private void spawnMonsterRandomly(int[] pos) {
        Random ran = new Random();
        int ranInt = ran.nextInt(Items.length());

        try {

            Object itemObj = Monsters.getMonster(ranInt);
            Monster item = (Monster) itemObj;

            spawnMonster(item, pos);
       
        }catch (Exception e) {
            System.out.println("Unable to create a monster... An monster in 'Monsters' list of monsters likely does not correspond to an Monster\n");
        }
    }
   
    /**
     *Spawn the specified monster at a random position in the room
     *@param mon the monster to be spawned
     */
    public void spawnMonsterRandomly(Monster mon) {
        int[] pos = new int[2];
        Random ran = new Random();
        pos[0] = ran.nextInt(room.length);
        pos[1] = ran.nextInt(room[0].length);

        spawnMonster(mon, pos);
    }


     

}
