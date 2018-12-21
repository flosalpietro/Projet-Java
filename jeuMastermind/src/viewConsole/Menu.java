package viewConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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
				try {
					multi();
					multi2();
					multi();
					multi2();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				b1.resultLine.createRandom();
				
				
				while(!win && b1.currLine <Param.NBLINES) {
				
				b1.propLine.Prop();
				
				System.out.println("==============Combinaison secrète ===========");
				for (int i=0;i<Param.NBCASES;i++) {
					System.out.print(b1.resultLine.getCase(i).getColor());
					
				}
				System.out.println("");
				System.out.println("================Votre proposition numero:"+(b1.currLine+1)+"=====================");
				for (int i=0;i<Param.NBCASES;i++) {
				System.out.print(b1.propLine.getCase(i).getColor());
				}
				System.out.println();
				
				System.out.println("========Resultat==========");
				b1.addLine();
				b1.currProp=1;
					
				System.out.println();
				
				System.out.println("========vos combinaisons précédentes: ===========");
				
				b1.previous_Prop();
				
				System.out.println("");
				if(b1.currLine>9) {
					b1.lose();
					win = true;
				}
				if(b1.currLine==9) {
					System.out.println("ATTENTION dernier essais");
				}
	            if(b1.propLine.getCase(0).getColor() + b1.propLine.getCase(1).getColor() + b1.propLine.getCase(2).getColor() + b1.propLine.getCase(3).getColor() == b1.resultLine.getCase(0).getColor() + b1.resultLine.getCase(1).getColor() + b1.resultLine.getCase(2).getColor() + b1.resultLine.getCase(3).getColor()) {
	            	b1.win();
	            	win = true;
	            }
	            
				}
				
		  }
		  
		  public void multi() throws IOException{
				Socket s = new Socket("localhost", 4998);
				int testt = 1;
				PrintWriter pr = new PrintWriter(s.getOutputStream());
				pr.println(testt);
				pr.flush();
				
				 InputStreamReader in = new InputStreamReader(s.getInputStream());
				 BufferedReader bf = new BufferedReader(in);
				 
				 String str = bf.readLine();
				 System.out.println("server répond à joueur1:"+str);
				 
				 s.close();
		  }
		  static int testt2=0;
		  public void multi2() throws IOException{
				Socket s = new Socket("localhost", 4998);
				Board b1 = new Board();
				//int testt = 2;
				testt2 = testt2 +1;
				PrintWriter pr = new PrintWriter(s.getOutputStream());
				pr.println(testt2);
				pr.flush();
				
				 InputStreamReader in = new InputStreamReader(s.getInputStream());
				 BufferedReader bf = new BufferedReader(in);
				 
				 String str = bf.readLine();
				 System.out.println("server répond à joueur2:"+str+" pour votre proposition qui est:"+testt2);
				 
				 s.close();
		  }
	}




