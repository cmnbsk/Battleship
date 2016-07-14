
public class Battleship{
	
	static DiagnosticLayout frame;
	static Board board1, board2;
	static Artificial_intelligence ai_first;
	static Artificial_intelligence ai_second;
	static int tura;

	public static void main(String[] args) {
		
		System.out.println("siedzialem nad tym caly dzien");
		
		frame = new DiagnosticLayout();
		
		board1 = new Board("Komputer 1");
		RandomGenerator.getRandomBoard(board1, 4, 3, 2, 1);
//		
//		System.out.println("Wygenerowano plansza komputera");
//		komputer.printBoard();
		
		board2 = new Board("Komputer 2");
		RandomGenerator.getRandomBoard(board2, 4, 3, 2, 1);
//		
//		System.out.println("Wygenerowano plansza gracza");
//		gracz.printBoard();
		
		Board.startGame();
		
		System.out.println("Plansza gracz");
		board1.printBoard();
		System.out.println("Plansza komputer");
		board2.printBoard();
		
		frame.refreshFirstBoard(board1);
		frame.refreshSecondBoard(board2);
		
		ai_first = new Artificial_intelligence();
		ai_second = new Artificial_intelligence();
		
		tura = 1;
		frame.setRound(tura);
//		while(Boolean.logicalAnd(gracz.isMovePossible(),komputer.isMovePossible())){
//			frame.nextRound();
//			ShootsSupport.generateTextLog(ai_first.shoot(board1),"Komputer 1");
//			frame.refreshFirstBoard(board1);
//			frame.nextRound();
//			ShootsSupport.generateTextLog(ai_second.shoot(board2),"Komputer 2");
//			frame.refreshSecondBoard(board2);
//		}
		
//		System.out.println("Plansza gracz");
//		board1.printBoard();
//		System.out.println("Plansza komputer");
//		board2.printBoard();
	}
	
	static void nextRound(){
		if(tura == 1)
			tura = 2;
		else tura = 1;
	}
	static int getRound(){
		if(tura==1)
			return 1;
		else return 2;
	}
	
	static boolean aiRound(Board board, Artificial_intelligence ai){
		if(board.isMovePossible()){
			ShootsSupport.generateTextLog(ai.shoot(board),board.getName());
		}else{
			board.getName();
			System.out.println(board.getName()+ ": brak ruchów!");
			frame.nextRound();
			nextRound();
			return false;
		}
		if(getRound()==1){
			frame.refreshFirstBoard(board);
			if(!board.isAnyShip()){
				System.out.println("Koniec gry, wygrywa gracz 1!");
				frame.shoot.setEnabled(false);
			}
		}else{
			frame.refreshSecondBoard(board);
			if(!board.isAnyShip()){
				System.out.println("Koniec gry, wygrywa gracz 2!");
				frame.shoot.setEnabled(false);
			}
		}
		frame.nextRound();
		nextRound();
		return true;
	}
	
	public static void nextAiRound() {
		if(getRound()==1)
			while(!aiRound(board1, ai_first));
		else while(!aiRound(board2, ai_second));
	}
}
