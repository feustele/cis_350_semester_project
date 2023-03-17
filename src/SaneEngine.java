import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class SaneEngine {
	Scanner scnr;
	String name;
	ArrayList<Item> inventory;
	Player P1;
	Map gameMap;
	introLevel room1 = new introLevel();
	outroLevel room2 = new outroLevel();

	public SaneEngine() {
		scnr = new Scanner(System.in);
		System.out.print("Before you embark on your quest, Hero - What is your name? ");
		name = scnr.nextLine();
		inventory = new ArrayList<Item>();
		P1 = new Player(name, inventory);
	}
	
	public static void main(String args[]) {
		try {
			SaneEngine game = new SaneEngine();
			game.room1.roomEngine();
			game.room2.roomEngine();
			IOException end = new IOException();
			throw end;
		} catch (IOException e){
			System.out.println("Thank you for playing!");
		}
	}
}
