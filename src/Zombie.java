/**
 * The Zombie class is a subclass of the Monster class, representing a type of monster in the game.
 */
public class Zombie extends Monster {
	
	/**
	 * Default constructor for the Zombie class.
	 * Creates a new Zombie object with a name of "Zombie" and a combat power of 100.
	 */
	public Zombie() {
        	super("Zombie",100); 
    	}
	
	/**
	 * Constructor for the Zombie class.
	 * Creates a new Zombie object with the specified name and combat power.
	 * @param name The name of the zombie.
	 * @param combatPower The combat power of the zombie.
	 */
	public Zombie(String name, int combatPower) {
		super(name,combatPower);
	}
}
