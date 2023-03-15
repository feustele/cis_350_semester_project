import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Items> inventory;
	Player P1;
	Map gameMap;
	
	public SaneEngine() {
		scnr = new Scanner(System.in);
		System.out.print("Before you embark on your quest, Hero - What is your name? ");
		name = scnr.nextLine();
		inventory = new ArrayList<Items>();
		P1 = new Player(name, inventory);
		gameMap = new Map();
	}
	
	public static void main(String args[]) {
		SaneEngine game = new SaneEngine();
		try {
			while(true) {
				game.gameMap.getPlayerRoom().roomEngine();
				game.gameMap.moveRooms('w');
			}
		} catch (IOException e) {
			// Exceptions thrown for the endings
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
