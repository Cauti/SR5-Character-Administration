package sr5.classes;

import java.util.EnumSet;
import java.util.HashMap;

public enum Handlung {
	
	KOMPFORMAB(0, "Komplexe Form abschießen", "S. 250", Handlungstyp.RESONANZ),
	KOMPFORMWEBEN(1, "Komplexe Form weben", "S. 249", Handlungstyp.RESONANZ),
	SPRITEAKDEAK(2, "Sprite aktivieren/deaktivieren", Handlungstyp.RESONANZ),
	SPRITEBEFEHLIGEN(3, "Sprite befehligen", Handlungstyp.RESONANZ),
	SPRITEDEKOMB(4, "Sprite dekompilieren", "S. 253", Handlungstyp.RESONANZ),
	SPRITEKOMP(5, "Sprite kompilieren", "S. 252", Handlungstyp.RESONANZ),
	SPRITEREG(6, "Komplexe Form abschießen", "S. 250", Handlungstyp.RESONANZ),
	AUSSTOEPSELN(7, "Ausstöpseln", "S. 234", Handlungstyp.MATRIX),
	BEFEHLVOR(8, "Befehl vortäuschen", "S. 236", Handlungstyp.MATRIX),
	BRUTEFORCE(9, "Brute Force", "S. 234", Handlungstyp.MATRIX),
	DATEICRACKEN(10, "Datei cracken", "S. 234", Handlungstyp.MATRIX),
	DATEIEDIT(11, "Datei editieren", "S. 234", Handlungstyp.MATRIX),
	DATENBOMBEENT(12, "Datenbombe entschärfen", Handlungstyp.MATRIX),
	DATENBOMBELEG(13, "Datenbombe legen", Handlungstyp.MATRIX),
	DATENSPIKE(14, "Datenspike", Handlungstyp.MATRIX),
	EILIGESHACKEN(15, "Eiliges Hacken", Handlungstyp.MATRIX),
	GERAETFORMAT(16, "Gerät formatieren", Handlungstyp.MATRIX),
	GERAETNEUSTART(17, "Gerät neu starten", Handlungstyp.MATRIX),
	GERAETSTEUERN(18, "Gerät steuern", Handlungstyp.MATRIX),
	GITTERWECHSEL(19, "Gitterwechsel", Handlungstyp.MATRIX),
	HOSTBETVER(20, "Host betretn/verlassen", Handlungstyp.MATRIX),
	ICONAUF(21, "Icon aufspühren", Handlungstyp.MATRIX),
	ICONVER(22, "Icon verändern", Handlungstyp.MATRIX),
	INTERFACEMODI(23, "Interfacemodi wechseln", Handlungstyp.MATRIX),
	GERAETSPRINGEN(24, "In ein Gerät springen", Handlungstyp.MATRIX),
	MARKEEINLADEN(25, "Marke einladen", Handlungstyp.MATRIX),
	MARKELOESCHEN(26, "Marke löschen", Handlungstyp.MATRIX),
	MATRIXSIGNATUR(27, "Maatrixsignatur löschen", Handlungstyp.MATRIX),
	MATRIXSUCHE(28, "Matrixsuche", "S.238", Handlungstyp.MATRIX),
	MATRIXWAHRNEHMUNG(29, "Matrixwahrnehmung", Handlungstyp.MATRIX),
	NACHRICHTUEBERM(30, "Nachricht übermitteln", Handlungstyp.MATRIX),
	OWBESTIMMEN(31, "Overwatch-Wert bestimmen", Handlungstyp.MATRIX),
	PROGRAMMABST(32, "Programm abstürzen lassen", Handlungstyp.MATRIX),
	SIGNALSTOEREN(33, "Signal stören", Handlungstyp.MATRIX),
	UEBERTRAGUNGABF(34, "Übertragung abfangen", Handlungstyp.MATRIX),
	VERSTECKEN(35, "Verstecken", Handlungstyp.MATRIX),
	VOLLEMABWEHR(36, "Volle Matrixabwehr", Handlungstyp.MATRIX),
	;
	
	private int id;
	private String name;
	private String text;
	private String seite;
	private Handlungstyp typ;
	private static HashMap<String, Integer> nameToHandID = new HashMap<String, Integer>();
	
	static {
		for (Handlung h : EnumSet.allOf(Handlung.class)) {
			nameToHandID.put(h.name, h.id);
		}
	}

	private Handlung(int id, String name, String seite, Handlungstyp typ) {
		this.id = id;
		this.name= name;
		this.seite = seite;
		this.typ = typ;
		setText(id);
	}
	
	private Handlung(int id, String name, Handlungstyp typ) {
		this.id = id;
		this.name= name;
		this.typ = typ;
		setText(id);
	}
	
	private void setText(int id) {
		switch (id) {
		case 0: text = "KOMPLEXE FORM ABSCHIESSEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Probe: Software + Resonanz [Geistig] gegen Stufe der\r\n" + 
				"Komplexen Form + Resonanz\r\n" + 
				"Der Technomancer versucht, eine Komplexe Form zu been-\r\n" + 
				"den (siehe S. 250).";
				break;
		case 1: text = "KOMPLEXE FORM WEBEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Probe: Software + Resonanz [Stufe]\r\n" + 
				"Der Technomancer webt eine Komplexe Form (siehe Seite\r\n" + 
				"249).";
				break;
		case 2: text = "SPRITE AKTIVIEREN/\r\n" + 
				"DEAKTIVIEREN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Probe: keine\r\n" + 
				"Der Technomancer aktiviert ein registriertes Sprite, das in\r\n" + 
				"der Resonanz wartet. Es erscheint zu Beginn der nächsten\r\n" + 
				"Kampfrunde. Er kann diese Handlung auch benutzen, um ein\r\n" + 
				"Sprite in die Resonanz zurückzuschicken, wodurch alle of-\r\n" + 
				"fenen Aufgaben verfallen. Es verschwindet dann mit seiner\r\n" + 
				"nächsten Handlung.";
				break;
		case 3: text = "SPRITE BEFEHLIGEN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Probe: keine\r\n" + 
				"Der Technomancer bef ehlt einem Sprite, etwas für ihn zu\r\n" + 
				"tun, was eine seiner Aufgaben verbraucht.";
				break;
		case 4: text = "SPRITE DEKOMPILIEREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Probe: Dekompilieren + Resonanz [Sozial] gegen Spritestu-\r\n" + 
				"fe (+Resonanz des Kompilierers)\r\n" + 
				"Der Technomancer versucht, ein Sprite zu dekompilieren\r\n" + 
				"(siehe S. 253).";
				break;
		case 5: text = "SPRITE KOMPILIEREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Probe: Kompilieren + Resonanz [Spritestufe] gegen Sprite-\r\n" + 
				"stufe\r\n" + 
				"Der Technomancer kompiliert ein Sprite (siehe S. 252).";
				break;
		case 6: text = "SPRITE REGISTRIEREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Probe: Registrieren + Resonanz [Spritestufe] gegen Sprite-\r\n" + 
				"stufe x 2\r\n" + 
				"Der Technomancer registriert ein Sprite (siehe S. 253).";
				break;
		case 7: text = "AUSSTÖPSELN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Benötigte Marken: Besitzer\r\n" + 
				"Probe: Hardware + Willenskraft [Firewall] gegen Logik +\r\n" + 
				"Angriff (s. Text)\r\n" + 
				"Durch diese Handlung wird der Charakter von der Matrix\r\n" + 
				"getrennt, und sein Zugangsgerät wird neu gestartet. Wenn er\r\n" + 
				"in der VR war und nicht zuerst in die AR gewechselt ist, erlei-\r\n" + 
				"det er Auswurfschock (S. 226). Die Probe ist nur dann eine\r\n" + 
				"Vergleichende Probe, wenn der Charakter von jemandem mit\r\n" + 
				"einer Linksperre (S. 226) belegt wurde. Dann ist das Icon, das\r\n" + 
				"seine Verbindung sperrt, der Verteidiger. Wenn mehr als eine\r\n" + 
				"Persona den Charakter mit einer Linksperre belegt hat, muss\r\n" +
				"er jeden Gegner einzeln besiegen. Er legt eine einzelne Probe\r\n" + 
				"ab, und jeder Gegner legt eine eigene Verteidigungsprobe ab.\r\n" + 
				"Man kann nur sich selbst ausstöpseln. Man kann nieman-\r\n" + 
				"den auswerfen, es sei denn, man setzt ihn durch Matrixscha-\r\n" + 
				"den außer Gefecht.";
				break;
		case 8: text = "BEFEHL VORTÄUSCHEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1 (siehe Beschreibung)\r\n" + 
				"Probe: Hacking + Intuition [Schleicher] gegen Logik + Fi-\r\n" + 
				"rewall\r\n" + 
				"Der Charakter täuscht vor, der Besitzer des Geräts zu sein\r\n" + 
				"und ihm legitime Befehle zu erteilen. Dafür braucht er eine\r\n" + 
				"Marke auf dem Icon des Besitzers, nicht dem des Geräts. Die\r\n" + 
				"Gegenseite wehrt sich aber basierend auf dem Gerät. Dieser\r\n" + 
				"Trick funktioniert nur bei Geräten oder Agenten, nicht bei IC,\r\n" + 
				"Sprites, Hosts, Personas oder anderen Icons.\r\n" + 
				"Wenn der Charakter diese Handlung durchführt, kann\r\n" + 
				"er dem Gerät befehlen, etwas zu tun, was es normalerwei-\r\n" + 
				"se autonom oder semi-autonom tun kann. Ein Magschloss\r\n" + 
				"kann sich öffnen oder schließen, eine Smartgun kann ihren\r\n" + 
				"Ladestreifen auswerfen oder ihren Feuermodus ändern, eine\r\n" + 
				"Drohne kann Leute von ihrer Zielliste entfernen oder zu ihr\r\n" + 
				"hinzufügen – und das sind nur einige Beispiele. Die meisten\r\n" + 
				"Geräte können (anders als Agenten, bei denen Befehl Vortäu-\r\n" + 
				"schen auch funktioniert) keine eigenen Matrixhandlungen wie\r\n" + 
				"Marke Einladen, Interfacemodus Wechseln oder Ausstöpseln\r\n" + 
				"durchführen, aber die meisten können sich neu starten oder\r\n" + 
				"Nachrichten übermitteln. Wenn der Spielleiter nicht sicher ist,\r\n" + 
				"ob ein Gerät in der Lage ist, den Befehl des Charakters aus-\r\n" + 
				"zuführen, kann er eine Probe auf Gerätestufe x 2 (mit einem\r\n" + 
				"Schwellenwert je nach Situation) ablegen, um herauszuf n-\r\n" + 
				"den, ob das Gerät den Befehl des Charakters versteht.";
				break;
		case 9: text = "BRUTE FORCE\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: Matrixkampf + Logik [Angriff] gegen Willenskraft +\r\n" + 
				"Firewall\r\n" + 
				"Mit dieser Handlung kann ein Charakter uneingeladen eine\r\n" + 
				"Marke auf einem Ziel platzieren. Diese Handlung wird von\r\n" + 
				"Hackern genutzt, die das Attribut Angriff dem Attribut Schlei-\r\n" + 
				"cher vorziehen (und ist mit dem Eiligen Hacken verwandt).\r\n" + 
				"Wenn der Charakter bei dieser Handlung Erfolg hat, platziert\r\n" + 
				"er eine Marke auf dem Ziel. Er kann auf einem Icon maximal 3\r\n" + 
				"Marken platzieren. Wenn er will, kann er dem Ziel außerdem\r\n" + 
				"pro volle 2 Nettoerfolge 1 Kästchen Matrixschaden zufügen,\r\n" + 
				"wenn es Matrixschaden erleiden kann. Diesem Schaden wird\r\n" + 
				"mit Gerätestufe + Firewall widerstanden.\r\n" + 
				"Vor dem Würfeln kann der Charakter ansagen, dass er mehr\r\n" + 
				"als eine Marke auf einmal platzieren will. Wenn er 2 Marken\r\n" + 
				"gleichzeitig platzieren will, erhält er einen Würfelpoolmodi-\r\n" + 
				"f kator von -4 auf die Probe. Wenn er es mit 3 Marken auf\r\n" + 
				"einmal versucht, beträgt der Malus -10.\r\n" + 
				"Ein Charakter kann mit dieser Handlung auch in ein Gitter\r\n" + 
				"wechseln, zu dem er keinen legalen Zugang hat. Der Verteidi-\r\n" + 
				"gungspool dagegen beträgt 4 für ein lokales Gitter und 6 für\r\n" + 
				"ein globales Gitter. Wenn dem Charakter die Probe gelingt,\r\n" + 
				"platziert er keine Marke auf dem Gitter, sondern springt so-\r\n" +
				"fort in das entsprechende Gitter. Ein erfolgreicher Gitterwech-\r\n" + 
				"sel mit Brute Force alarmiert das Gitter oder seinen Halbgott\r\n" + 
				"nicht in gleicher Weise, wie das die meisten anderen erfolg-\r\n" + 
				"reichen Angriffshandlungen tun (s. Das Bemerken von Hackern,\r\n" + 
				"S. 232).";
				break;
		case 10: text = "DATEI CRACKEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: Hacking + Logik [Angriff] gegen Schutzstufe x 2\r\n" + 
				"Der Charakter knackt mit dieser Handlung den Schutz einer\r\n" + 
				"Datei, wodurch sie lesbar und editierbar wird. Bei einer unge-\r\n" + 
				"schützten Datei muss diese Handlung natürlich nicht durch-\r\n" + 
				"geführt werden.";
				break;
		case 11: text = "DATEI EDITIEREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: Computer + Logik [Datenverarbeitung] gegen Intu-\r\n" + 
				"ition + Firewall\r\n" + 
				"Diese Handlung erlaubt es, Dateien zu erstellen, zu ändern,\r\n" + 
				"zu kopieren, zu schützen oder zu löschen. Der Verteidiger bei\r\n" + 
				"dieser Probe ist entweder der Host, auf dem die Datei liegt,\r\n" + 
				"oder der Besitzer der Datei (wenn sie sich nicht auf einem\r\n" + 
				"Host bef ndet). Mit jeder Handlung kann ein Detail der Da-\r\n" + 
				"tei verändert werden: ein kurzer Absatz Text, ein Detail ei-\r\n" + 
				"nes Bilds oder zwei bis drei Sekunden Video oder Audio (Sie\r\n" + 
				"müssen gemeinsam mit dem Spielleiter festlegen, was genau\r\n" + 
				"gemacht werden kann). Der Spielleiter kann einen Malus für\r\n" + 
				"diese Probe festlegen, wenn komplexe oder schwierige Än-\r\n" + 
				"derungen vorgenommen werden sollen. Wenn der Charakter\r\n" + 
				"eine Datei fortlaufend ändern (also etwa sein Team aus einer\r\n" + 
				"Videoübertragung entfernen) will, muss er diese Handlung\r\n" + 
				"einmal pro Kampfrunde durchführen, solange er diese Ände-\r\n" + 
				"rungen vornehmen will.\r\n" + 
				"Wenn der Charakter diese Handlung einsetzt, um eine Datei\r\n" + 
				"zu kopieren, wird er zum Besitzer der Kopie. Wenn die Datei,\r\n" + 
				"die er zu kopieren versucht, geschützt ist, scheitert die Hand-\r\n" + 
				"lung automatisch. Wenn die Datei eine Datenbombe hat, wird\r\n" + 
				"diese gezündet (man sollte also Dateien immer überprüfen,\r\n" + 
				"bevor man sie öffnet).\r\n" + 
				"Wenn der Charakter der Besitzer einer Datei ist, kann er sie\r\n" + 
				"mit dieser Handlung auch schützen. Um eine Datei zu schüt-\r\n" + 
				"zen, ist eine Erfolgsprobe auf Computer + Logik [Datenver-\r\n" + 
				"arbeitung] erforderlich. Die Anzahl der Erfolge dabei wird\r\n" + 
				"zur Schutzstufe der Datei. Eine geschützte Datei kann nicht\r\n" + 
				"gelesen, verändert, gelöscht oder kopiert werden, bevor der\r\n" + 
				"Schutz durchbrochen wurde.";
				break;
		case 12: text = "DATENBOMBE ENTSCHÄRFEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: Keine\r\n" + 
				"Probe: Software + Intuition [Firewall] gegen Stufe der Da-\r\n" + 
				"tenbombe x 2\r\n" + 
				"Der Charakter versucht, eine Datenbombe zu entschärfen,\r\n" + 
				"die er (gewöhnlich durch eine Matrixwahrnehmungsprobe)\r\n" + 
				"entdeckt hat. Wenn er Nettoerfolge erzielt, wird die Daten-\r\n" +
				"bombe entschärft und gelöscht. Wenn nicht, wird sie aktiviert,\r\n" + 
				"verursacht Schaden und löscht vielleicht die Datei, in die sie\r\n" + 
				"eingepf anzt wurde (wenn das in ihrem Code vorgesehen ist).";
				break;
		case 13: text = "DATENBOMBE LEGEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: Software + Logik [Schleicher] gegen Gerätestufe x 2\r\n" + 
				"Der Charakter platziert eine Datenbombe in einer Datei.\r\n" + 
				"Wenn er das tut, legt er die Stufe der Datenbombe fest, die\r\n" + 
				"maximal so hoch sein kann wie die Anzahl seiner Nettoer-\r\n" + 
				"folge bei der Probe. Außerdem muss er festlegen, ob die Da-\r\n" + 
				"tenbombe die verminte Datei löschen soll, wenn sie aktiviert\r\n" + 
				"wird, und er muss ein Passwort festlegen, das die Datenbom-\r\n" + 
				"be davon abhält, hochzugehen. Eine Datei kann nur eine Da-\r\n" + 
				"tenbombe gleichzeitig enthalten.\r\n" + 
				"Die Datenbombe wird ausgelöst, wenn jemand ohne Be-\r\n" + 
				"nutzung des Passworts versucht, die Datei zu lesen, zu ver-\r\n" + 
				"ändern, zu kopieren, zu schützen oder zu löschen oder eine\r\n" + 
				"andere Datenbombe darin zu legen. Wenn eine Datenbombe\r\n" + 
				"hochgeht, verursacht sie (Stufe x W6) Matrixschaden beim\r\n" + 
				"auslösenden Icon (das dem Schaden wie gewohnt wider-\r\n" + 
				"steht), löscht die Datei (wenn sie so eingestellt ist) und an-\r\n" + 
				"schließend sich selbst. Wenn das Passwort benutzt wird, akti-\r\n" + 
				"viert sich die Datenbombe nicht. Stattdessen bleibt sie in der\r\n" + 
				"Datei und wartet auf den nächsten Zugriff.\r\n" + 
				"Eine Datenbombe kann mit Matrixwahrnehmung entdeckt\r\n" + 
				"werden. Wenn sie entdeckt ist, kann sie mit der Handlung Da-\r\n" + 
				"tenbombe Entschärfen entschärft werden. Eine entschärfte\r\n" + 
				"Datenbombe wird gelöscht.";
				break;		
		case 14: text = "DATENSPIKE\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: Keine\r\n" + 
				"Probe: Matrixkampf + Logik [Angriff] gegen Intuition + Fi-\r\n" + 
				"rewall\r\n" + 
				"Der Charakter schickt Schadcode gegen eine Persona oder\r\n" + 
				"ein Gerät, was beim Ziel zu Matrixschaden führt. Sein Angriff\r\n" + 
				"hat einen Schadenscode gleich der Stufe seines Matrixattri-\r\n" + 
				"buts Angriff, der pro Nettoerfolg um 1 Kästchen erhöht wird.\r\n" + 
				"Außerdem erhöht jede Marke, die der Charakter auf dem Ziel\r\n" + 
				"platziert hat, den Schaden ebenfalls um 2 Kästchen. Dieser\r\n" + 
				"Schaden ist Matrixschaden (siehe S. 225), dem mit Geräte-\r\n" + 
				"stufe + Firewall widerstanden wird.";
				break;
		case 15: text = "EILIGES HACKEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: Hacking + Logik [Schleicher] gegen Intuition + Fi-\r\n" + 
				"rewall\r\n" + 
				"Der Charakter kann mit dieser Handlung uneingeladen eine\r\n" + 
				"Marke auf einem Ziel platzieren. Diese Handlung wird von\r\n" + 
				"Hackern genutzt, die das Attribut Schleicher dem Attribut An-\r\n" + 
				"griff vorziehen (und ist mit Brute Force verwandt).\r\n" + 
				"Wenn das Ziel ein Icon ist, platziert der Charakter, wenn er\r\n" + 
				"gewinnt, 1 bis maximal 3 Marken darauf. Außerdem zählen\r\n" + 
				"je 2 volle Nettoerfolge als 1 Erfolg bei einer Matrixwahrneh-\r\n" +
				"mungsprobe, sodass der Charakter auch noch ein paar Infor-\r\n" + 
				"mationen über das Ziel seiner Marke erhält.\r\n" + 
				"Vor dem Würfeln kann der Charakter ansagen, dass er mehr\r\n" + 
				"als eine Marke auf einmal platzieren will. Wenn er 2 Marken\r\n" + 
				"gleichzeitig platzieren will, erhält er einen Würfelpoolmodi-\r\n" + 
				"f kator von -4 auf die Probe. Wenn er es mit 3 Marken auf\r\n" + 
				"einmal versucht, beträgt der Malus -10.\r\n" + 
				"Ein Charakter kann mit dieser Handlung auch in ein Gitter\r\n" + 
				"wechseln, zu dem er keinen legalen Zugang hat. Der Vertei-\r\n" + 
				"digungspool dagegen beträgt 4 für ein lokales Gitter und 6\r\n" + 
				"für ein globales Gitter. Wenn dem Charakter die Probe ge-\r\n" + 
				"lingt, platziert er keine Marke auf dem Gitter, sondern springt\r\n" + 
				"sofort in das entsprechende Gitter. Ein misslungener Gitter-\r\n" + 
				"wechsel mittels Eiligem Hacken alarmiert das Gitter oder\r\n" + 
				"seinen Halbgott nicht in der Weise, wie das bei den meisten\r\n" + 
				"misslungenen Schleicherhandlungen geschieht (s. Das Bemer-\r\n" + 
				"ken von Hackern, S. 232).";
				break;
		case 16: text = "GERÄT FORMATIEREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 3\r\n" + 
				"Probe: Computer + Logik [Schleicher] gegen Willenskraft\r\n" + 
				"+ Firewall\r\n" + 
				"Der Charakter schreibt den Bootsektor des Geräts um. Beim\r\n" + 
				"nächsten Neustart schaltet sich das Gerät einfach dauerhaft\r\n" + 
				"aus. Das kann durch das Ersetzen der Software wieder beho-\r\n" + 
				"ben werden, wozu eine Ausgedehnte Probe auf Software +\r\n" + 
				"Logik [Geistig] (12, 1 Stunde) nötig ist. Ein Gerät, das sich auf\r\n" + 
				"diese Weise ausgeschaltet hat, verliert alle seine WiFi-Vortei-\r\n" + 
				"le, kann aber weiter als normaler Mechanismus benutzt wer-\r\n" + 
				"den (eine Tür mit Klinke kann geöffnet werden, eine Waffe mit\r\n" + 
				"Abzug kann abgefeuert werden usw.). Außerdem ist es nicht\r\n" + 
				"mehr über die Matrix erreichbar.";
				break;
		case 17: text = "GERÄT NEU STARTEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 3\r\n" + 
				"Probe: Computer + Logik [Datenverarbeitung] gegen Wil-\r\n" + 
				"lenskraft + Firewall\r\n" + 
				"Das Zielgerät dieser Handlung schaltet sich ab und startet\r\n" + 
				"sofort neu. Es ist am Ende der nächsten Kampfrunde wieder\r\n" + 
				"online. Das Gerät stellt seine elektronischen Funktionen ein\r\n" + 
				"und verschwindet aus der Matrix, bis es neu gestartet ist.\r\n" + 
				"Wenn der Charakter das Gerät, auf dem seine Persona läuft,\r\n" + 
				"neu startet, wird sein Betriebssystem zurückgesetzt, alle seine\r\n" + 
				"Marken verschwinden, und alle Marken von anderen Perso-\r\n" + 
				"nas auf seinem Icon verschwinden. Wenn er sich in der VR\r\n" + 
				"bef ndet, während er den Neustart durchführt, erleidet er Aus-\r\n" + 
				"wurfschock (S. 226). Wenn er wieder online ist, kann sein Icon\r\n" + 
				"auf jedem Gitter erscheinen, zu dem er eine Zugangsberech-\r\n" + 
				"tigung hat – oder auf dem öffentlichen Gitter, wenn er keine\r\n" + 
				"Zugangsberechtigungen hat.\r\n" + 
				"Wenn der Charakter diese Handlung durchführt, kann er\r\n" + 
				"zwischen dem Abschalten und dem Neustart eine beliebige\r\n" + 
				"Verzögerung einrichten. Wer physischen Zugang zu dem Ge-\r\n" + 
				"rät hat, kann diese Verzögerung zunichtemachen, indem er\r\n" + 
				"den Netzschalter drückt, was das Gerät zum Starten zwingt.\r\n" + 
				"Dann ist das Gerät am Ende der nächsten Kampfrunde wieder\r\n" + 
				"online.\r\n" +
				"Diese Handlung funktioniert nur bei Geräten. Sie funktioniert\r\n" + 
				"nicht bei Hosts, Lebewesen (wie Technomancern, die sich al-\r\n" + 
				"lerdings selbst „neu starten“ können, siehe S. 249) oder Reso-\r\n" + 
				"nanzkonstrukten (wie etwa Sprites). Die einzige Persona, bei der\r\n" + 
				"diese Handlung funktioniert, ist die des Charakters. Wenn der\r\n" + 
				"Charakter der Besitzer des Geräts ist, das er neu startet, muss er\r\n" + 
				"keine Probe ablegen. Er kann diese Handlung nicht mit einem\r\n" + 
				"Gerät durchführen, das mit einer Linksperre (S. 226) belegt ist.";
				break;
		case 18: text = "GERÄT STEUERN\r\n" + 
				"(JE NACH HANDLUNG)\r\n" + 
				"Benötigte Marken: variabel\r\n" + 
				"Probe: (je nach Handlung) [Datenverarbeitung (oder spezi-\r\n" + 
				"ell)] gegen (je nach Handlung) oder Elektronische Kriegsfüh-\r\n" + 
				"rung + Intuition [Schleicher] gegen Intuition + Firewall\r\n" + 
				"Mit seinem Kommlink oder Deck als Fernsteuerung führt\r\n" + 
				"der Charakter mit einem Gerät, über das er genügend Kon-\r\n" + 
				"trolle hat, eine Handlung durch. Der Würfelpool der Proben\r\n" + 
				"wird dabei aus der passenden Fertigkeit + dem Attribut ge-\r\n" + 
				"bildet, die auch bei der normalen Benutzung des Geräts\r\n" + 
				"eingesetzt würden. Würde man zum Beispiel die montierte\r\n" + 
				"Waffe einer Drohne abfeuern, müsste man mit Geschütze +\r\n" + 
				"Geschicklichkeit würfeln, bei einem ferngesteuerten Unter-\r\n" + 
				"wasserschweißgerät hingegen mit Seefahrtmechanik + Logik.\r\n" + 
				"Alle Handlungen, die der Charakter mit Gerät Steuern durch-\r\n" + 
				"führt, nutzen entweder das normale Limit oder sein Attribut\r\n" + 
				"Datenverarbeitung, je nachdem, welches niedriger ist. Wenn\r\n" + 
				"es zu der Handlung, die der Charakter durchführen will, keine\r\n" + 
				"Probe gibt (wie etwa beim Aufsperren eines Magschlosses\r\n" + 
				"oder dem Auswerfen eines Ladestreifens) muss ihm eine Ver-\r\n" + 
				"gleichende Probe auf Elektronische Kriegsführung + Intuition\r\n" + 
				"[Schleicher] gegen Intuition + Firewall gelingen.\r\n" + 
				"Man kann mit dieser Handlung mehrere Geräte gleichzei-\r\n" + 
				"tig steuern. Wenn man der Besitzer aller gesteuerten Geräte\r\n" + 
				"ist und alle Geräte exakt dasselbe tun sollen, werden alle mit\r\n" + 
				"demselben Würfelpool und derselben Handlung bedient. An-\r\n" + 
				"sonsten wird der Würfelpool des Charakters auf alle Geräte\r\n" + 
				"aufgeteilt, die er mit einer einzigen Handlung steuern will.\r\n" + 
				"Die Art der Handlung (Frei, Einfach oder Komplex) ist die-\r\n" + 
				"selbe wie bei der normalen Benutzung des Geräts. Für eine\r\n" + 
				"Freie Handlung braucht man 1 Marke, für eine Einfache Hand-\r\n" + 
				"lung 2 Marken und für eine Komplexe Handlung 3 Marken\r\n" + 
				"auf dem Gerät.\r\n" + 
				"Diese Handlung ist eine Schleicherhandlung, sofern Schlei-\r\n" + 
				"cher als Limit verwendet wird, und unterliegt dann demselben\r\n" + 
				"Risiko eines Overwatch-Werts und denselben Konsequenzen\r\n" + 
				"beim Misslingen wie alle Schleicherhandlungen.";
				break;
		case 19: text = "GITTERWECHSEL\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: keine (Datenverarbeitungshandlung)\r\n" + 
				"Der Charakter springt in ein anderes Gitter, zum Beispiel\r\n" + 
				"vom öffentlichen Gitter nach Emerald City, dem lokalen Gitter\r\n" + 
				"von Seattle. Um das durchzuführen, muss er eine Zugangs-\r\n" + 
				"berechtigung für das Zielgitter haben. Wen er diese nicht hat,\r\n" + 
				"muss er mit Brute Force oder Eiligem Hacken das Gitter wech-\r\n" + 
				"seln. Wenn er sich in einem Host bef ndet, muss er diesen erst\r\n" + 
				"verlassen, bevor er das Gitter wechseln kann.";
				break;
		case 20: text = "HOST BETRETEN/VERLASSEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: keine\r\n" + 
				"Der Charakter betritt einen Host, auf dem er eine Marke\r\n" + 
				"platziert hat, und sein Icon erscheint dort. Oder er verlässt\r\n" + 
				"den Host, in dem er sich bef ndet. Zu dieser Handlung gibt es\r\n" + 
				"keine Probe: Ein Host lässt jeden rein, der eine Marke auf ihm\r\n" + 
				"hat, und jeder, der in einem Host ist, kann ihn verlassen. Der\r\n" + 
				"Host ist aber im Inneren vielleicht nicht mehr so freundlich,\r\n" + 
				"und einige IC-Arten können Personas in einem Host gefangen\r\n" + 
				"halten, bis sie ausbrechen können.\r\n" + 
				"Wenn der Charakter einen Host verlässt, kehrt er in das Git-\r\n" + 
				"ter zurück, aus dem er ihn betreten hat.";
				break;
		case 21: text = "ICON AUFSPÜREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 2\r\n" + 
				"Probe: Computer + Intuition [Datenverarbeitung] gegen\r\n" + 
				"Willenskraft + Schleicher\r\n" + 
				"Der Charakter f ndet den physischen Aufenthaltsort eines Ge-\r\n" + 
				"räts oder einer Persona. Wenn er bei dieser Handlung Erfolg hat,\r\n" + 
				"kennt immer er den Aufenthaltsort des Ziels, solange er mindes-\r\n" + 
				"tens 1 Marke darauf hat. Zum ersten Durchführen der Handlung\r\n" + 
				"muss er allerdings 2 Marken auf dem Ziel haben. Diese Hand-\r\n" + 
				"lung funktioniert nur bei Hosts, die mit einem einzigen physi-\r\n" + 
				"schen Ort verbunden sind. Die meisten Hosts sind allerdings\r\n" + 
				"über mehrere Datenzentren verteilt, die ihrem Besitzer (oder\r\n" + 
				"dem Provider ihres Besitzers) gehören. IC-Programme sind auf\r\n" + 
				"ihren jeweiligen Host beschränkt, weswegen Icon Aufspüren bei\r\n" + 
				"ihnen denselben Beschränkungen wie bei Hosts unterliegt.";
				break;
		case 22: text = "ICON VERÄNDERN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Benötigte Marken: Besitzer\r\n" + 
				"Probe: keine (Datenverarbeitungshandlung)\r\n" + 
				"Der Charakter verändert das Icon des Ziels zu einem, von\r\n" + 
				"dem er eine Kopie hat oder das er selbst entworfen hat. Das\r\n" + 
				"Verändern eines Icons ändert nichts an den Ergebnissen einer\r\n" + 
				"Matrixwahrnehmung, kann aber Personas reinlegen, die nicht\r\n" + 
				"die Zeit haben, genau nachzusehen. Man kann natürlich auch\r\n" + 
				"sein eigenes Icon verändern.";
				break;
		case 23: text = "INTERFACEMODUS WECHSELN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Benötigte Marken: Besitzer\r\n" + 
				"Probe: keine (Datenverarbeitungshandlung)\r\n" + 
				"Der Charakter schaltet zwischen AR und VR um. Das Um-\r\n" + 
				"schalten zur VR lässt seinen Körper erschlaffen, also sollte er\r\n" + 
				"das nicht in gefährlicher Umgebung tun. Wenn er von der VR\r\n" + 
				"in die AR wechselt, verliert er die Bonus-Initiativewürfel aus\r\n" + 
				"der VR (s. Veränderung der Initiative, S. 161). Wenn der Charak-\r\n" + 
				"ter mit einer Linksperre (S. 226) belegt ist, kann er den Inter-\r\n" + 
				"facemodus nicht wechseln.\r\n" + 
				"Der Charakter kann diese Handlung nur bei sich selbst\r\n" + 
				"durchführen, nicht bei anderen Leuten.";
				break;
		case 24: text = "IN EIN GERÄT SPRINGEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 3\r\n" + 
				"Probe: Elektronische Kriegsführung + Logik [Datenverar-\r\n" + 
				"beitung] gegen Willenskraft + Firewall\r\n" + 
				"Mit dieser Handlung springt ein Charakter in ein Gerät mit\r\n" + 
				"Riggerinterface (meist ein Fahrzeug oder eine Drohne). Es gibt\r\n" + 
				"allerdings einige Voraussetzungen, die dafür erfüllt sein müs-\r\n" + 
				"sen: Der Charakter muss 3 Marken auf dem Gerät haben, er\r\n" + 
				"muss sich in der VR bef nden, das Gerät muss ein Riggerin-\r\n" + 
				"terface haben, und der Charakter muss eine Riggerkontrolle\r\n" + 
				"haben. Wenn der Charakter der Besitzer des Geräts ist oder\r\n" + 
				"der Besitzer ihm das Hineinspringen erlaubt hat, ist dafür kei-\r\n" + 
				"ne Probe nötig. In der Matrix wird das Icon des Geräts, in das\r\n" + 
				"der Charakter hineingesprungen ist, zum Teil seiner Persona.\r\n" + 
				"Wenn bereits jemand anderer in das Gerät hineingesprun-\r\n" + 
				"gen ist, kann der Charakter diese Handlung nicht durchführen,\r\n" + 
				"bis der andere das Gerät verlässt.";
				break;
		case 25: text = "MARKE EINLADEN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Benötigte Marken: Besitzer\r\n" + 
				"Probe: keine (Datenverarbeitungshandlung)\r\n" + 
				"Wenn der Charakter der Besitzer eines Geräts, einer Datei\r\n" + 
				"oder Persona, eines Hosts oder eines IC ist, kann er andere Icons\r\n" + 
				"einladen, darauf eine Marke zu platzieren. Er kann bei dieser Ein-\r\n" + 
				"ladung festlegen, wie viele Marken er zulassen will, wie lange\r\n" + 
				"diese bestehen bleiben und wie lange die Einladung gilt. Der\r\n" + 
				"Eingeladene kann seine Marke(n) dann mit einer Freien Hand-\r\n" + 
				"lung platzieren. Der Charakter kann diese Einladung jederzeit\r\n" + 
				"widerrufen, bevor die Marke platziert wurde. Wenn allerdings\r\n" + 
				"ein anderes Icon schon eine Marke platziert hat, muss er entwe-\r\n" + 
				"der die Handlung Marke Löschen durchführen oder das Gerät\r\n" + 
				"neu starten, um diese vor Ablauf ihres Bestehens loszuwerden.";
				break;
		case 26: text = "MARKE LÖSCHEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: speziell\r\n" + 
				"Probe: Computer + Logik [Angriff] gegen Willenskraft + Fi-\r\n" + 
				"rewall\r\n" + 
				"Der Charakter löscht eine Marke, die auf seiner Persona oder\r\n" + 
				"einem anderen Icon platziert wurde. Um diese Handlung durch-\r\n" + 
				"zuführen, muss er selbst 3 Marken auf dem Icon haben, von dem\r\n" + 
				"er eine Marke löschen will (oder dessen Besitzer sein). Er braucht\r\n" + 
				"aber keine Marke auf dem Icon, das die Marke platziert hat. Er\r\n" + 
				"kann versuchen, mit derselben Handlung 2 Marken zu löschen,\r\n" + 
				"was allerdings einen Malus von -4 ergibt. Mit einem Malus von\r\n" + 
				"-10 kann er 3 Marken auf einmal löschen. Wenn er mehr als eine\r\n" + 
				"Marke auf einmal löschen will, müssen all diese Marken vom\r\n" + 
				"selben Icon platziert worden sein. Der Charakter kann mit dieser\r\n" + 
				"Handlung nicht die Besitzrechte am Zielicon verändern.\r\n" + 
				"Nehmen wir an, ein IC hätte Sie und Ihren Kumpel markiert.\r\n" + 
				"Sie würfeln mit Computer + Logik [Angriff] gegen die Stufe\r\n" + 
				"des IC (statt Willenskraft) + Firewall, um die Marke von Ihrem\r\n" + 
				"eigenen Icon zu löschen. Sie brauchen 3 Marken auf dem Icon\r\n" + 
				"Ihres Kumpels, um die Marken des IC davon zu löschen, aber\r\n" + 
				"er hat das nicht zugelassen, also ist er auf sich selbst gestellt.";
				break;
		case 27: text = "MATRIXSIGNATUR LÖSCHEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: Computer + Resonanz [Angriff] gegen Signaturstufe x 2\r\n" + 
				"Der Charakter löscht eine Matrixsignatur, die von einem\r\n" + 
				"Resonanzwesen, wie etwa einem Technomancer oder Sprite,\r\n" + 
				"hinterlassen wurde. Wenn die Probe gelingt, verschwindet die\r\n" + 
				"Signatur. Der Charakter muss das Attribut Resonanz besitzen,\r\n" + 
				"um diese Handlung durchzuführen. Anders als andere Reso-\r\n" + 
				"nanzhandlungen ist dies eine echte Matrixhandlung und dazu\r\n" + 
				"noch eine Angriffshandlung, also können Matrixschaden und\r\n" + 
				"Overwatch-Wert entstehen.";
				break;
		case 28: text = "MATRIXSUCHE\r\n" + 
				"(JE NACH HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: Computer + Intuition [Datenverarbeitung]\r\n" + 
				"Der Charakter sucht in der Matrix nach Informationen zu\r\n" + 
				"einem Thema. Wie lange das dauert und welcher Schwel-\r\n" + 
				"lenwert für die Probe gilt, hängt von der Verfügbarkeit der\r\n" + 
				"entsprechenden Information und dem durchsuchten Bereich\r\n" + 
				"ab. Jeder Nettoerfolg kann genutzt werden, um die Suche zu\r\n" + 
				"beschleunigen. Dazu wird der Grundzeitraum durch die An-\r\n" + 
				"zahl der Nettoerfolge dividiert. Wenn die Probe misslingt,\r\n" + 
				"verbringt der Charakter trotzdem den vollen Grundzeitraum\r\n" + 
				"mit der Suche (auch wenn er nichts f ndet).\r\n" + 
				"Manche Informationen sind geschützt und geheim und lie-\r\n" + 
				"gen auf einem Host, der nicht öffentlich zugänglich ist. Das\r\n" + 
				"Auff nden solcher Informationen setzt meist voraus, dass\r\n" + 
				"der Charakter den Host f ndet und betritt, in dem die Daten\r\n" + 
				"versteckt sind. Dann kann er innerhalb des Hosts eine Mat-\r\n" + 
				"rixsuche mit einem Grundzeitraum von 1 Minute (unabhän-\r\n" + 
				"gig von der Art der gesuchten Information) durchführen. Das\r\n" + 
				"funktioniert aber nur, wenn auf diese Information wenigstens\r\n" + 
				"gelegentlich von den legalen Nutzern zugegriffen wird. Wenn\r\n" + 
				"sie sich in einem Archiv bef ndet, muss der Charakter tiefer in\r\n" + 
				"den Host eindringen – ein gefährliches Unterfangen, das im\r\n" + 
				"bald erscheinenden Matrix-Quellenbuch weiter erklärt wird.";
				break;
		case 29: text = "MATRIXWAHRNEHMUNG\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: Computer + Intuition [Datenverarbeitung] (gegen\r\n" + 
				"Logik + Schleicher)\r\n" + 
				"Diese wichtige und vielseitige Handlung wird zum Finden\r\n" + 
				"von Icons und zum Analysieren von Objekten in der Matrix\r\n" + 
				"verwendet. Wenn ein Charakter diese Handlung durchführt,\r\n" + 
				"um ein Matrixobjekt zu analysieren oder in der Umgebung\r\n" + 
				"nach Icons auf Schleichfahrt zu suchen, legt er eine Erfolgs-\r\n" + 
				"probe ab, deren Erfolge angeben, wie viel er herausf ndet.\r\n" + 
				"Für jeden Nettoerfolg kann er eine Information erhalten: die\r\n" + 
				"Geräteart, eine Stufe, die Anzahl an Marken auf dem Objekt,\r\n" + 
				"Dateien, die das Icon trägt, das benutzte Gitter, ob es in der\r\n" + 
				"Umgebung Icons auf Schleichfahrt gibt oder andere passen-\r\n" + 
				"de Matrixinformationen. Wenn der Charakter etwas über\r\n" + 
				"Marken erfährt, kann er nur Marken erkennen, die er bereits\r\n" + 
				"einmal gesehen hat oder die von Personas platziert wurden,\r\n" + 
				"auf denen er selbst Marken platziert hat. Ansonsten erhält er\r\n" + 
				"nur die Zahl der Marken als Information.\r\n" + 
				"Wenn der Charakter versucht, ein Icon zu erkennen, das\r\n" + 
				"mehr als 100 Meter entfernt ist, legt er eine Erfolgsprobe ab:\r\n" + 
				"Der erste Erfolg lässt ihn das Ziel erkennen, zusätzliche Er-\r\n" + 
				"folge können wie oben erwähnt Zusatzinformationen geben.\r\n" + 
				"Wenn er nach einem Icon sucht, das auf Schleichfahrt läuft\r\n" + 
				"(nachdem er erfahren hat, dass es ein solches gibt), wird die\r\n" + 
				"Probe zur Vergleichenden Probe, wobei das Ziel sich mit Lo-\r\n" + 
				"gik + Schleicher wehrt. Nettoerfolge werden wie beim Entde-\r\n" + 
				"cken eines entfernten Ziels behandelt: Der erste Nettoerfolg\r\n" + 
				"lässt den Charakter das Ziel erkennen, weitere Nettoerfolge\r\n" + 
				"liefern Zusatzinformationen.";
				break;
		case 30: text = "NACHRICHT ÜBERMITTELN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: keine (Datenverarbeitungshandlung)\r\n" + 
				"Der Charakter schickt eine Text- oder Audionachricht (ei-\r\n" + 
				"nen kurzen Satz), ein Bild oder eine Datei durch die Matrix zu\r\n" + 
				"einem User, dessen Kommcode er hat. Wenn der Charakter\r\n" + 
				"die Matrix durch ein DNI benutzt, kann er – selbst in der AR\r\n" + 
				"– längere und kompliziertere Botschaften versenden (etwa ei-\r\n" + 
				"nen Absatz an Text). Außerdem kann er diese Handlung ver-\r\n" + 
				"wenden, um eine Live-Übertragung für einen oder mehrere\r\n" + 
				"Empfänger zugänglich zu machen, die von einem digitalen\r\n" + 
				"Aufzeichnungsgerät, das er hat, aufgezeichnet wird. Drohnen\r\n" + 
				"kann man mit dieser Handlung auch Befehle übermitteln.";
				break;
		case 31: text = "OVERWATCH-WERT BESTIMMEN\r\n" + 
				"(EINFACHE HANDLUNG)\r\n" + 
				"Benötigte Marken: Keine\r\n" + 
				"Probe: Elektronische Kriegsführung + Logik [Schleicher]\r\n" + 
				"gegen 6 Würfel\r\n" + 
				"Der Charakter kann herausf nden, wie dicht ihm die Halb-\r\n" + 
				"götter des Gitters auf den Fersen sind. Das Bestimmen des\r\n" + 
				"OW ist eine Schleicherhandlung, also erhöht sich der OW um\r\n" + 
				"die Erfolge der Gegenseite. Bei einem Erfolg teilt Ihnen der\r\n" + 
				"Spielleiter den OW mit, der vor der Handlung bestanden hat.\r\n" + 
				"Dann erhöht er ihn entsprechend der Erfolge der Gegenseite.";
				break;
		case 32: text = "PROGRAMM ABSTÜRZEN LASSEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: Matrixkampf + Logik [Angriff] gegen Intuition + Fi-\r\n" + 
				"rewall\r\n" + 
				"Der Charakter überlastet einen Teil des Hauptspeichers des\r\n" + 
				"Ziels und bringt damit eines seiner laufenden Programme\r\n" + 
				"zum Absturz. Er muss ansagen, welches Programm er abstür-\r\n" + 
				"zen lassen will. Der Charakter kann entweder durch Matrix-\r\n" + 
				"wahrnehmung oder dadurch, dass er das Programm in Aktion\r\n" + 
				"sieht, herausf nden, welche Programme das Ziel laufen lässt.\r\n" + 
				"Wenn der Charakter gewinnt, stürzt das Programm ab: Es wird\r\n" + 
				"beendet und kann erst wieder gestartet werden, wenn das zu-\r\n" + 
				"gehörige Gerät neu gestartet wird.";
				break;
		case 33: text = "SIGNAL STÖREN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: Besitzer\r\n" + 
				"Probe: Elektronische Kriegsführung + Logik [Angriff]\r\n" + 
				"Diese Handlung verwandelt das Gerät, das der Charakter\r\n" + 
				"benutzt, in einen kleinen Störsender. Solange der Charakter\r\n" + 
				"das Gerät nicht für andere Matrixhandlungen benutzt, addiert\r\n" + 
				"es seine Erfolge bei der Probe zum Rauschenwert für alle Ma-\r\n" + 
				"trixhandlungen mit oder gegen Geräte im Umkreis von 100\r\n" + 
				"Metern. Wenn der Charakter nur bestimmte Frequenzen oder\r\n" + 
				"Ziele stören will, sollte er einen echten Störsender kaufen –\r\n" + 
				"dafür sind sie schließlich da.";
				break;
		case 34: text = "ÜBERTRAGUNG ABFANGEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: 1\r\n" + 
				"Probe: Elektronische Kriegsführung + Intuition [Schleicher]\r\n" + 
				"gegen Logik + Firewall\r\n" + 
				"Mit dieser Handlung kann der Charakter Matrixübertragun-\r\n" + 
				"gen, die von und zu einem Ziel gesendet werden, abfangen,\r\n" + 
				"wenn er eine Marke auf dem Ziel hat. Er kann zusehen, zu-\r\n" + 
				"hören, mitlesen oder die Übertragung abspeichern, wenn er\r\n" + 
				"etwas hat, auf dem er sie speichern kann (zum Beispiel sein\r\n" + 
				"Deck).";
				break;
		case 35: text = "VERSTECKEN\r\n" + 
				"(KOMPLEXE HANDLUNG)\r\n" + 
				"Benötigte Marken: keine\r\n" + 
				"Probe: Elektronische Kriegsführung + Intuition [Schleicher]\r\n" + 
				"gegen Intuition + Datenverarbeitung\r\n" + 
				"Manchmal wird ein Charakter von einem anderen Icon ent-\r\n" + 
				"deckt, selbst wenn er auf Schleichfahrt läuft. Mit dieser Hand-\r\n" + 
				"lung kann er dafür sorgen, dass ein Ziel seine Spur verliert.\r\n" + 
				"Wenn die Probe gelingt, kann das Ziel ihn nicht mehr entde-\r\n" + 
				"cken und muss eine neue Matrixwahrnehmungsprobe able-\r\n" + 
				"gen, um ihn wiederzuf nden. Der Charakter kann sich nicht\r\n" + 
				"vor einem Icon verstecken, das eine Marke auf ihm platziert\r\n" + 
				"hat, also sollte er diese vor dieser Handlung löschen.";
				break;
		case 36: text = "VOLLE MATRIXABWEHR\r\n" + 
				"(UNTERBRECHUNGSHANDLUNG)\r\n" + 
				"Benötigte Marken: Besitzer\r\n" + 
				"Probe: keine (Firewallhandlung)\r\n" + 
				"Diese Handlung erlaubt es dem Charakter, in der Matrix\r\n" + 
				"auf Volle Abwehr zu gehen. Sie kann jederzeit durchgeführt\r\n" + 
				"werden. Wenn der Charakter eine Verteidigungsprobe gegen\r\n" + 
				"eine Matrixhandlung ablegt, darf er seine Willenskraft als Bo-\r\n" + 
				"nus zum Würfelpool addieren (oder noch mal addieren, wenn\r\n" + 
				"sie bereits Teil des Pools ist). Wenn der Charakter diese Hand-\r\n" + 
				"lung durchführt, wird sein Initiativeergebnis um 10 reduziert,\r\n" + 
				"aber die Wirkung hält bis zum Ende der Kampfrunde an.";
				break;
		}
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getName() {
		return name;
	}

	public String getSeite() {
		return seite;
	}

	public Handlungstyp getTyp() {
		return typ;
	}
	
	public static int getHandIDByName(String name) {
		return nameToHandID.get(name);
	}
}

enum Handlungstyp{
	RESONANZ, MATRIX, MAGIE, NORMAL;
}
//
//enum Wurfart{
//	VERPROBE, SCHWELLENWERT; 
//}
//
//enum Limit{
//	KOERPERLICH, GEISTIG, SOZIAL, PRAEZISION, ASTRAL, STUFE, FIREWALL;
//}
//
//enum Stufe{
//	KOMPLFORM, SPRITE;
//}