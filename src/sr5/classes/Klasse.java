/**
 * Enum für die Klasse eines Charakters
 */

package sr5.classes;

/**
 * @author Cauti
 *
 */
public enum Klasse {
	KEINE(0), MAGIER(1), ADEPT(2), MAGIERADEPT(3), RIGGER(4), DECKER(5), TECHNOMANCER(6);
	private int value;
	
	private Klasse(int i) {
		this.value= i;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Klasse getKlassByID(int id) {
		Klasse k = null;
		switch(id) {
		case 0: k = KEINE; break;
		case 1: k = MAGIER; break;
		case 2: k = ADEPT; break;
		case 3: k = MAGIERADEPT; break;
		case 4: k = RIGGER; break;
		case 5: k = DECKER; break;
		case 6: k = TECHNOMANCER; break;
		}
		return k;
	}
	
}
