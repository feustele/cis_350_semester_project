package TestClasses;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import projectSane.*;


public class MonstersTest {

    @Test
    public void isZombieAMonster() {
        Monster testLevel = new Zombie();

        Zombie testLevel2 = new Zombie();

        Object testMon3 = new Zombie();

        assertEquals(true, Monsters.isObjectAEnemy(testLevel));
        assertEquals(true, Monsters.isObjectAEnemy(testLevel2));
        assertEquals(true, Monsters.isObjectAEnemy(testMon3));
    }

    @Test
    public void isMonsterAMonsterAbstract() {
        for(int i = 0; i < Monsters.length(); i++) {
            Object mon;
            try {
                mon = Monsters.getMonster(i);
                assertEquals(true, Monsters.isObjectAEnemy(mon));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
