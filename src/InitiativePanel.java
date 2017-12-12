import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;



public class InitiativePanel extends JPanel {
	
	private static JPanel initPanel;
	private final static int maxAnz = 12;
	private static final JComponent jButtonKomplexeAktionen = null;
	private static int frameWidth, frameHeight, gapSpaceV, compHeight, arrayWidth;
	private static int aktTeilnehmer = 0; // Speichert die Anzahl der bereits hinzugefügten Teilnehmer
	
	private static JScrollPane scrollReihenfolge, scrollProto;
	private static JLabel jLabelTeilnehmer = new JLabel();
	private static JLabel jLabelBereitsVorhanden = new JLabel();
	private static JLabel jLabelText = new JLabel();
	private static JLabel jLabelEinfacheAktion = new JLabel(), jLabelKomplexeAktion = new JLabel();
	private static JLabel jLabelDranIst = new JLabel(), jLabelHandlungenOffen = new JLabel();
	private static JLabel[] teilnehmer = new JLabel[maxAnz];
	private static JComboBox<String> jComboBoxDranIst = new JComboBox<String>();
	private static JComboBox<String> ComboBoxCharas = new JComboBox<String>();
	private static JComboBox<String> jComboBoxEinfacheAktionen, jComboBoxKomplexeAktionen;
	@SuppressWarnings("unchecked")
	private static JComboBox<String>[] iniArt = (JComboBox<String>[]) new JComboBox[maxAnz];
	private static JComboBox<String>[] freieHandlung = (JComboBox<String>[]) new JComboBox[maxAnz];
	private static JComboBox<String>[] unterbrechungsHandlung = (JComboBox<String>[]) new JComboBox[maxAnz];
	private static JButton jButtonAddTeilnehmer = new JButton(), jButtonEinfacheHandlung = new JButton(), jButtonKomplexeHandlung = new JButton();
	private static JButton initiativeNeustart = new JButton(), protokollSpeichern = new JButton(), neuerKampf = new JButton();
	private static JButton[] wuerfeln = new JButton[maxAnz], freieAnwenden = new JButton[maxAnz], unterbrechungAnwenden = new JButton[maxAnz];
	private static JTextArea jTextAreaReihenfolge = new JTextArea();
	private static JTable jTableReihenfolge = new JTable();
	private static JTextArea jTextAreaProtokoll = new JTextArea();
	private static JTextField[] iniWert = new JTextField[maxAnz];
	
	private static String[] inis = {"Normal", "Astral", "Mit KS", "Mit HS"};
	private static String[] einfacheaktionen = {"Aufstehen", "Fokus aktivieren", "Gegenstand aufheben/ablegen", "Gegenstand benutzen", "Geist aktivieren",
		"Geist befehligen", "Geist entlassen", "Genau beobachten", "Gerätemodus ändern", "In Deckung gehen", "Ladestreifen einschieben", "Ladestreifen herausnehmen",
		"Pfeil abschießen", "Schnellzaubern", "Schnellziehen", "Waffe abfeuern (EM, HM, SM, AM)", "Waffe bereitmachen", "Wahrnehmung verlagern", "Werfen", "Zielen"};
	private static String[] komplexeaktionen = {"Astrale Projektion", "Fertigkeit einsetzen", "Geist herbeirufen", "Geist verbannen", "In ein geriggtes Fahrzeug springen",
		"Lange oder halbautom. Salve abfeuern", "Montierte oder Fahrz.waffe abfeuern", "Nahkampfangriff", "Sprinten", "Waffe im AM abfeuern", "Waffe nachladen",
		"Zauber wirken", "Nichts tun"};
	private static String[] freieHandlungen = {"Gegenstand fallen lassen", "Gestikulieren", "Laufen", "Mehrfachangriff", "Modus ändern", "Satz sprechen/übermitteln", "Sich hinwerfen",
		"Smartgunladestreifen auswerfen", "Ziel ansagen"};
	private static String[] unterbrechnungsHandlungen = {"Abfangen", "Ausweichen", "Blocken", "Parieren", "Volle Abwehr", "Volle Deckung"};
	private static String[] tableNames = {"Name", "Wert", "Runde"};
	// Speichert sortiert die Reihenfolge der Charaktere, dabei wird deren Teilnehmernummer (Reihenfolge des Hinzufügens) gespeichert
	private static ArrayList<Integer> sortedCharas = new ArrayList<Integer>();
	private static int[] runde = new int[maxAnz]; //Speichert in welcher Runde der Chara mit Index i ist 
	private static int handlungen = 2; //Steht für die Anzahl der Handlungen des aktuell handelnden Charakters
	private static int handelnderChara = -1; //Steht für den Handelnden Charakter (Index der Reihenfolge des Hinzufügens)
	
	private static Calendar calendar;

	public static void setupInitiativePanel(JPanel iPanel){
			
		frameWidth = IAmTheFrame.getFrameWidth();
		arrayWidth = (2*frameWidth)/36-10;
		frameHeight = IAmTheFrame.getFrameHeight();
		compHeight = (int) (frameHeight*0.06);
		gapSpaceV = (int) (frameHeight*0.01);
		
		initPanel = iPanel;
		initPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        JComponent clicked = (JComponent)e.getSource();
		        clicked.requestFocusInWindow();
		    }
		});
		// Erste Zeile:
		jLabelTeilnehmer.setBounds(40, 20, 150, compHeight);
	    jLabelTeilnehmer.setText("Teilnehmer hinzufügen:");
	    initPanel.add(jLabelTeilnehmer); 
	    ComboBoxCharas.setBounds(200, 20, 3*arrayWidth, compHeight);
	    initPanel.add(ComboBoxCharas);
	    jButtonAddTeilnehmer.setBounds(ComboBoxCharas.getX() + ComboBoxCharas.getWidth() + 10, 20, 3*arrayWidth, compHeight);
	    jButtonAddTeilnehmer.setText("Hinzufügen");
	    jButtonAddTeilnehmer.setMargin(new Insets(2, 2, 2, 2));
	    jButtonAddTeilnehmer.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  jButtonAddTeilnehmer_ActionPerformed(evt);
	      }
	    });
	    initPanel.add(jButtonAddTeilnehmer);
	    jLabelBereitsVorhanden.setBounds(jButtonAddTeilnehmer.getX() + jButtonAddTeilnehmer.getWidth() + 10, 20, 3*arrayWidth, compHeight);
	    jLabelBereitsVorhanden.setText("");
	    initPanel.add(jLabelBereitsVorhanden); 
	    
	    // Rechte \begin{minipage}
//	    reihenPanel = new JPanel();
//	    reihenPanel.setBorder(new TitledBorder ( new EtchedBorder (), "Reihenfolge:" ));
	    //jTextAreaReihenfolge.setBounds((2*frameWidth)/3, 20, (1*frameWidth)/3-30, (frameHeight/2)-120);
	    
	    DefaultTableModel model = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return tableNames.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return tableNames[index]; 
            } 
        };
	    
	    jTableReihenfolge = new JTable(model);
	    //jTextAreaReihenfolge.setEditable(false);
	    //scrollReihenfolge = new JScrollPane (jTextAreaReihenfolge, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollReihenfolge = new JScrollPane (jTableReihenfolge, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    //initPanel.add(jTextAreaReihenfolge);
	    scrollReihenfolge.setBounds((2*frameWidth)/3+20, 20, (frameWidth)/3-60, (frameHeight/2)-120);
	    scrollReihenfolge.setBorder(new TitledBorder ( new EtchedBorder (), "Reihenfolge:" ));
	    initPanel.add(scrollReihenfolge);
	    
	    jTextAreaProtokoll.setEditable(false);
	    scrollProto = new JScrollPane (jTextAreaProtokoll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollProto.setBounds((2*frameWidth)/3+20, (frameHeight/2)-80, (frameWidth)/3-60, (frameHeight/2)-80);
	    //jTextAreaProtokoll.setText("Protokoll: " + getDate());
	    scrollProto.setBorder(new TitledBorder ( new EtchedBorder (), "Protokoll: " + getDate()));
	    initPanel.add(scrollProto); 
	
	    
	    // Zweite, dritte, vierte und fünfte Zeile
	    for (int i = 0; i < teilnehmer.length; ++i){
	    	teilnehmer[i] = new JLabel();
	    	teilnehmer[i].setBounds(20+i*(arrayWidth+10), jLabelTeilnehmer.getY() + jLabelTeilnehmer.getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	//teilnehmer[i].setText("dummy");
	    	initPanel.add(teilnehmer[i]);
	    	
	    	iniArt[i] = new JComboBox<String>(inis);
	    	iniArt[i].setBounds(20+i*(arrayWidth+10), teilnehmer[0].getY() + teilnehmer[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	// ActionListener für iniArt[i]
	    	iniArt[i].addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent e){
		    		@SuppressWarnings("unchecked")
					JComboBox<String> sender = (JComboBox<String>) e.getSource(); 
		    		for (int j=0; j < maxAnz; ++j){
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
	    	
	    	iniWert[i] = new JTextField();
	    	iniWert[i].setBounds(20+i*(arrayWidth+10), iniArt[0].getY() + iniArt[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	iniWert[i].addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent evt) {
					JTextField sender = (JTextField) evt.getSource();
					sender.setText("");					
				}

				public void focusLost(java.awt.event.FocusEvent evt) {
					JTextField sender = (JTextField) evt.getSource();
					int index = -1;
					for (int i = 0; i < iniWert.length; ++i) {
						if (sender.equals(iniWert[i])){
							index = i;
						}
					}
					// Update der Reihenfolge
					sortCharasByIni(index);
					freieAnwenden[index].setEnabled(true);
					unterbrechungAnwenden[index].setEnabled(true);
					wuerfeln[index].setEnabled(false);
				}
			});
	    	    	
	    	wuerfeln[i] = new JButton();
	    	wuerfeln[i].setBounds(20+i*(arrayWidth+10), iniWert[0].getY() + iniWert[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	wuerfeln[i].setText("Würfeln");
	    	wuerfeln[i].setMargin(new Insets(2, 2, 2, 2));
	    	wuerfeln[i].addActionListener(new ActionListener() { 
	    		public void actionPerformed(ActionEvent evt) { 
	    			wuerfeln_ActionPerformed(evt);
	    		}
	    	});
	    	
	    	freieHandlung[i] = new JComboBox<String>(freieHandlungen);
	    	freieHandlung[i].setBounds(20+i*(arrayWidth+10), wuerfeln[0].getY() + wuerfeln[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	
	    	freieAnwenden[i] = new JButton();
	    	freieAnwenden[i].setBounds(20+i*(arrayWidth+10), freieHandlung[0].getY() + freieHandlung[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	freieAnwenden[i].setText("FH anwenden");
	    	freieAnwenden[i].setMargin(new Insets(2, 2, 2, 2));
	    	freieAnwenden[i].addActionListener(new ActionListener() { 
	    		public void actionPerformed(ActionEvent evt) { 
	    			freieAnwenden_ActionPerformed(evt);
	    		}
	    	});
	    	freieAnwenden[i].setEnabled(false);
	    	
	    	unterbrechungsHandlung[i] = new JComboBox<String>(unterbrechnungsHandlungen);
	    	unterbrechungsHandlung[i].setBounds(20+i*(arrayWidth+10), freieAnwenden[0].getY() + freieAnwenden[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	
	    	unterbrechungAnwenden[i] = new JButton();
	    	unterbrechungAnwenden[i].setBounds(20+i*(arrayWidth+10), unterbrechungsHandlung[0].getY() + unterbrechungsHandlung[0].getHeight() + gapSpaceV, arrayWidth, compHeight);
	    	unterbrechungAnwenden[i].setText("UH anwenden");
	    	unterbrechungAnwenden[i].setMargin(new Insets(2, 2, 2, 2));
	    	unterbrechungAnwenden[i].addActionListener(new ActionListener() { 
	    		public void actionPerformed(ActionEvent evt) { 
	    			unterbrechungAnwenden_ActionPerformed(evt);
	    		}
	    	});
	    	unterbrechungAnwenden[i].setEnabled(false);
	    	
	    } // end of for
	    
	    
//	    sPanel.setLayout(new MigLayout("", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]", "[13.00][][][][][][][][]"));
//		
//		for (int i = 0; i < maxAnz; ++i) {
//			teilnehmer[i] = new JLabel("Name");
//			sPanel.add(teilnehmer[i], "cell "+i+" 1");
//		
//			iniArt[i] = new JComboBox<String>(inis);
//			sPanel.add(iniArt[i], "cell "+i+" 2, growx");
//		
//			iniWert[i] = new JTextField();
//			sPanel.add(iniWert[i], "cell "+i+" 3");
//			//textField.setColumns(10);
//		
//			wuerfeln[i] = new JButton("Würfeln");
//			wuerfeln[i].addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent evt) {
//					wuerfeln_ActionPerformed(evt);
//				}
//			});
//			sPanel.add(wuerfeln[i], "cell "+i+" 4");
//		
//			freieHandlung[i] = new JComboBox<String>(freieHandlungen);
//			sPanel.add(freieHandlung[i], "cell "+i+" 5");
//		
//			freieAnwenden[i] = new JButton("FH anwenden");
//			sPanel.add(freieAnwenden[i], "cell "+i+" 6");
//		
//			unterbrechungsHandlung[i] = new JComboBox<String>(unterbrechnungsHandlungen);
//			sPanel.add(unterbrechungsHandlung[i], "cell "+i+" 7");
//		
//			unterbrechungAnwenden[i] = new JButton("UH anwenden");
//			sPanel.add(unterbrechungAnwenden[i], "cell "+i+" 8");
//		}
		
//		JScrollPane scrollPane = new JScrollPane (sPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.setBounds(30, 100, (frameWidth)-300,  frameHeight-300);
//	    //jTextAreaProtokoll.setText("Protokoll: " + getDate());
//		scrollPane.setBorder(new TitledBorder ( new EtchedBorder (), "Pain"));
//	    initPanel.add(scrollPane); 
	    
	    
	 // Ganz untere Zeile:
	    jLabelText.setBounds(40, unterbrechungAnwenden[0].getY() + unterbrechungAnwenden[0].getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
	    jLabelText.setText("Dran ist:");
		initPanel.add(jLabelText);
		jLabelDranIst.setBounds(40, jLabelText.getY() + jLabelText.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
		jLabelDranIst.setFont(new Font("Neuropol X Free",Font.BOLD,18));
		jLabelDranIst.setText("");
		//initPanel.add(jLabelDranIst);
		
		jComboBoxDranIst.setBounds(40, jLabelText.getY() + jLabelText.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
		jComboBoxDranIst.setFont(new Font("Neuropol X Free",Font.BOLD,18));
		initPanel.add(jComboBoxDranIst);
		
		jLabelHandlungenOffen.setBounds(40, jLabelDranIst.getY() + jLabelDranIst.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
		jLabelHandlungenOffen.setForeground(Color.green);
		jLabelHandlungenOffen.setText("Zwei Einfache oder eine Komplexe");
		initPanel.add(jLabelHandlungenOffen);
		
		jLabelEinfacheAktion.setBounds(jLabelDranIst.getX() + jLabelText.getWidth()+10, unterbrechungAnwenden[0].getY() + unterbrechungAnwenden[0].getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
		jLabelEinfacheAktion.setText("Einfache Handlungen:");
		initPanel.add(jLabelEinfacheAktion);
		
		jComboBoxEinfacheAktionen = new JComboBox<String>(einfacheaktionen);
		jComboBoxEinfacheAktionen.setBounds(jLabelEinfacheAktion.getX(), jLabelEinfacheAktion.getY() + jLabelEinfacheAktion.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
	    initPanel.add(jComboBoxEinfacheAktionen);
	    
	    jLabelKomplexeAktion.setBounds(jLabelEinfacheAktion.getX() + 3*arrayWidth+10, unterbrechungAnwenden[0].getY() + unterbrechungAnwenden[0].getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
		jLabelKomplexeAktion.setText("Komplexe Handlungen:");
		initPanel.add(jLabelKomplexeAktion);
		
		jComboBoxKomplexeAktionen = new JComboBox<String>(komplexeaktionen);
		jComboBoxKomplexeAktionen.setBounds(jLabelKomplexeAktion.getX(), jLabelKomplexeAktion.getY() + jLabelKomplexeAktion.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
	    initPanel.add(jComboBoxKomplexeAktionen);
	    
	    jButtonEinfacheHandlung.setBounds(jComboBoxEinfacheAktionen.getX(), jComboBoxEinfacheAktionen.getY() + jComboBoxEinfacheAktionen.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
	    jButtonEinfacheHandlung.setText("Einfache Handlung anwenden");
	    jButtonEinfacheHandlung.setMargin(new Insets(2, 2, 2, 2));
	    jButtonEinfacheHandlung.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) {
	    	  jButtonHandlungen_ActionPerformed(true);
	      }
	    });
	    initPanel.add(jButtonEinfacheHandlung);
	    
	    jButtonKomplexeHandlung.setBounds(jComboBoxKomplexeAktionen.getX(), jComboBoxKomplexeAktionen.getY() + jComboBoxKomplexeAktionen.getHeight() + gapSpaceV, 3*arrayWidth, compHeight);
	    jButtonKomplexeHandlung.setText("Komplexe Handlung anwenden");
	    jButtonKomplexeHandlung.setMargin(new Insets(2, 2, 2, 2));
	    jButtonKomplexeHandlung.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  jButtonHandlungen_ActionPerformed(false);
	      }
	    });
	    initPanel.add(jButtonKomplexeHandlung);
	    
	    // ganz unten
	    initiativeNeustart.setBounds(jComboBoxKomplexeAktionen.getX() + 3*arrayWidth+10, jComboBoxKomplexeAktionen.getY(), 3*arrayWidth, compHeight);
	    initiativeNeustart.setText("Nächster Initiativedurchgang");
	    initiativeNeustart.setMargin(new Insets(2, 2, 2, 2));
	    initiativeNeustart.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent evt) { 
    			initiativeNeustart_ActionPerformed(evt);
    		}
    	});
	    initPanel.add(initiativeNeustart);
	    initiativeNeustart.setEnabled(false);
	    
	    
	    neuerKampf.setBounds(initiativeNeustart.getX(), jLabelKomplexeAktion.getY(), 3*arrayWidth, compHeight);
	    neuerKampf.setText("Neue Kampfrunde");
	    neuerKampf.setMargin(new Insets(2, 2, 2, 2));
	    neuerKampf.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent evt) { 
    			neuerKampf_ActionPerformed(evt);
    		}
    	});
	    initPanel.add(neuerKampf);
	    
	    
	    
	    protokollSpeichern.setBounds(jButtonKomplexeHandlung.getX() + 3*arrayWidth+10, jButtonKomplexeHandlung.getY(), 3*arrayWidth, compHeight);
	    protokollSpeichern.setText("Protokoll speichern");
	    protokollSpeichern.setMargin(new Insets(2, 2, 2, 2));
	    protokollSpeichern.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent evt) { 
    			protokollSpeichern_ActionPerformed(evt);
    		}
    	});
	    initPanel.add(protokollSpeichern);
	}
	
	// Lässt ein Element zur TeilnehmerBox hinzufügen
	public static void addComboBoxCharas(String name){
		ComboBoxCharas.addItem(name);
	}
	
	// jButtonAddTeilnehmer-Methode
	public static void jButtonAddTeilnehmer_ActionPerformed(ActionEvent evt) {
		String chara = (String) ComboBoxCharas.getSelectedItem();
		if (!teilnehmercontains(chara)) {
			teilnehmer[aktTeilnehmer].setText(chara);
			iniArt[aktTeilnehmer].setSelectedItem("Normal");
			initPanel.add(iniArt[aktTeilnehmer]);
			iniWert[aktTeilnehmer].setText("" + IAmTheFrame.searchCharaByName(chara).getINI());
			initPanel.add(iniWert[aktTeilnehmer]);
			initPanel.add(wuerfeln[aktTeilnehmer]);
			wuerfeln[aktTeilnehmer].setEnabled(true);
			initPanel.add(freieHandlung[aktTeilnehmer]);
			initPanel.add(freieAnwenden[aktTeilnehmer]);
			freieAnwenden[aktTeilnehmer].setEnabled(false);
			initPanel.add(unterbrechungsHandlung[aktTeilnehmer]);
			initPanel.add(unterbrechungAnwenden[aktTeilnehmer]);
			unterbrechungAnwenden[aktTeilnehmer].setEnabled(false);
			
			teilnehmer[aktTeilnehmer].setVisible(true);
			iniArt[aktTeilnehmer].setVisible(true);
			iniWert[aktTeilnehmer].setVisible(true);
			wuerfeln[aktTeilnehmer].setVisible(true);
			freieAnwenden[aktTeilnehmer].setVisible(true);
			unterbrechungAnwenden[aktTeilnehmer].setVisible(true);
			freieHandlung[aktTeilnehmer].setVisible(true);
			unterbrechungsHandlung[aktTeilnehmer].setVisible(true);
			
			writeProto("" + chara + " nimmt am Kampf teil");
			if (aktTeilnehmer < maxAnz) aktTeilnehmer++;
			jLabelBereitsVorhanden.setText("");
			initPanel.repaint();
		} else {
			jLabelBereitsVorhanden.setForeground(Color.red);
			jLabelBereitsVorhanden.setText("Teilnehmer bereits vorhanden!");
		}
	 } // end of jButton2_ActionPerformed
	
	// Erweitert das Protokoll um @text
	public synchronized static void writeProto(String text) {
		jTextAreaProtokoll.append("\n" + getTime() + "\t" + text);
		CombatPanel.setProto(jTextAreaProtokoll.getText());
	}

	// Würfelt automatisch die Initiative aus
	public static void wuerfeln_ActionPerformed(ActionEvent evt) {
		// Suche den Button, der Sender des Events ist und suche den entsprechenden Index in der Liste
		JButton sender = (JButton) evt.getSource(); 
		for (int j=0; j < teilnehmer.length; ++j){
			if (sender instanceof JButton && sender.equals(wuerfeln[j])){
				int erg = 0;
				// j ist der Index des Teilnehmers, der mit dem Index des Buttons übereinstimmt			
				// Syntax-Analyse:
				String text = iniWert[j].getText();
				// Suche Position von + und W6:
				int pluspos = 0, wpos = 0, festwert = 0, zufall = 0;
				for (int i = 0; i < text.length(); ++i){
					if (text.charAt(i) == '+') pluspos = i;
					if (text.charAt(i) == 'W') wpos = i;
				}
				// Berechne festen Wert und Anzahl der Würfel
				if (text.contains("+") && text.contains("W")){
					festwert = Integer.parseInt(text.substring(0, pluspos));
					zufall = Integer.parseInt(text.substring(pluspos+1, wpos));
					// Würfel und schreibe in Textfeld
					int addiere = 0;
					Random ran = new Random();
				    for (int i = 0; i < zufall; ++i){
				    	int wurf = ran.nextInt(6)+1;
				    	System.out.println(wurf);
				    	addiere += wurf;
				    }
				    erg = addiere + festwert;
				    iniWert[j].setText("" + erg);
				    sortCharasByIni(j);
				}
				sender.setEnabled(false);
				freieAnwenden[j].setEnabled(true);
				unterbrechungAnwenden[j].setEnabled(true);
				writeProto("" + teilnehmer[j].getText() + " würfelt mit " + text + "; Ergebnis ist: " + erg);
				//jComboBoxDranIst.addItem(teilnehmer[j].getText());
			}
		}
		//jComboBoxDranIst.setSelectedItem(teilnehmer[sortedCharas.get(0)].getText());
	 } // end of wuerfeln_ActionPerformed
	
	// Wenn eine freie Handlung angewendet wird
	public static void freieAnwenden_ActionPerformed(ActionEvent evt) {
		// Suche den Button, der Sender des Events ist und suche den entsprechenden Index in der Liste
		JButton sender = (JButton) evt.getSource();
		for (int j=0; j < maxAnz; ++j){
			if (sender instanceof JButton && sender.equals(freieAnwenden[j])){
				String geradedran = teilnehmer[j].getText();
				//jTextAreaProtokoll.append("\n" + getTime() + "\t" + geradedran + " nutzt " + freieHandlung[j].getSelectedItem() + " (FH)");
				writeProto("" + geradedran + " nutzt " + freieHandlung[j].getSelectedItem() + " (FH)");
				sender.setEnabled(false);
			}
		}	
	 } // end of jButton2_ActionPerformed
	
	// Wenn eine Unterbrechungshandlung angewendet wird
	public static void unterbrechungAnwenden_ActionPerformed(ActionEvent evt) {
		// Suche den Button, der Sender des Events ist und suche den entsprechenden Index in der Liste
		JButton sender = (JButton) evt.getSource();
		for (int j=0; j < maxAnz; ++j){
			if (sender instanceof JButton && sender.equals(unterbrechungAnwenden[j])){
				String geradedran = teilnehmer[j].getText();
				int handelnderIni = Integer.parseInt(iniWert[j].getText());
				if (handelnderIni == 0){ 
					sortedCharas.remove((Object) handelnderChara);
				} else if (handelnderIni > 0){
					writeProto("" + geradedran + " nutzt " + unterbrechungsHandlung[j].getSelectedItem() + " (UH)");
					// Sofort 10 von Ini abziehen
					int indexuhandlung = unterbrechungsHandlung[j].getSelectedIndex();
					switch (indexuhandlung) {
					case 0: // Abfangen
					case 1: // Ausweichen
					case 2: // Blocken
					case 3:
						if (checkUnterbrechung(j, 5)) {
							decreaseIni(j, 5); sortCharasByIni(); updateReihenfolgeTable(); sender.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(initPanel, "Nicht genügend Initiative!");
						} break; // Parieren
					case 4: 
						if (checkUnterbrechung(j, 10)) {
							decreaseIni(j, 5); sortCharasByIni(); updateReihenfolgeTable(); sender.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(initPanel, "Nicht genügend Initiative!");
						} break; // Volle Abwehr
					case 5:
						if (checkUnterbrechung(j, 5)) {
							decreaseIni(j, 5); sortCharasByIni(); updateReihenfolgeTable(); sender.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(initPanel, "Nicht genügend Initiative!");
						} break; // Volle Abwehr
					}
					//jLabelDranIst.setText(teilnehmer[handelnderChara].getText());
					try {jComboBoxDranIst.setSelectedItem((teilnehmer[handelnderChara].getText()));}
					catch (Exception e) {jComboBoxDranIst.setSelectedIndex(0);}
					jLabelHandlungenOffen.setForeground(Color.green);
					jLabelHandlungenOffen.setText("Zwei Einfache oder eine Komplexe");
					//handlungen = 2;
				}
			}
		}	
	 } // end of jButton2_ActionPerformed
	
	// Wird ausgeführt, wenn Button "Nächster Initiativedurchgang" gedrückt wird
	public static void initiativeNeustart_ActionPerformed(ActionEvent evt) {
		for (int i = 0; i < aktTeilnehmer; ++i){
			wuerfeln[i].setEnabled(true);
			freieAnwenden[i].setEnabled(false);
			unterbrechungAnwenden[i].setEnabled(false);
			String chara = teilnehmer[i].getText();
			Chara c = IAmTheFrame.searchCharaByName(chara);
			int iniA = iniArt[i].getSelectedIndex();
			switch (iniA){
			case 0: iniWert[i].setText("" + c.getINI()); break;
			case 1: iniWert[i].setText("" + c.getINA()); break;
			case 2: iniWert[i].setText("" + c.getINKS()); break;
			case 3: iniWert[i].setText("" + c.getINHS()); break;
			default: iniWert[i].setText("" + c.getINI()); break;
			}
		}
		//jLabelDranIst.setText("");
		jComboBoxDranIst.removeAllItems();
		jLabelBereitsVorhanden.setText("");
		writeProto("Neuer Initiativedurchgang startet");
		clearRunde();
		initiativeNeustart.setEnabled(false);
	 }

	// Wenn ein neuer Kampf angefangen wird
	public static void neuerKampf_ActionPerformed(ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(initPanel,
				"Wollen Sie wirklich einen neuen Kampf beginnen?", "Neuer Kampf",
				JOptionPane.YES_NO_OPTION);
		aktTeilnehmer = 0;
		if (result == JOptionPane.YES_OPTION) {
			for (int i = 0; i < maxAnz; ++i) {
				teilnehmer[i].setText("");
				teilnehmer[i].setVisible(false);
				iniArt[i].setVisible(false);
				iniWert[i].setVisible(false);
				wuerfeln[i].setVisible(false);
				freieAnwenden[i].setVisible(false);
				unterbrechungAnwenden[i].setVisible(false);
				freieHandlung[i].setVisible(false);
				unterbrechungsHandlung[i].setVisible(false);
			}
			DefaultTableModel model = (DefaultTableModel) jTableReihenfolge.getModel();
			model.setRowCount(0);
		}
		initPanel.repaint();
	} // end of jButton2_ActionPerformed
	
	// Setzt die Werte im Runden-Array zurück
	private static void clearRunde() {
		// TODO Auto-generated method stub
		for (int i = 0; i < runde.length; ++i){
			runde[i] = 0;
		}
		DefaultTableModel model = (DefaultTableModel) jTableReihenfolge.getModel();
		model.setRowCount(0);
	}

	public static void protokollSpeichern_ActionPerformed(ActionEvent evt) {
		BufferedWriter bw = null;
	    FileWriter fw = null;
	    File file = null;
	    try{
	      String content = jTextAreaProtokoll.getText();
	      String filename = IAmTheFrame.getPath();
	      //String newfilename = FILENAME.substring(0, FILENAME.lastIndexOf("."));
	      file = new File(filename);
	      //System.out.println(file.getParent());
	      fw = new FileWriter(file.getParent() + "\\" + "Proto " + getDate() + "-" + getTimeforPath() + ".txt");
	      //System.out.println(fw.toString());
	      bw = new BufferedWriter(fw);
	      bw.write(content);
	    }  catch (IOException e){
	      e.printStackTrace();
	      jLabelBereitsVorhanden.setText("Die Datei kann nicht gespeichert werden.");
	    }  finally {
	      try {
	        
	          if (bw != null) {
	            bw.close();
	          } // end of if
	          if (fw != null) {
	            fw.close();
	          } // end of if
	      } catch(IOException ex) {
	        ex.printStackTrace();
	      } 
	    }  
	 } // end of protokollSpeichern
	
	// Sortiert die Charas nach ihrem INI-Wert (Insertion-Sort)
	private static void sortCharasByIni(int teilnehmernr) {
		// Wandelt den iniWert des Charakters mit der Teilnehmernummer @teilnehmernr in int um, -1 falls nicht möglich
		int ini = -1;
		try {
			ini = Integer.parseInt(iniWert[teilnehmernr].getText());
		} catch (Exception e){System.out.println("Kein Wert eingetragen!");
		}
		if (ini >= 0){
			// schaut in der sortierten Liste, an welcher Stelle der Chara kommt
			if (!sortedCharas.contains(teilnehmernr)){
				sortedCharas.add(teilnehmernr);
			}
			
			sortCharasByIni();
			
			// Nach dem sortieren jLabelDranIst anpassen
			if (sortedCharas.size() == 0) return;
			handelnderChara = sortedCharas.get(0);
			//jLabelDranIst.setText("" + teilnehmer[sortedCharas.get(0)].getText());
//			try {jComboBoxDranIst.setSelectedItem(teilnehmer[sortedCharas.get(0)].getText());}
//			catch (Exception e) {e.printStackTrace();}
		}
		//updateReihenfolgeProto();
		updateReihenfolgeTable();
	}
	
	// Sortiert die Charaktere nach ihrem Inititivewert
	private static void sortCharasByIni(){
		// Magisches Zeug zum sortieren:
		Collections.sort(sortedCharas, new Comparator<Integer>() {
		      public int compare(Integer p1, Integer p2) {
		       	int val1 = 0, val2 = 0; 
		       	try {
		       		val1 = Integer.parseInt(iniWert[p1].getText());
		       		val2 = Integer.parseInt(iniWert[p2].getText());
		       	} catch (NumberFormatException e){
		       		System.out.println("Nicht parsbar");
		       	}
		       	if (val1 == 0) return 1; // Wer 0 hat ist raus
		       	if (val2 == 0) return -1;
		       	if (runde[p1] != runde[p2]){ // Wer eine niedrigere Runde hat ist zuerst dran
		       		return runde[p1] - runde[p2];
		       	} else return val2 - val1; // Sonst: Wer einen niedrigeren Wert hat
		      }
		});	
	}


	// Updatet das Protokoll der Reihenfolge und die jComboBoxDranIst
	private static void updateReihenfolgeTable() {
		DefaultTableModel model = (DefaultTableModel) jTableReihenfolge.getModel();
		model.setRowCount(0);
		jComboBoxDranIst.removeAllItems();
		for (int i : sortedCharas){
			String teilnehmername = teilnehmer[i].getText();
			int teilnehmerini = -1;
			try {
				teilnehmerini = Integer.parseInt(iniWert[i].getText());
				//jTextAreaReihenfolge.append("\n" + teilnehmername + "\t" + teilnehmerini + "\t (R. " + runde[i] + ")");
				model.addRow(new Object[]{teilnehmername, teilnehmerini, runde[i]});
				jComboBoxDranIst.addItem(teilnehmername);
			} catch (Exception e){
				System.out.println("Nicht sortierbar");
			}
		}
	}

	private static boolean teilnehmercontains(String chara) {
		for (int i = 0; i < teilnehmer.length; ++i){
			if (teilnehmer[i].getText().equals(chara)) return true;
		}
		return false;
	}
	
	private static int getTeilnehmerNr(String chara) {
		for (int i = 0; i < teilnehmer.length; ++i){
			if (teilnehmer[i].getText().equals(chara)) return i;
		}
		return -1;
	}
	
	// Wird ausgeführt, wenn eine einfache oder komplexe Handlung angewendet wird
	private static void jButtonHandlungen_ActionPerformed(boolean b){
		// b = true heißt einfache, b = false heißt komplexe Handlung
		if (sortedCharas.size() == 0) return;
		//handelnderChara = sortedCharas.get(0);
		handelnderChara = getTeilnehmerNr((String) jComboBoxDranIst.getSelectedItem());
		//jLabelDranIst.setText(teilnehmer[handelnderChara].getText());
//		try {jComboBoxDranIst.setSelectedItem(teilnehmer[sortedCharas.get(0)].getText());}
//		catch (Exception e) {e.printStackTrace();}
		int handelnderIni = Integer.parseInt(iniWert[handelnderChara].getText());
		if (b && handlungen > 0 && handelnderIni > 0) { // Einfache Handlung geglückt
			handlungen--;
			if (handlungen > 0){
				jLabelHandlungenOffen.setForeground(new Color(23,197,182));
				jLabelHandlungenOffen.setText("Eine einfache Handlung");
			} else {
				jLabelHandlungenOffen.setForeground(Color.red);
				jLabelHandlungenOffen.setText("Keine Handlung mehr offen");
				// Chara in nächste Runde bringen!
			}
			writeProto("" + teilnehmer[handelnderChara].getText() + " nutzt " + jComboBoxEinfacheAktionen.getSelectedItem() + " (EH)");
		}
		else if (!b && handlungen > 1 && handelnderIni > 0){ // Komplexe Handlung geglückt
			handlungen -= 2;
			jLabelHandlungenOffen.setForeground(Color.red);
			jLabelHandlungenOffen.setText("Keine Handlung mehr offen");
			// Chara in nächste Runde bringen!
			writeProto("" + teilnehmer[handelnderChara].getText() + " nutzt " + jComboBoxKomplexeAktionen.getSelectedItem() + " (KH)");
		}
		else{ // Der Charakter darf nicht mehr handeln
			jLabelBereitsVorhanden.setForeground(Color.red);
			jLabelBereitsVorhanden.setText("Der Charakter kann dies nicht mehr tun.");
			jLabelDranIst.setText("");
			jLabelHandlungenOffen.setForeground(Color.red);
			jLabelHandlungenOffen.setText("Initiativedurchgang abgeschlossen");
			// frieAnwenden zurücksetzbar machen
			
			
				// ---------------------------------------------------------------------------->
			
			
			// 
		}
		// Chara in nächste Runde bringen!
		if (handelnderIni == 0){ 
			sortedCharas.remove((Object) handelnderChara);
		} else if (handlungen == 0 && handelnderIni > 0){
			// jComboBoxDranIst anpassen
			//if (sortedCharas.size() > 1) jComboBoxDranIst.setSelectedIndex(sortedCharas.get(1));
			// Initiativewert um 10 verringern (aber nie unter 0):
			decreaseIni(handelnderChara, 10);
			bringToNextRound(handelnderChara);
			jLabelDranIst.setText(teilnehmer[handelnderChara].getText());
			jLabelHandlungenOffen.setForeground(Color.green);
			jLabelHandlungenOffen.setText("Zwei Einfache oder eine Komplexe");
			handlungen = 2;
			checkForNextRound();
		}
		// Wenn niemand mehr handeln kann:
		boolean nochhandelbar = false;
		for (int i : sortedCharas){
			if (Integer.parseInt(iniWert[i].getText()) > 0) nochhandelbar = true;
		}
		if (!nochhandelbar){
			jLabelDranIst.setText("");
			jLabelHandlungenOffen.setForeground(Color.red);
			jLabelHandlungenOffen.setText("Initiativedurchgang abgeschlossen");
			initiativeNeustart.setEnabled(true); // Neustart zulassen
		}
	}
	
	// Checks, if next round will start
	private static boolean checkForNextRound() {
		int rundeletzterchar = 0;
		boolean first = false; 
		boolean ret = true;
		for (int i : sortedCharas){
			try {
				if (first && runde[i] != rundeletzterchar){
					ret = false;
				}
			} catch (ArrayIndexOutOfBoundsException e){}
			try {
				rundeletzterchar = runde[i];
			} catch (ArrayIndexOutOfBoundsException e){}
			first = true;
		}
		if (ret){
			for (int j = 0; j < maxAnz; ++j){
				unterbrechungAnwenden[j].setEnabled(true);
			}
		}
		return ret;
	}

	// decreases Ini by 10, but not < 0
	private static void decreaseIni(int handelnderChara, int value) {
		int handelnderIni = Integer.parseInt(iniWert[handelnderChara].getText());
		iniWert[handelnderChara].setText("" + (handelnderIni-value > 0? handelnderIni-value : 0));
	}
	
	private static boolean checkUnterbrechung(int handelnderChara, int value){
		int handelnderIni = Integer.parseInt(iniWert[handelnderChara].getText());
		return handelnderIni-value >= 0; 
	}
	
	private static boolean bringToNextRound(int handelbderChara) {
		// Runden-Array anpassen
		boolean ret = false;
		runde[handelnderChara]++;
		sortCharasByIni();
		if (Integer.parseInt(iniWert[sortedCharas.get(0)].getText()) > 0) {handelnderChara = sortedCharas.get(0); ret = true;}
		//updateReihenfolgeProto();
		updateReihenfolgeTable();
		return ret;
	}

	// Überführt die aktuelle Zeit in einen String der Form HH:MM:SS
	private static String getTime(){
		calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND); 
		return ""+ (hour<10? "0"+hour:""+hour) + ":" + (minute<10? "0"+minute:""+minute) + ":" + (second<10? "0"+second:""+second); //WOW!
	}
	
	public static String getTimeforPath(){
		calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND); 
		return ""+ (hour<10? "0"+hour:""+hour) + "-" + (minute<10? "0"+minute:""+minute) + "-" + (second<10? "0"+second:""+second); //WOW!
	}
	
	public static String getDate(){
		calendar = Calendar.getInstance();
		return ""+ calendar.get(Calendar.DAY_OF_MONTH) + "." + (calendar.get(Calendar.MONTH)+1) + "." + calendar.get(Calendar.YEAR);
	}
	
	public static synchronized String getProto(){
		return jTextAreaProtokoll.getText();
	}
	
	public static void setComboBoxCharas(String name) {
		ComboBoxCharas.addItem(name);
	}
}