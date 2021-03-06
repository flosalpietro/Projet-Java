package viewGraphique;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * JPanel des r�sultats des lignes ajout�es.
 */
@SuppressWarnings("serial")
public class Results extends JPanel{ 
	/**
	 * Tableau de JLabels contenant les couleurs des r�sultats.
	 */
	private JLabel[] results = new JLabel[Param.NBCASES];
	/**
	 * Score de la ligne.
	 */
	private int[] score = {0, 0};
	/**
	 * Layout du JPanel.
	 */
	private GridLayout grid = new GridLayout(2, (Param.NBCASES/2)+(Param.NBCASES%2), 1, 1);
	/**
	 * Construit le JPanel.
	 */
	public Results() {
		for(int i=0;i<Param.NBCASES;i++){
			results[i] = new JLabel();
			results[i].setIcon(new ImageIcon(getClass().getResource("/void.png")));
		}
		this.setBorder(new EmptyBorder(10, 0, 9, 0));
		this.setLayout(grid);
		for(int i=0;i<Param.NBCASES;i++){
			this.add(results[i]);
		}
		this.setOpaque(true);
		this.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * Modifie les scores obtenus.
	 * @param great Nombre de bonne r�ponse obtenue.
	 * @param good Nombre de bonne couleur mise dans la ligne.
	 */
	public void setScore(int great, int good){
		score[0]=great;
		score[1]=good;
		show();
	}
	/**
	 * Change les icones selon les r�sultats obtenus.
	 */
	public void show(){
		for(int i=0;i<score[0];i++){
			results[i].setIcon(new ImageIcon(getClass().getResource("/colorPosition.png")));
		}
		for(int j=score[0];j<score[1]+score[0];j++){
			results[j].setIcon(new ImageIcon(getClass().getResource("/color.png")));
		}
	}
	/**
	 * Envoie le nombre de bonnes r�ponses sur la ligne.
	 * @return Nombre de bonnes r�ponses.
	 */
	public int getScore(){
		return score[0];
	}
}
