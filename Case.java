package jeu2;

import java.util.Scanner;

import jeu2.Param;

public class Case {
	
	/**
	 * Couleur de la case.
	 */
	protected int color;
	
	/**
	 * Constructeur d'une case avec la couleur "numColor".
	 * @param numColor Couleur de la case.
	 */
	public Case() {
		this.color = createColor();
	}
	
	//public Case() {
		//randomColor();
	//}
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
	 * create color
	 */
	public int createColor() {
		//int colorCreate=0;
		Scanner scan = new Scanner(System.in);  
		String str = "";  
		System.out.print(" entrer une couleur: "); 
		str = scan.nextLine(); 
		System.out.println(str); 
		//String scan; 
		int colorCreate = Integer.parseInt(str);
		return colorCreate;
	}
	
	/**
	 * Renvoie la couleur de la classe.
	 * @return La couleur de la classe.
	 */
	public int getColor(){
		return this.color;
	}
	
}
