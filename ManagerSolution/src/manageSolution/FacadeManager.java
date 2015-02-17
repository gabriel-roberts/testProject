package manageSolution;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FacadeManager {
    	JFrame frame;
    	private static FacadeManager _facadeManager = null;
     public FacadeManager(){
    	 frame = new AccountManager();
     }
     public void createFrame(){
    	 frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
	      frame.setSize(500, 450);
	      frame.setVisible(true);
     }
     public static FacadeManager instance(){
 	    if (_facadeManager == null){ _facadeManager = new FacadeManager();     }
 	    return _facadeManager;
 	  } 
}
