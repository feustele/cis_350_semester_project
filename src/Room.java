//TODO: Add setters/getters for this method.
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;

public abstract class Room {
    private int roomLimit = 5; //Limits the max size of the rooms to spawn
    private int[] playerPosition = new int[2];
    
    private boolean isRoomSquare = true; //If this is true, then square rooms will be generated. Otherwise, rectangle rooms will generate. 
    private boolean hasVisited = false; //Determines if the player has already visited this room. Will be used to prevent 

    private double itemSpawnChance = .5; //Represents a percentage that an item will spawn
    private double enemySpawnChance = .5; //Represents a percentage that an enemy will spawn.

        // private boolean hasMonster - could work the same as item spawns once we have monsters. 


    private Object[][] room; //A grid containing both items and enemies.

  
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

    private void generateRoom() {
        Random ran = new Random();

        int ranInt = ran.nextInt(roomLimit);
        int[] roomSize = new int[2];
        roomSize[0] = ranInt;

        if(!isRoomSquare) {
            ranInt = ran.nextInt(roomLimit);
        }

        roomSize[1] = ranInt;

        room = new Object[roomSize[0]][roomSize[1]];
    }

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

    private void generateEnemies() {
        Random ran = new Random();

        for(int x = 0; x < room.length; x++) {
            for (int y = 0; y < room[x].length; y++) {
                double ranDoub = ran.nextDouble();
                boolean spawn = ranDoub >= enemySpawnChance;

                if(spawn) {

                    room[x][y] = new monster(
                        "A truly terrifying, slimy Frog. It is brightly colored, so it's probably best avoided - for now.", 
                        10, 
                        x, 
                        y);

                }
            }
        }
    }


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

    public Room(int[] roomSize) {

        //Generates the number of sections within the room. 
        generateRoom(roomSize);

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        
    }
    public Room() {

        //Generates the number of sections within the room. 
        generateRoom();

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        
    }

    public void setPlayerSpawn(int[] pos) {

        playerPosition[0] = pos[0];
        playerPosition[1] = pos[1];
        return;
    }

    public void setPlayerSpawn(char direction) {
        Random ran = new Random();
        int[] pos = new int[2];
        int axisNotFilled = ran.nextInt(roomLimit);

        switch(direction) {
        case 'w':
            playerPosition[0] = 0;
            playerPosition[1] = axisNotFilled;
            break;
        case 'd':
            playerPosition[0] = axisNotFilled;
            playerPosition[1] = room[0].length;
            break;
        case 's':
            playerPosition[0] = room[0].length;
            playerPosition[1] = axisNotFilled;
            break;
        case 'a':
            playerPosition[0] = axisNotFilled;
            playerPosition[1] = 0;
            break;
        }
        
        playerPosition[0] = pos[0];
        playerPosition[1] = pos[1];
        return;
    }

    public boolean getVisited() {
        return hasVisited;
    }
    
    public void setVisited(boolean bool) {
        hasVisited = bool;
        return;
    }

    protected int[] getPlayerPosition() {
        return playerPosition;
    }

    protected int[] getSize() {
        return new int[] {room.length, room[0].length};
    }



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


    // private void spawnMonster(monster enemy, int[] pos) {

    //     room[pos[0]][pos[1]] = enemy;
    // }

    // private void spawnMonsterRandomly() {
    //     //Randomly generate a position
    //     int[] pos = new int[2];
    //     Random ran = new Random();
    //     pos[0] = ran.nextInt(room.length);
    //     pos[1] = ran.nextInt(room[0].length);
    //     spawnMonsterRandomly(pos);
    // }

    // private void spawnMonsterRandomly(int[] pos) {
    //     Random ran = new Random();
    //     int ranInt = ran.nextInt(Items.length());

    //     try {

    //         Object itemObj = Monsters.getMonster(ranInt);
    //         monster item = (monster) itemObj;

    //         spawnMonster(item, pos);
       
    //     }catch (Exception e) {
    //         System.out.println("Unable to create item... An item in 'Items' list of items likely does not correspond to an item\n");
    //     }
       
        
    // }
    // private void spawnMonsterRandomly(monster mon) {
    //     int[] pos = new int[2];
    //     Random ran = new Random();
    //     pos[0] = ran.nextInt(room.length);
    //     pos[1] = ran.nextInt(room[0].length);

    //     spawnMonster(mon, pos);
    // }


}
