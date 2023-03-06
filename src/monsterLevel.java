import java.util.Random;

public class monsterLevel extends Room {
    
    monsterLevel.enemySpawnChance = 1;
    public class Main {
    	public static void roomEngine(String[] args) {
    		try {
    			FileReader reader = new FileReader("monsterLevelText.txt");
    			BufferedReader trap = new BufferedReader reader;
                String line; 
    			while((line = trap.readLine()) != null && scnr.next == /n) {
    				System.out.print(line);
    			}
                //reads out room enter text
    			reader.close();
                trap.close();
                if (room.getMonsters() has "Snake"){
                    System.out.print("You see a horrible, slithery snake!");
                }
                // snake (insert toxic by britney spears) 
                else if (room.getMonsters() has "Zombie"){
                    System.out.print("You see a shambling corpse!");
                }
                // zombie (insert Cranberries song here)
                else if (room.getMonsters() has "Frog"){
                    System.out.print("You see a... brightly colored frog?");
                }
                //poison dart frog - soon to have its own ending (greatful dead?).
                
                System.out.print("Maybe don't get too close... you don't have very many options.");
                // hints that the player should keep away from the monster
    			if (getEnemyPosition() == getPlayerPosition()) {
                    if (room.getMonsters() has "Snake"){
                        System.out.print("The snake lunges! You've been bitten!");
                        // if you interact with the snake
                    }
                    else if (room.getMonsters() has "Zombie"){
                        System.out.print("The zombie leaps at you with a snarl!");
                        // if you interact with the Zombie
                    }
                    else if (room.getMonsters() has "Frog"){
                        System.out.print("You pick up the frog. It wiggles indignantly.");
                        // if you interact with the frog
                    }   
    				try {
    	    			FileReader pitReader = new FileReader("poisonEnemy.txt");
                        BufferedReader pitBuffer = new BufferedReader pitReader;
    			        while((line = pitBuffer.readLine()) != null && scnr.next == /n) {
    				        System.out.print(line);
    			        }
                        pitReader.close();
                        pitBuffer.close();
                        new IOException end;
		                throw end;
                        
                    }
                    // reads out death by poison text
                catch (FileNotFoundException e) {
        			e.printStackTrace();

        		}
                catch (IOException e) {
        			e.printStackTrace();
    			}
    		}

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();

    		} catch (IOException e) {
    			e.printStackTrace();

    		}


}
