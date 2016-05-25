
public class Battleship {

	public static void main(String[] args) {
		System.out.println("siedzialem nad tym caly dzien");
		
		AI_randomGenerator generator = new AI_randomGenerator();
		
		Board komputer = new Board();
		generator.getRandomBoard(komputer, 4, 3, 2, 1);
		
		System.out.println("Wygenerowano plansza komputera");
		komputer.printBoard();
		
		Board gracz = new Board();
		generator.getRandomBoard(gracz, 4, 3, 2, 1);
		
		System.out.println("Wygenerowano plansza gracza");
		gracz.printBoard();
		
		Board.startGame();
		
		System.out.println("Plansza gracz");
		gracz.printBoard();
		System.out.println("Plansza komputer");
		komputer.printBoard();
	
		boolean isSuccess;
		while(Boolean.logicalAnd(gracz.isMovePossible(),komputer.isMovePossible())){
			isSuccess = false;
			while(!isSuccess){				
				switch(gracz.shoot(generator.getRandomShoot(), generator.getRandomShoot())){
					case -1: System.out.println("Gracz: b³¹d podczas strzalu, powtarzam strzal: ");
							
															    isSuccess=false; break;
					case 0: System.out.println("Gracz: pud³o.");
															    isSuccess=true;	break;
					case 1: System.out.println("Gracz: trafiony."); 
															    isSuccess=true;	break;
					case 2: System.out.println("Gracz: trafiony i zatopiony."); 
																isSuccess=true;	break;
				}
			}
			isSuccess=false;
			while(!isSuccess){				
				switch(komputer.shoot(generator.getRandomShoot(), generator.getRandomShoot())){
					case -1: System.out.println("Komputer: b³¹d podczas strzalu, powtarzam strzal: ");
														    isSuccess=false; break;
					case 0: System.out.println("Komputer: pud³o.");
														    isSuccess=true;	break;
					case 1: System.out.println("Komputer: trafiony."); 
														    isSuccess=true;	break;
					case 2: System.out.println("Komputer: trafiony i zatopiony."); 
															isSuccess=true;	break;
				}
			}
		}
		
		System.out.println("Plansza gracz");
		gracz.printBoard();
		System.out.println("Plansza komputer");
		komputer.printBoard();
	}

}
