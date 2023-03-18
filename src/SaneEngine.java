import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Item> inventory;
	Player P1;
	Map gameMap;
	
	public SaneEngine() {
		scnr = new Scanner(System.in);
		System.out.print("Before you embark on your quest, Hero - What is your name? ");
		name = scnr.nextLine();
		inventory = new ArrayList<Item>();
		P1 = new Player(name, inventory);
		gameMap = new Map();
		runGameLoop();
	}
	
	private void runGameLoop() {
		try {
			while(true) {
				char c = gameMap.getPlayerRoom().roomEngine();
				gameMap.moveRooms(c, P1);

				
				//game.gameMap.getPlayerRoom().roomEngine();
				//game.gameMap.moveRooms();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		SaneEngine game = new SaneEngine();
	}
}
