package TestClasses;
import projectSane.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class PlayerTest {
    @Test 
    public void constructorTest() {
        ArrayList<Item> inventory = new ArrayList<Item>();
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2", inventory);
        assertEquals(inventory, player2.openInventory());
        assertEquals(inventory, player1.openInventory());
        assertEquals(player1.openInventory(), player2.openInventory());
    }

    @Test 
    public void addItem() {
        Player player1 = new Player("Player1");
        Item amulet = new MysteriousAmulet();
        String status = player1.addItem(amulet);

        assertNotEquals("You cannot carry any more items!", status);

    }
    @Test 
    public void addMoreThanTenItems() {
        Player player1 = new Player("Player1");
        for(int i = 0; i < 10; i++) {
            Item amulet = new MysteriousAmulet();
            String status = player1.addItem(amulet);

            assertNotEquals("You cannot carry any more items!", status);
        }
        Item amulet = new MysteriousAmulet();
        String eleventhItemStatus = player1.addItem(amulet);

        assertEquals("You cannot carry any more items!", eleventhItemStatus);
    }

    @Test 
    public void dropItem() {
        ArrayList<Item> inventory = new ArrayList<Item>();

        Player player1 = new Player("Player1");
        Item amulet = new MysteriousAmulet();
        player1.addItem(amulet);

        player1.dropItem(player1.openInventory().get(0));
        assertEquals(inventory, player1.openInventory());
    }
}
