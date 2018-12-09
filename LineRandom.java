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
	 * Renvoie la case souhait�e.
	 * @param nbCase Le num�ro de la case que l'on veut r�cup�rer.
	 * @return La case demand�e en param�tre.
	 */
	public CaseRandom getCase(int nbCase){
		return tabCasesR[nbCase];
	}
}
