package jeu2;


public class LineRandom extends CaseRandom{
	
	private CaseRandom[] tabCasesR = new CaseRandom[Param.NBCASES];
	
	/**
	 * Contructeur
	 */
	public LineRandom() {
		this.tabCasesR[0]= new CaseRandom();
		this.tabCasesR[1]= new CaseRandom();
		this.tabCasesR[2]= new CaseRandom();
		this.tabCasesR[3]= new CaseRandom();
	}
	

	
	/**
	 * Renvoie la case souhaitée.
	 * @param nbCase Le numéro de la case que l'on veut récupérer.
	 * @return La case demandée en paramètre.
	 */
	public CaseRandom getCase(int nbCase){
		return tabCasesR[nbCase];
	}
}
