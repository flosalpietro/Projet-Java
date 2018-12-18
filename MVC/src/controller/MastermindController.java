/**
 * 
 */
package controller;

import java.awt.event.ActionListener;

import model.MastermindModel;
import view.MastermindView;
import view.MastermindViewConsole;


/**
 * @author Florence
 *
 */
public abstract class MastermindController implements ActionListener{

	protected MastermindModel model;
	protected MastermindViewConsole view;

	/**
	 * 
	 */
	public MastermindController(MastermindModel model, MastermindViewConsole view) {
		// TODO Auto-generated constructor stub
		this.model=model;
		this.view=view;
	}


	/*
	 * Methode qui lance le jeu;
	 */
	  
	  public void play() {
		  System.out.println("Bienvenue dans MasterMind!");
		  view.menuFirst();
	  }
}
