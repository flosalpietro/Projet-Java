/**
 * 
 */
package model;

/**
 * @author Florence
 *
 */
import model.Param;

public class Results {
	
	/**
	 * Tableau contenant les couleurs des résultats.
	 */
	private String[] results = new String[Param.NBCASES];
	/**
	 * Score de la ligne.
	 */
	private int[] score = { 0, 0};
	
	
	public Results() {
		
		}
		
	
	/**
	 * Modifie les scores obtenus.
	 * @param great Nombre de bonne réponses obtenues.
	 * @param good Nombre de bonne couleurs mises dans la ligne.
	 */
	public void setScore(int great, int good){
		this.score[0]=great;
		this.score[1]=good;
		show();
	}
	/**
	 * Place des + et - en fonction des résultats obtenue.
	 */
	public void show(){
		for(int i=0;i<this.score[0];i++){
			this.results[i] = "+";
			System.out.println(results[i]);
		}
		for(int j=score[0];j<score[1]+score[0];j++){
			this.results[j] = "-";
			System.out.println(results[j]);
		}
	}
	/**
	 * Envoie le nombre de bonnes réponses sur la ligne.
	 * @return Nombre de bonnes réponses.
	 */
	public int getScore(){
		return this.score[0];
	}

}