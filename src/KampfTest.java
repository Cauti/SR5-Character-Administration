import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.09.2017
  * @author 
  */

public class KampfTest extends JFrame {
  // Anfang Attribute
  // Ende Attribute
  
  public KampfTest() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1289; 
    int frameHeight = 755;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("KampfTest");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public KampfTest
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new KampfTest();
  } // end of main
  
  // Ende Methoden
} // end of class KampfTest
