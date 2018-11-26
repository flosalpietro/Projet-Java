package jeu;


import jeu.Param;

public class Line extends Case {
	
	
	private Case[] tabCases = new Case[Param.NBCOLORS];

	
	public Line() {
		for(int i=0;i<Param.NBCASES;i++){
			tabCases[i] = new Case();
		}
	}
		
		/**
		 * Méthode qui a pour but de creer une ligne aléatoire de couleurs.
		 */
		public void createRandom(){
			for(int i=0;i<Param.NBCASES;i++){
				tabCases[i].randomColor();
			}
		}
		
		/**
		 * Renvoie la case souhaitée.
		 * @param nbCase Le numéro de la case que l'on veut récupérer.
		 * @return La case demandée en paramètre.
		 */
		public Case getCase(int nbCase){
			return tabCases[nbCase];
		}
		
		public boolean isLineComplete(){
			int complete=0;
			for(int i=0;i<Param.NBCASES;i++){
				if(tabCases[i].getColor()!=0)complete++;
			}
			if(complete==Param.NBCASES)return true;
			return false;
		}
	
	}
