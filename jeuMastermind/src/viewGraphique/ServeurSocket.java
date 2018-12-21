package viewGraphique;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Socket du serveur.
 */
public class ServeurSocket extends ServerSocket implements Runnable {
	/**
	 * Chaine contenant les données des clients connectés au serveur.
	 */
	private ArrayList<ClientServerSide> listeClients = new ArrayList<ClientServerSide>();
	/**
	 * JPanel multijoueur.
	 */
	private IntroMulti multi;
	/**
	 * Plateau de jeu.
	 */
	private Board b;
	/**
	 * Fenêtre principale de l'application.
	 */
	private MainFrame mf;
	/**
	 * Constructeur qui permet de démarrer un serveur TCP sur le numéro de port se trouvant dans la classe Param.
	 * @param multi JPanel multijoueur.
	 * @param mf Fenêtre principale de l'application.
	 * @throws IOException Erreurs de construction de l'objet Socket.
	 */
	public ServeurSocket(IntroMulti multi, MainFrame mf) throws IOException {
		super(Param.NUMPORT);
		this.multi = multi;
		this.mf = mf;
		acceptePlusieursClients();
	}
	/**
	 * Méthode qui attend des clients pour les ajouter à la liste des clients connectés
	 */
	public void acceptePlusieursClients(){
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Permet d'écrire sur tous les clients.
	 * @param o Objet à envoyer.
	 */
	public void ecrireSurTousLesClients(Object o){
		for (ClientServerSide clientCoteServeur : listeClients) {
			clientCoteServeur.ecrire(o);
		}
	}
	/**
	 * Changer la valeur du plateau.
	 * @param b Plateau de jeu.
	 */
	public void setB(Board b) {
		this.b = b;
	}
	/**
	 * Thread attendant des clients voulant se connecter.
	 */
	public void run() {
		while (!this.isClosed()){
			try {
				ClientServerSide ccs = new ClientServerSide(this.accept(), b, mf);
				this.listeClients.add(ccs);
				multi.go(this);
				b.sendResults();
			} catch (IOException e) {
				
			}
		}
		
	}
}