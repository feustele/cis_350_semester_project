import java.util.ArrayList;

public class Player {
	//String Class;
	String Name;
	ArrayList <Item> Inventory = new ArrayList <Item>();

	public Player (String Name, ArrayList <Item> Inventory) {
		//this.Class = Class;
		this.Name = Name;
		this.Inventory = Inventory;
	}
	
	public Player (String Name) {
		//this.Class = Class;
		this.Name = Name;
		
	}
	/** 
	 * @return ArrayList<Items>
	 */
	//Items getWeapon() {
		//return Weapon;
	//}
	ArrayList<Item> openInventory() {
		return Inventory;
	}
	String addItem(Item selectedItem) {
		Inventory.add(selectedItem);
		String finalLine = "You picked up the " + selectedItem + "!";
		if (Inventory.size() > 10) {
			finalLine = "You cannot carry any more items!";
		}
		return finalLine;
	}
	String dropItem(Item selectedItem) {
		Inventory.remove(selectedItem);
		String finalLine = "You dropped the " + selectedItem + "!";
		return finalLine;
	}
	//String viewCommands() {
		//System.out.print(Inventory);
	//}

}