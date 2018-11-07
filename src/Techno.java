import sr5.classes.Klasse;

public class Techno extends Chara {

	private int stufe, angriff, schleicher, dv, firewall, mzm;
	
	public Techno(int kon, int ges, int rea, int sta, int wil, int log, int iNT,
			int cha, int edge, double ess, int mag, String ini, String ina,
			String inks, String inhs, int kzm, int gzm, int panz, String name,
			String meta, Klasse klasse) {
		super(kon, ges, rea, sta, wil, log, iNT, cha, edge, ess, mag, ini, ina, inks, inhs, kzm, gzm, panz, name, meta, klasse);
		angriff = cha;
		schleicher = iNT;
		dv = log;
		firewall = wil;
		stufe = mag;
		mzm = gzm;
	}

	public int getStufe() {
		return stufe;
	}

	public int getAngriff() {
		return angriff;
	}

	public int getSchleicher() {
		return schleicher;
	}

	public int getDv() {
		return dv;
	}

	public int getFirewall() {
		return firewall;
	}

	public int getMzm() {
		return mzm;
	}
}
