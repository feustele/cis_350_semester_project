package TestClasses;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.Test;
import projectSane.*;

public class SnakeTest {
    @Test
    public void defaultSnake() {
        Snake snake = new Snake();
    }

    @Test
    public void customSnake() {
        Snake snake = new Snake("Snakegity", 10);
        assertEquals(10, snake.getCombatPower());
        assertEquals("Snakegity", snake.getName());
    }

    @Test
    public void zeroCombatSnake() {
        Snake snake = new Snake("Snakegity", 0);
        assertEquals(0, snake.getCombatPower());
        assertEquals("Snakegity", snake.getName());
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeCombatPower() {
        Snake snake = new Snake("Snakegity Jr.", -5);
    }
}
