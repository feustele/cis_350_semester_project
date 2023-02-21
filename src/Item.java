import java.util.HashMap;
import java.util.Map;

public abstract class Item {


	Map<String, Integer> stats = new HashMap<String, Integer>();

	protected Item() {
		//stats.put("Health", 0);
		stats.put("Attack", 0);
		stats.put("Defense", 0);
		stats.put("Experience", 0);
		stats.put("Luck", 0);
	}
	protected Item(int Health, int Attack, int Defense, int Experience, int Luck) {
		stats.put("Health", Health);
		stats.put("Attack", Attack);
		stats.put("Defense", Defense);
		stats.put("Experience", Experience);
		stats.put("Luck", Luck);
	}

	protected void setStat(String stat, int statPoint) {
		stats.put(stat, statPoint);
	}
	protected void setHealth(int health) {
		stats.put("Health", health);
	}
	protected void setAttack(int attack) {
		stats.put("Attack", attack);
	}
	// protected void setDefense(int defense) {
	// 	stats.put("Defense", defense);
	// }
	protected void setExperience(int exp) {
		stats.put("Experience", exp);
	}
	protected void setLuck(int luck) {
		stats.put("Luck", luck);
	}
}
