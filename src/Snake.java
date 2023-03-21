/**
 * The Snake class represents a specific type of Monster that a player can encounter in the game.
 * It extends the abstract class Monster and provides implementation for its constructors.
 */
public class Snake extends Monster {
	
	/**
         * Constructs a new instance of the Snake class with default values for its name and combat power.
         * The name is set to "Snake" and the combat power is set to 100.
         */
	public Snake() {
        	super("Snake",100); 
    	}
	
	/**
         * Constructs a new instance of the Snake class with the specified name and combat power.
         * @param name the name of the Snake monster.
         * @param combatPower the combat power of the Snake monster.
         */
	public Snake(String name, int combatPower) {
		super(name,combatPower);
 }
}
