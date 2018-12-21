package viewGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

/**
 * JPanel affiché quand on lance une partie multijoueur.
 */
@SuppressWarnings("serial")
public class IntroMulti extends JPanel implements ActionListener{
	
	private RoundJTextField adressIp;
	private RoundJTextField port;
	private Button btnMenu;
	private Background bg;
	private MainFrame mf;
	private ServeurSocket ss;
	private ClientSocket cs;
	private JTextArea txtrConsole;
	private Board b;
	private JButton btnClient;
	private JButton btnServeur;

	/**
	 * Création du JPanel.
	 * @param mf Fenêtre principale de l'application.
	 */
	public IntroMulti(MainFrame mf){
		this.mf = mf;
		this.b = new Board(mf);
		
		this.setLayout(null);
		
		btnServeur = new Button("serveur");
		btnServeur.setBounds((Param.FRAMEWIDTH/3)-(193/2), (4*Param.FRAMEHEIGHT/10)-(54), 193, 54);
		btnServeur.addActionListener(this);
		add(btnServeur);
		
		btnClient = new Button("client");
		btnClient.setBounds((2*Param.FRAMEWIDTH/3)-(193/2), (4*Param.FRAMEHEIGHT/10)-(54), 193, 54);
		btnClient.addActionListener(this);
		add(btnClient);
		
		Param.ADRESSEIP = getIp();
		adressIp = new RoundJTextField();
		adressIp.setHorizontalAlignment(SwingConstants.CENTER);
		adressIp.setFont(new Font("Arial", Font.BOLD, 23));
		adressIp.setText(Param.ADRESSEIP);
		adressIp.setBounds((Param.FRAMEWIDTH/2)-((247+113+20)/2), (2*Param.FRAMEHEIGHT/10)-(72), 247, 72);
		adressIp.setColumns(10);
		adressIp.setForeground(Color.WHITE);
		adressIp.setBackground(Color.BLACK);
		this.add(adressIp);
		
		port = new RoundJTextField();
		port.setHorizontalAlignment(SwingConstants.CENTER);
		port.setText(Param.NUMPORT+"");
		port.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		port.setColumns(10);
		port.setBounds((Param.FRAMEWIDTH/2)-((247+113+20)/2)+247+20, (2*Param.FRAMEHEIGHT/10)-(72), 113, 72);
		this.add(port);
		port.setBackground(Color.BLACK);
		port.setForeground(Color.WHITE);
		
		btnMenu = new Button("menu");
		btnMenu.setBounds((Param.FRAMEWIDTH/2)-(269/2), (9*Param.FRAMEHEIGHT/10)-(54), 193, 54);
		btnMenu.addActionListener(this);
		this.add(btnMenu);
		
		txtrConsole = new JTextArea();
		txtrConsole.setBackground(Color.BLACK);
		txtrConsole.setForeground(Color.WHITE);
		//txtrConsole.setText("console");
		txtrConsole.setBounds((Param.FRAMEWIDTH/2)-(500/2), (7*Param.FRAMEHEIGHT/11)-(72), 500, 150);
		txtrConsole.setEditable(false);
		this.add(txtrConsole);
		
		bg = new Background();
		this.add(bg);
	}
	/**
	 * Retrouve l'adresse ip locale.
	 * @return Adresse ip locale si l'hôte est connecté.
	 */
	public String getIp(){
		try {
			String adr = Inet4Address.getLocalHost().getHostAddress();
			if(adr.equals("127.0.0.1")){
				btnClient.setEnabled(false);
				btnServeur.setEnabled(false);
				return "Pas de connexion";
			}else{
				return adr;
			}
		} catch (UnknownHostException e) {
			return "erreur inconnue";
		}
	}
	/**
	 * Lance le plateau multijoueur en mode serveur.
	 * @param ss Socket serveur.
	 */
	public void go(ServeurSocket ss) {
		Multi jeu = new Multi(mf, ss, b);
		mf.getContentPane().add(jeu, "jeu");
		mf.getCd().show(mf.getContentPane(), "jeu");
		ss.ecrireSurTousLesClients("case,;,"+Param.NBCASES+",;,"+Param.NBCOLORS);
		b.setMulti(jeu);
		b.passTurn();
	}
	/**
	 * Lance le plateau en mode client.
	 * @param cs Socket client
	 */
	public void go(ClientSocket cs) {
		Multi jeu = new Multi(mf, cs, b);
		mf.getContentPane().add(jeu, "jeu");
		mf.getCd().show(mf.getContentPane(), "jeu");
		b.setMulti(jeu);
		b.passTurn();
	}
	/**
	 * Gestion des clics sur les boutons.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "serveur" :
			try {
				Param.NUMPORT = Integer.parseInt(port.getText());
				this.ss = new ServeurSocket(this, mf);
				this.b.setSs(ss);
				this.ss.setB(b);
				txtrConsole.append("\nLe serveur attend un client.\nAdresse IP du serveur : "+getIp()+"\nNuméro de port : "+Param.NUMPORT);
				btnClient.setEnabled(false);
				btnClient.setText(null);
			} catch (IOException e1) {
				txtrConsole.append("\nLe serveur n'a pas pu se lancer.");
			}
			break;
		case "client" :
			Param.ADRESSEIP = adressIp.getText();
			Param.NUMPORT = Integer.parseInt(port.getText());
			try {
				this.cs = new ClientSocket(this, b, mf);
				b.setCs(cs);
				this.cs.setB(b);
			} catch (IOException e2) {
				txtrConsole.append("\nImpossible de se connecter au serveur.");
			}
			break;
		case "menu" :
			if((ss!=null)&&(!ss.isClosed())){
				try {
					ss.close();
				} catch (IOException e1) {
				}
			}
			if((cs!=null)&&(!cs.isClosed())){
				try {
					cs.close();
				} catch (IOException e1) {
				}
			}
			mf.menu();
			break;
		default:
			break;
		}
	}
}