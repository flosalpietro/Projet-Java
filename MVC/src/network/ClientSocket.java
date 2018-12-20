/**
 * 
 */
package network;

/**
 * @author Florence
 *
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import model.Board;
import model.Param;


/**
 * Socket du client.
 * 
 * 
 */
public class ClientSocket extends Socket implements Runnable {
	/**
	 * Stream de rentr�e d'objets par le socket.
	 */
	private ObjectInputStream ois;
	/**
	 * Stream de sortie d'objets par le socket.
	 */
	private ObjectOutputStream oos;
	/**
	 * Plateau de jeu.
	 */
	private Board b;
	/**
	 * Fen�tre principale de l'application.
	 */
	private Menu mf;
	/**
	 * Construit le Socket client.
	 * @param multi JPanel multijoueur.
	 * @param b Plateau de jeu.
	 * @param mf Fen�tre principale de l'application.
	 * @throws IOException Erreurs de construction de l'objet Socket.
	 * @throws UnknownHostException Erreurs de construction de l'objet Socket.
	 */
	public ClientSocket( Board b) throws UnknownHostException, IOException{
		super(Param.ADRESSEIP,Param.NUMPORT);
		try {
			oos = new ObjectOutputStream(this.getOutputStream());
			ois = new ObjectInputStream(this.getInputStream());
			this.lireNonStop();
			
			
		} catch (IOException e) {
			System.out.println("\nImpossible de cr�er les streams.");
		}
	}
	/**
	 * Lancement du thread de lecture.
	 */
	public void lireNonStop(){
		new Thread(this).start();
	}
	/**
	 * Envoyer un objet au serveur.
	 * @param o Objet � envoyer.
	 */
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			System.out.println("\nIMpossible d'�crire au serveur.");
		}
	}
	/**
	 * Lire un objet sur le serveur.
	 * @return L'objet lu.
	 */
	public Object lire(){
		try {
			Object o = ois.readObject();
			return o;
		} catch (IOException e) {
			try {
				JOptionPane.showMessageDialog(null, "Le serveur s'est d�connect�.");
				this.close();
				mf.menuFirst();
			} catch (IOException e1) {
				System.out.println("\nImpossible de fermer le socket.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("\nErreur inconnue.");
		}
		return null;
	}
	/**
	 * Changer la valeur du plateau.
	 * @param b Plateau de jeu.
	 */
	public void setB(Board b) {
		this.b = b;
	}
	/**
	 * Thread permettant de lire les objets re�us et les envoyer au plateau de jeu.
	 */
	public void run() {
		while (!this.isClosed()){
			Object o = this.lire();
			
		}
	}
}