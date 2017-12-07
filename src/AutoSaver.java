import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;

// Save periodically jTextAreaProtokoll from InitiativePanel
public class AutoSaver extends TimerTask {

	public void run() {
		System.out.println("Started");
		BufferedWriter bw = null;
	    FileWriter fw = null;
	    File file = null;
	    try{
	      String content = InitiativePanel.getProto();
	      String filename = IAmTheFrame.getPath();
	      file = new File(filename);
	      fw = new FileWriter(file.getParent() + "\\" + "AutoSave.txt");
	      bw = new BufferedWriter(fw);
	      bw.write(content);
	    }  catch (IOException e){
	      e.printStackTrace();
	    }  finally {
	      try {
	        
	          if (bw != null) {
	            bw.close();
	          } // end of if
	          if (fw != null) {
	            fw.close();
	          } // end of if
	      } catch(IOException ex) {
	        ex.printStackTrace();
	      } 
	    } 
	}
	
	public void terminate(){
		this.cancel();
	}
}