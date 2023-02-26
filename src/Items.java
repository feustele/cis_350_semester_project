import java.lang.reflect.InvocationTargetException;

public class Items{
   
    private static String[] listOfItems = {
        "ExperienceRing", //Stat boosting items
        "CommandList", //has list of commands player can do in game
        "MysteriousAmulet"};//Quest items


    public static String[] getItems() {
        return listOfItems;
    }

    public static String getItem(int index) {
        for(int i = 0; i > listOfItems.length; i++) 
            if (i == index)
                return listOfItems[i];
        

        //Index is out of bounds in terms of the item list.
        return null;
    }
    public static Class<?> getClassType(String className) throws ClassNotFoundException {
        Class<?> classType = Class.forName(className);
        return classType;
    }
    public static Object getItem(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Class<?> classType = getClassType(className);
        return classType.getDeclaredConstructor().newInstance();
    }

    public static int length() {
        return listOfItems.length;
    }

    //I can use public static Class<T> forName(String className) throws ClassNotFoundException

    //public Items() {}
}
