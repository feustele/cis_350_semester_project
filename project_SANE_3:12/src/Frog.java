/**
 * A basic enemy that the player can encounter
 */
public class Frog extends Monster{
	/**
	 * 
	 * @param name
	 * @param combatPower
	 */
	public Frog() {
        	super("Dart Frog",100); 
    	}
    public Frog(String name, int combatPower) {
        super(name,combatPower);
    }

}
