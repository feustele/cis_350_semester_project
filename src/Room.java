import java.util.Random;

public class Room {
    private static int ROOM_LIMIT = 5; //Limits the max size of the rooms to spawn
    private static boolean IS_ROOM_SQUARE = true; //If this is true, then square rooms will be generated. Otherwise, rectangle rooms will generate. 
    private static double ITEM_SPAWN_CHANCE = .5; //Represents a percentage that an item will spawn


    private boolean hasVisited = false; //Determines if the player has already visited this room. Will be used to prevent 
    private int[] roomSize = new int[2];

    private void generateRoom() {
        Random ran = new Random();
        int ranInt = ran.nextInt(ROOM_LIMIT);
        roomSize[0] = ranInt;

        if(!IS_ROOM_SQUARE) {
            ranInt = ran.nextInt(ROOM_LIMIT);
        }

        roomSize[1] = ranInt;

    }

    private void generateItems() {
        //We need to somehow store all the items, so we know what are the actual items that we can generate.

        
    }

    private void generateEnemies() {

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

    
}
