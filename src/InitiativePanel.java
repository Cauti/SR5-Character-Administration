import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class InitiativePanel {
	
	private static JPanel initPanel;
	private static int aktTeilnehmer = 0; // Speichert die Anzahl der bereits hinzugefügten Teilnehmer
	private static JLabel jLabelTeilnehmer = new JLabel();
	private static JLabel jLabelBereitsVorhanden = new JLabel();
	private static JLabel[] teilnehmer = new JLabel[10];
	private static JComboBox<String> ComboBoxCharas = new JComboBox<String>();
	@SuppressWarnings("unchecked")
	private static JComboBox<String>[] iniArt = (JComboBox<String>[]) new JComboBox[10];
	private static JButton jButtonAddTeilnehmer = new JButton();
	private static JButton[] wuerfeln = new JButton[10];
	private static JTextArea jTextAreaReihenfolge = new JTextArea();
	private static JTextArea jTextAreaProtokoll = new JTextArea();
	private static JTextField[] iniWert = new JTextField[10];
	
	private static String[] inis = {"Normal", "Astral", "Mit KS", "Mit HS"};
	private static ArrayList<String> sortedCharas = new ArrayList<String>();

	public static void setupInitiativePanel(JPanel iPanel){
		
		initPanel = iPanel;
		// Erste Zeile:
		jLabelTeilnehmer.setBounds(40, 30, 150, 44);
	    jLabelTeilnehmer.setText("Teilnehmer hinzufügen:");
	    initPanel.add(jLabelTeilnehmer); 
	    ComboBoxCharas.setBounds(200, 30, 150, 44);
	    initPanel.add(ComboBoxCharas);
	    jButtonAddTeilnehmer.setBounds(360, 30, 150, 44);
	    jButtonAddTeilnehmer.setText("Hinzufügen");
	    jButtonAddTeilnehmer.setMargin(new Insets(2, 2, 2, 2));
	    jButtonAddTeilnehmer.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  jButtonAddTeilnehmer_ActionPerformed(evt);
	      }
	    });
	    initPanel.add(jButtonAddTeilnehmer);
	    jLabelBereitsVorhanden.setBounds(550, 30, 250, 44);
	    jLabelBereitsVorhanden.setText("");
	    initPanel.add(jLabelBereitsVorhanden); 
	    
	    // Rechte \begin{minipage}
	    jTextAreaReihenfolge.setBounds(1020, 30, 250, 300);
	    jTextAreaReihenfolge.setText("Aktuelle Reihenfolge:");
	    initPanel.add(jTextAreaReihenfolge); 
	    jTextAreaProtokoll.setBounds(1020, 350, 250, 300);
	    jTextAreaProtokoll.setText("Protokoll:");
	    initPanel.add(jTextAreaProtokoll); 
	    
	    // Zweite, dritte, vierte und fünfte Zeile
	    for (int i = 0; i < teilnehmer.length; ++i){
	    	teilnehmer[i] = new JLabel();
	    	teilnehmer[i].setBounds(20+i*100, 100, 90, 44);
	    	//teilnehmer[i].setText("dummy");
	    	initPanel.add(teilnehmer[i]);
	    	
	    	iniWert[i] = new JTextField();
	    	iniWert[i].setBounds(20+i*100, 200, 90, 44);
	    	
	    	iniArt[i] = new JComboBox<String>(inis);
	    	iniArt[i].setBounds(20+i*100, 150, 90, 44);
	    	// ActionListener für iniArt[i]
	    	iniArt[i].addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent e){
		    		@SuppressWarnings("unchecked")
					JComboBox<String> sender = (JComboBox<String>) e.getSource(); 
		    		for (int j=0; j < aktTeilnehmer; ++j){
		    			if (sender.equals(iniArt[j])){
		    				String chara = teilnehmer[j].getText();
		    				Chara c = IAmTheFrame.searchCharaByName(chara);
		    				int iniA = iniArt[j].getSelectedIndex();
		    				switch (iniA){
		    				case 0: iniWert[j].setText("" + c.getINI()); break;
		    				case 1: iniWert[j].setText("" + c.getINA()); break;
		    				case 2: iniWert[j].setText("" + c.getINKS()); break;
		    				case 3: iniWert[j].setText("" + c.getINHS()); break;
		    				default: iniWert[j].setText("" + c.getINI()); break;
		    				}
		    			}
		    		}
		    	}
		    });
	    	//initPanel.add(iniArt[i]);
	    	
	    	wuerfeln[i] = new JButton();
	    	wuerfeln[i].setBounds(20+i*100, 250, 90, 44);
	    	wuerfeln[i].setText("Würfeln");
	    	wuerfeln[i].setMargin(new Insets(2, 2, 2, 2));
	    	wuerfeln[i].addActionListener(new ActionListener() { 
		      public void actionPerformed(ActionEvent evt) { 
		    	  wuerfeln_ActionPerformed(evt);
		      }
		    });
		    //initPanel.add(jButtonAddTeilnehmer);
	    }
	}
	
	// Lässt ein Element zur TeilnehmerBox hinzufügen
	public static void addComboBoxCharas(String name){
		ComboBoxCharas.addItem(name);
	}
	
	// jButtonAddTeilnehmer-Methode
	public static void jButtonAddTeilnehmer_ActionPerformed(ActionEvent evt) {
		 // TODO
		String chara = (String) ComboBoxCharas.getSelectedItem();
		if (!teilnehmercontains(chara)) {
			teilnehmer[aktTeilnehmer].setText(chara);
			iniArt[aktTeilnehmer].setSelectedItem("Normal");
			initPanel.add(iniArt[aktTeilnehmer]);
			iniWert[aktTeilnehmer].setText("" + IAmTheFrame.searchCharaByName(chara).getINI());
			initPanel.add(iniWert[aktTeilnehmer]);
			initPanel.add(wuerfeln[aktTeilnehmer]);
			if (aktTeilnehmer < teilnehmer.length-1) aktTeilnehmer++;
			jLabelBereitsVorhanden.setText("");
		} else {
			jLabelBereitsVorhanden.setForeground(Color.red);
			jLabelBereitsVorhanden.setText("Teilnehmer bereits vorhanden!");
		}
	 } // end of jButton2_ActionPerformed
	
	public static void wuerfeln_ActionPerformed(ActionEvent evt) {
		// Suche den Button, der Sender des Events ist und suche den entsprechenden Index in der Liste
		JButton sender = (JButton) evt.getSource(); 
		for (int j=0; j < aktTeilnehmer; ++j){
			if (sender instanceof JButton && sender.equals(wuerfeln[j])){
//				String chara = teilnehmer[j].getText();
//				Chara c = IAmTheFrame.searchCharaByName(chara);
				// Syntax-Analyse:
				String text = iniWert[j].getText();
				// Suche Position von + und W6:
				int pluspos = 0, wpos = 0, festwert = 0, zufall = 0;
				for (int i = 0; i < text.length(); ++i){
					if (text.charAt(i) == '+') pluspos = i;
					if (text.charAt(i) == 'W') wpos = i;
				}
				// Berechne festen Wert und Anzahld er Würfel
				if (text.contains("+") && text.contains("W")){
					festwert = Integer.parseInt(text.substring(0, pluspos));
					zufall = Integer.parseInt(text.substring(pluspos+1, wpos));
					// Würfel und schreibe in Textfeld
					int erfolge = 0;
					Random ran = new Random();
				    for (int i = 0; i < zufall; ++i){
				    	int wurf = ran.nextInt(6)+1;
				    	System.out.println(wurf);
				    	if (wurf == 5 || wurf == 6){
				    		erfolge++;
				    	}
				    }
				    iniWert[j].setText("" + (erfolge + festwert));
				}
			}
		}
		sortCharasByIni();
	 } // end of jButton2_ActionPerformed

	private static void sortCharasByIni() {
		// TODO Auto-generated method stub
		
	}

	private static boolean teilnehmercontains(String chara) {
		// TODO Auto-generated method stub
		//boolean b = false;
		for (int i = 0; i < teilnehmer.length; ++i){
			if (teilnehmer[i].getText().equals(chara)) return true;
		}
		return false;
	}
}
