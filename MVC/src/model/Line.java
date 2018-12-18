/**
 * 
 */
package model;

/**
 * @author Florence
 *
 */
import java.util.Scanner;

public class Line {
	
	/**
	 * Tableau de cases constituant la ligne.
	 */
	private Case[] tabCases = new Case[Param.NBCASES];
	
	/**
	 * Constructeur de Line 
	 */
	public Line() {
		for(int i=0;i<Param.NBCASES;i++){
			tabCases[i] = new Case();
		}
		
		
		
	}
	public void Prop() {
		System.out.println("Veuillez entrer votre proposition :");
		Scanner br = new Scanner(System.in); 
		    String  lines = br.nextLine();    
		    		
		    String[] strs = lines.trim().split("(?!^)");
		if(strs.length!=Param.NBCASES) {
			System.out.println("veuillez entrer une combinaison �"+Param.NBCASES+" caracteres");
			Prop();
		} 
		
		try {
		for(int i=0;i<strs.length;i++){
			
			tabCases[i] = new Case(Integer.parseInt(strs[i]));
			}}
		catch(NumberFormatException ex){
				System.out.println("veuillez entrer un chiffre comme caract�re");
			}
		
	} 
	

		/**
		 * Cr�e une ligne al�atoire de couleurs.
		 */
		public void createRandom(){
			for(int i=0;i<Param.NBCASES;i++){
				tabCases[i].randomColor();
			}
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
		 * M�thode pour v�rifier si la ligne est compl�te.
		 * @return true si la ligne est compl�te, false si il manque une couleur � la ligne.
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