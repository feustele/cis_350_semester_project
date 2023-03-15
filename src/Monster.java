import java.util.ArrayList;

/**
 * The parent class to all Monsters implemented. Holds the framework that will be used by all Monster.
 */
public abstract class Monster {
	//The amount of damage that a monster does
    protected int combatPower = 0;
    
	/**
	 * Creates a new monster with the specified power level
	 * @param combatPower
	*/
	public Monster (int combatPower) {
		
	}

	
	
	/** 
	 * 
	 * @return int
	 */
	protected int getCombatPower() {
		return combatPower;
	}



}