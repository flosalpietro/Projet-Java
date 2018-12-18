/**
 * 
 */
package test;

import model.MastermindModel;
import controller.MastermindController;
import view.MastermindViewConsole; 

/**
 * @author Florence
 *
 */
public class Mvc {

	protected static MastermindController controller;
	

	public  static  void main(String[] args) {
		controller.play();
	}

}

