import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Handler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.Timer;
import sr5.classes.*;
import sr5.helppanels.FertPanel;
import sr5.helppanels.HostFrame;

/**
 * 
 * Beschreibung
 * 
 * @version 1.0 vom 22.04.2017
 * @author Cauti
 */

public class IAmTheFrame extends JFrame {

	private static final long serialVersionUID = -5364507751550309271L;
	private static int frameWidth, frameHeight;
	private static ArrayList<Chara> charas = new ArrayList<Chara>();
	private static String absolutepath;

	// Menüs und Panels
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JFrame connectFrame;
	private JPanel valuePanel, battlePanel, initiativePanel;
	private static JList<String> allcharas = new JList<String>();
	//private static ArrayList<Chara> charaobjects = new ArrayList<Chara>();
	private DefaultListModel jList1Model = new DefaultListModel();
	private JScrollPane jList1ScrollPane = new JScrollPane(allcharas);
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private Timer time;
	private AutoSaver as;
	private BufferedImage image;
	private JMenu jMenu2;
	// Ende Attribute

	/**
	 * @wbp.parser.entryPoint
	 */
	public IAmTheFrame(String title) {
		// Frame-Initialisierung
		connectFrame = new JFrame();
		connectFrame.setTitle(title);
		//String iconpath = System.getProperty("user.dir") + "\\res\\logo2.png";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("logo2.png"));
			connectFrame.setIconImage(image);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(connectFrame,
						"Anwendung wirklich schließen?", "Schließen",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (as != null && time != null) {
						as.terminate();
						time.cancel();
						System.out.println("Timer stopped");
					}
					System.exit(0);
				}
			}
		};
		connectFrame.addWindowListener(exitListener);
		connectFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Größe der Windows-Toolbar
		Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = (int) d.getWidth();
		frameHeight = (int) (winSize.height);

		// GraphicsEnvironment ge =
		// GraphicsEnvironment.getLocalGraphicsEnvironment();
		// GraphicsDevice device =ge.getDefaultScreenDevice();
		//
		// if(device.isFullScreenSupported()){
		// device.setFullScreenWindow(connectFrame);
		// }

		connectFrame.setSize(frameWidth, frameHeight);
		connectFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		int x = (d.width - connectFrame.getSize().width) / 2;
		int y = (winSize.height - connectFrame.getSize().height) / 2;
		connectFrame.setLocation(x, y);
		connectFrame.setResizable(true);

		valuePanel = new JPanel();
		battlePanel = new JPanel();
		initiativePanel = new JPanel();
		JPanel matrixPanel = new JPanel();
		valuePanel.setLayout(null);
		battlePanel.setLayout(null);
		initiativePanel.setLayout(null);
		tabbedPane.addTab("Character", null, valuePanel,
				"Character Administration");
		tabbedPane.addTab("Initiative", null, initiativePanel,
				"Initiative Administration");
		tabbedPane.addTab("Combat", null, battlePanel, "Combat Emulation");
		tabbedPane.addTab("Matrix", null, matrixPanel, "Matrix Emulation");
		connectFrame.add(tabbedPane);

		// setUpValuePanel();
		setUpMenues();
		// setUpCombatPanel();
		CombatPanel.setUpCombatPanel(battlePanel);
		ValuePanel.setUpValuePanel(valuePanel);
		InitiativePanel.setupInitiativePanel(initiativePanel);
		MatrixPanel.buildGUI(matrixPanel);
		connectFrame.setVisible(true);
		//changeFont(connectFrame, new Font("Neuropol X Free",Font.PLAIN,14));
	} // end of public IAmTheFrame

	// Anfang Methoden

	// Setzt das Menü
	public void setUpMenues() {
		jMenuBar1 = new JMenuBar();

		jMenu1 = new JMenu("File");
		jMenu1.setMnemonic(KeyEvent.VK_F);
		
		jMenu2 = new JMenu("Help");
		jMenu2.setMnemonic(KeyEvent.VK_H);

		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Anwendung schließen");
		eMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int confirm = JOptionPane
						.showOptionDialog(
								connectFrame,
								"Sind Sie sicher, dass Sie die Anwendung schließen möchten?",
								"Anwendung schließen?",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					if (as != null && time != null) {
						as.terminate();
						time.cancel();
						System.out.println("Timer stopped");
					}
					System.exit(1);
				}
			}
		});

		// Lädt eine XML-File und zeigt die Charas an
		JMenuItem eMenuItem2 = new JMenuItem("Load File");
		eMenuItem2.setMnemonic(KeyEvent.VK_O);
		eMenuItem2.setToolTipText("Load a File");
		eMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"XML-Datei", "xml");
				JFileChooser fc;
				if (absolutepath == null) {
					fc = new JFileChooser();
				} else {
					fc = new JFileChooser(absolutepath);
				}
				fc.addChoosableFileFilter(filter);
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// Ausgabe der ausgewaehlten Datei
					System.out.println("Die zu öffnende Datei ist: "
							+ fc.getSelectedFile().getAbsolutePath());

					absolutepath = fc.getSelectedFile().getAbsolutePath();
					Chara[] c = XMLInterface.read(absolutepath);
					for (Chara chara : c) {
						//charaobjects.add(chara);
						charas.add(chara);
						String charname = chara.getName();
						((DefaultListModel<String>) allcharas.getModel()).addElement(charname);
						InitiativePanel.addComboBoxCharas(charname);
						CombatPanel.addComboBoxes(charname);
						if (chara.getKlasse().equals(Klasse.DECKER) || chara.getKlasse().equals(Klasse.RIGGER) || chara.getKlasse().equals(Klasse.TECHNOMANCER)) {
							MatrixPanel.addComboBoxes(charname);
						}
					}

					//
					time = new Timer(); // Instantiate Timer Object
					as = new AutoSaver();
					time.schedule(as, 0, 60000); // Create Repetitively task for
													// every 1 minute
				}
			}
		});

		JMenuItem eMenuItem3 = new JMenuItem("Create Host");
		eMenuItem3.setMnemonic(KeyEvent.VK_H);
		eMenuItem3.setToolTipText("Creats a Host");
		eMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				HostFrame hf = new HostFrame();
			}
		});
		
		JMenuItem eMenuItemFert = new JMenuItem("Fertigkeiten");
		eMenuItemFert.setMnemonic(KeyEvent.VK_F);
		eMenuItemFert.setToolTipText("Fertigkeiten anzeigen");
		eMenuItemFert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new FertPanel();
			}
		});
		
		jMenu1.add(eMenuItem2);
		jMenu1.add(eMenuItem3);
		jMenu1.add(eMenuItem);
		jMenu2.add(eMenuItemFert);
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);
		connectFrame.setJMenuBar(jMenuBar1);
	}

	public static String getPath() {
		return absolutepath;
	}

	public static JList<String> getAllCharas() {
		return allcharas;
	}

	public static ArrayList<Chara> getCharas() {
		return charas;
	}

	public static int getFrameWidth() {
		return frameWidth;
	}

	public static int getFrameHeight() {
		return frameHeight;
	}
	
	public static void addToAllCharas(String name){
		((DefaultListModel<String>) allcharas.getModel()).addElement(name);
	}

	// Antwortet den Chara mit dem Namen @selectedItem
	public static Chara searchCharaByName(String selectedItem) {
		for (Chara c : charas) {
			if (c.getName().equals(selectedItem)) {
				return c;
			}
		}
		return null;
	}
	
	public static void changeFont ( Component component, Font font ){
	    component.setFont ( font );
	    if ( component instanceof Container ){
	        for ( Component child : ( ( Container ) component ).getComponents () ){
	            changeFont ( child, font );
	        }
	    }
	}

	public static void main(String[] args) {
		try {
            // Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		new IAmTheFrame("CASCADE V. 1.2 Beta");
	} // end of main
} // end of class IAmTheFrame