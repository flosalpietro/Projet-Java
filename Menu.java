package jeu2;

import java.util.Scanner;

public class Menu {
	/*
	 * Methode qui lance le jeu;
	 */
	  
	  public void play() {
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
	          
	          //try {
	            //   selection =  scanner.nextInt();
	          //}catch(InputMismatchException e){
	        	//  System.out.println("enter a valid number");}
	           
	     
	     switch (selection){
	           
	         case 1:
	        	  jeuSolo();
	        	  System.out.println("en cours de developpement");
	              sousMenu();
	              break;
	           
	      
	         case 2:
	        	  System.out.println("Multiplayer:");
	        	  System.out.println("");
	        	  System.out.println("Le Mastermind est un jeu qui se joue habituellement à deux,");
	        	  System.out.println("le joueur 2 étant l’arbitre du premier.Le but du jeu est de deviner une séquence de 4 pions colorés en un minimum d’essai.");
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
		    int numProp = 0;
			Board b1 = new Board();
			b1.resultLine.createRandom();
			while(!win && numProp <= 10) {
			numProp++;
			b1.propLine.Prop();
			
			if(numProp>10) {
				System.out.println("Vous avez déja tenté 10x, vous avez perdu");
			}
			if(numProp==10) {
				System.out.println("ATTENTION dernier essais");
			}
			
			for (int i=0;i<Param.NBCASES;i++) {
				System.out.println(b1.resultLine.getCase(i).getColor());
			}
			System.out.println("================Votre proposition numero:"+numProp+"=====================");
			for (int i=0;i<Param.NBCASES;i++) {
			System.out.println(b1.propLine.getCase(i).getColor());
			}
			System.out.println("==================");
			b1.compare();
			
			}
			
	  }
}
