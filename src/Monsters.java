import java.lang.reflect.InvocationTargetException;

/**
* File folder for all Monster classes. Allows easy retrieval of a certain Monster class. 
 */
public class Monsters {
    //All of the monsters that can be found within the project
    private static String[] listOfMonsters = {
        "Frog",
        "Snake",
        "Zombie"
    };


    
    /** 
     *  Returns a list of strings representing the name of all Monster Classes
     * @return String[]
     */
    public static String[] getMonsters() {
        return listOfMonsters;
    }
    
    /**
     * Returns the name of the Room Class stored at some index.
     * @param index
     * @return String
     */
    public static String getMonsterName(int index) {
        for(int i = 0; i < listOfMonsters.length; i++) 
            if (i == index)
                return listOfMonsters[i];

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
    public static Object getMonster(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Class<?> classType = getClassType(className);
        return classType.getDeclaredConstructor().newInstance();
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
    public static Object getMonster(int index) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String name = getMonsterName(index);
        return getMonster(name);
    }


    /**
     * Determines whether the passed class is a enemey class or not.
     * @param potentialEnemey
     * @return boolean
     */
    public static boolean isObjectAEnemy(Object potentialEnemey) {
        String name = (potentialEnemey).getClass().getSimpleName();
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
        return listOfMonsters.length;
    }

    //I can use public static Class<T> forName(String className) throws ClassNotFoundException

    //public Monsters() {}
}
