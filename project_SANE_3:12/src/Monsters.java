import java.lang.reflect.InvocationTargetException;

/**
* File folder for all Monster classes. Allows easy retrieval of a certain Monster class. 
 */
public class Monsters {
    //All of the monsters that can be found within the project
    private static Class<?>[] listOfMonsters = new Class<?>[]{
        Frog.class,
        Snake.class,
        Zombie.class
    };


    
    /** 
     *  Returns a list of strings representing the name of all Monster Classes
     * @return Class<?>[]
     */
    public static Class<?>[] getMonsters() {
        return listOfMonsters;
    }
    
    /**
     * Returns the name of the Room Class stored at some index.
     * @param index
     * @return Class<?>
     */
    public static Class<?> getMonsterClass(int index) {
        for(int i = 0; i < listOfMonsters.length; i++) 
            if (i == index)
                return listOfMonsters[i];

        //Index is out of bounds in terms of the item list.
        return null;
    }

    /**
     * Returns a newly created instance of the class associated with the string.  
     * @param classToInitialize
     * @return Object
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws ClassNotFoundException
     */
    public static Object getMonster(Class<?>  classToInitialize) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        return classToInitialize.getDeclaredConstructor().newInstance();
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
        Class<?> classToInitialize = listOfMonsters[index];
        return getMonster(classToInitialize);
    }


    /**
     * Determines whether the passed class is a enemey class or not.
     * @param potentialEnemy
     * @return boolean
     */
    public static boolean isObjectAEnemy(Object potentialEnemy) {
        for (int i = 0; i < Rooms.length(); i++) {
            if (potentialEnemy.getClass().equals(listOfMonsters[i])) {
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
