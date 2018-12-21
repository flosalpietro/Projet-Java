package viewGraphique;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;



/**
 * Contient les informations du client connect� au serveur.
 * 
 
 */
public class ClientServerSide implements Runnable{
	/**
	 * Socket du serveur.
	 */
	private Socket socket;
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
	private MainFrame mf;
	/**
	 * Constructeur du client.
	 * @param socket Socket du serveur.
	 * @param b Plateau de jeu.
	 * @param mf Fen�tre principale de l'application.
	 */
	public ClientServerSide(Socket socket, Board b, MainFrame mf){
		this.b = b;
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Impossible de cr�er le stream de lecture.");
		}
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Impossible de cr�er le stream d'�criture.");
		}
		new Thread(this).start();
		this.mf = mf;
	}
	/**
	 * Ecrire sur le client.
	 * @param o Objet � �crire.
	 */
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			System.out.println("\nImpossible d'�crire sur le client.");
		}
	}
	/**
	 * Lire sur le client.
	 * @return objets lus.
	 */
	public Object lire(){
		try {
			return ois.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("\nErreur inconnue");
		} catch (IOException e) {
			System.out.println("\nImpossible de lire les objets.");
		}
		return null;
	}
	/**
	 * Thread permettant de lire les objets re�us et les envoyer au plateau de jeu.
	 */
	public void run() {
		while (!socket.isClosed()){
			try {
				Object o = ois.readObject();
				if(o!=null)b.processReceivedObject(o);
			} catch (ClassNotFoundException e) {
				System.out.println("\nErreur inconnue");
			} catch (IOException e) {
				try {
					JOptionPane.showMessageDialog(null, "Le client s'est d�connect�.");
					socket.close();
					mf.menu();
				} catch (IOException e1) {
					System.out.println("\nImpossible de stopper le serveur.");
				}
			}
		}
	}
}