package jeu2;

import java.util.ArrayList;

import jeu2.Param;

public class Board extends Results {
	
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
	//private  Results[] results = new Results[Param.NBLINES];
	//protected ArrayList<Board> results = new ArrayList<Board>(Param.NBLINES); 
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
	/**
	 * Tableau pour savoir si la couleur dans la ligne de résultat à été vérifiée.
	 */
	protected boolean isVerifiedResult[] = new boolean[Param.NBCASES];
	/**
	 * Tableau pour savoir si la couleur dans la ligne de proposition à été vérifiée.
	 */
	protected boolean isVerifiedProp[] = new boolean[Param.NBCASES];
	

	public Board() {
		for(int i=0;i<Param.NBLINES;i++){
			results[i] = new Results();
		}
	}
	
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
		
		
		results[currLine].setScore(same, sameColor);

		//Board r = new Board();
		//r.setScore(same, sameColor);
		//results.add(r);
		//show();
		//System.out.println("**********************");
		//System.out.println(results.size());
		//for (Results g: results) System.out.println(g.getScore());
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
	
	
	


