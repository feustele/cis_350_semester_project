import java.util.HashMap;
import java.util.Map;

/**
 * The parent class to all Items implemented. Holds the framework that will be used by all items.
 */
public abstract class Item {

	//Stores the stats of the item. Acts as a dictionary, where the key is the name of the stat.
	Map<String, Integer> stats = new HashMap<String, Integer>();

	/** 
	 * Default Constructor creates a new item
	*/
	protected Item() {
		//stats.put("Health", 0);
		stats.put("Attack", 0);
		stats.put("Defense", 0);
		stats.put("Experience", 0);
		stats.put("Luck", 0);
	}

	/**
	 * Creates a new item with specific stats.
	 * @param Health
	 * @param Attack
	 * @param Defense
	 * @param Experience
	 * @param Luck
	 */
	protected Item(int Health, int Attack, int Defense, int Experience, int Luck) {
		stats.put("Health", Health);
		stats.put("Attack", Attack);
		stats.put("Defense", Defense);
		stats.put("Experience", Experience);
		stats.put("Luck", Luck);
	}

	/** 
	 * Sets a specific stat to a certain statPoint if that stat exists. 
	 * @param stat
	 * @param statPoint
	 * @throws Exception
	 * @see setHealth
	 * @see setAttack
	 * @see setExperience
	 * @see setLuck
	 */
	protected void setStat(String stat, int statPoint) throws Exception {
		if (!stats.containsKey(stat)) {
			String errorMessage = "The stat, " + stat + ", is not a valid stat point"; 
			throw new Exception(errorMessage);
		}
		stats.put(stat, statPoint);
	}

	/**
	 * Sets the health stat of the item to a specific value.
	 * @param health
	 * @see setStat
	 * @see setAttack
	 * @see setExperience
	 * @see setLuck
	 */
	protected void setHealth(int health) {
		stats.put("Health", health);
	}

	/**
	 * Sets the attack stat of the item to a specific value.
	 * @param attack
	 * @see setStat
	 * @see setHealth
	 * @see setExperience
	 * @see setLuck
	 */
	protected void setAttack(int attack) {
		stats.put("Attack", attack);
	}
	// protected void setDefense(int defense) {
	// 	stats.put("Defense", defense);
	// }

	/**
	 * Sets the amount of experience gain that that the item gives to a specific value.
	 * @param exp
	 * @see setStat
	 * @see setHealth
	 * @see setAttack
	 * @see setLuck
	 */
	protected void setExperience(int exp) {
		stats.put("Experience", exp);
	}

	/**
	 * Sets the luck stat of the item to a specific value.
	 * @param luck
	 * @see setStat
	 * @see setHealth
	 * @see setAttack
	 * @see setExperience
	 */
	protected void setLuck(int luck) {
		stats.put("Luck", luck);
	}
}
