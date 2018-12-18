/**
 * 
 */
package model;

/**
 * @author Florence
 *
 */
public class Param {
	
	/**
	 * String des r�gles du jeu.
	 */
	public static String RULES = "<html><p>Le Mastermind est un jeu qui se joue habituellement � deux, le joueur 2 �tant l�arbitre du premier.</p><p>Le but du jeu est de deviner une s�quence de 4 pions color�s en un minimum d�essai.</p></br><p>Ici c�est l�g�rement diff�rent, puisque l� � arbitre � en question, c�est le jeu.</p><p>Dans ce jeu, vous serez capable de jouer � deux, tour � tour.</p><p>Vous serez capable aussi de choisir entre 4 et 6 pions par lignes et 6 � 10 couleurs diff�rentes.</p><p>A chaque tour, Une fois les pions plac�s, le jeu indique :</p><ul><li>Le nombre de pions de la bonne couleur bien plac�s en utilisant le m�me nombre de pions rouges.</li><li>Le nombre de pions de la bonne couleur, mais mal plac�s, avec les pions blancs.</li></ul></br><p>Le premier � trouver la s�quence de pions, sera le gagnant de la partie.</p></html>";
	
	
	public static String RULES_CONS = "<html><p>Le Mastermind est un jeu qui se joue habituellement � deux, mais ici l'on jouera contre le pc.Le but du jeu est de deviner une s�quence de 4 pions color�s en moins de 10 essaisIci l� � arbitre � en question, c�est le jeu.A chaque tour, Une fois les pions plac�s, le jeu indique:Le nombre de pions de la bonne couleur bien plac�s en utilisant '+' etle nombre de pions mal plac�s et/ou de mauvaise couleur par '-' .Si tu trouves la combinaisons en moins de 10 essais tu seras le gagnant de la partie.</p></html>";
	/**
	 * Tableau contenant les noms des couleurs dans l'ordre.
	 */
	public static String[] COLORS = {"Vide", "Rouge", "Bleu", "Vert", "Orange", "Jaune", "Blanc", "Rose", "Mauve" };

	/**
	 * Nombre de lignes d'essai pour trouver la r�ponse.
	 */
	public static int NBLINES = 10;
	
	/**
	 * Nombre de couleurs .
	 */
	public static int NBCOLORS = 6;
	
	/**
	 * Longueur du code.
	 */
	public static int NBCASES = 4;
	
	
}