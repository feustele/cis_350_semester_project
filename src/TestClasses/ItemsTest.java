package TestClasses;
import org.junit.Test;
import static org.junit.Assert.*;
import projectSane.*;

public class ItemsTest {
    @Test
    public void testItemsClass() {
        for(int i = 0; i < 100; i++) {
            Object object1;
            try {
                object1 = Items.getItem(0);
            } catch(Exception e) {
                object1 = null;
            }

            Object object2;
            try { object2 = Items.getItem(ExperienceRing.class); }
            catch(Exception e) {
                object2 = null;
            }

            assertNotNull(object1);
            assertNotNull(object2);
        }
    }
}
