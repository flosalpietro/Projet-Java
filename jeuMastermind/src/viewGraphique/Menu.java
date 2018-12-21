package viewGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Menu principal du jeu.
 * 
 */

public class Menu extends JPanel implements ActionListener, ChangeListener{
	/**
	 * Bouton pour lancer la partie solitaire.
	 */
	private Button btnSolo;
	/**
	 * Bouton pour lancer la partie multijoueur.
	 */
	private Button btnMulti;
	/**
	 * Bouton pour afficher les règles du jeu.
	 */
	private Button btnRules;
	/**
	 * Bouton pour quitter le jeu et fermer l'application.
	 */
	private Button btnQuit;
	/**
	 * JSlider permettant de choisir le nombre de cases.
	 */
	private JSlider sliderNbCases;
	/**
	 * JSlider permettant de choisir le nombres de couleurs.
	 */
	private JSlider sliderNbColors;
	/**
	 * Affiche le nombre de cases
	 */
	private JLabel lblNbCases;
	/**
	 * Afiche le nombre de couleurs 
	 */
	private JLabel lblNbColors;
	/**
	 * Afiche le nombre de cases sélectionnées avec JSlider.
	 */
	private JLabel nbCases;
	/**
	 * Affiche le nombre de couleurs sélectionnées avec JSlider.
	 */
	private JLabel nbColors;
	/**
	 * JPanel affiché en lancant le mode multijoueur.
	 */
	private IntroMulti multi;
	/**
	 * Frame de base de l'application.
	 */
	private MainFrame mf;
	/**
	 * JPanel des règles du jeu.
	 */
	private Rules rules;
	/**
	 * Création du JPanel.
	 * @param mf Fenètre principale de l'application.
	 */
	public Menu(MainFrame mf) {
		this.mf = mf;
		
		this.setLayout(null);
		this.setBounds(0, 0, 900, 700);
		this.setBorder(null);
		
		nbColors = new JLabel("6");
		nbColors.setFont(new Font("Times New Roman", Font.BOLD, 15));
		nbColors.setForeground(Color.RED);
		nbColors.setBounds(714, 554, 46, 14);
		this.add(nbColors);
		
		nbCases = new JLabel("4");
		nbCases.setFont(new Font("Times New Roman", Font.BOLD, 15));
		nbCases.setForeground(Color.RED);
		nbCases.setBounds(188, 545, 54, 32);
		this.add(nbCases);
		
		JLabel title = new JLabel("");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		title.setForeground(new Color(0, 204, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setIcon(new ImageIcon(getClass().getResource("/title.png")));
		title.setBackground(new Color(0, 255, 0));
		title.setBounds(109, 38, 624, 97);
		this.add(title);
		
		
		btnSolo = new Button("solo");
		btnSolo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSolo.addActionListener(this);
		btnSolo.setBounds(109, 166, 276, 109);
		this.add(btnSolo);
		
		btnMulti = new Button("multi");
		btnMulti.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnMulti.addActionListener(this);
		btnMulti.setBounds(461, 166, 276, 109);
		this.add(btnMulti);
		
		btnRules = new Button("rules");
		btnRules.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRules.addActionListener(this);
		btnRules.setBounds(109, 286, 628, 106);
		this.add(btnRules);
		
		btnQuit = new Button("quit");
		btnQuit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnQuit.addActionListener(this);
		btnQuit.setBounds(109, 430, 628, 106);
		this.add(btnQuit);
		
		sliderNbCases = new JSlider();
		sliderNbCases.addChangeListener(this);
		sliderNbCases.setForeground(new Color(255, 255, 255));
		sliderNbCases.setBackground(new Color(255, 255, 255));
		sliderNbCases.setValue(4);
		sliderNbCases.setPaintTicks(true);
		sliderNbCases.setMaximum(6);
		sliderNbCases.setMinimum(4);
		sliderNbCases.setBounds(29, 587, 349, 63);
		this.add(sliderNbCases);
		sliderNbCases.setOpaque(false);
		
		sliderNbColors = new JSlider();
		sliderNbColors.setPaintTicks(true);
		sliderNbColors.addChangeListener(this);
		sliderNbColors.setValue(6);
		sliderNbColors.setMinimum(6);
		sliderNbColors.setMaximum(10);
		sliderNbColors.setBounds(531, 587, 343, 63);
		this.add(sliderNbColors);
		sliderNbColors.setOpaque(false);
		
		lblNbCases = new JLabel("Nombre de cases :");
		lblNbCases.setForeground(new Color(255, 0, 0));
		lblNbCases.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNbCases.setBounds(29, 538, 149, 46);
		this.add(lblNbCases);
		
		lblNbColors = new JLabel("Nombre de couleurs :");
		lblNbColors.setForeground(new Color(255, 0, 0));
		lblNbColors.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNbColors.setBounds(531, 544, 173, 32);
		this.add(lblNbColors);
		
		JLabel background = new JLabel("");
		background.setFont(new Font("Times New Roman", Font.BOLD, 15));
		background.setForeground(Color.RED);
		background.setIcon(new ImageIcon(getClass().getResource("/background.png")));
		background.setBounds(0, 0, Param.FRAMEWIDTH, Param.FRAMEHEIGHT);
		this.add(background);
	}
	/**
	 * Action effectuées quand on appuye sur les boutons.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "solo": 
			Param.NBCASES = Integer.parseInt(nbCases.getText());
			Param.NBCOLORS = Integer.parseInt(nbColors.getText());
			Solo solo=new Solo(mf);
			mf.getContentPane().add(solo, "solo");
			mf.getCd().show(mf.getContentPane(), "solo");
			break;
		case "multi":
			Param.NBCASES = Integer.parseInt(nbCases.getText());
			Param.NBCOLORS = Integer.parseInt(nbColors.getText());
			multi = new IntroMulti(mf);
			mf.getContentPane().add(multi, "multi");
			mf.getCd().show(mf.getContentPane(), "multi");
			break;
		case "rules" :
			rules = new Rules(mf);
			mf.getContentPane().add(rules, "rules");
			mf.getCd().show(mf.getContentPane(), "rules");
			break;
		case "quit" : 
			System.exit(0);
			break;
		default:
			break;
		}
	}

	/**
	 * Actions effectuées quand on change les JSlider.
	 */
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==sliderNbCases){
			this.nbCases.setText(sliderNbCases.getValue()+"");
		}else if(e.getSource()==sliderNbColors){
			nbColors.setText(sliderNbColors.getValue()+"");
		}
	}
}