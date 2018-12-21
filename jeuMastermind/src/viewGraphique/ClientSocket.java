package viewGraphique;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;


/**
 * Socket du client.
 */
public class ClientSocket extends Socket implements Runnable {
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	
	/**
	 * Plateau de jeu.
	 */
	private Board b;
	/**
	 * Fenêtre principale de l'application.
	 */
	private MainFrame mf;
	/**
	 * Construit le Socket client.
	 * @param multi JPanel multijoueur.
	 * @param b Plateau de jeu.
	 * @param mf Fenêtre principale de l'application.
	 * @throws IOException Erreurs de construction de l'objet Socket.
	 * @throws UnknownHostException Erreurs de construction de l'objet Socket.
	 */
	public ClientSocket(IntroMulti multi, Board b,MainFrame mf) throws UnknownHostException, IOException{
		super(Param.ADRESSEIP,Param.NUMPORT);
		try {
			oos = new ObjectOutputStream(this.getOutputStream());
			ois = new ObjectInputStream(this.getInputStream());
			this.lireNonStop();
			multi.go(this);
			this.mf =mf;
		} catch (IOException e) {
			System.out.println("\nImpossible de créer les streams.");
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
	 * @param o Objet à envoyer.
	 */
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			System.out.println("\nImpossible d'écrire au serveur.");
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
				JOptionPane.showMessageDialog(null, "Le serveur s'est déconnecté.");
				this.close();
				mf.menu();
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
	 * Thread permettant de lire les objets reçus et de les envoyer au plateau de jeu.
	 */
	public void run() {
		while (!this.isClosed()){
			Object o = this.lire();
			if(o!=null)b.processReceivedObject(o);
		}
	}
}