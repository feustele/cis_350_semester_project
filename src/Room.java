//TODO: Add setters/getters for this method.
import java.util.Random;

public abstract class Room {
    private int roomLimit = 5; //Limits the max size of the rooms to spawn
    private int[][] room;
    
    private boolean isRoomSquare = true; //If this is true, then square rooms will be generated. Otherwise, rectangle rooms will generate. 
    private boolean hasVisited = false; //Determines if the player has already visited this room. Will be used to prevent 

    private double itemSpawnChance = .5; //Represents a percentage that an item will spawn


    private void generateRoom() {
        Random ran = new Random();
        int ranInt = ran.nextInt(roomLimit);
        int[] roomSize = new int[2];
        roomSize[0] = ranInt;

        if(!isRoomSquare) {
            ranInt = ran.nextInt(roomLimit);
        }

        roomSize[1] = ranInt;

        room = new int[roomSize[0]][roomSize[1]];
    }

    private void generateItems() {
        //We need to somehow store all the items, so we know what are the actual items that we can generate.

        
    }

    private void generateEnemies() {

    }



    public Room(int roomLimit, boolean isRoomSquare, double itemSpawnChance) {

        //Generates the number of sections within the room. 
        generateRoom();

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        this.roomLimit = roomLimit;
        this.isRoomSquare = isRoomSquare;
        this.itemSpawnChance = itemSpawnChance;
    }

    public Room() {

        //Generates the number of sections within the room. 
        generateRoom();

        //Generate items in the room
        generateItems();
        
        //Generate enemies
        generateEnemies();
        
    }

    public boolean getVisited() {
        return hasVisited;
    }
    
    public void setVisited(boolean bool) {
        hasVisited = bool;
        return;
    }

    protected int[] getSize() {
        int[] length = {room.length, room[0].length};
        return length;
        //return {room.length, room[0].length};
    }

    
}
