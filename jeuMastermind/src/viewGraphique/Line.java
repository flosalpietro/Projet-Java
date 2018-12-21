package viewGraphique;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * <p>La classe Line repr�sente une ligne sur le plateau de jeu. Elle est compos� de cases de la classe Case.</p>
 * 
 */
@SuppressWarnings("serial")
public class Line extends JPanel{
	/**
	 * Tableau de cases constituant la ligne.
	 */
	private Case[] tabCases = new Case[Param.NBCASES];
	/**
	 * Constructeur de Line instanciant les cases en les mettant dans un tableau.
	 */
	public Line() {
		for(int i=0;i<Param.NBCASES;i++){
			tabCases[i] = new Case();
			this.add(tabCases[i].getLbl());
		}
		this.setOpaque(true);
		this.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * M�thode qui a pour but de creer une ligne al�atoire de couleurs.
	 */
	public void createRandom(){
		for(int i=0;i<Param.NBCASES;i++){
			tabCases[i].randomColor();
		}
	}
	/**
	 * M�thode pour savoir si la ligne est compl�te.
	 * @return true si la ligne est compl�te, false � l'inverse.
	 */
	public boolean isLineComplete(){
		int complete=0;
		for(int i=0;i<Param.NBCASES;i++){
			if(tabCases[i].getColor()!=0)
				complete++;
		}
		if(complete==Param.NBCASES)return true;
		return false;
	}
	/**
	 * Renvoie la case souhait�e.
	 * @param nbCase Le num�ro de la case que l'on veut r�cup�rer.
	 * @return La case demand�e en param�tre.
	 */
	public Case getCase(int nbCase){
		return tabCases[nbCase];
	}
	/**
	 * Cache ou affiche les couleurs de la ligne concern�e.
	 * @param hide true pour cacher la ligne, false pour l'afficher.
	 */
	public void hide(boolean hide){
		if(hide){
			for(int i=0;i<Param.NBCASES;i++)tabCases[i].hide();
		}else{
			for(int i=0;i<Param.NBCASES;i++)tabCases[i].show();
		}
		
	}
}
