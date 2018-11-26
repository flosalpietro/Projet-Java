package jeu2;

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
	
	public Case() {
		randomColor();
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
	
}
