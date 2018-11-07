package sr5.classes;

public enum IC {
	ABSTURZ(0, "Absturz"), AUFSPUEHREN(1, "Aufspühren"), BLASTER(2, "Blaster"), BREMSE(3, "Bremse"), KILLER(4, "Killer"),
	LEUCHTSPUR(5, "Leuchtspur"), MARKER(6, "Marker"), PATROUILLE(7, "Patrouille"), SAEURE(8, "Säure"),
	SCHWARZESIC(9, "Schwarzes IC"), SPARKY(10, "Sparky"), STOERER(11, "Störer"), TEARBABY(12, "Tearbaby"), WIRBEL(13, "Wirbel");
	
	private int value;
	private String name;
	
	private IC(int val, String name) {
		value = val;
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
