package sr5.classes;

import java.util.ArrayList;

public class Host {
  
	private int angriff, schleicher, dv, firewall;
	private ArrayList<IC> ics = new ArrayList<IC>();
	
	public Host(int angriff, int schleicher, int dv, int firewall) {
		this.angriff = angriff;
		this.schleicher = schleicher;
		this.dv = dv;
		this.firewall = firewall;
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
	
	public ArrayList<IC> getICs(){
		return ics;
	}
}
