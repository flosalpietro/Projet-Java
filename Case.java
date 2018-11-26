package jeu;

import jeu.Param;

public class Case {
	
	/**
	 * Couleur de la case.
	 */
	protected static int color;
	
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
	public static void randomColor(){
		int min = 1;
		int max=Param.NBCOLORS;
		int random;
		random = min + (int)(Math.random() * ((max - min) + 1));
		color = random;
		
	}
	
	/**
	 * Renvoie la couleur de la classe.
	 * @return La couleur de la classe.
	 */
	public int getColor(){
		return this.color;
	}
	
	
}
