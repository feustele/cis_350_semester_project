import java.lang.reflect.InvocationTargetException;

/**
 * File folder for all Items classes. Allows easy retrieval of a certain Item class. 
 */
public class Items{
   //Lists all items within the game
    private static String[] listOfItems = {
        //Stat boosting items 
        "ExperienceRing", 

        //Quest items
        "MysteriousAmulet",

        //Misc
        "CommandList" //has list of commands player can do in game
    };


    
    /** 
     * Returns a list of strings representing the name of all Item classes
     * @return String[]
     */
    public static String[] getItems() {
        return listOfItems;
    }

    /**
     * Returns the name of the Room Class stored at some index.
     * @param index
     * @return
     */
    public static String getItemName(int index) {
        for(int i = 0; i < listOfItems.length; i++) 
            if (i == index)
                return listOfItems[i];
        

        //Index is out of bounds in terms of the item list.
        return null;
    }

    /**
     * Returns the class associated with the string.
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    private static Class<?> getClassType(String className) throws ClassNotFoundException {
        Class<?> classType = Class.forName(className);
        return classType;
    }

    /**
     * Returns a newly created instance of the class associated with the string.
     * @param className
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws ClassNotFoundException
     */
    public static Object getItem(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
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
    public static Object getItem(int index) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String name = getItemName(index);
        return getItem(name);
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
