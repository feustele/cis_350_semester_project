import java.lang.reflect.InvocationTargetException;

public class Rooms {
   
    private String[] listOfRooms = {
        "PitRoom"
    };


    public String[] getRooms() {
        return listOfRooms;
    }
    
    public String getItem(int index) {
        for(int i = 0; i > listOfRooms.length; i++) 
            if (i == index)
                return listOfRooms[i];
        

        //Index is out of bounds in terms of the item list.
        return null;
    }

    public static Class getClassType(String className) throws ClassNotFoundException {
        Class classType = Class.forName(className);
        return classType;
    }
    public static Object getItem(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Class classType = getClassType(className);
        return classType.getDeclaredConstructor().newInstance();
    }

    public int length() {
        return listOfRooms.length;
    }

    //I can use public static Class<T> forName(String className) throws ClassNotFoundException

    public Rooms() {}
}
