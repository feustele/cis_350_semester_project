import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Item> inventory;
	Player P1;
	Map gameMap;
	/**
	 * The main game engine for the game.
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
         * This method executes the game loop where the player's actions are read in and acted upon.
         * @throws IOException if there is an input/output error
         */
	private void runGameLoop() {
		try {
			while(true) {
				gameMap.getPlayerRoom().roomEngine(gameMap);
				//gameMap.moveRooms(c, P1);

				
				//game.gameMap.getPlayerRoom().roomEngine();
				//game.gameMap.moveRooms();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
        /**
         * The entry point of the program that creates a new game instance.
         * @param args 
         */
	public static void main(String args[]) {
		SaneEngine game = new SaneEngine();
	}
}
