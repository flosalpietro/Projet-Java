/**
 * 
 */
package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import java.util.*;

import controller.MastermindController;
import model.Board;
import model.MastermindModel;
import model.Param;


/**
 * @author Florence
 *
 */
public class MastermindViewConsole extends MastermindView implements Observer{

	public MastermindViewConsole(MastermindModel model, MastermindController control) {
		super(model, control);
		new Thread(this).start();
	}


	
	/**
	 * Lance l'application 
	 */
	public void init() {
		clear();
		System.out.println("Bienvenue dans MasterMind!");
		menuFirst();
		
	}
	
	/**
	 * Menu qui permet de gèrer le jeu  
	 */
	  public void sousMenu() {
		  System.out.println("press [1] to menu");
	      Scanner scanner = new Scanner (System.in);
	      int select= scanner.nextInt();
	      
		  switch (select) {
		  case 1:
			  menuFirst();
			  break;
		  default:
			  System.out.println("enter a valid number");
			  sousMenu();
		  }
	  }
	
	  public void menuFirst() {
	      System.out.println("Please Make a selection:"); 
	      System.out.println("[1] Play solo"); 
	      System.out.println("[2] Rules"); 
	      System.out.println("[3] Multiplayer");
	      System.out.println("[4] Exit"); 
	      System.out.println("Selection: "); 
	      
	      Scanner scanner = new Scanner (System.in);
	      int selection= scanner.nextInt();
	          
	           
	     
	     switch (selection){
	           
	         case 1:
	        	  jeuSolo();
	              sousMenu();
	              break;
	           
	      
	         case 2:
	        	  System.out.println("Multiplayer:");
	        	  System.out.println("");
	        	  System.out.println("Le Mastermind est un jeu qui se joue habituellement à deux,");
	        	  System.out.println("Le but du jeu est de deviner une séquence de 4 pions colorés en un minimum d’essai.");
	        	  System.out.println("Ici c’est légèrement différent, puisque l’ « arbitre » en question, c’est le jeu.");
	        	  System.out.println("Dans ce jeu, vous serez capable de jouer à deux, tour à tour.");
	        	  System.out.println("A chaque tour, Une fois les pions placés, le jeu indique: Le nombre de pions de la bonne couleur bien placés en utilisant '+'");
	        	  System.out.println("Le premier à trouver la séquence de pions, sera le gagnant de la partie.");
	        	  System.out.println("");
	        	  System.out.println("Solo:");
	        	  System.out.println("");
	        	  System.out.println("Le Mastermind est un jeu qui se joue habituellement à deux, mais ici l'on jouera contre le pc");
	        	  System.out.println("Le but du jeu est de deviner une séquence de 4 pions colorés en moins de 10 essais");
	        	  System.out.println("Ici l’ « arbitre » en question, c’est le jeu.");
	        	  System.out.println("A chaque tour, Une fois les pions placés, le jeu indique:");
	        	  System.out.println("Le nombre de pions de la bonne couleur bien placés en utilisant '+' et");
	        	  System.out.println("le nombre de pions mal placés et/ou de mauvaise couleur par '-' .");
	        	  System.out.println("Si tu trouves la combinaisons en moins de 10 essais tu seras le gagnant de la partie.");
	        	  System.out.println("");
	        	  sousMenu();
	              break;
	              
	              
	         case 3:
	        	  System.out.println("en cours de développement");
	              //multi();
	              sousMenu();
	        	  break;
	        	  
	      
	         case 4:
	        	  System.out.println("Exit Successful");
	              System.exit(0);
	                      
	         default:
	        	 System.out.println("Please enter a valid selection.");
	        	 menuFirst();
	         
	     };
	  }
	  
	  public void jeuSolo() {
			boolean win = false;	
			Board b1 = new Board();
			b1.getResultLine().createRandom();
			
			
			while(!win && b1.getCurrLine() <Param.NBLINES) {
			
			b1.getPropLine().Prop();
			
			System.out.println("==============Combinaison secrète ===========");
			for (int i=0;i<Param.NBCASES;i++) {
				System.out.print(b1.getResultLine().getCase(i).getColor());
				
			}
			System.out.println("");
			System.out.println("================Votre proposition numero:"+(b1.getCurrLine()+1)+"=====================");
			for (int i=0;i<Param.NBCASES;i++) {
			System.out.print(b1.getPropLine().getCase(i).getColor());
			}
			System.out.println();
			
			System.out.println("========Resultat==========");
			b1.addLine();
			b1.setCurrProp(1);
				
			System.out.println();
			
			System.out.println("========vos combinaisons précédentes: ===========");
			
			b1.previous_Prop();
			
			System.out.println("");
			if(b1.getCurrLine()>9) {
				b1.lose();
				win = true;
			}
			if(b1.getCurrLine()==9) {
				System.out.println("ATTENTION dernier essais");
			}
            if(b1.getPropLine().getCase(0).getColor() + b1.getPropLine().getCase(1).getColor() + b1.getPropLine().getCase(2).getColor() + b1.getPropLine().getCase(3).getColor() == b1.getResultLine().getCase(0).getColor() + b1.getResultLine().getCase(1).getColor() + b1.getResultLine().getCase(2).getColor() + b1.getResultLine().getCase(3).getColor()) {
            	b1.win();
            	win = true;
            }
            
			}
			
	  }
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void run(){
		init();
	}
		
	/**
	 * Vide la console  
	 */
	private void clear() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	/**
	 * Exit le programme
	 */
	private void exit(){
		System.exit(0);
	}


}


