import java.util.ArrayList;

public class Player {
	//String Class;
	String Name;
	ArrayList <Items> Inventory = new ArrayList <Items>();

	public Player (String Name, ArrayList <Items> Inventory) {
		//this.Class = Class;
		this.Name = Name;
		this.Inventory = Inventory;
	}
	
	/** 
	 * @return ArrayList<Items>
	 */
	//Items getWeapon() {
		//return Weapon;
	//}
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
	//String viewCommands() {
		//System.out.print(Inventory);
	//}

}