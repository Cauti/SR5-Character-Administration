package sr5.classes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

public enum Fertigkeit {

	AKROBATIK(0, "Akrobatik", Attribut.GES),
	ENTFESSELN(1, "Entfesseln", Attribut.GES),
	EXFERNKAMPF(2, "Exotische Fernkampfwaffe", Attribut.GES),
	EXNAHKAMPF(3, "Exotische Nahkampfwaffe", Attribut.GES),
	FINGERFERT(4, "Fingerfertigkeit", Attribut.GES),
	GESCHUETZE(5, "Geschütze", Attribut.GES),
	GEWEHRE(6, "Gewehre", Attribut.GES),
	KLINGENWAFFEN(7, "Klingenwaffen", Attribut.GES),
	KNUEPPEL(8, "Knüppel", Attribut.GES),
	PISTOLEN(9, "Pistolen", Attribut.GES),
	PROJEKTILWAFFEN(10, "Projektilwaffen", Attribut.GES),
	SCHLEICHEN(11, "Schleichen", Attribut.GES),
	SCHLOSSER(12, "Schlosser", Attribut.GES),
	SCHNELLFEUERW(13, "Schnellfeuerwaffen", Attribut.GES),
	SCHWEREWAFFEN(14, "Schwere Waffen", Attribut.GES),
	WAFFENLOSERK(15, "Waffenloser Kampf", Attribut.GES),
	WURFWAFFEN(16, "Wurfwaffen", Attribut.GES),
	FREIFALL(17, "Freifall", Attribut.KON),
	TAUCHEN(18, "Tauchen", Attribut.KON),
	BODENFAHRZEUGE(19, "Bodenfahrzeuge", Attribut.REA),
	FLUGZEUGE(20, "Flugzeuge", Attribut.REA),
	RAUMFAHRZEUGE(21, "Raumfahrzeuge", Attribut.REA),
	EXFAHRZEUGE(22, "Exotische Fahrzeuge", Attribut.REA),
	LAEUFER(23, "Läufer", Attribut.REA),
	SCHIFFE(24, "Schiffe", Attribut.REA),
	LAUFEN(25, "Laufen", Attribut.STA),
	SCHWIMMEN(26, "Schwimmen", Attribut.STA),
	EINSCHUECHTERN(27, "Einschüchtern", Attribut.CHA),
	FUEHRUNG(28, "Führung", Attribut.CHA),
	GEBRAEUCHE(29, "Gebräuche", Attribut.CHA),
	TIERFUEHRUNG(30, "Tierführung", Attribut.CHA),
	UEBERREDEN(31, "Überreden", Attribut.CHA),
	UNTERRICHT(32, "Unterricht", Attribut.CHA),
	VERHANDLUNG(33, "Verhandlung", Attribut.CHA),
	VERKOERPERUNG(34, "Verkörperung", Attribut.CHA),
	VORFUEHRUNG(35, "Vorführung", Attribut.CHA),
	ASKENNEN(36, "Askennen", Attribut.INT),
	HANDWERK(37, "Handwerk", Attribut.INT),
	HOBBYWISSEN(38, "Hobbywissen", Attribut.INT),
	NAVIGATION(39, "Navigation", Attribut.INT),
	SPRACHEN(40, "Sprachen", Attribut.INT),
	SPURENLESEN(41, "Spurenlesen", Attribut.INT),
	STRASSENWISSEN(42, "Straßenwissen", Attribut.INT),
	VERKLEIDEN(43, "Verkleiden", Attribut.INT),
	WAHRNEHMUNG(44, "Wahrnehmung", Attribut.INT),
	AKADEMWISSEN(45, "Akademisches Wisssen", Attribut.LOG),
	ARKANA(46, "Arkana", Attribut.LOG),
	BERUFSWISSEN(47, "Berufswissen", Attribut.LOG),
	BIOTECHNOLOGIE(48, "Biotechnologie", Attribut.LOG),
	CHEMIE(49, "Chemie", Attribut.LOG),
	COMPUTER(50, "Computer", Attribut.LOG),
	ELEKKRIEGSF(51, "Elektronische Kriegsführung", Attribut.LOG),
	ERSTEHILFE(52, "Erste Hilfe", Attribut.LOG),
	FAHRZEUGMECHANIK(53, "Fahrzeugmechanik", Attribut.LOG),
	FAELSCHEN(54, "Fälschen", Attribut.LOG),
	HACKING(55, "Hacking", Attribut.LOG),
	HARDWARE(56, "Hardware", Attribut.LOG),
	INDUSTRIEMECH(57, "Industriemechanik", Attribut.LOG),
	KYBERNETIK(58, "Kybernetik", Attribut.LOG),
	LUFTFAHRMECH(59, "Luftfahrmechanik", Attribut.LOG),
	MATRIXKAMPF(60, "Matrixkampf", Attribut.LOG),
	MEDIZIN(61, "Medizin", Attribut.LOG),
	SEEFAHRTMECH(62, "Seefahrtmechanik", Attribut.LOG),
	SOFTWARE(63, "Software", Attribut.LOG),
	SPRENGSTOFFE(64, "Sprengstoffe", Attribut.LOG),
	WAFFENBAU(65, "Waffenbau", Attribut.LOG),
	ASTRALKAMPF(66, "Astralkampf", Attribut.WIL),
	SURVIVAL(67, "Survival", Attribut.WIL),
	ALCHEMIE(68, "Alchemie", Attribut.MAG),
	ANTIMAGIE(69, "Antimagie", Attribut.MAG),
	BINDEN(70, "Binden", Attribut.MAG),
	ENTZAUBERN(71, "Entzaubern", Attribut.MAG),
	FOKUSHERST(72, "Fokusherstellung", Attribut.MAG),
	HERBEIRUFEN(73, "Herbeirufen", Attribut.MAG),
	RITUALZAUBEREI(74, "Ritualzauberei", Attribut.MAG),
	SPRUCHZAUBEREI(75, "Spruchzauberei", Attribut.MAG),
	VERBANNEN(76, "Verbannen", Attribut.MAG),
	DEKOMPILIEREN(77, "Dekompilieren", Attribut.RES),
	REGISTRIEREN(78, "Registrieren", Attribut.RES),
	KOMPILIEREN(79, "Kompilieren", Attribut.RES);
	
	private int value;
	private String name;
	private Attribut attribut;
	private String text;
	private static HashMap<String, Integer> nameToFert = new HashMap<String, Integer>();
	private static final int size = Fertigkeit.values().length;

	static {
		for (Fertigkeit f : EnumSet.allOf(Fertigkeit.class)) {
			nameToFert.put(f.name, f.value);
		}
	}
	
	private Fertigkeit(int id, String name, Attribut attr) {
		this.value = id;
		this.name = name;
		this.attribut = attr;
		setText(id);
		//setNameToFert(name, id);
		//nameToFert.put(name, id);
	}
	
//	protected void setNameToFert(String name, int id) {
//		nameToFert.put(name, id);
//	}

	private void setText(int id) {
		switch(id) {
		case 0: text = "AKROBATIK (GESCHICKLICHKEIT)\r\n" + 
				"Akrobatik misst das Balancegefühl, die Koordination und generel-\r\n" + 
				"le Bewegungsfähigkeit. Weitere Informationen zur Anwendung\r\n" + 
				"von Akrobatik finden Sie unter Einsatz von Akrobatik, S. 134.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Athletik\r\n" + 
				"Spezialisierungen: Balancieren, Klettern, Parkour, Sprin-\r\n" + 
				"gen, Tanzen";
				break;
		case 1: text = "ENTFESSELN (GESCHICKLICHKEIT)\r\n" + 
				"Entfesseln misst die Fähigkeit eines Charakters, mit manueller\r\n" + 
				"Geschicklichkeit und Verrenkungen aus Fesseln zu entkom-\r\n" + 
				"men. Siehe Einsatz von Entfesseln, S. 135.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Nach Fesseln (Handschellen, Kabelbin-\r\n" + 
				"der, Seile etc.), Schlangenmensch";
				break;
		case 2: text = "EXOTISCHE FERNKAMPFWAFFE\r\n" + 
				"(WAFFE)\r\n" + 
				"Manchmal ist eine gewöhnliche Schusswaffe nicht genug,\r\n" + 
				"und man braucht etwas Ausgefalleneres. Oder Seltsameres.\r\n" + 
				"Diese Fertigkeit muss für jede exotische Fernkampfwaffe se-\r\n" + 
				"parat erworben werden. Beispiele dafür sind Blasrohre, Gyro-\r\n" + 
				"jet-Pistolen, Flammenwerfer und Laser.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Keine";
				break;
		case 3: text = "EXOTISCHE NAHKAMPFWAFFE\r\n" + 
				"(WAFFE)\r\n" + 
				"Manchmal ist eine gewöhnliche Klinge oder ein Knüppel\r\n" + 
				"nicht genug, und man braucht etwas Ausgefalleneres. Oder\r\n" + 
				"Seltsameres. Diese Fertigkeit muss für jede exotische Nah-\r\n" + 
				"kampfwaffe separat erworben werden. Beispiele dafür sind\r\n" + 
				"Monof lamentpeitschen oder -kettensägen.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Keine";
				break;
		case 4: text = "FINGERFERTIGKEIT\r\n" + 
				"(GESCHICKLICHKEIT)\r\n" + 
				"Diese Fertigkeit ermöglicht dem Charakter, unbemerkt kleine\r\n" + 
				"Gegenstände zu stehlen, zu verbergen oder weiterzugeben.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Heimlichkeit\r\n" + 
				"Spezialisierungen: Stehlen, Taschendiebstahl, Taschen-\r\n" + 
				"spielerei";
				break;
		case 5: text = "GESCHÜTZE (GESCHICKLICHKEIT)\r\n" + 
				"Die Fertigkeit Geschütze wird zum Schießen mit fahrzeug-\r\n" + 
				"montierten Waffen, unabhängig von der Art der Waffenhal-\r\n" + 
				"terung, benutzt. Sie umfasst sowohl die Bedienung von Hand\r\n" + 
				"als auch über Sensoren (S. 186).\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Artillerie, Energiewaffen, Feuerwaffen,\r\n" + 
				"Lenkraketen, Raketen";
				break;
		case 6: text = "GEWEHRE\r\n" + 
				"Die Fertigkeit Gewehre dient zur Benutzung von Langwaffen\r\n" + 
				"wie Jagd- und Scharfschützengewehren. In diese Kategorie\r\n" + 
				"fallen auch Waffen wie Schrotf inten, die im Schulteranschlag\r\n" + 
				"abgefeuert werden.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Feuerwaffen\r\n" + 
				"Spezialisierungen: Scharfschützengewehre, Schießen auf Lan-\r\n" + 
				"ge Entfernung, Schießen auf Maximale Entfernung, Schrotf inten";
				break;
		case 7: text = "KLINGENWAFFEN\r\n" + 
				"Schneiden und Schnetzeln! Die Fertigkeit Klingenwaffen wird\r\n" + 
				"für schneidende und stechende Nahkampfwaffen benutzt.\r\n" + 
				"Man kann allerlei Klingenwaffen, wie Dolche, Schwerter und\r\n" + 
				"Äxte, damit führen.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Nahkampf\r\n" + 
				"Spezialisierungen: Äxte, Messer, Parieren, Schwerter";
				break;
		case 8: text = "KNÜPPEL\r\n" + 
				"Als Knüppel gelten stumpfe Nahkampfwaffen. Mit dieser Fer-\r\n" + 
				"tigkeit kann man stumpfe Gegenstände wie Baseballschläger,\r\n" + 
				"Krücken oder Streitkolben als Waffen nutzen.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Nahkampf\r\n" + 
				"Spezialisierungen: Hämmer, Parieren, Schlagstöcke, Stä-\r\n" + 
				"be, Totschläger";
				break;
		case 9: text = "PISTOLEN\r\n" + 
				"Diese Fertigkeit dient zum Schießen mit Handfeuerwaffen wie\r\n" + 
				"Tasern, Einzelschusspistolen, Halbautomatiken und Revolvern.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Feuerwaffen\r\n" + 
				"Spezialisierungen: Halbautomatik, Holdout-Pistolen, Re-\r\n" + 
				"volver, Taser";
				break;
		case 10: text = "PROJEKTILWAFFEN\r\n" + 
				"Diese Fertigkeit wird zum Schießen mit sehnenbestückten\r\n" + 
				"Projektilwaffen benutzt. Ein Charakter mit dieser Fertigkeit ist\r\n" + 
				"mit vielen Arten von Bögen und Armbrüsten sowie den ver-\r\n" + 
				"schiedensten Pfeilarten vertraut.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Nein\r\n" + 
				"Spezialisierungen: Armbrust, Bogen, Schleuder, Spezial-\r\n" + 
				"munition";
				break;
		case 11: text = "SCHLEICHEN (GESCHICKLICHKEIT)\r\n" + 
				"Sie müssen an einen Ort, an dem Sie nichts zu suchen haben?\r\n" + 
				"Diese Fertigkeit erlaubt Ihnen, in verschiedenen Situationen\r\n" + 
				"unauffällig zu bleiben. Siehe Einsatz von Heimlichkeitsfertigkei-\r\n" + 
				"ten, S. 135.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Heimlichkeit\r\n" + 
				"Spezialisierungen: Nach Ort (Dschungel, Stadt, Wüste\r\n" + 
				"usw.)";
				break;
		case 12: text = "SCHLOSSER (GESCHICKLICHKEIT)\r\n" + 
				"Diese Fertigkeit umfasst das Bauen, Reparieren, Manipulieren\r\n" + 
				"und Öffnen von mechanischen und elektronischen Schlös-\r\n" + 
				"sern. Meist werden mechanische Schließsysteme als Anti-\r\n" + 
				"quitäten gesehen, aber als Ersatzsysteme oder Überraschung\r\n" + 
				"f ndet man sie immer noch. Elektronische Schlösser sind viel\r\n" + 
				"weiter verbreitet und lassen sich mit dieser Fertigkeit gut ma-\r\n" + 
				"nipulieren. Siehe Türen, Fenster und Schlösser, S. 362.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Nach Art des Schlosses (Kombinations-\r\n" + 
				"schloss, Magschloss, Schließzylinder, Stimmerkennung, Tas-\r\n" + 
				"tenfeld usw.)";
				break;
		case 13: text = "SCHNELLFEUERWAFFEN\r\n" + 
				"Die Fertigkeit Schnellfeuerwaffen ermöglicht das Bedienen\r\n" + 
				"von Feuerwaffen, die größer als Pistolen, aber kleiner als Ge-\r\n" + 
				"wehre sind. Diese Kategorie umfasst Maschinenpistolen und\r\n" + 
				"andere vollautomatische Karabiner.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Feuerwaffen\r\n" + 
				"Spezialisierungen: Automatikpistolen, Maschinenpistolen,\r\n" + 
				"Sturmgewehre";
				break;
		case 14: text = "SCHWERE WAFFEN\r\n" + 
				"Die Fertigkeit Schwere Waffen umfasst die Benutzung aller\r\n" + 
				"Fernkampfwaffen, die größer als Sturmgewehre sind – wie\r\n" + 
				"etwa Granatwerfer, Maschinengewehre und Sturmkanonen.\r\n" + 
				"Die Fertigkeit gilt nur für in der Hand geführte und nicht fahr-\r\n" + 
				"zeugmontierte Waffen. Wenn man eine fahrzeugmontierte\r\n" + 
				"Waffe benutzen will, braucht man die Fertigkeit Geschütze.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Granatwerfer, Lenkraketenwerfer, Ra-\r\n" + 
				"ketenwerfer, Maschinengewehre, Sturmkanonen";
				break;
		case 15: text = "WAFFENLOSER KAMPF\r\n" + 
				"Diese Fertigkeit steht für Selbstverteidigung und Angriffe, bei\r\n" + 
				"denen der Körper die Hauptwaffe ist. Dazu gehören allerlei\r\n" + 
				"Kampfkünste, der Einsatz von Cyberimplantatwaffen und die\r\n" + 
				"Kampfstile, die sich für diese Waffen entwickelt haben.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Nahkampf\r\n" + 
				"Spezialisierungen: Blocken, Cyberimplantatwaffen, Fest-\r\n" + 
				"haltekampf, spezielle Kampfkunst";
				break;
		case 16: text = "WURFWAFFEN\r\n" + 
				"Wurfwaffen ist eine breit gefächerte Fertigkeit zum Werfen\r\n" + 
				"von Gegenständen, die als Waffen dienen.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Aerodynamische Wurfwaffen, Nichtaero -\r\n" + 
				"dynamische Wurfwaffen, Wurfklingen";
				break;
		case 17: text = "FREIFALL (KONSTITUTION)\r\n" + 
				"Diese Fertigkeit deckt Sprünge aus jeder Höhe – vom Sprung\r\n" + 
				"aus dem zweiten Stock bis zum Absprung aus einem hoch\r\n" + 
				"f iegenden Flugzeug – ab. Wenn der Fall irgendwie gesteuert\r\n" + 
				"oder verlangsamt werden soll, wird diese Fertigkeit benutzt,\r\n" + 
				"also zum Beispiel beim Fallschirmspringen, Fliegen mit Wing-\r\n" + 
				"suit oder beim schnellen Abseilen, beim Bungeespringen\r\n" + 
				"oder mit der Seilrutsche.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Abrollen, Basejumping, Bungee, Fall-\r\n" + 
				"schirm, HALO, Seilrutsche, Wingsuit";
				break;
		case 18: text = "TAUCHEN (KONSTITUTION)\r\n" + 
				"Tauchen umfasst eine Vielzahl von Handlungen, die unter\r\n" + 
				"Wasser stattf nden. Die Fertigkeit kann beim Tauchen, beim\r\n" + 
				"Schwimmen unter Wasser, bei der Benutzung komplizierter\r\n" + 
				"Tauchgeräte und beim Luftanhalten benutzt werden.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Auf Atemgeräte (Flüssigatmung, Gas-\r\n" + 
				"gemisch, Pressluft, Sauerstoff), auf Gebiete (Arktis, Höhlen,\r\n" + 
				"Kommerziell, Militär usw.), Kontrolliertes Hyperventilieren";
				break;
		case 19: text = "BODENFAHRZEUGE\r\n" + 
				"Mit dieser Fertigkeit lenkt man alle Bodenfahrzeuge, die nicht\r\n" + 
				"auf Beinen laufen. Die Fertigkeit wird sowohl zur direkten als\r\n" + 
				"auch zur Fernsteuerung benutzt.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Fernsteuerung, Hovercrafts, Ketten-\r\n" + 
				"fahrzeuge, Motorräder, Radfahrzeuge";
				break;
		case 20: text = "FLUGZEUGE\r\n" + 
				"Diese Fertigkeit wird zum Lenken bemannter\r\n" + 
				"oder unbemannter Flugzeuge benutzt, die in-\r\n" + 
				"nerhalb der Atmosphäre f iegen.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Fernsteuerung, Kippf ügler, Luftschiffe,\r\n" + 
				"Rotormaschinen, Starrf ügler, Vektorschubmaschinen";
				break;
		case 21: text = "RAUMFAHRZEUGE\r\n" + 
				"Als Raumfahrzeuge gelten Fahrzeuge, die zu suborbitalem\r\n" + 
				"oder Raumf ug bei niedriger Schwerkraft oder Schwerelosig-\r\n" + 
				"keit fähig sind.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Fernsteuerung, Raumfahrt, Semiballis-\r\n" + 
				"tisch, Suborbital, Trägersysteme";
				break;
		case 22: text = "EXOTISCHES FAHRZEUG\r\n" + 
				"(FAHRZEUG)\r\n" + 
				"Diese Fertigkeit muss für jedes exotische Fahrzeug separat er-\r\n" + 
				"worben werden. Das Fahrzeug kann mit dieser Fertigkeit auch\r\n" + 
				"ferngesteuert werden, sofern das möglich ist.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Keine";
				break;
		case 23: text = "LÄUFER\r\n" + 
				"Alle „Fahrzeuge“, die auf zwei oder mehr Beinen laufen, wer-\r\n" + 
				"den mit dieser Fertigkeit gelenkt. Der Charakter kann den Läu-\r\n" + 
				"fer direkt oder fernsteuern.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Fernsteuerung, Vielbeiner, Vierbeiner,\r\n" + 
				"Zweibeiner";
				break;
		case 24: text = "SCHIFFE\r\n" + 
				"Diese Fertigkeit dient zum Lenken von Wasserfahrzeugen –\r\n" + 
				"entweder direkt oder per Fernlenkung.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Fernsteuerung, Großschiffe, Motorboo-\r\n" + 
				"te, Segelboote, Tragf ächenboote, U-Boote";
				break;
		case 25: text = "LAUFEN (STÄRKE)\r\n" + 
				"Laufen dient dem Überwinden von Entfernungen in kurzer\r\n" + 
				"Zeit. Näheres dazu f nden Sie unter Einsatz von Laufen, S. 136.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Athletik\r\n" + 
				"Spezialisierungen: Langstrecke, Sprint, nach Terrain (Wüs-\r\n" + 
				"te, Stadt, Wildnis usw.)";
				break;
		case 26: text = "SCHWIMMEN (STÄRKE)\r\n" + 
				"Diese Fertigkeit steht für die Fähigkeit des Charakters, in ver-\r\n" + 
				"schiedenen Gewässerarten zu schwimmen. Die Stufe der Fer-\r\n" + 
				"tigkeit beeinf usst, wie weit und wie schnell er schwimmen\r\n" + 
				"kann. Siehe Einsatz von Schwimmen, S. 136.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Athletik\r\n" + 
				"Spezialisierungen: Kurzstrecke, Langstrecke";
				break;
		case 27: text = "EINSCHÜCHTERN (CHARISMA)\r\n" + 
				"Einschüchtern dient dazu, gefährlicher zu wirken als andere\r\n" + 
				"Leute, um diese dazu zu bringen, zu tun, was man möchte.\r\n" + 
				"Die Fertigkeit kann in verschiedenen Zusammenhängen – von\r\n" + 
				"der Verhandlung bis zum Verhör – eingesetzt werden. Ein-\r\n" + 
				"schüchtern wird als Vergleichende Probe auf Einschüchtern +\r\n" + 
				"Charisma [Sozial] gegen Einschüchtern + Willenskraft [Sozial]\r\n" + 
				"des Ziels abgehandelt. Modif katoren dafür f nden Sie in der\r\n" + 
				"Tabelle Soziale Modif katoren, S. 140.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Folter, Geistig, Körperlich, Verhör";
				break;
		case 28: text = "FÜHRUNG (CHARISMA)\r\n" + 
				"Führung dient dazu, Leute zu führen und zu motivieren. Im\r\n" + 
				"Gegensatz zu Überreden verlässt man sich bei Führung eher\r\n" + 
				"auf Autorität als auf Täuschung. Diese Fertigkeit ist besonders\r\n" + 
				"hilfreich, wenn ein Teammitglied erschüttert ist oder jemand\r\n" + 
				"gebeten wird, etwas zu tun, womit er sich nicht wohlfühlt. Die\r\n" + 
				"Fertigkeit Führung soll aber nicht als Ersatz für schlechte Zusam-\r\n" + 
				"menarbeit im Team dienen. Siehe Einsatz von Führung, S. 141.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Einf uss\r\n" + 
				"Spezialisierungen: Anleiten, Anspornen, Inspirieren, Kom-\r\n" + 
				"mandieren";
				break;
		case 29: text = "GEBRÄUCHE (CHARISMA)\r\n" + 
				"Gebräuche steht für das Verständnis und das Erkennen von an-\r\n" + 
				"gemessenem Sozialverhalten. Die Fertigkeit dient als eine Art\r\n" + 
				"soziale Version von Schleichen und ermöglicht es, unerkannt\r\n" + 
				"durch verschiedene soziale Situationen zu kommen. Außerdem\r\n" + 
				"kann sie ein gesellschaftliches Sicherheitsnetz sein, wenn ein\r\n" + 
				"Spieler eine soziale Situation verpatzt, die der Charakter aber\r\n" + 
				"bewältigt hätte. Siehe Einsatz von Gebräuche, S. 141.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Einf uss\r\n" + 
				"Spezialisierungen: Nach Kultur oder Subkultur (High Soci-\r\n" + 
				"ety, Konzerne, Medienwelt, Söldner, Straße, Yakuza usw.)";
				break;
		case 30: text = "TIERFÜHRUNG (CHARISMA)\r\n" + 
				"Diese Fertigkeit umfasst das Trainieren, Versorgen, Reiten\r\n" + 
				"(wenn das möglich ist) und die Führung von nichtbewussten\r\n" + 
				"Tieren. Kompetente Tierführer können auch mehrere Tiere\r\n" + 
				"führen. Es ist sogar möglich, sich einem unausgebildeten Tier\r\n" + 
				"zu nähern und ein Vertrauensverhältnis aufzubauen – oder zu-\r\n" + 
				"mindest nicht gefressen zu werden.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Nach Tierart (Delf ne, Höllenhunde,\r\n" + 
				"Katzen, Pferde, Vögel usw.), Abrichten, Hüten, Reiten";
				break;
		case 31: text = "ÜBERREDEN (CHARISMA)\r\n" + 
				"Überreden erlaubt es, einen NSC hereinzulegen oder zu ma-\r\n" + 
				"nipulieren. Diese Fertigkeit hat auch viel mit dem Vorspiegeln\r\n" + 
				"von Vertrauenswürdigkeit zu tun, die das Prinzip hinter dem\r\n" + 
				"Überreden ist.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Schauspielerei\r\n" + 
				"Spezialisierungen: Schnellreden, Verführung";
				break;
		case 32: text = "UNTERRICHT (CHARISMA)\r\n" + 
				"Unterricht steht für die Fähigkeit, anderen Leuten etwas bei-\r\n" + 
				"zubringen. Die Fertigkeitsstufe regelt, wie gut man neues Wis-\r\n" + 
				"sen vermitteln kann und bis zu welcher Komplexität man eine\r\n" + 
				"Fertigkeit lehren kann. Siehe Einsatz von Unterricht, S. 142.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Nach Kategorie von Aktions- oder Wis-\r\n" + 
				"sensfertigkeiten (Kampf, Sprachen, Magisch, Akademisches\r\n" + 
				"Wissen, Straßenwissen usw.)";
				break;
		case 33: text = "VERHANDLUNG (CHARISMA)\r\n" + 
				"Verhandlung steht für die Fähigkeit, Charisma, Kommunika-\r\n" + 
				"tionstechniken und Psychologie bei Geschäften einzusetzen,\r\n" + 
				"um sich in eine bessere Position zu bringen.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Einf uss\r\n" + 
				"Spezialisierungen: Diplomatie, Feilschen, Verträge";
				break;
		case 34: text = "VERKÖRPERUNG (CHARISMA)\r\n" + 
				"Verkörperung steht für die Fähigkeit, in die Rolle einer an-\r\n" + 
				"deren Person zu schlüpfen und sie in Stimme und Verhalten\r\n" + 
				"nachzuahmen. Die Fertigkeit ist durch die körperlichen Vor-\r\n" + 
				"aussetzungen eines Charakters begrenzt. Ein Zwerg kann\r\n" + 
				"vielleicht per Kommlink die Stimme eines Trolls nachmachen,\r\n" + 
				"aber wenn er dem Ziel gegenübersteht, wird die Illusion ver-\r\n" + 
				"f iegen.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Schauspielerei\r\n" + 
				"Spezialisierungen: Nach Metatyp (Elf, Mensch, Ork, Troll,\r\n" + 
				"Zwerg)";
				break;
		case 35: text = "VORFÜHRUNG (CHARISMA)\r\n" + 
				"Diese Fertigkeit repräsentiert die Fähigkeiten und das Hand-\r\n" + 
				"werkszeug, die man für die darstellenden Künste braucht. Der\r\n" + 
				"Aufführende kann mit dieser Fertigkeit ein Publikum unterhal-\r\n" + 
				"ten und vielleicht sogar in seinen Bann ziehen. Siehe Einsatz\r\n" + 
				"von Vorführung, S. 142.\r\n"
				+ "Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Schauspielerei\r\n" + 
				"Spezialisierungen: Nach darstellender Kunst (Präsentation,\r\n" + 
				"Schauspiel, Komik, Musikinstrument usw.)";
				break;
		case 36: text = "ASKENNEN (INTUITION)\r\n" + 
				"Askennen ist die Fähigkeit eines Magieanwenders, Phänome-\r\n" + 
				"ne im Astralraum zu erkennen und zu interpretieren. Sie er-\r\n" + 
				"laubt, Informationen durch das Lesen von Auren zu erhalten.\r\n" + 
				"Nur Charaktere, die astral wahrnehmen können, dürfen diese\r\n" + 
				"Fertigkeit erwerben. Näheres dazu f nden Sie unter Astrale\r\n" + 
				"Wahrnehmung, S. 312.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Astrale Signaturen, Aurenlesen, nach\r\n" + 
				"Auratyp (Metamenschen, Foki, Geister, Hüter etc.)";
				break;
		case 37: text = "HANDWERK (INTUITION)\r\n" + 
				"Diese Fertigkeit umfasst sowohl künstlerisches Schaffen als\r\n" + 
				"auch die handwerkliche Herstellung von Gegenständen, die\r\n" + 
				"sonst auf Fließbändern produziert werden. Die besten Künstler\r\n" + 
				"der Welt müssen auch etwas von ihrem Handwerk verstehen.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Nach Handwerk (Bildhauerei, Kochen,\r\n" + 
				"Malerei, Tischlerei usw.)";
				break;
		case 38: text = "HOBBYWISSEN\r\n" + 
				"Es mag seltsam klingen, aber viele Runner haben Hobbys, die\r\n" + 
				"über das Schießen und Zaubern hinausgehen. Hobbywissen\r\n" + 
				"entsteht aus Interessen, die man zum Spaß oder zur Entspan-\r\n" + 
				"nung verfolgt. Es gibt keine Grenzen und Beschränkungen für\r\n" + 
				"Hobbywissen, das ein Charakter haben kann. Hobbywissen ist\r\n" + 
				"mit dem Attribut Intuition verbunden.";
				break;
		case 39: text = "NAVIGATION (INTUITION)\r\n" + 
				"Mit der Fertigkeit Navigation können Technologie und Instinkt\r\n" + 
				"einen Charakter durch verschiedene Gelände führen. Sie er-\r\n" + 
				"möglicht das Lesen von Karten, die Benutzung von GPS-Ge-\r\n" + 
				"räten und AR-Wegweisern sowie die Orientierung an Gelän-\r\n" + 
				"demerkmalen oder nach dem eigenen Gefühl. Navigation\r\n" + 
				"kann in Umgebungen mit und ohne AR genutzt werden.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Natur\r\n" + 
				"Spezialisierungen: AR-Wegweiser, Astronomische Navi-\r\n" + 
				"gation, GPS, Karten, Kompass";
				break;
		case 40: text = "SPRACHE (INTUITION)\r\n" + 
				"Sprache ist die Fähigkeit, mit geschriebenen oder gesproche-\r\n" + 
				"nen Worten in einer bestimmten Sprache zu kommunizieren.\r\n" + 
				"Charaktere, die mehrere Sprachen beherrschen wollen, müs-\r\n" + 
				"sen für jede Sprache eine separate Fertigkeit erwerben.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Lesen, Schreiben, Sprechen, nach Dia-\r\n" + 
				"lekt, nach Lingo";
				break;
		case 41: text = "SPURENLESEN (INTUITION)\r\n" + 
				"Diese Fertigkeit ermöglicht das Erkennen der Spuren von\r\n" + 
				"Metamenschen und anderem Wild im Gelände und das Ver-\r\n" + 
				"folgen dieser Spuren. Sie erlaubt es auch, unmarkierte Wege\r\n" + 
				"und Wildpfade in verschiedenen Umgebungen zu f nden. Sie-\r\n" + 
				"he Einsatz von Spurenlesen, S. 136.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Natur\r\n" + 
				"Spezialisierungen: Nach Umgebung (Dschungel, Gebirge,\r\n" + 
				"Polargebiete, Stadt, Wald, Wüste usw.)";
				break;
		case 42: text = "STRASSENWISSEN\r\n" + 
				"Straßenwissen ist mit dem Attribut Intuition verbunden. Die-\r\n" + 
				"se Art Wissen beschäftigt sich mit den wichtigen Personen\r\n" + 
				"in einer Stadt und damit, wie man auf der Straße zu etwas\r\n" + 
				"kommt. Man kennt die Leute in verschiedenen Vierteln,\r\n" + 
				"weiß, wen man wozu befragen kann und wo man etwas f n-\r\n" + 
				"det. Die Informationen, die diese Wissensfertigkeit abdeckt,\r\n" + 
				"ändern sich schnell und häuf g, aber die Instinkte des Cha-\r\n" + 
				"rakters ermöglichen ihm, auf dem Laufenden zu bleiben.";
				break;
		case 43: text = "VERKLEIDEN (INTUITION)\r\n" + 
				"Verkleiden umfasst das nichtmagische Verändern des Äuße-\r\n" + 
				"ren mit Schminke oder Verkleidungen. Siehe Einsatz von Ver-\r\n" + 
				"kleiden, S. 135.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Heimlichkeit\r\n" + 
				"Spezialisierungen: Kosmetik, Tarnung, Theater, Trideo &\r\n" + 
				"Video";
				break;
		case 44: text = "WAHRNEHMUNG (INTUITION)\r\n" + 
				"Wahrnehmung ermöglicht es, das Besondere im Alltag\r\n" + 
				"wahrzunehmen, und ist eine der wichtigsten Fertigkeiten für\r\n" + 
				"Shadowrunner. Siehe Einsatz von Wahrnehmung, S. 137.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Durchsuchen, Hören, Riechen, Schme-\r\n" + 
				"cken, Sehen, Tasten, Ominöse Wahrnehmung (S. 314)";
				break;
		case 45: text = "AKADEMISCHES WISSEN\r\n" + 
				"Akademisches Wissen ist mit dem Attribut Logik verbun-\r\n" + 
				"den. Diese Art von Wissen umfasst universitäre Fächer wie\r\n" + 
				"Geschichte, Naturwissenschaften, Design, Technologie,\r\n" + 
				"Magietheorie und das Wissen um die Personen und Orga-\r\n" + 
				"nisationen, die auf diesen Gebieten ihre Finger im Spiel ha-\r\n" + 
				"ben. Auch die Geisteswissenschaften (Kulturwissenschaf-\r\n" + 
				"ten, Kunst, Philosophie und so weiter) gehören in diese\r\n" + 
				"Kategorie.";
				break;
		case 46: text = "ARKANA (LOGIK)\r\n" + 
				"Arkana regelt den Entwurf magischer Formeln, die zur Er-\r\n" + 
				"schaffung von Zaubern, Foki und allen anderen Arten von ma-\r\n" + 
				"gischen Manipulationen verwendet werden. Diese Fertigkeit\r\n" + 
				"ist auch nötig, um Formeln zu verstehen, die man kauft oder\r\n" + 
				"f ndet.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Fokusdesign, Geisterformeln, Zauber-\r\n" + 
				"design";
				break;
		case 47: text = "BERUFSWISSEN\r\n" + 
				"Berufswissen umfasst das Wissen über gewöhnliche Berufe,\r\n" + 
				"wie Journalismus, Handel, Technik und Ähnliche. Dieses Wis-\r\n" + 
				"sen kann bei einer Recherche, vor allem in der Welt der Kon-\r\n" + 
				"zerne, nützlich sein. Die Wissensfertigkeiten dieser Kategorie\r\n" + 
				"sind mit dem Attribut Logik verbunden.";
				break;
		case 48: text = "BIOTECHNOLOGIE (LOGIK)\r\n" + 
				"Biotechnologie wird von Ärzten und Wissenschaftlern be-\r\n" + 
				"nutzt, um Körperteile wachsen zu lassen. Diese Fertigkeit ist\r\n" + 
				"die Grundlage für das Klonen und die Herstellung von Biowa-\r\n" + 
				"re. Mit der richtigen Ausrüstung kann man mit dieser Fertig-\r\n" + 
				"keit beschädigte Bioware reparieren, neues Gewebe klonen\r\n" + 
				"oder Bioware im Körper eines Ziels entdecken. Das Implantie-\r\n" + 
				"ren oder Entfernen von Bioware ist damit nicht möglich.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Bioinformatik, Bioware, Gentherapie,\r\n" + 
				"Klonen, Wartung von Zuchttanks";
				break;
		case 49: text = "CHEMIE (LOGIK)\r\n" + 
				"Chemie erlaubt dem Charakter, chemische Reaktionen her-\r\n" + 
				"vorzurufen und chemische Verbindungen – von Drogen über\r\n" + 
				"Parfums bis hin zu Biopolymeren wie NuSkin – herzustellen.\r\n" + 
				"Chemie kann auch genutzt werden, um chemische Verbin-\r\n" + 
				"dungen zu analysieren.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Analytische Chemie, Anorganische Che-\r\n" + 
				"mie, Biochemie, Organische Chemie, Physikalische Chemie";
				break;
		case 50: text = "COMPUTER (LOGIK)\r\n" + 
				"Die Fertigkeit Computer ist die Grundlage für die Interaktion\r\n" + 
				"mit der Matrix. Sie steht für die Fähigkeit, Computer und ande-\r\n" + 
				"re mit der Matrix verbundene Geräte zu benutzen. Diese Fer-\r\n" + 
				"tigkeit konzentriert sich auf das Verständnis von verschiede-\r\n" + 
				"nen Betriebssystemen. Mit ihr kann ein Charakter keinen Code\r\n" + 
				"ausnutzen (wie mit Hacking) und auch nicht an Mainframes\r\n" + 
				"basteln (wie mit Hardware). Siehe Einsatz von Computer, S. 223.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Elektronik\r\n" + 
				"Spezialisierungen: Nach Handlung (Datei Editieren, Mat-\r\n" + 
				"rixsuche, Matrixwahrnehmung usw.)";
				break;
		case 51: text = "ELEKTRONISCHE KRIEGSFÜHRUNG\r\n" + 
				"(LOGIK)\r\n" + 
				"Elektronische Kriegsführung bildet die Basis militärischer Si-\r\n" + 
				"gnalaufklärung. Sie umfasst das Verschlüsseln, Stören, Täu-\r\n" + 
				"schen und Entschlüsseln elektronischer Kommunikationssys-\r\n" + 
				"teme. Wenn der Charakter die richtige Ausrüstung hat, kann\r\n" + 
				"er diese Fertigkeit nutzen, um Signale aus beliebigen Kommu-\r\n" + 
				"nikationssystemen zu manipulieren oder sogar zu überneh-\r\n" + 
				"men. Siehe Einsatz von Elektronischer Kriegsführung, S. 223.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Cracken\r\n" + 
				"Spezialisierungen: Kommunikation, Sensoroperationen,\r\n" + 
				"Stören, Verschlüsseln";
				break;
		case 52: text = "ERSTE HILFE (LOGIK)\r\n" + 
				"Erste Hilfe ist die Fähigkeit, Notfallmedizin wie ein Sanitäter\r\n" + 
				"zu betreiben. Sie kann genutzt werden, um Verletzungen zu\r\n" + 
				"behandeln und Charaktere zu stabilisieren, damit sie nicht\r\n" + 
				"sterben. Erste Hilfe kann nicht für chirurgische Eingriffe oder\r\n" + 
				"zum Reparieren beschädigter Implantate benutzt werden.\r\n" + 
				"Näheres dazu f nden Sie unter Heilung ab S. 204.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Biotech\r\n" + 
				"Spezialisierungen: Nach Behandlung (Knochenbrüche,\r\n" + 
				"Schussverletzungen, Verbrennungen, Wiederbelebung usw.)";
				break;
		case 53: text = "FAHRZEUGMECHANIK (LOGIK)\r\n" + 
				"Diese Fertigkeit dient zur Wartung, Reparatur und zum Um-\r\n" + 
				"bau aller Arten von Bodenfahrzeugen – von Autos über Rad-\r\n" + 
				"drohnen bis hin zu Panzern. Auch dafür sind die richtigen\r\n" + 
				"Werkzeuge, Teile und Zeit nötig. Siehe Bauen und Reparieren,\r\n" + 
				"S. 146.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Mechanik\r\n" + 
				"Spezialisierungen: Hovercrafts, Kettenfahrzeuge, Läufer,\r\n" + 
				"Radfahrzeuge";
				break;
		case 54: text = "FÄLSCHEN (LOGIK)\r\n" + 
				"Fälschen ermöglicht die Herstellung gefälschter Gegenstän-\r\n" + 
				"de oder das Verändern existierender Gegenstände für eige-\r\n" + 
				"ne Zwecke. Je nach Art der Fälschung sind unterschiedliche\r\n" + 
				"Werkzeuge, Materialien oder Vorlagen nötig. Siehe Einsatz\r\n" + 
				"von Fälschen, S. 146.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Bildmanipulation, Credstickfälschung,\r\n" + 
				"Dokumentenfälschung, Falsche IDs, Produktfälschung";
				break;
		case 55: text = "HACKING (LOGIK)\r\n" + 
				"Hacking dient zum Entdecken und Ausnutzen von Sicher-\r\n" + 
				"heitslücken in Computern und anderer Elektronik. Genaueres\r\n" + 
				"dazu f nden Sie unter Einsatz von Hacking, S. 223.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Cracken\r\n" + 
				"Spezialisierungen: Dateien, Geräte, Hosts, Personas";
				break;
		case 56: text = "HARDWARE (LOGIK)\r\n" + 
				"Hardware steht für die Fähigkeit eines Charakters, elektroni-\r\n" + 
				"sche Geräte zu bauen und zu reparieren. Dazu sind ein Ar-\r\n" + 
				"beitsplatz, Material, Werkzeug und genügend Zeit notwen-\r\n" + 
				"dig. Siehe Bauen und Reparieren, S. 146.\r\n" +
				"Improvisieren: Nein\r\n" +
				"Fertigkeitsgruppe: Elektronik\r\n" +
				"Spezialisierungen: Nach Art der Hardware (Cyberdecks,\r\n" +
				"Kommlinks, Smartguns usw.)";
				break;
		case 57: text = "INDUSTRIEMECHANIK (LOGIK)\r\n" + 
				"Industriemechanik beschäftigt sich mit dem Reparieren oder\r\n" + 
				"Umbauen von großen Maschinen wie Fertigungsstraßen, Ge-\r\n" + 
				"neratoren, Industrierobotern, Lüftungs- und Heizungstechnik\r\n" + 
				"und so weiter. Siehe Bauen und Reparieren, S. 146.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Mechanik\r\n" + 
				"Spezialisierungen: Bautechnik, Elektrik, Heizung & Lüf-\r\n" + 
				"tung, Hydraulik, Industrieroboter, Schweißen";
				break;	
		case 58: text = "KYBERNETIK (LOGIK)\r\n" + 
				"Kybernetik ermöglicht das Herstellen, Warten und Reparieren\r\n" + 
				"von kybernetischen Teilen. Ein Charakter kann mit den richti-\r\n" + 
				"gen Werkzeugen und Teilen sogar neue Cyberware herstellen.\r\n" + 
				"Kybernetik ist keine chirurgische Fertigkeit. Charaktere können\r\n" + 
				"damit keine Cyberware implantieren oder entfernen. Die Fertig-\r\n" + 
				"keit kann aber benutzt werden, um Cybergliedmaßen zu modi-\r\n" + 
				"f zieren oder zu verbessern. Siehe Bauen und Reparieren, S. 146.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Biotech\r\n" + 
				"Spezialisierungen: Bodyware, Cybergliedmaßen, Head-\r\n" + 
				"ware, Reparieren";
				break;
		case 59: text = "LUFTFAHRTMECHANIK (LOGIK)\r\n" + 
				"Diese Fertigkeit ermöglicht das Reparieren oder Umbauen\r\n" + 
				"von Luftfahrzeugen, wenn die benötigten Werkzeuge und\r\n" + 
				"Teile vorhanden sind. Siehe Bauen und Reparieren, S. 146.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Mechanik\r\n" + 
				"Spezialisierungen: Kippf ügler, Luftschiffe, Raumfahrzeu-\r\n" + 
				"ge, Rotormaschinen, Starrf ügler, Vektorschubmaschine";
				break;
		case 60: text = "MATRIXKAMPF (LOGIK)\r\n" + 
				"Matrixkampf wird von Hackern für Kämpfe in der Matrix be-\r\n" + 
				"nutzt. Siehe Einsatz von Matrixkampf, S. 223.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Cracken\r\n" + 
				"Spezialisierungen: Nach Ziel (Geräte, Gitter, IC, Personas,\r\n" + 
				"Sprites usw.)";
				break;
		case 61: text = "MEDIZIN (LOGIK)\r\n" + 
				"Medizin wird für größere Eingriffe wie Chirurgie benutzt.\r\n" + 
				"Auch bei länger dauernder Behandlung von Krankheiten oder\r\n" + 
				"für Diagnosen kann die Fertigkeit angewandt werden. Sie ist\r\n" + 
				"auch zur Implantation oder Entfernung von Cyber- und Bio-\r\n" + 
				"ware nutzbar, ermöglicht aber an den Systemen selbst keine\r\n" + 
				"Reparaturen oder Wartung. Näheres dazu f nden Sie unter\r\n" + 
				"Heilung ab S. 204.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Biotech\r\n" + 
				"Spezialisierungen: Implantationschirurgie, Magische Hei-\r\n" + 
				"lung, Organzüchtung, Pf ege, Plastische Chirurgie, Unfallchi-\r\n" + 
				"rurgie";
				break;
		case 62: text = "SEEFAHRTMECHANIK (LOGIK)\r\n" + 
				"Seefahrtmechanik beschäftigt sich mit Wartung, Reparatur\r\n" + 
				"und Umbau von Wasserfahrzeugen. Auch für diese Fertigkeit\r\n" + 
				"braucht man Teile, Werkzeug und Zeit. Siehe Bauen und Repa-\r\n" + 
				"rieren, S. 146.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Mechanik\r\n" + 
				"Spezialisierungen: Motorboote, Schiffe, Segelboote,\r\n" + 
				"U-Boote";
				break;
		case 63: text = "SOFTWARE (LOGIK)\r\n" + 
				"Software wird benutzt, um Programme zu schreiben und zu\r\n" + 
				"manipulieren. Siehe Einsatz von Software, S. 223. Auch Tech-\r\n" + 
				"nomancer benutzen Software, um ihre Komplexen Formen zu\r\n" + 
				"weben (s. Weben, S. 249).\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Elektronik\r\n" + 
				"Spezialisierungen: Datenbomben oder nach Komplexer\r\n" + 
				"Form (Editor, Petze, Resonanzspike usw.)";
				break;
		case 64: text = "SPRENGSTOFFE (LOGIK)\r\n" + 
				"Diese Fertigkeit wird zur Vorbereitung, Platzierung, Detona-\r\n" + 
				"tion – und häuf g auch zum Entschärfen – von chemischen\r\n" + 
				"Sprengstoffen benutzt. Siehe Sprengstoffe, S. 438.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Entschärfen, Improvisierte Sprengstof-\r\n" + 
				"fe, Kommerzielle Sprengstoffe, Plastiksprengstoffe";
				break;
		case 65: text = "WAFFENBAU (LOGIK)\r\n" + 
				"Waffenbau umfasst ein weites Feld von Fähigkeiten zum Bau-\r\n" + 
				"en und Reparieren von Waffen und Panzerungen. Wie bei\r\n" + 
				"allen Mechanikfertigkeiten sind dazu die passenden Werk-\r\n" + 
				"zeuge und Teile nötig. Schwellenwerte und Informationen\r\n" + 
				"über die Auswirkung von Erfolgen f nden Sie unter Bauen und\r\n" + 
				"Reparieren.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Artillerie, Feuerwaffen, Nahkampfwaf-\r\n" + 
				"fen, Panzerung, Schwere Waffen, Sprengstoffe, Waffenzube-\r\n" + 
				"hör";
				break;
		case 66: text = "ASTRALKAMPF (WILLENSKRAFT)\r\n" + 
				"Diese Fertigkeit ist für den Kampf im Astralraum erforderlich.\r\n" + 
				"Außerdem sind beim Kampf im Astralraum andere Attribute\r\n" + 
				"und Fähigkeiten wichtig als in der körperlichen Welt. Siehe\r\n" + 
				"dazu Astralkampf, S. 314.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Keine\r\n" + 
				"Spezialisierungen: Nach Art des Waffenfokus, nach Geg-\r\n" + 
				"nerart (Zauberer, Geister, Manabarrieren etc.)";
				break;
		case 67: text = "SURVIVAL (WILLENSKRAFT)\r\n" + 
				"Sie sind in der Wüste mit nichts als einem Becher, einem Pon-\r\n" + 
				"cho und einer Eisenstange? Dann brauchen Sie diese Fertig-\r\n" + 
				"keit, um lebend rauszukommen. Survival ermöglicht es, unter\r\n" + 
				"extremen Umständen längere Zeit am Leben zu bleiben. Da-\r\n" + 
				"mit kann man wichtige Handlungen – wie etwa Feuer machen,\r\n" + 
				"einen Unterstand bauen, Nahrung suchen usw. – auch unter\r\n" + 
				"widrigen Umständen durchführen. Siehe Einsatz von Survival,\r\n" + 
				"S. 136.\r\n" + 
				"Improvisieren: Ja\r\n" + 
				"Fertigkeitsgruppe: Natur\r\n" + 
				"Spezialisierungen: Dschungel, Gebirge, Polargebiete,\r\n" + 
				"Stadt, Wald, Wüste oder andere Umgebungen";
				break;
		case 68: text = "ALCHEMIE (MAGIE)\r\n" + 
				"Alchemie dient dazu, Substanzen herzustellen, die Zauber-\r\n" + 
				"sprüche speichern können. Meist dient Alchemie zum Brauen\r\n" + 
				"von Tränken, Destillieren von magischen Reagenzien oder so-\r\n" + 
				"gar zur Herstellung von Orichalkum.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Verzaubern\r\n" + 
				"Spezialisierungen: Nach Auslöser (Befehl, Kontakt, Zeit),\r\n" + 
				"nach Zauberart (Kampfzauber, Wahrnehmungszauber usw.)";
				break;
		case 69: text = "ANTIMAGIE (MAGIE)\r\n" + 
				"Antimagie ist eine defensive Fertigkeit, mit deren Hilfe man\r\n" + 
				"sich gegen magische Angriffe verteidigen und aufrechterhal-\r\n" + 
				"tene Zauber bannen kann. Siehe Antimagie, S. 294.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Hexerei\r\n" + 
				"Spezialisierungen: Nach Zauberart (Kampfzauber, Wahr-\r\n" + 
				"nehmungszauber usw.)";
				break;
		case 70: text = "BINDEN (MAGIE)\r\n" + 
				"Binden dient dazu, einen herbeigerufenen Geist längerfristig\r\n" + 
				"zu zusätzlichen Diensten zu zwingen. Siehe Binden, S. 300.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Beschwören\r\n" + 
				"Spezialisierungen: Nach Geisterart (Feuergeister, Erdgeis-\r\n" + 
				"ter usw.)";
				break;
		case 71: text = "ENTZAUBERN (MAGIE)\r\n" + 
				"Mit dieser Fertigkeit kann man magische Verzauberungen\r\n" + 
				"von Gegenständen entfernen. Siehe Entzaubern, S. 307.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Verzaubern\r\n" + 
				"Spezialisierungen: Nach Verzauberungsart (Alchemische\r\n" + 
				"Erzeugnisse, Kraftfoki usw.)";
				break;
		case 72: text = "FOKUSHERSTELLUNG (MAGIE)\r\n" + 
				"Die Fertigkeit Fokusherstellung braucht man zur Herstellung\r\n" + 
				"magischer Foki. Sie kann auch forensisch eingesetzt werden,\r\n" + 
				"um Informationen über die Herstellung und den Zweck ei-\r\n" + 
				"nes existierenden Fokus zu askennen. Siehe Fokusherstellung,\r\n" + 
				"S. 305.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Verzaubern\r\n" + 
				"Spezialisierungen: Fokusanalyse, Herstellung (nach Fokus-\r\n" + 
				"art)";
				break;
		case 73: text = "HERBEIRUFEN (MAGIE)\r\n" + 
				"Mit dieser Fertigkeit werden Geister herbeigerufen. Siehe Her-\r\n" + 
				"beirufen, S. 299.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Beschwören\r\n" + 
				"Spezialisierungen: Nach Geisterart (Erdgeister, Geister des\r\n" + 
				"Menschen usw.)";
				break;
		case 74: text = "RITUALZAUBEREI (MAGIE)\r\n" + 
				"Ritualzauberei dient dazu, Ritualzauber zu wirken. Siehe Ritu-\r\n" + 
				"alzauberei, S. 294.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Hexerei\r\n" + 
				"Spezialisierungen: Nach Merkmal (Verankert, Zauber, usw.)";
				break;
		case 75: text = "SPRUCHZAUBEREI (MAGIE)\r\n" + 
				"Die Fertigkeit Spruchzauberei erlaubt es dem Charakter, Mana\r\n" + 
				"als Energie für Effekte zu nutzen, die man „Zaubersprüche“\r\n" + 
				"nennt. Siehe Spruchzauberei, S. 279.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Hexerei\r\n" + 
				"Spezialisierungen: Nach Zauberart (Kampfzauber, Wahr-\r\n" + 
				"nehmungszauber usw.)";
				break;
		case 76: text = "VERBANNEN (MAGIE)\r\n" + 
				"Verbannen dient dazu, die Verbindung zu unterbrechen, die\r\n" + 
				"einen Geist in der körperlichen Welt hält. Verbannte Geister\r\n" + 
				"müssen auf ihre Heimatebene zurückkehren und müssen kei-\r\n" + 
				"ne noch ausstehenden Dienste mehr leisten.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Beschwören\r\n" + 
				"Spezialisierungen: Nach Geisterart (Luftgeister, Geister\r\n" + 
				"des Menschen usw.)";
				break;
		case 77: text = "DEKOMPILIEREN (RESONANZ)\r\n" + 
				"Dekompilieren ermöglicht es einem Charakter, zuvor kompi-\r\n" + 
				"lierte Sprites zu vernichten. Siehe Sprites, S. 252.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Tasken\r\n" + 
				"Spezialisierungen: Nach Spriteart (Kuriersprites, Störspri-\r\n" + 
				"tes usw.)";
				break;
		case 78: text = "REGISTRIEREN (RESONANZ)\r\n" + 
				"Mit dieser Fertigkeit kann ein Technomancer Sprites in der\r\n" + 
				"Matrix registrieren, wodurch Gitter sie als berechtigt anerken-\r\n" + 
				"nen. Siehe Sprites, S. 252.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Tasken\r\n" + 
				"Spezialisierungen: Nach Spriteart (Datensprites, Inf ltrator-\r\n" + 
				"sprites etc.)";
				break;
		case 79: text = "KOMPILIEREN\r\n" + 
				"Kompilieren steht für die Fähigkeit, die Nullen und Einsen der\r\n" + 
				"Maschinensprache und die Rhythmen der Resonanz in Sprites\r\n" + 
				"zu übersetzen. Siehe Sprites, S. 252.\r\n" + 
				"Improvisieren: Nein\r\n" + 
				"Fertigkeitsgruppe: Tasken\r\n" + 
				"Spezialisierungen: Nach Spriteart (Datensprites, Maschi-\r\n" + 
				"nensprites usw.)";
				break;
		}
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public Attribut getAttribut() {
		return attribut;
	}
	
	public String getText() {
		return text;
	}
	
	public static Fertigkeit getFertigkeitByID(int id) {
		switch (id) {
		case 0: return AKROBATIK;
		case 1: return ENTFESSELN;
		case 2: return EXFERNKAMPF;
		case 3: return Fertigkeit.EXNAHKAMPF;
		case 4: return FINGERFERT;
		case 5: return GESCHUETZE;
		case 6: return Fertigkeit.GEWEHRE;
		case 7: return KLINGENWAFFEN;
		case 8: return KNUEPPEL;
		case 9: return PISTOLEN;
		case 10: return PROJEKTILWAFFEN;
		case 11: return Fertigkeit.SCHLEICHEN;
		case 12: return SCHLOSSER;
		case 13: return Fertigkeit.SCHNELLFEUERW;
		case 14: return SCHWEREWAFFEN;
		case 15: return WAFFENLOSERK;
		case 16: return WURFWAFFEN;
		case 17: return FREIFALL;
		case 18: return TAUCHEN;
		case 19: return BODENFAHRZEUGE;
		case 20: return Fertigkeit.FLUGZEUGE;
		case 21: return Fertigkeit.RAUMFAHRZEUGE;
		case 22: return EXFAHRZEUGE;
		case 23: return LAEUFER;
		case 24: return SCHIFFE;
		case 25: return Fertigkeit.LAUFEN;
		case 26: return Fertigkeit.SCHWIMMEN;
		case 27: return EINSCHUECHTERN;
		case 28: return Fertigkeit.FUEHRUNG;
		case 29: return Fertigkeit.GEBRAEUCHE;
		case 30: return TIERFUEHRUNG;
		case 31: return Fertigkeit.UEBERREDEN;
		case 32: return Fertigkeit.UNTERRICHT;
		case 33: return Fertigkeit.VERHANDLUNG;
		case 34: return VERKOERPERUNG;
		case 35: return Fertigkeit.VORFUEHRUNG;
		case 36: return ASKENNEN;
		case 37: return HANDWERK;
		case 38: return HOBBYWISSEN;
		case 39: return NAVIGATION;
		case 40: return Fertigkeit.SPRACHEN;
		case 41: return SPURENLESEN;
		case 42: return Fertigkeit.STRASSENWISSEN;
		case 43: return VERKLEIDEN;
		case 44: return Fertigkeit.WAHRNEHMUNG;
		case 45: return Fertigkeit.AKADEMWISSEN;
		case 46: return ARKANA;
		case 47: return BERUFSWISSEN;
		case 48: return BIOTECHNOLOGIE;
		case 49: return CHEMIE;
		case 50: return COMPUTER;
		case 51: return Fertigkeit.ELEKKRIEGSF;
		case 52: return Fertigkeit.ERSTEHILFE;
		case 53: return Fertigkeit.FAHRZEUGMECHANIK;
		case 54: return FAELSCHEN;
		case 55: return HACKING;
		case 56: return HARDWARE;
		case 57: return INDUSTRIEMECH;
		case 58: return KYBERNETIK;
		case 59: return Fertigkeit.LUFTFAHRMECH;
		case 60: return Fertigkeit.MATRIXKAMPF;
		case 61: return MEDIZIN;
		case 62: return Fertigkeit.SEEFAHRTMECH;
		case 63: return SOFTWARE;
		case 64: return Fertigkeit.SPRENGSTOFFE;
		case 65: return WAFFENBAU;
		case 66: return ASTRALKAMPF;
		case 67: return SURVIVAL;
		case 68: return ALCHEMIE;
		case 69: return ANTIMAGIE;
		case 70: return BINDEN;
		case 71: return Fertigkeit.ENTZAUBERN;
		case 72: return FOKUSHERST;
		case 73: return Fertigkeit.HERBEIRUFEN;
		case 74: return RITUALZAUBEREI;
		case 75: return Fertigkeit.SPRUCHZAUBEREI;
		case 76: return VERBANNEN;
		case 77: return Fertigkeit.DEKOMPILIEREN;
		case 78: return REGISTRIEREN;
		case 79: return Fertigkeit.KOMPILIEREN;
		}
		return null;
	}
	
	public static int getFertIDByName(String name) {
		return nameToFert.get(name);
	}
	
	public static int getSize() {
		return size;
	}
	
	public static String[] getAllFertigkeitenAsStrings() {
		String[] alleferts = new String[size];
		for (int i = 0; i < size; ++i) {
			alleferts[i] = getFertigkeitByID(i).getName();
		}
		return alleferts;
	}
	
}
