
import java.awt.*;
import java.awt.event.*;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 22.04.2017
  * @author Cauti
  */

public class IAmTheFrame extends JFrame {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -5364507751550309271L;
// Allgemeine Attribute
  private Chara verteidiger;
  private int akt = -1;
  private int erfolgeVert = -1;
  private ArrayList<Chara> charas = new ArrayList<Chara>();
  
  // Attribute für valuePanel
  private JLabel jLabelKON = new JLabel();
  private JLabel jLabelGES = new JLabel();
  private JLabel jLabelREA = new JLabel();
  private JLabel jLabelSTA = new JLabel();
  private JLabel jLabelWIL = new JLabel();
  private JLabel jLabelLOG = new JLabel();
  private JLabel jLabelINT = new JLabel();
  private JLabel jLabelCHA = new JLabel();
  private JLabel jLabelEDG = new JLabel();
  private JLabel jLabelESS = new JLabel();
  private JLabel jLabelMAG = new JLabel(), jLabelPanz = new JLabel();
  private JLabel jLabelKLIM = new JLabel();
  private JLabel jLabelKLIMAnz = new JLabel();
  private JLabel jLabelGLIM = new JLabel();
  private JLabel jLabelGLIMAnz = new JLabel();
  private JLabel jLabelSLIM = new JLabel();
  private JLabel jLabelSLIMAnz = new JLabel();
  private JLabel jLabelINI = new JLabel();
  private JLabel jLabelMETA = new JLabel();
  private JLabel jLabelINA = new JLabel();
  private JLabel jLabelINKS = new JLabel();
  private JLabel jLabelINHS = new JLabel();
  private JLabel jLabelKZM = new JLabel();
  private JLabel jLabelGZM = new JLabel();
  private JTextField jTextFieldKON = new JTextField();
  private JTextField jTextFieldGES = new JTextField();
  private JTextField jTextFieldREA = new JTextField();
  private JTextField jTextFieldSTA = new JTextField();
  private JTextField jTextFieldWIL = new JTextField();
  private JTextField jTextFieldLOG = new JTextField();
  private JTextField jTextFieldINT = new JTextField();
  private JTextField jTextFieldCHA = new JTextField();
  private JTextField jTextFieldEDG = new JTextField();
  private JTextField jTextFieldESS = new JTextField();
  private JTextField jTextFieldMAG = new JTextField();
  private JTextField jTextFieldName = new JTextField();
  private JButton jButton1 = new JButton();
  private JButton jButton3 = new JButton();
  private String[] metatypes = {"Mensch", "Zwerg", "Ork", "Elf", "Troll"};
  private JComboBox<String> jComboBox1;
  
  // Attribute für battlePanel
  private boolean isTabbed1 = false, isTabbed2 = false, isTabbed3 = false, isTabbed4 = false, isTabbed5 = false, isTabbed6 = false, isTabbed7 = false, isTabbed8 = false;
  private JComboBox<String> jComboBox3 = new JComboBox<String>();
  private JComboBox<String> jComboBox4 = new JComboBox<String>();
  private JLabel jLabelAng = new JLabel();
  private JLabel jLabelVert = new JLabel();
  private JLabel jLabelKZMbat = new JLabel();
  private JLabel jLabelGZMbat = new JLabel();
  private JLabel jLabelKZMbatAnz = new JLabel();
  private JLabel jLabelGZMbatAnz = new JLabel();
  private JLabel jLabelKZMbatMali = new JLabel();
  private JLabel jLabelGZMbatMali = new JLabel();
  private JLabel jLabelKZMbat2 = new JLabel();
  private JLabel jLabelGZMbat2 = new JLabel();
  private JLabel jLabelKZMbatAnz2 = new JLabel();
  private JLabel jLabelGZMbatAnz2 = new JLabel();
  private JLabel jLabelKZMbatMali2 = new JLabel();
  private JLabel jLabelGZMbatMali2 = new JLabel();
  private JLabel jLabelErgebnisAngr = new JLabel(), jLabelErgebnisVert = new JLabel(), jLabelReaVert = new JLabel(), jLabelIntVert = new JLabel();
  private JLabel jLabelNAME = new JLabel(), jLabelNettoErf = new JLabel(), jLabelPanzCombat = new JLabel();
  private JLabel equal = new JLabel(), equal2 = new JLabel(), equal3 = new JLabel(), equal4 = new JLabel(), minus = new JLabel(), equal5 = new JLabel();
  private JLabel plus = new JLabel(), plus2 = new JLabel(), plus3 = new JLabel(), plus4 = new JLabel(), plusminus = new JLabel(), plusminus2 = new JLabel(), bracketLeft = new JLabel(), bracketRight = new JLabel();
  private JLabel wuerfelAngr = new JLabel(), wuerfelVert = new JLabel(), treffer = new JLabel(), schadensArt = new JLabel(), jLabelModSCode = new JLabel(), jLabelNettoErfText = new JLabel(), jLabelModSCodeText = new JLabel();
  private JLabel jLabelmodPanz = new JLabel(), jLabelmodPanzText = new JLabel(), jLabelschadenWiderstandText = new JLabel(), jLabelKonCombat = new JLabel(), jLabelmodPanzAnz = new JLabel();
  private JLabel jLabelKonCombatAnz = new JLabel(), jLabelmodPanzAnz2 = new JLabel(), jLabelAnzSchadenWid = new JLabel(), wuerfelSchadenWid = new JLabel();
  private JLabel jLabelSCodenachWuerfeln = new JLabel();
  private JLabel eintragSCodenachWuerfeln = new JLabel();
  private JTextField eintragErgAngr = new JTextField(), eintragErgVert = new JTextField(), schadenscodeAngr = new JTextField(), eintragErgSchadenWid = new JTextField(); 
  private JTextField jTextFieldINA = new JTextField();
  private JTextField jTextFieldINKS = new JTextField();
  private JTextField jTextFieldINHS = new JTextField();
  private JTextField jTextFieldKZM = new JTextField();
  private JTextField jTextFieldINI = new JTextField();
  private JTextField jTextFieldGZM = new JTextField();
  private JTextField jTextFieldKampfart = new JTextField();
  private JTextField jTextFieldAttribut = new JTextField();
  private JTextField jTextFieldModiAngr = new JTextField();
  private JTextField jTextFieldLimitAngr = new JTextField();
  private JTextField jTextFieldModiVert = new JTextField(), jTextFieldPanzCombat = new JTextField(), jTextFieldDK = new JTextField();
  private JTextField jTextFieldPanz = new JTextField();
  private JTextField jTextFieldNAME = new JTextField();
  private JButton jButton2 = new JButton(), automWuerfeln = new JButton(), automWuerfeln2 = new JButton(), schadenAnwenden = new JButton(), zurueckSetzen = new JButton();
  private JButton update = new JButton();
  
  // Menüs und Panels
  private JMenu jMenu1;
  private JMenuBar jMenuBar1;
  private JDialog connectFrame;
  private JPanel valuePanel, battlePanel, initiativePanel;
  private JList<String> allcharas = new JList<String>();
  private static ArrayList<Chara> charaobjects = new ArrayList<Chara>();
  private DefaultListModel jList1Model = new DefaultListModel();
  private JScrollPane jList1ScrollPane = new JScrollPane(allcharas);
  private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
  // Ende Attribute
  
  public IAmTheFrame(String title) { 
    // Frame-Initialisierung
    connectFrame = new JDialog();  
    connectFrame.setTitle("CaSCaDE V. 1.0");
  
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int frameWidth = 1300; 
    int frameHeight = 850;
    connectFrame.setSize(frameWidth, frameHeight);
    int x = (d.width - connectFrame.getSize().width) / 2;
    int y = (d.height - connectFrame.getSize().height) / 2;
    connectFrame.setLocation(x, y);
    connectFrame.setResizable(false);
    valuePanel = new JPanel();
    battlePanel = new JPanel();
    initiativePanel = new JPanel();
    valuePanel.setLayout(null);
    battlePanel.setLayout(null);
    initiativePanel.setLayout(null);
    tabbedPane.addTab("Character", null, valuePanel, "Character Administration");
    tabbedPane.addTab("Initiative", null, initiativePanel, "Initiative Administration");
    tabbedPane.addTab("Combat", null, battlePanel, "Combat Emulation");
    connectFrame.add(tabbedPane);
    
    setUpValuePanel();  
    setUpMenues();   
    setUpCombatPanel(); 
    InitiativePanel.setupInitiativePanel(initiativePanel);
    connectFrame.setVisible(true);
  } // end of public IAmTheFrame
  
  // Anfang Methoden
  
  // Setzt das Menü
  public void setUpMenues(){
	  	jMenuBar1 = new JMenuBar();
      
	    jMenu1 = new JMenu("File");
	    jMenu1.setMnemonic(KeyEvent.VK_F);
	    
	    JMenuItem eMenuItem = new JMenuItem("Exit");
	    eMenuItem.setMnemonic(KeyEvent.VK_E);
	    eMenuItem.setToolTipText("Exit application");
	    eMenuItem.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        System.exit(0);
	      }
	    });
	    
	    // Lädt eine XML-File und zeigt die Charas an
	    JMenuItem eMenuItem2 = new JMenuItem("Load File");
	    eMenuItem2.setMnemonic(KeyEvent.VK_O);
	    eMenuItem2.setToolTipText("Load a File");
	    eMenuItem2.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	       FileNameExtensionFilter filter = new FileNameExtensionFilter("XML-Datei", "xml");
	       JFileChooser fc = new JFileChooser();
	       fc.addChoosableFileFilter(filter);
	       int returnVal = fc.showOpenDialog(null);
	       if(returnVal == JFileChooser.APPROVE_OPTION){
	              // Ausgabe der ausgewaehlten Datei
	             System.out.println("Die zu öffnende Datei ist: " + fc.getSelectedFile().getName());
	             
	             String path = fc.getSelectedFile().getAbsolutePath();
	             Chara[] c = ReadXMLFile.read(path);
	             for (Chara chara : c) {
	               charaobjects.add(chara);
	               ((DefaultListModel) allcharas.getModel()).addElement(chara.getName());
	               jComboBox3.addItem(chara.getName());
	               jComboBox4.addItem(chara.getName());
	               InitiativePanel.addComboBoxCharas(chara.getName());
	             }
	         }
	      }
	    });
	    
	    jMenu1.add(eMenuItem2);
	    jMenu1.add(eMenuItem);
	    
	    jMenuBar1.add(jMenu1);
	    
	    connectFrame.setJMenuBar(jMenuBar1);
  }
  
  // Setzt die Labels und Fields von valuePanel
  public void setUpValuePanel(){
	  	jLabelKON.setBounds(32, 40, 166, 36);
	    jLabelKON.setText("Konstitution");
	    valuePanel.add(jLabelKON);
	    jLabelREA.setBounds(32, 152, 166, 36);
	    jLabelREA.setText("Reaktion");
	    valuePanel.add(jLabelREA);
	    jLabelINT.setBounds(32, 376, 166, 36);
	    jLabelINT.setText("Intuition");
	    valuePanel.add(jLabelINT);
	    jLabelGES.setBounds(32, 96, 166, 36);
	    jLabelGES.setText("Geschicklichkeit");
	    valuePanel.add(jLabelGES);
	    jLabelLOG.setBounds(32, 320, 166, 36);
	    jLabelLOG.setText("Logik");
	    valuePanel.add(jLabelLOG);
	    jLabelWIL.setBounds(32, 264, 166, 36);
	    jLabelWIL.setText("Willenskraft");
	    valuePanel.add(jLabelWIL);
	    jLabelSTA.setBounds(32, 208, 166, 36);
	    jLabelSTA.setText("Stärke");
	    valuePanel.add(jLabelSTA);
	    jLabelCHA.setBounds(32, 432, 166, 36);
	    jLabelCHA.setText("Charme");
	    valuePanel.add(jLabelCHA);
	    jLabelEDG.setBounds(32, 488, 166, 36);
	    jLabelEDG.setText("Edge");
	    valuePanel.add(jLabelEDG);
	    jLabelESS.setBounds(32, 544, 166, 36);
	    jLabelESS.setText("Essenz");
	    valuePanel.add(jLabelESS);
	    jLabelMAG.setBounds(32, 600, 166, 36);
	    jLabelMAG.setText("Magie/Resonanz");
	    valuePanel.add(jLabelMAG);
	    jTextFieldKON.setBounds(216, 32, 150, 44);
	    valuePanel.add(jTextFieldKON);
	    jTextFieldGES.setBounds(216, 88, 150, 44);
	    valuePanel.add(jTextFieldGES);
	    jTextFieldREA.setBounds(216, 144, 150, 44);
	    valuePanel.add(jTextFieldREA);
	    jTextFieldSTA.setBounds(216, 200, 150, 44);
	    valuePanel.add(jTextFieldSTA);
	    jTextFieldWIL.setBounds(216, 256, 150, 44);
	    valuePanel.add(jTextFieldWIL);
	    jTextFieldLOG.setBounds(216, 312, 150, 44);
	    valuePanel.add(jTextFieldLOG);
	    jTextFieldINT.setBounds(216, 368, 150, 44);
	    valuePanel.add(jTextFieldINT);
	    jTextFieldCHA.setBounds(216, 424, 150, 44);
	    valuePanel.add(jTextFieldCHA);
	    jTextFieldEDG.setBounds(216, 480, 150, 44);
	    valuePanel.add(jTextFieldEDG);
	    jTextFieldESS.setBounds(216, 536, 150, 44);
	    valuePanel.add(jTextFieldESS);
	    jTextFieldMAG.setBounds(216, 592, 150, 44);
	    valuePanel.add(jTextFieldMAG);
	    jButton1.setBounds(208, 656, 203, 49);
	    jButton1.setText("Zuweisen");
	    jButton1.setMargin(new Insets(2, 2, 2, 2));
	    jButton1.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton1_ActionPerformed(evt);
	      }
	    });
	    valuePanel.add(jButton1);
	    jLabelMETA.setBounds(400, 40, 166, 36);
	    jLabelMETA.setText("Metatyp");
	    valuePanel.add(jLabelMETA);
	    
	    jComboBox1 = new JComboBox<String>(metatypes);
	    jComboBox1.setSelectedItem("Mensch");
	    jComboBox1.setBounds(584, 32, 166, 44);
	    valuePanel.add(jComboBox1);
	    
	    jLabelINI.setBounds(400, 96, 166, 36);
	    jLabelINI.setText("Initiative");
	    valuePanel.add(jLabelINI);
	    jLabelINA.setBounds(400, 152, 166, 36);
	    jLabelINA.setText("Astrale Initiative");
	    valuePanel.add(jLabelINA);
	    jLabelINKS.setBounds(400, 208, 166, 36);
	    jLabelINKS.setText("Initiative mit KS");
	    valuePanel.add(jLabelINKS);
	    jLabelINHS.setBounds(400, 264, 166, 36);
	    jLabelINHS.setText("Initiative mit HS");
	    valuePanel.add(jLabelINHS);
	    jLabelKZM.setBounds(400, 320, 166, 36);
	    jLabelKZM.setText("Körperlicher ZuMon");
	    valuePanel.add(jLabelKZM);
	    jLabelGZM.setBounds(400, 376, 166, 36);
	    jLabelGZM.setText("Geistiger ZuMon");
	    valuePanel.add(jLabelGZM);
	    jLabelPanz.setBounds(400, 432, 166, 36);
	    jLabelPanz.setText("Panzerungswert");
	    valuePanel.add(jLabelPanz);
	    jLabelNAME.setBounds(400, 488, 166, 36);
	    jLabelNAME.setText("Name");
	    valuePanel.add(jLabelNAME);
	    jTextFieldINI.setBounds(584, 88, 166, 44);
	    valuePanel.add(jTextFieldINI);
	    jTextFieldINA.setBounds(584, 144, 166, 44);
	    valuePanel.add(jTextFieldINA);
	    jTextFieldINKS.setBounds(584, 200, 166, 44);
	    valuePanel.add(jTextFieldINKS);
	    jTextFieldINHS.setBounds(584, 256, 166, 44);
	    valuePanel.add(jTextFieldINHS);
	    jTextFieldKZM.setBounds(584, 312, 166, 44);
	    valuePanel.add(jTextFieldKZM);
	    jTextFieldGZM.setBounds(584, 368, 166, 44);
	    valuePanel.add(jTextFieldGZM);
	    jTextFieldPanz.setBounds(584, 424, 166, 44);
	    valuePanel.add(jTextFieldPanz);
	    jTextFieldNAME.setBounds(584, 480, 166, 44);
	    valuePanel.add(jTextFieldNAME);
	    
	    // Labels für Limits setzen
	    jLabelKLIM.setBounds(800, 40, 166, 36);
	    jLabelKLIM.setText("Körperliches Limit");
	    valuePanel.add(jLabelKLIM);
	    jLabelGLIM.setBounds(800, 152, 166, 36);
	    jLabelGLIM.setText("Geistiges Limit");
	    valuePanel.add(jLabelGLIM);
	    jLabelSLIM.setBounds(800, 264, 166, 36);
	    jLabelSLIM.setText("Soziales Limit");
	    valuePanel.add(jLabelSLIM);
	    
	    jLabelKLIMAnz.setBounds(820, 80, 166, 36);
	    jLabelKLIMAnz.setText("");
	    valuePanel.add(jLabelKLIMAnz);
	    jLabelGLIMAnz.setBounds(820, 192, 166, 36);
	    jLabelGLIMAnz.setText("");
	    valuePanel.add(jLabelGLIMAnz);
	    jLabelSLIMAnz.setBounds(820, 304, 166, 36);
	    jLabelSLIMAnz.setText("");
	    valuePanel.add(jLabelSLIMAnz);
	    
	    
	    
	    // Buttons setzen
	    jButton2.setBounds(432, 656, 203, 49);
	    jButton2.setText("Zurücksetzen");
	    jButton2.setMargin(new Insets(2, 2, 2, 2));
	    jButton2.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton2_ActionPerformed(evt);
	      }
	    });
	    valuePanel.add(jButton2);
	    
	    jButton3.setBounds(656, 656, 203, 49);
	    jButton3.setText("Speichern");
	    jButton3.setMargin(new Insets(2, 2, 2, 2));
	    jButton3.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton3_ActionPerformed(evt);
	      }
	    });
	    valuePanel.add(jButton3);
	    
	    allcharas.setModel(jList1Model);
	    jList1ScrollPane.setBounds(1000, 32, 250, 600);
	    valuePanel.add(jList1ScrollPane);
	    
	    
	    allcharas.addListSelectionListener(new ListSelectionListener()
	    {
	        public void valueChanged( ListSelectionEvent e ) {
	          akt = e.getFirstIndex();
	          jTextFieldKON.setText("" + charaobjects.get(akt).getKON());
	          jTextFieldGES.setText("" + charaobjects.get(akt).getGES());
	          jTextFieldREA.setText("" + charaobjects.get(akt).getREA());
	          jTextFieldSTA.setText("" + charaobjects.get(akt).getSTA());
	          jTextFieldWIL.setText("" + charaobjects.get(akt).getWIL());
	          jTextFieldLOG.setText("" + charaobjects.get(akt).getLOG());
	          jTextFieldINT.setText("" + charaobjects.get(akt).getINT());
	          jTextFieldCHA.setText("" + charaobjects.get(akt).getCHA());
	          jTextFieldEDG.setText("" + charaobjects.get(akt).getEDG());
	          jTextFieldESS.setText("" + charaobjects.get(akt).getESS());
	          jTextFieldMAG.setText("" + charaobjects.get(akt).getMAG());
	          jTextFieldINI.setText("" + charaobjects.get(akt).getINI());
	          jTextFieldINA.setText("" + charaobjects.get(akt).getINA());
	          jTextFieldINKS.setText("" + charaobjects.get(akt).getINKS());
	          jTextFieldINHS.setText("" + charaobjects.get(akt).getINHS());
	          jTextFieldKZM.setText("" + charaobjects.get(akt).getKZM());
	          jTextFieldGZM.setText("" + charaobjects.get(akt).getGZM());
	          jTextFieldPanz.setText("" + charaobjects.get(akt).getPANZ());
	          jTextFieldNAME.setText("" + charaobjects.get(akt).getName());
	          jLabelKLIMAnz.setText("" + charaobjects.get(akt).getKLIM());
	          jLabelGLIMAnz.setText("" + charaobjects.get(akt).getGLIM());
	          jLabelSLIMAnz.setText("" + charaobjects.get(akt).getSLIM());
	          jComboBox1.setSelectedItem(charaobjects.get(akt).getMeta());
	        }
	      } );
  }
  
  // Setzt die Labels und Fields von combatPanel
  public void setUpCombatPanel(){
	  	jLabelAng.setBounds(290, 30, 166, 36);
	  	jLabelAng.setFont(jLabelAng.getFont().deriveFont(18f));
	    jLabelAng.setText("Angereifer");
	    battlePanel.add(jLabelAng);
	    jLabelVert.setBounds(790, 30, 166, 36);
	    jLabelVert.setFont(jLabelVert.getFont().deriveFont(18f));
	    jLabelVert.setText("Verteidiger");
	    battlePanel.add(jLabelVert);
	    
	    jComboBox3.setBounds(250, 80, 166, 44);
	    battlePanel.add(jComboBox3);
	    jComboBox4.setBounds(750, 80, 166, 44);
	    battlePanel.add(jComboBox4);
	    
	    jLabelKZMbat.setBounds(180,130,200,36);
	    jLabelKZMbat.setText("Körperlicher ZuMon");
	    battlePanel.add(jLabelKZMbat);
	    jLabelGZMbat.setBounds(380,130,200,36);
	    jLabelGZMbat.setText("Geistiger ZuMon");
	    battlePanel.add(jLabelGZMbat);
	    jLabelKZMbatAnz.setBounds(190,160,200,36);
	    jLabelKZMbatAnz.setText("");
	    battlePanel.add(jLabelKZMbatAnz);
	    jLabelGZMbatAnz.setBounds(390,160,200,36);
	    jLabelGZMbatAnz.setText("");
	    battlePanel.add(jLabelGZMbatAnz);
	    jLabelKZMbatMali.setBounds(250,160,200,36);
	    jLabelKZMbatMali.setText("");
	    battlePanel.add(jLabelKZMbatMali);
	    jLabelGZMbatMali.setBounds(450,160,200,36);
	    jLabelGZMbatMali.setText("");
	    battlePanel.add(jLabelGZMbatMali);
	    
	    jLabelKZMbat2.setBounds(680,130,200,36);
	    jLabelKZMbat2.setText("Körperlicher ZuMon");
	    battlePanel.add(jLabelKZMbat2);
	    jLabelGZMbat2.setBounds(880,130,200,36);
	    jLabelGZMbat2.setText("Geistiger ZuMon");
	    battlePanel.add(jLabelGZMbat2);
	    jLabelKZMbatAnz2.setBounds(690,160,200,36);
	    jLabelKZMbatAnz2.setText("");
	    battlePanel.add(jLabelKZMbatAnz2);
	    jLabelGZMbatAnz2.setBounds(890,160,200,36);
	    jLabelGZMbatAnz2.setText("");
	    battlePanel.add(jLabelGZMbatAnz2);
	    jLabelKZMbatMali2.setBounds(750,160,200,36);
	    jLabelKZMbatMali2.setText("");
	    battlePanel.add(jLabelKZMbatMali2);
	    jLabelGZMbatMali2.setBounds(950,160,200,36);
	    jLabelGZMbatMali2.setText("");
	    battlePanel.add(jLabelGZMbatMali2);
	    
	    jTextFieldKampfart.setBounds(40, 240, 100, 44);
	    jTextFieldKampfart.setText("Kampffertigkeit");
	    battlePanel.add(jTextFieldKampfart);
	    jTextFieldAttribut.setBounds(170, 240, 100, 44);
	    jTextFieldAttribut.setText("Attribut");
	    battlePanel.add(jTextFieldAttribut);
	    jTextFieldModiAngr.setBounds(300, 240, 100, 44);
	    jTextFieldModiAngr.setText("Modifikator" + " (" + jLabelKZMbatMali.getText() + ")" );
	    battlePanel.add(jTextFieldModiAngr);
	    jTextFieldLimitAngr.setBounds(430, 240, 100, 44);
	    jTextFieldLimitAngr.setText("Limit (Waffe)");
	    battlePanel.add(jTextFieldLimitAngr);
	    
	    plus.setBounds(150,240,200,36);
	    plus.setText("+");
	    battlePanel.add(plus);
	    plusminus.setBounds(280,240,200,36);
	    plusminus.setText("\u00B1");
	    battlePanel.add(plusminus);
	    bracketLeft.setBounds(420,240,200,36);
	    bracketLeft.setText("[");
	    battlePanel.add(bracketLeft);
	    bracketRight.setBounds(540,240,200,36);
	    bracketRight.setText("]");
	    battlePanel.add(bracketRight);
	    equal.setBounds(200,300,200,36);
	    equal.setFont(equal.getFont().deriveFont(18f));
	    equal.setText("=");
	    battlePanel.add(equal);
	    jLabelErgebnisAngr.setBounds(300,300,200,36);
	    jLabelErgebnisAngr.setFont(jLabelErgebnisAngr.getFont().deriveFont(18f));
	    jLabelErgebnisAngr.setText("");
	    battlePanel.add(jLabelErgebnisAngr);
	    
	    jLabelReaVert.setBounds(700, 240, 100, 44);
	    jLabelReaVert.setText("");
	    battlePanel.add(jLabelReaVert);
	    jLabelIntVert.setBounds(830, 240, 100, 44);
	    jLabelIntVert.setText("");
	    battlePanel.add(jLabelIntVert);
	    plus2.setBounds(815,240,200,36);
	    plus2.setText("+");
	    battlePanel.add(plus2);
	    plusminus2.setBounds(945,240,200,36);
	    plusminus2.setText("\u00B1");
	    battlePanel.add(plusminus2);
	    jTextFieldModiVert.setBounds(960, 240, 100, 44);
	    jTextFieldModiVert.setText("Modifikator" + " (" + jLabelKZMbatMali2.getText() + ")" );
	    battlePanel.add(jTextFieldModiVert);
	    
	    equal2.setBounds(700,300,200,36);
	    equal2.setFont(equal.getFont().deriveFont(18f));
	    equal2.setText("=");
	    battlePanel.add(equal2);
	    jLabelErgebnisVert.setBounds(900,300,200,36);
	    jLabelErgebnisVert.setFont(jLabelErgebnisVert.getFont().deriveFont(18f));
	    jLabelErgebnisVert.setText("");
	    battlePanel.add(jLabelErgebnisVert);
	    
	    wuerfelAngr.setBounds(100, 350, 150, 44);
	    wuerfelAngr.setText("Ergebnis Würfelwurf:");
	    battlePanel.add(wuerfelAngr);
	    eintragErgAngr.setBounds(270, 350, 150, 44);
	    battlePanel.add(eintragErgAngr);
	    
	    wuerfelVert.setBounds(700, 350, 150, 44);
	    wuerfelVert.setText("Ergebnis Würfelwurf:");
	    battlePanel.add(wuerfelVert);
	    eintragErgVert.setBounds(870, 350, 150, 44);
	    battlePanel.add(eintragErgVert);
	    automWuerfeln.setBounds(1030, 350, 150, 44);
	    automWuerfeln.setText("Würfeln");
	    automWuerfeln.setMargin(new Insets(2, 2, 2, 2));
	    automWuerfeln.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        automWuerfeln_ActionPerformed(evt);
	      }
	    });
	    battlePanel.add(automWuerfeln);
	    
	    treffer.setBounds(570, 400, 150, 44);
	    treffer.setFont(treffer.getFont().deriveFont(18f));
	    treffer.setText("");
	    battlePanel.add(treffer);
	    
	    jLabelNettoErfText.setBounds(280, 440, 100, 44);
	    jLabelNettoErfText.setText("Nettoerfolge");
	    battlePanel.add(jLabelNettoErfText);
	    jLabelModSCodeText.setBounds(400, 440, 130, 44);
	    jLabelModSCodeText.setText("mod. Schadenscode");
	    battlePanel.add(jLabelModSCodeText);
	    jLabelPanzCombat.setBounds(700, 440, 150, 44);
	    jLabelPanzCombat.setText("Panzerungswert");
	    battlePanel.add(jLabelPanzCombat);
	    
	    schadenscodeAngr.setBounds(100, 470, 150, 44);
	    schadenscodeAngr.setText("Schadenscode");
	    battlePanel.add(schadenscodeAngr);
	    plus3.setBounds(265,470,50,36);
	    plus3.setText("+");
	    battlePanel.add(plus3);
	    jLabelNettoErf.setBounds(280, 470, 80, 44);
	    jLabelNettoErf.setText("");
	    battlePanel.add(jLabelNettoErf);
	    equal3.setBounds(350,470,100,44);
	    equal3.setFont(equal3.getFont().deriveFont(18f));
	    equal3.setText("=");
	    battlePanel.add(equal3);
	    jLabelModSCode.setBounds(400,470,100,44);
	    jLabelModSCode.setFont(jLabelModSCode.getFont().deriveFont(18f));
	    battlePanel.add(jLabelModSCode);
	    
	    jTextFieldPanzCombat.setBounds(700,470,150,44);
	    jTextFieldPanzCombat.setText("");
	    battlePanel.add(jTextFieldPanzCombat);
	    minus.setBounds(860,470,20,44);
	    minus.setText("-");
	    battlePanel.add(minus);
	    jTextFieldDK.setBounds(880,470,150,44);
	    jTextFieldDK.setText("DK");
	    battlePanel.add(jTextFieldDK);
	    equal4.setBounds(1040,470,30,44);
	    equal4.setFont(equal4.getFont().deriveFont(18f));
	    equal4.setText("=");
	    battlePanel.add(equal4);
	    jLabelmodPanz.setBounds(1070,470,100,44);
	    jLabelmodPanz.setFont(jLabelmodPanz.getFont().deriveFont(18f));
	    jLabelmodPanz.setText("");
	    battlePanel.add(jLabelmodPanz);
	    jLabelmodPanzText.setBounds(1070, 440, 150, 44);
	    jLabelmodPanzText.setText("mod. Panzerungswert");
	    battlePanel.add(jLabelmodPanzText);
	    
	    schadensArt.setBounds(520, 530, 200, 44);
	    schadensArt.setFont(schadensArt.getFont().deriveFont(18f));
	    schadensArt.setText("");
	    battlePanel.add(schadensArt);
	    
	    jLabelschadenWiderstandText.setBounds(700, 560, 300, 44);
	    jLabelschadenWiderstandText.setText("Anzahl Würfel für Schadenswidertsandsprobe:");
	    battlePanel.add(jLabelschadenWiderstandText);
	    
	    jLabelKonCombat.setBounds(700, 580, 100, 44);
	    jLabelKonCombat.setText("Kon");
	    battlePanel.add(jLabelKonCombat);
	    jLabelmodPanzAnz.setBounds(800, 580, 100, 44);
	    jLabelmodPanzAnz.setText("mod. Panz.");
	    battlePanel.add(jLabelmodPanzAnz);
	    jLabelKonCombatAnz.setBounds(700, 600, 100, 44);
	    jLabelKonCombatAnz.setText("");
	    battlePanel.add(jLabelKonCombatAnz);
	    jLabelmodPanzAnz2.setBounds(800, 600, 100, 44);
	    jLabelmodPanzAnz2.setText("");
	    battlePanel.add(jLabelmodPanzAnz2);
	    plus4.setBounds(780, 600, 20, 44);
	    plus4.setText("+");
	    battlePanel.add(plus4);
	    equal5.setBounds(920,600,30,44);
	    equal5.setFont(equal5.getFont().deriveFont(18f));
	    equal5.setText("=");
	    battlePanel.add(equal5);
	    jLabelAnzSchadenWid.setBounds(950,600,100,44);
	    jLabelAnzSchadenWid.setFont(jLabelAnzSchadenWid.getFont().deriveFont(18f));
	    jLabelAnzSchadenWid.setText("");
	    battlePanel.add(jLabelAnzSchadenWid);
	    
	    wuerfelSchadenWid.setBounds(700, 650, 150, 44);
	    wuerfelSchadenWid.setText("Ergebnis Würfelwurf:");
	    battlePanel.add(wuerfelSchadenWid);
	    eintragErgSchadenWid.setBounds(870, 650, 150, 44);
	    battlePanel.add(eintragErgSchadenWid);
	    automWuerfeln2.setBounds(1030, 650, 150, 44);
	    automWuerfeln2.setText("Würfeln");
	    automWuerfeln2.setMargin(new Insets(2, 2, 2, 2));
	    automWuerfeln2.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        automWuerfeln2_ActionPerformed(evt);
	      }
	    });
	    battlePanel.add(automWuerfeln2);
	    
	    jLabelSCodenachWuerfeln.setBounds(100, 600, 300, 44);
	    jLabelSCodenachWuerfeln.setText("Schadenscode nach Widerstandsprobe:");
	    battlePanel.add(jLabelSCodenachWuerfeln);
	    eintragSCodenachWuerfeln.setBounds(400, 600, 150, 44);
	    eintragSCodenachWuerfeln.setFont(eintragSCodenachWuerfeln.getFont().deriveFont(18f));
	    eintragSCodenachWuerfeln.setText("");
	    battlePanel.add(eintragSCodenachWuerfeln);
	    
	    schadenAnwenden.setBounds(250, 700, 200, 60);
	    schadenAnwenden.setText("Anwenden!");
	    schadenAnwenden.setMargin(new Insets(2, 2, 2, 2));
	    schadenAnwenden.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  schadenAnwenden_ActionPerformed(evt);
	      }
	    });
	    battlePanel.add(schadenAnwenden);
	    
	    zurueckSetzen.setBounds(470, 700, 200, 60);
	    zurueckSetzen.setText("Zurücksetzen");
	    zurueckSetzen.setMargin(new Insets(2, 2, 2, 2));
	    zurueckSetzen.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  zurueckSetzen_ActionPerformed(evt);
	      }
	    });
	    battlePanel.add(zurueckSetzen);
	    
	    update.setBounds(690, 700, 200, 60);
	    update.setText("Update Werte");
	    update.setMargin(new Insets(2, 2, 2, 2));
	    update.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  update_ActionPerformed(evt);
	      }
	    });
	    battlePanel.add(update);
	    
	    
	    // ActionListener für jComboBox3 (Angreifer)
	    jComboBox3.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		Chara ref = searchCharaByName((String) jComboBox3.getSelectedItem());
	    		jLabelKZMbatAnz.setText("" + ref.getKZM());
	    		jLabelGZMbatAnz.setText("" + ref.getGZM());
	    		jLabelKZMbatMali.setText("" + ((ref.getKZMAbs() - ref.getKZM()) / 3));
	    		jLabelGZMbatMali.setText("" + ((ref.getGZMAbs() - ref.getGZM()) / 3));
	    		jTextFieldModiAngr.setText("Modifikator" + " (" + jLabelKZMbatMali.getText() + ")" );
	    	}
	    });
	    // ActionListener für jComboBox4 (Verteidiger)
	    jComboBox4.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		Chara ref = searchCharaByName((String) jComboBox4.getSelectedItem());
	    		jLabelKZMbatAnz2.setText("" + ref.getKZM());
	    		jLabelGZMbatAnz2.setText("" + ref.getGZM());
	    		jLabelKZMbatMali2.setText("" + ((ref.getKZMAbs() - ref.getKZM()) / 3));
	    		jLabelGZMbatMali2.setText("" + ((ref.getGZMAbs() - ref.getGZM()) / 3));
	    		jLabelReaVert.setText("" + ref.getREA());
	    		jLabelIntVert.setText("" + ref.getINT());
	    		jTextFieldPanzCombat.setText("" + ref.getPANZ());
	    		jLabelKonCombatAnz.setText("" + ref.getKON());
	    		verteidiger = ref;
	    	}
	    });
	    
	 // Lässt den Text löschen, wenn in Textfeld geklickt wird
	    jTextFieldDK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed7){
            		jTextFieldDK.setText("");
            		isTabbed7 = true;
            	}	
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
            	calcSchadensArt();
            }
        });
	 // Lässt den Text löschen, wenn in Textfeld geklickt wird
	    eintragErgSchadenWid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed8){
            		eintragErgSchadenWid.setText("");
            		isTabbed8 = true;
            	}	
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
            	try {
          		  	eintragSCodenachWuerfeln.setText("" + (Integer.parseInt(jLabelModSCode.getText()) - Integer.parseInt(eintragErgSchadenWid.getText())));
          	  	} catch (Exception e) {
          	  		System.out.println("Fehler42");
          	  	}
            }
        });
	    
	 // Lässt den Text löschen, wenn in Textfeld geklickt wird
	    schadenscodeAngr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed6){
            		schadenscodeAngr.setText("");
            		isTabbed6 = true;
            	}	
            }
            public void focusLost(java.awt.event.FocusEvent evt){
            	try {
            		int nettoerf = (Integer.parseInt(eintragErgAngr.getText()) - Integer.parseInt(eintragErgVert.getText()));
            		if (nettoerf > 0) jLabelNettoErf.setText("" + nettoerf);
            		jLabelModSCode.setText("" + (Integer.parseInt(schadenscodeAngr.getText()) + nettoerf));
            		calcSchadensArt();
        		} catch (Exception e){
        			System.out.println("Keine Zahl!");
        		}
            }
        });
	    // Lässt den Text löschen, wenn in Textfeld geklickt wird
	    jTextFieldModiAngr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed1){
            		jTextFieldModiAngr.setText("");
            		isTabbed1 = true;
            	}	
            }
            public void focusLost(java.awt.event.FocusEvent evt){
            	try {
        			jLabelErgebnisAngr.setText("" + (Integer.parseInt(jTextFieldKampfart.getText()) + Integer.parseInt(jTextFieldAttribut.getText()) + Integer.parseInt(jTextFieldModiAngr.getText())) + " [" + Integer.parseInt(jTextFieldLimitAngr.getText()) + "]");
        		} catch (Exception e){
        			System.out.println("Wohl keine Zahl eingegeben?");
        		}
            }
        });
	    jTextFieldKampfart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed2){
            		jTextFieldKampfart.setText("");
            		isTabbed2 = true;
            	}
            }
            public void focusLost(java.awt.event.FocusEvent evt){
            	try {
        			jLabelErgebnisAngr.setText("" + (Integer.parseInt(jTextFieldKampfart.getText()) + Integer.parseInt(jTextFieldAttribut.getText()) + Integer.parseInt(jTextFieldModiAngr.getText())) + " [" + Integer.parseInt(jTextFieldLimitAngr.getText()) + "]");
        		} catch (Exception e){
        			System.out.println("Wohl keine Zahl eingegeben?");
        		}
            }
        });
	    jTextFieldAttribut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed3){
            		jTextFieldAttribut.setText("");
            		isTabbed3 = true;
            	}
            }
            public void focusLost(java.awt.event.FocusEvent evt){
            	try {
        			jLabelErgebnisAngr.setText("" + (Integer.parseInt(jTextFieldKampfart.getText()) + Integer.parseInt(jTextFieldAttribut.getText()) + Integer.parseInt(jTextFieldModiAngr.getText())) + " [" + Integer.parseInt(jTextFieldLimitAngr.getText()) + "]");
        		} catch (Exception e){
        			System.out.println("Wohl keine Zahl eingegeben?");
        		}
            }
        });
	    jTextFieldLimitAngr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed4){
            		jTextFieldLimitAngr.setText("");
            		isTabbed4 = true;
            	}
            }
            public void focusLost(java.awt.event.FocusEvent evt){
            	try {
        			jLabelErgebnisAngr.setText("" + (Integer.parseInt(jTextFieldKampfart.getText()) + Integer.parseInt(jTextFieldAttribut.getText()) + Integer.parseInt(jTextFieldModiAngr.getText())) + " [" + Integer.parseInt(jTextFieldLimitAngr.getText()) + "]");
        		} catch (Exception e){
        			System.out.println("Wohl keine Zahl eingegeben?");
        		}
            }
        });
	    jTextFieldModiVert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (!isTabbed5){
            		jTextFieldModiVert.setText("");
            		isTabbed5 = true;
            	}
            }
            public void focusLost(java.awt.event.FocusEvent evt){
            	try {
        			jLabelErgebnisVert.setText("" + (Integer.parseInt(jLabelReaVert.getText()) + Integer.parseInt(jLabelIntVert.getText()) + Integer.parseInt(jTextFieldModiVert.getText())));
        		} catch (Exception e){
        			System.out.println("Wohl keine Zahl eingegeben?");
        		}
            }
        });
	    eintragErgAngr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt){
            	calcTreffer();
            }
        });
	    eintragErgVert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt){
            	calcTreffer();
            }
        });
	    jTextFieldDK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt){
            	calcModPanz();
            }
        });
	    jTextFieldPanzCombat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt){
            	calcModPanz();
            }
        });
  }
  
  // Berechnet, welche Schadensart zustande kommt
  private boolean calcSchadensArt() {
	  try {
		  if (Integer.parseInt(jLabelModSCode.getText()) >= Integer.parseInt(jLabelmodPanz.getText())){
			  schadensArt.setForeground(Color.red);
			  schadensArt.setText("Körperlicher Schaden!");
			  return true;
		  } else {
			  schadensArt.setForeground(Color.green);
			  schadensArt.setText("Geistiger Schaden!");
		  }
		  
	  } catch (Exception e){
			System.out.println("Fehler!");
	  }
	  return false;
  }
  
  // Berechnet den mod. Panzerungswert
  private void calcModPanz() {
	  try {
		  	int n = (Integer.parseInt(jTextFieldPanzCombat.getText()) - Integer.parseInt(jTextFieldDK.getText()));
		  	if (n < 0) n = 0;
	  		jLabelmodPanz.setText("" + n);
	  		jLabelmodPanzAnz2.setText("" + n);
	  		jLabelAnzSchadenWid.setText("" + (Integer.parseInt(jLabelKonCombatAnz.getText()) + n));
	  } catch (Exception e){
			System.out.println("Fehler!");
	  }
  }
  
  // Berechnet, ob ein Treffer oder nicht stattfand und falls ja, werden Nettoerfolge angezeigt
  private void calcTreffer(){
	  try {
  		if (Integer.parseInt(eintragErgAngr.getText()) > Integer.parseInt(eintragErgVert.getText())) {
  			treffer.setForeground(Color.green);
  			treffer.setText("Treffer!");
  			jLabelNettoErf.setText("" + (Integer.parseInt(eintragErgAngr.getText()) - Integer.parseInt(eintragErgVert.getText())));
  		} else if (Integer.parseInt(eintragErgAngr.getText()) == Integer.parseInt(eintragErgVert.getText())){
  			treffer.setForeground(Color.black);
  			treffer.setText("Streiftreffer!");
  		} else {
  			treffer.setForeground(Color.red);
  			treffer.setText("Kein Treffer!");
  		}
		} catch (Exception e){
			System.out.println("Fehler!");
		}
  }
  
  // Antwortet den Chara mit dem Namen @selectedItem
  public static Chara searchCharaByName(String selectedItem) {
	  	for (Chara c : charaobjects){
	  		if (c.getName().equals(selectedItem)){
	  			return c;
	  		}
	  	}
	  	return null;
  }

  public static void main(String[] args) {
    new IAmTheFrame("CASCADE V. 1.0 Beta");
  } // end of main
  
  // Setzen-Button!
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
//    System.out.println("KON " + jTextFieldKON.getText());
//    System.out.println("GES " + jTextFieldGES.getText());
//    System.out.println("REA " + jTextFieldREA.getText());
//    System.out.println("STA " + jTextFieldSTA.getText());
//    System.out.println("WIL " + jTextFieldWIL.getText());
//    System.out.println("LOG " + jTextFieldLOG.getText());
//    System.out.println("INT " + jTextFieldINT.getText());
//    System.out.println("CHA " + jTextFieldCHA.getText());
//    System.out.println("EDG " + jTextFieldEDG.getText());
//    System.out.println("ESS " + jTextFieldESS.getText());
//    System.out.println("MAG " + jTextFieldMAG.getText());
//    System.out.println("INI " + jTextFieldINI.getText());
//    System.out.println("INA " + jTextFieldINA.getText());
//    System.out.println("INKS " + jTextFieldINKS.getText());
//    System.out.println("INHS " + jTextFieldINHS.getText());
    
    try {
    	charas.add(new Chara(Integer.parseInt(jTextFieldKON.getText()), Integer.parseInt(jTextFieldGES.getText()), Integer.parseInt(jTextFieldREA.getText()), Integer.parseInt(jTextFieldSTA.getText()), Integer.parseInt(jTextFieldWIL.getText()), Integer.parseInt(jTextFieldLOG.getText()), Integer.parseInt(jTextFieldINT.getText()), Integer.parseInt(jTextFieldCHA.getText()), Integer.parseInt(jTextFieldEDG.getText()), Double.parseDouble(jTextFieldESS.getText()), Integer.parseInt(jTextFieldMAG.getText()), jTextFieldINI.getText(), jTextFieldINA.getText(), jTextFieldINKS.getText(), jTextFieldINHS.getText(), Integer.parseInt(jTextFieldKZM.getText()), Integer.parseInt(jTextFieldGZM.getText()), Integer.parseInt(jTextFieldPanz.getText()), jTextFieldName.getText(), jComboBox1.getSelectedItem().toString()));
    } catch (Exception e){
    	System.out.println("Falsche Eingabewerte");
    }
    // Danger: Momentan der 0. Character in der Liste!
    //jTextFieldKLIM.setText("" + charas.get(0).getKLIM());
    //jTextFieldGLIM.setText("" + charas.get(0).getGLIM());
    //jTextFieldSLIM.setText("" + charas.get(0).getSLIM());
    
    //jTextFieldKLIM.setText("" + Math.ceil((Integer.parseInt(jTextFieldSTA.getText())*2 + Integer.parseInt(jTextFieldKON.getText()) + Integer.parseInt(jTextFieldREA.getText()))/3));
  } // end of jButton1_ActionPerformed
  
  // Neue Felder!!!!
  // Zurücksetzen der Werte
  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
	  String[] values = {jTextFieldKON.getText(), jTextFieldGES.getText(), jTextFieldREA.getText(),jTextFieldSTA.getText(),jTextFieldWIL.getText(), jTextFieldLOG.getText(), jTextFieldINT.getText(), jTextFieldCHA.getText(), jTextFieldEDG.getText(), jTextFieldESS.getText(), jTextFieldMAG.getText(), jTextFieldINI.getText(), jTextFieldINA.getText(), jTextFieldINKS.getText(), jTextFieldINHS.getText(), jTextFieldKZM.getText(), jTextFieldGZM.getText(), jTextFieldName.getText(), (String) jComboBox1.getSelectedItem()};  
	  XMLFileModifier.append(values);  
  } // end of jButton2_ActionPerformed
  
  // Speichern der Werte in XML
  public void jButton3_ActionPerformed(ActionEvent evt) {
      // TODO hier Quelltext einfügen
	  String[] values = {jTextFieldKON.getText(), jTextFieldGES.getText(), jTextFieldREA.getText(),jTextFieldSTA.getText(),jTextFieldWIL.getText(), jTextFieldLOG.getText(), jTextFieldINT.getText(), jTextFieldCHA.getText(), jTextFieldEDG.getText(), jTextFieldESS.getText(), jTextFieldMAG.getText(), jTextFieldINI.getText(), jTextFieldINA.getText(), jTextFieldINKS.getText(), jTextFieldINHS.getText(), jTextFieldKZM.getText(), jTextFieldGZM.getText(), jTextFieldName.getText(), (String) jComboBox1.getSelectedItem()};
	  XMLFileModifier.append(values);  
  } // end of jButton2_ActionPerformed
  
  // Würfelt zufällig für den Verteidiger die Probe
  public void automWuerfeln_ActionPerformed(ActionEvent evt) {
	  int anz = 0;
	  int erfolge = 0;
	  Random ran = new Random();
      try {
    	  anz = Integer.parseInt(jLabelErgebnisVert.getText());  
      } catch (Exception e){
    	  System.out.println("Fehler2");
      }
      for (int i = 0; i < anz; ++i){
    	  int wurf = ran.nextInt(6)+1;
    	  System.out.println(wurf);
    	  if (wurf == 5 || wurf == 6){
    		  erfolge++;
    	  }
      }
      erfolgeVert = erfolge;
      eintragErgVert.setText("" + erfolgeVert);
      try {
  		if (Integer.parseInt(eintragErgAngr.getText()) > Integer.parseInt(eintragErgVert.getText())) {
  			treffer.setForeground(Color.green);
  			treffer.setText("Treffer!");
  		} else if (Integer.parseInt(eintragErgAngr.getText()) == Integer.parseInt(eintragErgVert.getText())){
  			treffer.setText("Streiftreffer!");
  		} else {
  			treffer.setForeground(Color.red);
  			treffer.setText("Kein Treffer!");
  		}
		} catch (Exception e){
			System.out.println("Fehler!");
		}
  } // end of jButton2_ActionPerformed
  
//Würfelt zufällig für den Verteidiger die Schadenswiderstandsprobe
 public void automWuerfeln2_ActionPerformed(ActionEvent evt) {
	  int anz = 0;
	  int erfolge = 0;
	  Random ran = new Random();
	  try {
		  anz = Integer.parseInt(jLabelAnzSchadenWid.getText());  
	  } catch (Exception e){
		  System.out.println("Fehler3");
	  }
	  for (int i = 0; i < anz; ++i){
		  int wurf = ran.nextInt(6)+1;
		  System.out.println(wurf);
		  if (wurf == 5 || wurf == 6){
			  erfolge++;
		  }
	  }
	  eintragErgSchadenWid.setText("" + erfolge);
	  try {
		  eintragSCodenachWuerfeln.setText("" + (Integer.parseInt(jLabelModSCode.getText()) - erfolge));
	  } catch (Exception e) {
		  System.out.println("Fehler42");
	  }
	  
 } // end of jButton2_ActionPerformed
 
 public void schadenAnwenden_ActionPerformed(ActionEvent evt) {
	 try {
		 int n = Integer.parseInt(eintragSCodenachWuerfeln.getText());
		 if (calcSchadensArt()){
			 verteidiger.setKZM(verteidiger.getKZM() - n);
		 } else {
			 verteidiger.setGZM(verteidiger.getGZM() - n);
		 }
		 jLabelKZMbatAnz2.setText("" + verteidiger.getKZM());
 		 jLabelGZMbatAnz2.setText("" + verteidiger.getGZM());
 		 jLabelKZMbatMali2.setText("" + ((verteidiger.getKZMAbs() - verteidiger.getKZM()) / 3));
 		 jLabelGZMbatMali2.setText("" + ((verteidiger.getGZMAbs() - verteidiger.getGZM()) / 3));
 		 schadenAnwenden.setEnabled(false);
	 } catch (Exception e){
		 // do nothing
	 }
	  
 } // end of jButton2_ActionPerformed
 
 public void zurueckSetzen_ActionPerformed(ActionEvent evt) {
	 eintragErgAngr.setText("");
	 eintragErgVert.setText("");
	 schadenscodeAngr.setText("Schadenscode");
	 eintragErgSchadenWid.setText("");
	 jTextFieldKampfart.setText("Kampffertigkeit");
	 jTextFieldAttribut.setText("Attribut");
	 jTextFieldModiAngr.setText("Modifikator");
	 jTextFieldLimitAngr.setText("Limit");
	 jTextFieldModiVert.setText("Modifikator");
	 try {
		 jTextFieldPanzCombat.setText("" + verteidiger.getPANZ());
	 } catch (Exception e){
		 // do nothing
	 }
	 jTextFieldDK.setText("DK");
	 jLabelModSCode.setText("");
	 jLabelNettoErf.setText("");
	 jLabelErgebnisAngr.setText("");
	 jLabelErgebnisVert.setText("");
	 //wuerfelAngr.setText("");
	 //wuerfelVert.setText("");
	 treffer.setText("");
	 schadensArt.setText("");
	 jLabelmodPanz.setText("");
	 eintragSCodenachWuerfeln.setText("");
	 //jLabelmodPanzAnz2.setText("");
	 wuerfelSchadenWid.setText("");
	 schadenAnwenden.setEnabled(true);
 } // end of jButton2_ActionPerformed
 
 public void update_ActionPerformed(ActionEvent evt) {
	 
	 try {
			jLabelErgebnisAngr.setText("" + (Integer.parseInt(jTextFieldKampfart.getText()) + Integer.parseInt(jTextFieldAttribut.getText()) + Integer.parseInt(jTextFieldModiAngr.getText())) + " [" + Integer.parseInt(jTextFieldLimitAngr.getText()) + "]");
		} catch (Exception e){
			System.out.println("Wohl keine Zahl eingegeben?");
		}
	 try {
			jLabelErgebnisVert.setText("" + (Integer.parseInt(jLabelReaVert.getText()) + Integer.parseInt(jLabelIntVert.getText()) + Integer.parseInt(jTextFieldModiVert.getText())));
		} catch (Exception e){
			System.out.println("Wohl keine Zahl eingegeben?");
		}
	 calcTreffer();
	 calcSchadensArt();
	 try {
		int nettoerf = (Integer.parseInt(eintragErgAngr.getText()) - Integer.parseInt(eintragErgVert.getText()));
		if (nettoerf > 0) jLabelNettoErf.setText("" + nettoerf);
		jLabelModSCode.setText("" + (Integer.parseInt(schadenscodeAngr.getText()) + nettoerf));
		calcSchadensArt();
		} catch (Exception e){
			System.out.println("Keine Zahl!");
		}
	 calcModPanz();
	 try {
		 	
		  	eintragSCodenachWuerfeln.setText("" + (Integer.parseInt(jLabelModSCode.getText()) - Integer.parseInt(eintragErgSchadenWid.getText())));
	  	} catch (Exception e) {
	  		System.out.println("Fehler42");
	  	}
 } // end of jButton2_ActionPerformed

} // end of class IAmTheFrame