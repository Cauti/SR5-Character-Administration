/**
 * Enum für die Attribute eines Charakters
 */
package sr5.classes;

import java.util.EnumSet;
import java.util.HashMap;

/**
 * @author Cauti
 *
 */
public enum Attribut {

	GES(0, "Geschicklichkeit"), KON(1, "Konstitution"), REA(2, "Reaktion"), STA(3, "Stärke"), CHA(4, "Charisma"),
	INT(5, "Intuition"), LOG(6, "Logik"), WIL(7, "Willenskraft"), MAG(8, "Magie"), RES(9, "Resonanz"), EDG(10, "Edge"),
	ESS(11, "Essenz"), NONE;
	
	private int value;
	private String name;
	private static HashMap<String, Integer> nameToAttrID = new HashMap<String, Integer>();
	
	static {
		for (Attribut a : EnumSet.allOf(Attribut.class)) {
			nameToAttrID.put(a.name, a.value);
		}
	}
	
	private Attribut() {}
	
	private Attribut(int val, String name) {
		this.value = val;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
	public static int getAttributIDByName(String name) {
		return nameToAttrID.get(name);
	}
	
	public static Attribut getAttributByID(int id) {
		switch (id) {
		case 0: return GES;
		case 1: return KON;
		case 2: return REA;
		case 3: return STA;
		case 4: return CHA;
		case 5: return INT;
		case 6: return LOG;
		case 7: return WIL;
		case 8: return MAG;
		case 9: return RES;
		case 10: return EDG;
		case 11: return ESS;
		}
		return null;
	}
}
