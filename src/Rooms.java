import java.lang.reflect.Constructor;

/**
* File folder for all Room classes. Allows easy retrieval of a certain Room class. 
* The Rooms class is a utility class that provides access to the Room classes used in the game.
*
*/
public class Rooms {
   //Stores all of the rooms that will be used by the game.
    private static Class<?>[] listOfRooms = new Class[] {
        PitLevel.class//,
        //lavaLevel.class
    };


    
    /**
     *  Returns a list of strings representing the name of all Room Classes
     * @return The list of Room classes.
     */
    public static Class<?>[] getRooms() {
        return listOfRooms;
    }
    
    /**
     * Returns the name of the Room Class stored at some index.
     *
     * @param index The index of the Room class to retrieve.
     * @return The Room class at the specified index.
     */
    public static Class<?> getRoomClass(int index) {
        for(int i = 0; i < listOfRooms.length; i++) 
            if (i == index)
                return listOfRooms[i];

        //Index is out of bounds in terms of the item list.
        return null;
    }

    /**
     * Returns a newly created instance of the class associated with the string.  
     * @param classToInitialize The Room class to create an instance of.
     * @return A new instance of the specified Room class.
     * @throws Exception If there is an error creating the new instance.
     */
    public static Object getRoom(Class<?> classToInitialize) throws Exception {
        try {
            Constructor<?> classConstructor = classToInitialize.getDeclaredConstructor();
            return classConstructor.newInstance();
            //return classType.getDeclaredConstructor().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause());
            throw new Exception("Unable to generate a new room");
        }
        
    }

    /**
     * Returns a newly created instance of the class associated with the string stored at some index
     * @param index The index of the Room class to create an instance of.
     * @return A new instance of the Room class at the specified index.
     * @throws Exception If there is an error creating the new instance.
     */
    public static Object getRoom(int index) throws Exception {
        try {
            Class<?> classToInitialize = listOfRooms[index];
            return getRoom(classToInitialize);
        } catch(Exception e) {
            throw new Exception("Unable to get a new room");
        }
        
    }

    /**
     * Determines whether the passed class is a room class or not.
     * @param potentialRoom The object to check.
     * @return True if the object is an instance of a Room class, false otherwise.
     */
    public static boolean isObjectARoom(Object potentialRoom) {
        
        for (int i = 0; i < Rooms.length(); i++) {
            if (potentialRoom.getClass().equals(listOfRooms[i])) {
                return true;
            }

        }

        return false;
    }

    /**
     * Returns the number of rooms
     * @return int
     */
    public static int length() {
        return listOfRooms.length;
    }

    /**
     * I refuse to write a javadoc for a constructor that does not have any code within it
     */
    //public Rooms() {}
}
