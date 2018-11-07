package sr5.helppanels;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;
import sr5.classes.Fertigkeit;

public class FertPanel extends JDialog {
	private JTextField txtFertigkeit;
	private JLabel txtAttribut;
	private JComboBox<String> comboBoxFertigkeit;
	private JTextPane textPane;
	private JButton btnoeffnen;
	private boolean firstPressed = true;
	
	public FertPanel() {
		super();
		setTitle("Fertigkeiten");
		setUp();
	}
	
	private void setUp() {
		
		setSize(new Dimension(500, 400));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		setVisible(true);
		
		setLayout(new MigLayout("gapy 3%, gapx 2%, insets 2%", "[20%,grow][60%,grow][20%,grow]", "[10%,grow][10%,grow][60%,grow][10%,grow]"));
		
		JLabel lblSuchen = new JLabel("Suchen:");
		add(lblSuchen, "cell 0 0,grow");
		
		txtFertigkeit = new JTextField();
		txtFertigkeit.setText("Fertigkeit");
		add(txtFertigkeit, "cell 1 0 2 1,grow");
		txtFertigkeit.setColumns(10);
		
		comboBoxFertigkeit = new JComboBox<String>();
		add(comboBoxFertigkeit, "cell 0 1 3 1,grow");
		
		textPane = new JTextPane();
		add(textPane, "cell 0 2 3 1,grow");
		
		JLabel lblAttribut = new JLabel("Attribut:");
		add(lblAttribut, "cell 0 3,grow");
		
		txtAttribut = new JLabel();
		txtAttribut.setText("Attribut");
		add(txtAttribut, "cell 1 3 2 1,grow");
				
//		JLabel lblSeite = new JLabel("Seite:");
//		add(lblSeite, "cell 0 4");
//		
//		JLabel lblSeitenzahl = new JLabel("Seitenzahl");
//		add(lblSeitenzahl, "cell 1 4");
//		
//		btnoeffnen = new JButton("Öffnen");
//		add(btnoeffnen, "cell 2 4,grow");
		
		pack();
		
		this.setFocusable(true);
		
		setFunctions();
		
	}

	private void setFunctions() {
		Fertigkeit[] fert = Fertigkeit.class.getEnumConstants();
		for (Fertigkeit f: fert) {
			comboBoxFertigkeit.addItem(f.getName());
		}
		comboBoxFertigkeit.setSelectedItem(0);
		comboBoxFertigkeit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if (comboBoxFertigkeit.getItemCount() != 0) {
					int fid = Fertigkeit.getFertIDByName((String) comboBoxFertigkeit.getSelectedItem() );
					Fertigkeit f = Fertigkeit.getFertigkeitByID(fid);
					textPane.removeAll();
					textPane.setText(f.getText());
					txtAttribut.setText(f.getAttribut().getName());
				}
			}
		});
		txtFertigkeit.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String text = txtFertigkeit.getText();
				System.out.println(text);
				comboBoxFertigkeit.removeAllItems();
				//ArrayList<Fertigkeit> liketext = new ArrayList<Fertigkeit>();
				for (Fertigkeit f : fert) {
					if (f.getName().contains(text)) {
						System.out.println(f.getName());
						comboBoxFertigkeit.addItem(f.getName());
					}
				}
				if (comboBoxFertigkeit.getItemCount() == 0) {
					for (Fertigkeit f: fert) {
						comboBoxFertigkeit.addItem(f.getName());
					}
				}
				repaint();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		txtFertigkeit.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (firstPressed) {
					txtFertigkeit.setText("");
					firstPressed = false;
				}
			}
		});
		
//		btnoeffnen.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				btnoeffnen_ActionPerformed();
//			}
//		});
	}
	
//	// Wenn Button "Öffnen" gedrückt wird
//	private void btnoeffnen_ActionPerformed() {
////		String cmds[] = new String[] {"cmd", "/c", "Acrobat.exe /A \"page=1000\" \"C:\\Users\\PC\\Desktop\\beihilfeAUS.pdf\" "};
////		try {
////		    Runtime.getRuntime().exec(cmds);
////		    System.out.println("gedrückt");
////		} catch (Exception e) {
////			System.out.println("Doesn't exist");
////		}
////		try {
////		    // Execute command
////		    String command = "cmd /c start cmd.exe";
////		    Process child = Runtime.getRuntime().exec(command);
////
////		    // Get output stream to write from it
////		    OutputStream out = child.getOutputStream();
////
////		    out.write("Acrobat.exe /A \"page=2\" \"C:\\Users\\PC\\Desktop\\beihilfeAUS.pdf\"".getBytes());
////		    out.flush();
////		} catch (IOException e) {
////			System.out.println("No!");
////			
////		}
//		String[] command =
//		    {
//		        "cmd",
//		    };
//		    Process p;
//			try {
//				p = Runtime.getRuntime().exec(command);
//			
//				new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//				new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//				PrintWriter stdin = new PrintWriter(p.getOutputStream());
//				stdin.println("c:");
//				stdin.println("Acrobat.exe /A \"page=2\" \"C:\\Users\\Cauti\\Desktop\\beihilfeAUS.pdf\"");
//				// 	write any other commands you want here
//				stdin.close();
//				int returnCode = -1;
//				try {
//					returnCode = p.waitFor();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("Return code = " + returnCode);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
}
