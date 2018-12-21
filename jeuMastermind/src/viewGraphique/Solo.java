package viewGraphique;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


/**
 * JPanel du mode solitaire.

 */
@SuppressWarnings({ "serial" })
public class Solo extends JPanel implements ActionListener{
	
	private MainFrame mf;
	
	private JLabel rulesLbl;
	
	private Board b;
	
	private JLabel error;
	
	private Button btnMenu;
	
	/**
	 * Création du JPanel Solitaire.
	 * @param mf Fenêtre principale de l'application.
	 */
	public Solo(MainFrame mf) {
		this.setLayout(null);
		this.mf = mf;
		
		b = new Board(mf);
		b.setSolo(this);
		b.setBounds((Param.FRAMEWIDTH/2)-(350/2), 0, 350, Param.FRAMEHEIGHT);
		this.add(b);
		
		
		
		btnMenu = new Button("menu");
		btnMenu.setBounds(Param.FRAMEWIDTH-250, 50, 193, 54);
		btnMenu.addActionListener(this);
		this.add(btnMenu);
		
		error = new JLabel("");
		error.setFont(new Font("Tahoma", Font.BOLD, 15));
		error.setForeground(Color.RED);
		error.setBounds(Param.FRAMEWIDTH-250, 150, 200, 20);
		this.add(error);
		
		Background bg = new Background();
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
	 * Gestion des clics sur les différents boutons.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "menu":
			mf.menu();
			break;
		
		}
	}
}