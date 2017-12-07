import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
	  private static JTextField jTextFieldName = new JTextField();
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

	public static void setUpValuePanel(JPanel vPanel){
		valuePanel = vPanel;
		frameWidth = IAmTheFrame.getFrameWidth();
		frameHeight = IAmTheFrame.getFrameHeight();
		compHeight = (int) (frameHeight*0.06);
		gapSpaceV = (int) (frameHeight*0.01);
		
		jLabelKON.setBounds(32, 20, 166, compHeight);
	    jLabelKON.setText("Konstitution");
	    valuePanel.add(jLabelKON);
	    jLabelGES.setBounds(32, jLabelKON.getY() + jLabelKON.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelGES.setText("Geschicklichkeit");
	    valuePanel.add(jLabelGES);
	    jLabelREA.setBounds(32, jLabelGES.getY() + jLabelGES.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelREA.setText("Reaktion");
	    valuePanel.add(jLabelREA);
	    jLabelSTA.setBounds(32, jLabelREA.getY() + jLabelREA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelSTA.setText("Stärke");
	    valuePanel.add(jLabelSTA);
	    jLabelWIL.setBounds(32, jLabelSTA.getY() + jLabelSTA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelWIL.setText("Willenskraft");
	    valuePanel.add(jLabelWIL);
	    jLabelLOG.setBounds(32, jLabelWIL.getY() + jLabelWIL.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelLOG.setText("Logik");
	    valuePanel.add(jLabelLOG);
	    jLabelINT.setBounds(32, jLabelLOG.getY() + jLabelLOG.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelINT.setText("Intuition");
	    valuePanel.add(jLabelINT);  
	    jLabelCHA.setBounds(32, jLabelINT.getY() + jLabelINT.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelCHA.setText("Charme");
	    valuePanel.add(jLabelCHA);
	    jLabelEDG.setBounds(32, jLabelCHA.getY() + jLabelCHA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelEDG.setText("Edge");
	    valuePanel.add(jLabelEDG);
	    jLabelESS.setBounds(32, jLabelEDG.getY() + jLabelEDG.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelESS.setText("Essenz");
	    valuePanel.add(jLabelESS);
	    jLabelMAG.setBounds(32, jLabelESS.getY() + jLabelESS.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelMAG.setText("Magie/Resonanz");
	    valuePanel.add(jLabelMAG);
	    
	    jTextFieldKON.setBounds(216, 20, 150, compHeight);
	    valuePanel.add(jTextFieldKON);
	    jTextFieldGES.setBounds(216, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldGES);
	    jTextFieldREA.setBounds(216, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldREA);
	    jTextFieldSTA.setBounds(216, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldSTA);
	    jTextFieldWIL.setBounds(216, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldWIL);
	    jTextFieldLOG.setBounds(216, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldLOG);
	    jTextFieldINT.setBounds(216, jTextFieldLOG.getY() + jTextFieldLOG.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldINT);
	    jTextFieldCHA.setBounds(216, jTextFieldINT.getY() + jTextFieldINT.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldCHA);
	    jTextFieldEDG.setBounds(216, jTextFieldCHA.getY() + jTextFieldCHA.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldEDG);
	    jTextFieldESS.setBounds(216, jTextFieldEDG.getY() + jTextFieldEDG.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldESS);
	    jTextFieldMAG.setBounds(216, jTextFieldESS.getY() + jTextFieldESS.getHeight() + gapSpaceV, 150, compHeight);
	    valuePanel.add(jTextFieldMAG);
	    
	    jLabelMETA.setBounds(400, jLabelKON.getY(), 166, compHeight);
	    jLabelMETA.setText("Metatyp");
	    valuePanel.add(jLabelMETA);
	    jLabelINI.setBounds(400, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelINI.setText("Initiative");
	    valuePanel.add(jLabelINI);
	    jLabelINA.setBounds(400, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelINA.setText("Astrale Initiative");
	    valuePanel.add(jLabelINA);
	    jLabelINKS.setBounds(400, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelINKS.setText("Initiative mit KS");
	    valuePanel.add(jLabelINKS);
	    jLabelINHS.setBounds(400, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelINHS.setText("Initiative mit HS");
	    valuePanel.add(jLabelINHS);
	    jLabelKZM.setBounds(400, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelKZM.setText("Körperlicher ZuMon");
	    valuePanel.add(jLabelKZM);
	    jLabelGZM.setBounds(400, jTextFieldLOG.getY() + jTextFieldLOG.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelGZM.setText("Geistiger ZuMon");
	    valuePanel.add(jLabelGZM);
	    jLabelPanz.setBounds(400, jTextFieldINT.getY() + jTextFieldINT.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelPanz.setText("Panzerungswert");
	    valuePanel.add(jLabelPanz);
	    jLabelNAME.setBounds(400, jTextFieldCHA.getY() + jTextFieldCHA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelNAME.setText("Name");
	    valuePanel.add(jLabelNAME);
	    
	    jComboBox1 = new JComboBox<String>(metatypes);
	    jComboBox1.setSelectedItem("Mensch");
	    jComboBox1.setBounds(584, jLabelKON.getY(), 166, compHeight);
	    valuePanel.add(jComboBox1);
	    jTextFieldINI.setBounds(584, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldINI);
	    jTextFieldINA.setBounds(584, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldINA);
	    jTextFieldINKS.setBounds(584, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldINKS);
	    jTextFieldINHS.setBounds(584, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldINHS);
	    jTextFieldKZM.setBounds(584, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldKZM);
	    jTextFieldGZM.setBounds(584, jTextFieldLOG.getY() + jTextFieldLOG.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldGZM);
	    jTextFieldPanz.setBounds(584, jTextFieldINT.getY() + jTextFieldINT.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldPanz);
	    jTextFieldNAME.setBounds(584, jTextFieldCHA.getY() + jTextFieldCHA.getHeight() + gapSpaceV, 166, compHeight);
	    valuePanel.add(jTextFieldNAME);
	    
	    // Labels f�r Limits setzen
	    jLabelKLIM.setBounds(800, jLabelKON.getY(), 166, compHeight);
	    jLabelKLIM.setText("Körperliches Limit");
	    valuePanel.add(jLabelKLIM);
	    jLabelGLIM.setBounds(800, jTextFieldGES.getY() + jTextFieldGES.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelGLIM.setText("Geistiges Limit");
	    valuePanel.add(jLabelGLIM);
	    jLabelSLIM.setBounds(800, jTextFieldSTA.getY() + jTextFieldSTA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelSLIM.setText("Soziales Limit");
	    valuePanel.add(jLabelSLIM);
	    
	    jLabelKLIMAnz.setBounds(820, jTextFieldKON.getY() + jTextFieldKON.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelKLIMAnz.setText("");
	    valuePanel.add(jLabelKLIMAnz);
	    jLabelGLIMAnz.setBounds(820, jTextFieldREA.getY() + jTextFieldREA.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelGLIMAnz.setText("");
	    valuePanel.add(jLabelGLIMAnz);
	    jLabelSLIMAnz.setBounds(820, jTextFieldWIL.getY() + jTextFieldWIL.getHeight() + gapSpaceV, 166, compHeight);
	    jLabelSLIMAnz.setText("");
	    valuePanel.add(jLabelSLIMAnz);
	    
	    // Buttons setzen
	    jButton1.setBounds(208, jTextFieldMAG.getY() + jTextFieldMAG.getHeight() + 3*gapSpaceV, 203, compHeight);
	    jButton1.setText("Zuweisen");
	    jButton1.setMargin(new Insets(2, 2, 2, 2));
	    jButton1.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton1_ActionPerformed(evt);
	      }
	    });
	    valuePanel.add(jButton1);
	    jButton2.setBounds(432, jTextFieldMAG.getY() + jTextFieldMAG.getHeight() + 3*gapSpaceV, 203, compHeight);
	    jButton2.setText("Löschen");
	    jButton2.setMargin(new Insets(2, 2, 2, 2));
	    jButton2.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton2_ActionPerformed(evt);
	      }
	    });
	    valuePanel.add(jButton2);
	    jButton3.setBounds(656, jTextFieldMAG.getY() + jTextFieldMAG.getHeight() + 3*gapSpaceV, 203, compHeight);
	    jButton3.setText("Speichern");
	    jButton3.setMargin(new Insets(2, 2, 2, 2));
	    jButton3.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton3_ActionPerformed(evt);
	      }
	    });
	    valuePanel.add(jButton3);
	    
	    IAmTheFrame.getAllCharas().setModel(jList1Model);
	    jList1ScrollPane.setBounds(1000, jLabelKON.getY(), frameWidth-1050, jLabelMAG.getY()+jLabelMAG.getHeight()-jLabelKON.getY());
	    valuePanel.add(jList1ScrollPane);
	    
	    try {
	    	allcharas.setFont(new Font("Neuropol X Free",Font.BOLD,18));
	    } catch (Exception e){
	    	allcharas.setFont(new Font("Arial",Font.BOLD,18));
	    }
	    
	    allcharas.addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged( ListSelectionEvent e ) {
	        	if (!e.getValueIsAdjusting()){
	          //akt = e.getFirstIndex();
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
	        		} catch (java.lang.NullPointerException ex){
	        			ex.printStackTrace();
	        		}
	        	}
	        }
	      } );
	}
	
	// Setzen-Button! Neuer Chara wird angelegt und der Liste hinzugefügt!
	  public static void jButton1_ActionPerformed(ActionEvent evt) {
	    
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
	    
		  Chara tmp = IAmTheFrame.searchCharaByName(name);

		  if (tmp != null){
			  System.out.println(tmp.toString());
			  tmp.updateValues(kon, ges, rea, sta, wil, log, intu, cha, edg, ess, mag, ini, ina, inks, inhs, kzm, gzm, panz, meta);
		  } else {
			  try {
				  Chara chara = new Chara(kon,ges,rea,sta,wil,log,intu,cha,edg,ess,mag,ini,ina,inks,inhs,kzm,gzm,panz,name,meta);  
				  charas.add(chara);
				  IAmTheFrame.addToAllCharas(name);
				  CombatPanel.addComboBoxes(name);
				  InitiativePanel.setComboBoxCharas(name);
			  } catch (Exception e){
				  System.out.println("Falsche Eingabewerte");
			  }
		  }
	    // Danger: Momentan der 0. Character in der Liste!
	    //jTextFieldKLIM.setText("" + charas.get(0).getKLIM());
	    //jTextFieldGLIM.setText("" + charas.get(0).getGLIM());
	    //jTextFieldSLIM.setText("" + charas.get(0).getSLIM());
	    
	    //jTextFieldKLIM.setText("" + Math.ceil((Integer.parseInt(jTextFieldSTA.getText())*2 + Integer.parseInt(jTextFieldKON.getText()) + Integer.parseInt(jTextFieldREA.getText()))/3));
	  } // end of jButton1_ActionPerformed
	  
	 
	  // Löschen eines Charakters
	  public static void jButton2_ActionPerformed(ActionEvent evt) {
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
	  public static void jButton3_ActionPerformed(ActionEvent evt) {
	      // TODO hier Quelltext einfügen
//		  String kon = (jTextFieldKON.getText().equals("")) ? " " : jTextFieldKON.getText();
//		  String ges = (jTextFieldGES.getText().equals("")) ? " " : jTextFieldGES.getText();
//		  String rea = (jTextFieldREA.getText().equals("")) ? " " : jTextFieldREA.getText();
//		  String sta = (jTextFieldSTA.getText().equals("")) ? " " : jTextFieldSTA.getText();
//		  String wil = (jTextFieldWIL.getText().equals("")) ? " " : jTextFieldWIL.getText();
//		  String log = (jTextFieldLOG.getText().equals("")) ? " " : jTextFieldLOG.getText();
//		  String intu = (jTextFieldINT.getText().equals("")) ? " " : jTextFieldINT.getText();
//		  String cha = (jTextFieldCHA.getText().equals("")) ? " " : jTextFieldCHA.getText();
//		  String edg = (jTextFieldEDG.getText().equals("")) ? " " : jTextFieldEDG.getText();
//		  String ess = (jTextFieldESS.getText().equals("")) ? " " : jTextFieldESS.getText();
//		  String mag = (jTextFieldMAG.getText().equals("")) ? " " : jTextFieldMAG.getText();
//		  String ini = (jTextFieldINI.getText().equals("")) ? " " : jTextFieldINI.getText();
//		  String ina = (jTextFieldINA.getText().equals("")) ? " " : jTextFieldINA.getText();
//		  String inks = (jTextFieldINKS.getText().equals("")) ? " " : jTextFieldINKS.getText();
//		  String inhs = (jTextFieldINHS.getText().equals("")) ? " " : jTextFieldINHS.getText();
//		  String kzm = (jTextFieldKZM.getText().equals("")) ? " " : jTextFieldKZM.getText();
//		  String gzm = (jTextFieldGZM.getText().equals("")) ? " " : jTextFieldGZM.getText();
//		  String panz = (jTextFieldPanz.getText().equals("")) ? " " : jTextFieldPanz.getText();
//		  String name = (jTextFieldNAME.getText().equals("")) ? " " : jTextFieldNAME.getText();
//		  String meta = (String) jComboBox1.getSelectedItem();
//		  //String[] values = {jTextFieldKON.getText(), jTextFieldGES.getText(), jTextFieldREA.getText(),jTextFieldSTA.getText(),jTextFieldWIL.getText(), jTextFieldLOG.getText(), jTextFieldINT.getText(), jTextFieldCHA.getText(), jTextFieldEDG.getText(), jTextFieldESS.getText(), jTextFieldMAG.getText(), jTextFieldINI.getText(), jTextFieldINA.getText(), jTextFieldINKS.getText(), jTextFieldINHS.getText(), jTextFieldKZM.getText(), jTextFieldGZM.getText(), jTextFieldPanz.getText(), jTextFieldName.getText(), (String) jComboBox1.getSelectedItem()};
//		  //XMLFileModifier.append(values);
//		  String[] values = {kon,ges,rea,sta,wil,log,intu,cha,edg,ess,mag,ini,ina,inks,inhs,kzm,gzm,panz,name,meta};
//		  for (int i = 0; i < values.length; ++i){
//			  System.out.println(values[i]);
//		  }
		  //String[] valuestest = {jTextFieldKON.getText(), jTextFieldGES.getText(), jTextFieldREA.getText(),jTextFieldSTA.getText()};
		  
		  //ReadXMLFile.saveToXML(charas);
		  //XMLFileModifier.append(charas);
		  
		  jButton1_ActionPerformed(null);
		  XMLInterface.saveToXML(charas);
		
	  } // end of jButton2_ActionPerformed
	
}
