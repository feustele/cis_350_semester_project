import java.util.Scanner;
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Items> inventory;
	Player P1;
	Map gameMap;
	
	public SaneEngine() {
		scnr = = new Scanner(System.in);
		System.out.print("Enter player name: ");
		name = scnr.getLine();
		inventory = new ArrayList<Items>;
		P1 = new Player(name, inventory);
		gameMap = Map();
	}
	
	public static void main() {
		try {
			while(true) {
				gameMap.playerRoom.roomEngine();
				// If need be, move player to next room in map
			}
		} catch {
			// Exceptions thrown for the endings
		}
	}
	
	
	
	
}
