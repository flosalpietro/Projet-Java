/**
 * 
 */
package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import model.Board;
import model.Param;
/**
 * Socket du serveur.
 */
public class ServeurSocket extends ServerSocket implements Runnable {
	/**
	 * Chaine contenant les donn�es des clients connect�s au serveur.
	 */
	private ArrayList<ClientServerSide> listeClients = new ArrayList<ClientServerSide>();
	
	/**
	 * Plateau de jeu.
	 */
	private Board b;
	
	/**
	 * Constructeur qui permet de d�marrer un serveur TCP sur le num�ro de port se trouvant dans la classe Param.
	 * @param multi JPanel multijoueur.
	 * @param mf Fen�tre principale de l'application.
	 * @throws IOException Erreurs de construction de l'objet Socket.
	 */
	public ServeurSocket() throws IOException {
		super(Param.NUMPORT);
		
		acceptePlusieursClients();
	}
	/**
	 * M�thode qui attend des clients pour les ajouter � la liste des clients connect�s
	 */
	public void acceptePlusieursClients(){
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Permet d'�crire sur tous les clients.
	 * @param o Objet � envoyer.
	 */
	public void ecrirSurTousLesClients(Object o){
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
				ClientServerSide ccs = new ClientServerSide(this.accept(), b);
				this.listeClients.add(ccs);
				
			} catch (IOException e) {
				
			}
		}
		
	}
}