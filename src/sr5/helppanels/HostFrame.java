package sr5.helppanels;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class HostFrame extends JDialog {

	public HostFrame(){
		super();
		setTitle("Create a Host");
		setUp();
	}
	
	private void setUp() {
		setSize(new Dimension(400, 300));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//frameWidth = (int) d.getWidth();
		//frameHeight = (int) (winSize.height);
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		setVisible(true);
	}
	
}
