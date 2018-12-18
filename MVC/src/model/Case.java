/**
 * 
 */
package model;

/**
 * @author Florence
 *
 */


public class Case {
	
	/**
	 * Couleur de la case.
	 */
	protected int color;
	
	/**
	 * Constructeur d'une case avec la couleur "numColor".
	 * @param numColor Couleur de la case.
	 */
	public Case(int numColor) {
		this.color = numColor;
	}
	
	/**
	 * Constructeur d'une case 
	 */
	public Case() {
		
	}
	
	
	/**
	 * Choisit une couleur aléatoire pour la case.
	 */
	public void randomColor(){
		int min = 1;
		int max=Param.NBCOLORS;
		int random = min + (int)(Math.random() * ((max - min) + 1));

		this.color = random;
	}
	
	/**
	 * Renvoie la couleur de la classe.
	 * @return La couleur de la classe.
	 */
	public int getColor(){
		return this.color;
	}
	
	/**
	 * Change la couleur de la case en la couleur passée en paramètre.
	 * @param numColor Numéro de la couleur voulue.
	 */
	public void setColor(int numColor){
		this.color = numColor;
	}
	
	
	
}
