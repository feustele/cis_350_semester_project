import java.util.ArrayList;

/**
 * The parent class to all Monsters implemented. Holds the framework that will be used by all Monster.
 */
public abstract class Monster {
       
	/**
         * The name of the monster.
         */
	private String name;
	
	/**
         * The combat power of the monster.
         */
	protected int combatPower = 0;

	
	/**
	 * Creates a new monster with the specified power level. 
	 * @param name the name of the Monster
	 * @param combatPower the combat power of the Mon
	 */
	
	public Monster (String name, int combatPower) {
		this.name = name;
		this.combatPower = combatPower;
		
	}
	
	/**
         * Returns the name of the monster.
         * @return the name of the monster
         */
	public String getname() {
		return name;
	}
	
	/** 
         * Returns the combat power of the monster.
         * @return the combat power of the monster
         */
	protected int getCombatPower() {
		return combatPower;
	}

	
}
