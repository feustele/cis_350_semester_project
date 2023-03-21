import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main game engine for a text-based adventure game.
 */
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Item> inventory;
	Player P1;
	Map gameMap;
	
	/**
         * Creates a new game instance and initializes a new player and game map.
         */
	public SaneEngine() {
		scnr = new Scanner(System.in);
		System.out.print("Before you embark on your quest, Hero - What is your name? ");
		name = scnr.nextLine();
		inventory = new ArrayList<Item>();
		P1 = new Player(name, inventory);
		gameMap = new Map();
		runGameLoop();
	}
	
	/**
         * The main loop that runs the game.
         */
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

	/**
         * The entry point of the program that creates a new game instance.
         * @param args The command line arguments.
         */
	public static void main(String args[]) {
		SaneEngine game = new SaneEngine();
	}
}
