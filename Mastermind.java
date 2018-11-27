package MasterM;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {
	private int nbCouleur;
	private int nbPions;
	private int nbEssais;
	private boolean estGagnant;
	private boolean redondance;
	private int essaiActuel;
	private int essaiActuel1;
	private int essaiActuel2;

	String lettreRegle = "vrbnmo";
	private String Essai;
	private String random;


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
  public Mastermind(int nbEssais, int nbPions, int nbCouleur, boolean estGagnant, boolean redondance, String random) {
    this.nbEssais = nbEssais;
      if (nbEssais < 1) {
          throw new IllegalArgumentException("Au moins 1 essai est requis!");
      }
    this.nbPions= nbPions ;
      if(nbPions != 4) {
    	  throw new IllegalArgumentException("Il doit y avoir 4 pions");
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
  public void sousMenu() {
      Scanner scanner = new Scanner (System.in);
      int select= scanner.nextInt();
      
	  switch (select) {
	  case 1:
		  menu();
		  break;
	  default:
		  System.out.println("enter a valid number");
		  sousMenu();
	  }
  }
  
  public void menu() {
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
        	  saisirEssai();
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
        	  System.out.println("press [1] to menu");
              sousMenu();
              break;
              
              
         case 3:
        	  System.out.println("en cours de développement");
              multi();
        	  System.out.println("press [1] to menu");
        	  Scanner back2 = new Scanner (System.in);
              sousMenu();
        	  break;
        	  
      
         case 4:
        	  System.out.println("Exit Successful");
              System.exit(0);
                      
         default:
        	 System.out.println("Please enter a valid selection.");
        	 menu();
         
     };
  }
  
//---------------------SOLO-----------------------------  
/*
* Generation du code secret   
*/
   public String generCode() {   
  	   Random rand = new Random();
  	   String lettreRegle = "vrbnmo";
		int longueur = lettreRegle.length();
		int l1 = rand.nextInt(longueur);
		char cc = lettreRegle.charAt(l1);
		int l2 = rand.nextInt(longueur);
		char cc2 = lettreRegle.charAt(l2);
		int l3 = rand.nextInt(longueur);
		char cc3 = lettreRegle.charAt(l3);
		int l4 = rand.nextInt(longueur);
		char cc4 = lettreRegle.charAt(l4);
		String mot=Character.toString(cc); 
		String mot1=Character.toString(cc2);
		String mot2=Character.toString(cc3);
		String mot3=Character.toString(cc4);
		
		return random = mot + mot1 +mot2 + mot3;
     } 
   
/*
 * methode pour comparer   
 */
   String rando = generCode();
   public void compare() {
	     //String rando = generCode();
	     String essaiPlayer = saisi();
		 for (int i = 0;i < 4; i++) {
		     essaiPlayer.charAt(i);
		     rando.charAt(i);
		     
			 if(essaiPlayer.charAt(i)==rando.charAt(i)) {
				 System.out.print("+");
			 } else {
				 System.out.print("-");
			 }
		 }
   }
   
/*
 * saisir l'essai
 */
   public String saisi() {
	   Scanner input = new Scanner(System.in);
	   System.out.println("saisir à nouveau votre essai:");
	   String Essai = input.nextLine();
	   
	   return Essai;
   }
/*
 * Saisir la combinaison que l'on veut rentrer dans le jeu
 * @param input Nous permet de rentrer le code  
 */
  
   public void saisirEssai() {
	   generCode();
       Scanner input = new Scanner(System.in);
       while (essaiActuel < nbEssais) {
    	   essaiActuel ++;
    	   System.out.println("");
    	   System.out.println("Voici les couleurs disponibles: [v]=vert [r]=rouge [b]=bleu [n]=noir [m]=mauve [o]=orange");
    	   System.out.println(" --> '+' signifie que vous avez trouvé la couleur à la bonne place et '-' indique l'inverse.");
           System.out.println("Essai "+ essaiActuel +":" );       
           String Essai = input.nextLine();
           System.out.println("Vous avez saisi:"+ Essai);
           compare();
           //System.out.println("Vous avez x pions bien placé et x bonnes couleurs");
           System.out.println(" ");
           
  		   if(rando.equals(Essai)){
  			   System.out.println("");
		       System.out.println("!!!  Vous avez gagné  !!!");
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
             	  menu();
        	   }
		  } 
           
           if(Essai.length() != 4) {
        	   System.out.println("Vous devez rentrer 4 caractères qui sont dans la liste de couleur, retentez!");
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
             	  menu();
        	   }
           }
       }
   }

//--------------------Multi-------------------------------------------
/*
 * saisie code joeur 1 et 2   
 * 
 */
      public String codePl1() {
          Scanner inputPl1 = new Scanner(System.in);
          System.out.println("Voici les couleurs disponibles: [v]=vert [r]=rouge [b]=bleu [n]=noir [m]=mauve [o]=orange");
   	   System.out.println("Joueur1 votre code secret pour player2:");
   	   String code1 = inputPl1.nextLine();
   	   
   	   return this.code1=code1;
      }
      
      public String codePl2() {
          Scanner inputPl2 = new Scanner(System.in);
          System.out.println("Voici les couleurs disponibles: [v]=vert [r]=rouge [b]=bleu [n]=noir [m]=mauve [o]=orange");
          System.out.println("Joueur2 votre code secret pour player1:");
   	   String code2 = inputPl2.nextLine();
   	   
   	   return this.code2=code2;
      }   
        private String code1;
    	private String code2;
/*
 * saisie essai joeur 1 et 2   
 */
       public String saisiPl1() {
          Scanner input1 = new Scanner(System.in);
    	   System.out.println("Joueur1 écrire à nouveau votre essai:");
      	   String EssaiPl1 = input1.nextLine();
      	   
      	   return EssaiPl1;
         }
         
       public String saisiPl2() {
    	   Scanner input2 = new Scanner(System.in);
           System.out.println("Joueur2 écrire à nouveau votre essai:");
      	   String EssaiPl2 = input2.nextLine();
      	   
      	   return EssaiPl2;
         } 
       
/*
 * comparaison joueur 1 joueur 2       
 */
       public void comparePl1() {
  	     //String rando = generCode();
  	     String essaiPlayer1 = saisiPl1();
  		 for (int i = 0;i < 4; i++) {
  		     essaiPlayer1.charAt(i);
  		     code2.charAt(i);
  		     
  			 if(essaiPlayer1.charAt(i)==code2.charAt(i)) {
  				 System.out.print("+");
  			 } else {
  				 System.out.print("-");
  			 }
  		 }
   }   
     public void comparePl2() {
  	     //String rando = generCode();
  	     String essaiPlayer2 = saisiPl2();
  		 for (int i = 0;i < 4; i++) {
  		     essaiPlayer2.charAt(i);
  		     code1.charAt(i);
  		     
  			 if(essaiPlayer2.charAt(i)==code1.charAt(i)) {
  				 System.out.print("+");
  			 } else {
  				 System.out.print("-");
  			 }
  		 }
  }
//jeu en multi
     public void multi() {
    	 Scanner input = new Scanner(System.in);
    	 codePl1();
    	 codePl2();
    	 while(essaiActuel1 < nbEssais && essaiActuel2 < nbEssais) {
    		 essaiActuel1++;
      	     System.out.println("Voici les couleurs disponibles: [v]=vert [r]=rouge [b]=bleu [n]=noir [m]=mauve [o]=orange");
      	     System.out.println(" --> '+' signifie que vous avez trouvé la couleur à la bonne place et '-' indique l'inverse.");
             System.out.println("Joueur 1 Essai "+ essaiActuel1 +":" );
             String Essai = input.nextLine();
             System.out.println("Vous avez saisi:"+ Essai);
             
             if(Essai.length() != 4) {
            	   System.out.println("Vous devez rentrer 4 caractères!");
            	  }
             
             comparePl1();
             System.out.println("");
             essaiActuel2++;
      	     System.out.println("Voici les couleurs disponibles: [v]=vert [r]=rouge [b]=bleu [n]=noir [m]=mauve [o]=orange");
      	     System.out.println(" --> '+' signifie que vous avez trouvé la couleur à la bonne place et '-' indique l'inverse.");
             System.out.println("Joueur 2 Essai "+ essaiActuel2 +":" );
             String Essai2 = input.nextLine();
             System.out.println("Vous avez saisi:"+ Essai2);
             
             if(Essai2.length() != 4) {
                 System.out.println("Vous devez rentrer 4 caractères!");
                 }
             
             comparePl2();
             System.out.println("");
             
             
             
             if (essaiActuel1 == 10 && essaiActuel2 == 10) {
               System.out.println("");
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
               	  menu();
          	   }
             }
    		   
             if(code2.equals(Essai)&&code1.equals(Essai2)){
      			   System.out.println("");
    		       System.out.println("!!!  Joueur 1 et 2 - Vous avez gagné  !!!");
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
                 	  menu();
            	   }
    		  } 
             if(code2.equals(Essai)){
      			   System.out.println("");
    		       System.out.println("!!!  Joueur 1 - Vous avez gagné  !!!");
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
                 	  menu();
            	   }
    		  } 
    		   if(code1.equals(Essai)){
      			   System.out.println("");
    		       System.out.println("!!!  Joueur 2 -Vous avez gagné  !!!");
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
                 	  menu();
            	   }
    		  } 
    	 }	 
    	 
     }

//---------------------------------------------------------------------------------------     
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

//----------------------------------------------------------------------------------------   
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
	
	public String getEssai() {
		return Essai;
	}

	public void setEssai(String essai) {
		Essai = essai;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}
    public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public int getEssaiActuel1() {
		return essaiActuel1;
	}

	public void setEssaiActuel1(int essaiActuel1) {
		this.essaiActuel1 = essaiActuel1;
	}

	public int getEssaiActuel2() {
		return essaiActuel2;
	}

	public void setEssaiActuel2(int essaiActuel2) {
		this.essaiActuel2 = essaiActuel2;
	}

}
