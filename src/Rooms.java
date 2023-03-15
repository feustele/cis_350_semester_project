import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
* File folder for all Room classes. Allows easy retrieval of a certain Room class. 
*
*/
public class Rooms {
   //Stores all of the rooms that will be used by the game.
    private static String[] listOfRooms = {
        "PitLevel",
        "lavaLevel"
    };


    
    /**
     *  Returns a list of strings representing the name of all Room Classes
     * @return String[]
     */
    public static String[] getRooms() {
        return listOfRooms;
    }
    
    /**
     * Returns the name of the Room Class stored at some index.
     * @param index
     * @return String
     */
    public static String getRoomName(int index) {
        for(int i = 0; i < listOfRooms.length; i++) 
            if (i == index)
                return listOfRooms[i];

        //Index is out of bounds in terms of the item list.
        return null;
    }

    /**
     * Returns the class associated with the string.
     * @param className
     * @return Class<?>
     * @throws ClassNotFoundException
     */
    public static Class<?> getClassType(String className) throws ClassNotFoundException {
        Class<?> classType = Class.forName(className);
        return classType;
    }

    /**
     * Returns a newly created instance of the class associated with the string.  
     * @param className
     * @return Object
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws ClassNotFoundException
     */
    public static Object getRoom(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Class<?> classType = getClassType(className);
        Constructor<?> classConstructor = classType.getDeclaredConstructor();
        return classConstructor.newInstance();
    }

    /**
     * Returns a newly created instance of the class associated with the string stored at some index
     * @param index
     * @return Object
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws ClassNotFoundException
     */
    public static Object getRoom(int index) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String name = getRoomName(index);
        return getRoom(name);
    }

    /**
     * Determines whether the passed class is a room class or not.
     * @param potentialRoom
     * @return boolean
     */
    public static boolean isObjectARoom(Object potentialRoom) {
        String name = potentialRoom.getClass().getSimpleName();
        for (int i = 0; i < Rooms.length(); i++) {
            if (name.equals(Rooms.getRoomName(i))) {
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