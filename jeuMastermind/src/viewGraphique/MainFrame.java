package viewGraphique;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Fenêtre principale de l'application.
 * 
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	/**
	 * Cardlayout de la fenêtre.
	 */
	private CardLayout cd;
	/**
	 * JPanel principal.
	 */
	private JPanel contentPane = new JPanel();
	/**
	 * Menu du jeu.
	 */
	private Menu menu;
	
	/**
	 * Lance l'application.
	 * @param args Argument de main.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Mastermind");
		setIconImage(new ImageIcon(getClass().getResource("/Ico.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setBounds(((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(Param.FRAMEWIDTH/2), ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(Param.FRAMEHEIGHT/2), Param.FRAMEWIDTH, Param.FRAMEHEIGHT);
		
		this.setContentPane(contentPane);
		cd = new CardLayout();
		contentPane.setLayout(cd);
		
		menu = new Menu(this);
		contentPane.add(menu, "menu");
	}
	/**
	 * Méthode permettant d'afficher le menu.
	 */
	public void menu(){
		cd.show(getContentPane(), "menu");
	}
	/**
	 * Renvoie le CardLayout de la fenêtre.
	 * @return CardLayout de base de la frame.
	 */
	public CardLayout getCd() {
		return cd;
	}
}