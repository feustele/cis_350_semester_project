import java.util.ArrayList;

/**
 * The parent class to all Monsters implemented. Holds the framework that will be used by all Monster.
 */
public abstract class Monster {
        /**
	 * The amount of damage that a monster does
	 */
	private String name;
	protected int combatPower = 0;
	private int locX;
	private int locY;
	/**
	 * Creates a new monster with the specified power level
	 * @param name
	 * @param combatPower
	 * @param locX
	 * @param locY
	*/
	public Monster (String name, int combatPower, int locX, int locY) {
		this.name = name;
		this.combatPower = combatPower;
		this.locX = locX;
		this.locY =locY;
	}
	/**
	 * 
	 * @return String
	 */
	public String getname() {
		return name;
	}
	/** 
	 * 
	 * @return int
	 */
	protected int getCombatPower() {
		return combatPower;
	}
	/**
	 * 
	 * @return int
	 */
	public int getlocX() {
		return locX;
	}
	/**
	 * 
	 * @return int
	 */
	public int getlocY() {
		return locY;
	}


}
