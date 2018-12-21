package viewGraphique;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 * La classe Case représente une case sur le plateau de jeu.</p>
 * 
 */
public class Case {
	/**
	 * Couleur de la case.
	 */
	private int color;
	/**
	 * Label contenant l'image de la couleur.
	 */
	private JLabel lbl = new JLabel();
	/**
	 * Icone prévu pour cacher la case.
	 */
	private ImageIcon hideIcon = new ImageIcon(getClass().getResource("/11.png"));
	/**
	 * Icone de la couleur de la case.
	 */
	private ImageIcon img;
	/**
	 * Constructeur d'une case sans argument. Construit une case vide.
	 */
	public Case() {
		this.color=0;
		show();
		lbl.setBorder(new EmptyBorder(Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS));
	}
	/**
	 * Constructeur d'une case avec la couleur "numColor".
	 * @param numColor Couleur de la case.
	 */
	public Case(int numColor) {
		this.color = numColor;
		show();
		lbl.setBorder(new EmptyBorder(Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS));
	}
	/**
	 * Choisit une couleur aléatoire pour la case.
	 */
	public void randomColor(){
		int min = 1;
		int max=Param.NBCOLORS;
		int random;
		random = min + (int)(Math.random() * ((max - min) + 1));
		this.color = random;
		this.show();
	}
	/**
	 * Change l'icone de la case en la couleur "color" de la classe.
	 */
	public void show(){
		this.img = new ImageIcon(getClass().getResource("/"+this.color+".png"));
		lbl.setIcon(img);
	}
	/**
	 * Cache la case en mettant une icone "vide".
	 */
	public void hide(){
		lbl.setIcon(hideIcon);
	}
	/**
	 * Renvoie true si la case est vide.
	 * @return True si la case est vide, false si la case est assignée à une couleur.
	 */
	public boolean isEmpty(){
		if(this.color==0)return true;
		return false;
	}
	/**
	 * Renvoie la couleur de la classe.
	 * @return La couleur de la classe.
	 */
	public int getColor(){
		return this.color;
	}
	/**
	 * Renvoie le label de la case.
	 * @return Le label de la case.
	 */
	public JLabel getLbl(){
		return lbl;
	}
	/**
	 * Change la couleur de la case en la couleur passée en paramètre.
	 * @param numColor Numéro de la couleur voulue.
	 */
	public void setColor(int numColor){
		this.color = numColor;
		this.show();
	}

}
