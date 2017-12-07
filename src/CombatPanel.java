import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CombatPanel {

	private static JPanel battlePanel;
	private static int frameWidth, frameHeight, gapSpaceV, compHeight, arrayWidth;
	private static Chara verteidiger;
	private static int erfolgeVert = -1;

	private static boolean isTabbed1 = false, isTabbed2 = false,
			isTabbed3 = false, isTabbed4 = false, isTabbed5 = false,
			isTabbed6 = false, isTabbed7 = false, isTabbed8 = false;
	private static JComboBox<String> jComboBoxAngreifer = new JComboBox<String>();
	private static JComboBox<String> jComboBoxVerteidiger = new JComboBox<String>(), jComboBoxUHandlungen;
	private static JLabel jLabelAng = new JLabel();
	private static JLabel jLabelVert = new JLabel();
	private static JLabel jLabelKZMbat = new JLabel();
	private static JLabel jLabelGZMbat = new JLabel();
	private static JLabel jLabelKZMbatAnz = new JLabel();
	private static JLabel jLabelGZMbatAnz = new JLabel();
	private static JLabel jLabelKZMbatMali = new JLabel();
	private static JLabel jLabelGZMbatMali = new JLabel();
	private static JLabel jLabelKZMbat2 = new JLabel();
	private static JLabel jLabelGZMbat2 = new JLabel();
	private static JLabel jLabelKZMbatAnz2 = new JLabel();
	private static JLabel jLabelGZMbatAnz2 = new JLabel();
	private static JLabel jLabelKZMbatMali2 = new JLabel();
	private static JLabel jLabelGZMbatMali2 = new JLabel();
	private static JLabel jLabelErgebnisAngr = new JLabel(),
			jLabelErgebnisVert = new JLabel(), jLabelReaVert = new JLabel(),
			jLabelIntVert = new JLabel();
	private static JLabel jLabelNAME = new JLabel(),
			jLabelNettoErf = new JLabel(), jLabelPanzCombat = new JLabel();
	private static JLabel equal = new JLabel(), equal2 = new JLabel(),
			equal3 = new JLabel(), equal4 = new JLabel(), minus = new JLabel(),
			equal5 = new JLabel();
	private static JLabel plus = new JLabel(), plus2 = new JLabel(),
			plus3 = new JLabel(), plus4 = new JLabel(),
			plusminus = new JLabel(), plusminus2 = new JLabel(),
			bracketLeft = new JLabel(), bracketRight = new JLabel();
	private static JLabel wuerfelAngr = new JLabel(),
			wuerfelVert = new JLabel(), treffer = new JLabel(),
			schadensArt = new JLabel(), jLabelModSCode = new JLabel(),
			jLabelNettoErfText = new JLabel(),
			jLabelModSCodeText = new JLabel();
	private static JLabel jLabelmodPanz = new JLabel(),
			jLabelmodPanzText = new JLabel(),
			jLabelschadenWiderstandText = new JLabel(),
			jLabelKonCombat = new JLabel(), jLabelmodPanzAnz = new JLabel();
	private static JLabel jLabelKonCombatAnz = new JLabel(),
			jLabelmodPanzAnz2 = new JLabel(),
			jLabelAnzSchadenWid = new JLabel(),
			wuerfelSchadenWid = new JLabel();
	private static JLabel jLabelSCodenachWuerfeln = new JLabel();
	private static JLabel eintragSCodenachWuerfeln = new JLabel();
	private static JTextField eintragErgAngr = new JTextField(),
			eintragErgVert = new JTextField(),
			schadenscodeAngr = new JTextField(),
			eintragErgSchadenWid = new JTextField();
	private static JTextField jTextFieldINA = new JTextField();
	private static JTextField jTextFieldINKS = new JTextField();
	private static JTextField jTextFieldINHS = new JTextField();
	private static JTextField jTextFieldKZM = new JTextField();
	private static JTextField jTextFieldINI = new JTextField();
	private static JTextField jTextFieldGZM = new JTextField();
	private static JTextField jTextFieldKampfart = new JTextField();
	private static JTextField jTextFieldAttribut = new JTextField();
	private static JTextField jTextFieldModiAngr = new JTextField();
	private static JTextField jTextFieldLimitAngr = new JTextField();
	private static JTextField jTextFieldModiVert = new JTextField(),
			jTextFieldPanzCombat = new JTextField(),
			jTextFieldDK = new JTextField();
	private static JTextField jTextFieldPanz = new JTextField();
	private static JTextField jTextFieldNAME = new JTextField();
	private static JButton jButton2 = new JButton(),
			automWuerfeln = new JButton(), automWuerfeln2 = new JButton(),
			schadenAnwenden = new JButton(), zurueckSetzen = new JButton();
	private static JButton update = new JButton(), angriffWuerfeln = new JButton();
	private static JTable kZuMon, gZuMon, kZuMon2, gZuMon2;
    private static String[] tableNames = {"Akt. ZM", "Mali"};
    private static DefaultTableModel modelKZM, modelGZM, modelKZM2, modelGZM2;
    private static JTextArea jTextAreaProtokoll = new JTextArea();
    private static JScrollPane scrollProto = new JScrollPane();
    private static String[] uhandlungen = {"Normal", "Ausweichen", "Blocken", "Parieren", "Volle Abwehr", "Volle Deckung"};

	public static void setUpCombatPanel(JPanel cPanel) {
		battlePanel = cPanel;
		
			
		battlePanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        JComponent clicked = (JComponent)e.getSource();
		        clicked.requestFocusInWindow();
		    }
		});
		
		frameWidth = IAmTheFrame.getFrameWidth();
		double perw = frameWidth*0.01;
		arrayWidth = (2*frameWidth)/36-10;
		frameHeight = IAmTheFrame.getFrameHeight();
		double perh = frameHeight*0.01;
		compHeight = (int) (frameHeight*0.06);
		gapSpaceV = (int) (frameHeight*0.01);
			
		
		int x = (int) (8*perw);
		int w = (int) (16*perw);
		int y = (int) (8*perh);
		//System.out.println(x + " " + w);
		jLabelAng.setBounds(x, 30, w, compHeight);
		jLabelAng.setFont(jLabelAng.getFont().deriveFont(18f));
		jLabelAng.setText("Angreifer");
		jLabelAng.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelAng);
		
		jComboBoxAngreifer.setBounds(x, y, w, compHeight);
		battlePanel.add(jComboBoxAngreifer);
		
		
		// Einschub: ComboBox für UHandlungen
		x = (int) (74*perw);
		jComboBoxUHandlungen = new JComboBox<String>(uhandlungen);
		jComboBoxUHandlungen.setBounds(x, y, w, compHeight);
		jComboBoxUHandlungen.addFocusListener(new java.awt.event.FocusAdapter() {
//			public void focusGained(java.awt.event.FocusEvent evt) {}

			public void focusLost(java.awt.event.FocusEvent evt) {
				// Labels anpassen!
				
				// ---------------------------------------------------------->
			}
		});
		battlePanel.add(jComboBoxUHandlungen);

		// zurück
	    modelKZM = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return tableNames.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return tableNames[index]; 
            } 
        };
	    kZuMon = new JTable(modelKZM);
	    
	    x = (int) (4*perw);
	    y = (int) (16*perh);
	    w = (int) (8*perw);
	    JScrollPane sKZM = new JScrollPane (kZuMon, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sKZM.setBounds(x, y, w, (int) compHeight);
	    sKZM.setBorder(new TitledBorder ( new EtchedBorder (), "Körperlicher ZM:" ));
	    battlePanel.add(sKZM);
	    
	    modelGZM = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return tableNames.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return tableNames[index]; 
            } 
        };
	    
	    gZuMon = new JTable(modelGZM);
	    x = (int) (20*perw);
	    JScrollPane sGZM = new JScrollPane (gZuMon, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sGZM.setBounds(x, y, w, (int) compHeight);
	    sGZM.setBorder(new TitledBorder ( new EtchedBorder (), "Geistiger ZM:" ));
	    battlePanel.add(sGZM);
	    
	    x = (int) (2*perw);
	    y = (int) (24*perh);
	    w = (int) (6*perw);
		jTextFieldKampfart.setBounds(x, y, w, compHeight);
		jTextFieldKampfart.setText("Kampffertigkeit");
		jTextFieldKampfart.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldKampfart);
		
		x = (int) (jTextFieldKampfart.getX() + jTextFieldKampfart.getWidth());
		w = (int) (perw);
		plus.setBounds(x, y, w, compHeight);
		plus.setText("+");
		plus.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(plus);
		
		x = (int) (jTextFieldKampfart.getX() + jTextFieldKampfart.getWidth() + perw);
		y = (int) (24*perh);
	    w = (int) (6*perw);
		jTextFieldAttribut.setBounds(x, y , w, compHeight);
		jTextFieldAttribut.setText("Attribut");
		jTextFieldAttribut.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldAttribut);
		
		x = (int) (jTextFieldAttribut.getX() + jTextFieldAttribut.getWidth());
		w = (int) (perw);
		plusminus.setBounds(x, y, w, compHeight);
		plusminus.setText("\u00B1");
		plusminus.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(plusminus);
		
		x = (int) (jTextFieldAttribut.getX() + jTextFieldAttribut.getWidth() + perw);
		y = (int) (24*perh);
	    w = (int) (6*perw);
		jTextFieldModiAngr.setBounds(x, y, w, compHeight);
		jTextFieldModiAngr.setText("Modifikator (" + 0 + ")");
		jTextFieldModiAngr.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldModiAngr);
		
		x = (int) (jTextFieldModiAngr.getX() + jTextFieldModiAngr.getWidth());
		w = (int) (perw);
		bracketLeft.setBounds(x, y, w, compHeight);
		bracketLeft.setText("[");
		bracketLeft.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(bracketLeft);
		
		x = (int) (jTextFieldModiAngr.getX() + jTextFieldModiAngr.getWidth() + perw);
		y = (int) (24*perh);
	    w = (int) (6*perw);
		jTextFieldLimitAngr.setBounds(x, y, w, compHeight);
		jTextFieldLimitAngr.setText("Limit (Waffe)");
		jTextFieldLimitAngr.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldLimitAngr);

		x = (int) (jTextFieldLimitAngr.getX() + jTextFieldLimitAngr.getWidth());
		w = (int) (perw);		
		bracketRight.setBounds(x, y, w, compHeight);
		bracketRight.setText("]");
		bracketRight.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(bracketRight);
		
		x = (int) (6*perw);
	    y = (int) (30*perh);
	    w = (int) (8*perw);
		equal.setBounds(x, y, w, compHeight);
		equal.setFont(equal.getFont().deriveFont(18f));
		equal.setText("=");
		equal.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(equal);
		
		x = (int) (12*perw);
		jLabelErgebnisAngr.setBounds(x, y, w, compHeight);
		jLabelErgebnisAngr.setFont(jLabelErgebnisAngr.getFont().deriveFont(18f));
		jLabelErgebnisAngr.setText("");
		jLabelErgebnisAngr.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelErgebnisAngr);

		
		
		

		x = (int) (2*perw);
	    y = (int) (36*perh);
	    w = (int) (8*perw);
		wuerfelAngr.setBounds(x, y, w, compHeight);
		wuerfelAngr.setText("Ergebnis Würfelwurf:");
		wuerfelAngr.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(wuerfelAngr);
		
		x = (int) (wuerfelAngr.getX() + wuerfelAngr.getWidth() + perw);
		eintragErgAngr.setBounds(x, y, w, compHeight);
		eintragErgAngr.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(eintragErgAngr);
		
		x = (int) (eintragErgAngr.getX() + eintragErgAngr.getWidth() + perw);
		angriffWuerfeln.setBounds(x, y, w, compHeight);
		angriffWuerfeln.setText("Würfeln");
		angriffWuerfeln.setHorizontalAlignment(SwingConstants.CENTER);
		angriffWuerfeln.setMargin(new Insets(2, 2, 2, 2));
		angriffWuerfeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				angriffWuerfeln_ActionPerformed(evt);
			}
		});
		battlePanel.add(angriffWuerfeln);
		
		
		
		// <------------------------ 
		
		x = (int) (frameWidth/3-(4*perw));
		y = (int) (43*perh);
		w = (int) (8*perw);
		treffer.setBounds(x, y, w, compHeight);
		treffer.setFont(treffer.getFont().deriveFont(18f));
		treffer.setText("");
		treffer.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(treffer);

		x = (int) (eintragErgAngr.getX());
		y = (int) (48*perh);
		w = (int) (eintragErgAngr.getWidth());
		jLabelNettoErfText.setBounds(x, y, w, compHeight);
		jLabelNettoErfText.setText("Nettoerfolge");
		jLabelNettoErfText.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelNettoErfText);
		
		x = (int) (angriffWuerfeln.getX());
		jLabelModSCodeText.setBounds(x, y, w, compHeight);
		jLabelModSCodeText.setText("mod. Schadenscode");
		jLabelModSCodeText.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelModSCodeText);
		
		
		

		x = (int) (wuerfelAngr.getX());
		y = (int) (52*perh);
		schadenscodeAngr.setBounds(x, y, w, compHeight);
		schadenscodeAngr.setText("Schadenscode");
		schadenscodeAngr.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(schadenscodeAngr);
		
		x = (int) (schadenscodeAngr.getX() + schadenscodeAngr.getWidth());
		w = (int) (2*perw);
		plus3.setBounds(x, y, w, compHeight);
		plus3.setText("+");
		plus3.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(plus3);
		
		x = (int) (eintragErgAngr.getX());
		w = (int) (jLabelNettoErfText.getWidth());
		jLabelNettoErf.setBounds(x, y, w, compHeight);
		jLabelNettoErf.setText("");
		jLabelNettoErf.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelNettoErf);
		
		x = (int) (jLabelNettoErf.getX() + jLabelNettoErf.getWidth());
		w = (int) (2*perw);
		equal3.setBounds(x, y, w, compHeight);
		equal3.setFont(equal3.getFont().deriveFont(18f));
		equal3.setText("=");
		equal3.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(equal3);
		
		
		x = (int) (jLabelModSCodeText.getX());
		w = (int) (jLabelModSCodeText.getWidth());
		jLabelModSCode.setBounds(x, y, w, compHeight);
		jLabelModSCode.setFont(jLabelModSCode.getFont().deriveFont(18f));
		jLabelModSCode.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelModSCode);

		// <----------------------------- 
				
		x = (int) (frameWidth/3-(8*perw));
		y = (int) (60*perh);
		w = (int) (16*perw);
		schadensArt.setBounds(x, y, w, compHeight);
		schadensArt.setFont(schadensArt.getFont().deriveFont(18f));
		schadensArt.setText("");
		schadensArt.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(schadensArt);

		
		// <-----------------------------  HIER!
		
		
		

		x = (int) (wuerfelAngr.getX());
		y = (int) (68*perh);
		w = (int) (16*perw);
		jLabelSCodenachWuerfeln.setBounds(x, y, w, compHeight);
		jLabelSCodenachWuerfeln.setText("Schadenscode nach Widerstandsprobe:");
		jLabelSCodenachWuerfeln.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelSCodenachWuerfeln);
		
		x = (int) (jLabelModSCode.getX());
		w = (int) (jLabelModSCode.getWidth());
		eintragSCodenachWuerfeln.setBounds(x, y, w, compHeight);
		eintragSCodenachWuerfeln.setFont(eintragSCodenachWuerfeln.getFont().deriveFont(18f));
		eintragSCodenachWuerfeln.setText("");
		eintragSCodenachWuerfeln.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(eintragSCodenachWuerfeln);

		x = (int) (6*perw);
		y = (int) (84*perh);
		w = (int) (15*perw);
		schadenAnwenden.setBounds(x, y, w,compHeight);
		schadenAnwenden.setText("Anwenden!");
		schadenAnwenden.setMargin(new Insets(2, 2, 2, 2));
		schadenAnwenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				schadenAnwenden_ActionPerformed(evt);
			}
		});
		battlePanel.add(schadenAnwenden);

		x = (int) (schadenAnwenden.getX() + schadenAnwenden.getWidth() + 2*perw);
		zurueckSetzen.setBounds(x, y, w,compHeight);
		zurueckSetzen.setText("Zurücksetzen");
		zurueckSetzen.setMargin(new Insets(2, 2, 2, 2));
		zurueckSetzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				zurueckSetzen_ActionPerformed(evt);
			}
		});
		battlePanel.add(zurueckSetzen);

		x = (int) (zurueckSetzen.getX() + zurueckSetzen.getWidth() + 2*perw);
		update.setBounds(x, y, w,compHeight);
		update.setText("Update Werte");
		update.setMargin(new Insets(2, 2, 2, 2));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				update_ActionPerformed(evt);
			}
		});
		battlePanel.add(update);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		int c = (frameWidth/3);
		x = (int) (8*perw + c);
		w = (int) (16*perw);
		y = (int) jLabelAng.getY();
		jLabelVert.setBounds(x, y, w, compHeight);
		jLabelVert.setFont(jLabelVert.getFont().deriveFont(18f));
		jLabelVert.setText("Verteidiger");
		jLabelVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelVert);
				
		y = (int) jComboBoxAngreifer.getY();
		w = jComboBoxAngreifer.getWidth();
		jComboBoxVerteidiger.setBounds(x, y, w, compHeight);
		battlePanel.add(jComboBoxVerteidiger);
		
		
		modelKZM2 = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return tableNames.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return tableNames[index]; 
            } 
        };
	    kZuMon2 = new JTable(modelKZM2);
	    
	    x = (int) (4*perw+c);
	    y = (int) sKZM.getY();
	    w = (int) sKZM.getWidth();
	    JScrollPane sKZM2 = new JScrollPane (kZuMon2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sKZM2.setBounds(x, y, w, (int) compHeight);
	    sKZM2.setBorder(new TitledBorder ( new EtchedBorder (), "Körperlicher ZM:" ));
	    battlePanel.add(sKZM2);
	    
	    modelGZM2 = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return tableNames.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return tableNames[index]; 
            } 
        };
	    
	    gZuMon2 = new JTable(modelGZM2);
	    x = (int) (20*perw+c);
	    JScrollPane sGZM2 = new JScrollPane (gZuMon2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sGZM2.setBounds(x, y, w, (int) compHeight);
	    sGZM2.setBorder(new TitledBorder ( new EtchedBorder (), "Geistiger ZM:" ));
	    battlePanel.add(sGZM2);
	    
	    
	    
	    x = (int) (4*perw+c);
	    y = (int) jTextFieldKampfart.getY();
	    w = (int) (8*perw);
	    jLabelReaVert.setBounds(x, y, w, compHeight);
		jLabelReaVert.setText("");
		jLabelReaVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelReaVert);
		
		x = (int) (jLabelReaVert.getX() + jLabelReaVert.getWidth() + 2+perw);
		jLabelIntVert.setBounds(x, y, w, compHeight);
		jLabelIntVert.setText("");
		jLabelIntVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelIntVert);
		
		x = (int) (jLabelReaVert.getX() + jLabelReaVert.getWidth());
		w = (int) (2*perw);
		plus2.setBounds(x, y, w, compHeight);
		plus2.setText("+");
		plus2.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(plus2);
		
		x = (int) (jLabelIntVert.getX() + jLabelIntVert.getWidth());
		plusminus2.setBounds(x, y, w, compHeight);
		plusminus2.setText("\u00B1");
		plusminus2.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(plusminus2);
		
		x = (int) (jLabelIntVert.getX() + jLabelIntVert.getWidth() + 2*perw);
		w = jLabelReaVert.getWidth();
		jTextFieldModiVert.setBounds(x, y, w, compHeight);
		jTextFieldModiVert.setText("Modifikator" + " ("	+ jLabelKZMbatMali2.getText() + ")");
		jTextFieldModiVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldModiVert);

		x = (int) (jLabelReaVert.getX());
		y = equal.getY();
		w = jLabelReaVert.getWidth();
		equal2.setBounds(x, y, w, compHeight);
		equal2.setFont(equal.getFont().deriveFont(18f));
		equal2.setText("=");
		equal2.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(equal2);
		
		x = (int) (jLabelIntVert.getX());
		jLabelErgebnisVert.setBounds(x, y, w, compHeight);
		jLabelErgebnisVert.setFont(jLabelErgebnisVert.getFont().deriveFont(18f));
		jLabelErgebnisVert.setText("");
		jLabelErgebnisVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelErgebnisVert);
		
		x = (int) (jLabelReaVert.getX());
		y = wuerfelAngr.getY();
		wuerfelVert.setBounds(x, y, w, compHeight);
		wuerfelVert.setText("Ergebnis Würfelwurf:");
		wuerfelVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(wuerfelVert);
		
		x = (int) (wuerfelVert.getX() + wuerfelVert.getWidth() + perw);
		eintragErgVert.setBounds(x, y, w, compHeight);
		eintragErgVert.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(eintragErgVert);
		
		x = (int) (eintragErgVert.getX() + eintragErgVert.getWidth() + perw);
		automWuerfeln.setBounds(x, y, w, compHeight);
		automWuerfeln.setText("Würfeln");
		automWuerfeln.setMargin(new Insets(2, 2, 2, 2));
		automWuerfeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				automWuerfeln_ActionPerformed(evt);
			}
		});
		battlePanel.add(automWuerfeln);
		
		
		x = (int) (equal2.getX());
		y = (int) (jLabelNettoErfText.getY());
		w = (int) (equal2.getWidth());
		jLabelPanzCombat.setBounds(x, y, w, compHeight);
		jLabelPanzCombat.setText("Panzerungswert");
		jLabelPanzCombat.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelPanzCombat);
		
		//x = (int) (equal2.getX());
		y = (int) (schadenscodeAngr.getY());
		//w = (int) (equal2.getWidth());
		jTextFieldPanzCombat.setBounds(x, y, w, compHeight);
		jTextFieldPanzCombat.setText("Panzerungswert");
		jTextFieldPanzCombat.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldPanzCombat);
		
		x = (int) (jTextFieldPanzCombat.getX() + jTextFieldPanzCombat.getWidth());
		w = (int) (2*perw);
		minus.setBounds(x, y, w, compHeight);
		minus.setText("-");
		minus.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(minus);
		
		x = (int) (jTextFieldPanzCombat.getX() + jTextFieldPanzCombat.getWidth() + 2*perw);
		w = (int) (eintragErgVert.getWidth());
		jTextFieldDK.setBounds(x, y, w, compHeight);
		jTextFieldDK.setText("DK");
		jTextFieldDK.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jTextFieldDK);
		
		x = (int) (jTextFieldDK.getX() + jTextFieldDK.getWidth());
		w = (int) (2*perw);
		equal4.setBounds(x, y, w, compHeight);
		equal4.setFont(equal4.getFont().deriveFont(18f));
		equal4.setText("=");
		equal4.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(equal4);
		
		x = (int) (automWuerfeln.getX());
		w = (int) (automWuerfeln.getWidth());
		jLabelmodPanz.setBounds(x, y, w, compHeight);
		jLabelmodPanz.setFont(jLabelmodPanz.getFont().deriveFont(18f));
		jLabelmodPanz.setText("");
		jLabelmodPanz.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelmodPanz);
		
		y = jLabelPanzCombat.getY();
		jLabelmodPanzText.setBounds(x, y, w, compHeight);
		jLabelmodPanzText.setText("mod. Panzerungswert");
		battlePanel.add(jLabelmodPanzText);
		
		x = equal2.getX();
		y = schadensArt.getY() + gapSpaceV;
		w = (int) (2*automWuerfeln.getWidth());
		jLabelschadenWiderstandText.setBounds(x, y, w, compHeight);
		jLabelschadenWiderstandText.setText("Anzahl Würfel für Schadenswidertsandsprobe:");
		jLabelschadenWiderstandText.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelschadenWiderstandText);
		
		w = (int) (automWuerfeln.getWidth());
		y = (int) (jLabelschadenWiderstandText.getY() + 2*perh);
		jLabelKonCombat.setBounds(x, y, w, compHeight);
		jLabelKonCombat.setText("Kon");
		jLabelKonCombat.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelKonCombat);
		
		x = jTextFieldDK.getX();
		jLabelmodPanzAnz.setBounds(x, y, w, compHeight);
		jLabelmodPanzAnz.setText("mod. Panz.");
		jLabelmodPanzAnz.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelmodPanzAnz);
		
		x = jLabelKonCombat.getX();
		y = (int) (jLabelmodPanzAnz.getY() + 2*perh);
		jLabelKonCombatAnz.setBounds(x, y, w, compHeight);
		jLabelKonCombatAnz.setText("");
		jLabelKonCombatAnz.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelKonCombatAnz);
		
		x = eintragErgVert.getX();
		//y = jLabelmodPanzAnz.getY();
		jLabelmodPanzAnz2.setBounds(x, y, w, compHeight);
		jLabelmodPanzAnz2.setText("");
		jLabelmodPanzAnz2.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelmodPanzAnz2);
		
		x = minus.getX();
		y = jLabelKonCombatAnz.getY();
		w = (int) (2*perw);
		plus4.setBounds(x, y, w, compHeight);
		plus4.setText("+");
		plus4.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(plus4);
		
		x = equal4.getX();
		w = equal4.getWidth();
		equal5.setBounds(x, y, w, compHeight);
		equal5.setFont(equal5.getFont().deriveFont(18f));
		equal5.setText("=");
		equal5.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(equal5);
		
		x = automWuerfeln.getX();
		w = automWuerfeln.getWidth();
		jLabelAnzSchadenWid.setBounds(x, y, w, compHeight);
		jLabelAnzSchadenWid.setFont(jLabelAnzSchadenWid.getFont().deriveFont(18f));
		jLabelAnzSchadenWid.setText("");
		jLabelAnzSchadenWid.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(jLabelAnzSchadenWid);

		
		y = (int) (74*perh);
		x = equal2.getX();
		wuerfelSchadenWid.setBounds(x, y, w, compHeight);
		wuerfelSchadenWid.setText("Ergebnis Würfelwurf:");
		wuerfelSchadenWid.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(wuerfelSchadenWid);
		
		x = (int) (wuerfelSchadenWid.getX() + wuerfelSchadenWid.getWidth() + perw); 
		eintragErgSchadenWid.setBounds(x, y, w, compHeight);
		eintragErgSchadenWid.setHorizontalAlignment(SwingConstants.CENTER);
		battlePanel.add(eintragErgSchadenWid);
		
		x = (int) (eintragErgSchadenWid.getX() + eintragErgSchadenWid.getWidth() + perw);
		automWuerfeln2.setBounds(x, y, w, compHeight);
		automWuerfeln2.setText("Würfeln");
		automWuerfeln2.setMargin(new Insets(2, 2, 2, 2));
		automWuerfeln2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				automWuerfeln2_ActionPerformed(evt);
			}
		});
		battlePanel.add(automWuerfeln2);
		
		// <----------------------------------------------------------------
		
		jTextAreaProtokoll.setEditable(false);
	    scrollProto = new JScrollPane (jTextAreaProtokoll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollProto.setBounds((2*frameWidth)/3+20, automWuerfeln.getY(), (frameWidth)/3-60, frameHeight-automWuerfeln.getY()-100);
	    //jTextAreaProtokoll.setText("Protokoll: " + getDate());
	    scrollProto.setBorder(new TitledBorder ( new EtchedBorder (), "Protokoll: " + InitiativePanel.getDate()));
	    battlePanel.add(scrollProto); 

		// ActionListener für jComboBoxAngreifer (Angreifer)
		jComboBoxAngreifer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chara ref = IAmTheFrame.searchCharaByName((String) jComboBoxAngreifer.getSelectedItem());
				try {
//					jLabelKZMbatAnz.setText("" + ref.getKZM());
//					jLabelGZMbatAnz.setText("" + ref.getGZM());
//					jLabelKZMbatMali.setText(""	+ ((ref.getKZMAbs() - ref.getKZM()) / 3));
//					jLabelGZMbatMali.setText(""	+ ((ref.getGZMAbs() - ref.getGZM()) / 3));
//					jTextFieldModiAngr.setText("Modifikator" + " ("	+ jLabelKZMbatMali.getText() + ")");
				
					modelKZM.setRowCount(0);
					modelKZM.addRow(new Object[]{ref.getKZM(), ((ref.getKZMAbs() - ref.getKZM()) / 3)});
					modelGZM.setRowCount(0);
					modelGZM.addRow(new Object[]{ref.getGZM(), ((ref.getGZMAbs() - ref.getGZM()) / 3)});
					jTextFieldModiAngr.setText("Modifikator (" + modelKZM.getValueAt(0, 1)  + ")");
				} catch (java.lang.NullPointerException ex){
					ex.printStackTrace();
				}
			}
		});
		// ActionListener für jComboBoxVerteidiger (Verteidiger)
		jComboBoxVerteidiger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chara ref = IAmTheFrame.searchCharaByName((String) jComboBoxVerteidiger
						.getSelectedItem());
				try {
//					jLabelKZMbatAnz2.setText("" + ref.getKZM());
//					jLabelGZMbatAnz2.setText("" + ref.getGZM());
//					jLabelKZMbatMali2.setText(""
//							+ ((ref.getKZMAbs() - ref.getKZM()) / 3));
//					jLabelGZMbatMali2.setText(""
//							+ ((ref.getGZMAbs() - ref.getGZM()) / 3));
					jLabelReaVert.setText("" + ref.getREA());
					jLabelIntVert.setText("" + ref.getINT());
					jTextFieldPanzCombat.setText("" + ref.getPANZ());
					jLabelKonCombatAnz.setText("" + ref.getKON());
					modelKZM2.setRowCount(0);
					modelKZM2.addRow(new Object[]{ref.getKZM(), ((ref.getKZMAbs() - ref.getKZM()) / 3)});
					modelGZM2.setRowCount(0);
					modelGZM2.addRow(new Object[]{ref.getGZM(), ((ref.getGZMAbs() - ref.getGZM()) / 3)});
					jTextFieldModiVert.setText("Modifikator (" + modelKZM2.getValueAt(0, 1)  + ")");
					verteidiger = ref;
				} catch (java.lang.NullPointerException ex){
					ex.printStackTrace();
				}
			}
		});

		// L�sst den Text l�schen, wenn in Textfeld geklickt wird
		jTextFieldDK.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed7) {
					jTextFieldDK.setText("");
					isTabbed7 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				calcSchadensArt();
			}
		});
		// L�sst den Text l�schen, wenn in Textfeld geklickt wird
		eintragErgSchadenWid
				.addFocusListener(new java.awt.event.FocusAdapter() {
					public void focusGained(java.awt.event.FocusEvent evt) {
						if (!isTabbed8) {
							eintragErgSchadenWid.setText("");
							isTabbed8 = true;
						}
					}

					public void focusLost(java.awt.event.FocusEvent evt) {
						try {
							eintragSCodenachWuerfeln.setText(""
									+ (Integer.parseInt(jLabelModSCode
											.getText()) - Integer
											.parseInt(eintragErgSchadenWid
													.getText())));
						} catch (Exception e) {
							System.out.println("Fehler42");
						}
					}
				});

		// L�sst den Text l�schen, wenn in Textfeld geklickt wird
		schadenscodeAngr.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed6) {
					schadenscodeAngr.setText("");
					isTabbed6 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					int nettoerf = (Integer.parseInt(eintragErgAngr.getText()) - Integer
							.parseInt(eintragErgVert.getText()));
					if (nettoerf > 0)
						jLabelNettoErf.setText("" + nettoerf);
					jLabelModSCode.setText(""
							+ (Integer.parseInt(schadenscodeAngr.getText()) + nettoerf));
					calcSchadensArt();
				} catch (Exception e) {
					System.out.println("Keine Zahl!");
				}
			}
		});
		// Lässt den Text löschen, wenn in Textfeld geklickt wird
		jTextFieldModiAngr.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed1) {
					jTextFieldModiAngr.setText("");
					isTabbed1 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					jLabelErgebnisAngr.setText(""
							+ (Integer.parseInt(jTextFieldKampfart.getText())
									+ Integer.parseInt(jTextFieldAttribut
											.getText()) + Integer
										.parseInt(jTextFieldModiAngr.getText()))
							+ " ["
							+ Integer.parseInt(jTextFieldLimitAngr.getText())
							+ "]");
				} catch (Exception e) {
					System.out.println("Wohl keine Zahl eingegeben?");
				}
			}
		});
		jTextFieldKampfart.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed2) {
					jTextFieldKampfart.setText("");
					isTabbed2 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					jLabelErgebnisAngr.setText(""
							+ (Integer.parseInt(jTextFieldKampfart.getText())
									+ Integer.parseInt(jTextFieldAttribut
											.getText()) + Integer
										.parseInt(jTextFieldModiAngr.getText()))
							+ " ["
							+ Integer.parseInt(jTextFieldLimitAngr.getText())
							+ "]");
				} catch (Exception e) {
					System.out.println("Wohl keine Zahl eingegeben?");
				}
			}
		});
		jTextFieldAttribut.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed3) {
					jTextFieldAttribut.setText("");
					isTabbed3 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					jLabelErgebnisAngr.setText(""
							+ (Integer.parseInt(jTextFieldKampfart.getText())
									+ Integer.parseInt(jTextFieldAttribut
											.getText()) + Integer
										.parseInt(jTextFieldModiAngr.getText()))
							+ " ["
							+ Integer.parseInt(jTextFieldLimitAngr.getText())
							+ "]");
				} catch (Exception e) {
					System.out.println("Wohl keine Zahl eingegeben?");
				}
			}
		});
		jTextFieldLimitAngr.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed4) {
					jTextFieldLimitAngr.setText("");
					isTabbed4 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					jLabelErgebnisAngr.setText(""
							+ (Integer.parseInt(jTextFieldKampfart.getText())
									+ Integer.parseInt(jTextFieldAttribut
											.getText()) + Integer
										.parseInt(jTextFieldModiAngr.getText()))
							+ " ["
							+ Integer.parseInt(jTextFieldLimitAngr.getText())
							+ "]");
				} catch (Exception e) {
					System.out.println("Wohl keine Zahl eingegeben?");
				}
			}
		});
		jTextFieldModiVert.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (!isTabbed5) {
					jTextFieldModiVert.setText("");
					isTabbed5 = true;
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					jLabelErgebnisVert.setText(""
							+ (Integer.parseInt(jLabelReaVert.getText())
									+ Integer.parseInt(jLabelIntVert.getText()) + Integer
										.parseInt(jTextFieldModiVert.getText())));
				} catch (Exception e) {
					System.out.println("Wohl keine Zahl eingegeben?");
				}
			}
		});
		eintragErgAngr.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " würfelt den Angriff mit Kampffertigkeit " + jTextFieldKampfart.getText() + " + Attributwert " + jTextFieldAttribut.getText() + " (" + jTextFieldModiAngr.getText() + ") [" + jTextFieldLimitAngr.getText() + "]");
				InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " würfelt den Angriff mit " + jLabelErgebnisAngr.getText() + " Würfeln " + eintragErgAngr.getText() + " Erfolg(e)");
				calcTreffer();
			}
		});
		eintragErgVert.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				calcTreffer();
			}
		});
		jTextFieldDK.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				calcModPanz();
			}
		});
		jTextFieldPanzCombat
				.addFocusListener(new java.awt.event.FocusAdapter() {
					public void focusLost(java.awt.event.FocusEvent evt) {
						calcModPanz();
					}
				});
	}
	
	
	// Berechnet, welche Schadensart zustande kommt
	private static boolean calcSchadensArt() {
		try {
			if (Integer.parseInt(jLabelModSCode.getText()) >= Integer
					.parseInt(jLabelmodPanz.getText())) {
				schadensArt.setForeground(Color.red);
				schadensArt.setText("Körperlicher Schaden!");
				return true;
			} else {
				schadensArt.setForeground(Color.green);
				schadensArt.setText("Geistiger Schaden!");
			}

		} catch (Exception e) {
			System.out.println("Fehler!");
		}
		return false;
	}

	// Berechnet den mod. Panzerungswert
	private static void calcModPanz() {
		try {
			int n = (Integer.parseInt(jTextFieldPanzCombat.getText()) - Integer
					.parseInt(jTextFieldDK.getText()));
			if (n < 0)
				n = 0;
			jLabelmodPanz.setText("" + n);
			jLabelmodPanzAnz2.setText("" + n);
			jLabelAnzSchadenWid.setText(""
					+ (Integer.parseInt(jLabelKonCombatAnz.getText()) + n));
		} catch (Exception e) {
			System.out.println("Fehler!");
		}
	}

	// Berechnet, ob ein Treffer oder nicht stattfand und falls ja, werden
	// Nettoerfolge angezeigt
	private static void calcTreffer() {
		try {
			if (Integer.parseInt(eintragErgAngr.getText()) > Integer
					.parseInt(eintragErgVert.getText())) {
				treffer.setForeground(Color.green);
				treffer.setText("Treffer!");
				jLabelNettoErf.setText(""
						+ (Integer.parseInt(eintragErgAngr.getText()) - Integer
								.parseInt(eintragErgVert.getText())));
			} else if (Integer.parseInt(eintragErgAngr.getText()) == Integer
					.parseInt(eintragErgVert.getText())) {
				treffer.setForeground(Color.black);
				treffer.setText("Streiftreffer!");
			} else {
				treffer.setForeground(Color.red);
				treffer.setText("Kein Treffer!");
			}
		} catch (Exception e) {
			System.out.println("Fehler!");
		}
	}

	// Würfelt zufällig für den Verteidiger die Probe
	public static void automWuerfeln_ActionPerformed(ActionEvent evt) {
		int anz = 0;
		int erfolge = 0;
		int miss = 0;
		Random ran = new Random();
		try {
			anz = Integer.parseInt(jLabelErgebnisVert.getText());
		} catch (Exception e) {
			System.out.println("Fehler2");
		}
		for (int i = 0; i < anz; ++i) {
			int wurf = ran.nextInt(6) + 1;
			System.out.println(wurf);
			if (wurf == 5 || wurf == 6) {
				erfolge++;
			}
			if (wurf == 1) miss++;
		}
		erfolgeVert = erfolge;
		eintragErgVert.setText("" + erfolgeVert);
		InitiativePanel.writeProto("" + jComboBoxVerteidiger.getSelectedItem() + " würfelt die Verteidigung mit " + jLabelReaVert.getText() + " Reaktion + " + jLabelIntVert.getText() + " Intuition (" + jTextFieldModiVert.getText() + ")");
		InitiativePanel.writeProto("" + jComboBoxVerteidiger.getSelectedItem() + " würfelt die Verteidigung mit " + anz + " Würfeln " + erfolgeVert + " Erfolg(e)");
		try {
			if (Integer.parseInt(eintragErgAngr.getText()) > Integer
					.parseInt(eintragErgVert.getText())) {
				treffer.setForeground(Color.green);
				treffer.setText("Treffer!");
				InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " erzielt einen Treffer auf " + jComboBoxVerteidiger.getSelectedItem());
			} else if (Integer.parseInt(eintragErgAngr.getText()) == Integer
					.parseInt(eintragErgVert.getText())) {
				treffer.setText("Streiftreffer!");
				InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " erzielt einen Streiftreffer auf " + jComboBoxVerteidiger.getSelectedItem());
			} else {
				treffer.setForeground(Color.red);
				treffer.setText("Kein Treffer!");
				InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " trifft " + jComboBoxVerteidiger.getSelectedItem() + " nicht");
			}
		} catch (Exception e) {
			System.out.println("Fehler!");
		}
		if (Math.ceil(anz*1.0f/2) == miss) {
			if (erfolge == 0) {
				JOptionPane.showConfirmDialog(battlePanel,"Kritischer Patzer! (etwas sehr unangenehmes passiert)", "Kritischer Patzer", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showConfirmDialog(battlePanel,"Patzer! (etwas unangenehmes passiert)", "Patze", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	} // end of jButton2_ActionPerformed

	// Würfelt zufällig für den Verteidiger die Schadenswiderstandsprobe
	public static void automWuerfeln2_ActionPerformed(ActionEvent evt) {
		int anz = 0;
		int erfolge = 0;
		Random ran = new Random();
		try {
			anz = Integer.parseInt(jLabelAnzSchadenWid.getText());
		} catch (Exception e) {
			System.out.println("Fehler3");
		}
		for (int i = 0; i < anz; ++i) {
			int wurf = ran.nextInt(6) + 1;
			System.out.println(wurf);
			if (wurf == 5 || wurf == 6) {
				erfolge++;
			}
		}
		eintragErgSchadenWid.setText("" + erfolge);
		InitiativePanel.writeProto("" + jComboBoxVerteidiger.getSelectedItem() + " würfelt die Schadenwiderstandsprobe mit " + anz + " Würfeln " + erfolge + " Erfolge");
		try {
			eintragSCodenachWuerfeln.setText(""
					+ (Integer.parseInt(jLabelModSCode.getText()) - erfolge));
		} catch (Exception e) {
			System.out.println("Fehler42");
		}

	} // end of jButton2_ActionPerformed
	
	// Würfelt zufällig für den Verteidiger die Schadenswiderstandsprobe
		public static void angriffWuerfeln_ActionPerformed(ActionEvent evt) {
			int wuerfel = 0;
			int limit = 0;
			int erfolge = 0;
			String s = "";
			Random ran = new Random();
			try {
				// Syntaxanalyse:
				s = jLabelErgebnisAngr.getText();
				wuerfel = Integer.parseInt(s.substring(0,s.indexOf("[")-1));
				limit = Integer.parseInt(s.substring(s.indexOf("[")+1, s.length()-1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int i = 0; i < wuerfel; ++i) {
				int wurf = ran.nextInt(6) + 1;
				System.out.println(wurf);
				if (wurf == 5 || wurf == 6) {
					erfolge++;
				}
			}
			if (erfolge > limit) erfolge = limit;
			eintragErgAngr.setText("" + erfolge);
			InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " würfelt den Angriff mit Kampffertigkeit " + jTextFieldKampfart.getText() + " + Attributwert " + jTextFieldAttribut.getText() + " (" + jTextFieldModiAngr.getText() + ") [" + jTextFieldLimitAngr.getText() + "]");
			InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " würfelt den Angriff mit " + jLabelErgebnisAngr.getText() + " Würfeln " + erfolge + " Erfolg(e)");
			//InitiativePanel.writeProto("" + jComboBoxAngreifer.getSelectedItem() + " würfelt die Schadenwiderstandsprobe mit " + s + " Würfeln " + erfolge + " Erfolge");
//			try {
//				eintragSCodenachWuerfeln.setText(""
//						+ (Integer.parseInt(jLabelModSCode.getText()) - erfolge));
//			} catch (Exception e) {
//				System.out.println("Fehler42");
//			}

		} // end of jButton2_ActionPerformed

	public static void schadenAnwenden_ActionPerformed(ActionEvent evt) {
		try {
			int n = Integer.parseInt(eintragSCodenachWuerfeln.getText());
			if (n >= 10) { // Niederschlag!
				JOptionPane.showConfirmDialog(battlePanel,"Der Verteidiger wurde niedergeschlagen!", "Niederschlag!", JOptionPane.INFORMATION_MESSAGE);
			}
			if (calcSchadensArt()) {
				int neuerkzm = verteidiger.getKZM() - n;
				verteidiger.setKZM(neuerkzm);
				InitiativePanel.writeProto("" + jComboBoxVerteidiger.getSelectedItem() + " erleidet " + n + " körperlichen Schaden (neuer KZM: " + neuerkzm + ")");
			} else {
				int neuergzm = verteidiger.getGZM() - n;
				verteidiger.setGZM(neuergzm);
				InitiativePanel.writeProto("" + jComboBoxVerteidiger.getSelectedItem() + " erleidet " + n + " geistigen Schaden (neuer GZM: " + neuergzm + ")");
			}
//			jLabelKZMbatAnz2.setText("" + verteidiger.getKZM());
//			jLabelGZMbatAnz2.setText("" + verteidiger.getGZM());
//			jLabelKZMbatMali2.setText("" + ((verteidiger.getKZMAbs() - verteidiger.getKZM()) / 3));
//			jLabelGZMbatMali2.setText("" + ((verteidiger.getGZMAbs() - verteidiger.getGZM()) / 3));
			Chara ref = IAmTheFrame.searchCharaByName((String) jComboBoxVerteidiger
					.getSelectedItem());
			try {
//				jLabelReaVert.setText("" + ref.getREA());
//				jLabelIntVert.setText("" + ref.getINT());
//				jTextFieldPanzCombat.setText("" + ref.getPANZ());
//				jLabelKonCombatAnz.setText("" + ref.getKON());
				modelKZM2.setRowCount(0);
				modelKZM2.addRow(new Object[]{ref.getKZM(), ((ref.getKZMAbs() - ref.getKZM()) / 3)});
				modelGZM2.setRowCount(0);
				modelGZM2.addRow(new Object[]{ref.getGZM(), ((ref.getGZMAbs() - ref.getGZM()) / 3)});
				//jTextFieldModiVert.setText("Modifikator (" + modelKZM2.getValueAt(0, 1)  + ")");
				//verteidiger = ref;
			} catch (java.lang.NullPointerException ex){
				ex.printStackTrace();
			}
			
			schadenAnwenden.setEnabled(false);
		} catch (Exception e) {
			// do nothing
		}

	} // end of schadenAnwenden_ActionPerformed

	public static void zurueckSetzen_ActionPerformed(ActionEvent evt) {
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
		} catch (Exception e) {
			// do nothing
		}
		jTextFieldDK.setText("DK");
		jLabelModSCode.setText("");
		jLabelNettoErf.setText("");
		jLabelErgebnisAngr.setText("");
		jLabelErgebnisVert.setText("");
		// wuerfelAngr.setText("");
		// wuerfelVert.setText("");
		treffer.setText("");
		schadensArt.setText("");
		jLabelmodPanz.setText("");
		eintragSCodenachWuerfeln.setText("");
		// jLabelmodPanzAnz2.setText("");
		wuerfelSchadenWid.setText("");
		schadenAnwenden.setEnabled(true);
	} // end of jButton2_ActionPerformed

	public static void update_ActionPerformed(ActionEvent evt) {

		try {
			jLabelErgebnisAngr.setText("" + (Integer.parseInt(jTextFieldKampfart.getText())	+ Integer.parseInt(jTextFieldAttribut.getText()) + Integer
										.parseInt(jTextFieldModiAngr.getText()))
							+ " ["	+ Integer.parseInt(jTextFieldLimitAngr.getText()) + "]");
		} catch (Exception e) {
			System.out.println("Wohl keine Zahl eingegeben?");
		}
		try {
			jLabelErgebnisVert
					.setText(""
							+ (Integer.parseInt(jLabelReaVert.getText())
									+ Integer.parseInt(jLabelIntVert.getText()) + Integer
										.parseInt(jTextFieldModiVert.getText())));
		} catch (Exception e) {
			System.out.println("Wohl keine Zahl eingegeben?");
		}
		calcTreffer();
		calcSchadensArt();
		try {
			int nettoerf = (Integer.parseInt(eintragErgAngr.getText()) - Integer
					.parseInt(eintragErgVert.getText()));
			if (nettoerf > 0)
				jLabelNettoErf.setText("" + nettoerf);
			jLabelModSCode
					.setText(""
							+ (Integer.parseInt(schadenscodeAngr.getText()) + nettoerf));
			calcSchadensArt();
		} catch (Exception e) {
			System.out.println("Keine Zahl!");
		}
		calcModPanz();
		try {

			eintragSCodenachWuerfeln.setText(""
					+ (Integer.parseInt(jLabelModSCode.getText()) - Integer
							.parseInt(eintragErgSchadenWid.getText())));
		} catch (Exception e) {
			System.out.println("Fehler42");
		}
	} // end of jButton2_ActionPerformed
	
	// Lässt ein Element zur TeilnehmerBox hinzufügen
	public static void addComboBoxes(String name){
		jComboBoxAngreifer.addItem(name);
		jComboBoxVerteidiger.addItem(name);
	}
	
	public static void setProto(String text) {
		jTextAreaProtokoll.setText(text);		
	}
}