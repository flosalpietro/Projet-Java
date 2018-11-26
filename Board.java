package jeu;


import jeu.Line;
import jeu.Param;

public class Board {
	
	/**
	 * Tableau des lignes déjà proposées
	 */
	private Line[] tabLine = new Line[Param.NBLINES];
	
	/**
	 * Ligne de proposition de couleurs contenant également la validation de cette ligne et le reset
	 */
	private Line propLine = new Line();
	
	/**
	 * Tableau contenant les résultats des lignes proposées.
	 */
	private Results[] results = new Results[Param.NBLINES];
	
	/**
	 * Ligne du résultat final à découvrir.
	 */
	private Line resultLine = new Line();
	
	/**
	 * Ligne que l'on va proposer à la prochaine validation.
	 */
	private int currLine = 0;
	/**
	 * Tableau pour savoir si la couleur dans la ligne de résultat à été vérifiée.
	 */
	private boolean isVerifiedResult[] = new boolean[Param.NBCASES];
	/**
	 * Tableau pour savoir si la couleur dans la ligne de proposition à été vérifiée.
	 */
	private boolean isVerifiedProp[] = new boolean[Param.NBCASES];
	
	
	/**
	 * Compare la ligne de proposition et la ligne de résultat tout  en implémentant les résultats de la ligne correspondante.
	 */
	public void compare(){
		int sameColor=0;
		int same=0;
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
  
  
}
