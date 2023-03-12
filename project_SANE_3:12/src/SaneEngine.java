import java.util.Scanner;
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Items> inventory;
	Player P1;
	Map gameMap;
	
	public SaneEngine() {
		scnr = = new Scanner(System.in);
		System.out.print("Before you embark on your quest, Hero - What is your name? ");
		name = scnr.getLine();
		inventory = new ArrayList<Items>;
		P1 = new Player(name, inventory);
		gameMap = Map();
	}
	
	public static void main() {
		try {
			while(true) {
				gameMap.playerRoom.roomEngine();
				gameMap.moveRooms();
			}
		} catch IOException {
			// Exceptions thrown for the endings
		}
	}
	
	
	
	
}
