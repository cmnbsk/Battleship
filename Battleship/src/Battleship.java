
public class Battleship {

	public static void main(String[] args) {
		System.out.println("siedzialem nad tym caly dzien");
		
		Board gracz = new Board();
		
		gracz.addShip(4, 5, 6, 5);
		gracz.addShip(0, 5, 3, 5);
		gracz.addShip(0, 8, 0, 9);
		gracz.printBoard();
		System.out.println();
		
		gracz.shoot(2, 2);
		System.out.println("pud³o");
		System.out.println("trafiony");
		if(gracz.shoot(5,0)==0)
			System.out.println("pud³o");
		gracz.shoot(0, 9);
		if(gracz.shoot(0,8)==2)
			System.out.println("zatopiony");	
		
		gracz.printBoard();
		
//		AI_randomGenerator generator = new AI_randomGenerator();
//		Board komputer = new Board();
//		generator.generateRandomBoard(komputer, 4, 3, 2, 1);
//		komputer.printBoard();
	}

}
