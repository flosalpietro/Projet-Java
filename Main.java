package jeu2;

public class Main {
public  static  void main(String[] args) {
		
		Board b1 = new Board();
		b1.resultLine.createRandom();
		b1.propLine.createRandom();
		
		for (int i=0;i<Param.NBCASES;i++) {
			System.out.println(b1.resultLine.getCase(i).getColor());
		}
		System.out.println("=====================================");
		for (int i=0;i<Param.NBCASES;i++) {
		System.out.println(b1.propLine.getCase(i).getColor());
		}
		System.out.println("==================");
		b1.compare();
		
		
				
	}

}

