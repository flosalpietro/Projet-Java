package MasterM;

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
 * @param nombreEssai nombre d'essai donné au joueur
 * @param longueurCode Longueur du code secret généré 
 * @param minValeurCode Valeur min des valeurs du code (inclusive)
 * @param maxCodeValue Valeur max des valeurs du code (inclusive)
 * @param duplicationAutorise Si la duplication est autorisé ou non
*/
  public Mastermind(int nbEssais, int nbPions, int nbCouleur, boolean estGagnant, boolean redondance) {
      this.nbEssais = nbEssais;
      if (nbEssais < 1) {
          throw new IllegalArgumentException("Au moins 1 essai est requis!");
      }
  	this.nbPions= nbPions ;
    this.nbCouleur = nbCouleur;
    this.estGagnant = estGagnant;
    this.redondance = redondance;
    this.essaiActuel = 0;
  }  
  
/*
 * Différentes methodes à mettre en place  
 */
  
   //public saisirEssai() {}
   //public finJeu() {}
	
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
