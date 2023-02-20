import java.util.ArrayList;
import java.util.Random;

public class Room {
	boolean hasChest;
	boolean hasEnemy;
	boolean hasPlayerInside;
	
	String [] oaths = {"Gadzooks!", "Wow!", "Yikes!", "Yippee!", "Aieeee!"};
	String [] adjectivesSize = {"big", "teeny", "small", "regular-sized", "titanic"};
	String [] adjectivesDescriptive = {"dark", "suspicious", "light-colored", "neon yellow", "not at all suspicious"};
	String [] roomTypes = {"narrow", "cavernous", "dungeoneous", "cramped", "cozy"};
	
	Random random = new Random();
	
	
	public Room (String roomDescription, boolean hasPlayerInside) {
		
	}
	
	Room enterRoom() {
		Room.hasPlayerInside = true;
		return roomDesciption;
	}
	
	Room leaveRoom() {
		Room.hasPlayerInside = false;
	}
	
	public void enemyList(){
		ArrayList<Enemy> commonEnemies = new ArrayList<Enemy>();
		ArrayList<Enemy> rareEnemies = new ArrayList<Enemy>();
		// common enemies
		Enemy Werewolf = new Enemy("Werewolf", 20);
		Enemy Mothman = new Enemy("Mothman", 15);
		Enemy AGuyNamedGary = new Enemy("A Guy Named Gary", 12);
		Enemy SuspiciousCantaloupe = new Enemy("A Suspicious Canteloupe", 0);
		Enemy AngryHorse = new Enemy("Angry Horse", 10);
		// rare enemies
		Enemy BossDemon = new Enemy("Evan, the Litch Prince", 40);
		Enemy BossGhost = new Enemy("Nancy, the Suspicious Specter", 30);
		Enemy BossGremlin = new Enemy("Sir Sockington, the Werecat", 35);
		// final boss
		Enemy FinalBoss = new Enemy("The Queen", 100);
			
		commonEnemies.add(Werewolf);
		commonEnemies.add(Mothman);
		commonEnemies.add(AGuyNamedGary);
		commonEnemies.add(SuspiciousCantaloupe);
		commonEnemies.add(AngryHorse);
		
		rareEnemies.add(BossGremlin);
		rareEnemies.add(BossGhost);
		rareEnemies.add(BossDemon);
	}
	public void lookAround(){
		enemyList();
		int r = random.nextInt(100);
		// used to calculate if a chest or enemy is in the room
		
		if (r%2 == 0) {
			hasChest = true;
			int r1 = random.nextInt(5);
			int a = random.nextInt(5);
			int n = random.nextInt(5);
			System.out.println(oaths[r1] + " You see a " + adjectivesSize[a] + " " + adjectivesDescriptive[n] + " chest!");
		}
		else{
			hasChest = false;
			System.out.println("You do not see a chest in this room.");
			if (r%3 == 0) {
				hasEnemy = true;
				int r1 = random.nextInt(5);
				int a = random.nextInt(5);
				int n = random.nextInt(5);
				System.out.println(oaths[n] + " You see a " + adjectivesSize[a] + " " + adjectivesDescriptive[r1] + " " + commonEnemies.get(a) + "!");
			}
			else {
				
				System.out.println("You do not see any enemies in this room.");
			}
		}
		if (r%3 == 0) {
			hasEnemy = true;
		}
		else{
			hasEnemy = false;
		}
			
		if (hasChest) {
			int r1 = random.nextInt(5);
			int a = random.nextInt(5);
			int n = random.nextInt(5);
			System.out.println(oaths[r1] + " You see a " + adjectivesSize[a] + " " + adjectivesDescriptive[n] + " chest!");
		}
		else {
			System.out.println("You do not see a chest in this room.");
			if (hasEnemy) {
				int r1 = random.nextInt(5);
				int a = random.nextInt(5);
				int n = random.nextInt(5);
				System.out.println(oaths[n] + " You see a " + adjectivesSize[a] + " " + adjectivesDescriptive[r1] + " " + commonEnemies.get(a) + "!");
			}
			else {
				System.out.println("You do not see any enemies in this room.");
			}
		}
	}
	public void createMap() {
	ArrayList <Room> gameMap = new ArrayList <Room>();
	
	}
}
