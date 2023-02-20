import java.util.ArrayList;
import java.util.Scanner;

public class Quest {
	public static void main(String args[]) {  
		/** opening spiel **/
		ArrayList <Room> gameMap = new ArrayList <Room>();
		Room openingRoom = new Room("*A cavernous, drafty dungeon. A small console TV is in one corner. There are two doors ahead of you, and an overeager Wizard approaches.*", true);
		System.out.println(openingRoom.roomDescription);
		
		Scanner scnr = new Scanner(System.in);
		Player newPlayer = null;
		System.out.println("WELCOME PLAYER! I AM THE MIGHTY RONALD, AND I WILL GUIDE YOU THROUGH YOUR QUEST IN THE REALM OF MADEUPLANDIA!");
		System.out.println("THIS GAME REQUIRES YOU TO PRESS THE Y AND N KEYS TO PROGRESS.");
    	System.out.println("SORRY ABOUT THE SHOUTING, I AM VERY LONELY, AND I DO NOT GET OUT MUCH.");
    	System.out.println("PRAYTELL, WHAT IS YOUR NAME? CHOOSE WISELY, AS IT CANNOT BE CHANGED LATER.");
    	// create egg where ronald gets mad if you name yourself 'changed later'
    	
    	String givenName = scnr.nextLine();
    	newPlayer.Name = givenName;
    	System.out.println("SO YOU ARE THE PROPHESISED " + givenName + " ?");
    	// if yes, progress. if not, go back.
    	
    	System.out.println("AND WHAT SORT OF WARRIOR ARE YOU? A BURLY BARBARIAN? A TRICKY THIEF? A WONDEROUS WARLOCK?");
    	String givenClass = scnr.nextLine();
    	newPlayer.Class = givenClass;
    	System.out.println("SO YOU ARE THE " + givenClass + " " + givenName + " ?");
    	// if yes, progress. if not, go back.
    	
    	System.out.println("AND WHAT IS A " + givenClass + " WITHOUT A WEAPON?");
    	System.out.println("*You were given a very large stick.*");
    	Items givenWeapon = new Items ("A considerably large stick.", 5, true);
    	newPlayer.Weapon = givenWeapon; 
    	newPlayer.Inventory.add(givenWeapon);
    	System.out.println("MIGHTY " + givenName + ", I MUST ASK A TERRIBLY LARGE FAVOR FROM YOU.");
    	System.out.println("YOU MUST TRAVEL THROUGH THE END OF THIS DUNGEON TO RETRIEVE A VERY VALUABLE ITEM.");
    	System.out.println("THERE ARE MANY ENEMIES THAT MAY PURSUE YOU THROUGH, BUT THE REWARD IS WELL WORTH IT.");
    	// the very valuable item is a used gift card
    	System.out.println("VALIANT " + givenName + ", DO YOU ACCEPT THIS QUEST?");
    	// if player chooses no, game ends. ronald is disappointed and insults you.
    	System.out.println("FANTASTIC! GO FORTH, AND MAY LADY LUCK FAVOR YOU!");
    	
    	/** fetchquest **/
    	
	}
}
