/**
 * 
 */
package view;

import java.util.Observer;

import controller.MastermindController;
import model.MastermindModel;


/**
 * @author Florence
 *
 */
public abstract class MastermindView implements Observer, Runnable {

	protected MastermindModel model;
	protected MastermindController controller;

	/**
	 * 
	 */
	public MastermindView(MastermindModel model, MastermindController controller) {
		this.model=model;
		this.controller=controller;
		
		model.addObserver(this);

	}
	
	public abstract void init();



}

