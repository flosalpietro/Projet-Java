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
	//private  Results[] results = new Results[Param.NBLINES];
	//protected ArrayList<Board> results = new ArrayList<Board>(Param.NBLINES); 
	protected Results[] results = new Results[Param.NBLINES];	
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
	protected  int currLine = 0;
	
	private boolean isVerifiedResult[] = new boolean[Param.NBCASES];
	
	private boolean isVerifiedProp[] = new boolean[Param.NBCASES];
	
	
	
	

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
		tabLine[currLine] = new Line();
		for(int i=0;i<Param.NBCASES;i++){
			//tabLine[currLine] = new Line();
			tabLine[currLine].getCase(i).setColor(propLine.getCase(i).getColor());
			//propLine.getCase(i).setColor(0);
		}
		for(int i=0;i<Param.NBCASES;i++){
			isVerifiedResult[i] = false;
			isVerifiedProp[i] = false;
		}
		
		if(currLine==Param.NBLINES-1 && (!(results[currLine].getScore() == Param.NBCASES))) {
			lose();
		
	}
		currLine++;
		
		
		
	} 
	
	
	public void previous_Prop() {
		for(int j=0;j<currLine;j++) {
			System.out.print("Proposition "+(j+1)+": ");
		for (int i=0;i<Param.NBCASES;i++) {
			System.out.print(tabLine[j].getCase(i).getColor());
			}
		System.out.println();
		}
	}
	
	/**
	 * Compare la ligne de proposition et la ligne de résultat tout en implémentant les résultats de la ligne correspondante.
	 */
	public void compare(){
		int sameColor=0;
		int same=0;
	
		 //boolean isVerifiedResult[] = new boolean[Param.NBCASES]; //Tableau pour savoir si la couleur dans la ligne de résultat à été vérifiée.
	
		 //boolean isVerifiedProp[] = new boolean[Param.NBCASES]; //Tableau pour savoir si la couleur dans la ligne de proposition à été vérifiée.
		
		
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
	
	public  void show_code() {
		for (int i=0;i<Param.NBCASES;i++) {
			System.out.print(resultLine.getCase(i).getColor());
	}
	}
	
	
	public void win() {
		System.out.println("Félicitation, vous avez trouvé la combinaison secrète ! ");
		
	
	}
	
	public  void lose() {
		System.out.println("Game Over, vous n'avez pas trouvé la combinaison secrète ");
		System.out.println("voici le code qu'il fallait trouver:");
		show_code();
		System.out.println("");
	
	}
	
	  
	}
	
	
	



