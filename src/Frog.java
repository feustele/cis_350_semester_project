/**
 * A basic enemy that the player can encounter. This class extends the Monster class
 * and adds functionality specific to the Frog enemy.
 */
public class Frog extends Monster{

    /**
     * Creates a new Frog with default properties.
     * The default constructor calls the super constructor with default values.
     */
    public Frog() {
        super("Dart Frog", 100); 
    }
    
    /**
     * Creates a new Frog with specified properties.
     * @param name is the name of the Frog enemy
     * @param combatPower is the combat power of the Frog enemy
     */
    public Frog(String name, int combatPower) {
        super(name, combatPower);
    }
}


