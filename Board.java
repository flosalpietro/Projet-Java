package jeu2;

import java.util.ArrayList;

import jeu2.Param;

public class Board {
	
	/**
	 * Tableau des lignes déjà proposées
	 */
	private Line[] tabLine = new Line[Param.NBLINES];
	
	/**
	 * Ligne de proposition de couleurs 
	 */
	private Line propLine = new Line();
	
	/**
	 * Booléen servant à savoir si c'est au tour de cette board ci.
	 */
	private boolean turn = true;
	
	/**
	 * Tableau contenant les résultats des lignes proposées.
	 */
	//private ArrayList Results[] results = new Results[Param.NBLINES];
	private ArrayList<Results> results = new ArrayList<Results>(Param.NBLINES); 
	
	/**
	 * Numéro de la case que l'on va remplir dans propLine au prochain addColor.
	 */
	private int currProp = 1;
	
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
	 * Ajoute la ligne propLine au tableau de lignes proposées en faisant les vérifications nécessaires.
	 */
	public void addLine(){
		
		compare();
		
		for(int i=0;i<Param.NBCASES;i++){
			tabLine[currLine].getCase(i).setColor(propLine.getCase(i).getColor());
			//propLine.getCase(i).setColor(0);
		}
		for(int i=0;i<Param.NBCASES;i++){
			isVerifiedResult[i] = false;
			isVerifiedProp[i] = false;
		}
		currProp=1;
		if(results[currLine].getScore() == Param.NBCASES){
			if(turn){
				win();
			}else{
				lose();
			}
		}
		
		
		if(currLine==Param.NBLINES-1 && (!(results[currLine].getScore() == Param.NBCASES)))lose();
		currLine++;
		
	}
	
	/**
	 * Compare la ligne de proposition et la ligne de résultat tout en implémentant les résultats de la ligne correspondante.
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

		Results r = new Results();
		r.setScore(same, sameColor);
		results.add(r);
		System.out.println("**********************");
		System.out.println(results.size());
	//	results[currLine] = r;
	//	results[currLine].setScore(same, sameColor);
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
