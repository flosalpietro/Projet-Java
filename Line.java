package jeu2;

public class Line extends Case{
	
	/**
	 * Tableau de cases constituant la ligne.
	 */
	private Case[] tabCases = new Case[Param.NBCASES];
	
	/**
	 * Constructeur de Line 
	 */
	public Line() {
		tabCases[0]= new Case();
		tabCases[1]= new Case();
		tabCases[2]= new Case();
		tabCases[3]= new Case();
	}
		
		/**
		 * Crée une ligne aléatoire de couleurs.
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
		
		/**
		 * Méthode pour vérifier si la ligne est complète.
		 * @return true si la ligne est complète, false si il manque une couleur à la ligne.
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
			
		
		  }
