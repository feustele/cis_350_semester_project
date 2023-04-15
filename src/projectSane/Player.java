package projectSane;
import java.util.ArrayList;

public class Player {
	//String Class;
	String Name;
	ArrayList <Item> Inventory = new ArrayList <Item>();
        
	/**
         * Creates a new Player with the specified name and inventory.
         * 
         * @param Name The name of the player.
         * @param Inventory The player's inventory.
         */
	public Player (String Name, ArrayList <Item> Inventory) {
		//this.Class = Class;
		this.Name = Name;
		this.Inventory = Inventory;
	}
	
	/**
         * Creates a new Player with the specified name and an empty inventory.
         * 
         * @param Name The name of the player.
         */
	public Player (String Name) {
		//this.Class = Class;
		this.Name = Name;
		
	}
	 /**
          * Returns the player's inventory.
          * 
          * @return The player's inventory.
          */
	public ArrayList<Item> openInventory() {
		return Inventory;
	}
	
	/**
         * Adds an item to the player's inventory.
         * 
         * @param selectedItem The item to be added to the inventory.
         * @return A message indicating whether the item was successfully added or not.
         */
	public String addItem(Item selectedItem) {
		Inventory.add(selectedItem);
		String finalLine = "You picked up the " + selectedItem + "!";
		if (Inventory.size() > 10) {
			finalLine = "You cannot carry any more items!";
		}
		return finalLine;
	}
	 /**
          * Removes an item from the player's inventory.
          * 
          * @param selectedItem The item to be removed from the inventory.
          * @return A message indicating whether the item was successfully removed or not.
          */
	public String dropItem(Item selectedItem) {
		Inventory.remove(selectedItem);
		String finalLine = "You dropped the " + selectedItem + "!";
		return finalLine;
	}
	

}
