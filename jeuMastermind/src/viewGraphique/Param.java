package viewGraphique;

public class Param {
	
	
	public static String RULES = "<html><p>Le Mastermind est un jeu qui se joue habituellement � deux, le joueur 2 �tant l�arbitre du premier.</p><p>Le but du jeu est de deviner une s�quence de 4 pions color�s en un minimum d�essai.</p></br><p>Ici c�est l�g�rement diff�rent, puisque l� � arbitre � en question, c�est le jeu.</p><p>Dans ce jeu, vous serez capable de jouer � deux, tour � tour.</p><p>Vous serez capable aussi de choisir entre 4 et 6 pions par lignes et 6 � 10 couleurs diff�rentes.</p><p>A chaque tour, Une fois les pions plac�s, le jeu indique :</p><ul><li>Le nombre de pions de la bonne couleur bien plac�s en utilisant le m�me nombre de pions rouges.</li><li>Le nombre de pions de la bonne couleur, mais mal plac�s, avec les pions blancs.</li></ul></br><p>Le premier � trouver la s�quence de pions, sera le gagnant de la partie.</p></html>";
	public static String[] COLORS = {"Vide", "Rouge", "Bleu", "Vert", "Orange", "Jaune", "Blanc", "Rose", "Mauve" };
	public static int NBLINES = 10;
	public static int NBCOLORS = 6;
	public static int NBCASES = 4;
	public static int FRAMEWIDTH = 900;
	public static int FRAMEHEIGHT=700;
	public static int ECARTRONDS = 2;
	public static int TAILLEROND = 30;
	public static String ADRESSEIP = "192.168.0.";
	public static int NUMPORT = 12345;
	public static String TXTTURNN = "Ce n'est pas votre tour";
	public static String TXTTURNY = "C'est � vous de jouer.";
	
}