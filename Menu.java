
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
		          
		           
		     
		     switch (selection){
		           
		         case 1:
		        	  jeuSolo();
		              sousMenu();
		              break;
		           
		      
		         case 2:
		        	  System.out.println(Param.RULES_CONS);
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
				b1.resultLine.createRandom();
				
				
				while(!win && b1.currLine <Param.NBLINES) {
				
				b1.propLine.Prop();
				
				System.out.println("==============Combinaison secrète ===========");
				for (int i=0;i<Param.NBCASES;i++) {
					System.out.print(b1.resultLine.getCase(i).getColor());
					
				}
				System.out.println("");
				System.out.println("================Votre proposition numero:"+b1.currLine+1+"=====================");
				for (int i=0;i<Param.NBCASES;i++) {
				System.out.print(b1.propLine.getCase(i).getColor());
				}
				System.out.println();
				
				System.out.println("========Resultat==========");
				b1.addLine();
				b1.currProp=1;
				if(b1.results[b1.currLine].getScore() == Param.NBCASES){
					if(b1.turn){
						b1.win();
						win = true;
					}else{
						b1.lose();
						win = true;
					}
					if(b1.currLine==Param.NBLINES-1 && (!(b1.results[b1.currLine].getScore() == Param.NBCASES)))b1.lose();
					b1.currLine++;
				}
				System.out.println();
				
				System.out.println("========vos combinaisons précédentes: ===========");
				
				b1.previous_Prop();
				
				if(b1.currLine==9) {
					System.out.println("ATTENTION dernier essais");
				}
	            
				}
				
		  }
	}


