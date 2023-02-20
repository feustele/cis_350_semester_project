import java.util.ArrayList;

public class Player {
	String Class;
	String Name;
	Items Weapon;
	ArrayList <Items> Inventory = new ArrayList <Items>();
	
	public Player (String Class, String Name, Items Weapon, ArrayList <Items> Inventory) {
		this.Class = Class;
		this.Name = Name;
		this.Weapon = Weapon;
		this.Inventory = Inventory;
	}
	Items getWeapon() {
		return Weapon;
	}
	ArrayList<Items> openInventory() {
		return Inventory;
	}
	String addItem(Items selectedItem) {
		Inventory.add(selectedItem);
		String finalLine = "You picked up the " + selectedItem + "!";
		if (Inventory.size() > 10) {
			finalLine = "You cannot carry any more items!";
		}
		return finalLine;
	}
	String dropItem(Items selectedItem) {
		Inventory.remove(selectedItem);
		String finalLine = "You dropped the " + selectedItem + "!";
		return finalLine;
	}
	String enterCombat() {
		String finalLine = "";
		if (Enemy.getCombatPower() >= Items.getCombatPower()) {
			finalLine = "You lose! You scurry back to the start of the maze, narrowly avoiding dismemberment.";
			Room.leaveRoom();
			// code a room array so that it always returns you to room 1
			Room.enterRoom();
		}
		else {
			finalLine = "You win!";
		}
		return finalLine;
	}
	String viewCommands() {
		
	}
	
}
