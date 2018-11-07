import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import sr5.classes.Fertigkeit;
import sr5.classes.Klasse;


public class ValuePanel {
	
	private static JPanel valuePanel;
	private static int frameHeight, frameWidth, compHeight, compWidth, gapSpaceV;
	
	 // Attribute f�r valuePanel
	  private static int akt = -1;
	  private static JLabel jLabelKON = new JLabel();
	  private static JLabel jLabelGES = new JLabel();
	  private static JLabel jLabelREA = new JLabel();
	  private static JLabel jLabelSTA = new JLabel();
	  private static JLabel jLabelWIL = new JLabel();
	  private static JLabel jLabelLOG = new JLabel();
	  private static JLabel jLabelINT = new JLabel();
	  private static JLabel jLabelCHA = new JLabel();
	  private static JLabel jLabelEDG = new JLabel();
	  private static JLabel jLabelESS = new JLabel();
	  private static JLabel jLabelMAG = new JLabel();
	  private static JLabel jLabelPanz = new JLabel();
	  private static JLabel jLabelKLIM = new JLabel();
	  private static JLabel jLabelKLIMAnz = new JLabel();
	  private static JLabel jLabelGLIM = new JLabel();
	  private static JLabel jLabelGLIMAnz = new JLabel();
	  private static JLabel jLabelSLIM = new JLabel();
	  private static JLabel jLabelSLIMAnz = new JLabel();
	  private static JLabel jLabelINI = new JLabel();
	  private static JLabel jLabelMETA = new JLabel();
	  private static JLabel jLabelINA = new JLabel();
	  private static JLabel jLabelINKS = new JLabel();
	  private static JLabel jLabelINHS = new JLabel();
	  private static JLabel jLabelKZM = new JLabel();
	  private static JLabel jLabelGZM = new JLabel();
	  private static JLabel jLabelNAME = new JLabel();
	  private static JTextField jTextFieldINA = new JTextField();
	  private static JTextField jTextFieldINKS = new JTextField();
	  private static JTextField jTextFieldINHS = new JTextField();
	  private static JTextField jTextFieldKZM = new JTextField();
	  private static JTextField jTextFieldINI = new JTextField();
	  private static JTextField jTextFieldGZM = new JTextField();
	  private static JTextField jTextFieldKON = new JTextField();
	  private static JTextField jTextFieldGES = new JTextField();
	  private static JTextField jTextFieldREA = new JTextField();
	  private static JTextField jTextFieldSTA = new JTextField();
	  private static JTextField jTextFieldWIL = new JTextField();
	  private static JTextField jTextFieldLOG = new JTextField();
	  private static JTextField jTextFieldINT = new JTextField();
	  private static JTextField jTextFieldCHA = new JTextField();
	  private static JTextField jTextFieldEDG = new JTextField();
	  private static JTextField jTextFieldESS = new JTextField();
	  private static JTextField jTextFieldMAG = new JTextField();
	  private static JComboBox<Klasse> jComboBoxKlasse;
	  private static JTextField jTextFieldPanz = new JTextField();
	  private static JTextField jTextFieldNAME = new JTextField();
	  private static JButton jButton1 = new JButton();
	  private static JButton jButton2 = new JButton();
	  private static JButton jButton3 = new JButton();
	  private static String[] metatypes = {"Mensch", "Zwerg", "Ork", "Elf", "Troll", "Geist", "Critter"};
	  private static JComboBox<String> jComboBox1;
	  private static DefaultListModel jList1Model = new DefaultListModel();
	  private static JList<String> allcharas = IAmTheFrame.getAllCharas();
	  private static JScrollPane jList1ScrollPane = new JScrollPane(IAmTheFrame.getAllCharas());
	  //private static ArrayList<Chara> charaobjects = IAmTheFrame.getCharaObjects();
	  private static ArrayList<Chara> charas = IAmTheFrame.getCharas();
	  private static Klasse[] klassen = Klasse.class.getEnumConstants();
	  private static JLabel jLabelKlasse = new JLabel();
	  private static JTable info;
	  private static JButton btnZuweisen;
	  private static JButton btnLoeschen;
	  private static JButton btnSpeichern;
	  private static JButton btnSpeichernUnter;
	  private static JScrollPane scrollPane;
	  private static JComboBox<String> comboBoxFert;
	private static JButton btnHinzufuegen;
	private static DefaultTableModel ferttable;

	public static void setUpValuePanel(JPanel vPanel){
		valuePanel = vPanel;
		
		valuePanel.setLayout(new MigLayout("gapy 3%, gapx 2%, insets 2%", "[14%,grow][14%,grow][14%,grow][14%,grow][14%,grow][30%,grow]", "[7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][7%,grow][10%,grow]"));
		
		jLabelNAME = new JLabel("Name");
		valuePanel.add(jLabelNAME, "cell 0 0,grow");
		
		jTextFieldNAME = new JTextField();
		jTextFieldNAME.setText("Name");
		valuePanel.add(jTextFieldNAME, "cell 1 0,grow");
		//jTextFieldNAME.setColumns(10);
		
		JLabel jLabelMeta = new JLabel("Metatyp");
		valuePanel.add(jLabelMeta, "cell 2 0,grow");
		
		jComboBox1 = new JComboBox(metatypes);
		valuePanel.add(jComboBox1, "cell 3 0,grow");
		
		jLabelKLIM = new JLabel("Körperliches Limit");
		valuePanel.add(jLabelKLIM, "cell 4 0,grow");
		
		//scrollPane = new JScrollPane();
		//valuePanel.add(scrollPane, "cell 5 0 1 6,grow");
		
		//allcharas = new JList<String>();
		//scrollPane.setViewportView(allcharas);
		scrollPane = new JScrollPane(allcharas, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new TitledBorder ( new EtchedBorder (), "Charaktere" ));
		valuePanel.add(scrollPane, "cell 5 0 1 6,grow");
		
		jLabelKON = new JLabel("Konstitution");
		valuePanel.add(jLabelKON, "cell 0 1,grow");
		
		jTextFieldKON = new JTextField();
		jTextFieldKON.setText("Kon");
		valuePanel.add(jTextFieldKON, "cell 1 1,grow");
		//jTextFieldKON.setColumns(10);
		
		jLabelKlasse = new JLabel("Klasse");
		valuePanel.add(jLabelKlasse, "cell 2 1,grow");
		
		jComboBoxKlasse = new JComboBox(klassen);
		valuePanel.add(jComboBoxKlasse, "cell 3 1,grow");
		
		jLabelKLIMAnz = new JLabel("Klim");
		valuePanel.add(jLabelKLIMAnz, "cell 4 1,alignx right,growy");
		
		jLabelGES = new JLabel("Geschicklichkeit");
		valuePanel.add(jLabelGES, "cell 0 2,grow");
		
		jTextFieldGES = new JTextField();
		jTextFieldGES.setText("Ges");
		valuePanel.add(jTextFieldGES, "cell 1 2,grow");
		//jTextFieldGES.setColumns(10);
		
		jLabelINI = new JLabel("Initiative");
		valuePanel.add(jLabelINI, "cell 2 2,grow");
		
		jTextFieldINI = new JTextField();
		jTextFieldINI.setText("Ini");
		valuePanel.add(jTextFieldINI, "cell 3 2,grow");
		//jTextFieldINI.setColumns(10);
		
		jLabelGLIM = new JLabel("Geistiges Limit");
		valuePanel.add(jLabelGLIM, "cell 4 2,grow");
		
		jLabelREA = new JLabel("Reaktion");
		valuePanel.add(jLabelREA, "cell 0 3,grow");
		
		jTextFieldREA = new JTextField();
		jTextFieldREA.setText("Rea");
		valuePanel.add(jTextFieldREA, "cell 1 3,grow");
		//jTextFieldREA.setColumns(10);
		
		JLabel jLabelINA = new JLabel("Astrale Initiative");
		valuePanel.add(jLabelINA, "cell 2 3,grow");
		
		jTextFieldINA = new JTextField();
		jTextFieldINA.setText("Ina");
		valuePanel.add(jTextFieldINA, "cell 3 3,grow");
		//jTextFieldINA.setColumns(10);
		
		JLabel jLabelGLIMAnz = new JLabel("Glim");
		valuePanel.add(jLabelGLIMAnz, "cell 4 3,alignx right,growy");
		
		JLabel jLabelSTA = new JLabel("Stärke");
		valuePanel.add(jLabelSTA, "cell 0 4,grow");
		
		jTextFieldSTA = new JTextField();
		jTextFieldSTA.setText("Sta");
		valuePanel.add(jTextFieldSTA, "cell 1 4,grow");
		//jTextFieldSTA.setColumns(10);
		
		JLabel jLabelINKS = new JLabel("Initiative mit KS");
		valuePanel.add(jLabelINKS, "cell 2 4,grow");
		
		jTextFieldINKS = new JTextField();
		jTextFieldINKS.setText("Inks");
		valuePanel.add(jTextFieldINKS, "cell 3 4,grow");
		//jTextFieldINKS.setColumns(10);
		
		JLabel jLabelSLIM = new JLabel("Soziales Limit");
		valuePanel.add(jLabelSLIM, "cell 4 4,grow");
		
		JLabel jLabelWIL = new JLabel("Willenskraft");
		valuePanel.add(jLabelWIL, "cell 0 5,grow");
		
		jTextFieldWIL = new JTextField();
		jTextFieldWIL.setText("Wil");
		valuePanel.add(jTextFieldWIL, "cell 1 5,grow");
		//jTextFieldWIL.setColumns(10);
		
		JLabel jLabelINHS = new JLabel("Initiative mit HS");
		valuePanel.add(jLabelINHS, "cell 2 5,grow");
		
		jTextFieldINHS = new JTextField();
		jTextFieldINHS.setText("Inhs");
		valuePanel.add(jTextFieldINHS, "cell 3 5,grow");
		//jTextFieldINHS.setColumns(10);
		
		JLabel jLabelSLIMAnz = new JLabel("Slim");
		valuePanel.add(jLabelSLIMAnz, "cell 4 5,alignx right,growy");
		
		JLabel jLabelLOG = new JLabel("Logik");
		valuePanel.add(jLabelLOG, "cell 0 6,grow");
		
		jTextFieldLOG = new JTextField();
		jTextFieldLOG.setText("Log");
		valuePanel.add(jTextFieldLOG, "cell 1 6,grow");
		//jTextFieldLOG.setColumns(10);
		
		JLabel jLabelKZM = new JLabel("Körperlicher ZM");
		valuePanel.add(jLabelKZM, "cell 2 6,grow");
		
		jTextFieldKZM = new JTextField();
		jTextFieldKZM.setText("KZM");
		valuePanel.add(jTextFieldKZM, "cell 3 6,grow");
		//jTextFieldKZM.setColumns(10);
		
		JLabel jLabelALIM = new JLabel("Astrales Limit");
		valuePanel.add(jLabelALIM, "cell 4 6,grow");
		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		valuePanel.add(scrollPane_1, "cell 5 6 1 7,grow");
		
//		info = new JList();
//		scrollPane_1.setViewportView(info);
		
		String[] tableNames = {"Fertigkeit", "Stufe"};
		ferttable = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return tableNames.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return tableNames[index]; 
            } 
        };
	    
	    info = new JTable(ferttable);
	    
	    JScrollPane scrollPaneInfo = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneInfo.setBorder(new TitledBorder ( new EtchedBorder (), "Fertigkeiten" ));
		valuePanel.add(scrollPaneInfo, "cell 5 6 1 7,grow");
		
		JLabel jLabelINT = new JLabel("Intuition");
		valuePanel.add(jLabelINT, "cell 0 7,grow");
		
		jTextFieldINT = new JTextField();
		jTextFieldINT.setText("Int");
		valuePanel.add(jTextFieldINT, "cell 1 7,grow");
		//jTextFieldINT.setColumns(10);
		
		JLabel jLabelGZM = new JLabel("Geistiger ZM");
		valuePanel.add(jLabelGZM, "cell 2 7,grow");
		
		jTextFieldGZM = new JTextField();
		jTextFieldGZM.setText("GZM");
		valuePanel.add(jTextFieldGZM, "cell 3 7,grow");
		//jTextFieldGZM.setColumns(10);
		
		JLabel jLabelALIMAnz = new JLabel("Alim");
		valuePanel.add(jLabelALIMAnz, "cell 4 7,alignx right,growy");
		
		JLabel jLabelCHA = new JLabel("Charisma");
		valuePanel.add(jLabelCHA, "cell 0 8,grow");
		
		jTextFieldCHA = new JTextField();
		jTextFieldCHA.setText("Cha");
		valuePanel.add(jTextFieldCHA, "cell 1 8,grow");
		//jTextFieldCHA.setColumns(10);
		
		JLabel jLabelPANZ = new JLabel("Panzerungswert");
		valuePanel.add(jLabelPANZ, "cell 2 8,grow");
		
		jTextFieldPanz = new JTextField();
		jTextFieldPanz.setText("Panz");
		valuePanel.add(jTextFieldPanz, "cell 3 8,grow");
		//jTextFieldPanz.setColumns(10);
		
		JLabel jLabelEDG = new JLabel("Edge");
		valuePanel.add(jLabelEDG, "cell 0 9,grow");
		
		jTextFieldEDG = new JTextField();
		jTextFieldEDG.setText("Edg");
		valuePanel.add(jTextFieldEDG, "cell 1 9,grow");
		//jTextFieldEDG.setColumns(10);
		
		JLabel jLabelFertigkeit = new JLabel("Fertigkeit");
		valuePanel.add(jLabelFertigkeit, "cell 2 9,grow");
		
		comboBoxFert = new JComboBox(Fertigkeit.getAllFertigkeitenAsStrings());
		valuePanel.add(comboBoxFert, "cell 3 9,grow");
		
		btnHinzufuegen = new JButton("Hinzufügen");
		valuePanel.add(btnHinzufuegen, "flowx,cell 4 9,grow");
		
		JLabel jLabelESS = new JLabel("Essenz");
		valuePanel.add(jLabelESS, "cell 0 10,grow");
		
		jTextFieldESS = new JTextField();
		jTextFieldESS.setText("Ess");
		valuePanel.add(jTextFieldESS, "cell 1 10,grow");
		//jTextFieldESS.setColumns(10);
		
		JLabel jLabelWaffe = new JLabel("Waffe");
		valuePanel.add(jLabelWaffe, "cell 2 10,grow");
		
		JComboBox comboBoxWaffe = new JComboBox();
		valuePanel.add(comboBoxWaffe, "cell 3 10,grow");
		
		JButton btnBearbeiten = new JButton("Bearbeiten");
		valuePanel.add(btnBearbeiten, "cell 4 10,grow");
		
		JLabel jLabelMAG = new JLabel("Magie/Resonanz");
		valuePanel.add(jLabelMAG, "cell 0 11,grow");
		
		jTextFieldMAG = new JTextField();
		jTextFieldMAG.setText("Mag");
		valuePanel.add(jTextFieldMAG, "cell 1 11,grow");
		//jTextFieldMAG.setColumns(10);
		
		JPanel panel = new JPanel();
		valuePanel.add(panel, "cell 0 12 5 1,grow");
		panel.setLayout(new MigLayout("gapy 3%, gapx 5%, insets 5%", "[25%,grow][25%,grow][25%,grow][25%,grow]", "[100%,grow]"));
		
		btnZuweisen = new JButton("Zuweisen");
		panel.add(btnZuweisen, "cell 0 0,grow");
		
		btnLoeschen = new JButton("Löschen");
		panel.add(btnLoeschen, "cell 1 0,grow");
		
		btnSpeichern = new JButton("Speichern");
		panel.add(btnSpeichern, "cell 2 0,grow");
		
		btnSpeichernUnter = new JButton("Speichern unter");
		panel.add(btnSpeichernUnter, "cell 3 0,grow");
		
		setFunctions();
		
	}	
	
	private static void setFunctions() {
		
//		frameWidth = IAmTheFrame.getFrameWidth();
//		frameHeight = IAmTheFrame.getFrameHeight();
//		compHeight = (int) (frameHeight*0.06);
//		gapSpaceV = (int) (frameHeight*0.01);
//		
//		jLabelKON.setBounds(32, 20, 166, compHeight);
//	    jLabelKON.setText("Konstitution");
//	    valuePanel.add(jLabelKON);
//	    jLabelGES.setBounds(32, jLabelKON.getY() + jLabelKON.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelGES.setText("Geschicklichkeit");
//	    valuePanel.add(jLabelGES);
//	    jLabelREA.setBounds(32, jLabelGES.getY() + jLabelGES.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelREA.setText("Reaktion");
//	    valuePanel.add(jLabelREA);
//	    jLabelSTA.setBounds(32, jLabelREA.getY() + jLabelREA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelSTA.setText("Stärke");
//	    valuePanel.add(jLabelSTA);
//	    jLabelWIL.setBounds(32, jLabelSTA.getY() + jLabelSTA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelWIL.setText("Willenskraft");
//	    valuePanel.add(jLabelWIL);
//	    jLabelLOG.setBounds(32, jLabelWIL.getY() + jLabelWIL.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelLOG.setText("Logik");
//	    valuePanel.add(jLabelLOG);
//	    jLabelINT.setBounds(32, jLabelLOG.getY() + jLabelLOG.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelINT.setText("Intuition");
//	    valuePanel.add(jLabelINT);  
//	    jLabelCHA.setBounds(32, jLabelINT.getY() + jLabelINT.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelCHA.setText("Charme");
//	    valuePanel.add(jLabelCHA);
//	    jLabelEDG.setBounds(32, jLabelCHA.getY() + jLabelCHA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelEDG.setText("Edge");
//	    valuePanel.add(jLabelEDG);
//	    jLabelESS.setBounds(32, jLabelEDG.getY() + jLabelEDG.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelESS.setText("Essenz");
//	    valuePanel.add(jLabelESS);
//	    jLabelMAG.setBounds(32, jLabelESS.getY() + jLabelESS.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelMAG.setText("Magie/Resonanz");
//	    valuePanel.add(jLabelMAG);
//	    
//	    jTextFieldKON.setBounds(216, 20, 150, compHeight);
//	    valuePanel.add(jTextFieldKON);
//	    jTextFieldGES.setBounds(216, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldGES);
//	    jTextFieldREA.setBounds(216, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldREA);
//	    jTextFieldSTA.setBounds(216, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldSTA);
//	    jTextFieldWIL.setBounds(216, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldWIL);
//	    jTextFieldLOG.setBounds(216, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldLOG);
//	    jTextFieldINT.setBounds(216, jTextFieldLOG.getY() + jTextFieldLOG.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldINT);
//	    jTextFieldCHA.setBounds(216, jTextFieldINT.getY() + jTextFieldINT.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldCHA);
//	    jTextFieldEDG.setBounds(216, jTextFieldCHA.getY() + jTextFieldCHA.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldEDG);
//	    jTextFieldESS.setBounds(216, jTextFieldEDG.getY() + jTextFieldEDG.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldESS);
//	    jTextFieldMAG.setBounds(216, jTextFieldESS.getY() + jTextFieldESS.getHeight() + gapSpaceV, 150, compHeight);
//	    valuePanel.add(jTextFieldMAG);
//	    
//	    jLabelMETA.setBounds(400, jLabelKON.getY(), 166, compHeight);
//	    jLabelMETA.setText("Metatyp");
//	    valuePanel.add(jLabelMETA);
//	    jLabelINI.setBounds(400, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelINI.setText("Initiative");
//	    valuePanel.add(jLabelINI);
//	    jLabelINA.setBounds(400, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelINA.setText("Astrale Initiative");
//	    valuePanel.add(jLabelINA);
//	    jLabelINKS.setBounds(400, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelINKS.setText("Initiative mit KS");
//	    valuePanel.add(jLabelINKS);
//	    jLabelINHS.setBounds(400, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelINHS.setText("Initiative mit HS");
//	    valuePanel.add(jLabelINHS);
//	    jLabelKZM.setBounds(400, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelKZM.setText("Körperlicher ZuMon");
//	    valuePanel.add(jLabelKZM);
//	    jLabelGZM.setBounds(400, jTextFieldLOG.getY() + jTextFieldLOG.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelGZM.setText("Geistiger ZuMon");
//	    valuePanel.add(jLabelGZM);
//	    jLabelPanz.setBounds(400, jTextFieldINT.getY() + jTextFieldINT.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelPanz.setText("Panzerungswert");
//	    valuePanel.add(jLabelPanz);
//	    jLabelNAME.setBounds(400, jTextFieldCHA.getY() + jTextFieldCHA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelNAME.setText("Name");
//	    valuePanel.add(jLabelNAME);
//	    jLabelKlasse.setBounds(400, jLabelNAME.getY() + jLabelNAME.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelKlasse.setText("Klasse");
//	    valuePanel.add(jLabelKlasse);
//	    
//	    jComboBox1 = new JComboBox<String>(metatypes);
//	    jComboBox1.setSelectedItem("Mensch");
//	    jComboBox1.setBounds(584, jLabelKON.getY(), 166, compHeight);
//	    valuePanel.add(jComboBox1);
//	    jTextFieldINI.setBounds(584, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldINI);
//	    jTextFieldINA.setBounds(584, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldINA);
//	    jTextFieldINKS.setBounds(584, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldINKS);
//	    jTextFieldINHS.setBounds(584, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldINHS);
//	    jTextFieldKZM.setBounds(584, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldKZM);
//	    jTextFieldGZM.setBounds(584, jTextFieldLOG.getY() + jTextFieldLOG.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldGZM);
//	    jTextFieldPanz.setBounds(584, jTextFieldINT.getY() + jTextFieldINT.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldPanz);
//	    jTextFieldNAME.setBounds(584, jTextFieldCHA.getY() + jTextFieldCHA.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jTextFieldNAME);
//	    
//	    jComboBoxKlasse = new JComboBox<Klasse>(klassen);
//	    jComboBoxKlasse.setBounds(584, jTextFieldNAME.getY() + jTextFieldNAME.getHeight() + gapSpaceV, 166, compHeight);
//	    valuePanel.add(jComboBoxKlasse);
//	    
//	    // Labels für Limits setzen
//	    jLabelKLIM.setBounds(800, jLabelKON.getY(), 166, compHeight);
//	    jLabelKLIM.setText("Körperliches Limit");
//	    valuePanel.add(jLabelKLIM);
//	    jLabelGLIM.setBounds(800, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelGLIM.setText("Geistiges Limit");
//	    valuePanel.add(jLabelGLIM);
//	    jLabelSLIM.setBounds(800, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelSLIM.setText("Soziales Limit");
//	    valuePanel.add(jLabelSLIM);
//	    
//	    jLabelKLIMAnz.setBounds(820, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelKLIMAnz.setText("");
//	    valuePanel.add(jLabelKLIMAnz);
//	    jLabelGLIMAnz.setBounds(820, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelGLIMAnz.setText("");
//	    valuePanel.add(jLabelGLIMAnz);
//	    jLabelSLIMAnz.setBounds(820, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 166, compHeight);
//	    jLabelSLIMAnz.setText("");
//	    valuePanel.add(jLabelSLIMAnz);
//	    
//	    // Buttons setzen
//	    jButton1.setBounds(208, jTextFieldMAG.getY() + jTextFieldMAG.getHeight() + 3*gapSpaceV, 203, compHeight);
//	    jButton1.setText("Zuweisen");
//	    jButton1.setMargin(new Insets(2, 2, 2, 2));
	    btnZuweisen.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        btnZuweisen_ActionPerformed(evt);
	      }
	    });
//	    valuePanel.add(jButton1);
//	    jButton2.setBounds(432, jTextFieldMAG.getY() + jTextFieldMAG.getHeight() + 3*gapSpaceV, 203, compHeight);
//	    jButton2.setText("Löschen");
//	    jButton2.setMargin(new Insets(2, 2, 2, 2));
	    btnLoeschen.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        btnLoeschen_ActionPerformed(evt);
	      }
	    });
//	    valuePanel.add(jButton2);
//	    jButton3.setBounds(656, jTextFieldMAG.getY() + jTextFieldMAG.getHeight() + 3*gapSpaceV, 203, compHeight);
//	    jButton3.setText("Speichern");
//	    jButton3.setMargin(new Insets(2, 2, 2, 2));
	    btnSpeichern.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        btnSpeichern_ActionPerformed(evt);
	      }
	    });
	    
	    btnHinzufuegen.addActionListener(new ActionListener() { 
		      public void actionPerformed(ActionEvent evt) { 
		        btnHinzufuegen_ActionPerformed(evt);
		      }
		});
//	    valuePanel.add(jButton3);
//	    
	    IAmTheFrame.getAllCharas().setModel(jList1Model);
//	    jList1ScrollPane.setBounds(1000, jLabelKON.getY(), frameWidth-1050, jLabelMAG.getY()+jLabelMAG.getHeight()-jLabelKON.getY());
//	    valuePanel.add(jList1ScrollPane);
	    //scrollPane.add(allcharas);
//	    
	    try {
	    	allcharas.setFont(new Font("Neuropol X Free",Font.BOLD,18));
	    } catch (Exception e){
	    	allcharas.setFont(new Font("Arial",Font.BOLD,18));
	    }
	    
	    allcharas.addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged( ListSelectionEvent e ) {
	        	if (!e.getValueIsAdjusting()){
	        		try {
		        		Chara chara = IAmTheFrame.searchCharaByName(allcharas.getSelectedValue().toString());
	        			jTextFieldKON.setText("" + chara.getKON());
	        			jTextFieldGES.setText("" + chara.getGES());
	        			jTextFieldREA.setText("" + chara.getREA());
	        			jTextFieldSTA.setText("" + chara.getSTA());
	        			jTextFieldWIL.setText("" + chara.getWIL());
	        			jTextFieldLOG.setText("" + chara.getLOG());
	        			jTextFieldINT.setText("" + chara.getINT());
	        			jTextFieldCHA.setText("" + chara.getCHA());
	        			jTextFieldEDG.setText("" + chara.getEDG());
	        			jTextFieldESS.setText("" + chara.getESS());
	        			jTextFieldMAG.setText("" + chara.getMAG());
	        			jTextFieldINI.setText("" + chara.getINI());
	        			jTextFieldINA.setText("" + chara.getINA());
	        			jTextFieldINKS.setText("" + chara.getINKS());
	        			jTextFieldINHS.setText("" + chara.getINHS());
	        			jTextFieldKZM.setText("" + chara.getKZM());
	        			jTextFieldGZM.setText("" + chara.getGZM());
	        			jTextFieldPanz.setText("" + chara.getPANZ());
	        			jTextFieldNAME.setText("" + chara.getName());
	        			jLabelKLIMAnz.setText("" + chara.getKLIM());
	        			jLabelGLIMAnz.setText("" + chara.getGLIM());
	        			jLabelSLIMAnz.setText("" + chara.getSLIM());
	        			jComboBox1.setSelectedItem(chara.getMeta());
	        			jComboBoxKlasse.setSelectedItem(chara.getKlasse());
	        			
	        			// Info-Table anpassen
	        			ferttable.setRowCount(0);
	        			HashMap<Fertigkeit, Integer> fert = chara.getFertigkeiten();
	        			Set<Fertigkeit> fertigkeiten = fert.keySet();
	        			for (Fertigkeit f : fertigkeiten) {
	        				ferttable.addRow(new Object[]{f.getName(), fert.get(f)});
	        			}
	        	   	} catch (java.lang.NullPointerException ex){
	        			ex.printStackTrace();
	        		}
	        	}
	        }
	      } );
	    
	    valuePanel.repaint();
	}
	
	// Setzen-Button! Neuer Chara wird angelegt und der Liste hinzugefügt!
	  public static void btnZuweisen_ActionPerformed(ActionEvent evt) {
	    
		  int kon = (jTextFieldKON.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldKON.getText());
		  int ges = (jTextFieldGES.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldGES.getText());
		  int rea = (jTextFieldREA.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldREA.getText());
		  int sta = (jTextFieldSTA.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldSTA.getText());
		  int wil = (jTextFieldWIL.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldWIL.getText());
		  int log = (jTextFieldLOG.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldLOG.getText());
		  int intu = (jTextFieldINT.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldINT.getText());
		  int cha = (jTextFieldCHA.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldCHA.getText());
		  int edg = (jTextFieldEDG.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldEDG.getText());
		  double ess = (jTextFieldESS.getText().equals("")) ? 0.0 : Double.parseDouble(jTextFieldESS.getText());
		  int mag = (jTextFieldMAG.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldMAG.getText());
		  String ini = jTextFieldINI.getText();
		  String ina = jTextFieldINA.getText();
		  String inks = jTextFieldINKS.getText();
		  String inhs = jTextFieldINHS.getText();
		  int kzm = (jTextFieldKZM.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldKZM.getText());
		  int gzm = (jTextFieldGZM.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldGZM.getText());
		  int panz = (jTextFieldPanz.getText().equals("")) ? 0 : Integer.parseInt(jTextFieldPanz.getText());
		  String name = jTextFieldNAME.getText();
		  String meta = (String) jComboBox1.getSelectedItem();
		  Klasse klasse = (Klasse) jComboBoxKlasse.getSelectedItem();
	    
		  Chara tmp = IAmTheFrame.searchCharaByName(name);

		  if (tmp != null){
			  System.out.println(tmp.toString());
			  tmp.updateValues(kon, ges, rea, sta, wil, log, intu, cha, edg, ess, mag, ini, ina, inks, inhs, kzm, gzm, panz, meta, klasse);
		  } else {
			  try {
				  Chara chara;
				  if (klasse.equals(Klasse.TECHNOMANCER)) {
					  System.out.println(name + " ist ein Techno!");
					  chara = new Techno(kon,ges,rea,sta,wil,log,intu,cha,edg,ess,mag,ini,ina,inks,inhs,kzm,gzm,panz,name,meta,klasse);
				  } else {
					  chara = new Chara(kon,ges,rea,sta,wil,log,intu,cha,edg,ess,mag,ini,ina,inks,inhs,kzm,gzm,panz,name,meta,klasse);
				  }
				 
				  charas.add(chara);
				  IAmTheFrame.addToAllCharas(name);
				  CombatPanel.addComboBoxes(name);
				  InitiativePanel.setComboBoxCharas(name);
			  } catch (Exception e){
				  System.out.println("Falsche Eingabewerte");
			  }
		  }
	  } // end of jButton1_ActionPerformed
	  
	  // Löschen eines Charakters
	  public static void btnLoeschen_ActionPerformed(ActionEvent evt) {
		  	int result = JOptionPane.showConfirmDialog(valuePanel,
					"Soll der Charakter wirklich gelöscht werden?", "Charakter löschen?",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
					Chara c = IAmTheFrame.searchCharaByName(allcharas.getSelectedValue());
					DefaultListModel<String> model = (DefaultListModel<String>) allcharas.getModel();
					int selectedIndex = allcharas.getSelectedIndex();
					if (selectedIndex != -1) {
					    model.remove(selectedIndex);
					}
					charas.remove(c);
			}
	  } // end of jButton2_ActionPerformed
	  
	  // Speichern-Button (Speichern der Werte in XML)
	  public static void btnSpeichern_ActionPerformed(ActionEvent evt) {
		  btnZuweisen_ActionPerformed(null);
		  XMLInterface.saveToXML(charas);
	  } // end of jButton2_ActionPerformed
	  
	  public static void btnHinzufuegen_ActionPerformed(ActionEvent evt) {
		  try {
			  String fert = (String) comboBoxFert.getSelectedItem();
			  Chara chara = IAmTheFrame.searchCharaByName(allcharas.getSelectedValue());
			  chara.addFertigkeit(Fertigkeit.getFertigkeitByID(Fertigkeit.getFertIDByName(fert)), 1);
			  System.out.println(chara.getName() + " hat die Fertigkeit " + fert);
			  
			  // Info-Table anpassen
  			  ferttable.setRowCount(0);
  			  HashMap<Fertigkeit, Integer> fertMap = chara.getFertigkeiten();
  			  Set<Fertigkeit> fertigkeiten = fertMap.keySet();
  			  for (Fertigkeit f : fertigkeiten) {
  				  ferttable.addRow(new Object[]{f.getName(), fertMap.get(f)});
  			  }
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	
}
