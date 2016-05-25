
public class Battleship {

	public static void main(String[] args) {
		System.out.println("siedzialem nad tym caly dzien");
			
		Board komputer = new Board();
		RandomGenerator.getRandomBoard(komputer, 4, 3, 2, 1);
		
		System.out.println("Wygenerowano plansza komputera");
		komputer.printBoard();
		
		Board gracz = new Board();
		RandomGenerator.getRandomBoard(gracz, 4, 3, 2, 1);
		
		System.out.println("Wygenerowano plansza gracza");
		gracz.printBoard();
		
		Board.startGame();
		
		System.out.println("Plansza gracz");
		gracz.printBoard();
		System.out.println("Plansza komputer");
		komputer.printBoard();
	
		
		while(Boolean.logicalAnd(gracz.isMovePossible(),komputer.isMovePossible())){
			ShootsSupport.generateTextLog(AI.shoot(gracz),"Komputer 1");
			ShootsSupport.generateTextLog(AI.shoot(komputer),"Komputer 2");
		}
		
		System.out.println("Plansza gracz");
		gracz.printBoard();
		System.out.println("Plansza komputer");
		komputer.printBoard();
	}

}
