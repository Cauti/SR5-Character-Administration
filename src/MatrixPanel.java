import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import gui.things.*;

public class MatrixPanel extends JPanel {

	private static JTextField txtZm;
	private static JTextField txtOw;
	private static JTextField txtFertigkeit;
	private static JTextField txtFertigkeit_1;
	private static JTextField txtLimit;
	private static JTextField txtWert;
	private static JTextField txtZm_1;
	private static JTextField Marken;
	private static JTextField txtAngriff;
	private static JTextField txtSchleicher;
	private static JTextField txtDatenv;
	private static JTextField txtFirewall;
	private static JTextField txtAttribut;
	private static JTextField txtFertigkeit_2;
	private static JTextField txtLimit_1;
	
	private static JPanel matrixPanel;
	private static JTextField txtAttribut_1;
	private static JTextField txtMod_1;
	private static JTextField txtMod;
	private static JComboBox<String> comboBox;
	private static JComboBox<String> comboBoxVert;
	private static JComboBox<String> comboBoxAktionen;
	
	private static String[] modi = {"AR", "VR (kalt)", "VR (heiß)"};
	private static String[] aktionen = {"Ausstöpseln", "Befehl vortäuschen", "Brute Force", "Datei cracken", "Datei editieren", "Datenbombe entschärfen", "Datenbombe legen",
			"Datenspike", "Eiliges Hacken", "Gerät formatieren", "Gerät neu starten", "Gerät steuern", "Gitterwechsel", "Host betreten/verlassen", "Icon aufspüren",
			"Icon verändern", "Interfacemodi wechseln", "In ein Gerät springen", "Marke einladen", "Marke löschen", "Matrixsignatur löschen", "Matrixsuche",
			"Matrixwahrnehmung", "Nachricht übermitteln", "Overwatch-Wert bestimmen", "Programm abstürzen lassen", "Signal stören", "Übertragung abfangen",
			"Verstecken", "Volle Matrixabwehr"
	};
	private static JTextArea txtrInfo;
	private static JPanel pInfo;
	private static JLabel picLabel;
	private static JButton btnOwErhoehen;
	
	// Erstellt das gesamte Panel und dessen Layout
	public static void buildGUI(JPanel mPanel) {
		matrixPanel = mPanel;
		matrixPanel.setLayout(new MigLayout("gapy 3%, gapx 2%, insets 2%", "[33%][33%][33%,grow]", "[50%][50%,grow]"));
		
		JPanel pAngr = new JPanel();
		matrixPanel.add(pAngr, "cell 0 0,grow");
		pAngr.setLayout(new MigLayout("gapy 4%, gapx 2%, insets 5%", "[33%,grow][33%,grow][33%,grow]", "[20%,fill][20%,fill][20%,fill][20%,grow,fill][20%,fill]"));
		
		JLabel lblAngreifer = new JLabel("Angreifer");
		pAngr.add(lblAngreifer, "cell 0 0,alignx center,growy");
		
		comboBox = new JComboBox<String>();
		pAngr.add(comboBox, "cell 1 0,growx");
		
		JComboBox<?> comboBoxInter = new JComboBox<Object>(modi);
		pAngr.add(comboBoxInter, "cell 2 0,grow");
		
		txtZm = new JTextField();
		txtZm.setText("ZM");
		pAngr.add(txtZm, "cell 0 1,grow");
		txtZm.setColumns(10);
		
		txtOw = new JTextField();
		txtOw.setText("OW");
		pAngr.add(txtOw, "cell 1 1,grow");
		txtOw.setColumns(10);
		
		btnOwErhoehen = new JButton("OW erhoehen");
		pAngr.add(btnOwErhoehen, "cell 2 1,grow");
		
		JLabel lblAktion = new JLabel("Aktion");
		pAngr.add(lblAktion, "cell 0 2,alignx center,growy");
		
		comboBoxAktionen = new JComboBox<String>(aktionen);
		pAngr.add(comboBoxAktionen, "cell 1 2 2 1,grow");
		
		JPanel panelAttAng = new JPanel();
		pAngr.add(panelAttAng, "cell 0 3 3 1,grow");
		panelAttAng.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		txtAttribut_1 = new JTextField();
		txtAttribut_1.setText("Attribut");
		panelAttAng.add(txtAttribut_1, "flowx,cell 0 0,grow");
		txtAttribut_1.setColumns(10);
		
		JLabel label = new JLabel("+");
		panelAttAng.add(label, "cell 0 0,grow");
		
		txtFertigkeit = new JTextField();
		txtFertigkeit.setText("Fertigkeit");
		panelAttAng.add(txtFertigkeit, "cell 0 0,grow");
		txtFertigkeit.setColumns(10);
		
		JLabel label_1 = new JLabel("+");
		panelAttAng.add(label_1, "cell 0 0,grow");
		
		txtMod_1 = new JTextField();
		txtMod_1.setText("Mod");
		panelAttAng.add(txtMod_1, "cell 0 0,grow");
		txtMod_1.setColumns(10);
		
		JLabel label_2 = new JLabel("[");
		panelAttAng.add(label_2, "cell 0 0,grow");
		
		txtLimit = new JTextField();
		txtLimit.setText("Limit");
		panelAttAng.add(txtLimit, "cell 0 0,grow");
		txtLimit.setColumns(10);
		
		JLabel label_6 = new JLabel("]");
		panelAttAng.add(label_6, "cell 0 0,grow");
		
		JButton btnBerechnen = new JButton("Berechnen");
		pAngr.add(btnBerechnen, "cell 0 4,grow");
		
		txtWert = new JTextField();
		txtWert.setText("Wert");
		pAngr.add(txtWert, "cell 1 4,grow");
		txtWert.setColumns(10);
		
		JButton btnAnwenden = new JButton("Anwenden");
		pAngr.add(btnAnwenden, "cell 2 4,grow");
		
		
		// ------------------------------------------------------->
		JPanel pVert = new JPanel();
		matrixPanel.add(pVert, "cell 1 0,grow");
		pVert.setLayout(new MigLayout("gapy 4%, gapx 2%, insets 5%", "[50%,grow][50%,grow]", "[20%,grow][22%,grow][14%,grow][22%,grow][14%,grow][22%,grow]"));
		
		JLabel lblVerteidiger = new JLabel("Verteidiger");
		pVert.add(lblVerteidiger, "cell 0 0,alignx center,growy");
		
		comboBoxVert = new JComboBox<String>();
		pVert.add(comboBoxVert, "cell 1 0,grow");
		
		txtZm_1 = new JTextField();
		txtZm_1.setText("ZM");
		pVert.add(txtZm_1, "flowx,cell 0 1,grow");
		txtZm_1.setColumns(10);
		
		Marken = new JTextField();
		Marken.setText("Marken");
		pVert.add(Marken, "cell 1 1,grow");
		Marken.setColumns(10);
		
		JLabel lblAttribute = new JLabel("Attribute");
		pVert.add(lblAttribute, "cell 0 2 2 1,alignx center,growy");
		
		txtAngriff = new JTextField();
		txtAngriff.setText("Angriff");
		pVert.add(txtAngriff, "flowx,cell 0 3,grow");
		txtAngriff.setColumns(10);
		
		txtSchleicher = new JTextField();
		txtSchleicher.setText("Schleicher");
		pVert.add(txtSchleicher, "cell 0 3,grow");
		txtSchleicher.setColumns(10);
		
		txtDatenv = new JTextField();
		txtDatenv.setText("Datenv.");
		pVert.add(txtDatenv, "flowx,cell 1 3,grow");
		txtDatenv.setColumns(10);
		
		txtFirewall = new JTextField();
		txtFirewall.setText("Firewall");
		pVert.add(txtFirewall, "cell 1 3,grow");
		txtFirewall.setColumns(10);
		
		JLabel lblVerteidigung = new JLabel("Verteidigung");
		pVert.add(lblVerteidigung, "cell 0 4 2 1,alignx center,growy");
		
		
		// ------------------------------------------------------>
		// Panel ganz rechts
		
		JPanel panelAttVert = new JPanel();
		pVert.add(panelAttVert, "cell 0 5 2 1,grow");
		panelAttVert.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		txtAttribut = new JTextField();
		txtAttribut.setText("Attribut");
		panelAttVert.add(txtAttribut, "flowx,cell 0 0,grow");
		txtAttribut.setColumns(10);
		
		JLabel label_3 = new JLabel("+");
		panelAttVert.add(label_3, "cell 0 0,grow");
		
		txtFertigkeit_2 = new JTextField();
		txtFertigkeit_2.setText("Fertigkeit");
		panelAttVert.add(txtFertigkeit_2, "cell 0 0,grow");
		txtFertigkeit_2.setColumns(10);
		
		JLabel labelpm = new JLabel("+");
		panelAttVert.add(labelpm, "cell 0 0,grow");
		
		txtMod = new JTextField();
		txtMod.setText("Mod");
		panelAttVert.add(txtMod, "cell 0 0,grow");
		txtMod.setColumns(10);
		
		JLabel label_4 = new JLabel("[");
		panelAttVert.add(label_4, "cell 0 0,grow");
		
		txtLimit_1 = new JTextField();
		txtLimit_1.setText("Limit");
		panelAttVert.add(txtLimit_1, "cell 0 0,grow");
		txtLimit_1.setColumns(10);
		
		JLabel label_5 = new JLabel("]");
		panelAttVert.add(label_5, "cell 0 0,grow");
		
		pInfo = new JPanel();
		matrixPanel.add(pInfo, "cell 2 0,grow");
		pInfo.setLayout(new MigLayout("", "[100%,grow]", "[100%,grow]"));
		
		txtrInfo = new JTextArea();
		txtrInfo.setText("Info");
		pInfo.add(txtrInfo, "flowy,cell 0 0,grow");
		
		JList<?> list_2 = new JList<Object>();
		pInfo.add(list_2, "cell 0 0");
		
		
		// ------------------------------------------------------------->
		
		JPanel pSpritesAng = new JPanel();
		matrixPanel.add(pSpritesAng, "cell 0 1,grow");
		pSpritesAng.setLayout(new MigLayout("gapy 4%, gapx 2%, insets 5%", "[33%,grow][33%,grow][33%,grow]", "[20%,grow][80%,grow]"));
		
		JLabel lblKfOderSprite = new JLabel("KF oder Sprite");
		pSpritesAng.add(lblKfOderSprite, "cell 0 0,alignx center,growy");
		
		JComboBox<?> comboBoxSpriteAng = new JComboBox<Object>();
		pSpritesAng.add(comboBoxSpriteAng, "cell 1 0,grow");
		
		JButton btnHinzufuegenAng = new JButton("hinzufügen");
		pSpritesAng.add(btnHinzufuegenAng, "cell 2 0,grow");
		
		JList<?> listAng = new JList<Object>();
		pSpritesAng.add(listAng, "cell 0 1 2 1,grow");
		
		JPanel buttonArrayAng = new JPanel();
		pSpritesAng.add(buttonArrayAng, "cell 2 1,grow");
		buttonArrayAng.setLayout(new MigLayout("insets 3%, gapy 4%", "[100%,grow]", "[15%][15%]"));
		
		JButton btnStartenAng = new JButton("Starten");
		buttonArrayAng.add(btnStartenAng, "cell 0 0,grow");
		
		JButton btnAnwendenAng = new JButton("Anwenden");
		buttonArrayAng.add(btnAnwendenAng, "cell 0 1,grow");
		
		
		// ------------------------------------------------>
		
		JPanel pSpritesVert = new JPanel();
		matrixPanel.add(pSpritesVert, "cell 1 1,grow");
		pSpritesVert.setLayout(new MigLayout("gapy 4%, gapx 2%, insets 5%", "[33%,grow][33%,grow][33%,grow]", "[20%,grow][80%,grow]"));
		
		JLabel lblSpritesVert = new JLabel("KF oder Sprite");
		pSpritesVert.add(lblSpritesVert, "cell 0 0,grow");
		
		JComboBox<?> comboBoxSpriteVert = new JComboBox<Object>();
		pSpritesVert.add(comboBoxSpriteVert, "cell 1 0,grow");
		
		JButton btnHinzufuegenVert = new JButton("hinzufügen");
		pSpritesVert.add(btnHinzufuegenVert, "cell 2 0,grow");
		
		JList<?> listVert = new JList<Object>();
		pSpritesVert.add(listVert, "cell 0 1 2 1,grow");
		
		JPanel buttonArrayVert = new JPanel();
		pSpritesVert.add(buttonArrayVert, "cell 2 1,grow");
		buttonArrayVert.setLayout(new MigLayout("insets 3%, gapy 4%", "[100%,grow]", "[15%][15%]"));
		
		JButton btnStartenVert = new JButton("Starten");
		buttonArrayVert.add(btnStartenVert, "cell 0 0, grow");
		
		JButton btnAnwendenVert = new JButton("Anwenden");
		buttonArrayVert.add(btnAnwendenVert, "cell 0 1, grow");
		
		JList<?> ListAktionen = new JList<Object>();
		matrixPanel.add(ListAktionen, "cell 2 1,grow");
		
		// Ruft den logischen Aufbau des Panels auf
		setUp();
	}
	
	private static void oWErhoehen() {
		Random r = new Random();
		int z1 = r.nextInt(6)+1;
		int z2 = r.nextInt(6)+1;
		int ow = Integer.parseInt(txtOw.getText()) + z1 + z2;
		txtOw.setText("" + ow);
		InitiativePanel.writeProto("OW von " + comboBox.getSelectedItem() + " um " + (z1+z2) + " auf " + ow + " erhöht.");
		if (ow >= 40) {
			JOptionPane.showMessageDialog(matrixPanel, "Fokusierung!");
		}
	}
	
	private static void setUp() {
		txtOw.setText("0");
		Marken.setText("0");
		
		btnOwErhoehen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				oWErhoehen();
			}
		});
		
		// ItemListener, um die Werte für den Angreifer anzupassen
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				Chara chara = IAmTheFrame.searchCharaByName((String) comboBox.getSelectedItem());
				if (chara.getClass().equals(Techno.class)) {
					Techno c = (Techno) chara;
					txtZm.setText("" + c.getMzm());
				} else {
					txtZm.setText("ZM");
				}
			}
		});	
		comboBoxVert.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				Chara chara = IAmTheFrame.searchCharaByName((String) comboBoxVert.getSelectedItem());
				if (chara.getClass().equals(Techno.class)) {
					Techno c = (Techno) chara;
					txtZm_1.setText("" + c.getMzm());
					txtAngriff.setText("" + c.getAngriff());
					txtSchleicher.setText("" + c.getSchleicher());
					txtDatenv.setText("" + c.getDv());
					txtFirewall.setText("" + c.getFirewall());
				} else {
					txtZm_1.setText("ZM");
				}
			}
		});
		comboBoxAktionen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				BufferedImage image;
				JLabel picLabel = new JLabel();
				JPanel localPanel = new JPanel(new GridLayout(0, 1));
							    
				int w = pInfo.getWidth();
				//int h = pInfo.getHeight();
				int sel = comboBoxAktionen.getSelectedIndex();
				pInfo.removeAll();
				switch (sel) {
				case 0: 
					try {
						System.out.println("ght");
						image = ImageIO.read(getClass().getResourceAsStream("/Matrix/ausstoepseln.jpg"));
						int width = image.getWidth();
						int height = image.getHeight();
						double per = width/w;
						
						//BufferedImage after = Scalr.resize(image, Scalr.Method.BALANCED, w, (int) (height/per));
						//Image i = imageIcon.getImage(); // transform it
						
						//Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
						
						//StretchIcon si = new StretchIcon(newimg);  //
						//picLabel = new JLabel(new ImageIcon(after));
						//picLabel = new JLabel(new ImageIcon(image));
						//localPanel.add(picLabel);
						//picLabel = new JLabel(new StretchIcon(image));
						//picLabel.setPrefferedSize(0, 0, pInfo.getWidth(), pInfo.getHeight());
						
						picLabel.setIcon(new ImageIcon(image));
						
						//localPanel.add(picLabel);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} break;
				case 1:
					try {
						image = ImageIO.read(getClass().getResourceAsStream("/Matrix/befehl.jpg"));
						picLabel = new JLabel(new ImageIcon(image));
					} catch (IOException e1) {
						e1.printStackTrace();
					} break;
				case 2:
					try {
						image = ImageIO.read(getClass().getResourceAsStream("/Matrix/bruteforce.jpg"));
						picLabel = new JLabel(new ImageIcon(image));
					} catch (IOException e1) {
						e1.printStackTrace();
					} break;
				case 3:
					try {
						image = ImageIO.read(getClass().getResourceAsStream("/Matrix/cracken.jpg"));
						picLabel = new JLabel(new ImageIcon(image));
					} catch (IOException e1) {
						e1.printStackTrace();
					} break;
				case 4:
					try {
						image = ImageIO.read(getClass().getResourceAsStream("/Matrix/editieren.jpg"));
						picLabel = new JLabel(new ImageIcon(image));
					} catch (IOException e1) {
						e1.printStackTrace();
					} break;
				case 5:
					try {
						image = ImageIO.read(getClass().getResourceAsStream("/Matrix/datenbombeent.jpg"));
						picLabel = new JLabel(new ImageIcon(image));
					} catch (IOException e1) {
						e1.printStackTrace();
					} break;	
				}
				
				JScrollPane scrollP = new JScrollPane (picLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			    //ScrollablePanel scrollP = new ScrollablePanel(new MigLayout("", "[100%,grow]", "100%,grow"));
			    scrollP.setPreferredSize(new Dimension(pInfo.getWidth(), pInfo.getHeight()));
			    scrollP.add(picLabel);
			    pInfo.add(scrollP);
			    //scrollP.setBounds(0, 0, pInfo.getWidth(), pInfo.getHeight());
			    //scrollP.add(localPanel);
			    //localPanel.add(picLabel);
			    
				scrollP.setBorder(new TitledBorder ( new EtchedBorder (), "Info" ));
			    //pInfo.add(scrollP);
			   
			    matrixPanel.repaint();
			    
			}
		});
	}
	
	// Lässt ein Element zur TeilnehmerBox hinzufügen
	public static void addComboBoxes(String name){
		comboBox.addItem(name);
		comboBoxVert.addItem(name);
	}
}