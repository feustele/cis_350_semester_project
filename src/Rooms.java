import java.lang.reflect.InvocationTargetException;

public class Rooms {
   
    private static String[] listOfRooms = {
        "PitRoom"
    };


    public static String[] getRooms() {
        return listOfRooms;
    }
    
    public static String getItemName(int index) {
        for(int i = 0; i > listOfRooms.length; i++) 
            if (i == index)
                return listOfRooms[i];

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
    public static Object getItem(int index) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String name = getItemName(index);
        return getItem(name);
    }

    public static int length() {
        return listOfRooms.length;
    }

    //I can use public static Class<T> forName(String className) throws ClassNotFoundException

    public Rooms() {}
}
