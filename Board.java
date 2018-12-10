package jeu2;

import jeu2.Param;

public class Board  {
	
	/**
	 * Tableau des lignes déjà proposées
	 */
	protected Line[] tabLine = new Line[Param.NBLINES];
	
	/**
	 * Ligne de proposition de couleurs 
	 */
	protected Line propLine = new Line();
	
	/**
	 * Booléen servant à savoir si c'est au tour de cette board ci.
	 */
	protected boolean turn = true;
	
	/**
	 * Tableau contenant les résultats des lignes proposées.
	 */

	private Results[] results = new Results[Param.NBLINES];	
	/**
	 * Numéro de la case que l'on va remplir dans propLine au prochain addColor.
	 */
	protected int currProp = 1;
	
	/**
	 * Ligne du résultat final à découvrir.
	 */
	protected Line resultLine = new Line();
	
	/**
	 * Ligne que l'on va proposer à la prochaine validation.
	 */
	protected int currLine = 0;
	
	
	

	public Board() {
		for(int i=0;i<Param.NBLINES;i++){
			results[i] = new Results();
		}
	}
	
	
	/**
	 * Compare la ligne de proposition et la ligne de résultat tout en implémentant les résultats de la ligne correspondante.
	 */
	public void compare(){
		int sameColor=0;
		int same=0;
	
		 boolean isVerifiedResult[] = new boolean[Param.NBCASES]; //Tableau pour savoir si la couleur dans la ligne de résultat à été vérifiée.
	
		 boolean isVerifiedProp[] = new boolean[Param.NBCASES]; //Tableau pour savoir si la couleur dans la ligne de proposition à été vérifiée.
		
		
		for(int i=0;i<Param.NBCASES;i++){
			for(int j=0;j<Param.NBCASES;j++){
				if(i==j&&propLine.getCase(i).getColor()==resultLine.getCase(i).getColor()){
					if(!isVerifiedProp[i] && !isVerifiedResult[i]){
						same++;
						isVerifiedProp[i]=true;
						isVerifiedResult[i]=true;
					}
				}
			}
		} 
		for(int i=0;i<Param.NBCASES;i++){
			for(int j=0;j<Param.NBCASES;j++){
				if(propLine.getCase(i).getColor()==resultLine.getCase(j).getColor()){
					if(!isVerifiedProp[i] && !isVerifiedResult[j]){
						sameColor++;
						isVerifiedProp[i]=true;
						isVerifiedResult[j] = true;
					}
				}
			}
		}
		
		
		results[currLine].setScore(same, sameColor);

	
	}
	
	
	public void win() {
		System.out.println("Félicitation, vous avez trouvé la combinaison secrète ! ");
		System.out.println("La combinaison était : "+ resultLine);
	
	}
	
	public void lose() {
		System.out.println("Game Over, vous n'avez pas trouvé la combinaison secrète ");
		System.out.println("La combinaison était : "+ resultLine);
	
	}
	
	  
	}
	
	
	



	
	
	


