package TestClasses;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.Test;
import projectSane.*;

public class ZombieTest {
    @Test
    public void defaultZombie() {
        Zombie zombie = new Zombie();
    }

    @Test
    public void customZombie() {
        Zombie zombie = new Zombie("Zombiegity", 10);
        assertEquals(10, zombie.getCombatPower());
        assertEquals("Zombiegity", zombie.getName());
    }

    @Test
    public void zeroCombatZombie() {
        Zombie zombie = new Zombie("Zombiegity", 0);
        assertEquals(0, zombie.getCombatPower());
        assertEquals("Zombiegity", zombie.getName());
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeCombatPower() {
        Zombie zombie = new Zombie("Zombiegity Jr.", -5);
    }
}
