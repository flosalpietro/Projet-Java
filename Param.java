package jeu2;

public class Param {
	
	/**
	 * String des règles du jeu.
	 */
	public static String RULES = "<html><p>Le Mastermind est un jeu qui se joue habituellement à deux, le joueur 2 étant l’arbitre du premier.</p><p>Le but du jeu est de deviner une séquence de 4 pions colorés en un minimum d’essai.</p></br><p>Ici c’est légèrement différent, puisque l’ « arbitre » en question, c’est le jeu.</p><p>Dans ce jeu, vous serez capable de jouer à deux, tour à tour.</p><p>Vous serez capable aussi de choisir entre 4 et 6 pions par lignes et 6 à 10 couleurs différentes.</p><p>A chaque tour, Une fois les pions placés, le jeu indique :</p><ul><li>Le nombre de pions de la bonne couleur bien placés en utilisant le même nombre de pions rouges.</li><li>Le nombre de pions de la bonne couleur, mais mal placés, avec les pions blancs.</li></ul></br><p>Le premier à trouver la séquence de pions, sera le gagnant de la partie.</p></html>";
	
	
	/**
	 * Tableau contenant les noms des couleurs dans l'ordre.
	 */
	public static String[] COLORS = {"Vide", "Rouge", "Bleu", "Vert", "Orange", "Jaune", "Blanc", "Rose", "Mauve" };

	/**
	 * Nombre de lignes d'essai pour trouver la réponse.
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
