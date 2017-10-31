
public class Chara {
  
  private int KON, GES, REA, STA, WIL, LOG, INT, CHA, EDG, MAG, KLIM, GLIM, SLIM, KZM, GZM, KZMAbs, GZMAbs, PANZ;
  private double ESS;
  private String INI, INA, INKS, INHS;
  private final String name, meta;

  public Chara(int kon, int ges, int rea, int sta, int wil, int log, int iNT, int cha, int edge, double ess, int mag, String ini, String ina, String inks, String inhs, int kzm, int gzm, int panz, String name, String meta){
    KON = kon;
    GES = ges;
    REA = rea;
    STA = sta;
    WIL = wil;
    LOG = log;
    INT = iNT;
    CHA = cha;
    EDG = edge;
    ESS = ess;
    MAG = mag;
    INI = ini;
    INA = ina;
    INKS = inks;
    INHS = inhs;
    // Setzt den aktuellen Wert der Zustandsmonitore
    setKZM(kzm);
    setGZM(gzm);
    setPANZ(panz);
    // Berechnet den maximalen Wert der Zustandsmonitore
    if (KON % 2 == 0) setKZMAbs(8 + KON/2);
    else setKZMAbs(9 + KON/2);
    if (WIL % 2 == 0) setGZMAbs(8 + WIL/2);
    else setGZMAbs(9 + WIL/2);
    KLIM = (int) Math.ceil((2* STA + KON + REA)/3);
    GLIM = (int) Math.ceil((2* LOG + INT + WIL)/3);
    SLIM = (int) Math.ceil((2* CHA + WIL + ESS)/3);
    this.name = name;
    this.meta = meta;
  }

  public int getKON() {
    return KON;
  }

  public void setKON(int kON) {
    KON = kON;
  }

  public int getGES() {
    return GES;
  }

  public void setGES(int gES) {
    GES = gES;
  }

  public int getREA() {
    return REA;
  }

  public void setREA(int rEA) {
    REA = rEA;
  }

  public int getSTA() {
    return STA;
  }

  public void setSTA(int sTA) {
    STA = sTA;
  }

  public int getWIL() {
    return WIL;
  }

  public void setWIL(int wIL) {
    WIL = wIL;
  }

  public int getLOG() {
    return LOG;
  }

  public void setLOG(int lOG) {
    LOG = lOG;
  }

  public int getINT() {
    return INT;
  }

  public void setINT(int iNT) {
    INT = iNT;
  }

  public int getCHA() {
    return CHA;
  }

  public void setCHA(int cHA) {
    CHA = cHA;
  }

  public int getEDG() {
    return EDG;
  }

  public void setEDG(int eDG) {
    EDG = eDG;
  }

  public int getMAG() {
    return MAG;
  }

  public void setMAG(int mAG) {
    MAG = mAG;
  }

  public int getKLIM() {
    return KLIM;
  }

  public void setKLIM(int kLIM) {
    KLIM = kLIM;
  }

  public int getGLIM() {
    return GLIM;
  }

  public void setGLIM(int gLIM) {
    GLIM = gLIM;
  }

  public int getSLIM() {
    return SLIM;
  }

  public void setSLIM(int sLIM) {
    SLIM = sLIM;
  }

  public double getESS() {
    return ESS;
  }

  public void setESS(double eSS) {
    ESS = eSS;
  }

  public String getINI() {
    return INI;
  }

  public void setINI(String iNI) {
    INI = iNI;
  }

  public String getINA() {
    return INA;
  }

  public void setINA(String iNA) {
    INA = iNA;
  }

  public String getINKS() {
    return INKS;
  }

  public void setINKS(String iNKS) {
    INKS = iNKS;
  }

  public String getINHS() {
    return INHS;
  }

  public void setINHS(String iNHS) {
    INHS = iNHS;
  }

  public String getName() {
    return name;
  }

  public String getMeta() {
    return meta;
  }

  public int getKZM() {
	return KZM;
  }

  public void setKZM(int kZM) {
	KZM = kZM;
  }

  public int getGZM() {
	return GZM;
  }

  public void setGZM(int gZM) {
	GZM = gZM;
  }

public int getKZMAbs() {
	return KZMAbs;
}

public void setKZMAbs(int kZMAbs) {
	KZMAbs = kZMAbs;
}

public int getGZMAbs() {
	return GZMAbs;
}

public void setGZMAbs(int gZMAbs) {
	GZMAbs = gZMAbs;
}

public int getPANZ() {
	return PANZ;
}

public void setPANZ(int pANZ) {
	PANZ = pANZ;
}
   
}