/**
 * 
 */
package test;

import model.MastermindModel;
import controller.MastermindController;
import view.MastermindViewConsole;
import view.MastermindViewGUI; 

/**
 * @author Florence
 *
 */
public class Mvc {


	public  static  void main(String[] args) {
		
		MastermindModel mod = new MastermindModel();
		
		
		MastermindController contConsol = new MastermindController(mod);
		// MastermindController contGUI = new MastermindController(mod);
		
		MastermindViewConsole viewConsol = new MastermindViewConsole(mod, contConsol);
	//	MastermindViewGUI viewGUI = new MastermindViewGUI(mod, contGUI);

		
		
		
	}

}

