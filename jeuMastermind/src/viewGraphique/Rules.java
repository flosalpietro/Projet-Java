package viewGraphique;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * JPanel contenant les règles du jeu 
 * 
 */
public class Rules extends JPanel implements ActionListener{
	/**
	 * JLabel contenant le texte des règles du jeu.
	 */
	private JLabel rulesLbl;
	/**
	 * Bouton permettant de retourner au menu.
	 */
	private Button btnMenu;
	/**
	 * Fenêtre principale de l'application.
	 */
	private MainFrame mf;
	/**
	 * Création du JPanel.
	 * @param mf Fenêtre principale de l'application.
	 */
	public Rules(MainFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		rulesLbl = new JLabel(Param.RULES);
		rulesLbl.setFont(new Font("Courier New", Font.BOLD, 20));
		rulesLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		rulesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		rulesLbl.setBounds(75, 25, Param.FRAMEWIDTH-150, Param.FRAMEHEIGHT-200);
		rulesLbl.setForeground(Color.WHITE);
		this.add(rulesLbl);
		
		btnMenu = new Button("menu");
		btnMenu.setBounds((Param.FRAMEWIDTH/2)-(193/2), Param.FRAMEHEIGHT-100, 193, 54);
		btnMenu.addActionListener(this);
		this.add(btnMenu);
		
		Background bg = new Background();
		this.add(bg);
	}
	/**
	 * Actions au clic du bouton.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "menu":
			mf.menu();
			break;
			}
			
		}
	}

