package MasterM;

import java.util.Scanner;

public class Mastermind {
	private int nbCouleur;
	private int nbPions;
	private int nbEssais;
	private boolean estGagnant;
	private boolean redondance;
	private int essaiActuel;

/**
* Constructeur par défaut. Par défaut: redondance = false, nbPions = 4, nbEssais = 10, nbCouleurs = 6, estGagnant = false
*/	
  public Mastermind() {
	  nbCouleur = 6;
	  nbEssais = 10;
	  redondance = false;
	  estGagnant = false;
	  nbPions = 4;
	  essaiActuel = 0;
  } 	
  
/**
 * Constructeur pour paramétrer toutes les valeurs. Par de valeurs par défaut
 * @param nbEssai nombre d'essai donné au joueur
 * @param nbPions Longueur du code secret généré 
 * @param nbCouleurs Nombre de couleurs dans le jeu
 * @param estGagnant Par défaut sur false
 * @param redondance Si la redondance est autorisé ou non
*/
  public Mastermind(int nbEssais, int nbPions, int nbCouleur, boolean estGagnant, boolean redondance) {
    this.nbEssais = nbEssais;
      if (nbEssais < 1) {
          throw new IllegalArgumentException("Au moins 1 essai est requis!");
      }
    this.nbPions= nbPions ;
      if(nbPions != 4) {
    	  throw new IllegalArgumentException("Il doit y avoir 4 pions")
      }
    this.nbCouleur = nbCouleur;
    this.estGagnant = estGagnant;
    this.redondance = redondance;
    this.essaiActuel = 0;
  }  
  
/*
 * Methode qui lance le jeu;
 */
  
  public void play() {
	  System.out.println("Bienvenue dans MasterMind!");
	  menu();
  }
  
/**
 * Menu qui permet de gèrer le jeu  
 */
  public void menu() {
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
        	  saisirEssai();
              break;
           
      
         case 2:
        	  System.out.println("Voici les règles ...");
        	  System.out.println("press [1] to menu");
        	  Scanner back = new Scanner (System.in);
        	  int select = back.nextInt();
        	  
        	  switch (select) {
        	  case 1:
        		  menu();
        		  break;
        	  default:
        		  System.out.println("enter a valid number");
        	  }
              break;
              
              
         case 3:
        	  System.out.println("en cours de développement");
        	  System.out.println("press [1] to menu");
        	  Scanner back2 = new Scanner (System.in);
        	  int select2 = back2.nextInt();
        	  
        	  switch (select2) {
        	  case 1:
        		  menu();
        		  break;
        	  default:
        		  System.out.println("enter a valid number");}
        	  break;
        	  
      
         case 4:
        	  System.out.println("Exit Successful");
              System.exit(0);
                      
         default:
        	 System.out.println("Please enter a valid selection.");
         
     };
  }
  
/*
 * Saisir la combinaison que l'on veut rentrer dans le jeu
 * @param input Nous permet de rentrer le code  
 */
  
   public void saisirEssai() {
       Scanner input = new Scanner(System.in);
       while (essaiActuel < nbEssais) {
    	   essaiActuel ++;
           System.out.println("Essai "+ essaiActuel +":" );       
           String Essai = input.nextLine();
           System.out.println("Vous avez saisi:"+ Essai);
           
           if(Essai.length() != 4) {
        	   System.out.println("Vous devez rentrer 4 caractères, retentez!");
        	   essaiActuel --;
           }
           if (essaiActuel == 10) {
        	   System.out.println("Nombre d'essai maximum, vous avez perdu");
        	   System.out.println("");
        	   System.out.println("Please Make a selection:"); 
        	   System.out.println("[1] Menu"); 
        	   System.out.println("[2] Quit"); 
        	   
        	   Scanner finJeu = new Scanner (System.in);
        	   int select= finJeu.nextInt(); 
        	   switch(select) {
               case 1:
                  menu();
                  break;
                  
               case 2:
             	  System.out.println("Exit Successful");
                  System.exit(0);        
               default:
             	  System.out.println("Please enter a valid selection.");
        	   }
           }
       }
   }
   
/*
 * Renvois les messages de fin de jeu
 * @param gagnant Est à false tant que le joueur n'a pas gagné   
 */
   public void finJeu() {
	   boolean gagnant = false;
	   String messageFin;
	   if (gagnant = true) {
		   messageFin = "Vous avez gagné";
	   }
	   else {
		   messageFin = "Vous avez perdu";
	   }
   }
	
/*
 * Getters & Setters	
 */
	
	public int getNbCouleur() {
		return nbCouleur;
	}
	public void setNbCouleur(int nbCouleur) {
		this.nbCouleur = nbCouleur;
	}
	public int getNbPions() {
		return nbPions;
	}
	public void setNbPions(int nbPions) {
		this.nbPions = nbPions;
	}
	public int getNbEssais() {
		return nbEssais;
	}
	public void setNbEssais(int nbEssais) {
		this.nbEssais = nbEssais;
	}
	public boolean isEstGagnant() {
		return estGagnant;
	}
	public void setEstGagnant(boolean estGagnant) {
		this.estGagnant = estGagnant;
	}
	public boolean isRedondance() {
		return redondance;
	}
	public void setRedondance(boolean redondance) {
		this.redondance = redondance;
	}
	public int getEssaiActuel() {
		return essaiActuel;
	}

	public void setEssaiActuel(int essaiActuel) {
		this.essaiActuel = essaiActuel;
	}


}
