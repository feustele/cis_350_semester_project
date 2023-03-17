import java.lang.reflect.InvocationTargetException;

/**
 * File folder for all Items classes. Allows easy retrieval of a certain Item class. 
 */
public class Items{
   //Lists all items within the game
    private static Class<?>[] listOfItems = new Class[] {
        //Stat boosting items 
        ExperienceRing.class, 

        //Quest items
        MysteriousAmulet.class

        //Misc
        //"CommandList" //has list of commands player can do in game
    };


    
    /** 
     * Returns a list of strings representing the name of all Item classes
     * @return Class<?>[]
     */
    public static Class<?>[] getItems() {
        return listOfItems;
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
    public static Object getItem(Class<?> classToInitialize) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
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
    public static Object getItem(int index) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Class<?> classToInitialize = listOfItems[index];
        return getItem(classToInitialize);
    }

    /**
     * Returns the number of items
     * @return
     */
    public static int length() {
        return listOfItems.length;
    }


    //public Items() {}
}
