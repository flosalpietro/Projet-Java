package viewGraphique;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * JPanel du mode multijoueur.
 */
@SuppressWarnings("serial")
public class Multi extends JPanel implements ActionListener{
	
	private MainFrame mf;
	private Board b;
	private Background bg = new Background();
	private Button btnMenu;
	private ServeurSocket ss;
	private ClientSocket cs;
	private Button btnPass;
	private JLabel error;
	private JLabel rulesLbl;
	private JLabel turnLbl;
	
	/**
	 * Construction du JPanel Multijoueur en mode serveur.
	 * @param mf Fen�tre principale de l'application.
	 * @param ss Socket du serveur.
	 * @param b Plateau de jeu.
	 */
	public Multi(MainFrame mf, ServeurSocket ss, Board b) {
		this.b = b;
		createInterface(mf);
		this.ss = ss;
	}
	/**
	 * Construction du JPanel Multijoueur en mode client.
	 * @param mf Fen�tre principale de l'application.
	 * @param cs Socket du client.
	 * @param b Plateau de jeu.
	 */
	public Multi(MainFrame mf, ClientSocket cs, Board b) {
		this.b = b;
		createInterface(mf);
		this.cs = cs;
	}
	/**
	 * Cr�ation de l'interface utilisateur g�n�rale.
	 * @param mf fen�tre principale de l'application.
	 */
	public void createInterface(MainFrame mf) {
		this.setLayout(null);
		this.mf = mf;
		b.setBounds((Param.FRAMEWIDTH/2)-(350/2), 0, 350, Param.FRAMEHEIGHT);
		this.add(b);
		
		btnMenu = new Button("menu");
		btnMenu.setBounds(Param.FRAMEWIDTH-250, 50, 193, 54);
		btnMenu.addActionListener(this);
		this.add(btnMenu);
		
		btnPass = new Button("passeTour");
		btnPass.setBounds(Param.FRAMEWIDTH-250, 150, 193, 54);
		btnPass.addActionListener(this);
		this.add(btnPass);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setFont(new Font("Tahoma", Font.BOLD, 15));
		error.setBounds(Param.FRAMEWIDTH-250, 300, 200, 20);
		this.add(error);
		
		turnLbl = new JLabel("");
		turnLbl.setBounds(Param.FRAMEWIDTH-250, 250, 200, 20);
		turnLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		turnLbl.setForeground(Color.WHITE);
		this.add(turnLbl);
		
		this.add(bg);
	}
	/**
	 * Getter du JLabel error.
	 * @return JLabel des erreurs.
	 */
	public JLabel getError() {
		return error;
	}
	/**
	 * Change le texte du JLabel de tour.
	 * @param txt Texte � mettre dans le JLabel.
	 */
	public void setTurnLbl(String txt) {
		this.turnLbl.setText(txt);
	}
	/**
	 * Gestion des clics sur les diff�rents boutons.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "menu" :
			try {
				if((ss!=null)&&(!ss.isClosed())){
					ss.ecrireSurTousLesClients("deconnecte,;,1");
					ss.close();
				}
				if((cs!=null)&&(!cs.isClosed())){
					cs.ecrire("deconnecte,;,1");
					cs.close();
				}
			} catch (IOException e1) {
				System.out.println("Impossible de fermer le socket.");
			}
			mf.menu();
			break;
		case "passeTour" : 
			if(b.getTurn()){
				System.out.println("call passtour de multi");
				b.passTurn();
				b.send("passturn,;,1");
			}
			break;
		default:
			break;
		}
	}

}
