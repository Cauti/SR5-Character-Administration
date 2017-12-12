import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class UHandlungenComboBoxListener implements ItemListener {

	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		JComboBox<?> cb = (JComboBox<?>) evt.getSource();

	    Object item = evt.getItem();

	    if (evt.getStateChange() == ItemEvent.SELECTED) {
	      // Item was just selected
	    	
	    } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
	      // Item is no longer selected
	    }
	}

}
