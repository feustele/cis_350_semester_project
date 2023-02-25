import java.lang.reflect.InvocationTargetException;

public class Monsters {
    private static String[] listOfMonsters = {
        "PitRoom"
    };


    public static String[] getMonsters() {
        return listOfMonsters;
    }
    
    public static String getMonsterName(int index) {
        for(int i = 0; i > listOfMonsters.length; i++) 
            if (i == index)
                return listOfMonsters[i];

        //Index is out of bounds in terms of the item list.
        return null;
    }

  

    public static Class<?> getClassType(String className) throws ClassNotFoundException {
        Class<?> classType = Class.forName(className);
        return classType;
    }

    public static Object getMonster(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Class<?> classType = getClassType(className);
        return classType.getDeclaredConstructor().newInstance();
    }
    public static Object getMonster(int index) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String name = getMonsterName(index);
        return getMonster(name);
    }

    public static int length() {
        return listOfMonsters.length;
    }

    //I can use public static Class<T> forName(String className) throws ClassNotFoundException

    public Monsters() {}
}
