package TestClasses;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.Test;
import projectSane.*;

public class FrogTest {
    @Test
    public void defaultFrog() {
        Frog frog = new Frog();
    }

    @Test
    public void customFrog() {
        Frog frog = new Frog("Froggity", 10);
        assertEquals(10, frog.getCombatPower());
        assertEquals("Froggity", frog.getName());
    }

    @Test
    public void zeroCombatFrog() {
        Frog frog = new Frog("Froggity", 0);
        assertEquals(0, frog.getCombatPower());
        assertEquals("Froggity", frog.getName());
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeCombatPower() {
        Frog frog = new Frog("Froggity Jr.", -5);
    }
}
